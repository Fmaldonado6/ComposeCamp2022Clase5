package com.fmaldonado.internetconnection.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fmaldonado.internetconnection.network.ApiModel
import kotlinx.coroutines.launch
import java.io.IOException


class HomeViewModel : ViewModel() {

    init {
        getPhotos()
    }

    private fun getPhotos() {

    }

}

