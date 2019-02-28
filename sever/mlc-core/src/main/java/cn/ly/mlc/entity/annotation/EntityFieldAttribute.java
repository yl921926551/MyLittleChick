package cn.ly.mlc.entity.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityFieldAttribute {
	
	/**
	 * 名称
	 * @return
	 */
	String name() default "";
	
	/**
	 * 描述
	 * @return
	 */
	String desc() default "";
	
	/**
	 * 类型
	 * @return
	 */
	String type() default "";
	
	
}
