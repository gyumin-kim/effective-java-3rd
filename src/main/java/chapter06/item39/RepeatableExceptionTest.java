package chapter06.item39;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(RepeatableExceptionTestContainer.class)
public @interface RepeatableExceptionTest {
	Class<? extends Throwable> value();
}
