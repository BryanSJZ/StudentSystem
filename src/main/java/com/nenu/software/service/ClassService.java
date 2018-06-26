package com.nenu.software.service;

import com.nenu.software.common.entity.Class;

import java.util.List;

/**
 * 班级Service
 * @author shanjz
 * @since 2018/6/21 9:02
 * @version 1.0.0
 */
public interface ClassService {

    /**
     * 新增班级
     * @param clazz 班级对象
     * @throws Exception 异常
     */
    public void newClass(Class clazz) throws Exception;

    /**
     * 根据ID删除班级
     * @param id ID
     * @throws Exception 异常
     */
    public void deleteClassById(Integer id) throws Exception;

    /**
     * 更新班级
     * @param clazz 班级对象
     * @throws Exception 异常
     */
    public void updateClass(Class clazz) throws Exception;

    /**
     * 通过ID查找班级
     * @param id ID
     * @return 班级对象
     * @throws Exception 异常
     */
    public Class selectClassById(Integer id) throws Exception;

    /**
     * 通过条件查询班级
     * @param grade 年级
     * @param className 班级名称
     * @return 列表
     * @throws Exception 异常
     */
    public List<Class> listClassByConditions(String grade, String className) throws Exception;

}
