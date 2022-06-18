package view;

import model.Timeline;
import service.TimelineService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TimelineList extends JFrame {

    private JPanel contentPane;
    private JLabel lblBuyList;
    private JButton btnClose;
    private JTextArea textArea;
    private JScrollPane jScrollPane;
    private WorkerClass worker;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {               
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TimelineList frame = new TimelineList();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public TimelineList() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 343, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Settings for JLabel 'lblBuyList'
        lblBuyList = new JLabel("Buy List");
        lblBuyList.setBackground(new Color(51, 0, 102));
        lblBuyList.setOpaque(true);
        lblBuyList.setForeground(Color.WHITE);
        lblBuyList.setHorizontalAlignment(SwingConstants.CENTER);
        lblBuyList.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        lblBuyList.setBounds(0, 0, 327, 37);
        contentPane.add(lblBuyList);

        // Settings for JTextArea 'textArea' (for using multi threads and scroll)
        textArea = new JTextArea();
        // for adding sroll in text area
        jScrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setBounds(0, 42, 327, 546);
        contentPane.add(jScrollPane);

        // Settings for JButton 'btnClose'
        btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Booking booking = new Booking(); 
                booking.setVisible(true);
                dispose();
            }
        });
        btnClose.setBounds(218, 598, 97, 23);
        contentPane.add(btnClose);
    }

    // Settings for showTimeline method
    public void showTimeline() {
        textArea.setText(""); // set textArea into empty before it starts
        List<Timeline> timeLineList = TimelineService.getTimeline();

        // thread
        worker = new WorkerClass(timeLineList);
        worker.execute();
    }


    private class WorkerClass extends SwingWorker<String, Timeline> {
        List<Timeline> timelineList;
        int num;

        public WorkerClass(List<Timeline> timelineList) { 
        	// WorkerClass constructor (initializes timelineList and num)
            this.timelineList = timelineList;
            num = 0;
        }

        
        @Override // run when worker.execute runs
        protected String doInBackground() throws Exception { // show buy list
            try {
                for (Timeline timeline : timelineList) {
                    publish(timeline);
                    Thread.sleep(3000);
                }
                return "success";
            } catch (Exception e) {
                return "thread error";
            }
        }

        
        // Settings for process method
        @Override
        protected void process(List<Timeline> chunks) {
            for (int i = 0; i < chunks.size(); i++) {
                Timeline timeline = chunks.get(i);
                String line = "";
                line += "movieName : " + timeline.getMovieName() + "\n";
                line += "paymentDate : " + timeline.getPaymentDate() + "\n";
                line += "adult : " + timeline.getAdult() + "\n";
                line += "teen : " + timeline.getTeen() + "\n";
                line += "kid : " + timeline.getKid() + "\n";
                line += "totalPrice : " + timeline.getTotalPrice() + "\n\n";
                textArea.append(line); // append every line (not setText but append)
                textArea.setCaretPosition(textArea.getDocument().getLength()); // for scrolling till last
                num++;
            }
        }

        
        @Override
        protected void done() {

        }
    }
}

