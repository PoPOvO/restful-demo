package org.xli.restfuldemo.pojo.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author 谢力
 * @Description
 * @Date 创建于 2019/11/11 18:19
 */
@Data
public class AddStudentDTO {
    @NotNull
    @NotBlank
    private String id;

    @NotNull
    private Boolean sex;

    @Min(value = 1, message = "最小值为1")
    @Max(value = 120, message = "最大值为120")
    @NotNull
    private Byte age;

    @NotNull
    private String name;

    private Date createTime;

    private Date updateTime;

    @Email(message = "邮箱格式错误")
    private String email;

    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "手机号格式错误")
    private String phoneNumber;
}
