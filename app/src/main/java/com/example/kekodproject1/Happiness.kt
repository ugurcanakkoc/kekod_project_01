package com.example.kekodproject1

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kekodproject1.databinding.FragmentHappinessBinding

class Happiness : Fragment() {

    private var _binding: FragmentHappinessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHappinessBinding.inflate(inflater, container, false)

        val imageView = binding.happinessView
        Glide.with(this).asGif().load(R.drawable.happiness).into(imageView)
        val rotateImage = binding.happinessView
        val rotateAnimation = ObjectAnimator.ofFloat(rotateImage, "rotation", 0f, 360f)
        rotateAnimation.duration = 9000
        rotateAnimation.repeatCount = ObjectAnimator.INFINITE
        rotateAnimation.start()

        val scaleXAnimator = ObjectAnimator.ofFloat(rotateImage, "scaleX", 1f, 2f,1f)
        val scaleYAnimator = ObjectAnimator.ofFloat(rotateImage, "scaleY", 1f, 2f,1f)

        scaleXAnimator.duration = 3000 // Genişleme süresi (milisaniye)
        scaleYAnimator.duration = 3000 // Genişleme süresi (milisaniye)

        scaleXAnimator.repeatCount = ObjectAnimator.INFINITE
        scaleYAnimator.repeatCount = ObjectAnimator.INFINITE

        scaleXAnimator.interpolator = LinearInterpolator()
        scaleYAnimator.interpolator = LinearInterpolator()

        // Genişleme animasyonunu eşzamanlı başlat
        scaleXAnimator.start()
        scaleYAnimator.start()
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
