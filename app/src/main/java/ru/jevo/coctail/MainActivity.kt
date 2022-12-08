package ru.jevo.coctail

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import kotlinx.android.synthetic.main.activity_main.*
import ru.jevo.coctail.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainActivityViewModel
    lateinit var cocAdapter: SimpleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSearchCoctail()
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        loadApiData("vodka")
        initRecyclerView()


    }

    private fun initRecyclerView() {
        val recycler: RecyclerView = findViewById(R.id.recyclerView)
        recycler.apply {
            val layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext, VERTICAL)
            addItemDecoration(decoration)
            cocAdapter = SimpleAdapter()
            adapter = cocAdapter
        }

    }

    fun initSearchCoctail() {
        inputCoctailName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                   loadApiData(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {
                loadApiData(p0.toString())


            }

        })
    }

    private fun loadApiData(input: String) {


        viewModel.coctailList.observe(this, {
            recyclerView.adapter = cocAdapter
            cocAdapter.notifyDataSetChanged()
            fillList()

            (it).forEach { i -> println(i.body) }


        })
        viewModel.makeApiCall(input)


    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("$i test") }
        return data
    }
}