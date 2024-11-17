import java.awt.*;
import java.awt.event.*;

class StudentFeedbackFormAWT extends Frame implements ActionListener {
    Label titleLabel, nameLabel, departmentLabel, sectionLabel, subjectLabel, feedbackLabel, ratingLabel;
    TextField nameField, departmentField, sectionField, subjectField;
    TextArea feedbackArea;
    Choice ratingChoice;
    Button submitButton, viewFeedbackButton;

    // Variables to store feedback information
    String savedName, savedDepartment, savedSection, savedSubject, savedFeedback;
    String savedRating;

    public StudentFeedbackFormAWT() {
        setTitle("Student Feedback Form");
        setSize(400, 600);
        setLayout(null);

        // Set background color
        setBackground(new Color(173, 216, 230)); // Light blue background color

        // Set up components
        titleLabel = new Label("Student Feedback Form", Label.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(50, 50, 300, 30);
        add(titleLabel);

        nameLabel = new Label("Name:");
        nameLabel.setBounds(50, 100, 100, 30);
        add(nameLabel);
        nameField = new TextField();
        nameField.setBounds(150, 100, 200, 30);
        add(nameField);

        departmentLabel = new Label("Department:");
        departmentLabel.setBounds(50, 150, 100, 30);
        add(departmentLabel);
        departmentField = new TextField();
        departmentField.setBounds(150, 150, 200, 30);
        add(departmentField);

        sectionLabel = new Label("Section:");
        sectionLabel.setBounds(50, 200, 100, 30);
        add(sectionLabel);
        sectionField = new TextField();
        sectionField.setBounds(150, 200, 200, 30);
        add(sectionField);

        subjectLabel = new Label("Subject:");
        subjectLabel.setBounds(50, 250, 100, 30);
        add(subjectLabel);
        subjectField = new TextField();
        subjectField.setBounds(150, 250, 200, 30);
        add(subjectField);

        feedbackLabel = new Label("Feedback:");
        feedbackLabel.setBounds(50, 300, 100, 30);
        add(feedbackLabel);
        feedbackArea = new TextArea();
        feedbackArea.setBounds(150, 300, 200, 80);
        add(feedbackArea);

        ratingLabel = new Label("Rating (1-5):");
        ratingLabel.setBounds(50, 400, 100, 30);
        add(ratingLabel);
        ratingChoice = new Choice();
        for (int i = 1; i <= 5; i++) {
            ratingChoice.add(String.valueOf(i));
        }
        ratingChoice.setBounds(150, 400, 50, 30);
        add(ratingChoice);

        submitButton = new Button("Submit");
        submitButton.setBounds(100, 450, 80, 30);
        submitButton.setBackground(Color.BLUE);
        submitButton.setForeground(Color.WHITE);
        add(submitButton);

        viewFeedbackButton = new Button("View Feedback");
        viewFeedbackButton.setBounds(200, 450, 100, 30);
        viewFeedbackButton.setBackground(Color.GREEN);
        viewFeedbackButton.setForeground(Color.WHITE);
        add(viewFeedbackButton);

        submitButton.addActionListener(this);
        viewFeedbackButton.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Save feedback information
            savedName = nameField.getText();
            savedDepartment = departmentField.getText();
            savedSection = sectionField.getText();
            savedSubject = subjectField.getText();
            savedFeedback = feedbackArea.getText();
            savedRating = ratingChoice.getSelectedItem();

            // Show success dialog
            Dialog successDialog = new Dialog(this, "Feedback Submitted", true);
            successDialog.setLayout(new FlowLayout());
            successDialog.add(new Label("Thank you for your feedback!"));

            Button closeButton = new Button("Close");
            closeButton.addActionListener(ev -> successDialog.dispose());
            successDialog.add(closeButton);

            successDialog.setSize(200, 100);
            successDialog.setLocationRelativeTo(this);
            successDialog.setVisible(true);

            // Clear the form fields after submission
            nameField.setText("");
            departmentField.setText("");
            sectionField.setText("");
            subjectField.setText("");
            feedbackArea.setText("");
            ratingChoice.select(0); // Reset to first choice
        } else if (e.getSource() == viewFeedbackButton) {
            // Display saved feedback information in a dialog
            Dialog viewDialog = new Dialog(this, "View Feedback", true);
            viewDialog.setLayout(new GridLayout(6, 1));
            viewDialog.add(new Label("Name: " + savedName));
            viewDialog.add(new Label("Department: " + savedDepartment));
            viewDialog.add(new Label("Section: " + savedSection));
            viewDialog.add(new Label("Subject: " + savedSubject));
            viewDialog.add(new Label("Feedback: " + savedFeedback));
            viewDialog.add(new Label("Rating: " + savedRating));

            Button closeViewButton = new Button("Close");
            closeViewButton.addActionListener(ev -> viewDialog.dispose());
            viewDialog.add(closeViewButton);

            viewDialog.setSize(300, 300);
            viewDialog.setLocationRelativeTo(this);
            viewDialog.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new StudentFeedbackFormAWT().setVisible(true);
    }
}
