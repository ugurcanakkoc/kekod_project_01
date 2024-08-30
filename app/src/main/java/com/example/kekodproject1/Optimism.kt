package com.example.kekodproject1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kekodproject1.databinding.FragmentOptimismBinding

class Optimism : Fragment() {

    private var _binding: FragmentOptimismBinding? = null
    private val binding get() = _binding!!
    val optimismQuotes = listOf(
        "Her gün yeni bir umut doğar.",
        "Güneş her zaman bulutların arkasında parlıyor.",
        "Pozitif düşünmek, en iyi yol arkadaşıdır.",
        "Zorluklar geçicidir, umut kalıcıdır.",
        "Gülümse, hayat kısa ve güzeldir."
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentOptimismBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this).asGif().load(R.drawable.optimism).into(binding.imageView)

        binding.textView.setOnClickListener {
            val randomQuote = optimismQuotes.random()
            binding.textView.text = randomQuote
        }




    }

}