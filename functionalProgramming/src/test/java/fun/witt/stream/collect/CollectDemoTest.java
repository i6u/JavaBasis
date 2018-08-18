package fun.witt.stream.collect;

import org.junit.Before;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 收集器
 * */
public class CollectDemoTest {
    private List<Student> students;

    @Before
    public void before() {
        students = new CollectDemo().generateStudents(100);
    }

    @Test
    public void fun() {
        students.stream().forEach(System.out::println);
    }

    @Test
    public void fun1() {
        // option + command + v 快速补齐声明
        IntSummaryStatistics ageSummaryStatistics = students.stream().collect(Collectors.summarizingInt(Student::getAge));
        System.out.println("年龄汇总：" + ageSummaryStatistics);
    }

    @Test
    public void fun2() {
        // 分块
        Map<Boolean, List<Student>> collect = students.stream().collect(Collectors.partitioningBy(o -> o.getGender() == Gender.FEMALE));
        collect.entrySet().forEach(System.out::println);
    }

    @Test
    public void fun3() {
        // 分组显示班级学生信息
        Map<Grade, List<Student>> gradeListMap = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        gradeListMap.entrySet().forEach(System.out::println);
    }

    @Test
    public void fun4() {
        // 分组统计各班学生总数
        Map<Grade, Long> gradeListMap = students.stream().collect(Collectors.groupingBy(Student::getGrade, Collectors.counting()));
        gradeListMap.entrySet().forEach(System.out::println);
    }
}