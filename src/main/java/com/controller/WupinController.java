
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 物品交换
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wupin")
public class WupinController {
    private static final Logger logger = LoggerFactory.getLogger(WupinController.class);

    private static final String TABLE_NAME = "wupin";

    @Autowired
    private WupinService wupinService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BangfuduixiangService bangfuduixiangService;//帮扶对象
    @Autowired
    private BangfushenqingService bangfushenqingService;//帮扶申请
    @Autowired
    private DanganService danganService;//档案
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private JuankuanxiangmService juankuanxiangmService;//捐款项目
    @Autowired
    private JuankuanxiangmLiuyanService juankuanxiangmLiuyanService;//捐款项目留言
    @Autowired
    private NewsService newsService;//社区公告
    @Autowired
    private WupinCollectionService wupinCollectionService;//物品收藏
    @Autowired
    private WupinLiuyanService wupinLiuyanService;//物品留言
    @Autowired
    private WupinYuyueService wupinYuyueService;//申请交换
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private ZhiyuanzheService zhiyuanzheService;//志愿者
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("志愿者".equals(role))
            params.put("zhiyuanzheId",request.getSession().getAttribute("userId"));
        params.put("wupinDeleteStart",1);params.put("wupinDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = wupinService.queryPage(params);

        //字典表数据转换
        List<WupinView> list =(List<WupinView>)page.getList();
        for(WupinView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WupinEntity wupin = wupinService.selectById(id);
        if(wupin !=null){
            //entity转view
            WupinView view = new WupinView();
            BeanUtils.copyProperties( wupin , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(wupin.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody WupinEntity wupin, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wupin:{}",this.getClass().getName(),wupin.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            wupin.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WupinEntity> queryWrapper = new EntityWrapper<WupinEntity>()
            .eq("wupin_name", wupin.getWupinName())
            .eq("wupin_types", wupin.getWupinTypes())
            .eq("wupin_xuqiu", wupin.getWupinXuqiu())
            .eq("yonghu_id", wupin.getYonghuId())
            .eq("wupin_delete", wupin.getWupinDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WupinEntity wupinEntity = wupinService.selectOne(queryWrapper);
        if(wupinEntity==null){
            wupin.setWupinDelete(1);
            wupin.setInsertTime(new Date());
            wupin.setCreateTime(new Date());
            wupinService.insert(wupin);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WupinEntity wupin, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wupin:{}",this.getClass().getName(),wupin.toString());
        WupinEntity oldWupinEntity = wupinService.selectById(wupin.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            wupin.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(wupin.getWupinPhoto()) || "null".equals(wupin.getWupinPhoto())){
                wupin.setWupinPhoto(null);
        }

            wupinService.updateById(wupin);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WupinEntity> oldWupinList =wupinService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<WupinEntity> list = new ArrayList<>();
        for(Integer id:ids){
            WupinEntity wupinEntity = new WupinEntity();
            wupinEntity.setId(id);
            wupinEntity.setWupinDelete(2);
            list.add(wupinEntity);
        }
        if(list != null && list.size() >0){
            wupinService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<WupinEntity> wupinList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            WupinEntity wupinEntity = new WupinEntity();
//                            wupinEntity.setWupinName(data.get(0));                    //物品名称 要改的
//                            wupinEntity.setWupinPhoto("");//详情和图片
//                            wupinEntity.setWupinTypes(Integer.valueOf(data.get(0)));   //物品类型 要改的
//                            wupinEntity.setWupinXuqiu(data.get(0));                    //交换需求 要改的
//                            wupinEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wupinEntity.setWupinContent("");//详情和图片
//                            wupinEntity.setWupinDelete(1);//逻辑删除字段
//                            wupinEntity.setInsertTime(date);//时间
//                            wupinEntity.setCreateTime(date);//时间
                            wupinList.add(wupinEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        wupinService.insertBatch(wupinList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }



    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<WupinView> returnWupinViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = wupinCollectionService.queryPage(params1);
        List<WupinCollectionView> collectionViewsList =(List<WupinCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(WupinCollectionView collectionView:collectionViewsList){
            Integer wupinTypes = collectionView.getWupinTypes();
            if(typeMap.containsKey(wupinTypes)){
                typeMap.put(wupinTypes,typeMap.get(wupinTypes)+1);
            }else{
                typeMap.put(wupinTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("wupinTypes",type);
            PageUtils pageUtils1 = wupinService.queryPage(params2);
            List<WupinView> wupinViewList =(List<WupinView>)pageUtils1.getList();
            returnWupinViewList.addAll(wupinViewList);
            if(returnWupinViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = wupinService.queryPage(params);
        if(returnWupinViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnWupinViewList.size();//要添加的数量
            List<WupinView> wupinViewList =(List<WupinView>)page.getList();
            for(WupinView wupinView:wupinViewList){
                Boolean addFlag = true;
                for(WupinView returnWupinView:returnWupinViewList){
                    if(returnWupinView.getId().intValue() ==wupinView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnWupinViewList.add(wupinView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnWupinViewList = returnWupinViewList.subList(0, limit);
        }

        for(WupinView c:returnWupinViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnWupinViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wupinService.queryPage(params);

        //字典表数据转换
        List<WupinView> list =(List<WupinView>)page.getList();
        for(WupinView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WupinEntity wupin = wupinService.selectById(id);
            if(wupin !=null){


                //entity转view
                WupinView view = new WupinView();
                BeanUtils.copyProperties( wupin , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(wupin.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody WupinEntity wupin, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wupin:{}",this.getClass().getName(),wupin.toString());
        Wrapper<WupinEntity> queryWrapper = new EntityWrapper<WupinEntity>()
            .eq("wupin_name", wupin.getWupinName())
            .eq("wupin_types", wupin.getWupinTypes())
            .eq("wupin_xuqiu", wupin.getWupinXuqiu())
            .eq("yonghu_id", wupin.getYonghuId())
            .eq("wupin_delete", wupin.getWupinDelete())
//            .notIn("wupin_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WupinEntity wupinEntity = wupinService.selectOne(queryWrapper);
        if(wupinEntity==null){
            wupin.setWupinDelete(1);
            wupin.setInsertTime(new Date());
            wupin.setCreateTime(new Date());
        wupinService.insert(wupin);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

