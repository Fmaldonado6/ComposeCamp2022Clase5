package com.fmaldonado.internetconnection.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fmaldonado.internetconnection.models.ApiModel
import com.fmaldonado.internetconnection.network.NetworkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface HomeUiState {
    data class Success(val list: List<ApiModel>) : HomeUiState
    object Loading : HomeUiState
    object Error : HomeUiState
}

class HomeViewModel : ViewModel() {


    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            homeUiState = try {
                val result = NetworkApi.retrofitService.getPhotos()
                HomeUiState.Success(result)
            } catch (e: IOException) {
                HomeUiState.Error
            }
        }
    }

}

