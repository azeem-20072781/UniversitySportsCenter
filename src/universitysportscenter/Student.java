package universitysportscenter;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    String name;
    ArrayList<Exercise> selectedExercise;

    public Student() {
    }

    public Student(String name, ArrayList<Exercise> selectedExercise) {
        this.name = name;
        this.selectedExercise = selectedExercise;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Exercise> getSelectedExercise() {
        return selectedExercise;
    }

    @Override
    public String toString() {
        return "Student name='" + getName() + '\'' + ", selectedExercise= " + Arrays.toString(getSelectedExercise().toArray());
    }
}
