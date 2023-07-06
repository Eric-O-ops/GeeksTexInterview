package com.eric.geekstexinterview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eric.geekstexinterview.databinding.ItemCarBinding

class CarAdapter : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    private var arrayCar:ArrayList<Car> = ArrayList()

    inner class ViewHolder(private val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(model: Car) {
            Glide.with(binding.iv).load(model.image).into(binding.iv)
            with(binding) {
                tvName.text = model.name
                tvYear.text= model.year.toString()
            }
        }
    }

    fun setList(list: ArrayList<Car>) { arrayCar = list }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(arrayCar[position])
    }

    override fun getItemCount(): Int = arrayCar.size
}