package com.example.mvvpexamplekotlin.datasource

import android.os.Handler
import com.example.mvvpexamplekotlin.model.Repository

class GitRepoLocalDataSource {
    val arrayList = ArrayList<Repository>()
    fun getRepositories(onRepositoryReadyCallback: OnRepoLocalReadyCallback){
        arrayList.add(Repository(
            "First Local Repo",
            "Local Owner 1",
            100,
            false
        )
        )
        arrayList.add(
            Repository(
                "Second Local Repo",
                "Local Owner 2",
                30,
                true
            )
        )
        arrayList.add(
            Repository(
                "Third Local Repo",
                "Local Owner 3",
                430,
                false
            )
        )
        Handler().postDelayed({onRepositoryReadyCallback.onLocalDataReady(arrayList)}, 2000)
    }

    fun saveRepositories(list: ArrayList<Repository>){
        if(arrayList != list)
            arrayList.addAll(list)
    }
}

interface OnRepoLocalReadyCallback {
    fun onLocalDataReady(data : ArrayList<Repository>)
}