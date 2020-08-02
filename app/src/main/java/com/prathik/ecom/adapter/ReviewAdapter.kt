package com.prathik.ecom.adapter

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Paint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prathik.ecom.R
import com.prathik.ecom.customView.AddButtonView
import com.prathik.ecom.realm.products.ProductsModelR
import io.realm.RealmRecyclerViewAdapter
import io.realm.RealmResults

class ReviewAdapter public constructor(
    context: Context,
    var modelArrayList: RealmResults<ProductsModelR>?
) : RealmRecyclerViewAdapter<ProductsModelR, ReviewAdapter.ViewHolder>(
    modelArrayList,
    true
) {

    var contexts: Context? = context


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.review_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val obj = modelArrayList?.get(position)

        if (obj != null && obj.count > 0) {
            holder.itemView.visibility = View.VISIBLE
            holder.itemView.layoutParams = RecyclerView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            holder.foodname.text = obj?.foodName
            holder.cart_countPrice.text = getPerPrice(obj.price, obj.count)

        } else {
            holder.itemView.visibility = View.GONE
            holder.itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
        }

    }


    fun getPerPrice(price: Float, count: Int): String {

        return "$count x ${contexts?.getString(R.string.rupee)}$price = ${contexts?.getString(R.string.rupee)}${count * price}"
    }

    override fun getItemCount(): Int {

        return if (modelArrayList == null) {
            0
        } else {
            modelArrayList?.size!!
        }


    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var foodname: TextView = itemView.findViewById(R.id.Restaurant_Id)
        var cart_countPrice: TextView = itemView.findViewById(R.id.cart_countPrice)

    }


}