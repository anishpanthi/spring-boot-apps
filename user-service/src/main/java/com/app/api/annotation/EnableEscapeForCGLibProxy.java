package com.app.api.annotation;

import java.lang.annotation.*;

/**
 * @author Anish Panthi
 */
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface EnableEscapeForCGLibProxy {
}
