package view;

import database.DB; // import DB for movie, user information
import model.Movie;
import service.MovieService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Info extends JDialog {

    private final JPanel contentPanel = new JPanel();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    DB.init();
                    Info frame = new Info("Crime City2");
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
    public Info(String movieName) {
        Movie movie = MovieService.getMovie(movieName);
        setTitle("Info");
        setBounds(100, 100, 371, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(null);

        // Settings for JLabel 'lblPoster'
        JLabel lblPoster = new JLabel("");
        lblPoster.setIcon(new ImageIcon(movie.getImage()));
        lblPoster.setBounds(0, 0, 162, 128);
        contentPanel.add(lblPoster);

        // Settings for JLabel 'lblMovieName'
        JLabel lblMovieName = new JLabel("Name: " + movie.getName());
        lblMovieName.setHorizontalAlignment(SwingConstants.LEFT);
        lblMovieName.setBounds(0, 138, 331, 15);
        contentPanel.add(lblMovieName);

        // Settings for JLabel 'lblGenre'
        JLabel lblGenre = new JLabel("Genre: " + movie.getGenre());
        lblGenre.setHorizontalAlignment(SwingConstants.LEFT);
        lblGenre.setBounds(0, 163, 331, 15);
        contentPanel.add(lblGenre);

        // Settings for JLabel 'lblCast'
        JLabel lblCast = new JLabel("Cast: " + movie.getCast());
        lblCast.setHorizontalAlignment(SwingConstants.LEFT);
        lblCast.setBounds(0, 188, 331, 15);
        contentPanel.add(lblCast);

        // Settings for JLabel 'lblPg'
        JLabel lblPg = new JLabel("Pg: " + movie.getPg());
        lblPg.setHorizontalAlignment(SwingConstants.LEFT);
        lblPg.setBounds(0, 213, 331, 15);
        contentPanel.add(lblPg);

        // Set Panel for button area first
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        getContentPane().add(buttonPane, BorderLayout.SOUTH);
        
        // Settings for JButton 'btnClose'
        JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // close this window
            }
        });
        btnClose.setActionCommand("Cancel");
        buttonPane.add(btnClose);
    }
}
