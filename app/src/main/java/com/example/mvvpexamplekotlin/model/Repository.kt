package com.example.mvvpexamplekotlin.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class Repository(repositoryName: String?, var repositoryOwner: String?, var namberOfStarts: Int?
                 , var hasIssues: Boolean = false): BaseObservable() {
    @get:Bindable
    var repositoryName = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.repositoryName)
    }
}