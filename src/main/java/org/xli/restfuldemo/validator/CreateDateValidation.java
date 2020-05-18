package org.xli.restfuldemo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/11/12 18:33
 */
@Documented
@Constraint(validatedBy = CreateTimeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RUNTIME)
public @interface CreateDateValidation {
    String message() default "不是正确创建时间";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    // 指定多个Validation时使用
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        CreateDateValidation[] value();
    }
}


