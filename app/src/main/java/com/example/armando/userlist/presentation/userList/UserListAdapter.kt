package com.example.armando.userlist.presentation.userList

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.example.armando.userlist.R
import com.example.armando.userlist.data.model.UserEntity
import com.example.armando.userlist.data.model.UserEntityDiff
import kotlinx.android.synthetic.main.item_user.view.*


//Para hacer un Listener
typealias OnUserClick = (userEntity : UserEntity)-> Unit

class UserListAdapter(val onUserClick: OnUserClick) :
        RecyclerView.Adapter<UserListAdapter.UserListVH>()  {

    private val items : MutableList<UserEntity> = mutableListOf()
    override fun getItemCount(): Int =items.size

    fun submitList(items:List<UserEntity>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false)
        return  UserListVH(view)
    }

    override fun onBindViewHolder(holder: UserListVH, position: Int) {
        holder.bind(items[position])
    }


    inner class UserListVH(view:View) : RecyclerView.ViewHolder(view){
            //itemView es cada elemento de la lista
            fun bind(userEntity: UserEntity){
                with(itemView){
                    user_name.text = userEntity.name
                    //Cargamos imagen con Glide
                    Glide.with(user_avatar)
                            .load(userEntity.avatarUrl)
                            .into(user_avatar)
                }
                itemView.setOnClickListener {
                    onUserClick(userEntity)
                }
            }


        }

}