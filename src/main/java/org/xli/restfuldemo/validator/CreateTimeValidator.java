package org.xli.restfuldemo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

/**
 * @author 谢力
 * @Description 校验创建时间，创建时间要大于dateTime
 * @Date 创建于 2019/11/12 18:35
 */
public class CreateTimeValidator implements ConstraintValidator<CreateDateValidation, Date> {
    private final LocalDateTime dateTime = LocalDateTime.of(2019, 11, 11, 12, 0);

    /**
     * 可以通过该方法获取“校验注解”的字段值
     *
     * @param constraintAnnotation 校验注解
     */
    @Override
    public void initialize(CreateDateValidation constraintAnnotation) {
        // 获取@CreateDateValidation的字段值
        String message = constraintAnnotation.message();
        System.out.println("校验消息：" + message);
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        LocalDateTime cur = value.toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime();
        // 创建时间要大于dateTime
        return cur.toEpochSecond(ZoneOffset.UTC) - dateTime.toEpochSecond(ZoneOffset.UTC) > 0;
    }
}
