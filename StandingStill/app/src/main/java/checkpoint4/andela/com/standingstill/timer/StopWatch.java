package checkpoint4.andela.com.standingstill.timer;

import android.os.Handler;

public class StopWatch {

    private long hr;
    private long min;
    private long sec;
    private long milliSeconds;
    private Handler handler;
    private long startTime, elapsedTime;


    private int refreshRate = 1000;

    private String seconds, minute, hour;
    private boolean stopped;

    private Runnable runnableTimer = new Runnable() {
        @Override
        public void run() {
            elapsedTime = System.currentTimeMillis() - startTime;
            updateTimer(getElapsedTime());
            handler.postDelayed(this, refreshRate);

        }
    };

    public void start() {
        startTime = System.currentTimeMillis();

        handler.removeCallbacks(runnableTimer);
        handler.postDelayed(runnableTimer, 0);

    }

    public void stop() {
        startTime = System.currentTimeMillis();
        stopped = true;

    }

    public StopWatch() {

        handler = new Handler();
    }

    public void updateTimer(float time) {
        sec = (long) time / 1000;
        min = sec / 60;
        hr = min / 60;

    }

    public String secondsToString() {
        sec = sec % 60;
        seconds=String.valueOf(sec);
        if(sec == 0){
            seconds = "00";
        }
        if(sec <10 && sec > 0){
            seconds = "0"+seconds;
        }
        return seconds;

    }

    public String minuteToString() {
        min = min % 60;
        minute =String.valueOf(min);
        if(min == 0){
            minute = "00";
        }
        if(min <10 && min > 0){
            minute = "0" + minute;
        }

        return minute;
    }

    public String hourToString() {
        hour = String.valueOf(hr);
        if(hr == 0){
            hour = "00";
        }
        if(hr < 10 && hr > 0){
            hour = "0" + hour;
        }

        return hour;
    }
    

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }



    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

}
