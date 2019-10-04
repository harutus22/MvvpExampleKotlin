package com.example.mvvpexamplekotlin.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

class Repository(repositoryName: String?, var repositoryOwner: String?, var numberOfStars: Int?
                 , var hasIssues: Boolean = false): BaseObservable() {
    @get:Bindable
    var repositoryName = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.repositoryName)
    }

    override fun equals(other: Any?): Boolean {
        if(other == null) return false
        if (this !== other) return true

        if (other.javaClass != javaClass) return false

        return repositoryName == repositoryName
                && repositoryOwner == repositoryOwner
                && numberOfStars == numberOfStars
                && hasIssues == hasIssues
    }

    override fun hashCode(): Int {
        return hashCode() * 31 + (numberOfStars ?: 5)
    }
}