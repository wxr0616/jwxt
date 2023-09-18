package ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentInfoPage {
    // 定义文本字段和按钮
    private JTextField nameField;
    private JTextField contactField;
    private JPasswordField passwordField;
    private JButton saveButton;

    public static void openStudentInfoPage() {
        // 创建JFrame窗口
        JFrame studentFrame = new JFrame("学生信息页面");
        studentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        studentFrame.setSize(400, 300);

        // 创建面板
        JPanel panel = new JPanel();
        studentFrame.getContentPane().add(panel);

        // 设置布局为网格布局
        panel.setLayout(new GridLayout(4, 2));

        // 添加标签和文本字段
        JLabel nameLabel = new JLabel("姓名：");
        panel.add(nameLabel);
        JTextField nameField = new JTextField();
        panel.add(nameField);

        JLabel contactLabel = new JLabel("联系信息：");
        panel.add(contactLabel);
        JTextField contactField = new JTextField();
        panel.add(contactField);

        JLabel passwordLabel = new JLabel("登录密码：");
        panel.add(passwordLabel);
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        // 添加保存按钮并注册事件监听器
        JButton saveButton = new JButton("保存");
        panel.add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里处理保存按钮的点击事件
                String name = nameField.getText();
                String contact = contactField.getText();
                String password = new String(passwordField.getPassword());

                // 执行保存操作，可以调用适当的方法进行数据存储等操作

                // 提示保存成功或失败信息
                JOptionPane.showMessageDialog(null, "个人信息保存成功！");
            }
        });

        // 显示窗口
        studentFrame.setVisible(true);
    }
}
