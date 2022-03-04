package com.example.flavordemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.flavordemo.databinding.ItemFeatureBinding
import com.example.flavordemo.model.Feature


class FeatureListAdapter(
    private val featureList: ArrayList<Feature>
) : RecyclerView.Adapter<FeatureListAdapter.ViewHolder>() {

    //creating a inner class with name ViewHolder
    //it takes a view argument, in which we will pass the generated class of item_feature
    class ViewHolder(val binding: ItemFeatureBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemFeatureBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(featureList[position]) {
                binding.tvFeature.text = feature
            }
        }
        holder.binding.cardFeature.setOnClickListener(View.OnClickListener {
            Toast.makeText(
                holder.binding.root.context,
                featureList[position].feature,
                Toast.LENGTH_SHORT
            ).show()
        })

    }

    override fun getItemCount(): Int {
        return featureList.size //returns the size of Arraylist of Feature
    }
}