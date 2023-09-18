package ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ff{
	/**
     * @wbp.parser.entryPoint
     */

	public static class StudentRegistrationGUI extends JFrame {
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
	        
	        getContentPane().add(registrationPanel, BorderLayout.CENTER);
	        getContentPane().add(confirmButton, BorderLayout.SOUTH);
	        pack();
	        setLocationRelativeTo(null);
	    }
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            StudentRegistrationGUI studentRegistrationGUI = new StudentRegistrationGUI();
	            studentRegistrationGUI.setVisible(true);
	        });
	    }
	}}