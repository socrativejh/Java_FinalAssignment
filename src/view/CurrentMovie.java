package view;

import database.DB; // import DB for movie information
import service.MovieService;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class CurrentMovie extends JFrame {

    private JPanel contentPane;
    private JLabel labelMovie1;
    private JLabel labelMovie2;
    private JLabel labelMovie3;
    private JLabel labelMovie4;
    private JButton btnInfo1;
    private JButton btnReserve1;
    private JButton btnReserve2;
    private JButton btnInfo2;
    private JButton btnReserve3;
    private JButton btnInfo3;
    private JButton btnReserve5;
    private JButton btnInfo5;
    private JLabel labelMovie5;
    private JLabel labelMovie6;
    private JButton btnReserve4;
    private JButton btnInfo4;
    private JButton btnReserve6;
    private JButton btnInfo6;
    private JLabel movieLabel;
    private JButton btnBack;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DB.init();
                    CurrentMovie frame = new CurrentMovie();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public CurrentMovie() {
        setTitle("Current Showing Movie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 609, 727);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        movieLabel = new JLabel("Current Showing Movie");
        movieLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 21));
        movieLabel.setForeground(Color.WHITE);
        movieLabel.setHorizontalAlignment(SwingConstants.CENTER);
        movieLabel.setBackground(new Color(51, 0, 102));
        movieLabel.setOpaque(true);
        movieLabel.setBounds(0, 0, 593, 61);
        contentPane.add(movieLabel);

        
        /**
    	 * Settings for JLabel
    	 * - bring movie name from DB
    	 * - get image file by using movie name
    	 */
        
        String movieName1;
        String movieName2;
        String movieName3;
        String movieName4;
        String movieName5;
        String movieName6;
        
        
        movieName1 = DB.names.get(0); // bring name from DB
        labelMovie1 = new JLabel("");
        labelMovie1.setIcon(new ImageIcon(MovieService.getMovie(movieName1).getImage())); // get image by using movie name
        labelMovie1.setBounds(12, 97, 187, 210);
        contentPane.add(labelMovie1);

        movieName2 = DB.names.get(1);
        labelMovie2 = new JLabel("");
        labelMovie2.setIcon(new ImageIcon(MovieService.getMovie(movieName2).getImage()));
        labelMovie2.setBounds(211, 96, 174, 213);
        contentPane.add(labelMovie2);

        movieName3 = DB.names.get(2);
        labelMovie3 = new JLabel("");
        labelMovie3.setIcon(new ImageIcon(MovieService.getMovie(movieName3).getImage()));
        labelMovie3.setBounds(407, 96, 174, 213);
        contentPane.add(labelMovie3);

        movieName5 = DB.names.get(4);
        labelMovie4 = new JLabel("");
        labelMovie4.setIcon(new ImageIcon(MovieService.getMovie(movieName5).getImage()));
        labelMovie4.setBounds(215, 352, 174, 227);
        contentPane.add(labelMovie4);

        movieName6 = DB.names.get(5);
        labelMovie5 = new JLabel("");
        labelMovie5.setIcon(new ImageIcon(MovieService.getMovie(movieName6).getImage()));
        labelMovie5.setBounds(407, 352, 174, 227);
        contentPane.add(labelMovie5);

        // 원래 여기서 movieName6 = DB.names.get(5);
        movieName4 = DB.names.get(3);
        labelMovie6 = new JLabel("");
        labelMovie6.setIcon(new ImageIcon(MovieService.getMovie(movieName4).getImage()));
        labelMovie6.setBounds(12, 352, 187, 227);
        contentPane.add(labelMovie6);

        /**
    	 * Settings for JButton Info and Reserve
    	 * - when we click info or reserve button each class object is generated
    	 * - and then make that object visible
    	 */
        btnInfo1 = new JButton("Info");
        btnInfo1.setBounds(127, 319, 72, 23);
        btnInfo1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Info info = new Info(movieName1);
                info.setVisible(true);
            }
        });
        contentPane.add(btnInfo1);

        btnReserve1 = new JButton("Reserve");
        btnReserve1.setBounds(12, 319, 100, 23);
        btnReserve1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reserve reserve = new Reserve(movieName1);
                reserve.setVisible(true);
            }
        });
        contentPane.add(btnReserve1);

        btnReserve2 = new JButton("Reserve");
        btnReserve2.setBounds(215, 319, 90, 23);
        btnReserve2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reserve reserve = new Reserve(movieName2);
                reserve.setVisible(true);
            }
        });
        contentPane.add(btnReserve2);

        btnInfo2 = new JButton("Info");
        btnInfo2.setBounds(317, 319, 72, 23);
        btnInfo2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Info info = new Info(movieName2);
                info.setVisible(true);
            }
        });
        contentPane.add(btnInfo2);

        btnReserve3 = new JButton("Reserve");
        btnReserve3.setBounds(407, 319, 90, 23);
        btnReserve3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reserve reserve = new Reserve(movieName3);
                reserve.setVisible(true);
            }
        });
        contentPane.add(btnReserve3);

        btnInfo3 = new JButton("Info");
        btnInfo3.setBounds(509, 319, 72, 23);
        btnInfo3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Info info = new Info(movieName3);
                info.setVisible(true);
            }
        });
        contentPane.add(btnInfo3);

        btnReserve4 = new JButton("Reserve");
        btnReserve4.setBounds(12, 589, 100, 23);
        btnReserve4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reserve reserve = new Reserve(movieName4);
                reserve.setVisible(true);
            }
        });
        contentPane.add(btnReserve4);

        btnInfo4 = new JButton("Info");
        btnInfo4.setBounds(127, 589, 72, 23);
        btnInfo4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Info info = new Info(movieName4);
                info.setVisible(true);
            }
        });
        contentPane.add(btnInfo4);

        btnReserve5 = new JButton("Reserve");
        btnReserve5.setBounds(215, 589, 90, 23);
        btnReserve5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reserve reserve = new Reserve(movieName5);
                reserve.setVisible(true);
            }
        });
        contentPane.add(btnReserve5);

        btnInfo5 = new JButton("Info");
        btnInfo5.setBounds(317, 589, 72, 23);
        btnInfo5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Info info = new Info(movieName5);
                info.setVisible(true);
            }
        });
        contentPane.add(btnInfo5);

        btnReserve6 = new JButton("Reserve");
        btnReserve6.setBounds(407, 589, 90, 23);
        btnReserve6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reserve reserve = new Reserve(movieName6);
                reserve.setVisible(true);
            }
        });
        contentPane.add(btnReserve6);

        btnInfo6 = new JButton("Info");
        btnInfo6.setBounds(509, 589, 72, 23);
        btnInfo6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Info info = new Info(movieName6);
                info.setVisible(true);
            }
        });
        contentPane.add(btnInfo6);

        // Settings for JButton 'Back'
        btnBack = new JButton("Back");
        btnBack.setBounds(255, 655, 97, 23);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // when we click Back button
                Booking booking = new Booking(); // it goes back to Booking window
                booking.setVisible(true);
                dispose(); // and dispose this current movie window
            }
        });
        contentPane.add(btnBack);
    }
}
