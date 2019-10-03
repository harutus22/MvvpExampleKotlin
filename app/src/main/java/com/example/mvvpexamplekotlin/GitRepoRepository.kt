package com.example.mvvpexamplekotlin

import com.example.mvvpexamplekotlin.datasource.GitRepoLocalDataSource
import com.example.mvvpexamplekotlin.datasource.GitRepoRemoteDataSource
import com.example.mvvpexamplekotlin.datasource.OnRepoRemoteRepositories
import com.example.mvvpexamplekotlin.datasource.OnRepoLocalReadyCallback
import com.example.mvvpexamplekotlin.model.Repository
import com.example.mvvpexamplekotlin.network.NetworkManager

class GitRepoRepository(val networkManager: NetworkManager) {
    val localData = GitRepoLocalDataSource()
    val remoteData = GitRepoRemoteDataSource()

    fun getRepositories(onRepositoryReadyCallback: OnRepositoryReadyCallback){
        networkManager.isConnectedToInternet?.let {
            if(it){
                remoteData.getRepositories(object : OnRepoRemoteRepositories{
                    override fun onRemoteDataReady(repoList: ArrayList<Repository>) {
                        localData.saveRepositories(repoList)
                        onRepositoryReadyCallback.onDataReady(repoList)
                    }
                })
            } else {
                localData.getRepositories(object : OnRepoLocalReadyCallback{
                    override fun onLocalDataReady(data: ArrayList<Repository>) {
                        onRepositoryReadyCallback.onDataReady(data)
                    }
                })
            }
        }
    }

    interface OnRepositoryReadyCallback {
        fun onDataReady(data: ArrayList<Repository>)
    }
}

