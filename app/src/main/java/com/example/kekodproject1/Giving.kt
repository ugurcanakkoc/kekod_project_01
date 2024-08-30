package com.example.kekodproject1

import android.content.Intent
import android.graphics.ImageDecoder
import android.graphics.ImageDecoder.*
import android.net.Uri
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kekodproject1.databinding.FragmentGivingBinding

class Giving : Fragment() {

    private var _binding: FragmentGivingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentGivingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = binding.givingGif
        Glide.with(this).asGif().load(R.drawable.giving).into(imageView)


        binding.sendSmsButton.setOnClickListener {
            sendSms("İyi ki varsın!")
        }
    }

    private fun sendSms(message: String) {
        val smsUri = Uri.parse("smsto:")
        val intent = Intent(Intent.ACTION_SENDTO, smsUri).apply {
            putExtra("sms_body", message)
        }
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}