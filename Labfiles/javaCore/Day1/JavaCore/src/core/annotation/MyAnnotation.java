package core.annotation;

import java.lang.annotation.*;
//An annotation type declaration. 

@Retention(RetentionPolicy.RUNTIME)

@interface MyAnnotation {
	String str();
	int	val();

}
