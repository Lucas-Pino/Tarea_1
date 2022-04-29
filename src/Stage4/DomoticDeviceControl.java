public class DomoticDeviceControl {

    public void DomoticDeviceControl(int ch, Cloud c){
        channel = ch;
        cloud = c;
    }
    public int getChannel() {
        return channel;
    }
    protected Cloud cloud;
    protected int channel;
}
