package com.temption.myarchitecture.logic.transformation

import androidx.lifecycle.*
import com.temption.myarchitecture.MyApplication
import com.temption.myarchitecture.data.Person

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2021/2/2 15:52
 */
class TransformationViewModel(app: MyApplication) : AndroidViewModel(app) {


    private val rawLiveData = MutableLiveData<Person>()

    fun start() {
        //person是data,data 1 equal data 2,如果使用distinctUntilChanged，只会拿到两次变化
        rawLiveData.value = Person("男", 27, false)
        rawLiveData.value = Person("男", 27, false)
        rawLiveData.value = Person("男", 28, false)
    }

    /**
     * 关注联系使用map
     */
    fun mapAgeOnly(): LiveData<Int> {
        return rawLiveData.map {
            it.age
        }
    }

    /**
     * 关注switch使用switchMap,比map更加灵活
     */
    fun switchMapAgeOnly(): LiveData<Int> {
        return rawLiveData.switchMap {
            MutableLiveData(it.age)
        }
    }
    /**
     *
     */
    fun distinctPerson(): LiveData<Person> {
        return rawLiveData.distinctUntilChanged()
    }

}