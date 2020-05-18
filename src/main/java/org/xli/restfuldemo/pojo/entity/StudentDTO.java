package org.xli.restfuldemo.pojo.entity;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.xli.restfuldemo.validator.CreateDateValidation;
import org.xli.restfuldemo.validator.CreateTimeValidator;

import javax.persistence.Column;
import javax.validation.*;
import javax.validation.constraints.*;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/11/11 18:19
 */
@Data
@StudentDTO.StudentDTOValidation(message = "StudentDTO类校验错误", groups = {StudentDTO.Edit.class, StudentDTO.Create.class})
public class StudentDTO {
    // 分组校验标志
    public interface Create {}
    public interface Edit {}

    @NotNull(groups = Create.class)
    @NotBlank(groups = Create.class)
    private String id;

    @NotNull(groups = Create.class)
    private Boolean sex;

    @Min(value = 1, message = "最小值为1", groups = {Create.class, Edit.class})
    @Max(value = 120, message = "最大值为120", groups = {Create.class, Edit.class})
    @NotNull(groups = Create.class)
    private Byte age;

    @NotNull(groups = Create.class)
    private String name;

    @CreateDateValidation(groups = {Create.class})
    private Date createTime;

    private Date updateTime;

    @Email(message = "邮箱格式错误", groups = {Create.class, Edit.class})
    private String email;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号格式错误", groups = {Create.class, Edit.class})
    private String phoneNumber;

//    @Valid
//    private AddressDTO addressDTO;
//
//    @Data
//    static class AddressDTO {
//        @NotNull
//        @NotBlank
//        private String address;
//    }

    /**
     * 对StudentDTO类的校验
     */
    @Documented
    @Constraint(validatedBy = StudentDTOValidator.class)
    @Target({ElementType.TYPE})
    @Retention(RUNTIME)
    public @interface StudentDTOValidation {
        String message() default "";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

        // 指定多个Validation时使用
        @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
        @Retention(RUNTIME)
        @Documented
        @interface List {
            StudentDTOValidation[] value();
        }
    }

    /**
     * 对StudentDTO的校验类
     */
    public static class StudentDTOValidator implements ConstraintValidator<StudentDTOValidation, StudentDTO> {
        @Override
        public void initialize(StudentDTOValidation constraintAnnotation) {
            System.out.println(constraintAnnotation);
        }

        @Override
        public boolean isValid(StudentDTO value, ConstraintValidatorContext context) {
            return false;
        }
    }

    @Component
    public static class StudentValidator implements Validator {
        /**
         * 该Validator所支持的类
         * @param clazz
         * @return
         */
        @Override
        public boolean supports(Class<?> clazz) {
            return StudentDTO.class.equals(clazz);
        }

        /**
         * 对校验类实例的字段进行校验，并可以设置errMsg
         */
        @Override
        public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "姓名不能为空");
            StudentDTO studentDTO = (StudentDTO) target;
            if (studentDTO.getSex() != null && studentDTO.getSex() == true) {
                errors.rejectValue("sex", "valid sex", "sex不能为true");
            }
        }
    }
}
