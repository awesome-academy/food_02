package com.example.gfood.data.source.local

interface OnFetchDataLocalListener<T> {

    fun onSuccess(data: T)
    fun onFailed(idMessage: Int)
}
