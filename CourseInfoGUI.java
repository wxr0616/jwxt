package ceshi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

class Course {
    private String name;
    private List<String> students;
    private Map<String, Integer> ratings;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.ratings = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(String studentName) {
        students.add(studentName);
    }

    public void addRating(String studentName, int rating) {
        ratings.put(studentName, rating);
    }

    public List<String> getStudents() {
        return students;
    }

    public double getAverageRating() {
        if (ratings.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (int rating : ratings.values()) {
            sum += rating;
        }
        return sum / ratings.size();
    }
}

class CourseInfoApp {
    private Map<String, Course> courses;

    public CourseInfoApp() {
        courses = new HashMap<>();
    }

    public void addCourse(String courseName) {
        courses.put(courseName, new Course(courseName));
    }

    public void enrollStudent(String courseName, String studentName) {
        if (courses.containsKey(courseName)) {
            courses.get(courseName).addStudent(studentName);
        }
    }

    public void rateCourse(String courseName, String studentName, int rating) {
        if (courses.containsKey(courseName)) {
            courses.get(courseName).addRating(studentName, rating);
        }
    }

    public List<String> getCourseStudents(String courseName) {
        if (courses.containsKey(courseName)) {
            return courses.get(courseName).getStudents();
        }
        return new ArrayList<>();
    }

    public double getCourseAverageRating(String courseName) {
        if (courses.containsKey(courseName)) {
            return courses.get(courseName).getAverageRating();
        }
        return 0;
    }
}

public class CourseInfoGUI {
    public static void main(String[] args) {
        CourseInfoApp app = new CourseInfoApp();

        JFrame frame = new JFrame("课程信息系统");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(CourseInfoGUI.class.getResource("/image/calendar.png")));
        frame.setBackground(new Color(0, 255, 255));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(534, 317);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 255, 255));
        frame.getContentPane().add(panel);

        JButton addCourseButton = new JButton("添加课程");
        addCourseButton.setBounds(215, 5, 117, 41);
        addCourseButton.setIcon(new ImageIcon(CourseInfoGUI.class.getResource("/image/empty .png")));
        JButton enrollButton = new JButton("添加学生");
        enrollButton.setIcon(new ImageIcon(CourseInfoGUI.class.getResource("/image/empty .png")));
        enrollButton.setFont(new Font("宋体", Font.PLAIN, 12));
        enrollButton.setBounds(212, 56, 120, 31);
        JButton rateButton = new JButton("评价课程");
        rateButton.setIcon(new ImageIcon(CourseInfoGUI.class.getResource("/image/like.png")));
        rateButton.setFont(new Font("宋体", Font.PLAIN, 14));
        rateButton.setBounds(23, 136, 126, 25);
        JButton showStudentsButton = new JButton("显示学生");
        showStudentsButton.setFont(new Font("宋体", Font.PLAIN, 16));
        showStudentsButton.setBounds(23, 230, 96, 28);
        JButton showRatingButton = new JButton("显示课程平均分");
        showRatingButton.setFont(new Font("宋体", Font.PLAIN, 16));
        showRatingButton.setBounds(23, 171, 145, 41);

        JTextField courseNameField = new JTextField(15);
        courseNameField.setBounds(113, 15, 96, 21);
        JTextField studentNameField = new JTextField(15);
        studentNameField.setBounds(113, 53, 96, 21);
        JTextField ratingField = new JTextField(5);
        ratingField.setFont(new Font("宋体", Font.PLAIN, 10));
        ratingField.setBounds(113, 105, 36, 21);
        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setBounds(266, 96, 244, 184);
        resultArea.setEditable(false);

        addCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameField.getText();
                app.addCourse(courseName);
                resultArea.setText("已添加课程：" + courseName);
            }
        });

        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameField.getText();
                String studentName = studentNameField.getText();
                app.enrollStudent(courseName, studentName);
                resultArea.setText(studentName + " 已加入 " + courseName);
            }
        });

        rateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameField.getText();
                String studentName = studentNameField.getText();
                int rating = Integer.parseInt(ratingField.getText());
                app.rateCourse(courseName, studentName, rating);
                resultArea.setText(studentName + " 为 " + courseName + " 打分：" + rating + " 星");
            }
        });

        showStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameField.getText();
                List<String> students = app.getCourseStudents(courseName);
                resultArea.setText(courseName + " 的学生名单：\n" + String.join("\n", students));
            }
        });

        showRatingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameField.getText();
                double averageRating = app.getCourseAverageRating(courseName);
                resultArea.setText(courseName + " 的平均分：" + averageRating);
            }
        });
        panel.setLayout(null);

        JLabel label = new JLabel("课程名：");
        label.setBounds(23, 8, 96, 28);
        label.setFont(new Font("宋体", Font.PLAIN, 24));
        panel.add(label);
        panel.add(courseNameField);
        panel.add(addCourseButton);
        JLabel label_1 = new JLabel("学生名：");
        label_1.setBounds(23, 46, 96, 28);
        label_1.setFont(new Font("宋体", Font.PLAIN, 24));
        panel.add(label_1);
        panel.add(studentNameField);
        panel.add(enrollButton);
        JLabel label_2 = new JLabel("评分 (1-5)：");
        label_2.setFont(new Font("宋体", Font.PLAIN, 16));
        label_2.setBounds(7, 78, 112, 58);
        panel.add(label_2);
        panel.add(ratingField);
        panel.add(rateButton);
        panel.add(showStudentsButton);
        panel.add(showRatingButton);
        panel.add(resultArea);

        frame.setVisible(true);
    }
}