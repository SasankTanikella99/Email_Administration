package Email_Administration;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String email;
    private String company_suffix_email = ".anime.com";
    private String password;
    private String department;
    private int defaultPasswordLength = 10;
    private int mailbox_capacity;
    private String alternate_email;

    //constructor for receiving input first and last names
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        System.out.println(" Your email has been created : " + firstName + " " + lastName);

        //function call for the department
        this.department = setDepartment();
        System.out.println("Department is: " + department);

        //function call for returning random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("password is set: " + this.password);

        //combining elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + company_suffix_email;
    }

    // ask for department
    private String setDepartment(){
        System.out.print("Enter the department code: \n 1 for sales \n 2 for development \n 3 for accounting \n 0 for none of the above \n Please choose: ");
        Scanner in  = new Scanner(System.in);
        int choice_of_department = in.nextInt();
        return switch (choice_of_department) {
            case 1 -> "sales";
            case 2 -> "development";
            case 3 -> "accounting";
            case 0 -> "None of the above";
            default -> "Please select a valid department (0-3)";
        };
    }

    // Generate a random password
    private String randomPassword(int length){
        String setPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
            int random = (int)(Math.random() * setPassword.length());
            password[i] = setPassword.charAt(random);
        }
        return new String(password);
    }
    // Set the mailbox capacity
    public void setMailBoxCapacity(int capacity){
        this.mailbox_capacity = capacity;
    }
    // Set the alternate email
    public void setAlternateEmail(String alt){
        this.alternate_email = alt;
    }

    // Change the password
    public void Change_Password(String pwd){
        this.password = pwd;
    }

    // Get Methods
    public int getMailbox_capacity(){
        return mailbox_capacity;
    }

    public String getAlternate_email(){
        return alternate_email;
    }

    public String getPassword(){
        return password;
    }

    public String ShowInformation(){
        return "Name: " + firstName + " " + lastName + " " + " Email: " + email + " " + " Mailbox capacity: " + mailbox_capacity;
    }

}
