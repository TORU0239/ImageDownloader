package io.toru.imagedownloader.kotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import io.toru.imagedownloader.R
import io.toru.imagedownloader.kotlin.model.AppData
import io.toru.imagedownloader.kotlin.model.TestObject
import io.toru.imagedownloader.kotlin.presenter.MainPresenter
import io.toru.imagedownloader.kotlin.presenter.MainPresenterImp
import io.toru.imagedownloader.kotlin.ui.view.MainAdapter
import io.toru.imagedownloader.kotlin.view.MainView

class MainActivity : AppCompatActivity(), MainView{
    companion object{
        val TAG:String = MainActivity::class.java.simpleName
    }

    private val recyclerView by lazy{ // 호출하는 시점에 생성됨.
        findViewById(R.id.main_recyclerview) as RecyclerView
    }

    // 뒤늦게 값이 대입되어서 절대 null 이 되지 않는 경우에 lateinit 를 사용한다.
    lateinit private var adapter : MainAdapter
    lateinit var mainViewPresenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewPresenter = MainPresenterImp(this)
        mainViewPresenter.onInitMainView()
    }

    override fun initView() {
        val dataList: List<AppData> = listOf(AppData(name = "Toru", appDrawable = null), AppData(name = "Hailey", appDrawable = null), AppData(name = "Alice", appDrawable = null))
        adapter = MainAdapter(dataList,{ Toast.makeText(this, it.name, Toast.LENGTH_SHORT).show() })
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        TestObject.testObject() // singleton pattern 의 간단한 예
    }

    override fun updateView() { }

//    // MainActivity.TAG 와 동일한 역할.
//    companion object{
//        val TAG:String = MainActivity::class.java.simpleName
//    }
//
//    var text: TextView? = null
//
//    private val textview by lazy{ // null 이 나올 수가 없다.
//        findViewById(R.id.textview)
//    }
//
//    private fun test10(){
//        Log.w(TAG , "test10")
//        text = textview as TextView
//        text!!.let { it.text = "1234"}
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        textview.setOnClickListener {
////            view -> // lambda 를 생략할 수도 있다.
////            test()
//            it.alpha = 0.5f
//            test()
//            test10()
//        }
//    }
//
//    fun test(){
//        val returnValue = (fun (a:Int, b:Int) = a+b)
//        Log.w(TAG, "result : " + returnValue(1,1))
//        val result = 1.max(10)
//        Log.w("TORU", "max result:::" + result)
//        Log.w("TORU", "min result:::" + 1.min(10))
//
//        val test = 1 min 10
//        test2()
//        Log.w("TORU", "test 3 : " + test3(11))
//        test4()
//    }
//
//    var tests = "Test!!!"
//    fun test2(){
//        Log.w("TORU", "name $tests test")
//    }
//
//    fun test3(x:Any):Any{
//        // kotlin 에서는 when 이 switch 를 대신한다.
//        when(x){
//            "test" ->return "test shit"
//            1 -> return 18
//            else -> return "NULL"
//        }
//    }
//
//    fun test4(){
//        val list = ArrayList<String>()
//        list.add("test1")
//        list.add("test2")
//        list.add("test3")
//        list.add("test4")
//        list.add("test5")
//
//        for(s in list){
//            Log.w("TORU", "string : $s")
//        }
//
//        // steram 형태
//        list.filter { it == "test4" || it == "test5" }.map { Log.w("TORU", "test:: $it")}
//    }
//
//    // infix notation
//    fun Int.max(x:Int): Int = if (this > x) this else x
//    infix fun Int.min(x:Int): Int = if(this <= x) this else x
}