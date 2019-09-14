package com.example.divyanshukotlinmvvm.service.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserSelectionModel
{
    @SerializedName("userId")
    @Expose
    private var userId: String? = null
    @SerializedName("id")
    @Expose
    private var id: String? = null
    @SerializedName("title")
    @Expose
    private var title: String? = null
    @SerializedName("body")
    @Expose
    private var body: String? = null



    fun getUserId(): String? {
        return userId
    }

    fun setUserId(userId: String?) {
        this.userId = userId
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getTitle(): String? {
        return title
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getBody(): String? {
        return body
    }

    fun setBody(body: String?) {
        this.body = body
    }
}