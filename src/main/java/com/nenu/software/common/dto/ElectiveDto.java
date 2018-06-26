package com.nenu.software.common.dto;

/**
 * 选课DTO
 * @author shanjz
 * @since 2018/6/23 13:12
 * @version 1.0.0
 */
public class ElectiveDto {

    //选课ID
    private long id;

    //学号
    private long stuId;

    //学生姓名
    private String stuName;

    //课程ID
    private long courseId;

    //课程名称
    private String courseName;

    //学生分数
    private double score;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public long getStuId() {
        return stuId;
    }

    public void setStuId(long stuId) {
        this.stuId = stuId;
    }


    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }


    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuName() {
        return stuName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
