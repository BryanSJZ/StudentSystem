package com.nenu.software.mapper;

import com.nenu.software.common.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 课程Mapper
 * @author shanjz
 * @since 2018/6/20 20:43
 */
@Repository
public interface CourseMapper {

    /**
     * 新增课程
     * @param course 课程对象
     * @throws Exception 异常
     */
    public void newCourse(@Param("course") Course course) throws Exception;

    /**
     * 通过ID删除课程
     * @param id ID
     * @throws Exception 异常
     */
    public void deleteCourseById(@Param("id") Integer id) throws Exception;

    /**
     * 更新课程信息
     * @param course 课程对象
     * @throws Exception 异常
     */
    public void updateCourse(@Param("course") Course course) throws Exception;

    /**
     * 通过ID查找课程
     * @param id ID
     * @return 课程对象
     * @throws Exception 异常
     */
    public Course selectCourseById(@Param("id") Integer id) throws Exception;

    /**
     * 通过课程名称查找
     * @param courseName 名称
     * @return 课程列表
     * @throws Exception 异常
     */
    public List<Course> listCourseByName(@Param("courseName") String courseName) throws Exception;


    /**
     * 查询所有的课程
     * @return 课程列表
     * @throws Exception 异常
     */
    public List<Course> queryAllCourse() throws Exception;
}
