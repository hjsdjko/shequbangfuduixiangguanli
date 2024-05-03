
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
 * 志愿者
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhiyuanzhe")
public class ZhiyuanzheController {
    private static final Logger logger = LoggerFactory.getLogger(ZhiyuanzheController.class);

    private static final String TABLE_NAME = "zhiyuanzhe";

    @Autowired
    private ZhiyuanzheService zhiyuanzheService;


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
    private WupinYuyueService wupinYuyueService;//申请交换
    @Autowired
    private YonghuService yonghuService;//用户
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
        PageUtils page = zhiyuanzheService.queryPage(params);

        //字典表数据转换
        List<ZhiyuanzheView> list =(List<ZhiyuanzheView>)page.getList();
        for(ZhiyuanzheView c:list){
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
        ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(id);
        if(zhiyuanzhe !=null){
            //entity转view
            ZhiyuanzheView view = new ZhiyuanzheView();
            BeanUtils.copyProperties( zhiyuanzhe , view );//把实体数据重构到view中
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
    public R save(@RequestBody ZhiyuanzheEntity zhiyuanzhe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhiyuanzhe:{}",this.getClass().getName(),zhiyuanzhe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ZhiyuanzheEntity> queryWrapper = new EntityWrapper<ZhiyuanzheEntity>()
            .eq("username", zhiyuanzhe.getUsername())
            .or()
            .eq("zhiyuanzhe_phone", zhiyuanzhe.getZhiyuanzhePhone())
            .or()
            .eq("zhiyuanzhe_id_number", zhiyuanzhe.getZhiyuanzheIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiyuanzheEntity zhiyuanzheEntity = zhiyuanzheService.selectOne(queryWrapper);
        if(zhiyuanzheEntity==null){
            zhiyuanzhe.setCreateTime(new Date());
            zhiyuanzhe.setPassword("123456");
            zhiyuanzheService.insert(zhiyuanzhe);
            return R.ok();
        }else {
            return R.error(511,"账户或者志愿者手机号或者志愿者身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiyuanzheEntity zhiyuanzhe, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,zhiyuanzhe:{}",this.getClass().getName(),zhiyuanzhe.toString());
        ZhiyuanzheEntity oldZhiyuanzheEntity = zhiyuanzheService.selectById(zhiyuanzhe.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(zhiyuanzhe.getZhiyuanzhePhoto()) || "null".equals(zhiyuanzhe.getZhiyuanzhePhoto())){
                zhiyuanzhe.setZhiyuanzhePhoto(null);
        }

            zhiyuanzheService.updateById(zhiyuanzhe);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ZhiyuanzheEntity> oldZhiyuanzheList =zhiyuanzheService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        zhiyuanzheService.deleteBatchIds(Arrays.asList(ids));

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
            List<ZhiyuanzheEntity> zhiyuanzheList = new ArrayList<>();//上传的东西
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
                            ZhiyuanzheEntity zhiyuanzheEntity = new ZhiyuanzheEntity();
//                            zhiyuanzheEntity.setUsername(data.get(0));                    //账户 要改的
//                            //zhiyuanzheEntity.setPassword("123456");//密码
//                            zhiyuanzheEntity.setZhiyuanzheName(data.get(0));                    //志愿者姓名 要改的
//                            zhiyuanzheEntity.setZhiyuanzhePhone(data.get(0));                    //志愿者手机号 要改的
//                            zhiyuanzheEntity.setZhiyuanzheIdNumber(data.get(0));                    //志愿者身份证号 要改的
//                            zhiyuanzheEntity.setZhiyuanzhePhoto("");//详情和图片
//                            zhiyuanzheEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            zhiyuanzheEntity.setZhiyuanzheEmail(data.get(0));                    //志愿者邮箱 要改的
//                            zhiyuanzheEntity.setCreateTime(date);//时间
                            zhiyuanzheList.add(zhiyuanzheEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //志愿者手机号
                                if(seachFields.containsKey("zhiyuanzhePhone")){
                                    List<String> zhiyuanzhePhone = seachFields.get("zhiyuanzhePhone");
                                    zhiyuanzhePhone.add(data.get(0));//要改的
                                }else{
                                    List<String> zhiyuanzhePhone = new ArrayList<>();
                                    zhiyuanzhePhone.add(data.get(0));//要改的
                                    seachFields.put("zhiyuanzhePhone",zhiyuanzhePhone);
                                }
                                //志愿者身份证号
                                if(seachFields.containsKey("zhiyuanzheIdNumber")){
                                    List<String> zhiyuanzheIdNumber = seachFields.get("zhiyuanzheIdNumber");
                                    zhiyuanzheIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhiyuanzheIdNumber = new ArrayList<>();
                                    zhiyuanzheIdNumber.add(data.get(0));//要改的
                                    seachFields.put("zhiyuanzheIdNumber",zhiyuanzheIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<ZhiyuanzheEntity> zhiyuanzheEntities_username = zhiyuanzheService.selectList(new EntityWrapper<ZhiyuanzheEntity>().in("username", seachFields.get("username")));
                        if(zhiyuanzheEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiyuanzheEntity s:zhiyuanzheEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //志愿者手机号
                        List<ZhiyuanzheEntity> zhiyuanzheEntities_zhiyuanzhePhone = zhiyuanzheService.selectList(new EntityWrapper<ZhiyuanzheEntity>().in("zhiyuanzhe_phone", seachFields.get("zhiyuanzhePhone")));
                        if(zhiyuanzheEntities_zhiyuanzhePhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiyuanzheEntity s:zhiyuanzheEntities_zhiyuanzhePhone){
                                repeatFields.add(s.getZhiyuanzhePhone());
                            }
                            return R.error(511,"数据库的该表中的 [志愿者手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //志愿者身份证号
                        List<ZhiyuanzheEntity> zhiyuanzheEntities_zhiyuanzheIdNumber = zhiyuanzheService.selectList(new EntityWrapper<ZhiyuanzheEntity>().in("zhiyuanzhe_id_number", seachFields.get("zhiyuanzheIdNumber")));
                        if(zhiyuanzheEntities_zhiyuanzheIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiyuanzheEntity s:zhiyuanzheEntities_zhiyuanzheIdNumber){
                                repeatFields.add(s.getZhiyuanzheIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [志愿者身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhiyuanzheService.insertBatch(zhiyuanzheList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectOne(new EntityWrapper<ZhiyuanzheEntity>().eq("username", username));
        if(zhiyuanzhe==null || !zhiyuanzhe.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(zhiyuanzhe.getId(),username, "zhiyuanzhe", "志愿者");
        R r = R.ok();
        r.put("token", token);
        r.put("role","志愿者");
        r.put("username",zhiyuanzhe.getZhiyuanzheName());
        r.put("tableName","zhiyuanzhe");
        r.put("userId",zhiyuanzhe.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ZhiyuanzheEntity zhiyuanzhe, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<ZhiyuanzheEntity> queryWrapper = new EntityWrapper<ZhiyuanzheEntity>()
            .eq("username", zhiyuanzhe.getUsername())
            .or()
            .eq("zhiyuanzhe_phone", zhiyuanzhe.getZhiyuanzhePhone())
            .or()
            .eq("zhiyuanzhe_id_number", zhiyuanzhe.getZhiyuanzheIdNumber())
            ;
        ZhiyuanzheEntity zhiyuanzheEntity = zhiyuanzheService.selectOne(queryWrapper);
        if(zhiyuanzheEntity != null)
            return R.error("账户或者志愿者手机号或者志愿者身份证号已经被使用");
        zhiyuanzhe.setCreateTime(new Date());
        zhiyuanzheService.insert(zhiyuanzhe);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(id);
        zhiyuanzhe.setPassword("123456");
        zhiyuanzheService.updateById(zhiyuanzhe);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(zhiyuanzhe.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(zhiyuanzhe.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        zhiyuanzhe.setPassword(newPassword);
		zhiyuanzheService.updateById(zhiyuanzhe);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectOne(new EntityWrapper<ZhiyuanzheEntity>().eq("username", username));
        if(zhiyuanzhe!=null){
            zhiyuanzhe.setPassword("123456");
            zhiyuanzheService.updateById(zhiyuanzhe);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrZhiyuanzhe(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(id);
        if(zhiyuanzhe !=null){
            //entity转view
            ZhiyuanzheView view = new ZhiyuanzheView();
            BeanUtils.copyProperties( zhiyuanzhe , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = zhiyuanzheService.queryPage(params);

        //字典表数据转换
        List<ZhiyuanzheView> list =(List<ZhiyuanzheView>)page.getList();
        for(ZhiyuanzheView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhiyuanzheEntity zhiyuanzhe = zhiyuanzheService.selectById(id);
            if(zhiyuanzhe !=null){


                //entity转view
                ZhiyuanzheView view = new ZhiyuanzheView();
                BeanUtils.copyProperties( zhiyuanzhe , view );//把实体数据重构到view中

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
    public R add(@RequestBody ZhiyuanzheEntity zhiyuanzhe, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,zhiyuanzhe:{}",this.getClass().getName(),zhiyuanzhe.toString());
        Wrapper<ZhiyuanzheEntity> queryWrapper = new EntityWrapper<ZhiyuanzheEntity>()
            .eq("username", zhiyuanzhe.getUsername())
            .or()
            .eq("zhiyuanzhe_phone", zhiyuanzhe.getZhiyuanzhePhone())
            .or()
            .eq("zhiyuanzhe_id_number", zhiyuanzhe.getZhiyuanzheIdNumber())
//            .notIn("zhiyuanzhe_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiyuanzheEntity zhiyuanzheEntity = zhiyuanzheService.selectOne(queryWrapper);
        if(zhiyuanzheEntity==null){
            zhiyuanzhe.setCreateTime(new Date());
            zhiyuanzhe.setPassword("123456");
        zhiyuanzheService.insert(zhiyuanzhe);

            return R.ok();
        }else {
            return R.error(511,"账户或者志愿者手机号或者志愿者身份证号已经被使用");
        }
    }

}

