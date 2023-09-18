package ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//学生选课
public class CourseSelectionSystem extends JFrame {
    private JPanel roleSelectionPanel;
    private JButton studentButton;
    private JButton adminButton;
    private ArrayList<String> courses = new ArrayList<>();

    public CourseSelectionSystem() {
        setTitle("Course Selection System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        roleSelectionPanel = new JPanel();
        roleSelectionPanel.setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("请选择角色");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        roleSelectionPanel.add(label);

        studentButton = new JButton("学生");
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStudentCourseSelection();
            }
        });

        adminButton = new JButton("管理员");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminCourseEntry();
            }
        });

        roleSelectionPanel.add(studentButton);
        roleSelectionPanel.add(adminButton);

        getContentPane().add(roleSelectionPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void showStudentCourseSelection() {
        JComboBox<String> courseComboBox = new JComboBox<>(courses.toArray(new String[0]));
        JTextField nameField = new JTextField(15);
        JTextField idField = new JTextField(15);

        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(4, 2));
        studentPanel.add(new JLabel("选择课程:"));
        studentPanel.add(courseComboBox);
        studentPanel.add(new JLabel("学生姓名:"));
        studentPanel.add(nameField);
        studentPanel.add(new JLabel("学生学号:"));
        studentPanel.add(idField);

        int result = JOptionPane.showConfirmDialog(null, studentPanel, "学生选课", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String selectedCourse = (String) courseComboBox.getSelectedItem();
            String studentName = nameField.getText();
            String studentId = idField.getText();

            // 在实际应用中，可以在这里处理选课逻辑，添加选课记录等操作
            JOptionPane.showMessageDialog(null, "选课成功！");
        }
    }

    private void showAdminCourseEntry() {
        JTextField courseNameField = new JTextField(20);
        JTextField courseNumberField = new JTextField(10);

        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(3, 2));
        adminPanel.add(new JLabel("课程名:"));
        adminPanel.add(courseNameField);
        adminPanel.add(new JLabel("课程号:"));
        adminPanel.add(courseNumberField);

        int result = JOptionPane.showConfirmDialog(null, adminPanel, "管理员录入课程", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String courseName = courseNameField.getText();
            String courseNumber = courseNumberField.getText();
            courses.add(courseName + " (" + courseNumber + ")");
            JOptionPane.showMessageDialog(null, "课程已录入！");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CourseSelectionSystem courseSelectionSystem = new CourseSelectionSystem();
                courseSelectionSystem.setVisible(true);
            }
        });
    }
}

