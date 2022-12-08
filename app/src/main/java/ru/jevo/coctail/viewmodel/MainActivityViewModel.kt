package ru.jevo.coctail.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.jevo.coctail.network.*


/**
 * Created by Alex on 09.03.2022.
 */
class MainActivityViewModel : ViewModel() {

    lateinit var coctailList: MutableLiveData<List<Post>>

    init {
        coctailList = MutableLiveData()
    }



    fun getCoctailListOberver(): MutableLiveData<List<Post>> = coctailList

    fun makeApiCall(query: String) {
        val apiData = ApiDataImpl.getApiData().create(ApiData::class.java)
        apiData.posts
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getCoctailListObserverRx())
    }

    private fun getCoctailListObserverRx(): Observer<List<Post>> {
        return object : Observer<List<Post>> {
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: List<Post>) {
                coctailList.postValue(t)


                Log.d("ГД2Е", t.size.toString())
            }

            override fun onError(e: Throwable) {
                Log.d("ОШИБКА", "")
            }

            override fun onComplete() {
                Log.d("777", "{EQ")
            }


        }
    }
}