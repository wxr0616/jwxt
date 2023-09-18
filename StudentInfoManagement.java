package ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class StudentInfoManagement extends JFrame {
    private JPanel roleSelectionPanel;
    private JButton adminButton;
    private JButton studentButton;
    private HashMap<String, Student> studentMap = new HashMap<>();

    public StudentInfoManagement() {
        setTitle("Student Info Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        roleSelectionPanel = new JPanel();
        roleSelectionPanel.setLayout(new GridLayout(3, 1));

        JLabel label = new JLabel("请选择角色");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        roleSelectionPanel.add(label);

        adminButton = new JButton("管理员");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminStudentEntry();
            }
        });

        studentButton = new JButton("学生");
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStudentInfoUpdate();
            }
        });

        roleSelectionPanel.add(adminButton);
        roleSelectionPanel.add(studentButton);

        getContentPane().add(roleSelectionPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void showAdminStudentEntry() {
        JTextField studentNameField = new JTextField(20);
        JTextField studentIdField = new JTextField(10);
        JTextField studentMajorField = new JTextField(20);
        JTextField studentPhoneNumberField = new JTextField(15);

        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(4, 2));
        adminPanel.add(new JLabel("学生姓名:"));
        adminPanel.add(studentNameField);
        adminPanel.add(new JLabel("学生学号:"));
        adminPanel.add(studentIdField);
        adminPanel.add(new JLabel("学生专业:"));
        adminPanel.add(studentMajorField);
        adminPanel.add(new JLabel("电话号码:"));
        adminPanel.add(studentPhoneNumberField);

        int result = JOptionPane.showConfirmDialog(null, adminPanel, "管理员录入学生信息", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String name = studentNameField.getText();
            String id = studentIdField.getText();
            String major = studentMajorField.getText();
            String phoneNumber = studentPhoneNumberField.getText();

            Student student = new Student(name, id, major, phoneNumber);
            studentMap.put(id, student);
            JOptionPane.showMessageDialog(null, "录入成功！");
        }
    }

    private void showStudentInfoUpdate() {
        JComboBox<String> studentComboBox = new JComboBox<>(studentMap.keySet().toArray(new String[0]));
        JTextField phoneNumberField = new JTextField(15);

        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(2, 2));
        studentPanel.add(new JLabel("选择学生:"));
        studentPanel.add(studentComboBox);
        studentPanel.add(new JLabel("新电话号码:"));
        studentPanel.add(phoneNumberField);

        int result = JOptionPane.showConfirmDialog(null, studentPanel, "学生信息修改", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String selectedStudentId = (String) studentComboBox.getSelectedItem();
            Student student = studentMap.get(selectedStudentId);

            String newPhoneNumber = phoneNumberField.getText();

            student.setPhoneNumber(newPhoneNumber);

            JOptionPane.showMessageDialog(null, "修改成功！");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StudentInfoManagement studentInfoManagement = new StudentInfoManagement();
                studentInfoManagement.setVisible(true);
            }
        });
    }

    private class Student {
        private String name;
        private String id;
        private String major;
        private String phoneNumber;

        public Student(String name, String id, String major, String phoneNumber) {
            this.name = name;
            this.id = id;
            this.major = major;
            this.phoneNumber = phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}

