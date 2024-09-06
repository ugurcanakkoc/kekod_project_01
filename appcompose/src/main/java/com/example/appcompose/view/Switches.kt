package com.example.appcompose.view

import com.example.appcompose.model.MenuItem
import com.example.appcompose.viewmodel.SwitchViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SwitchList(viewModel: SwitchViewModel) {
    val switchStates by viewModel.switchStates.collectAsState( )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SwitchWithLabel(
            label = "Ego",
            isChecked = switchStates[MenuItem.Ego]!!,
            onCheckedChange = { viewModel.onSwitchCheckedChanged(MenuItem.Ego, it) }
        )
        SwitchWithLabel(
            label = "Giving",
            isChecked = switchStates[MenuItem.Giving]!!,
            onCheckedChange = { viewModel.onSwitchCheckedChanged(MenuItem.Giving, it) }
        )
        SwitchWithLabel(
            label = "Happiness",
            isChecked = switchStates[MenuItem.Happiness]!!,
            onCheckedChange = { viewModel.onSwitchCheckedChanged(MenuItem.Happiness, it) }
        )
        SwitchWithLabel(
            label = "Kindness",
            isChecked = switchStates[MenuItem.Kindness]!!,
            onCheckedChange = { viewModel.onSwitchCheckedChanged(MenuItem.Kindness, it) }
        )
        SwitchWithLabel(
            label = "Optimism",
            isChecked = switchStates[MenuItem.Optimism]!!,
            onCheckedChange = { viewModel.onSwitchCheckedChanged(MenuItem.Optimism, it) }
        )
        SwitchWithLabel(
            label = "Respect",
            isChecked = switchStates[MenuItem.Respect]!!,
            onCheckedChange = { viewModel.onSwitchCheckedChanged(MenuItem.Respect, it) }
        )
    }
}


@Composable
fun SwitchWithLabel(label: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            modifier = Modifier.weight(1f)
        )
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color(0xFF8E44AD),
                uncheckedThumbColor = Color.Black,
                uncheckedTrackColor = Color.Gray
            )
        )
    }
}
