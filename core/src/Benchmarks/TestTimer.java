//serves as the prototype timer
//created by Rithesh Rajasekar
package Benchmarks;


public class TestTimer {


    private int worldTimer;
    private  String worldTimerString;
    private float timeCount;

    public TestTimer(int time){
        worldTimer = time;
        worldTimerString = "" + worldTimer;
        timeCount = 0;
    }
    //updates countdown on timer
    public void update(float dt){
        timeCount+= dt;
        if(timeCount>=1){
            worldTimer--;
            worldTimerString = " " + worldTimer;
            timeCount = 0;
        }
    }
    public String getWorldTimerString(){
        return worldTimerString;
    }
    public int getWorldTimer(){
        return worldTimer;
    }



}

