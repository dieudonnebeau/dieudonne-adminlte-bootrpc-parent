package com.dieudonne.adminlte.elasticsearch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dieudonne.adminlte.bootrpc.elasticsearh.service.EsBlogService;
import com.dieudonne.adminlte.bootrpc.elasticsearh.service.model.EsBlog;
import com.dieudonne.adminlte.bootrpc.elasticsearh.service.vo.TagVO;

/**
 * Blog 控制器.
 * 
 * @since 1.0.0 2017年8月23日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {
	
	@Autowired
    private EsBlogService esBlogService;
	 
    @GetMapping
    public String listEsBlogs(
            @RequestParam(value="order",required=false,defaultValue="new") String order,
            @RequestParam(value="keyword",required=false,defaultValue="" ) String keyword,
            @RequestParam(value="async",required=false) boolean async,
            @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
            @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
            Model model) {

    	Page<EsBlog> page = null;
        List<EsBlog> list = null;
        boolean isEmpty = true; // 系统初始化时，没有博客数据
        try {
            if (order.equals("hot")) { // 最热查询
                page = esBlogService.listHotestEsBlogs(keyword, pageIndex, pageSize, "");
            } else if (order.equals("new")) { // 最新查询
                
                page = esBlogService.listNewestEsBlogs(keyword, pageIndex, pageSize, "");
            }

            isEmpty = false;
        } catch (Exception e) {
           
            page = esBlogService.listEsBlogs(pageIndex, pageSize);
        }  

        list = page.getContent();   // 当前所在页面数据列表


        model.addAttribute("order", order);
        model.addAttribute("keyword", keyword);
        model.addAttribute("page", page);
        model.addAttribute("blogList", list);

        // 首次访问页面才加载
        if (!async && !isEmpty) {
            List<EsBlog> newest = esBlogService.listTop5NewestEsBlogs();
            model.addAttribute("newest", newest);
            List<EsBlog> hotest = esBlogService.listTop5HotestEsBlogs();
            model.addAttribute("hotest", hotest);
            List<TagVO> tags = esBlogService.listTop30Tags();
            model.addAttribute("tags", tags);
            List<String> users = esBlogService.listTop12Users();
            model.addAttribute("users", users);
        }

        return (async==true?"/index :: #mainContainerRepleace":"/index");
    }
}
