package com.example.mvvpexamplekotlin.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvpexamplekotlin.viewmodel.MainViewModel
import com.example.mvvpexamplekotlin.R
import com.example.mvvpexamplekotlin.databinding.ActivityMainBinding
import com.example.mvvpexamplekotlin.model.Repository
import com.example.mvvpexamplekotlin.recyclerview.RepoAdapter

class MainActivity : AppCompatActivity(), RepoAdapter.OnRepositoryItemClickListener {
    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    lateinit var binding: ActivityMainBinding
    private val repositoryRecyclerViewAdapter = RepoAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = repositoryRecyclerViewAdapter
        viewModel.repositories.observe(this, Observer<ArrayList<Repository>>{
            it?.let { repositoryRecyclerViewAdapter.replaceData(it) }
        })
    }
}
