package io.toru.imagedownloader.kotlin.ui.view

import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import io.toru.imagedownloader.R
import io.toru.imagedownloader.kotlin.model.AppData

/**
 * Created by wonyoung on 2016. 11. 27..
 */
class MainAdapter(val dataList:List<AppData>, val onClick:(AppData)->Any) : Adapter<MainViewHolder>() {
    override fun getItemCount(): Int {
        return dataList.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        return LayoutInflater.from(parent?.context).inflate(R.layout.adapter_main, parent, false).let { MainViewHolder(it, onClick) }
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        holder?.updateView(dataList[position])
    }
}