package com.mbobiosio.foodsandfruits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.mbobiosio.foodsandfruits.databinding.ActivityMainBinding
import com.mbobiosio.foodsandfruits.listener.FoodClickListener
import com.mbobiosio.foodsandfruits.model.Fruits
import com.mbobiosio.foodsandfruits.ui.adapter.FoodsAdapter
import com.mbobiosio.foodsandfruits.ui.fragment.FruitDetailFragment
import com.mbobiosio.foodsandfruits.util.loadFoodsFromAsset
import timber.log.Timber

/*
* Created by Mbuodile Obiosio on Oct 10, 2021.
* Twitter: @cazewonder
* Nigeria
*/
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FoodsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this

        initAdapter()
        fetchDataFromJson()
    }

    private fun fetchDataFromJson() {
        //load data from json data file
        val foods = loadFoodsFromAsset(this)

        //use gson to parse json data to list
        val foodList = Gson().fromJson(foods, Array<Fruits>::class.java).toList()

        //Timber.d("Foods $foodList")
        /*
        * This project uses ListAdapter so we call 'submitList' to parse data to adapter
        *
        * */
        adapter.submitList(foodList)
    }

    private fun initAdapter() {
        adapter = FoodsAdapter(object: FoodClickListener {
            override fun onItemClicked(fruits: Fruits) {
                //Timber.d("$fruits")
                val fragment = FruitDetailFragment()
                val bundle = Bundle()
                bundle.putSerializable("data", fruits)
                fragment.arguments = bundle
                fragment.show(supportFragmentManager, fragment.tag)

            }
        })
        binding.foods.adapter = adapter
    }
}