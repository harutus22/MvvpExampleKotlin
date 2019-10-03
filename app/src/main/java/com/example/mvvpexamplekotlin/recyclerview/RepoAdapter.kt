package com.example.mvvpexamplekotlin.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvpexamplekotlin.databinding.RvItemRepositoryBinding
import com.example.mvvpexamplekotlin.model.Repository

class RepoAdapter(private var repoList: ArrayList<Repository>,
                  private val listener: OnRepositoryItemClickListener):
    RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): RepoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemRepositoryBinding.inflate(layoutInflater, parent, false)
        return RepoViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) =
        holder.bind(repoList[position], listener)

    fun replaceData(list: ArrayList<Repository>) {
        repoList = list
        notifyDataSetChanged()
    }

    interface OnRepositoryItemClickListener {
        fun onItemClick(position: Int)
    }

    class RepoViewHolder(private var binding: RvItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository, itemClick: OnRepositoryItemClickListener) {
            binding.apply {
                repository = repo
                root.setOnClickListener { itemClick.onItemClick(layoutPosition) }
                executePendingBindings()
            }
        }
    }
}