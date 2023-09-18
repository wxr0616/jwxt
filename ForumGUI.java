package ceshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//论坛
public class ForumGUI extends JFrame {
    private JTextArea messageTextArea;
    private JButton postButton;
    private JComboBox<String> userTypeComboBox;
    private JButton stickyButton;
    private JTextField inputTextField;
    private boolean isAdmin = false; // Track the admin status

    private ArrayList<Message> messages;

    public ForumGUI() {
    	setBackground(new Color(192, 192, 192));
    	setIconImage(Toolkit.getDefaultToolkit().getImage(ff.class.getResource("/image/论坛.png")));
        setTitle("论坛界面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        messages = new ArrayList<>();

        messageTextArea = new JTextArea(10, 30);
        messageTextArea.setBackground(new Color(255, 250, 240));
        JScrollPane scrollPane = new JScrollPane(messageTextArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(245, 255, 250));
        inputPanel.setLayout(new FlowLayout());

        inputTextField = new JTextField(20);
        JLabel label = new JLabel("留言输入框");
        label.setBackground(new Color(255, 215, 0));
        inputPanel.add(label);
        inputPanel.add(inputTextField);

        userTypeComboBox = new JComboBox<>(new String[]{"教师", "学生", "管理员"});
        inputPanel.add(userTypeComboBox);

        postButton = new JButton("发言");
        postButton.setBackground(new Color(255, 215, 0));
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                postMessage();
            }
        });
        inputPanel.add(postButton);

        getContentPane().add(inputPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(245, 255, 250));
        bottomPanel.setLayout(new FlowLayout());

        stickyButton = new JButton("置顶消息");
        stickyButton.setFont(new Font("宋体", Font.PLAIN, 14));
        stickyButton.setIcon(new ImageIcon(ff.class.getResource("/image/speaker.png")));
        stickyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleAdmin(); // Toggle admin status
            }
        });
        bottomPanel.add(stickyButton);

        getContentPane().add(bottomPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void toggleAdmin() {
        isAdmin = !isAdmin;
        userTypeComboBox.setEnabled(!isAdmin);
    }

    private void postMessage() {
        String userType = (String) userTypeComboBox.getSelectedItem();
        String messageText = inputTextField.getText();

        if (!messageText.isEmpty()) {
            if (isAdmin) {
                // Admin's messages are sticky
                String stickyMessage = "[管理员] " + messageText;
                Message message = new Message("管理员", stickyMessage);
                messages.add(0, message);
            } else {
                Message message = new Message(userType, messageText);
                messages.add(message);
            }

            refreshMessageTextArea();
            inputTextField.setText("");
        }
    }

    private void refreshMessageTextArea() {
        messageTextArea.setText("");

        for (int i = messages.size() - 1; i >= 0; i--) {
            Message message = messages.get(i);
            messageTextArea.append(message.getFormattedMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ForumGUI();
            }
        });
    }

    private static class Message {
        private String userType;
        private String messageText;

        public Message(String userType, String messageText) {
            this.userType = userType;
            this.messageText = messageText;
        }

        public String getFormattedMessage() {
            return "[" + userType + "] " + messageText;
        }
    }
}
