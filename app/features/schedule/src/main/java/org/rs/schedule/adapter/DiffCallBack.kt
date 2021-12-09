package org.rs.schedule.adapter

import androidx.recyclerview.widget.DiffUtil
import org.rs.cardears.core.model.Appointment
import org.rs.cardears.core.model.Provider

object DiffCallBack : DiffUtil.ItemCallback<Appointment>() {
    override fun areItemsTheSame(oldItem: Appointment, newItem: Appointment): Boolean =
        oldItem.time == newItem.time

    override fun areContentsTheSame(oldItem: Appointment, newItem: Appointment): Boolean =
        oldItem == newItem
}
