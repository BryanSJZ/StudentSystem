package com.nenu.software.mapper;

import com.nenu.software.common.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 教师mapper
 * @author shanjz
 * @since 2018/6/20 19:56
 * @version 1.0.0
 */
@Repository
public interface TeacherMapper {

    /**
     * 新增教师
     * @param teacher 教师对象
     * @throws Exception 异常
     */
    public void newTeacher(@Param("teacher") Teacher teacher) throws Exception;

    /**
     * 通过ID删除教师
     * @param id ID
     * @throws Exception 异常
     */
    public void deleteTeacherById(@Param("id") Integer id) throws Exception;

    /**
     * 根据教师编号删除教师
     * @param teaNum 教师工号
     * @throws Exception 异常
     */
    public void deleteTeacherByTeaNum(@Param("teaNum") String teaNum) throws Exception;

    /**
     * 更新教师
     * @param teacher 教师对象
     * @throws Exception 异常
     */
    public void updateTeacher(@Param("teacher") Teacher teacher) throws Exception;

    /**
     * 通过ID查找教师
     * @param id ID
     * @return 教师对象
     * @throws Exception 异常
     */
    public Teacher selectTeacherById(@Param("id") Integer id) throws Exception;

    /**
     * 通过教师工号查找教师
     * @param teaNum 教师工号
     * @return 教师对象
     * @throws Exception 异常
     */
    public Teacher selectTeacherByTeaNum(@Param("teaNum") String teaNum) throws Exception;

    /**
     * 根据条件查询教师列表
     * @param teaName 教师姓名
     * @param teaNum 教师编号
     */
    public List<Teacher> listTeacherByConditions(@Param("teaName") String teaName,
                                                 @Param("teaNum") String teaNum) throws Exception;

    /**
     * 检查登陆
     * @param teacher 教师对象
     * @return 教师对象
     * @throws Exception 异常
     */
    public Teacher checkTeaLogin(Teacher teacher) throws Exception;


}
