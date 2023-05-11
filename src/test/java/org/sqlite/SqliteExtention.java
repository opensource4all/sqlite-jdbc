package org.sqlite;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;

@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(ExecutionConditionForExtention.class)
@Target(ElementType.METHOD)
public @interface SqliteExtention {
    String value();
}
