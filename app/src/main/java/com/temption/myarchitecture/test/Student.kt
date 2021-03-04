package com.temption.myarchitecture.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

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
open class Student(private var name: String, private var age: Int) {

   open  var gender: Int? = null
   open  val gender2: Int? = null

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




    }

    fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")


    fun main() {
            runBlocking {
                val a = async { log("I'm computing a piece of the answer")
                    6
                }
                val b = async { log("I'm computing another piece of the answer")
                    7
                }
                log("The answer is ${a.await() * b.await()}")
            }

        runBlocking { //sampleStart /
            //启动一个协程来处理某种传入请求（request）
            val request = launch {
                repeat(3) { i -> // 启动少量的子作业
                    launch {
                        delay((i + 1) * 200L) // 延迟 200 毫秒、400 毫秒、600 毫秒的时间
                        println("Coroutine$i is done")
                    }
                }
                println("request: I'm done and I don't explicitly join my children that are still active")
            }
            request.join() // 等待请求的完成，包括其所有子协程 println("Now processing of the request is complete") /
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

class Son(private var name: String, private var age: Int) :Student(name, age){
    override var gender: Int? = 2
    override var gender2: Int = 2
    val size: Int
        get() { // 👈 每次获取 size 值时都会执行 items.size
            return 2
        }
    var volume: Int
        get() { // 👈 每次获取 size 值时都会执行 items.size
            return 2
        }
        set(value) {
            println(value)}
}



fun main(args: Array<String>) {
    println("main")
    val list = mutableListOf<Int>()


    list.filter { true  }




    val action: () -> Long = {
        0
    }

    run(action)

    run {
        0
    }


    println(action.invoke())
    println(action.invoke())
    println(action.invoke())
    println(action.invoke())


    fun double(x: Int): Int {
        return 2 * x
    }

    val double = double(2)

    val stringPlus: (String, String) -> String = String::plus


}

var size:Int = 3



fun fibonacci(): () -> Long { //返回值为一个无参返回值为Long类型的函数
    var first = 0L
    var second = 1L

    return fun(): Long { //返回一个匿名函数
        val result = second
        second += first
        first = second - first
        return result
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


var n = 0L
var next = 1L

private fun fibonacci(s:Long):Long{
    if (s <= 0L){
        return n
    }else if (s == 1L){
        return n+next
    }else{
        return fibonacci(s - 1) + fibonacci(s - 2)
    }
}