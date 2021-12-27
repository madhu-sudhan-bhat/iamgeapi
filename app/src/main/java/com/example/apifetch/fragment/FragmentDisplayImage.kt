package com.example.apifetch.fragment

import android.content.Intent.*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.apifetch.R
import com.squareup.picasso.Picasso

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "url"
private var Arg2 = ""
var mView: View? = null


class FragmentDisplayImage : Fragment() {

    private var param1: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


            param1 = it.getString("url")
            Arg2 = param1.toString()


//            Toast.makeText(context, param1.toString() , Toast.LENGTH_SHORT).show()
        }

    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        super.onCreateView(inflater, container, savedInstanceState);
//        var a =this.getView()
//        var image= view?.findViewById<ImageView>(R.id.Fragimage)
//        Picasso.get().load(Arg2).resize(700, 700).centerCrop().into(image);
//        return inflater.inflate(R.layout.fragment_display_image, container, false)
//
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_display_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var image= view.findViewById<ImageView>(R.id.Fragimage)
        Picasso.get().load(Arg2).resize(700, 700).centerCrop().into(image);
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            FragmentDisplayImage().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)

                }
            }
    }
}