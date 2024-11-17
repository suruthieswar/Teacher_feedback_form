import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 30, 80, 25);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 30, 160, 25);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 70, 80, 25);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 70, 160, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(30, 110, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Validate login credentials with UserData
                if (UserData.isValidLogin(username, password)) {
                    dispose();
                    new FormSelection().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login!");
                }
            }
        });
        add(loginButton);

        signupButton = new JButton("Sign Up");
        signupButton.setBounds(140, 110, 80, 25);
        signupButton.addActionListener(e -> new Signup().setVisible(true));
        add(signupButton);
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
