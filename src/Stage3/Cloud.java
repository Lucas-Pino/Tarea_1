import java.util.ArrayList;

public class Cloud {
    public Cloud() {
        lamps = new ArrayList<DomoticDevice>();
        rollerShades = new ArrayList<DomoticDevice>();
    }
    public void addLamp(Lamp l){
        lamps.add(l);
    }
    public void addRollerShade(RollerShade rs){
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
    public void changeLampPowerState(int channel){
        // ???
    }
    public void startShadeUp(int channel){
        for(DomoticDevice  dd: rollerShades){
            RollerShade rs =(RollerShade)dd;
            rs.startUp();
        }
    }
    public void startShadeDown(int channel){
        for(DomoticDevice  dd: rollerShades){
            RollerShade rs =(RollerShade)dd;
            rs.startDown();
        }
    }
    public void stopShade(int channel){
        for(DomoticDevice  dd: rollerShades){
            RollerShade rs =(RollerShade)dd;
            rs.stop();
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
        return state;
    }
    private ArrayList<DomoticDevice> lamps;
    private ArrayList<DomoticDevice> rollerShades;
}
