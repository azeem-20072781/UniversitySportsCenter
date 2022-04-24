package universitysportscenter;

import java.util.*;

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
            System.out.println("Enter your choice: \n1:Schedule\n2:Check Timetable and Choose Lesson\n3:Show Students\n4:Review Your Lesson\n5:Print Reports\n0:Exit");
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
                        System.out.println(lessonClass.day + " , " + lessonClass.timeOfDay.getTime() + " , Students = " + lessonClass.noOfStudents + " , " + lessonClass.student + " , " + lessonClass.getReview());
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
                    System.out.print("Choose your rating from(1: Very dissatisfied, 2: Dissatisfied, 3: Ok, 4: Satisfied, 5:" + "Very Satisfied): ");
                    int reviewRating = Integer.parseInt(scanner.nextLine());
                    Review review = new Review(reviewString, reviewRating);
                    for (LessonClass lesson : lessonClassesList) {
                        if (lesson.getStudent().getName().equalsIgnoreCase(name) && lesson.getDay().equalsIgnoreCase(day) && lesson.getStudent().getSelectedExercise().contains(exercise)) {
                            lesson.setReview(review);
                            System.out.println("Review Added Successfully");

                        }
                    }

                }
                case 5 -> {
                    //TODO print reports
                    System.out.println("Choose Report To Print: 1:Report 1\n2:Report 2");
                    int reportNumber = Integer.parseInt(scanner.nextLine());
                    //a report containing the number of students per group exercise lesson on each day, along with the
                    //average rating;
                    int  countSaturday = 0, countSunday = 0, saturdayRating = 0, sundayRating = 0;
                    //a report containing the number of students per group exercise lesson on each day, along with the
                    //average rating;
                    if (reportNumber == 1) {

                        TreeMap<String, Integer> map = new TreeMap<>();
                        //getting rating for Saturday along with number of studnets

                        for (LessonClass lessonClass : lessonClassesList) {
                            String exercise = lessonClass.getStudent().getSelectedExercise().get(0).getName();
                            String key = ("Saturday," + exercise + "," + lessonClass.getTimeOfDay().getTime());
                            map.put(key, lessonClass.getNoOfStudents());
                            countSaturday += 1;
                            saturdayRating += lessonClass.getReview().getReviewRating();
                        }
                        //getting rating for Sunday along with number of studnets
                        for (LessonClass lessonClass : lessonClassesList) {
                            String exercise = lessonClass.getStudent().getSelectedExercise().get(0).getName();
                            String key = ("Sunday," + exercise + "," + lessonClass.getTimeOfDay().getTime());
                            countSunday += 1;
                            sundayRating += lessonClass.getReview().getReviewRating();
                            map.put(key, lessonClass.getNoOfStudents());
                        }
                            //calculating average for separate days
                        for (String key : map.keySet()) {
                            if (key.contains("Saturday"))
                                System.out.println(key + " " + map.get(key) + " - Average Rating: " + saturdayRating / countSaturday);
                            if (key.contains("Sunday"))
                                System.out.println(key + " " + map.get(key) + " - Average Rating: " + sundayRating / countSunday);
                        }
                    }
                    //a report containing the group exercise which has generated the highest income, counting all the
                    //same exercise lessons together.
                    else if (reportNumber == 2) {
                        //separating exercise and its cose with number of students enrolled
                        TreeMap<String, Integer> costMap = new TreeMap<>();
                        for (LessonClass lessonClass : lessonClassesList) {
                            Exercise exercise = lessonClass.getStudent().getSelectedExercise().get(0);
                            String exerciseName = exercise.getName();
                            costMap.put(exerciseName + "," + lessonClass.getNoOfStudents(), exercise.getPrice());
                        }
                        //calculating total price
                        for (String key : costMap.keySet()) {
                            String[] keyParsed = key.split(",");
                            int noOfStudents = Integer.parseInt(keyParsed[1]);
                            int price = costMap.get(key);
                            int totalPrice = noOfStudents * price;

                            costMap.put(key, totalPrice);
                        }
                        //getting key with max price and printing it along price
                        String key = Collections.max(costMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
                        System.out.println(key.substring(0, key.indexOf(",")) + " , Price: " + costMap.get(key));
                    }
                }
            }
            if (choice != 0) {
                System.out.println("Do you want to perform another action(1/0)?");
                choice = Integer.parseInt(scanner.nextLine());
            } else System.out.println("Thank you for using this system");
        } while (choice == 1);

    }

    /**
     * it adds dummy data to application
     *
     * @param lessonClassesList list containing data of all students
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
     * @param max limit upto which the random number will be generated
     * @return a random number
     */
    private static int getRandomNumber(int max) {
        Random random = new Random();
        return random.ints(1, max).findFirst().getAsInt();
    }

    /**
     * it takes exercise from user whichever he wants to select
     *
     * @param exerciseNumber it is the exercise number selected by student
     * @return Exercise as per the exercise number
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
     * @param scanner object of student to take input from user
     * @return TimeOfDay it is the time of the day as selected by student
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
     * @param scanner object of student to take input from user
     * @return the exercise number selected by the student
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
