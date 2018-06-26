package com.nenu.software.service;

import com.nenu.software.common.entity.Course;

import java.util.List;

/**
 * 课程service
 * @author shanjz
 * @since 2018/6/20 20:56
 */
public interface CourseService {

    /**
     * 新增课程
     * @param course 课程对象
     * @throws Exception 异常
     */
    public void newCourse(Course course) throws Exception;

    /**
     * 通过ID删除课程
     * @param id ID
     * @throws Exception 异常
     */
    public void deleteCourseById(Integer id) throws Exception;

    /**
     * 更新课程
     * @param course 课程对象
     * @throws Exception 异常
     */
    public void updateCourse(Course course) throws Exception;

    /**
     * 通过ID查找课程
     * @param id ID
     * @return 课程对象
     * @throws Exception 异常
     */
    public Course selectCourseById(Integer id) throws Exception;

    /**
     * 根据课程名（可以为空）查找课程列表
     * @param courseName 课程名
     * @return 列表
     * @throws Exception 异常
     */
    public List<Course> listCourseByName(String courseName) throws Exception;

    /**
     * 查询所有课程
     * @return 课程列表
     * @throws Exception 异常
     */
    public List<Course> queryAllCourse() throws Exception;

}
