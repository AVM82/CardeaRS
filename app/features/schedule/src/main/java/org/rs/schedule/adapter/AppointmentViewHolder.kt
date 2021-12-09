package org.rs.schedule.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.rs.cardears.core.model.Appointment
import org.rs.schedule.databinding.ItemTimeBinding

class AppointmentViewHolder(private val binding: ItemTimeBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(item: Appointment) {
        views {
            appointment.text = item.time
            if (item.customer == null) {
                timeItem.setCardBackgroundColor(Color.rgb(56, 142, 60))
            } else {
                timeItem.setCardBackgroundColor(Color.GRAY)
            }
        }
    }

    companion object {
        fun from(parent: ViewGroup) = ItemTimeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ).let(::AppointmentViewHolder)
    }

    private fun <T> views(block: ItemTimeBinding.() -> T): T? = binding.block()

}
