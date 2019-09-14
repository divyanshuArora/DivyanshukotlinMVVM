package com.example.divyanshukotlinmvvm.service.repository

import android.util.Log
import androidx.core.graphics.ColorUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.divyanshukotlinmvvm.interfaces.SelectedUserApiInterface
import com.example.divyanshukotlinmvvm.service.model.UserSelectionResponse
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONArray


class SelectedUserRepository {

    companion object FactoryUser {
        fun getUserInstance(): SelectedUserRepository {
            return SelectedUserRepository()
        }
    }

    fun getUserList(id: String): LiveData<UserSelectionResponse> {

        var data = MutableLiveData<UserSelectionResponse>()


        SelectedUserApiInterface.createUserSelection().getSelectedUser(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                data.value = it
                Log.d("SelectedUserRepository","result"+it)

            }, { Log.d("SelectedUserRepository", "Failed:" + it) })

        return  data
    }
}


//        SelectedUserApiInterface.createUserSelection().getSelectedUser(id)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(object: Observer<UserSelectionResponse>{
//
//                override fun onNext(response: UserSelectionResponse) {
//
//
//                    Log.d("SelectedUserRepository","list: "+response.toString())
//
//
//                }
//
//                override fun onComplete() {
//
//                }
//
//                override fun onSubscribe(d: Disposable) {
//
//                    Log.e("SelectedUserRepository","Disposable"+d)
//                }
//
//
//                override fun onError(e: Throwable) {
//
//                    Log.e("SelectedUserRepository","Throw: "+e)
//                }
//            })
//
//        return data
//    }





