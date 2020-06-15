package com.atsicau.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

//判断操作系统是否为Linux

public class LinuxCondition implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String version = context.getEnvironment().getProperty("os.name");
		if(version.contains("linux"))
			return true;
		return false;
	}
	
}
