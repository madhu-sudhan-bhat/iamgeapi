package com.example.apifetch

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
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
        val apiInterface = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build().create(ApiInterface::class.java)

        with(apiInterface) {

            getData()
                .observeOn(AndroidSchedulers.mainThread())

                .subscribeOn(Schedulers.io())
                .subscribe(object: DisposableObserver <ArrayList<DataFileItem>>(){
                    override fun onNext(t: ArrayList<DataFileItem>) {
                        Log.e("Response",t.toString())
                        list=t;
                        Log.d("ListValue",list.toString())
                        val adapter = list?.let { Adapter(it) }
                        rv.adapter=adapter
                    }

                    override fun onError(e: Throwable) {

                    }

                    override fun onComplete() {

                    }
                }

                )
        }


    }


}