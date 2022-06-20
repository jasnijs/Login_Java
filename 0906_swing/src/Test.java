import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Test implements ActionListener {

    // Izvilku visus objektus ārpus metodēm, lai varētu pielietot tās vairākās uzreiz
    private static JLabel label, emailLabel, passLabel, passConfLabel, error, username, yourEmail, yourPass,
            yourInfo;
    private static JTextField nameField, emailField;
    private static JPasswordField passField, passConfField;
    private static JCheckBox seePass;
    public static String user, email, pass ,passConf;

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();


    public void tester() {

//    JFrame frame = new JFrame();
//    JPanel panel = new JPanel();

        frame.setSize(430,270);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Registration");
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);

        // Login Label
        label = new JLabel("Login:");
        label.setBounds(50,30,90,25);
        panel.add(label);

        // Login input
        nameField = new JTextField();
        nameField.setBounds(170,30,170,25);
        panel.add(nameField);

        // Email Label
        emailLabel = new JLabel("E-mail:");
        emailLabel.setBounds(50,60,90,25);
        panel.add(emailLabel);

        // Email input
        emailField = new JTextField();
        emailField.setBounds(170,60,170,25);
        panel.add(emailField);

        // Pass Label
        passLabel = new JLabel("Password:");
        passLabel.setBounds(50,90,120,25);
        panel.add(passLabel);

        // Pass input
        passField = new JPasswordField();
        passField.setBounds(170,90,170,25);
        panel.add(passField);

        // Pass conf Label
        passConfLabel = new JLabel("Confirm password:");
        passConfLabel.setBounds(50,120,120,25);
        panel.add(passConfLabel);

        // Pass conf input
        passConfField = new JPasswordField();
        passConfField.setBounds(170,120,170,25);
        panel.add(passConfField);

        // Input button
        JButton btn = new JButton("Enter");
        btn.setBounds(215,160,80,20);
        btn.setBackground(new Color(224,255,255));
        panel.add(btn);
        btn.addActionListener(this);

        // Error message
        error = new JLabel();
        error.setBounds(175,190,200,25);
        error.setForeground(new Color(255, 0, 0));
        panel.add(error);

        // Checkbox to see or hide password
        seePass = new JCheckBox();
        seePass.setBounds(342, 92, 20, 20);
        panel.add(seePass);
        seePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(seePass.isSelected()){
                    // Means that if checked, then password is no longer hidden
                    passField.setEchoChar((char)0);
                    passConfField.setEchoChar((char)0);
                }
                else {
                    // char code for pass symbol
                    passField.setEchoChar('\u2022');
                    passConfField.setEchoChar('\u2022');
                }
            }
        });

//        // Your Info
//        yourInfo = new JLabel();
//        yourInfo.setBounds(130,180,200,60);
//        panel.add(yourInfo);

}

// Method to remove everything from panel
public void update() {
        panel.removeAll();
}

// Šim pēc būtības būtu jābūt atsevišķā class failā, bet man nesanāca to panākt tā, lai strādātu kā iecerēts
public void acc(){
//    JFrame frame = new JFrame();
//    JPanel panel = new JPanel();

    // Here, before executing rest of the program, it first clears all previous statements
    update();

    frame.setSize(360,200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("User Info");
    frame.setVisible(true);
    frame.add(panel);

    panel.setLayout(null);
    panel.setBackground(new Color(144, 238, 144));

    // User label
    label = new JLabel("Username:");
    label.setBounds(50,30,90,25);
    panel.add(label);

    // Username
    username = new JLabel();
    username.setBounds(130,30,170,25);
    panel.add(username);

    // Email label
    emailLabel = new JLabel("E-mail:");
    emailLabel.setBounds(50,60,90,25);
    panel.add(emailLabel);

    // Your e-mail
    yourEmail = new JLabel();
    yourEmail.setBounds(130,60,170,25);
    panel.add(yourEmail);

    // Pass label
    passLabel = new JLabel("Password:");
    passLabel.setBounds(50,90,120,25);
    panel.add(passLabel);

    // Your pass
    yourPass = new JLabel();
    yourPass.setBounds(130,90,170,25);
    panel.add(yourPass);
}

    @Override
    public void actionPerformed(ActionEvent e) {

//        if(seePass.isSelected()){
//            passField.setEchoChar((char)0);
//            passConfField.setEchoChar((char)0);
//        }
//        else {
//            passField.setEchoChar('\u2022');
//            passConfField.setEchoChar('\u2022');
//        }

        user = nameField.getText();
        email = emailField.getText();
        pass = passField.getText();
        passConf = passConfField.getText();

                // Checks if any of fields contain blanks
                if (user.isBlank() || email.isBlank() || pass.isBlank() || passConf.isBlank()) {
                    error.setText("Please fill the blanks");
                    return;
                }
                // Compares both password inputs if they match
                if (!pass.equals(passConf)) {
                    error.setText("Password does not match");
                    passField.setBackground(new Color(240,90,90));
                    passConfField.setBackground(new Color(240,90,90));
                    return;
                }

             // After all the checkups and successful execution, second panel is called
            acc();

                username.setText(user);
                yourEmail.setText(email);
                yourPass.setText(pass);

//        yourInfo.setText("Username: " + user + "\n"
//                + "E-mail: " + email + "\n"
//                + "Your password: " + pass);

    }

}
