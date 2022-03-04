package com.example.flavordemo.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flavordemo.adapter.FeatureListAdapter
import com.example.flavordemo.databinding.ActivityMainBinding
import com.example.flavordemo.databinding.ItemFeatureBinding
import com.example.flavordemo.model.Feature


class MainActivity : AppCompatActivity() {
    //view binding for the activity
    private var _binding: ActivityMainBinding? = null //kotlin is null safe, so declaring nullable
    private val binding get() = _binding!! //using the assertion since we know value will never be null

    // creating the reference to the feature adapter and the feature list
    // in this list, pass the data model of Feature

    private lateinit var featureListAdapter: FeatureListAdapter
    private lateinit var featureList: ArrayList<Feature>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //it binds r.layout.activity_main

        callService("URL Implementation TO:DO")

        //creating LayoutManager
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        // adding rvFeatureLists to a layoutManager
        binding.rvFList.setLayoutManager(layoutManager)
        //initialize the adapter, and pass the required argument
        featureList = ArrayList()
        featureListAdapter = FeatureListAdapter(featureList)

        //attach adapter to the recycler view
        binding.rvFList.adapter = featureListAdapter

        //load feature
        loadFeatureList("Login")
        loadFeatureList("Register")
        loadFeatureList("Forgot Password")
        loadFeatureList("Facebook Login")
        loadFeatureList("Google Login")
        loadFeatureList("Play Paid Game")
        binding.rvFList.isVisible


    }

    private fun callService(url: String) {
        Toast.makeText(this, url, Toast.LENGTH_SHORT).show()
    }


    private fun loadFeatureList(featureText: String) {
        val feature = Feature()
        feature.feature = featureText
        featureList.add(feature)
    }

    // on destroy of view make the set the binding reference to null

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}




