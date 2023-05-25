package com.example.reciphyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reciphyapp.databinding.FragmentRecommendBinding

class FragmentRecommend : Fragment() {
    private var position: Int? = null
    private var username: String? = null
    private var _binding: FragmentRecommendBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvRecommend.layoutManager = LinearLayoutManager(requireActivity())

        arguments?.let {
            position = it.getInt(ARG_POSITION, 0)
            username = it.getString(ARG_RECIPE)
        }

        when {
            position == 1 -> findRecommend1()
            position == 2 -> findRecommend2()
            position == 3 -> findRecommend3()
        }
    }

    private fun findRecommend3() {
        binding.textView.text = "Telur"
    }

    private fun findRecommend2() {
        binding.textView.text = "Ayam"
    }

    private fun findRecommend1() {
        binding.textView.text = "Daging"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecommendBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        val ARG_RECIPE = "recipe"
        val ARG_POSITION = "position"
    }
}