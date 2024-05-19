import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
        setSize(500, 350);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new BorderLayout(10, 10));
        mainpanel.setBorder(new EmptyBorder(10,10,10,10));
        mainpanel.setBackground(new Color(44, 44, 44));

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(44, 44, 44));
        inputPanel.setLayout(new GridLayout(2, 1, 0, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        JLabel amountLabel = new JLabel("Enter Amount: ");
        amountLabel.setForeground(new Color(255, 255, 255));
        amountField = new JTextField();
        // amountField.setFocusable(false);
        amountField.setBackground(new Color(58, 58, 58));
        amountField.setForeground(new Color(255, 255, 255));
        amountField.setBorder(BorderFactory.createLineBorder(new Color(58, 58, 58), 2));
        amountField.setPreferredSize(new Dimension(200, 30));
        amountField.setFont(new Font("Arial", Font.PLAIN, 18));  // Set font to Arial, plain style, size 18
        amountField.setCaretColor(Color.white);


        inputPanel.add(amountLabel);
        inputPanel.add(amountField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 15, 15));
        buttonPanel.setBackground(new Color(44, 44, 44));
        JButton depositButton = new JButton("Deposit");
        depositButton.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 7), 0));
        depositButton.setBackground(new Color(240, 240, 7));
        depositButton.setFocusable(false);
        depositButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                depositButton.setBackground(new Color(123, 242, 53)); // Darker orange for hover
            }
            public void mouseExited(MouseEvent evt) {
                depositButton.setBackground(new Color(240, 240, 7)); // Original orange
            }
            public void mouseClicked(MouseEvent evt){
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

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBackground(new Color(240, 240, 7));
        withdrawButton.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 7), 0));
        withdrawButton.setFocusable(false);
        withdrawButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                withdrawButton.setBackground(new Color(255, 53, 46)); // Darker orange for hover
            }
            public void mouseExited(MouseEvent evt) {
                withdrawButton.setBackground(new Color(240, 240, 7)); // Original orange
            }
            public void mouseClicked(MouseEvent evt){
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


        JButton balButton = new JButton("View Balance");
        balButton.setBackground(new Color(240, 240, 7));
        balButton.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 7), 0));
        balButton.setFocusable(false);
        balButton.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) {
                balButton.setBackground(new Color(12, 146, 242)); // Darker orange for hover
            }
            public void mouseExited(MouseEvent evt) {
                balButton.setBackground(new Color(240, 240, 7)); // Original orange
            }
            public void mouseClicked(MouseEvent evt){
                showMessage("Balance Available: "+account.showBalance());
            }
        });
        

        buttonPanel.add(depositButton);
        buttonPanel.add(withdrawButton);
        buttonPanel.add(balButton);

        JPanel outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        outputPanel.setBackground(new Color(44, 44, 44));

        textarea = new JTextArea(5, 10);
        textarea.setEditable(false);
        textarea.setBackground(new Color(58, 58, 58));
        textarea.setForeground(new Color(255, 255, 255));
        textarea.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 0));
        textarea.setFont(new Font("Anona", Font.PLAIN, 18));  // Set font to Arial, plain style, size 18


        // JScrollPane scroll = new JScrollPane(textarea);

        outputPanel.add(textarea, BorderLayout.CENTER);

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
