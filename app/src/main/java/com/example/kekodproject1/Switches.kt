package com.example.kekodproject1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.example.kekodproject1.databinding.FragmentSwitchesBinding

class Switches : Fragment() {

    private var _binding: FragmentSwitchesBinding? = null
    private val binding get() = _binding!!
    private var itemCount = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentSwitchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val switches = listOf(
            binding.givingSwitch,
            binding.respectSwitch,
            binding.happinessSwitch,
            binding.kindnessSwitch,
            binding.optimismSwitch
        )

        // Ego switch'i dinleyici
        binding.egoSwitch.setOnCheckedChangeListener { _, isChecked ->
            handleEgoSwitch(isChecked,switches)
        }

        // Diğer switch'lerin dinleyicileri
        switches.forEach { switch ->
            switch.setOnClickListener {
                val isChecked = switch.isChecked
                handleSwitchCheckedChange(switch, isChecked)
            }
        }
    }

    private fun handleEgoSwitch(isChecked: Boolean,switches: List<SwitchCompat>) {
        if (isChecked) {

            (activity as MainActivity).setBotNavVisibility(false)
            switches.forEach { switch ->
                removeMenuItem(switch.id)
                switch.isChecked = false
            }
        } else {
            (activity as MainActivity).setBotNavVisibility(true)
        }
    }


    private fun handleSwitchCheckedChange(switch: SwitchCompat, isChecked: Boolean) {
        if (binding.egoSwitch.isChecked) {
            switch.isChecked = false
            if (itemCount > 1)
                removeMenuItem(switch.id)
        } else {
            if (isChecked) {
                println(itemCount)
                if (itemCount < 5) {

                    addMenuItem(switch.id)
                } else if (itemCount == 5) {
                    switch.isChecked = false
                }
            } else {
                removeMenuItem(switch.id)
            }
        }
    }

    private fun addMenuItem(switchId: Int) {
        if ((activity as MainActivity).addMenuItem(switchId))
            itemCount++

    }

    private fun removeMenuItem(switchId: Int) {
        if ((activity as MainActivity).removeMenuItem(switchId))
            itemCount--


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
