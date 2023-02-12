package com.example.rickymortyapp.viewmodel

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.rickymortyapp.data.Result
import com.example.rickymortyapp.R
import kotlinx.android.synthetic.main.document_list.view.*



class GetRickyMortyDataAdapter(val documentClick: (Int) -> Unit): RecyclerView.Adapter<GetRickyMortyDataAdapter.SearchViewHolder>() {
    var characterList: List<Result> = emptyList<Result>()

    fun setData(list: List<Result>){
        characterList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.document_list, parent,false))
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val documento = characterList[position]
        holder.itemView.TvDescription.text = "Description ${documento.status} - ${documento.species}"
        holder.itemView.TvName.text = "Name: ${documento.name} "
        Glide.with(holder.itemView.context).load(documento.image).into(holder.itemView.ivitem)
        //holder.itemView.ivitem.imageView = Glide(getContext) documento.image
        holder.itemView.setOnClickListener { documentClick(position) }
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}