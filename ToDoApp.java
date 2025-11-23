import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class ToDoApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("To-Do List App");
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        // Task List Model & List
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(listModel);
        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        JTextField taskField = new JTextField(20);
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");
        inputPanel.add(taskField);
        inputPanel.add(addButton);
        inputPanel.add(deleteButton);
        // Add Button Functionality
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        });
        // Delete Button Functionality
        deleteButton.addActionListener(e -> {
            int index = taskList.getSelectedIndex();
            if (index != -1) {
                listModel.remove(index);
            }
        });
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
