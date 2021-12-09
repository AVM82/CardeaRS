package org.rs.schedule.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import org.rs.cardears.core.model.Appointment

class AppointmentAdapter(private val onClickListener: OnClickListener) : ListAdapter<Appointment, AppointmentViewHolder>(DiffCallBack) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder =
        AppointmentViewHolder.from(parent)

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.setOnClickListener {
            item?.let { item -> onClickListener.onClick(item) }
        }
        holder.bind(item)
    }

    class OnClickListener(private val clickListener: (item: Appointment) -> Unit) {
        fun onClick(item: Appointment) = clickListener(item)
    }
}