package com.rafif.gamebargainhub.core.ui

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rafif.gamebargainhub.core.R
import com.rafif.gamebargainhub.core.databinding.ItemListDealBinding
import com.rafif.gamebargainhub.core.domain.model.Deal
import com.rafif.gamebargainhub.core.utils.StringUtils.getStoreName


class DealsAdapter : RecyclerView.Adapter<DealsAdapter.ListViewHolder>() {

    private var listData = ArrayList<Deal>()
    var onItemClick: ((Deal) -> Unit)? = null

    fun setData(newListData: List<Deal>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_list_deal, parent, false))

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount() = listData.size

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListDealBinding.bind(itemView)
        fun bind(data: Deal) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.thumb)
                    .into(ivItemImage)
                tvItemTitle.text = data.title
                val subtitle = itemView.context.getString(R.string.item_subtitle, getStoreName(data.storeId))
                val normalPrice = itemView.context.getString(R.string.item_price, data.normalPrice)
                val salePrice = itemView.context.getString(R.string.item_price, data.salePrice)
                val savings = itemView.context.getString(R.string.item_savings, data.savings
                    .toFloat().toInt().toString())
                tvItemSubtitle.text = subtitle
                tvNormalPrice.text = normalPrice
                tvSalePrice.text = salePrice
                tvSavings.text = savings
                tvNormalPrice.paintFlags = tvNormalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            }
        }
        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}