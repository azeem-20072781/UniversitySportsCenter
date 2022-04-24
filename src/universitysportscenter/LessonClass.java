package universitysportscenter;

public class LessonClass {
    Student student;
    String day;
    int noOfStudents;
    TimeOfDay timeOfDay;
    Review review;

    public LessonClass(Student student, String day, int noOfStudents, TimeOfDay timeOfDay, Review review) {
        this.student = student;
        this.day = day;
        this.noOfStudents = noOfStudents;
        this.timeOfDay = timeOfDay;
        this.review = review;
    }

    public Student getStudent() {
        return student;
    }

    public String getDay() {
        return day;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    public Review getReview() {
        return review;
    }
}
