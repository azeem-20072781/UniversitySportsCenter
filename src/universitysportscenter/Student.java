package universitysportscenter;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

public class Student {
    String name;
    ArrayList<Exercise> selectedExercise;

    @Override
    public String toString() {
        return "Student name='" + name + '\'' + ", selectedExercise=" + String.join(",", (CharSequence) selectedExercise);
    }

    public Student() {
    }

    public Student(String name, ArrayList<Exercise> selectedExercise) {
        this.name = name;
        this.selectedExercise = selectedExercise;
    }
}
