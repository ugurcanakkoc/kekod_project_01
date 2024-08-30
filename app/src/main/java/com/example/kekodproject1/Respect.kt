package com.example.kekodproject1

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kekodproject1.databinding.FragmentRespectBinding

class Respect : Fragment() {

    private var _binding: FragmentRespectBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentRespectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ekranın altından gelen buton
        val respectButton = binding.respectButton
        val imageView = binding.imageView
        val fadeOutImage = ObjectAnimator.ofFloat(imageView,"alpha",1f,0f)
        val fadeOutButton = ObjectAnimator.ofFloat(respectButton,"alpha",1f,0f)

        val scaleX = ObjectAnimator.ofFloat(imageView, "scaleX", 1f, 1.5f)
        val scaleY = ObjectAnimator.ofFloat(imageView, "scaleY", 1f, 1.5f)
        fadeOutButton.duration = 1000
        fadeOutImage.duration = 500

        scaleX.duration = 9000
        scaleY.duration = 9000

        fadeOutImage.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                imageView.setImageResource(R.drawable.respect)

                val fadeIn = ObjectAnimator.ofFloat(imageView, "alpha", 0f, 1f)
                fadeIn.duration = 500
                fadeIn.start()
            }
        })



        respectButton.setOnClickListener {
            scaleX.start()
            scaleY.start()
            fadeOutImage.start()
            fadeOutButton.start()

        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
