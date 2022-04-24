package universitysportscenter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * The type Main.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<LessonClass> lessonClassesList = new ArrayList<>();
        addStudentsData(lessonClassesList);

        int choice;
        do {
            System.out.println("Enter your choice: \n1:Schedule\n2:Check Timetable and Choose Lesson\n3:Show Students\n4:Review Your Lesson\n0:Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("Search by:\n1:Day Name\n2:Exercise Name ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        System.out.print("Enter Day Name(Saturday/Sunday): ");
                        String dayName = scanner.nextLine();
                        for (LessonClass lessonClass : lessonClassesList) {
                            if (lessonClass.getDay().equalsIgnoreCase(dayName)) {
                                System.out.println("Time: " + lessonClass.getTimeOfDay() + " Space Left: " + (4 - lessonClass.getNoOfStudents()) + " ");
                            }
                        }

                    } else if (choice == 2) {
                        int exerciseNumber = displayAndChooseExercise(scanner);
                        Exercise exercise = getExercise(exerciseNumber);
                        for (LessonClass lessonClass : lessonClassesList) {
                            if (lessonClass.getStudent().getSelectedExercise().contains(exercise)) {
                                System.out.println("Time: " + lessonClass.getTimeOfDay() + " Space Left: " + (4 - lessonClass.getNoOfStudents()) + " ");
                            }
                        }
                    } else System.out.println("Invalid choice");
                }
                case 2 -> {
                    int exerciseNumber = displayAndChooseExercise(scanner);
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();

                    Exercise exercise = getExercise(exerciseNumber);
                    TimeOfDay timeOfDay = getTimeOfDay(scanner);

                    ArrayList<Exercise> exerciseArrayList = new ArrayList<>();
                    exerciseArrayList.add(exercise);
                    Student student = new Student(studentName, exerciseArrayList);
                    LessonClass lessonClass = new LessonClass(student, "day", 1, timeOfDay, null);
                    lessonClassesList.add(lessonClass);
                    System.out.println("Added Success Fully");
                }
                case 3 -> {
                    for (LessonClass lessonClass : lessonClassesList) {
                        System.out.println(lessonClass.day + " , " + lessonClass.timeOfDay.getTime() + " , Students = " + lessonClass.noOfStudents +
                                " , " + lessonClass.student + " , " +
                                lessonClass.getReview());
                    }
                }
                case 4 -> {
                    System.out.print("Enter Your Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Day: ");
                    String day = scanner.nextLine();
                    System.out.print("Choose Exercise: ");
                    int exerciseNumber = displayAndChooseExercise(scanner);
                    Exercise exercise = getExercise(exerciseNumber);

                    System.out.print("Enter your review: ");
                    String reviewString = scanner.nextLine();
                    System.out.print("Choose your rating from(1: Very dissatisfied, 2: Dissatisfied, 3: Ok, 4: Satisfied, 5:" +
                            "Very Satisfied): ");
                    int reviewRating = Integer.parseInt(scanner.nextLine());
                    Review review = new Review(reviewString, reviewRating);
                    for (LessonClass lesson : lessonClassesList) {
                        if (lesson.getStudent().getName().equalsIgnoreCase(name) && lesson.getDay().equalsIgnoreCase(day) && lesson.getStudent().getSelectedExercise().contains(exercise)) {
                            lesson.setReview(review);
                            System.out.println("Review Added Successfully");

                        }
                    }

                }
            }
            if (choice != 0) {
                System.out.println("Do you want to perform another action(1/0)?");
                choice = Integer.parseInt(scanner.nextLine());
            }else System.out.println("Thank you for using this system");
        } while (choice == 1);

    }

    /**
     * it adds dummy data to application
     *
     * @param lessonClassesList
     */
    private static void addStudentsData(ArrayList<LessonClass> lessonClassesList) {
        for (int i = 0; i < 10; i++) {

            int time = getRandomNumber(3);
            int rating = getRandomNumber(5);
            int day = getRandomNumber(2);
            int exerciseNumber = getRandomNumber(5);
            Exercise exercise = getExercise(exerciseNumber);
            String dayName = null;
            if (day == 1) dayName = "Saturday";
            else if (day == 2) dayName = "Sunday";


            TimeOfDay timeOfDay = null;
            if (time == 1) timeOfDay = TimeOfDay.MORNING;
            else if (time == 2) timeOfDay = TimeOfDay.AFTERNOON;
            else if (time == 3) timeOfDay = TimeOfDay.EVENING;

            ArrayList<Exercise> selectedExercise = new ArrayList<>();
            selectedExercise.add(exercise);

            Student student = new Student("Student " + (i + 1), selectedExercise);
            Review review = new Review("dummy review ", rating);
            LessonClass lessonClass = new LessonClass(student, dayName, 1, timeOfDay, review);


            lessonClassesList.add(lessonClass);

        }
    }

    /**
     * it generates random numbers
     *
     * @param max
     * @return
     */
    private static int getRandomNumber(int max) {
        Random random = new Random();
        return random.ints(1, max)
                .findFirst()
                .getAsInt();
    }

    /**
     * it takes exercise from user whichever he wants to select
     *
     * @param exerciseNumber
     * @return Exercise
     */
    private static Exercise getExercise(int exerciseNumber) {
        Exercise exercise = null;
        if (exerciseNumber == 1) exercise = Exercise.YOGA;
        else if (exerciseNumber == 2) exercise = Exercise.ZUMBA;
        else if (exerciseNumber == 3) exercise = Exercise.AQUACISE;
        else if (exerciseNumber == 4) exercise = Exercise.BOX_FIT;
        else if (exerciseNumber == 5) exercise = Exercise.BODY_BLITZ;
        else System.out.println("Unexpected value: " + exerciseNumber);
        return exercise;
    }

    /**
     * it takes the time of day from user for lesson
     *
     * @param scanner
     * @return TimeOfDay
     */
    private static TimeOfDay getTimeOfDay(Scanner scanner) {
        System.out.println("Select time of day:1:Morning, 2: Afternoon. 3:Evening ");
        int time = Integer.parseInt(scanner.nextLine());
        TimeOfDay timeOfDay = null;
        if (time == 1) {
            timeOfDay = TimeOfDay.MORNING;

        } else if (time == 2) {
            timeOfDay = TimeOfDay.AFTERNOON;

        } else if (time == 3) timeOfDay = TimeOfDay.EVENING;
        return timeOfDay;
    }

    /**
     * it displays exercises to user and takes input for whichever exercise they want to proceed with
     *
     * @param scanner
     * @return
     */
    private static int displayAndChooseExercise(Scanner scanner) {
        Exercise[] values = Exercise.values();
        for (int i = 0; i < values.length; i++) {
            Exercise exercise = values[i];
            System.out.println((i + 1) + ") Exercise Name: " + exercise.getName() + " , Price: " + exercise.getPrice());
        }
        System.out.print("Enter Exercise Number: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
