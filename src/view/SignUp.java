package view;

import exception.*;
import model.User;
import service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class SignUp extends JFrame {

    private JPanel contentPane;
    private JLabel labelId;
    private JLabel labelPassword;
    private JLabel labelName;
    private JLabel labelBirth;
    private JTextField textFieldId;
    private JTextField textFieldPassword;
    private JTextField textFieldName;
    private JTextField textFieldBirth;
    private JButton btnOk;
    private JButton btnCancel;
    private String[] errorSelections = new String[30]; // for showing error messages at once
    private String result = "";

    /**
     * Create the frame.
     */
    public SignUp() {
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 412, 282);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Settings for JLabel 'labelId'
        labelId = new JLabel("ID");
        labelId.setHorizontalAlignment(SwingConstants.CENTER);
        labelId.setBounds(36, 36, 57, 15);
        contentPane.add(labelId);

        // Settings for JLabel 'labelPassword'
        labelPassword = new JLabel("PW");
        labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
        labelPassword.setBounds(36, 75, 57, 15);
        contentPane.add(labelPassword);

        // Settings for JLabel 'labelName'
        labelName = new JLabel("Name");
        labelName.setHorizontalAlignment(SwingConstants.CENTER);
        labelName.setBounds(36, 117, 57, 15);
        contentPane.add(labelName);

        // Settings for JLabel 'labelBirth'
        labelBirth = new JLabel("Birth");
        labelBirth.setHorizontalAlignment(SwingConstants.CENTER);
        labelBirth.setBounds(36, 156, 57, 15);
        contentPane.add(labelBirth);

        // Settings for JTextField 'textFieldId'
        textFieldId = new JTextField();
        textFieldId.setColumns(10);
        textFieldId.setBounds(106, 29, 270, 30);
        contentPane.add(textFieldId);

        // Settings for JTextField 'textFieldPassword'
        textFieldPassword = new JTextField();
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(105, 68, 270, 30);
        contentPane.add(textFieldPassword);

        // Settings for JTextField 'textFieldName'
        textFieldName = new JTextField();
        textFieldName.setFont(new Font("����", Font.PLAIN, 11));
        textFieldName.setColumns(10);
        textFieldName.setBounds(105, 110, 270, 30);
        contentPane.add(textFieldName);

        // Settings for JTextField 'textFieldBirth'
        textFieldBirth = new JTextField();
        textFieldBirth.setFont(new Font("����", Font.PLAIN, 11));
        textFieldBirth.setText("ex) 06/06/1995");
        textFieldBirth.setColumns(10);
        textFieldBirth.setBounds(106, 149, 270, 30);
        contentPane.add(textFieldBirth);

        // Settings for JButton 'btnOk'
        btnOk = new JButton("OK");
        btnOk.addActionListener(new ActionListener() { // if btnOk is clicked
            public void actionPerformed(ActionEvent e) {
                int count = 0;
                User user = new User();
                // ID
                String id = textFieldId.getText();
                try {
                    idCheck(id); // checking id
                    user.setId(id); // then set id into user object
                } catch (IdFormatException idFormatException) { // if id is not in english
                    errorSelections[count] = "Your id must be in english or number"; //then add error message in String array
                    count++;

                } catch (IdWIthBlankException idWIthBlankException) { // if id is blank
                    errorSelections[count] = "Please fill out id"; //then add error message in String array
                    count++;
                }

                // PW
                String pw = textFieldPassword.getText();
                try {
                    pwCheck(pw); // checking pw
                    user.setPassword(pw); // then set pw into user object
                } catch (PwFormatException pwFormatException) { // if pw doesn't follow the format
                    errorSelections[count] = "Your pw must be longer than 8 and english, number, special symbol combination"; //then add error message in String array
                    count++;

                } catch (PwWIthBlankException pwWIthBlankException) {  // if pw is blank
                    errorSelections[count] = "Please fill out pw"; //then add error message in String array
                    count++;
                }

                // name
                String name = textFieldName.getText();
                try {
                    nameCheck(name); // checking name
                    user.setName(name); // then set name into user object
                } catch (NameFormatException nameFormatException) { // if name doesn't follow the format
                    errorSelections[count] = "Your name must be in english"; //then add error message in String array
                    count++;

                } catch (NameEmptyException nameEmptyException) {  // if name is blank
                    errorSelections[count] = "Please fill out name"; //then add error message in String array
                    count++;
                }

                // birth
                String birth = textFieldBirth.getText();
                try {
                    birthCheck(birth); // checking statement
                    user.setBirth(birth);  // then set birth into user object
                } catch (BirthFormatException birthFormatException) { // if birth doesn't follow the format
                    errorSelections[count] = "Your birth must be in '06/06/1992' format"; //then add error message in String array
                    count++;

                } catch (BirthWIthBlankException birthWIthBlankException) {  // if birth is blank
                    errorSelections[count] = "Please fill out birth"; //then add error message in String array
                    count++;
                }

                // show error message
                if (count == 0) { // when there is no error
                    result = UserService.addUser(id, user);
                    if ("success".equals(result)) {
                        JOptionPane.showMessageDialog(null,
                                "Successfully Submitted",
                                "Success Message",
                                JOptionPane.PLAIN_MESSAGE); // show success message
                        UserService.login(id); // login by using id and pw that were just made
                        Booking booking = new Booking();
                        booking.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                result,
                                "You have following problems:",
                                JOptionPane.ERROR_MESSAGE); // then show error messages(or an error message)
                    }
                } else { // when there are some errors (or an error)
                    result = ""; // initialize the String result first
                    for (int i = 0; i < count; i++) {
                        result = result + (i + 1) + ". " + errorSelections[i] + "\n"; // and then make a loop to add all messages in one string
                    }
                    JOptionPane.showMessageDialog(null,
                            result,
                            "You have following problems:",
                            JOptionPane.ERROR_MESSAGE); // then show error messages(or an error message)
                }

            }
        });
        btnOk.setBounds(168, 210, 97, 23);
        contentPane.add(btnOk);

        // Settings for JButton 'btnCancel'
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e -> { // if Cancel button is clicked
            Booking booking = new Booking(); // generate Booking class object (
            booking.setVisible(true);
            dispose(); // close this sign up window
        });
        btnCancel.setBounds(277, 210, 97, 23);
        contentPane.add(btnCancel);
    }

    // id check
    private void idCheck(String id) throws IdFormatException, IdWIthBlankException {
        if ((id == null || id.isEmpty())) { // when id is empty
            throw new IdWIthBlankException();
        } else if (Pattern.matches("^[a-zA-Z0-9]*$", id) == false) { // when id doesn't follow the format
            throw new IdFormatException();
        }
    }

    // pw check
    private void pwCheck(String pw) throws PwFormatException, PwWIthBlankException {
        if ((pw == null || pw.isEmpty())) { // when pw is empty
            throw new PwWIthBlankException();
        } else if (Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", pw) == false) { // pw should be over 8, num+english+special symbol
            throw new PwFormatException();
        }
    }

    // name check
    private void nameCheck(String name) throws NameEmptyException, NameFormatException {
        if ((name == null || name.isEmpty())) { // when name is empty
            throw new NameEmptyException();
        } else if (Pattern.matches("(\\b[A-Za-z]+)( )([A-Za-z]+\\b)", name) == false) { // when name doesn't follow the format (write only surname or name)
            throw new NameFormatException();
        }
    }

    // birth check
    private void birthCheck(String birth) throws BirthFormatException, BirthWIthBlankException {
        if ((birth == null || birth.isEmpty())) { // when birth is empty
            throw new BirthWIthBlankException();
        } else if (Pattern.matches("^\\d{2}/\\d{2}/\\d{4}$", birth) == false) { // when birth doesn't follow the format
            throw new BirthFormatException();
        }
    }
}
