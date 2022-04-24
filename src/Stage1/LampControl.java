import com.opencsv.CSVWriter;

public class LampControl {
    public LampControl(int channel, Cloud c){
        this.channel = channel;
        this.cloud = c;

    }
    public void pressPower(CSVWriter out){
        cloud.changeLampPowerState(channel, out);
    }
    public int getChannel(){
        return channel;
    }
    public void rUP(CSVWriter out){
        cloud.changeRed(channel, "UP", out);
    }
    public void rDOWN(CSVWriter out){
        cloud.changeRed(channel, "DOWN", out);
    }
    public void gUP(CSVWriter out){
        cloud.changeGreen(channel, "UP", out);
    }
    public void gDOWN(CSVWriter out){
        cloud.changeGreen(channel, "DOWN", out);
    }
    public void bUP(CSVWriter out){
        cloud.changeBlue(channel, "UP", out);
    }
    public void bDOWN(CSVWriter out) {
        cloud.changeBlue(channel, "DOWN", out);
    }



    private int channel;
    private Cloud cloud;
}
