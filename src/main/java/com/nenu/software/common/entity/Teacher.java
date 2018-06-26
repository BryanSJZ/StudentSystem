package com.nenu.software.common.entity;

import javax.persistence.Entity;

/**
 * 学生实体类
 * @author shanjz
 * @since 2018/6/22 15:20
 */
@Entity
public class Teacher {

  //唯一标识符
  private long id;

  //教师姓名
  private String teaName;

  //教师工号
  private String teaNum;

  //密码
  private String password;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getTeaName() {
    return teaName;
  }

  public void setTeaName(String teaName) {
    this.teaName = teaName;
  }


  public String getTeaNum() {
    return teaNum;
  }

  public void setTeaNum(String teaNum) {
    this.teaNum = teaNum;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
