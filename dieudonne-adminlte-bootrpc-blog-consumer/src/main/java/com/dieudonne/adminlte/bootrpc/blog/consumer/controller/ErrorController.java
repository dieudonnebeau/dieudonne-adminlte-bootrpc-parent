package com.dieudonne.adminlte.bootrpc.blog.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @ClassName:  ErrorController   
 * @Description:错误控制器   
 * @author: 湖南无为网电子商务有限公司  (Dieudonne)
 * @date:   2018年11月30日 下午5:30:03   
 *     
 * @Copyright: 2018 http://www.0731333.com Inc. All rights reserved. 
 * 注意：本内容仅限于湖南无为网电子商务有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Controller
@RequestMapping("/error")
public class ErrorController {  
    @RequestMapping(value ="/{code}")  
    public  String index(@PathVariable String code,Model model){
		return "error/" + code;
    }  
}
