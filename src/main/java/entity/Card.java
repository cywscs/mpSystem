package entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Card {

    @ExcelProperty(value = "用户编号")
    private Integer id;

    @ExcelProperty(value = "姓名")
    private String name;

    @ExcelProperty(value = "年龄")
    private Integer age;

    @ExcelProperty(value = "性别")
    private String sex;

    @ExcelProperty(value = "用户名")
    private String username;

    @ExcelProperty(value = "密码")
    private String password;

    @ExcelProperty(value = "邮箱")
    private String email;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
