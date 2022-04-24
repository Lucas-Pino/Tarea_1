import java.io.PrintStream;
import java.util.Scanner;

public class Operator {
    public Operator(ShadeControl sc, Cloud c){
        this.rsControl = sc;
        this.cloud = c;
    }
//    public void addShadeControl(ShadeControl sc){
//        // ???
//    }
    public void executeCommands(Scanner in, PrintStream out){
        //out.println("Time\t" + cloud.getHeaders());
        while(in.hasNextInt()){
            int commandTime=in.nextInt();
            while (time < commandTime) {
                //out.println(time+"\t"+cloud.getState());
                cloud.advanceTime(delta);
                time+=delta;
            }
            String device=in.next();

            if (!device.equals("C")) {
                out.println("Unexpected device:" + device);
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
                    out.println("Unexpected command:" + command);
                    System.exit(-1);
                }
            }
        }
    }
    private double time=0;
    private ShadeControl rsControl;
    private Cloud cloud;
    private final double delta=0.1;
}
