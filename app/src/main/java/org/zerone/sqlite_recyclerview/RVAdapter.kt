package org.zerone.sqlite_recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter (private val userList: ArrayList<UserObj>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {

        val tvNameCard: TextView = view.findViewById(R.id.name)
        val tvAgeCard: TextView = view.findViewById(R.id.age)

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.user_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNameCard.text = userList[position].userName
        holder.tvAgeCard.text = userList[position].userAge.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}