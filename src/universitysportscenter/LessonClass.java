package universitysportscenter;

import java.util.ArrayList;

public class LessonClass {
    Student student;
    String day;
    int noOfStudents;
    TimeOfDay timeOfDay; //1= morning, 2=afternoon, 3=evening
    Review review;

    public LessonClass(Student student, String day, int noOfStudents, TimeOfDay timeOfDay, Review review) {
        this.student = student;
        this.day = day;
        this.noOfStudents = noOfStudents;
        this.timeOfDay = timeOfDay;
        this.review = review;
    }
}
