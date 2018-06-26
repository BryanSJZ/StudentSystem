package com.nenu.software.common.dto;

/**
 * 学生及分数
 * @author shanjz
 * @since 2018/6/22 9:55
 * @version 1.0.0
 */
public class StuScore {

    //选课ID
    private int eleId;

    //学生ID
    private int stuId;

    //课程ID
    private int courseId;

    //课程名称
    private String course;

    //学生学号
    private String stuNum;

    //学生姓名
    private String stuName;

    //年级
    private String grade;

    //班级名称
    private String className;

    //得分
    private double score;

    public int getEleId() {
        return eleId;
    }

    public void setEleId(int eleId) {
        this.eleId = eleId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
