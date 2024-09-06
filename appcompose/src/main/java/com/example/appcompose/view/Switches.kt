package com.example.appcompose.view

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
    val isEgoChecked by viewModel.isEgoChecked.collectAsState()
    val isGivingChecked by viewModel.isGivingChecked.collectAsState()
    val isHappinessChecked by viewModel.isHappinessChecked.collectAsState()
    val isKindnessChecked by viewModel.isKindnessChecked.collectAsState()
    val isOptimismChecked by viewModel.isOptimismChecked.collectAsState()
    val isRespectChecked by viewModel.isRespectChecked.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SwitchWithLabel(label = "Ego", isChecked = isEgoChecked, onCheckedChange = viewModel::onEgoCheckedChanged)
        SwitchWithLabel(label = "Giving", isChecked = isGivingChecked, onCheckedChange = viewModel::onGivingCheckedChanged)
        SwitchWithLabel(label = "Happiness", isChecked = isHappinessChecked, onCheckedChange = viewModel::onHappinessCheckedChanged)
        SwitchWithLabel(label = "Kindness", isChecked = isKindnessChecked, onCheckedChange = viewModel::onKindnessCheckedChanged)
        SwitchWithLabel(label = "Optimism", isChecked = isOptimismChecked, onCheckedChange = viewModel::onOptimismCheckedChanged)
        SwitchWithLabel(label = "Respect", isChecked = isRespectChecked, onCheckedChange = viewModel::onRespectCheckedChanged)
    }
}

@Composable
fun SwitchWithLabel(label: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.padding(vertical = 8.dp),
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
