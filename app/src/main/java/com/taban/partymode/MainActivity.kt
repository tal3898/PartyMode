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

    val COLOR_INTERVAL = 150L
    val colorsList = Arrays.asList(
        Color.RED,
        Color.BLUE,
        Color.GREEN,
        Color.YELLOW,
        Color.MAGENTA
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        hideAllScreenBars()
        setContentView(R.layout.activity_main)
        changeScreenColorRandomly()
    }

    fun changeScreenColorRandomly() {
        val currentLayout = findViewById(R.id.main_layout) as ConstraintLayout

        var changeColorThread = Thread(Runnable {
            while(true) {
                var randomColorIndex = Random().nextInt(colorsList.size)
                currentLayout.setBackgroundColor(colorsList[randomColorIndex])
                Thread.sleep(COLOR_INTERVAL)
            }
        })
        changeColorThread.start()
    }

    fun hideAllScreenBars() {
        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        //hide the title bar
        getSupportActionBar()?.hide();

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }
}
