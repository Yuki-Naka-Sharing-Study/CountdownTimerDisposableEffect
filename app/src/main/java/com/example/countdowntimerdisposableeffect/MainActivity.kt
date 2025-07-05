package com.example.countdowntimerdisposableeffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.countdowntimerdisposableeffect.ui.theme.CountdownTimerDisposableEffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CountdownTimerDisposableEffectTheme {
                CountdownTimerScreen()
            }
        }
    }
}