package com.dolezal.infinite.net

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dolezal.infinite.data.NetworkState

class NetworkStateModel {

    private val _state = MutableLiveData<NetworkState>()
    val state: LiveData<NetworkState> = _state

    fun postState(state: NetworkState) {
        _state.postValue(state)
    }
}