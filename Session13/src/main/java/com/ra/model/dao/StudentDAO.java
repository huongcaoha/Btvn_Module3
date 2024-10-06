package com.ra.model.dao;

import com.ra.model.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class StudentDAO {

    private Session session;

    public StudentDAO() {
        session = new Configuration().configure().buildSessionFactory().openSession();
    }

    public void saveStudent(Student student) {
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    public List<Student> getAllStudents() {
        return session.createQuery("FROM Student", Student.class).list();
    }

    public Student getStudentById(Long id) {
        return session.get(Student.class, id);
    }

    public void updateStudent(Student student) {
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
    }

    public void deleteStudent(Long id) {
        Transaction transaction = session.beginTransaction();
        Student student = getStudentById(id);
        if (student != null) {
            session.delete(student);
        }
        transaction.commit();
    }

    public void close() {
        session.close();
    }

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        // Tạo và lưu sinh viên mới
        Student student = new Student();
        student.setFullName("John Doe");
        student.setEmail("john.doe@example.com");
        studentDAO.saveStudent(student);

        // Lấy danh sách sinh viên
        List<Student> students = studentDAO.getAllStudents();
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getFullName() + ", Email: " + s.getEmail());
        }

        // Đóng session
        studentDAO.close();
    }
}