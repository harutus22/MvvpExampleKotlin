package com.example.mvvpexamplekotlin.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvpexamplekotlin.GitRepoRepository


import com.example.mvvpexamplekotlin.model.Repository
import com.example.mvvpexamplekotlin.network.NetworkManager

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var gitRepoRepository: GitRepoRepository = GitRepoRepository(NetworkManager(getApplication()))
    var isLoading = ObservableField(false)
    var repositories = MutableLiveData<ArrayList<Repository>>()

    fun loadRepositories() {
        isLoading.set(true)
        gitRepoRepository.getRepositories(object :
            GitRepoRepository.OnRepositoryReadyCallback {
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                if (data != repositories.value) {
                    repositories.value = data
                }
            }
        })
    }
}