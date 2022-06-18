package view;

import model.Movie;
import service.MovieService;
import service.UserService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reserve extends JDialog {

    private JPanel contentPane;
    private JLabel lblReserve;
    private JLabel lblPoster;
    private JLabel lblAdultChoice;
    private JLabel lblTeenChoice;
    private JLabel lblKidChoice;
    private JButton btnReserve;
    private JLabel lblMovieName;
    private JComboBox comboBoxAdult;
    private JComboBox comboBoxTeen;
    private JComboBox comboBoxKids;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Reserve frame = new Reserve("범죄도시2");
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
    public Reserve(String movieName) {
        Movie movie = MovieService.getMovie(movieName); // generate Movie class object

        setBounds(100, 100, 469, 394);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Settings for JLabel 'lucasLabel'
        lblReserve = new JLabel("Reserve");
        lblReserve.setBackground(new Color(51, 0, 102));
        lblReserve.setOpaque(true);
        lblReserve.setForeground(Color.WHITE);
        lblReserve.setHorizontalAlignment(SwingConstants.CENTER);
        lblReserve.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblReserve.setBounds(0, 0, 453, 37);
        contentPane.add(lblReserve);

        // Settings for JLabel 'lblPoster'
        lblPoster = new JLabel("");
        lblPoster.setBounds(10, 47, 220, 145);
        lblPoster.setIcon(new ImageIcon(movie.getImage()));
        contentPane.add(lblPoster);

        // Settings for JLabel 'lblAdultChoice'
        lblAdultChoice = new JLabel("Adult");
        lblAdultChoice.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdultChoice.setBounds(152, 214, 57, 15);
        contentPane.add(lblAdultChoice);

        // Settings for JLabel 'lblTeenChoice'
        lblTeenChoice = new JLabel("Teenager");
        lblTeenChoice.setHorizontalAlignment(SwingConstants.CENTER);
        lblTeenChoice.setBounds(152, 247, 57, 15);
        contentPane.add(lblTeenChoice);

        // Settings for JLabel 'lblKidChoice'
        lblKidChoice = new JLabel("Kid");
        lblKidChoice.setHorizontalAlignment(SwingConstants.CENTER);
        lblKidChoice.setBounds(152, 282, 57, 15);
        contentPane.add(lblKidChoice);

        // Settings for JLabel 'lblMovieName'
        lblMovieName = new JLabel(movie.getName());
        lblMovieName.setFont(new Font("굴림", Font.BOLD, 16));
		lblMovieName.setHorizontalAlignment(SwingConstants.CENTER);
        lblMovieName.setBounds(250, 108, 142, 53);
        contentPane.add(lblMovieName);

        // Settings for JButton 'btnReserve'
        btnReserve = new JButton("Reserve");
        btnReserve.setBounds(185, 322, 97, 23);
        btnReserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// for finding out how many tickets are picked (for each age)
                int adult = Integer.parseInt(comboBoxAdult.getSelectedItem().toString());
                int teen = Integer.parseInt(comboBoxTeen.getSelectedItem().toString());
                int kid = Integer.parseInt(comboBoxKids.getSelectedItem().toString());
                String result = UserService.reserve(movie, adult, teen, kid); 
                if ("success".equals(result)) {
                    JOptionPane.showMessageDialog(null,
                            "Successfully Submitted",
                            "Success Message",
                            JOptionPane.PLAIN_MESSAGE); // show success message
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null,
                            result,
                            "You have following problems:",
                            JOptionPane.ERROR_MESSAGE); // show error message
                }
            }
        });
        contentPane.add(btnReserve);

        // Settings for JComboBox for adult, teenager, kid for buying ticket (different price)
        comboBoxAdult = new JComboBox();
        comboBoxAdult.setModel(new DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        comboBoxAdult.setBounds(221, 210, 75, 23);
        contentPane.add(comboBoxAdult);

        comboBoxTeen = new JComboBox();
        comboBoxTeen.setModel(new DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        comboBoxTeen.setBounds(221, 243, 75, 23);
        contentPane.add(comboBoxTeen);

        comboBoxKids = new JComboBox();
        comboBoxKids.setModel(new DefaultComboBoxModel(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
        comboBoxKids.setBounds(221, 278, 75, 23);
        contentPane.add(comboBoxKids);
    }
}
