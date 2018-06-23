package com.nenu.software.controller.back;

import com.nenu.software.common.entity.Student;
import com.nenu.software.service.ClassService;
import com.nenu.software.service.StudentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: software-liuwang
 * @time: 2018/6/22 9:22
 * @description: 学生Controller
 */
@Controller
@RequestMapping(value = "back/student")
public class StudentBackController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private ClassService classService;

    /**
     * 根据条件获取JSON学生列表
     * @param stuName 学生姓名
     * @param stuNum 学生学号
     * @param classId 班级Id
     * @return
     */
    @RequestMapping(value = "listStudentByConditions", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject listStudentByConditions(@RequestParam(value = "stuName", required = false, defaultValue = "") String stuName,
                                              @RequestParam(value = "stuNum", required = false, defaultValue = "-1") Integer stuNum,
                                              @RequestParam(value = "classId", required = false, defaultValue = "-1") Integer classId) {
        JSONObject jsonObject = new JSONObject();
        List<Student> studentList = new ArrayList<>();
        try {
            studentList = studentService.listStudentByConditions(stuName, stuNum, classId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = new JSONArray();
        if(studentList != null) {
            for(Student student : studentList) {
                JSONObject json = new JSONObject();
                if(student.getStuName() != null && !student.getStuName().equals("")) {
                    json.put("stuName", student.getStuName());
                } else {
                    json.put("stuName", "无");
                }
                if(student.getStuNum() > 0) {
                    json.put("stuNum", student.getStuNum());
                } else {
                    json.put("stuNum", "无");
                }
                if (student.getBirthday() != null && !student.getBirthday().equals("")) {
                    json.put("birthday", student.getBirthday());
                } else {
                    json.put("birthday", "无");
                }
                if(student.getClassId() > 0) {
                    try {
                        json.put("class", classService.selectClassById((int) student.getClassId()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    json.put("class", "无");
                }
                jsonArray.add(json);
            }
        }
        jsonObject.put("json", jsonArray);
        return jsonObject;
    }

}
