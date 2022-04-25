import com.opencsv.CSVWriter;

import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Operator {
    public Operator(ShadeControl sc, Cloud c){
        this.rsControl = sc;
        this.cloud = c;
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
            if (channel == rsControl.getChannel()) {
                if (command.equals("U")){
                    rsControl.startUp();
                }else if(command.equals("S")){
                    rsControl.stop();
                }else if(command.equals("D")){
                    rsControl.startDown();
                }else{
                    System.out.println("Unexpected command:" + command);
                    System.exit(-1);
                }
            }
            String[] state = {commandTime+"\t"+cloud.getState()};
            out.writeNext(state);
        }
    }
    private double time=0;
    private ShadeControl rsControl;
    private Cloud cloud;
    private final double delta=0.1;
}
