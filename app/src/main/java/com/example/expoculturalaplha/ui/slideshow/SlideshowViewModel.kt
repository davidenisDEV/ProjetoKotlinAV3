package com.example.expoculturalaplha.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Você não possui nenhuma conquista."
    }
    val text: LiveData<String> = _text
}