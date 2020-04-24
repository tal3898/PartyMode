package com.taban.partymode

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.RelativeLayout
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)

        //hide the title bar
        getSupportActionBar()?.hide();

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_main)

        var colorsList = Arrays.asList(
            Color.RED,
            Color.BLUE,
            Color.GREEN,
            Color.YELLOW,
            Color.MAGENTA
        )

        val currentLayout = findViewById(R.id.main_layout) as ConstraintLayout


        var changeColorThread = Thread(Runnable {
            while(true) {
                var randomColorIndex = Random().nextInt(colorsList.size)
                currentLayout.setBackgroundColor(colorsList[randomColorIndex])
                Thread.sleep(3000)
            }
        })
        changeColorThread.start()


    }
}
