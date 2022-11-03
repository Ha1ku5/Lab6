import java.io.*;
import java.util.Scanner;

public class Advice {
    public static void main(String[] args) {

        //prints advice file to screen
        try{
            Scanner fileRead = new Scanner(new FileInputStream("advice.txt"));
            System.out.println(fileRead);
        } catch (FileNotFoundException e){
            System.out.println(" THERE IS NO FILE. BAD. ERROR.");
            System.exit(0);
        }


        System.out.println("What is your coding advice to pass on? ");
        //writing to advice file
        PrintWriter out = null;
        try {
            out = new PrintWriter(new FileOutputStream("advice.txt"));
            Scanner input = new Scanner(System.in);

        } catch (FileNotFoundException e) {
            System.out.println(" THERE IS NO FILE ");
            System.exit(0);
        }
        PrintWriter outToLog = null;
        try {
            outToLog = new PrintWriter(new FileOutputStream("adviceLog.txt"));

        } catch (FileNotFoundException e) {
            System.out.println(" THERE IS NO FILE ");
            System.exit(0);
        }



    }



}
