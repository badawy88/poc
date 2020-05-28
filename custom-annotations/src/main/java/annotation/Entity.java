package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;

@Retention(RetentionPolicy.CLASS)
@Target({TYPE,METHOD})
public @interface Entity {
    String name();
    String target() default "";
}
