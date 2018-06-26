package com.nenu.software.common.entity;

import javax.persistence.Entity;

/**
 * 班级实体类
 * @author shanjz
 * @since 2018/6/22 15:12
 * @version 1.0.0
 */
@Entity
public class Class {

  //唯一标识
  private long id;

  //年级
  private String grade;

  //班级
  private String className;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }


  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

}
