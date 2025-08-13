import java.awt.*;
import javax.swing.*;

public class BudgetPanel extends JPanel {
    public static Budget currentBudget;

    public BudgetPanel() {
        setLayout(new GridLayout(5, 2, 5, 5));

        JTextField transportField = new JTextField();
        JTextField accommodationField = new JTextField();
        JTextField foodField = new JTextField();
        JTextField activitiesField = new JTextField();
        JButton saveBtn = new JButton("Save Budget");

        add(new JLabel("Transportation ($):"));
        add(transportField);
        add(new JLabel("Accommodation ($):"));
        add(accommodationField);
        add(new JLabel("Food ($):"));
        add(foodField);
        add(new JLabel("Activities ($):"));
        add(activitiesField);
        add(new JLabel());
        add(saveBtn);

        saveBtn.addActionListener(e -> {
            try {
                double t = Double.parseDouble(transportField.getText().trim());
                double a = Double.parseDouble(accommodationField.getText().trim());
                double f = Double.parseDouble(foodField.getText().trim());
                double act = Double.parseDouble(activitiesField.getText().trim());

                if (t < 0 || a < 0 || f < 0 || act < 0) {
                    JOptionPane.showMessageDialog(this, "Budget values cannot be negative.");
                    return;
                }

                currentBudget = new Budget(t, a, f, act);
                JOptionPane.showMessageDialog(this, "Budget saved!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers.");
            }
        });
    }
}
