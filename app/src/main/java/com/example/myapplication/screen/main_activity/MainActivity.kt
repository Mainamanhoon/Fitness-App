package com.example.myapplication.screen.main_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Adapter.WorkoutAdapter
import com.example.myapplication.model.Tutorial
import com.example.myapplication.model.Workout
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        val workoutList:ArrayList<Workout> = getData()
        val recyclerView :RecyclerView = binding.recyclerView1
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL,false)
        recyclerView.adapter = WorkoutAdapter(workoutList)

    }

    private fun getData(): ArrayList<Workout> {
        val list = ArrayList<Workout>()

        list.add(
            Workout(
                title = "Running",
                description = "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body.",
                picPath = "pic_1",
                kcal = 160,
                durationAll = "9 min",
                tutorials = getLesson1()
            )
        )

        list.add(
            Workout(
                title = "Stretching",
                description = "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body.",
                picPath = "pic_2",
                kcal = 230,
                durationAll = "85 min",
                tutorials = getLesson2()
            )
        )

        list.add(
            Workout(
                title = "Yoga",
                description = "You just woke up. It is a brand new day. The canvas is blank. How do you begin? Take 21 minutes to cultivate a peaceful mind and strong body.",
                picPath = "pic_3",
                kcal = 180,
                durationAll = "65 min",
                tutorials = getLesson3()
            )
        )

        return list
    }
    private fun getLesson1(): ArrayList<Tutorial> {
        val list = ArrayList<Tutorial>()
        list.add(Tutorial("Lesson 1", "03:46", "HBPMvFkPgNE", "pic_1_1"))
        list.add(Tutorial("Lesson 2", "03:41", "K6124WqjjPW", "pic_1_2"))
        list.add(Tutorial("Lesson 3", "01:57", "Zc08V4YY0eA", "pic_1_3"))
        return list
    }

    private fun getLesson2(): ArrayList<Tutorial> {
        val list = ArrayList<Tutorial>()
        list.add(Tutorial("Lesson 1", "20:23", "LJeImBAXT7I", "pic_3_1"))
        list.add(Tutorial("Lesson 2", "18:27", "47Exgz07FLU", "pic_3_2"))
        list.add(Tutorial("Lesson 3", "32:25", "OmLx8tmaQ-4", "pic_3_3"))
        list.add(Tutorial("Lesson 4", "07:52", "w86EaIoFRY", "pic_3_4"))
        return list
    }

    private fun getLesson3(): ArrayList<Tutorial> {
        val list = ArrayList<Tutorial>()
        list.add(Tutorial("Lesson 1", "23:00", "v7AYKMP6rOE", "pic_3_1"))
        list.add(Tutorial("Lesson 2", "27:00", "EmLzxnoJYE", "pic_3_2"))
        list.add(Tutorial("Lesson 3", "21:00", "v7SN-d4qXx0", "pic_3_3"))
        list.add(Tutorial("Lesson 4", "21:00", "LQxZ628YNj4", "pic_3_4"))
        return list
    }


}