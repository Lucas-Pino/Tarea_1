public abstract class DomoticDevice {
    public DomoticDevice(){
        this.channel = 0;
        this.id = 0;
    }
    public void setDomoticDevice(int idNew, int ch){
       id = idNew;
       channel = ch;
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
