package com.nenu.software.mapper;

import com.nenu.software.common.dto.ElectiveDto;
import com.nenu.software.common.dto.StuScore;
import com.nenu.software.common.entity.Course;
import com.nenu.software.common.entity.Elective;
import com.nenu.software.common.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 选修课程Mapper
 * @author shanjz
 * @since 2018/6/21 9:16
 * @version 1.0.0
 */
public interface ElectiveMapper {

    /**
     * 新增选课
     * @param elective 选课对象
     * @throws Exception 异常
     */
    public void newElective(@Param("elective") Elective elective) throws Exception;

    /**
     * 根据条件删除选课
     * @param id 选课ID
     * @param stuId 学生ID
     * @param courseId 课程ID
     * @throws Exception 异常
     */
    public void deleteElectiveByConditions(@Param("id") Integer id,
                                           @Param("stuId") Integer stuId,
                                           @Param("courseId") Integer courseId) throws Exception;

    /**
     * 更新选课信息
     * @param elective 选课对象
     * @throws Exception 异常
     */
    public void updateElective(@Param("elective") Elective elective) throws Exception;

    /**
     * 通过ID查询选课
     * @param id ID
     * @return 选课对象
     * @throws Exception 异常
     */
    public Elective selectElectiveById(@Param("id") Integer id) throws Exception;

    /**
     * 通过条件查询选课
     * @param stuId 学生ID
     * @param courseId 课程ID
     * @return 选课列表
     * @throws Exception 异常
     */
    public List<Elective> listElectiveByConditions(@Param("stuId") Integer stuId,
                                                   @Param("courseId") Integer courseId) throws Exception;

    /**
     * 查询选某课程的全体学生
     * @param courseId 课程ID
     * @return 选择该课程的学生
     * @throws Exception 异常
     */
    public List<StuScore> listElectiveStudents(@Param("courseId") int courseId) throws Exception;

    /**
     * 查询某学生已选课程
     * @param stuId 学生ID
     * @return 学生已选课程
     */
    public List<Course> listElectedCourses(@Param("stuId") int stuId) throws Exception;

    /**
     * 查询某学生未选课程
     * @param stuId 学生ID
     * @return 学生未选课程
     */
    public List<Course> listUnelectedCourses(@Param("stuId") int stuId) throws Exception;


    /**
     * 查询自己的选课和成绩
     * @param stuId 学生ID
     * @return 列表
     * @throws Exception 异常
     */
    public List<ElectiveDto> queryCourseAndScore(int stuId) throws Exception;


}
