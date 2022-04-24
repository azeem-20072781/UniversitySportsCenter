package universitysportscenter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<LessonClass> lessonClassesList = new ArrayList<>();
        int choice;
        do {
            System.out.println("Enter your choice: \n1:Schedule\n2:Choose Exercise\n0:Exit");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> {
                    System.out.println("Search by:\n1:Day Name\n2:Exercise Name ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice == 1) {
                        System.out.print("Enter Day Name(Saturday/Sunday): ");
                        String dayName = scanner.nextLine();
                        //TODO show time table by day name

                    } else if (choice == 2) {
                        int exerciseNumber = displayAndChooseExercise(scanner);
                        //TODO show time table by exercise
                    } else System.out.println("Invalid choice");
                }
                case 2 -> {
                    //TODO choose and store exercise
                    int exerciseNumber = displayAndChooseExercise(scanner);
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();

                    Exercise exercise = getExercise(exerciseNumber);
                    TimeOfDay timeOfDay = getTimeOfDay(scanner);

                    ArrayList<Exercise> exerciseArrayList = new ArrayList<>();
                    exerciseArrayList.add(exercise);
                    Student student = new Student(studentName, exerciseArrayList);
                    LessonClass lessonClass = new LessonClass(student, "day", 0, timeOfDay, null);
                    lessonClassesList.add(lessonClass);
                    System.out.println("Added Success Fully");
                }
                case 3 -> {
                    for (LessonClass lessonClass : lessonClassesList) {
                        System.out.println(lessonClass.day+" "+lessonClass.timeOfDay.getTime()+" "+lessonClass.noOfStudents+" "+lessonClass.student);
                    }
                }
            }

            System.out.println("Do you want to perform another action(1/0)?");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice == 1);

    }

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
