package ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//注册界面
public class AccountApplicationGUI extends JFrame {
    private JPanel roleSelectionPanel;
    private JButton studentButton;
    private JButton teacherButton;

    public AccountApplicationGUI() {
        setTitle("注册界面");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        roleSelectionPanel = new JPanel();
       

        JLabel label = new JLabel("请选择注册的角色");
        label.setIcon(new ImageIcon(AccountApplicationGUI.class.getResource("/image/学生信息.png")));
        label.setBounds(57, 35, 147, 31);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        roleSelectionPanel.add(label);

        studentButton = new JButton("学生");
        studentButton.setBounds(57, 93, 147, 31);
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStudentRegistration();
            }
        });

        teacherButton = new JButton("教师");
        teacherButton.setBounds(57, 134, 147, 31);
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTeacherRegistration();
            }
        });

        roleSelectionPanel.add(studentButton);
        roleSelectionPanel.add(teacherButton);

        getContentPane().add(roleSelectionPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void showStudentRegistration() {
        StudentRegistrationGUI studentRegistrationGUI = new StudentRegistrationGUI();
        setVisible(false);
        studentRegistrationGUI.setVisible(true);
    }

    private void showTeacherRegistration() {
        TeacherRegistrationGUI teacherRegistrationGUI = new TeacherRegistrationGUI();
        setVisible(false);
        teacherRegistrationGUI.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AccountApplicationGUI accountGUI = new AccountApplicationGUI();
                accountGUI.setVisible(true);
            }
        });
    }
}

class StudentRegistrationGUI extends JFrame {
    private JPanel registrationPanel;
    private JLabel snoLabel;
    private JLabel snameLabel;
    private JLabel sageLabel;
    private JLabel ssexLabel;
    private JLabel smajorLabel;
    private JLabel sbirthLabel;
    private JLabel phoneNumLabel;
    private JLabel emailLabel;
    private JLabel sclassLabel;
    private JLabel stuPhotoLabel;
    private JLabel timeEnrollLabel;
    private JLabel dateGraduLabel;
    private JTextField snoField;
    private JTextField snameField;
    private JTextField sageField;
    private JTextField ssexField;
    private JTextField smajorField;
    private JTextField sbirthField;
    private JTextField phoneNumField;
    private JTextField emailField;
    private JTextField sclassField;
    private JTextField stuPhotoField;
    private JTextField timeEnrollField;
    private JTextField dateGraduField;
    private JButton confirmButton;

    public StudentRegistrationGUI() {
        setTitle("学生注册界面");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        registrationPanel = new JPanel();
        registrationPanel.setLayout(new GridLayout(7, 2));

        snoLabel = new JLabel("学号：");
        snoField = new JTextField();
        snameLabel = new JLabel("姓名：");
        snameField = new JTextField();
        sageLabel = new JLabel("年龄：");
        sageField = new JTextField();
        ssexLabel = new JLabel("性别：");
        ssexField = new JTextField();
        smajorLabel = new JLabel("专业：");
        smajorField = new JTextField();
        sbirthLabel = new JLabel("出生日期：");
        sbirthField = new JTextField();
        phoneNumLabel = new JLabel("电话号码：");
        phoneNumField = new JTextField();
        emailLabel = new JLabel("邮箱：");
        emailField = new JTextField();
        sclassLabel = new JLabel("班级：");
        sclassField = new JTextField();
        stuPhotoLabel = new JLabel("照片：");
        stuPhotoField = new JTextField();
        timeEnrollLabel = new JLabel("入学时间：");
        timeEnrollField = new JTextField();
        dateGraduLabel = new JLabel("毕业日期：");
        dateGraduField = new JTextField();

        registrationPanel.add(snoLabel);
        registrationPanel.add(snoField);
        registrationPanel.add(snameLabel);
        registrationPanel.add(snameField);
        registrationPanel.add(sageLabel);
        registrationPanel.add(sageField);
        registrationPanel.add(ssexLabel);
        registrationPanel.add(ssexField);
        registrationPanel.add(smajorLabel);
        registrationPanel.add(smajorField);
        registrationPanel.add(sbirthLabel);
        registrationPanel.add(sbirthField);
        registrationPanel.add(phoneNumLabel);
        registrationPanel.add(phoneNumField);
        registrationPanel.add(emailLabel);
        registrationPanel.add(emailField);
        registrationPanel.add(sclassLabel);
        registrationPanel.add(sclassField);
        registrationPanel.add(stuPhotoLabel);
        registrationPanel.add(stuPhotoField);
        registrationPanel.add(timeEnrollLabel);
        registrationPanel.add(timeEnrollField);
        registrationPanel.add(dateGraduLabel);
        registrationPanel.add(dateGraduField);

        confirmButton = new JButton("确认");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 将信息交给管理员审核
            	  // 检查学生注册界面的字段信息是否为空
                if (snoField.getText().isEmpty() ||
                        snameField.getText().isEmpty() ||
                        sageField.getText().isEmpty() ||
                        ssexField.getText().isEmpty() ||
                        smajorField.getText().isEmpty() ||
                        sbirthField.getText().isEmpty() ||
                        phoneNumField.getText().isEmpty() ||
                        emailField.getText().isEmpty() ||
                        sclassField.getText().isEmpty() ||
                        stuPhotoField.getText().isEmpty() ||
                        timeEnrollField.getText().isEmpty() ||
                        dateGraduField.getText().isEmpty()) {
                    // 弹窗提示用户请完善信息
                    JOptionPane.showMessageDialog(null, "请完善您的信息");
                }else  
                	JOptionPane.showMessageDialog(null, "信息已交由管理员审核");

             // 在弹窗提示后再弹出一个确认对话框
             int result = JOptionPane.showConfirmDialog(null, "审核通过", "确认", JOptionPane.YES_NO_OPTION);
             if (result == JOptionPane.YES_OPTION) {
                 // 用户点击了确认按钮
                 // 可以在这里执行相应的操作
             } else {
                 // 用户点击了取消按钮或关闭了对话框
                 // 可以在这里执行相应的操作
             }

            }
        });

        getContentPane().add(registrationPanel, BorderLayout.CENTER);
        getContentPane().add(confirmButton, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }
}


