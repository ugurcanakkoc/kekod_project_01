package com.example.kekodproject1

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.size
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kekodproject1.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val switches =
        MenuItem(101, "Switches", R.id.switchesNavigation, R.drawable.ic_switches)
    private val respectSwitch =
        MenuItem(R.id.respectSwitch, "Respect", R.id.respectNavigation, R.drawable.ic_respect)
    private val givingSwitch =
        MenuItem(R.id.givingSwitch, "Giving", R.id.givingNavigation, R.drawable.ic_giving)
    private val happinessSwitch = MenuItem(
        R.id.happinessSwitch,
        "Happiness",
        R.id.happinessNavigation,
        R.drawable.ic_happiness
    )
    private val kindnessSwitch =
        MenuItem(R.id.kindnessSwitch, "Kindness", R.id.kindnessNavigation, R.drawable.ic_kindness)
    private val optimismSwitch =
        MenuItem(R.id.optimismSwitch, "Optimism", R.id.optimismNavigation, R.drawable.ic_optimism)

    private lateinit var  navBarBottom: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = binding.fragmentContainerView.getFragment<NavHostFragment>()
        val navController = navHostFragment.findNavController()
        navBarBottom = binding.navBottomView

        navBarBottom.setupWithNavController(navController)


            navBarBottom.menu.add(0, switches.destinationId, 0, switches.switchName)
                .setIcon(switches.itemIcon)

        println(navBarBottom.size)


        }



        private fun getMenuItemIdForSwitch(switchId: Int): MenuItem? {
            return when (switchId) {
                R.id.respectSwitch -> respectSwitch
                R.id.givingSwitch -> givingSwitch
                R.id.happinessSwitch -> happinessSwitch
                R.id.kindnessSwitch -> kindnessSwitch
                R.id.optimismSwitch -> optimismSwitch

                else -> null
            }
        }

        fun addMenuItem(switchId: Int): Boolean {
            val menuItem = getMenuItemIdForSwitch(switchId)
            val menu = navBarBottom.menu
            if (menuItem != null && menu.findItem(menuItem.destinationId) == null && menu.size() < 5) {
                menu.add(0, menuItem.destinationId, 0, menuItem.switchName)
                    .setIcon(menuItem.itemIcon)
                return true
            } else {
                Snackbar.make(binding.root, "Navigasyon Menüsü Dolu", Snackbar.LENGTH_SHORT).show()
                return false
            }
        }


        fun removeMenuItem(switchId: Int): Boolean {
            val menuItem = getMenuItemIdForSwitch(switchId)
            menuItem?.let {
                binding.navBottomView.menu.findItem(it.destinationId)?.let { menuItem ->
                    binding.navBottomView.menu.removeItem(menuItem.itemId)
                    return true

                }
            }
            return false
        }

        fun setBotNavVisibility(visible: Boolean) {
            binding.navBottomView.visibility = if (visible) View.VISIBLE else View.GONE
        }

    }
