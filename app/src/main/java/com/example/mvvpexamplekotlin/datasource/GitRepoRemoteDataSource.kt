package com.example.mvvpexamplekotlin.datasource

import android.os.Handler
import com.example.mvvpexamplekotlin.model.Repository

class GitRepoRemoteDataSource{
    fun getRepositories(onRepoRemoteRepository: OnRepoRemoteRepositories){
        val list = ArrayList<Repository>()
        list.add(Repository("First Remote Repo", "Remote Owner 1", 100, false))
        list.add(Repository("Second Remote Repo", "Remote Owner 2", 30, true))
        list.add(Repository("Third Remote Repo", "Remote Owner 3", 430, false))

        Handler().postDelayed({onRepoRemoteRepository.onRemoteDataReady(list)}, 2000)
    }
}

interface OnRepoRemoteRepositories{
    fun onRemoteDataReady(repoList: ArrayList<Repository>)
}