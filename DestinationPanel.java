import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DestinationPanel extends JPanel {
    private ArrayList<Destination> destinations = new ArrayList<>();

    public DestinationPanel() {
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        JTextField nameField = new JTextField();
        JTextField dateField = new JTextField();
        JTextField costField = new JTextField();
        JButton addBtn = new JButton("Add Destination");

        form.add(new JLabel("Name:"));
        form.add(nameField);
        form.add(new JLabel("Date:"));
        form.add(dateField);
        form.add(new JLabel("Estimated Cost ($):"));
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
}
