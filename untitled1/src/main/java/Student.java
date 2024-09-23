public class Student {
    private String studentName ;
    private int gender ;
    private int age ;
    private String phone ;

    public Student() {
    }

    public Student(String studentName, int gender, int age, String phone) {
        this.studentName = studentName;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
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

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
