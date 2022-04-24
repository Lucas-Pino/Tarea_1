public class ShadeControl extends DomoticDeviceControl{
    public ShadeControl(int ch, Cloud c){
        this.channel = ch;
        this.cloud = c;
    }
    public void startUp(){
        System.out.println("UP");
        cloud.startShadeUp(channel);
    }
    public void startDown(){
        System.out.println("DOWN");
        cloud.startShadeDown(channel);
    }
    public void stop(){
        System.out.println("STOP");
        cloud.stopShade(channel);
    }
}
