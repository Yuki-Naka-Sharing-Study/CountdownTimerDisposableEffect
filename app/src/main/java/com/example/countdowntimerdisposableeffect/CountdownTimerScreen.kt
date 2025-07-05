package com.example.countdowntimerdisposableeffect

import android.os.CountDownTimer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun CountdownTimerScreen(startSeconds: Int = 10) {
    var timeLeft by remember { mutableIntStateOf(startSeconds) }
    var isFinished by remember { mutableStateOf(false) }

    DisposableEffect(Unit) {
        val timer = object : CountDownTimer(startSeconds * 1000L, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft = (millisUntilFinished / 1000).toInt()
            }

            override fun onFinish() {
                isFinished = true
            }
        }

        timer.start()

        onDispose {
            timer.cancel()
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (isFinished) {
            Text("完了！", fontSize = 32.sp)
        } else {
            Text("残り：${timeLeft}秒", fontSize = 32.sp)
        }
    }
}
