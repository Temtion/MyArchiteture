package com.temption.myarchitecture.test

import androidx.lifecycle.lifecycleScope
import com.temption.myarchitecture.data.Person
import kotlinx.coroutines.*
import okhttp3.internal.wait

/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2021/1/14 14:42
 */
/**
 * @Description:
 * @Author:         haoshuaihui
 * @CreateDate:     2021/1/14 13:41
 */
class Student(private var name: String, private var age: Int) {

    private var gender: Int? = null

    init {
        name = "$name inited"
    }

    constructor(name: String, age: Int, gender: Int) : this(name, age) {
        this.gender = gender
    }

    fun show() {
        print("该学生的姓名是：${name},年龄是:${age},性别是：${gender}")
    }

    fun judge() {
        if (age > 30 && gender == 1) {
            print("bad")
        } else {
            print("good")
        }
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    companion object{
        const val staticValue = "dsadsa";
        @JvmStatic
        fun main(args: Array<String>) {

        }
    }
}

fun main(args: Array<String>) {
    println("main")
    runBlocking {
        val async = async {
            getWebTime()
        }
        val result = async.await()
        //deal result
        val result2 = getWebTime()
        //deal result


        launch {


        }
        coroutineScope {

        }
        supervisorScope {

        }
    }
}

private suspend fun getWebTime(): Long = withContext(Dispatchers.IO) {
    3
}

private fun averageArray(array: Array<Int>) {
    val start = System.currentTimeMillis();
    val average = array.average()
    println("array平均值是：${average},耗时${System.currentTimeMillis() - start}")
}

fun averageList(list: List<Int>) {
    val start = System.currentTimeMillis();
    val average = list.average()
    println("list平均值是：${average},耗时${System.currentTimeMillis() - start}")
}

private fun averageIntArray(intArrayResult: IntArray) {
    val start = System.currentTimeMillis();
    val average = intArrayResult.average()
    println("IntArray平均值是：${average},耗时${System.currentTimeMillis() - start}")
}


private fun testList() {
    val student = Student("haha", 31, 1)
    student.show()
    student.judge()

    val listOf = mutableListOf<Int?>(1, 5)
    listOf.add(2)
    listOf.add(2)
    listOf.add(null)
    listOf.filterNotNull()
    listOf.forEach {
        println(it)
    }
    for (item in listOf) {
        println(item)
    }
}