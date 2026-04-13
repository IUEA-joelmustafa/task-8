import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JCalendar;
import java.util.Date;

public class EmployeeRegistrationSystem {

    JFrame frame;
    JTextField nameField, emailField;
    JPasswordField passwordField;
    JComboBox<String> departmentBox;
    JCalendar calendar;
    JTree tree;

    public EmployeeRegistrationSystem() {
        frame = new JFrame("Employee Registration System");
        frame.setSize(700, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ===== FORM PANEL =====
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        nameField = new JTextField();
        emailField = new JTextField();
        passwordField = new JPasswordField();

        String[] departments = {"IT", "Finance", "HR", "Marketing"};
        departmentBox = new JComboBox<>(departments);

        calendar = new JCalendar();

        formPanel.add(new JLabel("Full Name:"));
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        formPanel.add(emailField);

        formPanel.add(new JLabel("Password:"));
        formPanel.add(passwordField);

        formPanel.add(new JLabel("Department:"));
        formPanel.add(departmentBox);

        formPanel.add(new JLabel("Date of Birth:"));
        formPanel.add(calendar);

        // ===== TREE PANEL =====
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Company");

        DefaultMutableTreeNode it = new DefaultMutableTreeNode("IT");
        it.add(new DefaultMutableTreeNode("Developers"));
        it.add(new DefaultMutableTreeNode("Support"));

        DefaultMutableTreeNode hr = new DefaultMutableTreeNode("HR");
        hr.add(new DefaultMutableTreeNode("Recruitment"));

        DefaultMutableTreeNode finance = new DefaultMutableTreeNode("Finance");
        DefaultMutableTreeNode marketing = new DefaultMutableTreeNode("Marketing");

        root.add(it);
        root.add(hr);
        root.add(finance);
        root.add(marketing);

        tree = new JTree(root);

        JPanel treePanel = new JPanel(new BorderLayout());
        treePanel.add(new JLabel("Organization Structure:"), BorderLayout.NORTH);
        treePanel.add(new JScrollPane(tree), BorderLayout.CENTER);

        // ===== BUTTONS =====
        JButton submitBtn = new JButton("Submit");
        JButton clearBtn = new JButton("Clear");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(submitBtn);
        buttonPanel.add(clearBtn);

        // ===== ADD TO FRAME =====
        frame.add(formPanel, BorderLayout.CENTER);
        frame.add(treePanel, BorderLayout.WEST);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // ===== BUTTON LOGIC =====

        submitBtn.addActionListener(e -> handleSubmit());
        clearBtn.addActionListener(e -> clearForm());

        frame.setVisible(true);
    }

    private void handleSubmit() {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String department = (String) departmentBox.getSelectedItem();
        Date dob = calendar.getDate();

        // Validation
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Hide password
        String hiddenPassword = "******";

        // Selected Tree Node
        Object selectedNode = tree.getLastSelectedPathComponent();
        String org = (selectedNode != null) ? selectedNode.toString() : "Not selected";

        // Summary
        String message = "Registration Successful!\n\n"
                + "Name: " + name + "\n"
                + "Email: " + email + "\n"
                + "Password: " + hiddenPassword + "\n"
                + "Department: " + department + "\n"
                + "DOB: " + dob + "\n"
                + "Organization: " + org;

        JOptionPane.showMessageDialog(frame, message);
    }

    private void clearForm() {
        nameField.setText("");
        emailField.setText("");
        passwordField.setText("");
        departmentBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        new EmployeeRegistrationSystem();
    }
}