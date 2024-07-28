package student.management.Views;

/**
 *
 * @author thakshara
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.border.EmptyBorder;
import student.management.Models.Student;

public class CustomDailog extends JDialog {

    private JTextField nameField;
    private JTextField ageField;
    private JTextField facultyField;
    private JTextField departmentField;
    private JButton insertButton;
    private JButton cancelButton;

    private Student student;
    final private String addButtonLabel;

    public CustomDailog(Frame parent, String title, String addButtonLabel) {
        super(parent, title, true);
        this.addButtonLabel = addButtonLabel;
        intComponents();

        insertButton.addActionListener((ActionEvent e) -> {

            try {
                final String name = nameField.getText();
                final String age = ageField.getText();
                final String faculty = facultyField.getText();
                final String department = departmentField.getText();
                
                if (name.equals("") || age.equals("") || faculty.equals("") || department.equals("")) {
                    JOptionPane.showMessageDialog(this, "All fields are requiered!",
                            "Student Management System", JOptionPane.WARNING_MESSAGE);
                } else {
                    this.student = new Student(name, Integer.parseInt(age), faculty, department);
                    dispose();
                }
                
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numerical value to Age!",
                        "Student Management System", JOptionPane.ERROR_MESSAGE);
            }

        });

        cancelButton.addActionListener((ActionEvent e) -> {
            dispose();
        });

        setLocationRelativeTo(parent);
    }

    public Student showDialog() {
        setVisible(true);

        return this.student;
    }

    public Student showDialog(Student student) {
        nameField.setText(student.getName());
        ageField.setText(String.valueOf(student.getAge()));
        facultyField.setText(student.getFaculty());
        departmentField.setText(student.getDepartment());
        setVisible(true);

        return this.student;
    }

    private void intComponents() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250, 30));
        panel.add(nameField);
        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        ageField.setPreferredSize(new Dimension(250, 30));
        panel.add(ageField);
        panel.add(new JLabel("Faculty:"));
        facultyField = new JTextField();
        facultyField.setPreferredSize(new Dimension(250, 30));
        panel.add(facultyField);
        panel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        departmentField.setPreferredSize(new Dimension(250, 30));
        panel.add(departmentField);

        insertButton = new JButton(this.addButtonLabel);
        cancelButton = new JButton("Cancel");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(insertButton);
        buttonPanel.add(cancelButton);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
        pack();
    }
}
