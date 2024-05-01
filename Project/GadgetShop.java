import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GadgetShop extends JFrame {
    private ArrayList<Gadget> gadgets;
    private JTextField txtModel, txtPrice, txtWeight, txtSize, txtCredit, txtMemory, txtPhoneNo, txtDuration, txtDownload, txtDisplayNumber;
    
    public GadgetShop() {
        gadgets = new ArrayList<>();
 
        
        txtModel = new JTextField(10);
        txtPrice = new JTextField(5);
        txtWeight = new JTextField(5);
        txtSize = new JTextField(10);
        txtCredit = new JTextField(5);
        txtMemory = new JTextField(5);
        txtPhoneNo = new JTextField(10);
        txtDuration = new JTextField(5);
        txtDownload = new JTextField(5);
        txtDisplayNumber = new JTextField(5);

        JButton btnAddMobile = new JButton("Add Mobile");
        JButton btnAddMP3 = new JButton("Add MP3");
        JButton btnClear = new JButton("Clear");
        JButton btnDisplayAll = new JButton("Display All");
        JButton btnMakeCall = new JButton("Make A Call");
        JButton btnDownloadMusic = new JButton("Download Music");

        
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        
        add(new JLabel("Model:"));
        add(txtModel);
        add(new JLabel("Price:"));
        add(txtPrice);
        add(new JLabel("Weight:"));
        add(txtWeight);
        add(new JLabel("Size:"));
        add(txtSize);
        add(new JLabel("Credit:"));
        add(txtCredit);
        add(new JLabel("Memory:"));
        add(txtMemory);
        add(btnAddMobile);
        add(btnAddMP3);
        add(btnClear);
        add(btnDisplayAll);
        add(new JLabel("Phone No:"));
        add(txtPhoneNo);
        add(new JLabel("Duration:"));
        add(txtDuration);
        add(new JLabel("Download:"));
        add(txtDownload);
        add(new JLabel("Display Number:"));
        add(txtDisplayNumber);
        add(btnMakeCall);
        add(btnDownloadMusic);

       
        btnAddMobile.addActionListener(e -> addMobile());
        btnAddMP3.addActionListener(e -> addMP3());
        btnClear.addActionListener(e -> clearTextFields());
        btnDisplayAll.addActionListener(e -> displayAllGadgets());
        btnMakeCall.addActionListener(e -> makeACall());
        btnDownloadMusic.addActionListener(e -> downloadMusic());

        
        setTitle("Gadget Shop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    
    private void addMobile() {
    try {
        String model = txtModel.getText().trim();
        double price = Double.parseDouble(txtPrice.getText().trim());
        int weight = Integer.parseInt(txtWeight.getText().trim());
        String size = txtSize.getText().trim();
        int credit = Integer.parseInt(txtCredit.getText().trim());

        
        if (model.isEmpty() || price <= 0 || weight <= 0 || size.isEmpty() || credit < 0) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields correctly", "Input Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Mobile newMobile = new Mobile(model, price, weight, size, credit);
            gadgets.add(newMobile);
            JOptionPane.showMessageDialog(this, "Mobile added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearTextFields();
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers for price, weight, and credit", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}

    private void addMP3() {
    try {
        String model = txtModel.getText().trim();
        double price = parseDouble(txtPrice.getText().trim());
        int weight = parseInt(txtWeight.getText().trim());
        String size = txtSize.getText().trim();
        int memory = parseInt(txtMemory.getText().trim());

        
        if (model.isEmpty() || price <= 0 || weight <= 0 || size.isEmpty() || memory <= 0) {
            JOptionPane.showMessageDialog(this, "Please fill out all fields correctly", "Input Error", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        MP3 newMP3 = new MP3(model, price, weight, size, memory);
        gadgets.add(newMP3);
        JOptionPane.showMessageDialog(this, "MP3 added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        clearTextFields();
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numbers for price, weight, and memory", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}

private double parseDouble(String text) throws NumberFormatException {
    if (text == null || text.isEmpty()) {
        throw new NumberFormatException("Input string is null or empty");
    }
    return Double.parseDouble(text);
}

private int parseInt(String text) throws NumberFormatException {
    if (text == null || text.isEmpty()) {
        throw new NumberFormatException("Input string is null or empty");
    }
    return Integer.parseInt(text);
}


    private void clearTextFields() {
        txtModel.setText("");
        txtPrice.setText("");
        txtWeight.setText("");
        txtSize.setText("");
        txtCredit.setText("");
        txtMemory.setText("");
        txtPhoneNo.setText("");
        txtDuration.setText("");
        txtDownload.setText("");
        txtDisplayNumber.setText("");
    }

    private void displayAllGadgets() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < gadgets.size(); i++) {
            builder.append("[").append(i).append("] ");
            gadgets.get(i).display(); 
            builder.append("\n");
        }
        JOptionPane.showMessageDialog(this, builder.toString(), "All Gadgets", JOptionPane.INFORMATION_MESSAGE);
    }

 private void makeACall() {
        try {
            int displayNumber = getDisplayNumber();
            String phoneNumber = getPhoneNumber();
            int duration = getDuration();

            if (displayNumber != -1 && displayNumber < gadgets.size()) {
                Gadget gadget = gadgets.get(displayNumber);
                if (gadget instanceof Mobile) {
                    ((Mobile) gadget).makeCall(phoneNumber, duration);
                } else {
                    JOptionPane.showMessageDialog(this, "Selected gadget is not a mobile", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Invalid display number", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for display number and duration", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getDisplayNumber() {
        String text = txtDisplayNumber.getText().trim();
        if (text.isEmpty() || !text.matches("\\d+")) {
            throw new NumberFormatException("Display number must be a non-negative integer");
        }
        return Integer.parseInt(text);
    }

    private String getPhoneNumber() {
        return txtPhoneNo.getText().trim();
       
    }

    private int getDuration() {
        String text = txtDuration.getText().trim();
        if (text.isEmpty() || !text.matches("\\d+")) {
            throw new NumberFormatException("Duration must be a non-negative integer");
        }
        return Integer.parseInt(text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GadgetShop::new);
    }


    private void downloadMusic() {
    try {
        int displayNumber = getDisplayNumber();
        int downloadSize = getDownloadSize();

        if (displayNumber != -1 && displayNumber < gadgets.size()) {
            Gadget gadget = gadgets.get(displayNumber);
            if (gadget instanceof MP3) {
                ((MP3) gadget).downloadMusic(downloadSize);
            } else {
                JOptionPane.showMessageDialog(this, "Selected gadget is not an MP3 player", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Invalid display number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Please enter valid numeric values for display number and download size", "Input Error", JOptionPane.ERROR_MESSAGE);
    }
}


private int getDownloadSize() {
    String text = txtDownload.getText().trim();
    if (text.isEmpty() || !text.matches("\\d+")) {
        throw new NumberFormatException("Download size must be a non-negative integer");
    }
    return Integer.parseInt(text);
}


    
    
}