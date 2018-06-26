package com.nenu.software.common.entity;

import javax.persistence.Entity;

/**
 * 班级实体类
 * @author shanjz
 * @since 2018/6/22 15:15
 * @version 1.0.0
 */
@Entity
public class Course {

  //唯一标识符
  private long id;

  //课程姓名
  private String courseName;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

}
