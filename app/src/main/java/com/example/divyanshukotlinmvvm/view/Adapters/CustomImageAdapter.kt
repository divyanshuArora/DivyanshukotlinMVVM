package com.example.divyanshukotlinmvvm.view.Adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.net.URL

object CustomImageAdapter
{

    @BindingAdapter("getImageFromUrl")
    @JvmStatic
    fun getImage(imageView: ImageView,url: String)
    {
        Glide.with(imageView.context).load(url).into(imageView)
    }


    @BindingAdapter("imageResource")
    fun setImageResource(imageView: ImageView, resource: Int){
        imageView.setImageResource(resource)

    }





}