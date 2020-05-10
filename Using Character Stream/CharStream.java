import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CharStream {
    public static void main(String[] args) throws IOException {
        FileInputStream inputFile = null;
        FileOutputStream outputFile = null;

        try{
            inputFile = new FileInputStream("inputFile.txt");
            outputFile = new FileOutputStream("outputFile.txt");

            /*Reading the input file and writing the contents into the output
            file character by character*/

            int temp;

            while((temp = inputFile.read()) != -1){
                outputFile.write((char)temp);
            }
        }
        finally{
            if(inputFile != null) inputFile.close();
            if(outputFile != null) outputFile.close();
        }
    }
}