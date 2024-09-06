package com.example.appcompose

import MenuItemRepository
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appcompose.model.MenuItem
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
            val navController = rememberNavController()
            val menuItemRepository = MenuItemRepository()
            val menuItems = menuItemRepository.menuItems
            var selectedItem by remember { mutableStateOf(menuItems[0].route) }

            KeKodProject1Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            menuItems.forEach { menuItem ->
                                NavigationBarItem(
                                    label = { Text(menuItem.label) },
                                    selected = menuItem.route == selectedItem,
                                    onClick = {
                                        selectedItem = menuItem.route
                                        navController.navigate(menuItem.route) {
                                            restoreState = true
                                            popUpTo = navController.graph.findStartDestination().id
                                            launchSingleTop = true
                                        }
                                    },
                                    icon = {
                                        Icon(
                                            painter = painterResource(menuItem.itemIcon),
                                            contentDescription = null
                                        )
                                    }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        val switchViewModel = SwitchViewModel(menuItemRepository)
                        NavigationGraph(navController, switchViewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController,switchViewModel: SwitchViewModel) {
    NavHost(navController = navController, startDestination = MenuItem.Switch.route) {
        composable(MenuItem.Switch.route) {

            SwitchList(switchViewModel)
        }
        composable(MenuItem.Giving.route) {
            val viewModel: GivingViewModel = viewModel()
            Giving(viewModel)
        }
        composable(MenuItem.Happiness.route) {
            val viewModel: HappinessViewModel = viewModel()
            Happiness(viewModel)
        }
        composable(MenuItem.Respect.route) {
            val viewModel: RespectViewModel = viewModel()
            Respect(viewModel)
        }
        composable(MenuItem.Kindness.route) {
            val viewModel: KindnessViewModel = viewModel()
            Kindness(viewModel)
        }
        composable(MenuItem.Optimism.route) {
            val viewModel: OptimismViewModel = viewModel()
            Optimism(viewModel)
        }
    }
}
