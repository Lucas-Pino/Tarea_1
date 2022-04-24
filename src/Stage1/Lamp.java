public class Lamp {
    private int channel;
    private short r,g,b;
    private LampState state;
    private final int id;  // to conform lamp's header
    private static int nextId=0;

    public Lamp (int channel){      //constructor
        this.channel = channel;
        this.r = 255;
        this.g = 255;
        this.b = 255;
        this.state = LampState.OFF;

    }
    {
        id=nextId++;
    }
    public int getChannel(){
        return channel;
    }
    public void changePowerState(){
        if(state == LampState.ON){
            state = LampState.OFF;
        }else{
            state = LampState.ON;
        }
    }
    public void rUP(){
        if(r+10 > 255){
            r = 255;
        }
        else {
            r = (short) (r + 10);
        }
    }
    public void rDOWN(){
        if(r-10 < 0){
            r = 0;
        }
        else {
            r = (short) (r - 10);
        }
    }
    public void gUP(){
        if(g+10 > 255){
            g = 255;
        }
        else {
            g = (short) (g + 10);
        }
    }
    public void gDOWN(){
        if(g-10 < 0){
            g = 0;
        }
        else {
            g = (short) (g - 10);
        }
    }
    public void bUP(){
        if(b+10 > 255){
            b = 255;
        }
        else {
            b = (short) (b + 10);
        }
    }
    public void bDOWN(){
        if(b-10 < 0){
            b = 0;
        }
        else {
            b = (short) (b - 10);
        }
    }

    public String getHeader(){
        return "Hola";
    }

    public String toString(){
        if (state==LampState.ON)
            return ""+r+"\t"+g+"\t"+b;
        else
            return "0\t0\t0";
    }

}
