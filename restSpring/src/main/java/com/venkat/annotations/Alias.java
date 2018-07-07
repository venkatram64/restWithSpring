package com.venkat.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention( value = RetentionPolicy.RUNTIME )
@Target(ElementType.METHOD) 
public @interface Alias { 
	@SuppressWarnings({ "rawtypes" })
	public abstract Class clazz();
	public abstract String alias();
}
