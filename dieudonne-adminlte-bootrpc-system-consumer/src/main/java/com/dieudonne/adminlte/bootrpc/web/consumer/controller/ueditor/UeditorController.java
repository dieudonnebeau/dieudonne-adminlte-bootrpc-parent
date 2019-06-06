package com.dieudonne.adminlte.bootrpc.web.consumer.controller.ueditor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ueditor")
public class UeditorController {

	 @GetMapping("/index")
	   public String index() {
	       return "ueditor/add";
	 }
}
