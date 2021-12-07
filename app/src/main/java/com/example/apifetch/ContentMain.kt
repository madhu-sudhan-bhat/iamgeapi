package com.example.apifetch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="https://picsum.photos/v2/"

class ContentMain : AppCompatActivity() {

    var list:ArrayList<DataFileItem>?= ArrayList()
    //
    val adapter:Adapter?= list?.let { Adapter(it)}
    //
    var myCompositeDisposable: CompositeDisposable? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_main)
        val rv = findViewById<RecyclerView>(R.id.RV)
        val manager: LinearLayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL, false
        )
        rv.layoutManager = manager
       //
        myCompositeDisposable = CompositeDisposable()
      //
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(Rxjava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(ApiInterface::class.java)
       //

//        myCompositeDisposable?.add(retrofitBuilder.getData()
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe(this::handleResponse))
      //

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<ArrayList<DataFileItem>?> {
            override fun onResponse(call: Call<ArrayList<DataFileItem>?>, response: Response<ArrayList<DataFileItem>?>) {
                Log.e("Response",response.body().toString())
                list=response.body();
                Log.d("ListValue",list.toString())
                val adapter = list?.let { Adapter(it) }
                rv.adapter=adapter
            }

            override fun onFailure(call: Call<ArrayList<DataFileItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })


    }

}