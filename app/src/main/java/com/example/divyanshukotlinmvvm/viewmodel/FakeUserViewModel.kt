package com.example.divyanshukotlinmvvm.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.divyanshukotlinmvvm.service.model.FakeUserModel
import com.example.divyanshukotlinmvvm.service.model.FakeUsersResponse
import com.example.divyanshukotlinmvvm.service.repository.FakeUserRepository

class FakeUserViewModel (application: Application): AndroidViewModel(application)
{
    fun getSelectedFakeUser(page: String,context: Context): LiveData<FakeUsersResponse>
    {
        //return SelectedUserRepository.getUserInstance().getUserList(page)
        return  FakeUserRepository.getInstance().getFakeUserList(page)
    }

}