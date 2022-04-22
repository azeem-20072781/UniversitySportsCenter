package universitysportscenter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*************Lessons available****************");


        System.out.println("**********************************************");
        int choice;
        do {
            System.out.println("Enter your choice: \n1:Schedule\n2:Choose Exercise\n0:Exit");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.println("Schedule is: ");

            } else if (choice == 2) {
                Exercise[] values = Exercise.values();
                for (int i = 0; i < values.length; i++) {
                    Exercise exercise = values[i];
                    System.out.println((i + 1) + ") Exercise Name: " + exercise.getName() + " , Price: " + exercise.getPrice());
                }
                System.out.print("Enter Exercise Number: ");
                int exerciseNumber = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter Student Name: ");
                String studentName = scanner.nextLine();

            }

            System.out.println("Do you want to perform another action(1/0)?");
            choice = Integer.parseInt(scanner.nextLine());
        } while (choice == 1);


//        System.out.println("Check Time Table by entering day name (Saturday/Sunday): ");
//        String day = scanner.nextLine();
//        System.out.println("Time table for " + day + " is: ");

    }
}
