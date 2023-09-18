package ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class CourseManagement extends JFrame {
    private JPanel roleSelectionPanel;
    private JButton teacherButton;
    private JButton studentButton;
    private JButton adminButton;
    private JComboBox<String> teacherComboBox;
    private JComboBox<String> studentComboBox;
    private JComboBox<String> courseComboBox;
    private HashMap<String, Teacher> teacherMap = new HashMap<>();
    private HashMap<String, Student> studentMap = new HashMap<>();
    private HashMap<String, Course> courseMap = new HashMap<>();

 // 在CourseManagement类中添加calculateNewAttendanceRate方法
    private double calculateNewAttendanceRate(int leaveStudentCount) {
        // 在这里根据请假学生的数量和总学生人数计算新的出勤率
        // 这里你可以使用适当的算法来计算出勤率
        // 假设总学生人数为100，你可以这样计算出勤率：(100 - leaveStudentCount) / 100.0 * 100
        return (100 - leaveStudentCount) / 100.0 * 100;
    }

    
    public CourseManagement() {
        setTitle("Course Management");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        roleSelectionPanel = new JPanel();
        roleSelectionPanel.setLayout(new GridLayout(4, 1));

        JLabel label = new JLabel("请选择角色");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        roleSelectionPanel.add(label);

        teacherButton = new JButton("教师");
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTeacherAttendance();
            }
        });
        roleSelectionPanel.add(teacherButton);

        studentButton = new JButton("学生");
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showStudentLeaveApplication();
            }
        });
        roleSelectionPanel.add(studentButton);

        adminButton = new JButton("管理员");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminManageCourse();
            }
        });
        roleSelectionPanel.add(adminButton);

        getContentPane().add(roleSelectionPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    private void showTeacherAttendance() {
        JFrame teacherFrame = new JFrame("教师 - 考勤结果");
        teacherFrame.setSize(300, 200);
        teacherFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel teacherPanel = new JPanel();
        teacherPanel.setLayout(new GridLayout(3, 1)); // Reduced the number of rows

        JLabel courseLabel = new JLabel("选择课程:");
        courseComboBox = new JComboBox<>(courseMap.keySet().toArray(new String[0]));
        JButton queryButton = new JButton("查询");

        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();

                // 模拟从数据库或数据源中获取考勤信息，假设有三个学生请假
                ArrayList<String> leaveStudents = new ArrayList<>();
                leaveStudents.add("学生1 - 学号1 - 请假理由1");
                leaveStudents.add("学生2 - 学号2 - 请假理由2");
                leaveStudents.add("学生3 - 学号3 - 请假理由3");

                if (!leaveStudents.isEmpty()) {
                    // 构建弹出的消息
                    StringBuilder messageBuilder = new StringBuilder("考勤结果：出勤率80%\n\n请假学生信息：\n");
                    for (String leaveStudent : leaveStudents) {
                        messageBuilder.append(leaveStudent).append("\n");
                    }

                    // 弹出消息框显示请假学生信息
                    JOptionPane.showMessageDialog(teacherFrame, messageBuilder.toString(), "考勤结果", JOptionPane.INFORMATION_MESSAGE);
                    
                    // 根据请假学生人数调整出勤率，这里你需要根据实际需求修改
                    double attendanceRate = calculateNewAttendanceRate(leaveStudents.size());
                    System.out.println("新的出勤率：" + attendanceRate); // 在控制台打印出勤率
                } else {
                    // 如果没有学生请假
                    JOptionPane.showMessageDialog(teacherFrame, "考勤结果：出勤率100%", "考勤结果", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        teacherPanel.add(courseLabel);
        teacherPanel.add(courseComboBox);
        teacherPanel.add(queryButton);

        teacherFrame.add(teacherPanel);
        teacherFrame.setVisible(true);
    }

   

    // 定义一个类来表示学生请假信息
    private class StudentLeaveInfo {
        private String name;
        private String studentID;
        private String reason;

        public StudentLeaveInfo(String name, String studentID, String reason) {
            this.name = name;
            this.studentID = studentID;
            this.reason = reason;
        }

        public String getName() {
            return name;
        }

        public String getStudentID() {
            return studentID;
        }

        public String getReason() {
            return reason;
        }
    }
        

   
    private void showStudentLeaveApplication() {
        JFrame studentFrame = new JFrame("学生 - 请假申请");
        studentFrame.setSize(400, 300);
        studentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel studentPanel = new JPanel();
        studentPanel.setLayout(new GridLayout(5, 2));

        JLabel courseLabel = new JLabel("选择课程:");
        JComboBox<String> courseComboBox = new JComboBox<>(courseMap.keySet().toArray(new String[0]));
        JLabel nameLabel = new JLabel("姓名:");
        JTextField nameField = new JTextField();
        JLabel studentIDLabel = new JLabel("学号:");
        JTextField studentIDField = new JTextField();
        JLabel reasonLabel = new JLabel("请假理由:");
        JTextArea reasonArea = new JTextArea();
        JButton applyButton = new JButton("确认请假");

        applyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                String name = nameField.getText();
                String studentID = studentIDField.getText();
                String reason = reasonArea.getText();

                // 在这里处理请假申请，可以将请假信息存储到数据库或显示在界面上
                // 例如：将请假信息显示在对话框中
                String message = "请假申请成功\n\n" +
                                 "课程: " + selectedCourse + "\n" +
                                 "姓名: " + name + "\n" +
                                 "学号: " + studentID + "\n" +
                                 "请假理由:\n" + reason;

                JOptionPane.showMessageDialog(studentFrame, message, "请假申请成功", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        studentPanel.add(courseLabel);
        studentPanel.add(courseComboBox);
        studentPanel.add(nameLabel);
        studentPanel.add(nameField);
        studentPanel.add(studentIDLabel);
        studentPanel.add(studentIDField);
        studentPanel.add(reasonLabel);
        studentPanel.add(new JScrollPane(reasonArea)); // 使用滚动窗格以便显示多行文本
        studentPanel.add(applyButton);

        studentFrame.add(studentPanel);
        studentFrame.setVisible(true);
    }


    private void showAdminManageCourse() {
        JFrame adminFrame = new JFrame("管理员页面");
        adminFrame.setSize(300, 200);
        adminFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(6, 2)); // 增加了行数和列数

        JLabel nameLabel = new JLabel("教师姓名:");
        JTextField teacherNameField = new JTextField(); // 添加了一个文本输入框
        JLabel classroomLabel = new JLabel("授课教室:");
        JTextField classroomField = new JTextField();
        JLabel courseNameLabel = new JLabel("课程名:");
        JTextField courseNameField = new JTextField();
        JLabel timeLabel = new JLabel("授课时间:");
        JTextField timeField = new JTextField();
        JButton confirmButton = new JButton("确认");

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teacherName = teacherNameField.getText(); // 获取教师姓名输入
                String classroom = classroomField.getText();
                String courseName = courseNameField.getText();
                String time = timeField.getText();
                
                // 在此处验证和处理输入数据
                
                // 将新的课程添加到courseMap
                courseMap.put(courseName, new Course()); // 在此，我仅仅用了一个空的Course对象，你可能需要为其提供详细的参数

                // 显示成功对话框
                JOptionPane.showMessageDialog(adminFrame, "录入成功", "成功", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        adminPanel.add(nameLabel);
        adminPanel.add(teacherNameField);
        adminPanel.add(classroomLabel);
        adminPanel.add(classroomField);
        adminPanel.add(courseNameLabel);
        adminPanel.add(courseNameField);
        adminPanel.add(timeLabel);
        adminPanel.add(timeField);
        adminPanel.add(confirmButton);

        adminFrame.add(adminPanel);
        adminFrame.setVisible(true);
    }


    
  

    private class Teacher {
        // 教师信息类的定义
        // ...
    }

    private class Student {
        // 学生信息类的定义
        // ...
    }

    private class Course {
        // 课程信息类的定义
        // ...
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CourseManagement().setVisible(true);
            }
        });
    }
}
