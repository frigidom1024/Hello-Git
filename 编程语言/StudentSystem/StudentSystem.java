
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private String gender;
    private String studentNumber;
    private String hobby;
    private double gpa;

    public Student(String name, int age, String gender, String studentNumber, String hobby, double gpa) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.studentNumber = studentNumber;
        this.hobby = hobby;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getHobby() {
        return hobby;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return name+"\t\t"+age+"\t\t"+gender+"\t\t"+studentNumber+"\t\t"+hobby+"\t\t"+gpa;
    }
    public String tString() {
        return name + "," + age + "," +gender +  ","+ studentNumber + "," + hobby + ","+ gpa;
    }

    public static Student fromString(String data) {
        String[] parts = data.split(",");
        return new Student(parts[0], Integer.parseInt(parts[1]), parts[2], parts[3], parts[4], Double.parseDouble(parts[5]));
    }
}

public class StudentSystem {
    private static List<Student> students = new ArrayList<>();
    private static final String FILE_PATH = "D:\\Hello-Git\\编程语言\\StudentSystem\\students.txt";

    public static void loadStudents() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine())!= null) {
                Student student = Student.fromString(line);
                students.add(student);
            }
        } catch (IOException e) {
            System.out.println("载入信息出现异常");
        }
    }

    public static void saveStudents() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Student student : students) {
                writer.write(student.tString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("保存失败");
        }
    }

    public static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入名字:");
        String name = scanner.nextLine();
        System.out.println("输入年龄:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("输入性别");
        String gender = scanner.nextLine();
        System.out.println("输入学号");
        String studentNumber = scanner.nextLine();
        System.out.println("输入爱好");
        String hobby = scanner.nextLine();
        System.out.println("输入绩点");
        double gpa = scanner.nextDouble();
        Student student = new Student(name, age, gender, studentNumber, hobby, gpa);
        students.add(student);
        System.out.println("添加成功");
    }

    public static void deleteStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入要删除学生的学号");
        String studentNumber = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentNumber().equals(studentNumber)) {
                students.remove(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("暂无相关信息");
    }

    public static void sortStudentsByGpa() {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getGpa() < s2.getGpa()) {
                    return -1;
                } else if (s1.getGpa() > s2.getGpa()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("按绩点排列");
    }

    public static void viewStudents() {
        System.out.println("name\tage\tgender\tstudentNumber\thobby\tgpa");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        loadStudents();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 按绩点进行排列");
            System.out.println("4. 查看信息");
            System.out.println("5. 保存并退出");
            System.out.println("请选择:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    sortStudentsByGpa();
                    break;
                case 4:
                    viewStudents();
                    break;
                case 5:
                    saveStudents();
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("暂未开放");
            }
        } while (choice!= 5);
    }
}
