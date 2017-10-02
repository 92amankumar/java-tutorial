package com.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CustomAnnotation {
	public static void main(String[] args) {

	}

	@UseCase(id = 10, description = "Used for validating password")
	public boolean validatePassword(String password) {
		return password.matches("\\w*\\d\\w*");
	}
}
// The default retention policy type is CLASS.
// If a Target meta-annotation is not present on an annotation type declaration,
// the declared type may be used on any program element.

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface UseCase {
	public int id();

	public String description() default "No Description";
}

/*
 * Three standard annotations in java.lang
 * : @Override, @Deprecated, @SuppressWarnings
 * 
 * Four Meta-Annotations (Annotations used for annotating annotations)
 * 
 * @Target
 * 
 * @Retention
 * 
 * @Documented
 * 
 * @Inherited
 */