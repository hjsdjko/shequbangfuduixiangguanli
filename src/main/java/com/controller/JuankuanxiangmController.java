
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
 * 捐款项目
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/juankuanxiangm")
public class JuankuanxiangmController {
    private static final Logger logger = LoggerFactory.getLogger(JuankuanxiangmController.class);

    private static final String TABLE_NAME = "juankuanxiangm";

    @Autowired
    private JuankuanxiangmService juankuanxiangmService;


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
        params.put("juankuanxiangmDeleteStart",1);params.put("juankuanxiangmDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = juankuanxiangmService.queryPage(params);

        //字典表数据转换
        List<JuankuanxiangmView> list =(List<JuankuanxiangmView>)page.getList();
        for(JuankuanxiangmView c:list){
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
        JuankuanxiangmEntity juankuanxiangm = juankuanxiangmService.selectById(id);
        if(juankuanxiangm !=null){
            //entity转view
            JuankuanxiangmView view = new JuankuanxiangmView();
            BeanUtils.copyProperties( juankuanxiangm , view );//把实体数据重构到view中
            //级联表 志愿者
            //级联表
            ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(juankuanxiangm.getZhiyuanzheId());
            if(zhiyuanzhe != null){
            BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "zhiyuanzheId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setZhiyuanzheId(zhiyuanzhe.getId());
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
    public R save(@RequestBody JuankuanxiangmEntity juankuanxiangm, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,juankuanxiangm:{}",this.getClass().getName(),juankuanxiangm.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("志愿者".equals(role))
            juankuanxiangm.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JuankuanxiangmEntity> queryWrapper = new EntityWrapper<JuankuanxiangmEntity>()
            .eq("juankuanxiangm_name", juankuanxiangm.getJuankuanxiangmName())
            .eq("zhiyuanzhe_id", juankuanxiangm.getZhiyuanzheId())
            .eq("juankuanxiangm_types", juankuanxiangm.getJuankuanxiangmTypes())
            .eq("juankuanxiangm_xuqiu", juankuanxiangm.getJuankuanxiangmXuqiu())
            .eq("juankuanxiangm_qudao", juankuanxiangm.getJuankuanxiangmQudao())
            .in("juankuanxiangm_yesno_types", new Integer[]{1,2})
            .eq("juankuanxiangm_delete", juankuanxiangm.getJuankuanxiangmDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JuankuanxiangmEntity juankuanxiangmEntity = juankuanxiangmService.selectOne(queryWrapper);
        if(juankuanxiangmEntity==null){
            juankuanxiangm.setJuankuanxiangmYesnoTypes(1);
            juankuanxiangm.setJuankuanxiangmDelete(1);
            juankuanxiangm.setInsertTime(new Date());
            juankuanxiangm.setCreateTime(new Date());
            juankuanxiangmService.insert(juankuanxiangm);
            return R.ok();
        }else {
            if(juankuanxiangmEntity.getJuankuanxiangmYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(juankuanxiangmEntity.getJuankuanxiangmYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JuankuanxiangmEntity juankuanxiangm, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,juankuanxiangm:{}",this.getClass().getName(),juankuanxiangm.toString());
        JuankuanxiangmEntity oldJuankuanxiangmEntity = juankuanxiangmService.selectById(juankuanxiangm.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("志愿者".equals(role))
//            juankuanxiangm.setZhiyuanzheId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(juankuanxiangm.getJuankuanxiangmPhoto()) || "null".equals(juankuanxiangm.getJuankuanxiangmPhoto())){
                juankuanxiangm.setJuankuanxiangmPhoto(null);
        }

            juankuanxiangmService.updateById(juankuanxiangm);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody JuankuanxiangmEntity juankuanxiangmEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,juankuanxiangmEntity:{}",this.getClass().getName(),juankuanxiangmEntity.toString());

        JuankuanxiangmEntity oldJuankuanxiangm = juankuanxiangmService.selectById(juankuanxiangmEntity.getId());//查询原先数据

//        if(juankuanxiangmEntity.getJuankuanxiangmYesnoTypes() == 2){//通过
//            juankuanxiangmEntity.setJuankuanxiangmTypes();
//        }else if(juankuanxiangmEntity.getJuankuanxiangmYesnoTypes() == 3){//拒绝
//            juankuanxiangmEntity.setJuankuanxiangmTypes();
//        }
        juankuanxiangmService.updateById(juankuanxiangmEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JuankuanxiangmEntity> oldJuankuanxiangmList =juankuanxiangmService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JuankuanxiangmEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JuankuanxiangmEntity juankuanxiangmEntity = new JuankuanxiangmEntity();
            juankuanxiangmEntity.setId(id);
            juankuanxiangmEntity.setJuankuanxiangmDelete(2);
            list.add(juankuanxiangmEntity);
        }
        if(list != null && list.size() >0){
            juankuanxiangmService.updateBatchById(list);
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
            List<JuankuanxiangmEntity> juankuanxiangmList = new ArrayList<>();//上传的东西
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
                            JuankuanxiangmEntity juankuanxiangmEntity = new JuankuanxiangmEntity();
//                            juankuanxiangmEntity.setJuankuanxiangmName(data.get(0));                    //项目名称 要改的
//                            juankuanxiangmEntity.setJuankuanxiangmPhoto("");//详情和图片
//                            juankuanxiangmEntity.setZhiyuanzheId(Integer.valueOf(data.get(0)));   //志愿者 要改的
//                            juankuanxiangmEntity.setJuankuanxiangmTypes(Integer.valueOf(data.get(0)));   //项目类型 要改的
//                            juankuanxiangmEntity.setJuankuanxiangmXuqiu(Integer.valueOf(data.get(0)));   //捐款数值 要改的
//                            juankuanxiangmEntity.setJuankuanxiangmQudao(data.get(0));                    //捐款渠道 要改的
//                            juankuanxiangmEntity.setJuankuanxiangmContent("");//详情和图片
//                            juankuanxiangmEntity.setJuankuanxiangmYesnoTypes(Integer.valueOf(data.get(0)));   //项目审核 要改的
//                            juankuanxiangmEntity.setJuankuanxiangmYesnoText(data.get(0));                    //审核回复 要改的
//                            juankuanxiangmEntity.setJuankuanxiangmDelete(1);//逻辑删除字段
//                            juankuanxiangmEntity.setInsertTime(date);//时间
//                            juankuanxiangmEntity.setCreateTime(date);//时间
                            juankuanxiangmList.add(juankuanxiangmEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        juankuanxiangmService.insertBatch(juankuanxiangmList);
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
        PageUtils page = juankuanxiangmService.queryPage(params);

        //字典表数据转换
        List<JuankuanxiangmView> list =(List<JuankuanxiangmView>)page.getList();
        for(JuankuanxiangmView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JuankuanxiangmEntity juankuanxiangm = juankuanxiangmService.selectById(id);
            if(juankuanxiangm !=null){


                //entity转view
                JuankuanxiangmView view = new JuankuanxiangmView();
                BeanUtils.copyProperties( juankuanxiangm , view );//把实体数据重构到view中

                //级联表
                    ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(juankuanxiangm.getZhiyuanzheId());
                if(zhiyuanzhe != null){
                    BeanUtils.copyProperties( zhiyuanzhe , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setZhiyuanzheId(zhiyuanzhe.getId());
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
    public R add(@RequestBody JuankuanxiangmEntity juankuanxiangm, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,juankuanxiangm:{}",this.getClass().getName(),juankuanxiangm.toString());
        Wrapper<JuankuanxiangmEntity> queryWrapper = new EntityWrapper<JuankuanxiangmEntity>()
            .eq("juankuanxiangm_name", juankuanxiangm.getJuankuanxiangmName())
            .eq("zhiyuanzhe_id", juankuanxiangm.getZhiyuanzheId())
            .eq("juankuanxiangm_types", juankuanxiangm.getJuankuanxiangmTypes())
            .eq("juankuanxiangm_xuqiu", juankuanxiangm.getJuankuanxiangmXuqiu())
            .eq("juankuanxiangm_qudao", juankuanxiangm.getJuankuanxiangmQudao())
            .in("juankuanxiangm_yesno_types", new Integer[]{1,2})
            .eq("juankuanxiangm_yesno_text", juankuanxiangm.getJuankuanxiangmYesnoText())
            .eq("juankuanxiangm_delete", juankuanxiangm.getJuankuanxiangmDelete())
//            .notIn("juankuanxiangm_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JuankuanxiangmEntity juankuanxiangmEntity = juankuanxiangmService.selectOne(queryWrapper);
        if(juankuanxiangmEntity==null){
            juankuanxiangm.setJuankuanxiangmYesnoTypes(1);
            juankuanxiangm.setJuankuanxiangmDelete(1);
            juankuanxiangm.setInsertTime(new Date());
            juankuanxiangm.setCreateTime(new Date());
        juankuanxiangmService.insert(juankuanxiangm);

            return R.ok();
        }else {
            if(juankuanxiangmEntity.getJuankuanxiangmYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(juankuanxiangmEntity.getJuankuanxiangmYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

