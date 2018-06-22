package com.nenu.software.controller.front;

import com.nenu.software.common.entity.Student;
import com.nenu.software.common.util.Pages;
import com.nenu.software.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author shanjz
 * @since 2018/6/20 10:46
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    /**
     * 学生登陆
     * @param student
     * @param session
     * @return
     */
    @RequestMapping("/login")
    public String login(Student student, HttpSession session) {
        Student temp = null;
        try {
            temp = studentService.checkLogin(student.getStuNum(), student.getPassword());
        } catch (Exception e) {
            return Pages.ERROR;
        }
        if(temp != null) {
            session.setAttribute("student", temp);
            return Pages.FRONTINDEX;
        }
        return "redirect:/login.jsp";
    }


    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("student");
        return "redirect:/login.jsp";
    }


    /**
     * 进入选课页面
     * @return
     */
    @RequestMapping("/toElectiveCourse")
    public String toElectiveCourse() {
        return Pages.ELECTIVECOURSE;
    }




}
