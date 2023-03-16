package com.example.livedata_viewmodel_databinding_demoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    //Here we don't our counter to be changed by other classes, so we will
    //make it private and
    //make another object of LiveData(Not Mutable LiveData) to get counter value.
    //As LiveData cannot be changed, they are immutable
    //Hence, we now made it Read Only Live Data
    private var counter = MutableLiveData<Int>()
    val countData : LiveData<Int>
    get() = counter



    init {
        counter.value = 0
    }

    fun updateCounter(){
        counter.value = (counter.value)?.plus(1)
    }
}