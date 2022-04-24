package test.universitysportscenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import universitysportscenter.LessonClass;
import universitysportscenter.Main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Apr 25, 2022</pre>
 */
public class MainTest {

    /**
     * Method: addStudentsData(ArrayList<LessonClass> lessonClassesList)
     */
    @Test
    public void testAddStudentsData() {
        try {
            Method method = Main.class.getDeclaredMethod("addStudentsData",
                    ArrayList.class);
            method.setAccessible(true);
        } catch (NoSuchMethodException ignored) {
        }

    }

    /**
     * Method: getRandomNumber(int max)
     */
    @Test
    public void testGetRandomNumber() {

        try {
            Method method = Main.class.getDeclaredMethod("getRandomNumber", int.class);
            method.setAccessible(true);
        } catch (NoSuchMethodException ignored) {
        }

    }

    /**
     * Method: getExercise(int exerciseNumber)
     */
    @Test
    public void testGetExercise() {
        try {
            Method method = Main.class.getMethod("getExercise", int.class);
            method.setAccessible(true);
            method.invoke( 1);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
        }
    }

    /**
     * Method: getTimeOfDay(Scanner scanner)
     */
    @Test
    public void testGetTimeOfDay() {

try { 
   Method method = Main.class.getMethod("getTimeOfDay", Scanner.class);
   method.setAccessible(true); 
   method.invoke(Scanner.class, Scanner.class);
} catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
}
    }

    /**
     * Method: displayAndChooseExercise(Scanner scanner)
     */
    @Test
    public void testDisplayAndChooseExercise() {
try {
   Method method = Main.class.getMethod("displayAndChooseExercise", Scanner.class);
   method.setAccessible(true); 
   method.invoke(Scanner.class);
} catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
}
    }

} 
