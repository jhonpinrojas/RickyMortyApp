package com.example.rickymortyapp.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickymortyapp.viewmodel.GetRickyMortyDataAdapter
import com.example.rickymortyapp.R
import com.example.rickymortyapp.data.Result
import com.example.rickymortyapp.viewmodel.Rickymortyviewmodel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var CharacterList: List<Result> = emptyList<Result>()
    private lateinit var viewModel: Rickymortyviewmodel
    private var page=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel =ViewModelProvider(this).get(Rickymortyviewmodel::class.java)
        val next = findViewById<Button>(R.id.Next)
        val previus = findViewById<Button>(R.id.Previus)
        initUI()
        next.setOnClickListener{
            page++
            initUI()
           }
        previus.setOnClickListener{
            page--
            if (page>0){
                initUI()
            } else { page++ }
        }
    }

    private fun initUI(){
        Rickymoryrecyclerview.layoutManager = LinearLayoutManager(this)
        viewModel.getCharacterListperpage(page)
        viewModel.CharacterList.observe(this, Observer { list ->
            (Rickymoryrecyclerview.adapter as GetRickyMortyDataAdapter).setData(list)
            CharacterList=list
        })
        Rickymoryrecyclerview.adapter= GetRickyMortyDataAdapter{
            val name = CharacterList[it].name
            val status = CharacterList[it].status
            val origen= CharacterList[it].origin.name
            val img= CharacterList[it].image
            val created = CharacterList[it].created
            val gender = CharacterList[it].gender
            val location = CharacterList[it].location.name
            val i= Intent(this, RicymortyDocument::class.java)
            i.putExtra("name", name)
            i.putExtra("status", status)
            i.putExtra("origen", origen)
            i.putExtra("img", img)
            i.putExtra("created", created)
            i.putExtra("gender", gender)
            i.putExtra("location", location)
            startActivity(i)

        }

    }
}