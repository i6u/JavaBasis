package fun.witt.stream.collect;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author witt
 * @fileName CollectDemo
 * @date 2018/8/19 01:07
 * @description
 * @history <author>    <time>    <version>    <desc>
 */

public class CollectDemo {

    public List<Student> generateStudents(int count) {
        return Stream.generate(() -> new Random().nextInt(52))
                .limit(count)
                .distinct()
                .filter(integer -> (integer + 65) <= 91 || (integer + 65) >= 97)
                .map(CollectDemo::setAgeGender)
                .collect(Collectors.toList());
    }

    private static Student setAgeGender(int age) {
        Student student = new Student();
        student.setName("学生 " + String.valueOf((char) (age + 65)));
        student.setAge(age);
        student.setGender(age % 2 == 0 ? Gender.MALE : Gender.FEMALE);
        student.setGrade(age > 20 ? Grade.FOUR : age > 15 ? Grade.THREE : age > 10 ? Grade.TWO : Grade.ONE);
        return student;
    }
}
