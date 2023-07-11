import java.util.Scanner;

interface MessagingService {
    void sendMessage();

}
class SMSMessagingService implements MessagingService
{
    @Override
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number to which the message to be sent: ");
        long number=scanner.nextLong();
        System.out.println("Enter your message: ");
        String message=scanner.next();
        String str=String.valueOf(number);
        if(str.matches("[6-9]\\d{9}"))
        {
            System.out.println("SMS SENT SUCCESSFULLY!!");
            System.out.println("Message sent to: "+message);
            System.out.println("Message: "+number);
        }
        else
        {
            System.out.println("Please enter correct phone number!!");
        }

    }
}
class EmailMessagingService implements MessagingService
{
    @Override
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the email id to which the message to be sent: ");
        String email=scanner.next();
        System.out.println("Enter your subject: ");
        String subject=scanner.next();
        System.out.println("Enter your message: ");
        String message=scanner.next();
        if(email.matches("^[A-Za-z0-9+_.-]+@(.+)$"))
        {
            System.out.println("EMAIL SENT SUCCESSFULLY!!");
            System.out.println("Email sent to: "+email);
            System.out.println("Subject: "+subject);
            System.out.println("Message: "+message);
        }
        else
        {
            System.out.println("Please enter valid email id");
        }
    }
}
class WhatsAppMessagingService implements MessagingService
{

    @Override
    public void sendMessage() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number to which the message to be sent: ");
        long number=scanner.nextLong();
        System.out.println("Enter your message: ");
        String message=scanner.next();
        System.out.println("Enter YES if you are a whatsapp user! Else NO ");
        String whatsapp=scanner.next();
        String str=String.valueOf(number);
        if(str.matches("[6-9]\\d{9}") && whatsapp.equals("YES"))
        {
            System.out.println("WHATSAPP MESSAGE SENT SUCCESSFULLY!!");
            System.out.println("Message: "+number);
            System.out.println("Message sent to: "+message);

        }
        else if(!str.matches("[6-9]\\d{9}"))
        {
            System.out.println("Please enter a valid number");
        }
        else if(whatsapp.equals("NO"))
        {
            System.out.println("Your number doesn't exist in Whatsapp");
        }

    }

}
public class Message {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Do you want to a) SMS or b) WHATSAPP or c) EMAIL?");
        String ch=scanner.next();
        MessagingService smsMessagingService = new SMSMessagingService();
        MessagingService emailMessagingService = new EmailMessagingService();
        MessagingService whatsappMessagingService = new WhatsAppMessagingService();
        if(ch.equals("a"))
        {
            smsMessagingService.sendMessage();
        }
        else if(ch.equals("b"))
        {
            whatsappMessagingService.sendMessage();
        }
        else if(ch.equals("c"))
        {
            emailMessagingService.sendMessage();
        }
    }
}
