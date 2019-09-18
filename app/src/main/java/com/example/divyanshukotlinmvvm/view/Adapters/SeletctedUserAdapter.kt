package com.example.divyanshukotlinmvvm.view.Adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.divyanshukotlinmvvm.R
import com.example.divyanshukotlinmvvm.databinding.SelectedUserBinding
import com.example.divyanshukotlinmvvm.service.model.UserSelectionModel
import okhttp3.ResponseBody

class SeletctedUserAdapter(context: Context, val list: List<UserSelectionModel>): RecyclerView.Adapter<SeletctedUserAdapter.ItemViewHolder>()
{

    var arrayList = list


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder
    {

        val selectedUserBinding: SelectedUserBinding
       selectedUserBinding =  DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.user_selection_item,parent,false)

        return ItemViewHolder(selectedUserBinding)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {
        holder.selectedUserBind(arrayList.get(position),position)
    }

    class ItemViewHolder(val userSelectionBinding: SelectedUserBinding): RecyclerView.ViewHolder(userSelectionBinding.root)
    {
        fun selectedUserBind(item: UserSelectionModel, position: Int)
        {
            userSelectionBinding.userModel = item
            userSelectionBinding.executePendingBindings()

        }


    }





}