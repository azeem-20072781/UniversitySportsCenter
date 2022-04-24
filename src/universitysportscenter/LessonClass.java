package universitysportscenter;

/**
 * The type Lesson class.
 */
public class LessonClass {
    /**
     * The Student.
     */
    Student student;
    /**
     * The Day.
     */
    String day;
    /**
     * The No of students.
     */
    int noOfStudents;
    /**
     * The Time of day.
     */
    TimeOfDay timeOfDay;
    /**
     * The Review.
     */
    Review review;

    /**
     * Instantiates a new Lesson class.
     *
     * @param student      the student
     * @param day          the day
     * @param noOfStudents the no of students
     * @param timeOfDay    the time of day
     * @param review       the review
     */
    public LessonClass(Student student, String day, int noOfStudents, TimeOfDay timeOfDay, Review review) {
        this.student = student;
        this.day = day;
        this.noOfStudents = noOfStudents;
        this.timeOfDay = timeOfDay;
        this.review = review;
    }

    /**
     * Gets student.
     *
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Gets day.
     *
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * Gets no of students.
     *
     * @return the no of students
     */
    public int getNoOfStudents() {
        return noOfStudents;
    }

    /**
     * Gets time of day.
     *
     * @return the time of day
     */
    public TimeOfDay getTimeOfDay() {
        return timeOfDay;
    }

    /**
     * Gets review.
     *
     * @return the review
     */
    public Review getReview() {
        return review;
    }
}
