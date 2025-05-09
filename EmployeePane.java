import javax.swing.*;
import java.awt.*;

public class EmployeePane extends JFrame {

    public EmployeePane(Employee employee) {
        // Frame settings
        setTitle("Design Preview [EmployeePanel]");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create panel and layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Row 1 - Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Name : "), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel( employee.getFirstName()+ " "+ employee.getMiddleName()+" "+employee.getLastName() ), gbc);

        // Row 2 - Designation
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Designation"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel(employee.getDesignation()), gbc);

        // Row 3 - Total Leaves
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Total Leaves"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel(String.valueOf(employee.leavesTotal)), gbc);

        // Row 4 - Balance Leaves
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Balance Leaves"), gbc);

        gbc.gridx = 1;
        panel.add(new JLabel(String.valueOf(employee.leavesAvailable)), gbc);

        // Row 1 - Manager
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(new JLabel("Manager"), gbc);

        gbc.gridx = 3;
        panel.add(new JLabel("No"), gbc);

        // Row 2 - Leaves Used
        gbc.gridx = 2;
        gbc.gridy = 1;
        panel.add(new JLabel("Leaves Used"), gbc);

        gbc.gridx = 3;
        panel.add(new JLabel(String.valueOf( employee.leavesTotal - employee.leavesAvailable)), gbc);

        // Row 5 - Buttons
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        panel.add(new JButton("Apply Leave"), gbc);

        gbc.gridx = 1;
        panel.add(new JButton("View Leave Status"), gbc);

        gbc.gridx = 2;
        panel.add(new JButton("View Leaves"), gbc);

        // Add panel to frame
        add(panel);
    }
}
