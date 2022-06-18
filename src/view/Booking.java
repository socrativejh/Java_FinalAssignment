package view;

import database.DB;
import database.Status;
import service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Booking extends JFrame {

    private JPanel contentPane;
    private JLabel megaLogo;
    private JButton btnMovie;
    private JButton btnLogin;
    private JButton btnSignUp;
    private JButton btnLogout;
    private JButton btnMovieList;
    private JButton btnTimelineList;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UserService.readUser();
                DB.init();
                Booking frame = new Booking();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Booking() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 427);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        megaLogo = new JLabel("");
        megaLogo.setIcon(new ImageIcon("src/images/Megabox.jpeg"));
        megaLogo.setBounds(42, 38, 498, 147);
        contentPane.add(megaLogo);

        // Settings for JButton 'btnMovie'
        btnMovie = new JButton("Current Movie");
        btnMovie.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnMovie.setBounds(196, 191, 195, 37);
        btnMovie.setVisible(false);
        btnMovie.addActionListener(e -> { // if btnMovie is clicked 
            CurrentMovie currentMovie = new CurrentMovie(); // generate the CurrentMovie class object
            currentMovie.setVisible(true); // and make it visible (open current movie window)
            dispose(); // and close this window
        });
        contentPane.add(btnMovie);

        // Settings for JButton 'btnLogin'
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> { // if btnLogin is clicked 
            Login login = new Login(); // generate the Login class object
            login.setModal(true); 
            login.setVisible(true); // and make it visible (open login window)
            if (Status.getLoginUser() != null && !"".equals(Status.getLoginUser())) {
                setLoginView(); // if we successfully login set LoginView
            } else {
                setLogoutView(); // or if we don't set LogoutView
            }
        });
        btnLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnLogin.setBounds(196, 248, 195, 37);
        contentPane.add(btnLogin);

        // Settings for JButton 'btnSignUp'
        btnSignUp = new JButton("Sign Up"); 
        btnSignUp.addActionListener(e -> { // if btnSignUp is clicked 
            SignUp signUp = new SignUp(); // generate the SignUp class object
            signUp.setVisible(true); // and make it visible (open signUp window)
            this.setVisible(false);
        });
        btnSignUp.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnSignUp.setBounds(196, 307, 195, 37);
        contentPane.add(btnSignUp);

        // Settings for JButton 'btnMovieList'
        btnMovieList = new JButton("Movie List");
        btnMovieList.addActionListener(e -> { 
            CurrentMovie currentMovie = new CurrentMovie();
            currentMovie.setVisible(true);
            this.setVisible(false);
        });
        btnMovieList.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnMovieList.setBounds(196, 191, 195, 37);

        // Settings for JButton 'btnTimelineList'
        btnTimelineList = new JButton("Timeline List");
        btnTimelineList.addActionListener(e -> {
                    TimelineList timelineList = new TimelineList();
                    timelineList.setVisible(true);
                    timelineList.showTimeline(); // show the time line of purchased list
                    dispose(); // and then close the window
                }
        );
        btnTimelineList.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnTimelineList.setBounds(196, 248, 195, 37);

        // Settings for JButton 'btnLogout'
        btnLogout = new JButton("Logout");
        btnLogout.addActionListener(e -> {
            Status.setLoginUser(null); // set now login user into null (logout)
            setLogoutView(); // and show logout mode view
        });
        btnLogout.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        btnLogout.setBounds(196, 307, 195, 37);
        btnLogout.setVisible(false);

        // login check
        if (Status.getLoginUser() == null) {
            setLogoutView();
        } else {
            setLoginView();
        }
    }

    // when login is not success (logout mode->login, signUp button)
    private void setLogoutView() {
        btnLogin.setVisible(true);
        contentPane.add(btnLogin);

        btnSignUp.setVisible(true);
        contentPane.add(btnSignUp);

        btnLogout.setVisible(false);
        contentPane.remove(btnLogout);

        btnMovieList.setVisible(false);
        contentPane.remove(btnMovieList);

        btnTimelineList.setVisible(false);
        contentPane.remove(btnTimelineList);
    }

     // when login is success (login mode-> movieList, TimelineList, Logout button)
    private void setLoginView() {
        btnLogin.setVisible(false); 
        contentPane.remove(btnLogin);

        btnSignUp.setVisible(false);
        contentPane.remove(btnSignUp);

        btnLogout.setVisible(true);
        contentPane.add(btnLogout);

        btnMovieList.setVisible(true);
        contentPane.add(btnMovieList);

        btnTimelineList.setVisible(true);
        contentPane.add(btnTimelineList);
    }


}

