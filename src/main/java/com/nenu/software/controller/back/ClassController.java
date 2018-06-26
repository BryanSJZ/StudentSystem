package com.nenu.software.controller.back;


import com.nenu.software.common.entity.Class;
import com.nenu.software.service.ClassService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 班级控制器
 * @author shanjz
 * @since 2017/9/18 20:17
 * @version 1.0.0
 */
@Controller
@RequestMapping("/backClass")
public class ClassController {
    @Autowired
    ClassService classService;

    /**
     * 获取班级列表
     * @return 班级列表JSON
     */
    @RequestMapping("/all")
    @ResponseBody
    public JSONObject list() {
        JSONObject jsonObject = new JSONObject();
        try {
            List<Class> list = classService.listClassByConditions("","");
            jsonObject.put("list",list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 跳转至班级列表页面
     * @return 班级列表页面
     */
    @RequestMapping("list")
    public String toList() {
        return "grade/backpages/class-list";
    }


    /**
     * ajax删除班级
     * @param id ID
     * @return 成功与否JSON
     */
    @RequestMapping("/delete")
    @ResponseBody
    public JSONObject deleteClass(@RequestParam("id")int id) {
        JSONObject jsonObject = new JSONObject();
        try {
            classService.deleteClassById(id);
            jsonObject.put("code",1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code",0);
        }
        return jsonObject;
    }

    /**
     * 新增班级处理表单
     * @param grade 年级
     * @param name 班级
     * @return 列表页
     */
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String newCourse(@RequestParam("grade") String grade,@RequestParam("className")String name) {
        Class aClass = new Class();
        aClass.setGrade(grade);
        aClass.setClassName(name);
        try {
            classService.newClass(aClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.toList();
    }
}
