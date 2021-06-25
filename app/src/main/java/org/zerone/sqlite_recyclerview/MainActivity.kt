package org.zerone.sqlite_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DatabaseHelper(this)
        for (i in 0..30){
            db.insertData("Name$i", i)
        }
        val userList = db.readData()
        db.close()

        val rv = findViewById<RecyclerView>(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        val mAdapter: RecyclerView.Adapter<RVAdapter.ViewHolder>
        mAdapter = RVAdapter(userList as ArrayList<UserObj>)
        rv.adapter = mAdapter
    }
}