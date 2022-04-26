import com.opencsv.CSVWriter;

public class LampControl {
    public LampControl(int channel, Cloud c){
        this.channel = channel;
        this.cloud = c;

    }

    public void pressPower(){
        cloud.changeLampPowerState(channel);
    }
    public int getChannel(){
        return channel;
    }
    public void rUP(){
        cloud.changeRed(channel, "UP");
    }
    public void rDOWN(){
        cloud.changeRed(channel, "DOWN");
    }
    public void gUP(){
        cloud.changeGreen(channel, "UP");
    }
    public void gDOWN(){
        cloud.changeGreen(channel, "DOWN");
    }
    public void bUP(){
        cloud.changeBlue(channel, "UP");
    }
    public void bDOWN() {
        cloud.changeBlue(channel, "DOWN");
    }



    private int channel;
    private Cloud cloud;
}
