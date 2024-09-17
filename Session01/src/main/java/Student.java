import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Student {
    private int Id ;
    private  String studentName ;
    private int gender ;
    private int age ;
    private String phone ;
    private String email ;

    public Student() {
    }

    public Student(int id, String studentName, int gender, int age, String phone, String email) {
        Id = id;
        this.studentName = studentName;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
