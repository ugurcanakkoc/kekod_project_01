package com.example.appcompose.model


import com.example.appcompose.R

sealed class MenuItem(
    val route: String,
    val itemIcon: Int,
    val label: String,
) {
    data object Switch : MenuItem("switchList", R.drawable.ic_switches, "Switch")
    data object Giving : MenuItem("givingScreen", R.drawable.ic_giving, "Giving")
    data object Happiness : MenuItem("happinessScreen", R.drawable.ic_happiness, "Happiness")
    data object Respect : MenuItem("respectsScreen", R.drawable.ic_respect, "Respects")
    data object Kindness : MenuItem("kindnessScreen", R.drawable.ic_kindness, "Kindness")
    data object Optimism : MenuItem("optimismScreen", R.drawable.ic_optimism, "Optimism")
    data object Ego : MenuItem("egoScreen", R.drawable.ic_launcher_foreground, "Ego")
}
