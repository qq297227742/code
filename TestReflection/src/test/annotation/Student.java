package test.annotation;
@Table("tb_student")
public class Student {
    @Field(columnName = "id", type = "int",length = 10)
    private int id;
    @Field(columnName = "sname",type = "varchar",length = 10)
    private String studentName;
    @Field(columnName = "age",type = "varchar",length = 3)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(int id, String studentName, int age) {
        this.id = id;
        this.studentName = studentName;
        this.age = age;
    }

    public Student() {
    }
}
