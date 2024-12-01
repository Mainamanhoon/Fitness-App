package com.example.myapplication

import java.io.Serializable

class Workout(var title:String, var description:String, var picPath:String, var kcal:Int,
              val durationAll:String, var tutorials:ArrayList<Tutorial>
):Serializable {

//    fun getTittle(): String{
//        return title
//    }
//    fun getDescription(): String{
//        return description
//    }
//    fun getPicPath(): String {
//       return picPath
//    }
//
//    fun getLessons(): ArrayList<Tutorial> {
//       return tutorials
//    }
//
//    fun getKcal(): Int {
//        return kcal
//    }
//
//    fun getDurationAll(): String {
//        return durationAll
//    }

}