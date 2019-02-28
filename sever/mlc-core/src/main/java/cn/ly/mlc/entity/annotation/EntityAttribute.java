package cn.ly.mlc.entity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityAttribute {

	/**
	 * 实体名称
	 * @return
	 */
	String name() default "";
	
	/**
	 * 实体描述
	 * @return
	 */
	String desc() default "";
	
}
