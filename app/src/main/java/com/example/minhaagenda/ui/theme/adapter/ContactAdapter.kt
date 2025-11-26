package com.example.minhaagenda.ui.theme.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minhaagenda.R
import com.example.minhaagenda.data.model.Contact

class ContactAdapter(
    private var list: List<Contact>,
    private val onClick: (Contact) -> Unit,
    private val onLongPress: (Contact) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.txtName)
        val txtPhone: TextView = view.findViewById(R.id.txtPhone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val c = list[position]
        holder.txtName.text = c.name
        holder.txtPhone.text = c.phone

        holder.itemView.setOnClickListener { onClick(c) }
        holder.itemView.setOnLongClickListener { onLongPress(c); true }
    }

    fun update(newList: List<Contact>) {
        list = newList
        notifyDataSetChanged()
    }
}
