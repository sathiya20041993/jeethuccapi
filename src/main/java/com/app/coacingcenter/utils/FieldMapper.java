package com.app.coacingcenter.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldMapper {

	public String name() default "none";

	public String type() default "java.lang.String";

	public String conversionMethod() default "none";

	public boolean required() default false;

	public Class target() default Object.class;
	
}
