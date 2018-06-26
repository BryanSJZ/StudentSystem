package com.nenu.software.service;


import com.nenu.software.common.dto.ElectiveDto;
import com.nenu.software.common.dto.StuScore;
import com.nenu.software.common.entity.Course;
import com.nenu.software.common.entity.Elective;
import com.nenu.software.common.entity.Student;

import java.util.List;

/**
 * 选修信息Service
 * @author shanjz
 * @since 2018/6/21 9:02
 * @version 1.0.0
 */
public interface ElectiveService {

    /**
     * 新增选课信息
     * @param elective 选课对象
     * @throws Exception 异常
     */
    public void newElective(Elective elective) throws Exception;

    /**
     * 根据条件删除选修课程
     * @param id ID
     * @param stuId 学生ID
     * @param courseId 课程ID
     * @throws Exception 异常
     */
    public void deleteElectiveByConditions(Integer id,
                                           Integer stuId,
                                           Integer courseId) throws Exception;

    /**
     * 更新选课信息
     * @param elective 选课对象
     * @throws Exception 异常
     */
    public void updateElective(Elective elective) throws Exception;

    /**
     * 根据ID查找选课
     * @param id ID
     * @return 选课对象
     * @throws Exception 异常
     */
    public Elective selectElectiveById(Integer id) throws Exception;

    /**
     * 根据条件查找选修信息
     * @param stuId 学生ID
     * @param courseId 课程ID
     * @return 选课列表
     * @throws Exception 异常
     */
    public List<Elective> listElectiveByConditions(Integer stuId,
                                                   Integer courseId) throws Exception;


    /**
     * 查询选某课程的全体学生
     * @param courseId 课程ID
     * @return 选择该课程的学生
     * @throws Exception 异常
     */
    public List<StuScore> listElectiveStudents(int courseId) throws Exception;

    /**
     * 查询某学生已选课程
     * @param stuId 学生ID
     * @return 学生已选课程
     */
    public List<Course> listElectedCourses(int stuId) throws Exception;

    /**
     * 查询某学生未选课程
     * @param stuId 学生ID
     * @return 学生未选课程
     */
    public List<Course> listUnelectedCourses(int stuId) throws Exception;


    /**
     * 查询自己的选课和成绩
     * @param stuId 学生ID
     * @return 选课DTO列表
     * @throws Exception 异常
     */
    public List<ElectiveDto> queryCourseAndScore(int stuId) throws Exception;
}
