package fun.witt.stream.collect;

import java.util.function.Supplier;

/**
 * @author witt
 * @fileName Student
 * @date 2018/8/19 01:07
 * @description
 * @history <author>    <time>    <version>    <desc>
 */

public class Student {

    private String name;
    private int age;
    private Gender gender;
    private Grade grade;

    public Student(String name, int age, Gender gender, Grade grade) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.grade = grade;
    }

    public Student() {
    }

    public Student(Supplier<Student> studentSupplier) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", grade=" + grade +
                '}';
    }
}
enum Gender{
    MALE,FEMALE
}
enum Grade{
    ONE,TWO,THREE,FOUR
}