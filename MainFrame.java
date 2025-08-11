import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Budget Travel Planner");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Destinations", new DestinationPanel());
        tabs.addTab("Budget", new BudgetPanel());
        tabs.addTab("Overview", new OverviewPanel());

        add(tabs, BorderLayout.CENTER);
    }
}
