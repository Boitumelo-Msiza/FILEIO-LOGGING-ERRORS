
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Visitor {

    private static final Logger logger = LogManager.getLogger(Visitor.class.getName());

    public boolean Save(String name, int age, String assistant, String comment){



            LocalTime time = LocalTime.now();
            LocalDate date = LocalDate.now();
        try {


            File file = new File(name.replace(" ","_").toLowerCase()+".text");
            if(file.createNewFile()) {
                logger.debug("file is created");
            }else{
                logger.debug("File already exists");
            }
               FileWriter  writer = new FileWriter(file);
                writer.write("Name of Visitor: " + name + "\nAge: " + age + "\nAssistant: " + assistant
                        + "\nComment: " + comment + "\nDate: " + date + "\nTime: " + time);
                writer.close();

            logger.debug("File successfully created");
            System.out.println();
        }catch (IOException e){
            logger.error("An error has occurred.");
        }
        return true;
    }

        public void Load(String name){

        try{
            File obj = new File(name.replace(" ","_").toLowerCase()+".text");
            Scanner myReader = new Scanner(obj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }catch (FileNotFoundException e){
            System.out.println("An error has occurred");
            e.getStackTrace();
        }
    }

    public static void main(String []args){
         String Full_Name;
         int Age;
         String Assistant;
         String Comment;
        Scanner scan = new Scanner(System.in);

      Visitor obj = new Visitor();

        System.out.println("Welcome to Umuzi");

        System.out.println("Please enter your full names: ");
       Full_Name= scan.nextLine();

        System.out.println("Please enter your age: ");
        Age = scan.nextInt();

        System.out.println("Please enter assistant name: ");
        
        Assistant = scan.next();

        System.out.println("Please enter comment: ");
        Comment = scan.next();



        obj.Save(Full_Name,Age,Assistant,Comment);

        System.out.println("Would you like to view a file? ");
        String file = scan.next();

        if(file.equalsIgnoreCase("no")) {
            System.exit(0);
        }
        else {
            System.out.println("Enter name of the file");
            String FileName = scan.next();
//            System.out.print("Visitor File reads as follows :");
            obj.Load(FileName);
        }
    }


}
