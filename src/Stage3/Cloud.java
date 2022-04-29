import com.opencsv.CSVWriter;

import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<DomoticDevice>();
        rollerShades = new ArrayList<DomoticDevice>();
    }
    public void addLamp(Lamp l){
        l.setDomoticDevice(lamps.size(), l.getChannel());
        lamps.add(l);
    }
    public void addRollerShade(RollerShade rs){
        rs.setDomoticDevice(rollerShades.size(), rs.getChannel());
        rollerShades.add(rs);
    }
    public void advanceTime(double delta){
        for (DomoticDevice dd: rollerShades) {
            RollerShade rs =(RollerShade)dd;
            rs.advanceTime(delta);

        }
    }
//    private DomoticDevice getDomoticDeviceAtChannel( ArrayList<DomoticDevice> devices, int channel){
//        // ???
//        DomoticDevice test = new DomoticDevice();
//        return test;
//    }

    //Funciones de lampara

    public void changeLampPowerState(int channel){
        for (DomoticDevice dd: lamps){
            Lamp l =(Lamp)dd;
            if (l.getChannel() == channel){
                l.changePowerState();
            }

        }
    }
    public void changeRed(int channel, String change){
        for (DomoticDevice dd: lamps){
            Lamp l =(Lamp)dd;
            if (l.getChannel() == channel){
                if (change.equals("UP")) {
                    l.rUP();
                }else if (change.equals("DOWN")){
                    l.rDOWN();
                }
            }
        }
    }
    public void changeGreen(int channel, String change){
        for (DomoticDevice dd: lamps){
            Lamp l =(Lamp)dd;
            if (l.getChannel() == channel){
                if (change.equals("UP")) {
                    l.gUP();
                }else if (change.equals("DOWN")){
                    l.gDOWN();
                }
            }
        }
    }
    public void changeBlue(int channel, String change){
        for (DomoticDevice dd: lamps){
            Lamp l =(Lamp)dd;
            if (l.getChannel() == channel){
                if (change.equals("UP")) {
                    l.bUP();
                }else if (change.equals("DOWN")){
                    l.bDOWN();
                }
            }
        }
    }



    //Funciones de cortina

    public void startShadeUp(int channel){
        for(DomoticDevice  dd: rollerShades){
            RollerShade rs =(RollerShade)dd;
            if (rs.getChannel() == channel) {
                rs.startUp();
            }
        }
    }
    public void startShadeDown(int channel){
        for(DomoticDevice  dd: rollerShades){
            RollerShade rs =(RollerShade)dd;
            if (rs.getChannel() == channel) {
                rs.startDown();
            }
        }
    }
    public void stopShade(int channel){
        for(DomoticDevice  dd: rollerShades){
            RollerShade rs =(RollerShade)dd;
            if (rs.getChannel() == channel) {
                rs.stop();
            }
        }
    }
    public String getHeaders(){
        String header = "";
        for (DomoticDevice  rs: rollerShades){
            header += rs.getHeader()+"\t";
        }
        for (DomoticDevice l: lamps){
            header += l.getHeader()+"\t";
        }
        return header;
    }
    public String getState(){
        String state = "";
        for (DomoticDevice  dd: rollerShades){
            RollerShade rs =(RollerShade)dd;
            //state = state + rs.getMotorState() +"\t";
            String st = rs.getMotorState().toString();
            if (st.equals("UPWARD")){
                state = state + 100 +"\t";
            } else if (st.equals("STOPPED")){
                state = state + 0 +"\t";
            } else if (st.equals("DOWNWARD")){
                state = state + -100 +"\t";
            }
        }
        for (DomoticDevice  dd: lamps){
            Lamp l =(Lamp)dd;
            //state = state + rs.getMotorState() +"\t";
            state = state + l.toStr()+ "\t";
        }
        return state;
    }
    private ArrayList<DomoticDevice> lamps;
    private ArrayList<DomoticDevice> rollerShades;
}
