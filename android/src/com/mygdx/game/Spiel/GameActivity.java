package com.mygdx.game.Spiel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import com.mygdx.game.Layouts.GameOverActivity;

import java.util.ArrayList;
import java.util.List;


public class GameActivity extends Activity  {

    //  public boolean dialogActive;
    //public GameView theGameView;
    //public Dialog dialog1;
    private List<Sprite> spriteList = new ArrayList<Sprite>();
    private List<Integer> spriteListNum = new ArrayList<Integer>();
    private ShakeEventListener mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    public GameView theGameView;
    public ShakeEventListener shakeEventListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeEventListener(new ShakeEventListener.OnShakeListener() {
            @Override
            public void onShake() {
                for (int i = spriteList.size() - 1; i >= 0; i--) {
                    Sprite sprite = spriteList.get(i);
                    sprite.setxSpeed((theGameView.getWidth()/10)*1);
                    sprite.setySpeed(theGameView.getHeight()/10);
                }
                // shakeEventListener.onShake=true;
                //theGameView.wuerfel=0;
                //theGameView.wuerfel++;
                //theGameView.onTouchEvent();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }



    public void onGameOver() {
        Intent theNextIntent = new Intent(getApplicationContext(), GameOverActivity.class);
        startActivity(theNextIntent);
        this.finish();
    }
  /*  public void würfeleins(){
        dialog1 = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
        dialog1.setContentView(R.layout.wuerfeleins);
        dialog1.show();
        dialogActive=true;
        dialogState();
    }
    public void dialogState() {
        if (dialogActive){
            dialog1.hide();
            dialogActive=false;
            theGameView.resumeThread();

        }else if (!dialogActive){
            theGameView.pauseThread();
            dialog1.show();
            dialogActive=true;
        }
    }
*/
}