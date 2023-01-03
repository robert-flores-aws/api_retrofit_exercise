package com.example.api_system

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (val product: MutableList<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        return holder.bindView(product[position])
    }

    override fun getItemCount(): Int {
        return product.size
    }


}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val txtId = itemView.findViewById<TextView>(R.id.txt_id)
    private val txtName = itemView.findViewById<TextView>(R.id.txt_name)
    private val txtEmail = itemView.findViewById<TextView>(R.id.txt_email)
    private val txtBody = itemView.findViewById<TextView>(R.id.txt_body)

    fun bindView(product: Product){

        txtId.text = product.id.toString()
        txtName.text = "Name : " + product.name
        txtEmail.text = "Email : " + product.email
        txtBody.text = "Comment : " + product.body

        val nameSpan = SpannableStringBuilder(txtName.text)
        val emailSpan = SpannableStringBuilder(txtEmail.text)
        val bodySpan = SpannableStringBuilder(txtBody.text)
        val bss = StyleSpan(android.graphics.Typeface.BOLD)
        nameSpan.setSpan(bss, 0, 6, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        emailSpan.setSpan(bss, 0, 7, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
        bodySpan.setSpan(bss, 0, 9, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        txtName.text = nameSpan
        txtEmail.text = emailSpan
        txtBody.text = bodySpan
    }
}