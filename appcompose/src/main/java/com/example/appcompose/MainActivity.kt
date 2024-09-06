package com.example.appcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.appcompose.view.ui.theme.KeKodProject1Theme
import com.example.appcompose.view.SwitchList
import com.example.appcompose.viewmodel.SwitchViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KeKodProject1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF8ED1FC)
                ) {

                    val switchViewModel: SwitchViewModel by viewModels()
                    SwitchList(viewModel = switchViewModel)
                }
            }
        }
    }
}
