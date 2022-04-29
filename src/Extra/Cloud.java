import com.opencsv.CSVWriter;

import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<DomoticDevice>();
        lightSensors = new ArrayList<LightSensor>();
        rollerShades = new ArrayList<DomoticDevice>();
    }
    public void addLamp(Lamp l){
        l.setDomoticDevice(lamps.size(), l.getChannel());
        lamps.add(l);
    }
    public void addLightSensor(LightSensor s){
        lightSensors.add(s);
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
        for (LightSensor sensor: lightSensors){
            if (sensor.getChannel() == channel){
                if (sensor.checkLights(lamps)){
                    closeShade(channel);
                }
                break;
            }
        }
    }
    public void changeRed(int channel, String change){
        for (DomoticDevice dd: lamps){
            Lamp l =(Lamp)dd;
            if (l.getChannel() == channel){
                if (change.equals("UP")) {
                    l.rUP();
                    for (LightSensor sensor: lightSensors){
                        if (sensor.getChannel() == channel){
                            if (sensor.checkLights(lamps)){
                                closeShade(channel);
                            }
                            break;
                        }
                    }
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
                    for (LightSensor sensor: lightSensors){
                        if (sensor.getChannel() == channel){
                            if (sensor.checkLights(lamps)){
                                closeShade(channel);
                            }
                            break;
                        }
                    }
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
                    for (LightSensor sensor: lightSensors){
                        if (sensor.getChannel() == channel){
                            if (sensor.checkLights(lamps)){
                                closeShade(channel);
                            }
                            break;
                        }
                    }
                }else if (change.equals("DOWN")){
                    l.bDOWN();
                }
            }
        }
    }



    //Funciones de cortina

    public void closeShade(int channel){
        for(DomoticDevice  dd: rollerShades){
            RollerShade rs =(RollerShade)dd;
            if (rs.getChannel() == channel) {
                rs.close();
            }
        }
    }

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
            state = state + rs.toStr()+ "\t";
        }
        for (DomoticDevice  dd: lamps){
            Lamp l =(Lamp)dd;
            //state = state + rs.getMotorState() +"\t";
            state = state + l.toStr()+ "\t";
        }
        return state;
    }
    private ArrayList<DomoticDevice> lamps;
    private ArrayList<LightSensor> lightSensors;
    private ArrayList<DomoticDevice> rollerShades;
}
