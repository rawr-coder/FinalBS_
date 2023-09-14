package com.example.finalbs_.ui.addlocation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class addlocationViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is addlocation Fragment"
    }
    val text: LiveData<String> = _text
}