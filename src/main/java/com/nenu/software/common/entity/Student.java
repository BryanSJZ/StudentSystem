package com.nenu.software.common.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import java.util.Date;

/**
 * 学生实体类
 * @author shanjz
 * @since 2018/6/22 15:18
 * @version 1.0.0
 */
@Entity
public class Student {

  //唯一标识符
  private long id;

  //学生姓名
  private String stuName;

  //学号
  private long stuNum;

  //密码
  private String password;

  //生日
  private String birthday;

  //班级ID
  private long classId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }


  public long getStuNum() {
    return stuNum;
  }

  public void setStuNum(long stuNum) {
    this.stuNum = stuNum;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }


  public long getClassId() {
    return classId;
  }

  public void setClassId(long classId) {
    this.classId = classId;
  }

}
