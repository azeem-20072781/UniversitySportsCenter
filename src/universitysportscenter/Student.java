package universitysportscenter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Student.
 */
public class Student {
    /**
     * The Name.
     */
    String name;
    /**
     * The Selected exercise.
     */
    ArrayList<Exercise> selectedExercise;

    /**
     * Instantiates a new Student.
     */
    public Student() {
    }

    /**
     * Instantiates a new Student.
     *
     * @param name             the name
     * @param selectedExercise the selected exercise
     */
    public Student(String name, ArrayList<Exercise> selectedExercise) {
        this.name = name;
        this.selectedExercise = selectedExercise;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets selected exercise.
     *
     * @return the selected exercise
     */
    public ArrayList<Exercise> getSelectedExercise() {
        return selectedExercise;
    }

    @Override
    public String toString() {
        return "Student name='" + getName() + '\'' + ", selectedExercise= " + Arrays.toString(getSelectedExercise().toArray());
    }
}
