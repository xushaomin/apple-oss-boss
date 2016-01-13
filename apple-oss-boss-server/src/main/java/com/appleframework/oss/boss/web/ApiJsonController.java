package com.appleframework.oss.boss.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appleframework.oss.boss.service.UserSearchService;

@Controller
public class ApiJsonController extends BaseController {
		
	@Resource
	private UserSearchService userSearchService;
	
	/*@Resource
	private RtsRoleService rtsRoleService;
	
	@Resource
	private DepartmentService departmentService;

	
	@Resource
	private JavaMailSender mailSender;
	
	@Resource
	private FreeMarkerConfigurer freemarkerConfig;*/
	
	@RequestMapping(value = "/api/user/list")
	public @ResponseBody List<Map<String, Object>> add(Model model, String keyword) throws Exception {
		return userSearchService.getMapListByState(1, keyword);
	}
	
}
