package com.nenu.software.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.nenu.software.common.entity.Class;

import java.util.List;

/**
 * 班级Mapper
 * @author shanjz
 * @since 2018/6/21 8:50
 */
@Repository
public interface ClassMapper {

    /**
     * 添加班级
     * @param clazz 班级对象
     * @throws Exception 异常
     */
    public void newClass(@Param("clazz") Class clazz) throws Exception;

    /**
     * 通过ID删除班级
     * @param id 唯一标识符
     * @throws Exception 异常
     */
    public void deleteClassById(@Param("id") Integer id) throws Exception;

    /**
     * 更新班级
     * @param clazz 班级对象
     * @throws Exception 异常
     */
    public void updateClass(@Param("clazz") Class clazz) throws Exception;

    /**
     * 通过ID查找班级
     * @param id 唯一标识符
     * @return 班级对象
     * @throws Exception 异常
     */
    public Class selectClassById(@Param("id") Integer id) throws Exception;

    /**
     * 根据条件查找班级
     * @param grade 年级
     * @param className 班级名称
     * @return 标记列表
     * @throws Exception 异常
     */
    public List<Class> listClassByConditions(@Param("grade") String grade,
                                             @Param("className") String className) throws Exception;

}
