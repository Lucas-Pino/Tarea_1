public abstract class DomoticDevice {
    public DomoticDevice(){
        this.channel = -1;
        this.id = -1;
    }
    public DomoticDevice(int id, int ch){
       // ???
    }
    public int getChannel() {
        return channel;
    }
    public int getId() {
        return id;
    }
    public abstract String getHeader();
    private int id;
    private int channel;
}
