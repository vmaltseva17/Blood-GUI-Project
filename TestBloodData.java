import javax.swing.*;
import java.util.Scanner;

public class TestBloodData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BloodData defaultBloodData = new BloodData();

        // Prompt the user for values for the second object
        BloodData.BloodType user_bloodtype = BloodData.BloodType.valueOf(JOptionPane.showInputDialog("Enter your blood type (A, B, O, AB)"));
        BloodData.RhFactor user_rhFactor = BloodData.RhFactor.valueOf(JOptionPane.showInputDialog("Enter your blood rh factor (POSITIVE, NEGATIVE)"));
        BloodData userBloodData = new BloodData(user_bloodtype, user_rhFactor);

        // Display the details of both objects
        displayBloodData("Default Blood Data", defaultBloodData);
        displayBloodData("User Blood Data", userBloodData);

        // Change the values in the default object using user's values
        defaultBloodData.setBloodType(user_bloodtype);
        defaultBloodData.setRhFactor(user_rhFactor);

        // Display the details for the default object again to confirm the changes
        displayBloodData("Updated Default Blood Data", defaultBloodData);
    }
    public static BloodData getUserBloodData(){
        BloodData.BloodType user_bloodtype = BloodData.BloodType.valueOf(JOptionPane.showInputDialog("Enter your blood type (A, B, O, AB)"));
        BloodData.RhFactor user_rhFactor = BloodData.RhFactor.valueOf(JOptionPane.showInputDialog("Enter your blood rh factor (POSITIVE, NEGATIVE)"));
        return new BloodData(user_bloodtype, user_rhFactor);
    }
    private static void displayBloodData(String title, BloodData bloodData) {
        System.out.println("\n" + title + ":");
        System.out.println("Blood Type: " + bloodData.getBloodType());
        System.out.println("Rh Factor: " + bloodData.getRhFactor());
    }
}