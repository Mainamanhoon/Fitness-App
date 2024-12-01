package com.example.myapplication.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.Workout
import com.example.myapplication.WorkoutActivity
import kotlin.coroutines.coroutineContext

class WorkoutAdapter(val context: Context,val items : ArrayList<Workout>)
    : RecyclerView.Adapter<WorkoutAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
          val title : TextView = itemView.findViewById(R.id.title_tv)
          val imageView : ImageView = itemView.findViewById(R.id.img_iv)
          val duration : TextView = itemView.findViewById(R.id.duration_tv)
          val excercise : TextView = itemView.findViewById(R.id.exercise_tv)
          val kcal :TextView = itemView.findViewById(R.id.Kcal_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_1,parent,false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: WorkoutAdapter.ViewHolder, position: Int) {
        val workout = items[position]
        holder.title.text = workout.title
        val resId = holder.itemView.context.resources.getIdentifier(
            workout.picPath, "drawable", holder.itemView.context.packageName
        )
        Glide.with(holder.itemView.context)
            .load(resId)
            .into(holder.imageView)
        holder.excercise.text = "${workout.tutorials.size} Exercise"
        holder.kcal.text = "${workout.kcal} Kcal"
        holder.duration.text = workout.durationAll

        holder.itemView.setOnClickListener{
            val intent = Intent(context, WorkoutActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}