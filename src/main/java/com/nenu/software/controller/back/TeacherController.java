package com.nenu.software.controller.back;

import com.nenu.software.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author shanjz
 * @since 2018/6/23 12:34
 */
@RequestMapping("/backTeacher")
public class TeacherController {


    @Autowired
    private TeacherService service;







}
