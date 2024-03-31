import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class bloodyyyGUI extends JFrame {

    // creating the class that will have the JFrame in it
    // declaring the variables that will be in this class
    private JPanel panel;
    private JTextField yourName, yourid, bloodtype, rh;

    private JButton submit;

    public bloodyyyGUI() {
        // constructor of the class, basically sets the dedault for all the variables
        setTitle("Worcestser Blood Donation Group");
        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(new GridLayout(2,3));

        // creating a JLabel and Textfield to allow the user to input their name
        JLabel name = new JLabel("Name:");
        yourName = new JTextField();
        panel.add(name);
        panel.add(yourName);

        // creating a JLabel and Textfield to allow the user to input their id
        JLabel id = new JLabel("ID Number:");
        yourid = new JTextField();
        panel.add(id);
        panel.add(yourid);

        // creating a JLabel and Textfield to allow the user to input their blood type
        JLabel blood = new JLabel("Blood Type:");
        bloodtype= new JTextField();
        panel.add(blood);
        panel.add(bloodtype);

        // creating a JLabel and Textfield to allow the user to input their rh Factor

        JLabel rhlabel= new JLabel("Rh Factor:");
         rh = new JTextField();
        panel.add(rhlabel);
        panel.add(rh);


        // creating a JButton that allows the user to sumbut their data

        JButton submit = new JButton("Submit my data to the database");
        submit.addActionListener(new submitbuttonfunctionality());
        panel.add(submit);



        add(panel);
        setVisible(true);
    }

    // creating a nested class (trying something new to make code less messy and more flexible)
    // the class serves as an event listener for the submit button
    // when the sumbut button is clicked, the actionperfoemd method of the subclass is invoked

    private class submitbuttonfunctionality implements ActionListener {
        // implementing the actionlistener means the class basically has all of the
        // methods that help the actionlistener interface
        public void actionPerformed(ActionEvent e) {
            // taking the user input from the textfield
            String name = yourName.getText();
            String id = yourid.getText();
            String bloodType = bloodtype.getText();
            String rhFactor = rh.getText();

            if (bloodType.isEmpty() || rhFactor.isEmpty()) {
                // using a logical operator and default method to combine two condtions
                int choice = JOptionPane.showConfirmDialog(panel, "Do you not know your blood type and rh factor?", "Blood Data", JOptionPane.YES_NO_OPTION);
                // if the textfields are empty when the button is clicked, a message dialog box pops up
                if (choice == JOptionPane.YES_OPTION) {
                    // nested condiyion statement which calls the hospital class if yes is clicked on the message dialog box
                   hospital();
                } else {
                    // if no is clicked the confirmation method is called
                    confirmation();
                }
            }
        }
    }

    private void hospital() {
        // creating a class which allows the user to select a hospital
        JPanel hospitalpanel = new JPanel();
        hospitalpanel.setLayout(new FlowLayout());

        JLabel hospitalLabel = new JLabel("Please choose the hospital nearest to you:");
        // creating a JCombobox to allow the user to choose from a list of hospitals
        JComboBox<String> hospitalComboBox = new JComboBox<>(new String[]{"Adcare Hospital", "Worcester Recovery Center and Hospital", "UMass Memorial HealthCare", "Saint Vincent Hospital", "Hanehmann Hospital",});
        hospitalpanel.add(hospitalLabel);
        hospitalpanel.add(hospitalComboBox);

        JButton search = new JButton("Search");
        // when the search button is clicked, a showmessagediaolog box will show up to schedule an appointment
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(hospitalpanel, "Please call +7744200039 to book a blood testing appointment to determine your blood type. This can save your life in an emergency.");
            }
        });
        hospitalpanel.add(search);

        JOptionPane.showMessageDialog(panel, hospitalpanel);
    }

    private void confirmation() {
        // creates the confirmation class to show the confrimation label
        JPanel confirmationpanel = new JPanel();
        confirmationpanel.setLayout(new BorderLayout());

        JLabel confirmationlabel = new JLabel("Thank you. Your data has been added to the database.");
        confirmationpanel.add(confirmationlabel, BorderLayout.CENTER);

        getContentPane().removeAll(); // Remove previous components
        add(confirmationpanel);
        revalidate(); // Revalidate the JFrame to reflect changes
        repaint(); // Repaint the JFrame

        JOptionPane.showMessageDialog(panel, confirmationpanel);
        // new functiion of showmessagedialog: centering the box on the parent panel
    }

    public static void main(String[] args)
    // creating an instance of the bloodyGUI class
    {
        new bloodyyyGUI();
    }
}
