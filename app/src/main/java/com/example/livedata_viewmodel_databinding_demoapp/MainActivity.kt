package com.example.livedata_viewmodel_databinding_demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata_viewmodel_databinding_demoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        //binding.btn.setOnClickListener()
        //We are controlling Click events here by making a View Model object in XML file and using onClick() attribute.

        binding.myViewModel = viewModel

        viewModel.counter.observe(this, Observer {
            binding.textView.text = it.toString()
        })
    }
}