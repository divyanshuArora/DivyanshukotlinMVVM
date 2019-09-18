package com.example.divyanshukotlinmvvm.service.repository
import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.divyanshukotlinmvvm.interfaces.SelectedUserApiInterface
import com.example.divyanshukotlinmvvm.service.model.UserSelectionModel
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.Callback
import okhttp3.Response
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import java.util.logging.Level.parse


class SelectedUserRepository {

    companion object FactoryUser {
        fun getUserInstance(): SelectedUserRepository {
            return SelectedUserRepository()
        }
    }

    @SuppressLint("CheckResult")
    fun getUserList(id: String): LiveData<List<UserSelectionModel>> {
        var data = MutableLiveData<List<UserSelectionModel>>()

        SelectedUserApiInterface.createUserSelection().getSelectedUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe( {   data.value = it
                Log.d("selected", "Error: "+it.size) },
                        { Log.d("selected", "Error: "+it.message.toString())})
        return data
        }
    }







