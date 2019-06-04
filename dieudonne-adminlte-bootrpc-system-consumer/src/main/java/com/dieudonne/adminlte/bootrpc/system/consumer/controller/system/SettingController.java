package com.dieudonne.adminlte.bootrpc.system.consumer.controller.system;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dieudonne.adminlte.bootrpc.system.consumer.common.anno.Log;
import com.dieudonne.adminlte.bootrpc.system.consumer.common.controller.SuperController;
import com.dieudonne.adminlte.bootrpc.system.service.ISysSettingService;
import com.dieudonne.adminlte.model.system.SysSetting;

/**
 * 
 * @ClassName:  SettingController   
 * @Description:系统设置控制器   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月30日 下午5:56:01   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/system/setting")
public class SettingController extends SuperController{  
	
	@Autowired private ISysSettingService	sysSettingService;
	
	/**
	 * 查询系统设置
	 */
	@RequiresPermissions("listSetting")
    @RequestMapping("/page")  
    public  String page(Model model){ 	
    	List<SysSetting> list =  sysSettingService.queryPage();
    	model.addAttribute("list",list);
		return "system/setting/page";
    } 
    
	@RequiresPermissions("doSetting")
	@Log("Mise à jour du système")
    @RequestMapping("/doSetting")
    public String doSetting(String[] id,String[] sysValue,Model model,RedirectAttributes redirectAttributes){
    	
    	if(ArrayUtils.isNotEmpty(id)){
    		for(int i=0;i<id.length;i++){
    			SysSetting setting	= new SysSetting();
        		setting.setId(id[i]);
        		setting.setSysvalue(sysValue[i]);
        		sysSettingService.updateByIDNotNull(setting);
    		}
    	}
    	redirectAttributes.addFlashAttribute("info","OK,Mise à jour du succès!");
		return redirectTo("/system/setting/page.html");
		
    }
    
}
