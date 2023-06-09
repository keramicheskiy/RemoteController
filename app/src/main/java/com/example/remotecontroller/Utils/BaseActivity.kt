package com.example.openmouse.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.remotecontroller.R
import com.google.android.material.snackbar.Snackbar

class BaseActivity : AppCompatActivity() {
    fun showErrorSnackBar(message: String?, errorMessage: Boolean) {
        val snackBar = Snackbar.make(
            findViewById(com.google.android.material.R.id.content),//kvjhkjfh
            message!!,
            Snackbar.LENGTH_LONG
        )
        val snackBarView = snackBar.view
        if (errorMessage) {
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(this, R.color.colorSnackBarError)
            )
        } else {
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(this, R.color.mygreen)
            )
        }
        snackBar.show()
    }
}