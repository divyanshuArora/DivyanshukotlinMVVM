package com.example.divyanshukotlinmvvm.service.repository
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.divyanshukotlinmvvm.interfaces.ApiInterfaces
import com.example.divyanshukotlinmvvm.service.model.FakeUsersResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers



open class FakeUserRepository {

    companion object Factory
    {
        fun getInstance(): FakeUserRepository
        {
            return FakeUserRepository()
        }
    }

    fun getFakeUserList(page:String): LiveData<FakeUsersResponse>
    {
        var data = MutableLiveData<FakeUsersResponse>()

        ApiInterfaces.create2().getFakeUsers(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data.value = it
                Log.d("FakeRepo","Resp")
            },{ Log.d("FakeRepo","Error"+it) })


            return  data
    }
}






////////////////// usign retrogit

//var interfaces: ApiInterfaces
//
//interfaces = ApiClient.createService(ApiInterfaces::class.java,"https://reqres.in/api/")
//
//val responseBodyCall: Call<FakeUsersResponse> = interfaces.getFakeUsers(page)
//responseBodyCall.enqueue(object :Callback<FakeUserModel>
//{
//    override fun onFailure(call: Call<FakeUserModel>, t: Throwable) {
//        Log.d("FakeUserRepository",""+t)
//    }
//
//    override fun onResponse(call: Call<FakeUserModel>, response: Response<FakeUserModel>) {
//
//        var result = response.body().toString()
//
//        Log.d("FakeUserRepository","response: "+result)
//    }
//})





////////////////// usign retrogit









