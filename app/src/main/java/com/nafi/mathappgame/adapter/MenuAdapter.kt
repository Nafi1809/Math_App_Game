package com.nafi.mathappgame.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nafi.mathappgame.R
import com.nafi.mathappgame.model.soal


class MenuAdapter(
    private val soalList: List<soal>,
    private val onItemClick: (soal) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_soal, parent, false)
        return MenuViewHolder(view)
    }
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val soal = soalList[position]
        holder.tvNamaSoal.text = soal.question
        holder.tvid.text = "Id ${soal.id}"
        holder.tvanswer_A.text = soal.answer_A
        holder.tvanswer_B.text = soal.answer_B
        holder.tvanswer_C.text = soal.answer_C
        holder.tvanswer_D.text = soal.answer_D
        holder.tvcorrect_answer.text = soal.correct_answer
        holder.tvdiffiqult.text = soal.difficult
        holder.itemView.setOnClickListener {onItemClick(soal)}

    }
    override fun getItemCount(): Int {
        return soalList.size
    }
    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNamaSoal: TextView = itemView.findViewById(R.id.tvsoal)
        val tvid: TextView = itemView.findViewById(R.id.tvid)
        val tvanswer_A: TextView = itemView.findViewById(R.id.tvanswer_A)
        val tvanswer_B: TextView = itemView.findViewById(R.id.tvanswer_B)
        val tvanswer_C: TextView = itemView.findViewById(R.id.tvanswer_C)
        val tvanswer_D: TextView = itemView.findViewById(R.id.tvanswer_D)
        val tvcorrect_answer: TextView = itemView.findViewById(R.id.tvcorrect_answer)
        val tvdiffiqult: TextView = itemView.findViewById(R.id.tvdiffiqult)
    }
}