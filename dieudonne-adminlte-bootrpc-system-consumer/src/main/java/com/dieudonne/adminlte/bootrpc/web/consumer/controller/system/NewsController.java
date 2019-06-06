package com.dieudonne.adminlte.bootrpc.web.consumer.controller.system;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dieudonne.adminlte.bootrpc.system.service.IAppNewsService;
import com.dieudonne.adminlte.bootrpc.web.consumer.common.anno.Log;
import com.dieudonne.adminlte.bootrpc.web.consumer.common.bean.Rest;
import com.dieudonne.adminlte.bootrpc.web.consumer.common.controller.SuperController;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.common.util.CommonUtil;
import com.dieudonne.adminlte.model.system.AppNews;;
/**
 * 
 * @ClassName:  DeptController   
 * @Description:部门控制器   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月30日 下午5:49:02   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/system/app-news")
public class NewsController extends SuperController{  

	@Autowired private IAppNewsService appNewsService;
	
	/**
	 * 分页查询新闻
	 */
	@RequiresPermissions("listNews")
    @RequestMapping("/list/{pageNumber}")  
    public  String list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize, String search,Model model){
		if(StringUtils.isNotBlank(search)){
			model.addAttribute("search",search);
		}
		// 查询分页
		PageUtil<AppNews> pageData = appNewsService.queryPage(new PageUtil<AppNews>(pageNumber , pageSize), search);
		model.addAttribute("pageData", pageData);
		return "system/news/list";
    } 
    
    /**
     * 新增新闻
     */
	@RequiresPermissions("addNews")
    @RequestMapping("/add")  
    public  String add(Model model){
		return "system/news/add";
    } 
    
    /**
     * 执行新增
     */
	@RequiresPermissions("addNews")
    @Log("Création du nouveau News ")
    @RequestMapping("/doAdd")  
	@ResponseBody
    public  Rest doAdd(AppNews appNews){
		appNews.setId(CommonUtil.getUuid());
		appNews.setCreateTime(new Date());
		appNews.setUpdateTime(new Date());
		appNews.setTopState(1);
		appNews.setState(1);
		appNews.setReadNumber(0);
		appNewsService.save(appNews);
		return Rest.ok();
    }  
    /**
     * 删除新闻
     */
	@RequiresPermissions("deleteNews")
    @Log("Supprimer le News")
    @RequestMapping("/delete")  
    @ResponseBody
    public  Rest delete(String id){
		appNewsService.deleteByID(id);
    	return Rest.ok();
    }  
    
	/**
	 * 编辑新闻
	 */
	@RequiresPermissions("editNews")
    @RequestMapping("/edit/{id}")  
    public  String edit(@PathVariable String id,Model model){
    	AppNews appNews = appNewsService.queryByID(id);
    	
    	model.addAttribute("appNews",appNews);
    	return "system/news/edit";
    } 
    /**
     * 执行编辑
     */
	@RequiresPermissions("editNews")
    @Log("Modifier le News")
    @RequestMapping("/doEdit")  
	@ResponseBody
    public  Rest doEdit(AppNews appNews,Model model){
		appNews.setUpdateTime(new Date());
		appNewsService.updateByIDNotNull(appNews);
    	return Rest.ok();
    } 
	
}
