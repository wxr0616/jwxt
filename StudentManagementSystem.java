package ceshi;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ceshi.AccountApplicationGUI;
import ceshi.zhujiemian;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import ceshi.AdminInfoPage;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//登录界面
public class StudentManagementSystem {
    protected static final String DB_URL = "jdbc:mysql://localhost:3307/xsgl324";
    protected static final String DB_USER = "root";
    protected static final String DB_PASSWORD = "1234";
    
    public static void main(String[] args) {
    	// 创建JFrame窗口
        JFrame frame = new JFrame("学生管理系统");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(StudentManagementSystem.class.getResource("/image/key.png")));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(381, 311);

     // 创建用户名标签和文本字段
        JLabel usernameLabel = new JLabel("用户名:");
        usernameLabel.setBounds(21, 5, 78, 32);
        usernameLabel.setIcon(new ImageIcon(StudentManagementSystem.class.getResource("/image/学生信息.png")));
        JTextField usernameField = new JTextField(20);
        usernameField.setBounds(104, 10, 126, 21);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(usernameLabel);
        frame.getContentPane().add(usernameField);

     // 创建密码标签和密码字段
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setIcon(new ImageIcon(StudentManagementSystem.class.getResource("/image/key.png")));
        passwordLabel.setBounds(21, 57, 78, 32);
        frame.getContentPane().add(passwordLabel);

        
        
        
        JPasswordField passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(104, 63, 126, 26);
        frame.getContentPane().add(passwordField_1);
        
        String[] roles = { "学生", "教师", "管理员" };
        JComboBox<String> comboBox = new JComboBox<>(roles);
        comboBox.setEditable(true);
        comboBox.setBounds(104, 123, 109, 27);
        frame.getContentPane().add(comboBox);



        

     // 创建登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(41, 188, 91, 32);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField_1.getPassword());
                String role = (String) comboBox.getSelectedItem();
                handleLogin(username, password, role);
                zhujiemian.createAndShowGUI();
            }
        });
        frame.getContentPane().add(loginButton);

     // 创建取消按钮
        JButton cancelButton = new JButton("取消");
        cancelButton.setBounds(225, 188, 91, 32);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCancel();
            }
        });
        frame.getContentPane().add(cancelButton);

     // 创建注册按钮
        JButton registerButton = new JButton("注册");
        registerButton.setBounds(135, 232, 78, 32);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRegister();
            }
        });
        frame.getContentPane().add(registerButton);
        
        JLabel lblNewLabel = new JLabel("角色：\r\n");
        lblNewLabel.setIcon(new ImageIcon(ww.class.getResource("/image/学生信息.png")));
        lblNewLabel.setBounds(21, 118, 78, 32);
        frame.getContentPane().add(lblNewLabel);
        
        
        
        
        // 显示窗口
        frame.setVisible(true);
    }

  

    
    




	public static void handleLogin(String username, String password, String role) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // 连接数据库
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("成功连接数据库");

            // 查询数据库中的用户表，验证用户名、密码和角色是否匹配
            String sql = "SELECT * FROM user WHERE username = ? AND password = ? AND role = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, role);

            
            
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println(role + "登录成功");
             // 根据角色进行跳转
                switch (role) {
                case "学生":
                	 zhujiemian.createAndShowGUI();  // 跳转到学生主界面
                    break;
                case "教师":
                	 zhujiemian.createAndShowGUI();  // 跳转到教师主界面
                    break;

                case "管理员":
                	 zhujiemian.createAndShowGUI(); 
                        break;
                }
            } else {
                System.out.println("用户名、密码或角色不正确");
            }
        } catch (SQLException ex) {
            System.out.println("登录时发生数据库错误: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            // 关闭数据库连接等资源
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("关闭数据库连接时发生错误: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }


	public static void createAndShowGUI() {
		System.out.println("跳转到主界面");
	    zhujiemian Zhujiemian = new zhujiemian();
	    Zhujiemian.setVisible(true);
	}

	
	public static void handleCancel() {
        System.out.println("已取消操作");
    }

	public static void handleRegister() {
	    System.out.println("跳转到注册界面");
	    // 创建 AccountApplicationGUI 实例并显示界面
	    AccountApplicationGUI accountApplicationGUI = new AccountApplicationGUI();
	    accountApplicationGUI.setVisible(true);
	}


    public static void performRegistration(String newUsername, String newPassword, String newRole) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // 连接数据库
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("成功连接数据库");

            // 插入新用户信息到user表
            String sql = "INSERT INTO user (username, password, role) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, newUsername);
            statement.setString(2, newPassword);
            statement.setString(3, newRole);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("注册成功");
            } else {
                System.out.println("注册失败");
            }
        } catch (SQLException ex) {
            System.out.println("注册时发生数据库错误: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            // 关闭数据库连接等资源
            try {
                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("关闭数据库连接时发生错误: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    }

    





