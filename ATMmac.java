import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BankAccount {
    double balance;

    BankAccount(double amount) {
        balance = amount;
    }

    double showBalance() {
        return balance;
    }

    void Deposit(double amount) {
        balance += amount;
    }

    int withdraw(double amount) {
        if(amount>balance) return 0;
        balance -= amount;
        return 1;
    }
}

class ATMmac extends JFrame {
    private JTextField amountField;
    private JTextArea textarea;

    ATMmac(BankAccount account) {
        setTitle("ATM Machine");
        setSize(400, 300);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout());
        mainpanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 1, 5, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JLabel amountLabel = new JLabel("Enter Amount: ");
        amountField = new JTextField();
        // amountField = new JTextField(10);

        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 15, 15));
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton balButton = new JButton("View Balance");

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountText = amountField.getText();
                try {
                    double amount = Double.parseDouble(amountText);
                    account.Deposit(amount);
                    showMessage("Deposit Successful!!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ATMmac.this, "Please Enter amount");
                    return;
                }
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountText = amountField.getText();
                try {
                    double amount = Double.parseDouble(amountText);
                    if(account.withdraw(amount)==0){
                        JOptionPane.showMessageDialog(ATMmac.this, "Withdraw Failed.");
                        showMessage("Insufficient Funds!!");
                    }
                    else showMessage("Withdraw Successful!!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ATMmac.this, "Please Enter amount");
                    return;
                }
            }
        });

        balButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    showMessage("Balance Available: "+account.showBalance());
            }
        });

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(balButton);

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        textarea = new JTextArea(5, 10);
        textarea.setEditable(false);
        JScrollPane scroll = new JScrollPane(textarea);

        outputPanel.add(scroll, BorderLayout.CENTER);

        mainpanel.add(inputPanel, BorderLayout.NORTH);
        mainpanel.add(buttonPanel, BorderLayout.CENTER);
        mainpanel.add(outputPanel, BorderLayout.SOUTH);

        add(mainpanel);
        setVisible(true);
    }

    public void showMessage(String message){
        textarea.setText(message);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        new ATMmac(account);
    }
}