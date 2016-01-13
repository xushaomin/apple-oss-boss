package com.appleframework.oss.boss.template.directive;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.appleframework.web.freemarker.directive.BaseDirective;

import freemarker.core.Environment;
import freemarker.ext.beans.CollectionModel;
import freemarker.ext.beans.NumberModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

@Component("authorizeDirective")
public class AuthorizeDirective extends BaseDirective {

	private static final String VARIABLE_NAME = "hasRights";

	@SuppressWarnings({ "rawtypes" })
	public void execute(Environment env, Map params, TemplateModel[] loopVars, 
			TemplateDirectiveBody body) throws TemplateException, IOException {		
		CollectionModel rightsSequence = (CollectionModel)params.get("rights");
		NumberModel menuNumber = (NumberModel)params.get("menuId");
		NumberModel adminNumber = (NumberModel)params.get("isAdmin");
		Integer isAdmin = (Integer)adminNumber.getAsNumber();
		Integer hasRights = 0;
		if(isAdmin == 1) {
			hasRights = 1;
		}
		else {
			if(null != rightsSequence.get(menuNumber.toString())) {
				hasRights = 1;
			}
		}
		setLocalVariable(VARIABLE_NAME, hasRights, env, body);
	}

}