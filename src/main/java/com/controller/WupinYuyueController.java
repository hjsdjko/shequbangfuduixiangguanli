
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
 * 申请交换
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wupinYuyue")
public class WupinYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(WupinYuyueController.class);

    private static final String TABLE_NAME = "wupinYuyue";

    @Autowired
    private WupinYuyueService wupinYuyueService;


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
    private WupinService wupinService;//物品交换
    @Autowired
    private WupinCollectionService wupinCollectionService;//物品收藏
    @Autowired
    private WupinLiuyanService wupinLiuyanService;//物品留言
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
        CommonUtil.checkMap(params);
        PageUtils page = wupinYuyueService.queryPage(params);

        //字典表数据转换
        List<WupinYuyueView> list =(List<WupinYuyueView>)page.getList();
        for(WupinYuyueView c:list){
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
        WupinYuyueEntity wupinYuyue = wupinYuyueService.selectById(id);
        if(wupinYuyue !=null){
            //entity转view
            WupinYuyueView view = new WupinYuyueView();
            BeanUtils.copyProperties( wupinYuyue , view );//把实体数据重构到view中
            //级联表 物品交换
            //级联表
            WupinEntity wupin = wupinService.selectById(wupinYuyue.getWupinId());
            if(wupin != null){
            BeanUtils.copyProperties( wupin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setWupinId(wupin.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(wupinYuyue.getYonghuId());
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
    public R save(@RequestBody WupinYuyueEntity wupinYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wupinYuyue:{}",this.getClass().getName(),wupinYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            wupinYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<WupinYuyueEntity> queryWrapper = new EntityWrapper<WupinYuyueEntity>()
            .eq("wupin_id", wupinYuyue.getWupinId())
            .eq("yonghu_id", wupinYuyue.getYonghuId())
            .in("wupin_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WupinYuyueEntity wupinYuyueEntity = wupinYuyueService.selectOne(queryWrapper);
        if(wupinYuyueEntity==null){
            wupinYuyue.setWupinYuyueYesnoTypes(1);
            wupinYuyue.setInsertTime(new Date());
            wupinYuyue.setCreateTime(new Date());
            wupinYuyueService.insert(wupinYuyue);
            return R.ok();
        }else {
            if(wupinYuyueEntity.getWupinYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(wupinYuyueEntity.getWupinYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WupinYuyueEntity wupinYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,wupinYuyue:{}",this.getClass().getName(),wupinYuyue.toString());
        WupinYuyueEntity oldWupinYuyueEntity = wupinYuyueService.selectById(wupinYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            wupinYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            wupinYuyueService.updateById(wupinYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody WupinYuyueEntity wupinYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,wupinYuyueEntity:{}",this.getClass().getName(),wupinYuyueEntity.toString());

        WupinYuyueEntity oldWupinYuyue = wupinYuyueService.selectById(wupinYuyueEntity.getId());//查询原先数据

//        if(wupinYuyueEntity.getWupinYuyueYesnoTypes() == 2){//通过
//            wupinYuyueEntity.setWupinYuyueTypes();
//        }else if(wupinYuyueEntity.getWupinYuyueYesnoTypes() == 3){//拒绝
//            wupinYuyueEntity.setWupinYuyueTypes();
//        }
        wupinYuyueService.updateById(wupinYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<WupinYuyueEntity> oldWupinYuyueList =wupinYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        wupinYuyueService.deleteBatchIds(Arrays.asList(ids));

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
            List<WupinYuyueEntity> wupinYuyueList = new ArrayList<>();//上传的东西
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
                            WupinYuyueEntity wupinYuyueEntity = new WupinYuyueEntity();
//                            wupinYuyueEntity.setWupinId(Integer.valueOf(data.get(0)));   //物品 要改的
//                            wupinYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            wupinYuyueEntity.setWupinYuyueText(data.get(0));                    //交换物品详情 要改的
//                            wupinYuyueEntity.setWupinYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //交换状态 要改的
//                            wupinYuyueEntity.setWupinYuyueYesnoText(data.get(0));                    //回复 要改的
//                            wupinYuyueEntity.setInsertTime(date);//时间
//                            wupinYuyueEntity.setCreateTime(date);//时间
                            wupinYuyueList.add(wupinYuyueEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        wupinYuyueService.insertBatch(wupinYuyueList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = wupinYuyueService.queryPage(params);

        //字典表数据转换
        List<WupinYuyueView> list =(List<WupinYuyueView>)page.getList();
        for(WupinYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        WupinYuyueEntity wupinYuyue = wupinYuyueService.selectById(id);
            if(wupinYuyue !=null){


                //entity转view
                WupinYuyueView view = new WupinYuyueView();
                BeanUtils.copyProperties( wupinYuyue , view );//把实体数据重构到view中

                //级联表
                    WupinEntity wupin = wupinService.selectById(wupinYuyue.getWupinId());
                if(wupin != null){
                    BeanUtils.copyProperties( wupin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setWupinId(wupin.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(wupinYuyue.getYonghuId());
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
    public R add(@RequestBody WupinYuyueEntity wupinYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,wupinYuyue:{}",this.getClass().getName(),wupinYuyue.toString());
        Wrapper<WupinYuyueEntity> queryWrapper = new EntityWrapper<WupinYuyueEntity>()
            .eq("wupin_id", wupinYuyue.getWupinId())
            .eq("yonghu_id", wupinYuyue.getYonghuId())
            .eq("wupin_yuyue_text", wupinYuyue.getWupinYuyueText())
            .in("wupin_yuyue_yesno_types", new Integer[]{1,2})
            .eq("wupin_yuyue_yesno_text", wupinYuyue.getWupinYuyueYesnoText())
//            .notIn("wupin_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WupinYuyueEntity wupinYuyueEntity = wupinYuyueService.selectOne(queryWrapper);
        if(wupinYuyueEntity==null){
            wupinYuyue.setWupinYuyueYesnoTypes(1);
            wupinYuyue.setInsertTime(new Date());
            wupinYuyue.setCreateTime(new Date());
        wupinYuyueService.insert(wupinYuyue);

            return R.ok();
        }else {
            if(wupinYuyueEntity.getWupinYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(wupinYuyueEntity.getWupinYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

