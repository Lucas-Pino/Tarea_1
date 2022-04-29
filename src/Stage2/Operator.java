import com.opencsv.CSVWriter;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Operator {
    public Operator(ArrayList shadesControlers, ArrayList lampsControlers, Cloud c){
        this.cloud = c;
        this.rsControlers = shadesControlers;       // Array listcontroles cortinas
        this.lmpsControlers =  lampsControlers;     // Arraylist controles lamparas
    }

//    public void addShadeControl(ShadeControl sc){
//        // ???
//    }

    public void executeCommands(Scanner in, CSVWriter out){
        //out.println("Time\t" + cloud.getHeaders());
        String[] header = {"Time\t" + cloud.getHeaders()};
        out.writeNext(header);
        while(in.hasNextInt()){
            int commandTime=in.nextInt();

            while (time < commandTime) {
                //System.out.println(time+"\t"+cloud.getState());
                cloud.advanceTime(delta);
                time+=delta;
            }
            String device=in.next();

            if (!device.equals("C")) {
                System.out.println("Unexpected device:" + device);
                System.exit(-1);
            }

            int channel = in.nextInt();
            String command=in.next();


            for (int i = 0; i<rsControlers.size(); i++){
                if (rsControlers.get(i).getChannel() == channel){
                    if (command.equals("U")){
                        rsControlers.get(i).startUp();
                    }else if(command.equals("S")){
                        rsControlers.get(i).stop();
                    }else if(command.equals("D")){
                        rsControlers.get(i).startDown();
                    }else{
                        System.out.println("Unexpected command:" + command);
                        System.exit(-1);
                    }
                    break;
                }
            }

            String[] state = {commandTime+"\t"+cloud.getState()};
            out.writeNext(state);
        }
    }
    private double time=0;
    private Cloud cloud;
    private final double delta=0.1;
    private ArrayList<LampControl> lmpsControlers;
    private ArrayList<ShadeControl> rsControlers;
}
