package com.atsicau.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.atsicau.bean.Pink;
/*
 * 自定义逻辑返回需要返回的组件
 */
public class MyImportSelector implements ImportSelector{
	
	//返回值，就是导入到容器中的组件类全类名
	
	/*
	 * AnnotationMetadata:当前标注@Import注解的所有类的所有注解信息
	 * @see org.springframework.context.annotation.ImportSelector#selectImports(org.springframework.core.type.AnnotationMetadata)
	 */

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//importingClassMetadata.getMetaAnnotationTypes(annotationName)
		//方法不应该返回null
		return new String[]{"com.atsicau.bean.Pink"};
	}

}
