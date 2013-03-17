package com.viojon.brushwhatever;

import com.viojon.brushwhatever.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class Main extends Activity {
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        View contentView = findViewById(R.id.fullscreen_content);
        
        Bitmap b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Canvas board = new Canvas(b);
        contentView.draw(board);
        contentView.setOnTouchListener(new MyOnTouch());
        
        

        // Set up an instance of SystemUiHider to control the system UI for
        // this activity.

        // Upon interacting with UI controls, delay any scheduled hide()
        // operations to prevent the jarring behavior of controls going away
        // while interacting with the UI.
    }

    private class MyOnTouch implements OnTouchListener{

        @Override
        public boolean onTouch(View arg0, MotionEvent arg1) {
            Canvas board = new Canvas(arg0.getDrawingCache());
            board.drawText("hello", arg1.getX(), arg1.getX(),new Paint());
            arg0.draw(board);
            return false;
        }
    }

}
