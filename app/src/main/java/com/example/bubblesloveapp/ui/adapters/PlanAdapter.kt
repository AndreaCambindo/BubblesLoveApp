package com.example.bubblesloveapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bubblesloveapp.interfaces.OnPlanClickListener
import com.example.bubblesloveapp.data.models.PlanItemModel
import com.example.bubblesloveapp.databinding.ItemCitaBinding

class PlanAdapter(var list: List<PlanItemModel>): RecyclerView.Adapter<PlanAdapter.ViewHolder>(){

    var listener: OnPlanClickListener? = null

    class ViewHolder(val item: ItemCitaBinding): RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemCitaBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder , position: Int) {
        val plan = list[position]
        holder.item.itemCitaTitle.text = plan.name
        holder.item.itemCitaSumary.text = plan.categoria
        holder.item.itemCitaIcon.setImageResource(plan.image.toInt())
        holder.item.root.setOnClickListener{
            listener?.onClick(plan)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDataSet(list: List<PlanItemModel>){
        this.list = list
        notifyDataSetChanged()
    }
}