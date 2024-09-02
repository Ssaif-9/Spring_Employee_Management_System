import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD,ElementType.PARAMETER,ElementType.TYPE,ElementType.FIELD})

public @interface Author {
    String name() default "";
    int salary();
}
