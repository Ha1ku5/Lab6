import java.io.*;
import java.util.Scanner;

public class Advice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userAdvice;

        //prints advice file to screen
        try{
            System.out.print("Your magical advice is...");
            Scanner fileRead = new Scanner(new FileInputStream("advice.txt"));
            System.out.println();
            while(fileRead.hasNext())
                System.out.println(fileRead.nextLine());
            fileRead.close();
            System.out.println();
        } catch (FileNotFoundException e){
            System.out.println("Looks like nobody has provided any advice for you!.");
        }

        //writing to advice file, as well as adding to adviceLog file
        PrintWriter out = null;
        PrintWriter log = null;
        try {
            out = new PrintWriter(new FileOutputStream("advice.txt"));
            log = new PrintWriter(new FileOutputStream("adviceLog.txt",true));

            //gets input from user until they hit the return key twice
            //puts that text into advice.txt and adviceLog.txt
            System.out.println("What is your coding advice to pass on? Hit return twice to exit.");
            userAdvice = input.nextLine();
            while(!userAdvice.equals("")){
                out.println(userAdvice);
                log.println(userAdvice);
                userAdvice = input.nextLine();
            }
            log.println();

        } catch (FileNotFoundException e) {
            System.out.println(" THERE IS NO FILE ");
            System.exit(0);
        }

        out.close();
        log.close();
    }



}
