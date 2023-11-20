package com.example.finalbs_

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class HomeActivity : AppCompatActivity() {

    private val BASE_URL = "https://developer.sepush.co.za/business/2.0/"
    private val TAG: String = "CHECK_RESPONSE"
    private val apiKey = "CC086C16-1FD54C97-A7ACE9C8-6F290F7D"
    private lateinit var areaInfoTextView: TextView
    private lateinit var recyclerViewSchedule: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        areaInfoTextView = findViewById(R.id.textViewAreaInfo)
        recyclerViewSchedule = findViewById(R.id.recyclerViewSchedule)

        // Set up RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerViewSchedule.layoutManager = layoutManager

        GETALLCOMMENTS()
    }

    private fun GETALLCOMMENTS() {
        val interceptor = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("token", apiKey)
                .build()
            chain.proceed(request)
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        api.getComments("eskde-10-fourwaysext10cityofjohannesburggauteng", "current")
            .enqueue(object : Callback<Comments> {
                override fun onResponse(
                    call: Call<Comments>,
                    response: Response<Comments>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { comments ->
                            // Access data as needed
                            val name = comments.info.name
                            val region = comments.info.region
                            val events = comments.events

                            // Process the data as needed
                            Log.i(TAG, "onResponse: Name: $name, Region: $region")
                            for (event in events) {
                                Log.i(TAG, "Event: Start: ${event.start}, End: ${event.end}, Note: ${event.note}")
                            }

                            // Check if schedule is accessible in Comments
                            val schedule = comments.schedule
                            val days = schedule?.days ?: emptyList<Day>() // Replace 'Day' with your actual class

                            // Set up the adapter for the RecyclerView
                            val scheduleAdapter = ScheduleAdapter(days)
                            recyclerViewSchedule.adapter = scheduleAdapter as RecyclerView.Adapter<RecyclerView.ViewHolder>
                        }
                    }
                }


                override fun onFailure(call: Call<Comments>, t: Throwable) {
                    Log.i(TAG, "onFailure: ${t.message}")
                }
            })
    }


    // ... (rest of your code)

    fun HomePage(view: View?) {
        // Define the intent to start the new activity
        val intent = Intent(
            this,
            HomeActivity::class.java
        ) // Replace TargetActivity with the name of the activity you want to open
        startActivity(intent)
    }

    fun Status(view: View?) {
        // Define the intent to start the new activity
        val intent = Intent(
            this,
            ScheduleActivity::class.java
        ) // Replace TargetActivity with the name of the activity you want to open
        startActivity(intent)
    }

    fun AddLocation(view: View?) {
        // Define the intent to start the new activity
        val intent = Intent(
            this,
            AddLocationActivity::class.java
        ) // Replace TargetActivity with the name of the activity you want to open
        startActivity(intent)
    }

    fun Calc(view: View?) {
        // Define the intent to start the new activity
        val intent = Intent(
            this,
            WattCalcActivity::class.java
        ) // Replace TargetActivity with the name of the activity you want to open
        startActivity(intent)
    }
}


