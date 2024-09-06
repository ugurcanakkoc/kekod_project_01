package com.example.appcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcompose.view.Giving
import com.example.appcompose.view.Happiness
import com.example.appcompose.view.Kindness
import com.example.appcompose.view.Optimism
import com.example.appcompose.view.Respect
import com.example.appcompose.view.SwitchList
import com.example.appcompose.view.ui.theme.KeKodProject1Theme
import com.example.appcompose.viewmodel.GivingViewModel
import com.example.appcompose.viewmodel.HappinessViewModel
import com.example.appcompose.viewmodel.KindnessViewModel
import com.example.appcompose.viewmodel.OptimismViewModel
import com.example.appcompose.viewmodel.RespectViewModel
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
                    val navController = rememberNavController()
                    NavigationGraph(navController)
                }
            }
        }
    }



}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "switchList") {
        composable("switchList") {
            val viewModel = remember { SwitchViewModel() }
            SwitchList(viewModel)
        }
        composable("givingScreen") {
            val viewModel = remember { GivingViewModel() }
            Giving(viewModel)
        }
        composable("happinessScreen") {
            val viewModel = remember { HappinessViewModel() }
            Happiness(viewModel)
        }
        composable("respectsScreen") {
            val viewModel = remember { RespectViewModel() }
            Respect(viewModel)
        }
        composable("kindnessScreen") {
            val viewModel = remember { KindnessViewModel() }
            Kindness(viewModel)
        }
        composable("optimismScreen") {
            val viewModel = remember { OptimismViewModel() }
            Optimism(viewModel)
        }

    }
}