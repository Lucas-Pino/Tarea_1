import java.util.ArrayList;

public class LightSensor {
    public LightSensor(int channel){
        this.channel = channel;
    }
    public boolean checkLights(ArrayList<DomoticDevice> lamps){ //Devuelve 1 si tiene que cerrar las cortinas de esecanal
        int sum = 0;
        for (DomoticDevice dd: lamps){
            Lamp lamp =(Lamp)dd;
            sum = sum + lamp.getColorsSum();
        }
        if (sum > 512){
            return true;
        }else{
            return false;
        }
    }
    public int getChannel() {
        return channel;
    }

    private int channel;
}
