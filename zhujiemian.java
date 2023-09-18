package ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class zhujiemian {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    public static void createAndShowGUI() {
    	JFrame frame = new JFrame();
    	frame.setBackground(new Color(128, 255, 255));
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(ww.class.getResource("/image/学生信息.png")));
        frame.getContentPane().setEnabled(false);
        frame.setTitle("学生信息管理系统");
        frame.getContentPane().setBackground(SystemColor.inactiveCaption);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel optionsPanel = new JPanel();
        optionsPanel.setBackground(new Color(240, 240, 240));
        frame.getContentPane().add(optionsPanel, BorderLayout.WEST);
        optionsPanel.setLayout(new GridLayout(7, 1, 0, 10));

        JButton btnNewButton = new JButton("学生信息");
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 24));
        btnNewButton.setIcon(new ImageIcon(ww.class.getResource("/image/学生信息.png")));
        optionsPanel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("教师信息");
        btnNewButton_1.setIcon(new ImageIcon(ww.class.getResource("/image/教师信息.png")));
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 24));
        optionsPanel.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("论坛");
        btnNewButton_2.setIcon(new ImageIcon(ww.class.getResource("/image/论坛.png")));
        btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 24));
        optionsPanel.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("评价");
        btnNewButton_3.setIcon(new ImageIcon(ww.class.getResource("/image/calendar.png")));
        btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 24));
        optionsPanel.add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("课程信息");
        btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 24));
        btnNewButton_4.setIcon(new ImageIcon(ww.class.getResource("/image/calendar.png")));
        optionsPanel.add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("选课系统");
        btnNewButton_5.setFont(new Font("宋体", Font.PLAIN, 24));
        btnNewButton_5.setIcon(new ImageIcon(ww.class.getResource("/image/cart.png")));
        optionsPanel.add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("授课系统");
        btnNewButton_6.setFont(new Font("宋体", Font.PLAIN, 24));
        btnNewButton_6.setIcon(new ImageIcon(ww.class.getResource("/image/bell.png")));
        optionsPanel.add(btnNewButton_6);

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BorderLayout(0, 0));

        frame.setBounds(100, 100, 784, 531);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

	

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

    
}
