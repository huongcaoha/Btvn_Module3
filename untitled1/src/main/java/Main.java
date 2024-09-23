import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Connection getConnection (){
        try {
            String url = "jdbc:mysql://localhost:3307/demo_module3";
            String username = "root" ;
            String password = "12345678";
            Connection connection = DriverManager.getConnection(url,username,password);
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
            return null ;
        }
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        String query = "select * from students";
        try (Connection connection = getConnection() ;
             PreparedStatement preparedStatement = connection.prepareStatement(query);
        ){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("studentName");
                int gender = rs.getInt("gender");
                int age = rs.getInt("age");
                String phone = rs.getString("phone");
                Student student= new Student(name,gender,age,phone);
                students.add(student);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        for(Student student : students){
            System.out.println(student.toString());
        }
    }
}
