import com.opencsv.CSVWriter;

import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<Lamp>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public Lamp getLampAtChannel( int channel){
        //???
        return lamps.get(0);
    }
    public void changeLampPowerState(int channel, CSVWriter out){
        String[] instruction = {""};
        for (Lamp l: lamps){
            if (l.getChannel() == channel){
                l.changePowerState();
                instruction[0] = instruction[0] + l.toStr();
            }

        }
        System.out.println(instruction[0]);
        out.writeNext(instruction);
    }
    public void changeRed(int channel, String change, CSVWriter out){
        for (Lamp l: lamps){
            if (l.getChannel() == channel){
                if (change.equals("UP")) {
                    l.rUP();
                }else if (change.equals("DOWN")){
                    l.rDOWN();
                }
            }
        }
    }
    public void changeGreen(int channel, String change, CSVWriter out){
        for (Lamp l: lamps){
            if (l.getChannel() == channel){
                if (change.equals("UP")) {
                    l.gUP();
                }else if (change.equals("DOWN")){
                    l.gDOWN();
                }
            }
        }
    }
    public void changeBlue(int channel, String change, CSVWriter out){
        for (Lamp l: lamps){
            if (l.getChannel() == channel){
                if (change.equals("UP")) {
                    l.bUP();
                }else if (change.equals("DOWN")){
                    l.bDOWN();
                }
            }
        }
    }
    public String getHeaders(){
        String header = "";
        for (Lamp l: lamps){
            header.append("L").append(counter).append("R\t").append("L").append(counter).append("G\t").append("L").append(counter).append("B\t");
            counter ++;
        }
            
        return header;
    }
    public String getState(){       //que raios
        //??
        return "Hola";

    }
    private ArrayList<Lamp> lamps; // getting ready for next stages
}
