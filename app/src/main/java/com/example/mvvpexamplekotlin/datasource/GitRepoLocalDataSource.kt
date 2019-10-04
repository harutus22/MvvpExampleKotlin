package com.example.mvvpexamplekotlin.datasource

import android.os.Handler
import com.example.mvvpexamplekotlin.model.Repository

class GitRepoLocalDataSource {
    val arrayList = ArrayList<Repository>()
    fun getRepositories(onRepositoryReadyCallback: OnRepoLocalReadyCallback){
        val list = ArrayList<Repository>()
        list.add(Repository(
            "First Local Repo",
            "Local Owner 1",
            100,
            false
        )
        )
        list.add(
            Repository(
                "Second Local Repo",
                "Local Owner 2",
                30,
                true
            )
        )
        list.add(
            Repository(
                "Third Local Repo",
                "Local Owner 3",
                430,
                false
            )
        )
        if (arrayList.isEmpty()){
            arrayList.addAll(list)
        }
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