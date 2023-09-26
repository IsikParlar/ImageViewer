package com.example.imageviewer.presenter

import com.example.imageviewer.model.Model
import com.example.imageviewer.view.MainView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Presenter {
    val model = Model()
    private var mainView: MainView? = null

    fun getMembers() {
        val disposable = model.request("https://api.github.com/")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { members ->
                mainView?.showMembers(members)
            }
    }

    fun sendActivity(mainView: MainView){
        this.mainView = mainView
    }
}