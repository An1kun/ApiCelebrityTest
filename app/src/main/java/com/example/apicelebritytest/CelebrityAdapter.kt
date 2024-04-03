package com.example.apicelebritytest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class CelebrityAdapter(private var celebrities: List<Celebrity>):RecyclerView.Adapter<CelebrityAdapter.CelebrityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebrityViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.celebrity_item,parent,false)
        return CelebrityViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return celebrities.size
    }
    override fun onBindViewHolder(holder: CelebrityViewHolder, position: Int) {
        val celebrity = celebrities[position]
        holder.bind(celebrity)
    }


    fun updateData(newCelebrity: List<Celebrity>) {
        val diffCallback = CelebrityDiffCallBack(celebrities,newCelebrity)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        celebrities = newCelebrity
        diffResult.dispatchUpdatesTo(this)
    }


    inner class CelebrityViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val ageTextView: TextView = itemView.findViewById(R.id.ageTextView)
        private val professionsTextView: TextView = itemView.findViewById(R.id.professionsTextView)
        private val networthTextView: TextView = itemView.findViewById(R.id.networthTextView)
        private val nationalityTextView: TextView = itemView.findViewById(R.id.nationalityTextView)
        private val heightTextView: TextView = itemView.findViewById(R.id.heightTextView)
        private val birthdayTextView: TextView = itemView.findViewById(R.id.birthdayTextView)


        fun bind(celebrity: Celebrity) {
            nameTextView.text = celebrity.name
            ageTextView.text = "Age: ${celebrity.age}"
            professionsTextView.text = "Professions: ${celebrity.occupation.joinToString(", ")}"
            networthTextView.text = "Net Worth: ${celebrity.networth}"
            nationalityTextView.text = "Nationality: ${celebrity.nationality}"
            heightTextView.text = "Height: ${celebrity.height}"
            birthdayTextView.text = "Birthday: ${celebrity.birthday}"
        }

    }
}