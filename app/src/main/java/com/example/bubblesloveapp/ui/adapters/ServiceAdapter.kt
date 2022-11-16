package com.example.bubblesloveapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bubblesloveapp.data.models.ServiceItemModel
import com.example.bubblesloveapp.databinding.ItemServicesBinding
import com.example.bubblesloveapp.interfaces.onServiceClickListener

class ServiceAdapter(val list:List<ServiceItemModel>): RecyclerView.Adapter<ServiceAdapter.ViewHolder>(){

    var listener: onServiceClickListener? = null

    class ViewHolder(val item: ItemServicesBinding):RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemServicesBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder , position: Int) {
        val service = list[position]
        holder.item.itemServiceTitle.text = service.title
        holder.item.itemServiceDescripcion.text = service.description
        holder.item.itemServiceIcon.setImageResource(service.icon.toInt())
        holder.item.root.setOnClickListener {
            listener?.onClick(service)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}