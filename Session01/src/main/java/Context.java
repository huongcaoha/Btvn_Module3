import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Context {
    public static Connection getConnect(){
      String url = "jdbc:mysql://localhost:3307/demo_module3";
      String username = "root";
      String password = "12345678" ;
      try {
          Connection connection = DriverManager.getConnection(url,username,password);
          System.out.println("Connect success !");
          return connection;
      }catch (SQLException e){
          e.printStackTrace();
          System.err.println("Connect error !");
          return null ;
      }
    }

    public static void addStudent(Student student){
        String query = "insert into students(studentName,gender,age,phone)" +
                "values(?,?,?,?)";
        try (Connection connection = getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            preparedStatement.setString(1,student.getStudentName());
            preparedStatement.setInt(2,student.getGender());
            preparedStatement.setInt(3,student.getAge());
            preparedStatement.setString(4,student.getPhone());
            int rs = preparedStatement.executeUpdate();
            if(rs > 0){
                System.out.println("Add success !");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Student student1 = new Student(4,"Nguyễn Văn Khánh",1,32,"0367508795","asdsahjdkasda@gmail.com");
        addStudent(student1);
        List<Student> students = new ArrayList<>();
        Connection connection = getConnect();
        String query ="select * from students";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query) ){
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("studentName");
                    int gender = rs.getInt("gender");
                    int age = rs.getInt("age");
                    String phone = rs.getString("phone");
                    String email = "example@gmail.com";
                    Student student = new Student(id,name,gender,age,phone,email);
                    students.add(student);
                }
        }catch (SQLException e){
            e.printStackTrace();
        }
        if(students.isEmpty()){
            System.err.println("List student is empty !");
        }else {
            for (Student student : students){
                System.out.println(student.toString());
            }
        }

    }


}
