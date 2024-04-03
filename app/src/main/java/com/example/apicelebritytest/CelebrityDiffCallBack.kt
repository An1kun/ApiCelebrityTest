package com.example.apicelebritytest

import androidx.recyclerview.widget.DiffUtil

class CelebrityDiffCallBack(private val oldList:List<Celebrity>,private val newList: List<Celebrity> ):DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldCelebrity = oldList[oldItemPosition]
        val newCelebrity = newList[newItemPosition]
        return oldCelebrity.name == newCelebrity.name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldCelebrity = oldList[oldItemPosition]
        val newCelebrity = newList[newItemPosition]
        return oldCelebrity == newCelebrity
    }
}