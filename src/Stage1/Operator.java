import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.Scanner;

public class Operator {
    public Operator(LampControl lc, Cloud c){
        this.lampControl = lc;
        this.cloud = c;
    }
    public void executeCommands(Scanner in, CSVWriter out){
//        out.println("Time\t" + cloud.getHeaders());
//        out.println(time+"\t"+cloud.getState());
        while(in.hasNextInt()){

            time=in.nextInt();
            String string=in.next();
            if (!string.equals("L")) {
                //out.println("Unexpected device:" + string);
                System.exit(-1);
            }
            int channel=in.nextInt();
            String command = in.next();
            if (command.equals("P")){
                lampControl.pressPower(out);
            }else{
                String command2 = in.next();
                command = command+command2;

                switch (command){
                    case "RU":{
                        lampControl.rUP(out);
                        break;
                    }
                    case "RD":{
                        lampControl.rDOWN(out);
                        break;
                    }
                    case "GU":{
                        lampControl.gUP(out);
                        break;
                    }
                    case "GD":{
                        lampControl.gDOWN(out);
                        break;
                    }
                    case "BU":{
                        lampControl.bUP(out);
                        break;
                    }
                    case "BD":{
                        lampControl.bDOWN(out);
                        break;
                    }
                    default: {
                        System.out.println("Opcion incorrecta");
                    }
                }
            }

            //????
        }
    }
    private double time=0;
    private LampControl lampControl;
    private Cloud cloud;
}
