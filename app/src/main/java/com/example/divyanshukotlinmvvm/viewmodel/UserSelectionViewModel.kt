package com.example.divyanshukotlinmvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.divyanshukotlinmvvm.service.model.UserSelectionResponse
import com.example.divyanshukotlinmvvm.service.repository.SelectedUserRepository

class UserSelectionViewModel(application: Application): AndroidViewModel(application)
{

    fun getSelectedUser(userId: String):LiveData<UserSelectionResponse>
    {
        return SelectedUserRepository.getUserInstance().getUserList(userId)
    }



}
