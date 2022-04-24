public class ShadeControl extends DomoticDeviceControl{
    public ShadeControl(int ch, Cloud c){
        this.channel = ch;
        this.cloud = c;
    }
    public void startUp(){
        cloud.startShadeUp(channel);
    }
    public void startDown(){
        // ??
    }
    public void stop(){
        // ??
    }
}
