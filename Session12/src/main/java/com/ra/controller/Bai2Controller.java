package com.ra.controller;

import com.ra.dao.impl.StudentDAOImpl;
import com.ra.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/bai2")
public class Bai2Controller {

    StudentDAOImpl studentDAO = new StudentDAOImpl();
    @GetMapping("")
    public String display(Model model){
        List<Student> students = studentDAO.getListStudent();
        model.addAttribute("student",students);
        return "bai2_display";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable int id){
        Student student = studentDAO.getStudentById(id);
        model.addAttribute("student",student);
        return "bai2_update";
    }

    @PostMapping("/update")
    public String update(Model model , HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        Student student = new Student();
                student.setId(Integer.parseInt(req.getParameter("id")));
                student.setFullName(req.getParameter("fullName"));
                student.setEmail(req.getParameter("email"));
                student.setAddress(req.getParameter("address"));
                student.setPhone(req.getParameter("phone"));
                student.setStatus(Boolean.parseBoolean(req.getParameter("status")));
                studentDAO.updateStudent(student);
               return display(model);
    }

    @GetMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id){
        System.out.println(id);
       studentDAO.deleteStudent(id);
       return display(model);
    }

    @GetMapping("/create")
    public String formCreate(){
        return "bai2_create";
    }

    @PostMapping("create")
    public String create(Model model , HttpServletRequest req) throws UnsupportedEncodingException {
        req.setCharacterEncoding("utf-8");
        Student student = new Student();
        student.setFullName(req.getParameter("fullName"));
        student.setEmail(req.getParameter("email"));
        student.setAddress(req.getParameter("address"));
        student.setPhone(req.getParameter("phone"));
        studentDAO.addStudent(student);
        return display(model);
    }










//    @RequestMapping("/bai2/{action}/{id}")
//    public String bai2(Model model , HttpServletRequest req, @PathVariable("action") String action,@PathVariable("id") int id) throws UnsupportedEncodingException {
//        req.setCharacterEncoding("utf-8");
//        if(action == null){
//            action = "" ;
//        }
//        switch (action){
//            case "create" : {
//                return "bai2_create";
//            }
//            case "update" : {
//                Student student = studentDAO.getStudentById(id);
//                model.addAttribute("student",student);
//                return "bai2_update";
//            }
//            case "delete" : {
//                studentDAO.deleteStudent(id);
//                return displayStudent(model);
//            }
//            default: {
//                return displayStudent(model);
//            }
//        }
//
//    }
//
//    private String displayStudent(Model model) {
//        List<Student> students = studentDAO.getListStudent();
//        model.addAttribute("student",students);
//        return "bai2_display";
//    }
//
//    @PostMapping("/bai2")
//    public String bai2_post(Model model , HttpServletRequest req) throws UnsupportedEncodingException {
//        req.setCharacterEncoding("utf-8");
//        String action = req.getParameter("action");
//        if(action == null){
//            action = "" ;
//        }
//        switch (action){
//            case "create" : {
//                Student student = new Student();
//                student.setFullName(req.getParameter("fullName"));
//                student.setEmail(req.getParameter("email"));
//                student.setAddress(req.getParameter("address"));
//                student.setPhone(req.getParameter("phone"));
//                boolean success = studentDAO.addStudent(student);
//                if(!success){
//                    model.addAttribute("error" , "create error !");
//                }else {
//                    List<Student> students = studentDAO.getListStudent();
//                    model.addAttribute("students",students);
//                    return "bai2_display";
//                }
//                break;
//            }
//            case "update" : {
//                Student student = new Student();
//                student.setId(Integer.parseInt(req.getParameter("id")));
//                student.setFullName(req.getParameter("fullName"));
//                student.setEmail(req.getParameter("email"));
//                student.setAddress(req.getParameter("address"));
//                student.setPhone(req.getParameter("phone"));
//                student.setStatus(Boolean.parseBoolean(req.getParameter("status")));
//                studentDAO.addStudent(student);
//                break;
//            }
//        }
//        List<Student> students = studentDAO.getListStudent();
//        model.addAttribute("students",students);
//        return "bai2_display";
//    }
}
