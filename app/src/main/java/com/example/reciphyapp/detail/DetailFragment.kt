package com.example.reciphyapp.detail

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.BulletSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.reciphyapp.R
import com.example.reciphyapp.database.DetailResponse
import com.example.reciphyapp.database.StringData
import com.example.reciphyapp.databinding.FragmentDetailBinding
import com.example.reciphyapp.databinding.FragmentRecommendBinding

class DetailFragment : Fragment() {
    private var position: Int? = null
    private var ingredients: String? = null
    private var steps: String? = null
    private var listIngredients : List<String>? = null
    private var listSteps : List<String>? = null
    private var _binding: FragmentDetailBinding?= null
    private val binding get() = _binding!!
    private lateinit var tvDetail: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            position = it.getInt(ARG_POSITION, 0)
            ingredients = it.getString(ARG_INGREDIENTS)
            steps = it.getString(ARG_STEPS)
        }

        val delim = "--"
        listIngredients = ingredients?.split(delim)
        listSteps = steps?.split(delim)

        if (position == 1){
            binding.tvDetailFragment.text = listIngredients?.let { convertToBulletList(it) }
        } else {
            binding.tvDetailFragment.text = listSteps?.let { convertToBulletList(it) }
        }
    }

    fun convertToBulletList(stringList: List<String>): CharSequence {
        val spannableStringBuilder = SpannableStringBuilder("\n")
        stringList.forEachIndexed { index, text ->
            val line: CharSequence = text + (if (index < stringList.size - 1) "\n" else "")
            val spannable: Spannable = SpannableString(line)
            spannable.setSpan(
                BulletSpan(15, Color.BLACK),
                0,
                spannable.length,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE
            )
            spannableStringBuilder.append(spannable)
        }
        return spannableStringBuilder
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
        binding.tvDetailFragment.text = listIngredients?.let { convertToBulletList(it) }
    }

    companion object {
        val ARG_POSITION = "position"
        val ARG_INGREDIENTS = "ingredients"
        val ARG_STEPS = "steps"
    }
}