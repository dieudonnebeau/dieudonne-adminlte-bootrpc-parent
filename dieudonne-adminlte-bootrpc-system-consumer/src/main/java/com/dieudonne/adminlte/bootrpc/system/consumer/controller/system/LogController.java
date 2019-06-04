package com.dieudonne.adminlte.bootrpc.system.consumer.controller.system;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dieudonne.adminlte.bootrpc.system.consumer.common.controller.SuperController;
import com.dieudonne.adminlte.bootrpc.system.service.ISysLogService;
import com.dieudonne.adminlte.common.mapper.util.PageUtil;
import com.dieudonne.adminlte.model.system.SysLog;

/**
 * 
 * @ClassName:  LogController   
 * @Description:日志控制器  
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月30日 下午5:49:42   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/system/log")
public class LogController extends SuperController {

	@Autowired private ISysLogService sysLogService;
	
	/**
	 * 分页查询日志
	 */
	@RequiresPermissions("listLog")
    @RequestMapping("/list/{pageNumber}")  
    public  String list(@PathVariable Integer pageNumber, @RequestParam(defaultValue="15") Integer pageSize, String search,String daterange,Model model){		
		PageUtil<SysLog> page = new PageUtil<>(pageNumber , pageSize);
		// 查询分页
		if(StringUtils.isNotBlank(search)){
			model.addAttribute("search", search);
		}
		//日期查询
		if(StringUtils.isNotBlank(daterange)){
			model.addAttribute("daterange", daterange);
		}
		PageUtil<SysLog> pageData = sysLogService.queryPage(page, search , daterange);
		model.addAttribute("pageData", pageData);
		return "system/log/list";
    } 
    
    /**
     * 获取参数
     */
    @RequestMapping("/params/{id}")
    @ResponseBody
    public String params(@PathVariable String id,Model model){
    	SysLog sysLog = sysLogService.queryByID(id);
    	return sysLog.getParams();
    }
    
}
