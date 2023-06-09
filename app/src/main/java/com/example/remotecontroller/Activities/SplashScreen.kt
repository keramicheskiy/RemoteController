package com.example.remotecontroller.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import com.example.remotecontroller.Activities.MainActivity
import com.example.remotecontroller.Activities.NoAccessActivity
import com.example.remotecontroller.R
import com.example.remotecontroller.Utils.Constants
import com.example.remotecontroller.Utils.FirebaseClass
//import kotlinx.serialization.json.Json
//import kotlinx.serialization.decodeFromString

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.splash_screen)


        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()


        Handler(Looper.getMainLooper()).postDelayed({
//            if (FirebaseClass().getUserID().isNotEmpty()) {
//                val intent = Intent(this@SplashScreen, MainActivity::class.java)
//                intent.putExtra(Constants.USERS, FirebaseClass().getUserEmail())
//                intent.putExtra(Constants.IS_LOGGED_IN, true)
//                startActivity(intent)
//            } else {
//                val intent = Intent(this@SplashScreen, NoAccessActivity::class.java)
//                intent.putExtra(Constants.IS_LOGGED_IN, false)
//                startActivity(intent)
//            }

            finish()
        }, 2000)

    }




}