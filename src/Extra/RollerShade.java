public class RollerShade extends DomoticDevice {
    public RollerShade (int channel, double alpha, double length) {
        this.motor = motor;
        this.channel = channel;
        this.MaxShadeLength = length;
        this.length = 0;
        motor = new Motor(alpha, channel);
    }
    public Motor.MotorState getMotorState(){
        return motor.state;
    }
    public int getChannel(){
        return channel;
    }
    public void startUp(){
        motor.turnUp();
    }
    public void startDown(){
        motor.turnDown();
    }
    public void stop(){
        motor.stop();
    }
    public void close(){
        motor.close();
    }
    public void advanceTime(double delta){
        motor.advanceTime(delta);
    }
    public String getHeader(){
        String s = "RS" + getId();
        return s;
    }
    public String toStr(){
        String s = String.valueOf(Math.round((length/MaxShadeLength)*100)) + "%";
        return s;
    }
    private class Motor {  //nested class, Motor is only used within RollerShade.        //cambie a static
        public Motor (double a, int ch){        //constructor
            channel = ch;
            alpha = a;
            state = MotorState.STOPPED;
        }
        public MotorState getMotorState(){
            return state;
        }       //metodo
        public enum MotorState {      // ale: dejé el state fuera
            UPWARD,
            STOPPED,
            DOWNWARD
        }
        public void turnUp(){
            state = MotorState.UPWARD;
        }
        public void turnDown(){
            state = MotorState.DOWNWARD;
        }
        public void stop(){
            state = MotorState.STOPPED;
        }
        public void close(){
            length = MaxShadeLength;
        }
        public void advanceTime(double delta){

            double increment = alpha*delta*RADIUS;
            switch (state) {
                case STOPPED: break;
                case DOWNWARD:
                    if (length + increment > MaxShadeLength){
                        length = MaxShadeLength;
                        state = MotorState.STOPPED;
                    }else{
                        length = length + increment;
                    }
                    break;
                case UPWARD:
                    if (length - increment < 0){
                        length = 0;
                        state = MotorState.STOPPED;
                    }else{
                        length = length - increment;
                    }

                    break;
            }
        }
        private double alpha;
        private int channel;
        private MotorState state;
        private static double RADIUS=0.04;
    }

    private Motor motor;
    private double length;
    private double MaxShadeLength;
    private static int nextId;
    private int channel;


}
