package com.ra.dao.impl;

import com.ra.connectDB.Database;
import com.ra.dao.StudentDAO;
import com.ra.model.entity.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> getListStudent() {
        List<Student> students = new ArrayList<>();
        String query = "call proc_get_list();";
        try (Connection connection = Database.getConnect();
             CallableStatement statement = connection.prepareCall(query)
            ){
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setFullName(rs.getString("fullName"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                student.setPhone(rs.getString("phone"));
                student.setStatus(rs.getBoolean("status"));
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean addStudent(Student student) {
        String query = "{call proc_add_student(?,?,?,?)} ;";
        try (Connection connection = Database.getConnect();
            CallableStatement statement = connection.prepareCall(query);
            ){
            statement.setString(1,student.getFullName());
            statement.setString(2,student.getEmail());
            statement.setString(3,student.getAddress());
            statement.setString(4,student.getPhone());
            int rs = statement.executeUpdate();
            if(rs > 0){
                return true ;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public boolean updateStudent(Student student) {
        String query = "{call proc_update_student(?,?,?,?,?,?)} ;";
        try (Connection connection = Database.getConnect();
             CallableStatement statement = connection.prepareCall(query);
        ){
            statement.setInt(1,student.getId());
            statement.setString(2,student.getFullName());
            statement.setString(3,student.getEmail());
            statement.setString(4,student.getAddress());
            statement.setString(5,student.getPhone());
            statement.setBoolean(6,student.isStatus());
            int rs = statement.executeUpdate();
            if(rs > 0){
                return true ;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public boolean deleteStudent(int id) {
        String query = "{call proc_delete_student(?)} ;";
        try (Connection connection = Database.getConnect();
             CallableStatement statement = connection.prepareCall(query);
        ){
            statement.setInt(1,id);
            int rs = statement.executeUpdate();
            if(rs > 0){
                return true ;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false ;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = new Student();
        String query = "{call proc_get_student_by_Id(?)} ;";
        try (Connection connection = Database.getConnect();
             CallableStatement statement = connection.prepareCall(query);
        ){
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                student.setId(rs.getInt("id"));
                student.setFullName(rs.getString("fullName"));
                student.setEmail(rs.getString("email"));
                student.setAddress(rs.getString("address"));
                student.setPhone(rs.getString("phone"));
                student.setStatus(rs.getBoolean("status"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return student ;
    }

}
