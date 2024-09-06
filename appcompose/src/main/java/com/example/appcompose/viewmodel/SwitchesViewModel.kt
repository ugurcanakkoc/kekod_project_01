package com.example.appcompose.viewmodel

import MenuItemRepository
import androidx.lifecycle.ViewModel
import com.example.appcompose.model.MenuItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SwitchViewModel(private val menuItemRepository: MenuItemRepository) : ViewModel() {


    private val _switchStates = MutableStateFlow(
        mapOf(
            MenuItem.Ego to true,
            MenuItem.Giving to false,
            MenuItem.Happiness to false,
            MenuItem.Kindness to false,
            MenuItem.Optimism to false,
            MenuItem.Respect to false
        )
    )
    val switchStates: StateFlow<Map<MenuItem, Boolean>> = _switchStates

    // TODO: isEgoChecked buglı çalışıyor. Ego kapalı iken switch açınca ilk seferde tekrar kendisini true yapıyor.
    private val isEgoChecked: Boolean get() = _switchStates.value[MenuItem.Ego]!!


    fun onSwitchCheckedChanged(menuItem: MenuItem, isChecked: Boolean) {

        if (menuItem == MenuItem.Ego) {
            if (isChecked) {
                closeAllSwitches()
                updateSwitchState(menuItem, true)
            } else {
                updateSwitchState(menuItem, false)
            }
        } else if (!isEgoChecked) {

            updateSwitchState(menuItem, isChecked)
            if (menuItem.label != MenuItem.Switch.label && menuItem.label != MenuItem.Ego.label) {
                if (isChecked) {

                    if (!menuItemRepository.addMenuItem(menuItem))
                        updateSwitchState(menuItem, false)
                } else {
                    menuItemRepository.removeMenuItem(menuItem)
                }
            }
            return
        } else {
            updateSwitchState(menuItem, false)
        }


    }

    private fun updateSwitchState(menuItem: MenuItem, isChecked: Boolean) {
        val updatedStates = _switchStates.value.toMutableMap()
        updatedStates[menuItem] = isChecked
        _switchStates.value = updatedStates
    }

    private fun closeAllSwitches() {
        val updatedStates = _switchStates.value.toMutableMap()
        updatedStates.forEach { (menuItem, _) ->
            if (menuItem != MenuItem.Ego)
                updatedStates[menuItem] = false
                menuItemRepository.removeMenuItem(menuItem)
        }
        _switchStates.value = updatedStates

    }
}



