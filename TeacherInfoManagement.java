package ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class TeacherInfoManagement extends JFrame {
    private JPanel roleSelectionPanel;
    private JButton adminButton;
    private JButton teacherButton;
    private HashMap<String, Teacher> teacherMap = new HashMap<>();

    public TeacherInfoManagement() {
        setTitle("Teacher Info Management");
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
                showAdminTeacherEntry();
            }
        });

        teacherButton = new JButton("教师");
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTeacherInfoUpdate();
            }
        });

        roleSelectionPanel.add(adminButton);
        roleSelectionPanel.add(teacherButton);

        getContentPane().add(roleSelectionPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void showAdminTeacherEntry() {
        JTextField teacherNameField = new JTextField(20);
        JTextField teacherIdField = new JTextField(10);
        JTextField teacherEmailField = new JTextField(20);
        JTextField teacherDepartmentField = new JTextField(20);
        JTextField teacherPhoneNumberField = new JTextField(15);

        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(5, 2));
        adminPanel.add(new JLabel("教师姓名:"));
        adminPanel.add(teacherNameField);
        adminPanel.add(new JLabel("教师工号:"));
        adminPanel.add(teacherIdField);
        adminPanel.add(new JLabel("教师邮箱:"));
        adminPanel.add(teacherEmailField);
        adminPanel.add(new JLabel("教师部门:"));
        adminPanel.add(teacherDepartmentField);
        adminPanel.add(new JLabel("电话号码:"));
        adminPanel.add(teacherPhoneNumberField);

        int result = JOptionPane.showConfirmDialog(null, adminPanel, "管理员录入教师信息", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String name = teacherNameField.getText();
            String id = teacherIdField.getText();
            String email = teacherEmailField.getText();
            String department = teacherDepartmentField.getText();
            String phoneNumber = teacherPhoneNumberField.getText();

            Teacher teacher = new Teacher(name, id, email, department, phoneNumber);
            teacherMap.put(id, teacher);
            JOptionPane.showMessageDialog(null, "录入成功！");
        }
    }

    private void showTeacherInfoUpdate() {
        JComboBox<String> teacherComboBox = new JComboBox<>(teacherMap.keySet().toArray(new String[0]));
        JTextField emailField = new JTextField(20);
        JTextField phoneNumberField = new JTextField(15);

        JPanel teacherPanel = new JPanel();
        teacherPanel.setLayout(new GridLayout(3, 2));
        teacherPanel.add(new JLabel("选择教师:"));
        teacherPanel.add(teacherComboBox);
        teacherPanel.add(new JLabel("新邮箱:"));
        teacherPanel.add(emailField);
        teacherPanel.add(new JLabel("新电话号码:"));
        teacherPanel.add(phoneNumberField);

        int result = JOptionPane.showConfirmDialog(null, teacherPanel, "教师信息修改", JOptionPane.OK_CANCEL_OPTION);

        if (result == JOptionPane.OK_OPTION) {
            String selectedTeacherId = (String) teacherComboBox.getSelectedItem();
            Teacher teacher = teacherMap.get(selectedTeacherId);

            String newEmail = emailField.getText();
            String newPhoneNumber = phoneNumberField.getText();

            teacher.setEmail(newEmail);
            teacher.setPhoneNumber(newPhoneNumber);

            JOptionPane.showMessageDialog(null, "修改成功！");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TeacherInfoManagement teacherInfoManagement = new TeacherInfoManagement();
                teacherInfoManagement.setVisible(true);
            }
        });
    }

    private class Teacher {
        private String name;
        private String id;
        private String email;
        private String department;
        private String phoneNumber;

        public Teacher(String name, String id, String email, String department, String phoneNumber) {
            this.name = name;
            this.id = id;
            this.email = email;
            this.department = department;
            this.phoneNumber = phoneNumber;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }
}

