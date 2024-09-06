package com.example.appcompose.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SwitchViewModel : ViewModel() {

    private val _isEgoChecked = MutableStateFlow(false)
    val isEgoChecked: StateFlow<Boolean> = _isEgoChecked

    private val _isGivingChecked = MutableStateFlow(false)
    val isGivingChecked: StateFlow<Boolean> = _isGivingChecked

    private val _isHappinessChecked = MutableStateFlow(false)
    val isHappinessChecked: StateFlow<Boolean> = _isHappinessChecked

    private val _isKindnessChecked = MutableStateFlow(false)
    val isKindnessChecked: StateFlow<Boolean> = _isKindnessChecked

    private val _isOptimismChecked = MutableStateFlow(false)
    val isOptimismChecked: StateFlow<Boolean> = _isOptimismChecked

    private val _isRespectChecked = MutableStateFlow(false)
    val isRespectChecked: StateFlow<Boolean> = _isRespectChecked

    fun onEgoCheckedChanged(isChecked: Boolean) {
        if (isChecked)
            closeAllSwitch()
        _isEgoChecked.value = isChecked
    }

    fun onGivingCheckedChanged(isChecked: Boolean) {
        if (checkedEgoSwitch())
            _isGivingChecked.value = false
        else
            _isGivingChecked.value = isChecked
    }

    fun onHappinessCheckedChanged(isChecked: Boolean) {
        if (checkedEgoSwitch())
            _isHappinessChecked.value = false
        else
            _isHappinessChecked.value = isChecked
    }

    fun onKindnessCheckedChanged(isChecked: Boolean) {
        if (checkedEgoSwitch())
            _isKindnessChecked.value = false
        else
            _isKindnessChecked.value = isChecked
    }

    fun onOptimismCheckedChanged(isChecked: Boolean) {
        if (checkedEgoSwitch())
            _isOptimismChecked.value = false
        else
            _isOptimismChecked.value = isChecked
    }

    fun onRespectCheckedChanged(isChecked: Boolean) {
        if (checkedEgoSwitch())
            _isRespectChecked.value = false
        else
            _isRespectChecked.value = isChecked
    }

    private fun checkedEgoSwitch(): Boolean {
        return _isEgoChecked.value
    }

    private fun closeAllSwitch() {
        _isGivingChecked.value = false
        _isHappinessChecked.value = false
        _isKindnessChecked.value = false
        _isOptimismChecked.value = false
        _isRespectChecked.value = false
    }
}
