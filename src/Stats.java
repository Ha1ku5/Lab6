
//necessary imports for file i/o
import java.io.*;
import java.sql.SQLOutput;
import java.util.Scanner; //reads from stream


/**
 * Write a description of class Stats here.
 * 
 * @author Alexander Leatha
 * @version (a version number or a date)
 */
public class Stats {
    public static void main(String[] args) throws IOException{  
        // Scanner and PrintWrite must be declared outside the try block
        // otherwise their scope will be limited to within the block 
        Scanner input = null;
        
        double inputNumber = 0.0;
        
        int negNum = 0;
        int btw0and100 = 0;
        int geq100 = 0;
        
        int lineCounter = 0;
        double grandTotal = 0.0;
        
        double min = 9999999.9;
        double max = 0.0;
        double average = 0.0;
        
        try {            
           input = new Scanner(new FileInputStream("fileIn.txt"));
           
        } 
        catch (IOException e) {
           System.out.println("File not found.");
           System.exit(0);
        } 
        //scanning through file and updating variables accordingly
        while (input.hasNext()){
            inputNumber = input.nextDouble();
            lineCounter++;
            grandTotal += inputNumber;

            if(inputNumber > max)
                max = inputNumber;
            if(inputNumber < min)
                min = inputNumber;

            if(inputNumber < 0) {
                negNum++;
            }
            else if (inputNumber >= 0 && inputNumber <= 100) {
                btw0and100++;
            }
            else {
                geq100++;
            }
        }

        input.close();
        average = grandTotal / lineCounter;
        display(average, max, min, lineCounter, negNum, btw0and100, geq100);
    }

    public static void display (double average, double max, double min, double lineCounter, int negNum, int btw0and100, int geq100){
    
        PrintWriter output = null;
        try{
            output = new PrintWriter(new FileOutputStream("fileOut.txt"));
                
        } catch (IOException e) {
            System.out.println(" Sorry, we cannot locate the file!");
            System.exit(0);
        }
        //output stuff to file here
        output.println(" Statistics for the numbers in fileIn.txt:");
        output.println("average: " + average);
        output.println("max: " + max);
        output.println("min: " + min);
        output.printf("There are <%d> negative numbers, <%d> numbers between 0 (inclusive) and 100 (exclusive), and <%d> numbers that are greater than or equal to 100.", negNum, btw0and100, geq100);

        output.close();
    }
}
