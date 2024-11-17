import javax.swing.*;

public class Signup extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public Signup() {
        setTitle("Sign Up");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("New Username:");
        userLabel.setBounds(20, 30, 100, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(130, 30, 120, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("New Password:");
        passLabel.setBounds(20, 70, 100, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(130, 70, 120, 25);
        add(passwordField);

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(80, 110, 120, 25);
        registerButton.addActionListener(e -> registerUser());
        add(registerButton);
    }

    private void registerUser() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Register the username and password in UserData
        UserData.register(username, password);

        JOptionPane.showMessageDialog(this, "Registration Successful!");

        // Close signup window and open the login window
        dispose();
        new Login().setVisible(true);
    }
}
