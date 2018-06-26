package com.nenu.software.controller.front;

import com.nenu.software.common.entity.Student;
import com.nenu.software.service.StudentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * 学生前台控制器
 * @author shanjz
 * @since 2018/6/20 10:46
 * @version 1.0.0
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 获取学生姓名
     * @param session session对象
     * @return 课程对象JSON
     */
    @RequestMapping(value = "/getStuName")
    @ResponseBody
    public JSONObject getStuName(HttpSession session) {

        Student student = (Student)session.getAttribute("student");
        String stuName = student.getStuName();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("stuName", stuName);
        return jsonObject;
    }


    /**
     * 学生登陆
     * @param student 学生对象
     * @param session session对象
     * @return 选课页或重新登陆页
     */
    @RequestMapping("/login")
    public String login(Student student, HttpSession session) {
        Student temp = null;
        try {
            temp = studentService.checkLogin(student.getStuNum(), student.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(temp != null) {
            session.setAttribute("student", temp);
            return "grade/frontpages/course-list";
        }
        return "redirect:/login.html";
    }


    /**
     * 退出登录
     * @param session session对象
     * @return 登录页
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("student");
        return "redirect:/login.html";
    }


    /**
     * 前往个人中心
     * @return 个人中心
     */
    @RequestMapping("/toPerson")
    public String toPerson() {
        return "grade/frontpages/change-password";
    }


    /**
     * 获得个人信息
     * @param session session对象
     * @return 学生对象
     */
    @RequestMapping("/getPerson")
    @ResponseBody
    public Student getPersion(HttpSession session) {
        Student student = (Student)session.getAttribute("student");
        return student;
    }



//    /**
//     * 前往修改资料页面
//     * @return
//     */
//    @RequestMapping("/toUpdateMyself")
//    public String toUpdateMyself() {
//        return Pages.UPDATEMYSELF;
//    }


    /**
     * 修改自己的密码和生日
     * @param password 密码
     * @param birthday 生日
     * @param session session对象
     * @return 个人页面
     */
    @RequestMapping("/updateMyself")
    public String updateMyself(String password, String birthday, HttpSession session) {
        Student student = new Student();
        student.setPassword(password);
        student.setBirthday(birthday);
        int stuId = (int)((Student)session.getAttribute("student")).getId();
        student.setId(stuId);
        try {
            studentService.updateStudent(student);
            return "grade/frontpages/change-password";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


//    /**
//     * 进入选课页面
//     * @return
//     */
//    @RequestMapping("/toElectiveCourse")
//    public String toElectiveCourse() {
//        return Pages.ELECTIVECOURSE;
//    }







}
