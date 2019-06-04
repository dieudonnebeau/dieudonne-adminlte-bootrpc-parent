package com.dieudonne.adminlte.bootrpc.blog.consumer.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dieudonne.adminlte.bootrpc.blog.consumer.common.anno.Log;
import com.dieudonne.adminlte.bootrpc.blog.consumer.common.bean.Rest;
import com.dieudonne.adminlte.bootrpc.blog.consumer.common.controller.SuperController;
import com.dieudonne.adminlte.bootrpc.blog.service.IAppBlogCatalogService;
import com.dieudonne.adminlte.model.blog.AppBlogCatalog;
/**
 * 
 * @ClassName:  AppBlogController   
 * @Description:博客控制器   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2019年5月30日 下午5:19:47   
 *     
 * @Copyright: 2019 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/app/blogCatalog")
public class AppBlogCatalogController extends SuperController{  

	@Autowired private IAppBlogCatalogService appBlogCatalogService;
	
	
//	@RequiresPermissions("listBlog")
//    @RequestMapping("/list/{pageNumber}")  
//    public  String list(@PathVariable Integer pageNumber,@RequestParam(defaultValue="15") Integer pageSize, String search,Model model){
//		if(StringUtils.isNotBlank(search)){
//			model.addAttribute("search",search);
//		}
//		// 查询分页
//		PageUtil<AppBlog> pageData = appBlogService.queryPage(new PageUtil<AppBlog>(pageNumber , pageSize), search);
//		model.addAttribute("pageData", pageData);
//		return "app/blog/list";
//    } 
    
   
	@RequiresPermissions("addCatalog")
    @RequestMapping("/add")  
    public  String add(Model model){
		return "app/blogCatalog/add";
    } 
    
    
	@RequiresPermissions("addBlog")
    @Log("Création du nouveau blog catalog ")
    @RequestMapping("/doAdd")  
	@ResponseBody
    public  Rest doAdd(AppBlogCatalog blogCatalog){
		appBlogCatalogService.save(blogCatalog);
		return Rest.ok();
    }  
   
	@RequiresPermissions("deleteCatalog")
    @Log("Supprimer le blog catalog")
    @RequestMapping("/delete")  
    @ResponseBody
    public  Rest delete(String id){
		appBlogCatalogService.deleteByID(id);
    	return Rest.ok();
    }  
    
	
	@RequiresPermissions("editBlog")
    @RequestMapping("/edit/{id}")  
    public  String edit(@PathVariable String id,Model model){
    	AppBlogCatalog blogCatalog = appBlogCatalogService.queryByID(id);
    	
    	model.addAttribute("blogCatalog",blogCatalog);
    	return "app/blogCatalog/edit";
    } 

	@RequiresPermissions("editBlog")
    @Log("Modifier le blog catalog")
    @RequestMapping("/doEdit")  
	@ResponseBody
    public  Rest doEdit(AppBlogCatalog blogCatalog,Model model){
		appBlogCatalogService.updateByID(blogCatalog);
    	return Rest.ok();
    } 
	
}
