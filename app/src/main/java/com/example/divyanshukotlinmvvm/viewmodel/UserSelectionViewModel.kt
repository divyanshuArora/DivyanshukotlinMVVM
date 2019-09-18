package com.example.divyanshukotlinmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.divyanshukotlinmvvm.service.model.UserSelectionModel
import com.example.divyanshukotlinmvvm.service.repository.SelectedUserRepository
import okhttp3.ResponseBody

class UserSelectionViewModel(application: Application): AndroidViewModel(application)
{

    fun getSelectedUser(userId: String):LiveData<List<UserSelectionModel>>
    {
        return SelectedUserRepository.getUserInstance().getUserList(userId)
    }



}
