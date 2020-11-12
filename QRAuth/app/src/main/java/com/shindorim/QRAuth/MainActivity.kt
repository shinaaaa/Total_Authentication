package com.shindorim.QRAuth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = ArrayList<AuthList>()
        list.add(
            AuthList(
                getDrawable(R.drawable.kakaolink_btn_medium)!!,
                getString(R.string.kakao),
                getString(R.string.kakao_link)
            )
        )
        list.add(
            AuthList(
                getDrawable(R.drawable.navelink_btn_green)!!,
                getString(R.string.naver),
                getString(R.string.naver_link)
            )
        )


        viewManager = LinearLayoutManager(this)
        viewAdapter = AuthListAdapter(list)

        recyclerView = findViewById(R.id.recycler_view)

        recyclerView.adapter = viewAdapter
        recyclerView.layoutManager = viewManager

    }
}