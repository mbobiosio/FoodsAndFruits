package com.mbobiosio.foodsandfruits.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.mbobiosio.foodsandfruits.databinding.FragmentFruitDetailBinding
import com.mbobiosio.foodsandfruits.model.Fruits
import timber.log.Timber


class FruitDetailFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentFruitDetailBinding

    private lateinit var fruits: Fruits

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFruitDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        val bundle = arguments
        if (bundle != null) {
            fruits = (bundle.getSerializable("data") as Fruits)
            binding.fruits = fruits
        }
        Timber.d("${fruits.description}")

        binding.imageView3.setOnClickListener { dismiss() }

        return binding.root
    }
}