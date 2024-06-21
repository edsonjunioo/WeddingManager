package br.com.weddingmanager.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.weddingmanager.R
import br.com.weddingmanager.model.Supplier

class ListSuppliersAdapter(
    private val context: Context,
    suppliers: List<Supplier>
) : RecyclerView.Adapter<ListSuppliersAdapter.ViewHolder>() {

    private val suppliers = suppliers.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(supplier: Supplier) {
            val name = itemView.findViewById<TextView>(R.id.name)
            name.text = supplier.name
            val type = itemView.findViewById<TextView>(R.id.type)
            type.text = supplier.type
            val amount = itemView.findViewById<TextView>(R.id.amount)
            amount.text = supplier.amount.toPlainString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.supplier_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = suppliers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val supplier = suppliers[position]
        holder.bind(supplier)
    }

    fun update(suppliers: List<Supplier>) {
        this.suppliers.clear()
        this.suppliers.addAll(suppliers)
//        notifyDataSetChanged()
    }

}
