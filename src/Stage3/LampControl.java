import com.opencsv.CSVWriter;

public class LampControl {
    public LampControl(int channel, Cloud c){
        this.channel = channel;
        this.cloud = c;

    }

    public void pressPower(CSVWriter out, int time){
        cloud.changeLampPowerState(channel, out, time);
    }
    public int getChannel(){
        return channel;
    }
    public void rUP(CSVWriter out, int time){
        cloud.changeRed(channel, "UP", out, time);
    }
    public void rDOWN(CSVWriter out, int time){
        cloud.changeRed(channel, "DOWN", out, time);
    }
    public void gUP(CSVWriter out, int time){
        cloud.changeGreen(channel, "UP", out, time);
    }
    public void gDOWN(CSVWriter out, int time){
        cloud.changeGreen(channel, "DOWN", out, time);
    }
    public void bUP(CSVWriter out, int time){
        cloud.changeBlue(channel, "UP", out, time);
    }
    public void bDOWN(CSVWriter out, int time) {
        cloud.changeBlue(channel, "DOWN", out, time);
    }



    private int channel;
    private Cloud cloud;
}
