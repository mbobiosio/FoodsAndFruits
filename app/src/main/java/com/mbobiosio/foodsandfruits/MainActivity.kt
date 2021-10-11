package com.mbobiosio.foodsandfruits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mbobiosio.foodsandfruits.model.Food
import com.mbobiosio.foodsandfruits.util.loadFoodsFromAsset
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import timber.log.Timber
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchDataFromJson()
        Timber.d("OnCreate")
    }

    private fun fetchDataFromJson() {
        try {
            val foods = loadFoodsFromAsset(this)
            val foodsArray = JSONArray(foods)

            Timber.d("Food array $foodsArray")
            for (i in 0 until foodsArray.length()) {
                val foodObj: JSONObject = foodsArray.getJSONObject(i)
                foodObj.apply {
                    val id = getInt("id")
                    val name = getString("productName")
                    val image = getInt("image")
                    val from = getString("from")
                    val nutrients = getString("nutrients")
                    val quantity = getString("quantity")
                    val price = getDouble("price")
                    val organic = getBoolean("organic")
                    val description = getString("description")

                    //add objects to foods data class
                    val food = Food(
                        id = id,
                        productName = name,
                        image = image,
                        from = from,
                        nutrients = nutrients,
                        quantity = quantity,
                        price = price,
                        isOrganic = organic,
                        description = description
                    )

                    Timber.d("$food")
                }
            }
        } catch (e: JSONException) {

        } catch (e: IOException) {

        }
    }
}