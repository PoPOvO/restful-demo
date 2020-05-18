package org.xli.restfuldemo.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "student_info")
@ToString(exclude = {"createTime", "updateTime"})
public class StudentDO {
    @Id
    private String id;

    private Boolean sex;

    private Byte age;

    private String name;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;
}
