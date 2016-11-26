package io.toru.imagedownloader.kotlin.ui.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import io.toru.imagedownloader.R
import io.toru.imagedownloader.kotlin.model.AppData

/**
 * Created by wonyoung on 2016. 11. 27..
 */
class MainViewHolder(itemView: View?, val onClick:(AppData)->Any) : RecyclerView.ViewHolder(itemView) {
    private var mainItemText : TextView
    private var mainItemImage : ImageView

    init {
        mainItemText = itemView?.findViewById(R.id.main_adapter_text) as TextView
        mainItemImage = itemView?.findViewById(R.id.main_adapter_image) as ImageView
    }

    fun updateView(data:AppData){
        with(data){
            mainItemText.text = data.name
            data.appDrawable?.let { mainItemImage.setImageDrawable(it)}
            itemView.setOnClickListener {
                onClick(this)
            }
        }
    }
}