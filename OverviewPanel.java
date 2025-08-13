import java.awt.*;
import javax.swing.*;

public class OverviewPanel extends JPanel {
    private JLabel totalEstimatedLabel;
    private JLabel totalBudgetLabel;
    private JButton refreshBtn;

    public OverviewPanel() {
        setLayout(new GridLayout(3, 1, 10, 10));

        totalEstimatedLabel = new JLabel("Total Estimated Cost: $0.00");
        totalBudgetLabel = new JLabel("Total Actual Budget: $0.00");
        refreshBtn = new JButton("Refresh Overview");

        refreshBtn.addActionListener(e -> updateOverview());

        add(totalEstimatedLabel);
        add(totalBudgetLabel);
        add(refreshBtn);
    }

    private void updateOverview() {
        double estimatedSum = 0;
        // Sum estimated cost from DestinationPanel's destinations
        if (DestinationPanel.class != null) {
            try {
                // Access the destinations list reflectively (simpler way is a shared manager)
                java.lang.reflect.Field field = DestinationPanel.class.getDeclaredField("destinations");
                field.setAccessible(true);
                java.util.ArrayList<Destination> dests = (java.util.ArrayList<Destination>) field.get(getParent().getComponent(0));
                for (Destination d : dests) {
                    estimatedSum += d.getEstimatedCost();
                }
            } catch (Exception e) {
                // fallback if reflection fails
                estimatedSum = 0;
            }
        }

        totalEstimatedLabel.setText(String.format("Total Estimated Cost: $%.2f", estimatedSum));

        double actualBudget = (BudgetPanel.currentBudget != null) ? BudgetPanel.currentBudget.getTotal() : 0;
        totalBudgetLabel.setText(String.format("Total Actual Budget: $%.2f", actualBudget));
    }
}
