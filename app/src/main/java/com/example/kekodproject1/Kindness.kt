package com.example.kekodproject1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kekodproject1.databinding.FragmentKindnessBinding

class Kindness : Fragment() {

    private var _binding: FragmentKindnessBinding? = null
    private val binding get() = _binding!!
    private var score = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentKindnessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val answersGroup = binding.answersGroup
        val submitButton = binding.submitButton
        val resultImage = binding.resultImage
        val questionText = binding.questionText

        questionText.text = "Bir arkadaşın kodu çalışmadığı için ağlıyorsa, nasıl tepki verirsiniz?"

        answersGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.answerA.id -> score = 0
                binding.answerB.id -> score = 1
            }
        }


        submitButton.setOnClickListener {
            resultImage.visibility = View.VISIBLE
            resultImage.setImageResource(if (score != 0) R.drawable.kindness_image else R.drawable.rude_image)
            binding.questionLayout.visibility=View.GONE
            binding.resultLayout.visibility=View.VISIBLE
            if (score != 0) {
                binding.kindnessText.visibility = View.VISIBLE
            } else {
                binding.rudeText.visibility = View.VISIBLE
            }
        }




    }

}