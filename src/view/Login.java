package view;

import database.DB;
import database.Status;
import model.User;
import service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JDialog {

    private JPanel contentPane;
    private JLabel jlabelId;
    private JLabel jlabelPassword;
    private JButton btnLogin;
    private JTextField textFieldId;
    private JTextField textFieldPassword;

    /**
     * Create the frame.
     */
    public Login() {
        setTitle("Login");
        setBounds(100, 100, 407, 185);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Settings for JLabel 'jlabelId'
        jlabelId = new JLabel("ID");
        jlabelId.setHorizontalAlignment(SwingConstants.CENTER);
        jlabelId.setFont(new Font("굴림", Font.PLAIN, 11));
        jlabelId.setBounds(30, 50, 57, 15);
        contentPane.add(jlabelId);

        // Settings for JLabel 'jlabelPassword'
        jlabelPassword = new JLabel("PassWord");
        jlabelPassword.setHorizontalAlignment(SwingConstants.CENTER);
        jlabelPassword.setFont(new Font("굴림", Font.PLAIN, 11));
        jlabelPassword.setBounds(30, 85, 70, 15);
        contentPane.add(jlabelPassword);

       // Settings for JLabel 'btnLogin'
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() { // if login button is clicked
            public void actionPerformed(ActionEvent e) {
                String id = textFieldId.getText(); 
                String pw = textFieldPassword.getText();

                String result = UserService.login(id, pw);
                if ("success".equals(result)) { // if we successfully login
                    dispose(); // close this login window
                } else { // if we fail login
                    JOptionPane.showMessageDialog(null,  // show error message
                            result,
                            "Fail",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnLogin.setBounds(289, 50, 74, 45);
        contentPane.add(btnLogin);

        // Settings for JTextField 'textFieldId'
        textFieldId = new JTextField();
        textFieldId.setBounds(118, 47, 159, 21);
        contentPane.add(textFieldId);
        textFieldId.setColumns(10);
        
        // Settings for JTextField 'textFieldPassword'
        textFieldPassword = new JTextField();
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(118, 82, 159, 21);
        contentPane.add(textFieldPassword);
    }
}
