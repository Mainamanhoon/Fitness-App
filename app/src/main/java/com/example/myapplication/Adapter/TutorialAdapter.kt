package com.example.myapplication.Adapter

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.model.Tutorial
import com.example.myapplication.databinding.TutorialViewHolderBinding

class TutorialAdapter(val tutorials:ArrayList<Tutorial>):RecyclerView.Adapter<TutorialAdapter.ViewHolder>() {
    lateinit var context: Context
    class ViewHolder(val binding: TutorialViewHolderBinding):RecyclerView.ViewHolder(binding.root){
            val imageView = binding.imageView6
            val duration = binding.durationTv
            val title = binding.titleTv
      }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TutorialAdapter.ViewHolder {
         context = parent.context
         val binding : TutorialViewHolderBinding = TutorialViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         return ViewHolder(binding)
     }

     override fun onBindViewHolder(holder: TutorialAdapter.ViewHolder, position: Int) {
          val tutorial : Tutorial = tutorials[position]
          holder.title.text = tutorial.title
          holder.duration.text = tutorial.duration.toString()

         val resId = holder.itemView.context.resources.getIdentifier(
             tutorial.picPath, "drawable", holder.itemView.context.packageName
         )

         Glide.with(holder.itemView.context)
             .load(resId).
             into(holder.imageView)

         holder.binding.root.setOnClickListener{
             val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:${tutorial.link}"))
             val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watc?v=${tutorial.link}"))

             try{
                 context.startActivity(appIntent)
             }catch(e:ActivityNotFoundException){
                 context.startActivity(webIntent)
             }
         }

      }

     override fun getItemCount(): Int {
         return tutorials.size
     }

 }