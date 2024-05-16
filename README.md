# codsoft_3
This repository contains Task 3


<h2>Task 3</h2>

<h3>ATM Interface</h3>
Create a class to represent the ATM machine. <br>
Design the user interface for the ATM, including options such as withdrawing, depositing, and
checking the balance.<br>
Implement methods for each option, such as withdraw(amount), deposit(amount), and
checkBalance().<br>
Create a class to represent the user's bank account, which stores the account balance.<br>
Connect the ATM class with the user's bank account class to access and modify the account
balance.<br>
Validate user input to ensure it is within acceptable limits (e.g., sufficient balance for withdrawals).<br>
Display appropriate messages to the user based on their chosen options and the success or failure
of their transactions.<br>

<h4>Code Briefing</h4>

BankAccount Class: <br> 
* Represents a bank account with attributes for the balance.<br> 
* Contains methods for showing the balance, depositing money, and withdrawing money.<br> 

ATMmac Class (Extends JFrame):<br> 
* Represents an ATM machine GUI.<br> 
* Contains text fields and buttons for depositing, withdrawing, and viewing balance.<br> 
* Implements ActionListener for button actions.<br> 

Constructor:<br> 
* Sets up the GUI window with appropriate size, title, and layout.<br> 
* Creates panels for input, buttons, and output.<br> 

Input Panel:<br> 
* Contains a label for entering the amount and a text field.<br> 

Button Panel:<br> 
* Contains buttons for deposit, withdraw, and view balance.<br> 
* Each button has an ActionListener attached to perform actions on button click.<br> 

Action Listeners:<br> 
* Deposit: Parses the input amount and deposits it into the account.<br> 
* Withdraw: Parses the input amount and withdraws it from the account if sufficient balance is available.<br> 

View Balance: Displays the current balance.<br> 

Output Panel:<br> 
* Displays messages such as deposit success, withdrawal success, or balance.<br> 
* Uses a JTextArea within a JScrollPane for displaying messages.<br> 

showMessage Method:<br> 
* Updates the text area with the provided message.<br> 

Main Method:<br> 
* Creates an instance of the BankAccount class with an initial balance of $5000.<br> 
* Creates an instance of the ATMmac class, passing the BankAccount object to it.<br> 
* Displays the ATM machine GUI.<br>
