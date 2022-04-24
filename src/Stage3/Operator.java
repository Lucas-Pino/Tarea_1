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
        String[] header= {cloud.getHeaders()};
        out.writeNext(header);
        while(in.hasNext()){
            int time=in.nextInt();
            String str=in.next();
            if (!str.equals("L")) {
                //out.println("Unexpected device:" + str);
                System.exit(-1);
            }
            int channel=in.nextInt();
            String command = in.next();
            if (command.equals("P")){
                lampControl.pressPower(out, time);
            }else{
                String command2 = in.next();
                command = command+command2;

                switch (command){
                    case "RU":{
                        lampControl.rUP(out, time);
                        break;
                    }
                    case "RD":{
                        lampControl.rDOWN(out, time);
                        break;
                    }
                    case "GU":{
                        lampControl.gUP(out, time);
                        break;
                    }
                    case "GD":{
                        lampControl.gDOWN(out, time);
                        break;
                    }
                    case "BU":{
                        lampControl.bUP(out, time);
                        break;
                    }
                    case "BD":{
                        lampControl.bDOWN(out, time);
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
    private LampControl lampControl;
    private Cloud cloud;
}
