import java.awt.*;
import javax.swing.*;

public class OverviewPanel extends JPanel {
    private JLabel totalEstimatedLabel;
    private JLabel totalBudgetLabel;
    private JButton refreshBtn;

    public OverviewPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createTitledBorder("Overview"));

        JPanel grid = new JPanel(new GridLayout(1, 2, 20, 10));

        totalEstimatedLabel = new JLabel("Total Estimated Cost: ৳ 0.00", SwingConstants.CENTER);
        totalBudgetLabel = new JLabel("Total Actual Budget: ৳ 0.00", SwingConstants.CENTER);

        totalEstimatedLabel.setFont(new Font("Arial", Font.BOLD, 14));
        totalBudgetLabel.setFont(new Font("Arial", Font.BOLD, 14));

        grid.add(totalEstimatedLabel);
        grid.add(totalBudgetLabel);

        refreshBtn = new JButton("🔄 Refresh Overview");
        styleButton(refreshBtn);

        refreshBtn.addActionListener(e -> updateOverview());

        add(grid, BorderLayout.CENTER);
        add(refreshBtn, BorderLayout.SOUTH);
    }

    private void updateOverview() {
        double estimatedSum = 0;
        if (DestinationPanel.class != null) {
            try {
                java.lang.reflect.Field field = DestinationPanel.class.getDeclaredField("destinations");
                field.setAccessible(true);
                java.util.ArrayList<Destination> dests =
                    (java.util.ArrayList<Destination>) field.get(getParent().getComponent(0));
                for (Destination d : dests) {
                    estimatedSum += d.getEstimatedCost();
                }
            } catch (Exception e) {
                estimatedSum = 0;
            }
        }

        totalEstimatedLabel.setText(String.format("Total Estimated Cost: $%.2f", estimatedSum));
        double actualBudget = (BudgetPanel.currentBudget != null) ? BudgetPanel.currentBudget.getTotal() : 0;
        totalBudgetLabel.setText(String.format("Total Actual Budget: $%.2f", actualBudget));
    }

    private void styleButton(JButton btn) {
        btn.setBackground(new Color(0, 120, 215));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 13));
    }
}
