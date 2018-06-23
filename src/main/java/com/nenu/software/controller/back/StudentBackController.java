package com.nenu.software.controller.back;

import com.nenu.software.common.entity.Student;
import com.nenu.software.service.ClassService;
import com.nenu.software.service.StudentService;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
     * @return 学生列表json
     */
    @RequestMapping(value = "listStudentByConditions", method = RequestMethod.POST)
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

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    @RequestMapping(value = "selectStudentById/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject selectStudentById(@PathVariable(value = "id") Integer id) {
        Student student = null;
        JSONObject jsonObject = new JSONObject();
        try {
            student = studentService.selectStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(student.getStuName() != null && !student.getStuName().equals("")) {
            jsonObject.put("stuName", student.getStuName());
        } else {
            jsonObject.put("stuName", "无");
        }
        if(student.getStuNum() > 0) {
            jsonObject.put("stuNum", student.getStuNum());
        } else {
            jsonObject.put("stuNum", "无");
        }
        if (student.getBirthday() != null && !student.getBirthday().equals("")) {
            jsonObject.put("birthday", student.getBirthday());
        } else {
            jsonObject.put("birthday", "无");
        }
        if(student.getClassId() > 0) {
            try {
                jsonObject.put("class", classService.selectClassById((int) student.getClassId()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            jsonObject.put("class", "无");
        }

        return jsonObject;
    }

    /**
     * 新增学生
     * @param stuName
     * @param stuNum
     * @param password
     * @param birthday
     * @param classId
     * @return 1 - 增加成功
     *         0 - 增添失败
     */
    @RequestMapping(value = "newStudent", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject newStudent(@RequestParam(value = "stuName", required = false, defaultValue = "") String stuName,
                                 @RequestParam(value = "stuNum", required = false, defaultValue = "-1") Integer stuNum,
                                 @RequestParam(value = "password", required = false, defaultValue = "") String password,
                                 @RequestParam(value = "birthday", required = false) String birthday,
                                 @RequestParam(value = "classId", required = false, defaultValue = "-1") Integer classId) {

        JSONObject jsonObject = new JSONObject();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Student student = new Student();
        student.setStuName(stuName);
        student.setStuNum(stuNum);
        student.setPassword(password);
//        Date birthDate = null;
//        try {
//            birthDate = DateFormat.getDateInstance().parse(birthday);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        student.setBirthday(birthday);
        student.setClassId(classId);

        try {
            studentService.newStudent(student);
            jsonObject.put("code", 1);

        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code", 0);

        }

        return jsonObject;
    }

    /**
     * 根据id删除学生
     * @param id
     * @return 1 - 删除成功
     *         0 - 删除失败
     */
    @RequestMapping(value = "deleteStudentById/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject deleteStudentById(@PathVariable(value = "id") Integer id) {
        JSONObject jsonObject = new JSONObject();
        try {
            studentService.deleteStudentById(id);
            jsonObject.put("code", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code", 0);
        }

        return jsonObject;
    }

    /**
     * 根据id更新学生信息
     * @param id id
     * @param stuName 姓名
     * @param stuNum 学号
     * @param password 密码
     * @param birthday 生日
     * @param classId 班级id
     * @return 1 - 更新成功
     *         2 - 更新失败
     */
    @RequestMapping(value = "updateStudentById/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject updateStudentById(@PathVariable("id") Integer id,
                                        @RequestParam(value = "stuName", required = false, defaultValue = "") String stuName,
                                        @RequestParam(value = "stuNum", required = false, defaultValue = "-1") Integer stuNum,
                                        @RequestParam(value = "password", required = false, defaultValue = "") String password,
                                        @RequestParam(value = "birthday", required = false) String birthday,
                                        @RequestParam(value = "classId", required = false, defaultValue = "-1") Integer classId) {
        JSONObject jsonObject = new JSONObject();
        Student student = new Student();
        student.setId(id);
        student.setStuName(stuName);
        student.setStuNum(stuNum);
        student.setPassword(password);
        student.setBirthday(birthday);
        student.setClassId(classId);

        try {
            studentService.updateStudent(student);
            jsonObject.put("code", 1);
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("code", 0);
        }
        return jsonObject;
    }
}