class TeacherRegistrationGUI extends JFrame {
    private JPanel registrationPanel;
    private JLabel tnoLabel;
    private JLabel tnameLabel;
    private JLabel tsexLabel;
    private JLabel deptLabel;
    private JLabel phoneNumLabel;
    private JLabel emailLabel;
    private JTextField tnoField;
    private JTextField tnameField;
    private JTextField tsexField;
    private JTextField deptField;
    private JTextField phoneNumField;
    private JTextField emailField;
    private JButton confirmButton;

    public TeacherRegistrationGUI() {
        setTitle("教师注册界面");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        registrationPanel = new JPanel();
        registrationPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 10, 5, 10);

        tnoLabel = new JLabel("教师编号：");
        registrationPanel.add(tnoLabel, gbc);

        gbc.gridx = 1;
        tnoField = new JTextField(15);
        registrationPanel.add(tnoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        tnameLabel = new JLabel("姓名：");
        registrationPanel.add(tnameLabel, gbc);

        gbc.gridx = 1;
        tnameField = new JTextField(15);
        registrationPanel.add(tnameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        tsexLabel = new JLabel("性别：");
        registrationPanel.add(tsexLabel, gbc);

        gbc.gridx = 1;
        tsexField = new JTextField(15);
        registrationPanel.add(tsexField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        deptLabel = new JLabel("部门：");
        registrationPanel.add(deptLabel, gbc);

        gbc.gridx = 1;
        deptField = new JTextField(15);
        registrationPanel.add(deptField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        phoneNumLabel = new JLabel("电话号码：");
        registrationPanel.add(phoneNumLabel, gbc);

        gbc.gridx = 1;
        phoneNumField = new JTextField(15);
        registrationPanel.add(phoneNumField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        emailLabel = new JLabel("邮箱：");
        registrationPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        emailField = new JTextField(15);
        registrationPanel.add(emailField, gbc);

        confirmButton = new JButton("确认");
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 将信息交给管理员审核
                if (tnoField.getText().isEmpty() ||
                        tnameField.getText().isEmpty() ||
                        tsexField.getText().isEmpty() ||
                        deptField.getText().isEmpty() ||
                        phoneNumField.getText().isEmpty() ||
                        emailField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "请完善您的信息");
                } else {
                    JOptionPane.showMessageDialog(null, "信息已交由管理员审核");
                    int result = JOptionPane.showConfirmDialog(null, "审核通过", "确认", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        // 用户点击了确认按钮
                        // 可以在这里执行相应的操作
                    } else {
                        // 用户点击了取消按钮或关闭了对话框
                        // 可以在这里执行相应的操作
                    }
                }
            }
        });

        getContentPane().add(registrationPanel, BorderLayout.CENTER);
        getContentPane().add(confirmButton, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main1(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TeacherRegistrationGUI teacherRegistrationGUI = new TeacherRegistrationGUI();
            teacherRegistrationGUI.setVisible(true);
        });
    }







    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AccountApplicationGUI();
            }
        });
    }
}



