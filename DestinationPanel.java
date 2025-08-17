import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class DestinationPanel extends JPanel {
    private ArrayList<Destination> destinations = new ArrayList<>();

    public DestinationPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder("Add Destinations"));

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        JTextField nameField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField costField = new JTextField();

        JButton addBtn = new JButton("➕ Add Destination");
        styleButton(addBtn);

        form.add(new JLabel("Name:"));
        form.add(nameField);
        form.add(new JLabel("Date:"));
        form.add(dateField);
        form.add(new JLabel("Estimated Cost (৳):"));
        form.add(costField);
        form.add(new JLabel());
        form.add(addBtn);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> destinationList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(destinationList);

        addBtn.addActionListener(e -> {
            try {
                String name = nameField.getText().trim();
                String date = dateField.getText().trim();
                double cost = Double.parseDouble(costField.getText().trim());

                if (name.isEmpty() || date.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Please enter name and date.");
                    return;
                }
                if (cost < 0) {
                    JOptionPane.showMessageDialog(this, "Estimated cost cannot be negative.");
                    return;
                }

                Destination dest = new Destination(name, date, cost);
                destinations.add(dest);
                listModel.addElement(name + " (" + date + ") - $" + cost);

                nameField.setText("");
                dateField.setText("");
                costField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter a valid cost.");
            }
        });

        add(form, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void styleButton(JButton btn) {
        btn.setBackground(new Color(0, 120, 215));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
    }
}
