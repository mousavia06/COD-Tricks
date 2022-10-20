package com.example.codtricks.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codtricks.R
import com.example.codtricks.adapter.TricksAdapter
import com.example.codtricks.data.ItemTricks
import com.example.codtricks.databinding.FragmentTricksBinding

class FragmentTricks :Fragment() {
    lateinit var binding: FragmentTricksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTricksBinding.inflate(layoutInflater , container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arrayListOf(
            ItemTricks("https://www.samagaha.com/wp-content/uploads/2019/10/perks-call-of-duty-mobile-featured.jpg",
                "پرک ها" ,
                "اشنایی با تمامی پرک ها"
            ) ,
            ItemTricks(
                "https://guides.gamepressure.com/call-of-duty-mobile/gfx/word/507327687.jpg",
                "چند نفره | multi" ,
                "حالت ها و آموزش بخش چند نفره بازی"
            ),
            ItemTricks(
                "https://charlieintel.com/wp-content/uploads/2021/09/blackout-map-cod-mobile.jpg",
                "بتل رویال | battle royale" ,
                "حالت ها و آمورش بخش بتل رویال"
            ),
            ItemTricks(
                "https://progameguides.com/wp-content/uploads/2021/08/Feature-Call-of-Duty-Mobile-Loadouts.jpg",
                "بخش Loadout",
                "بهترین Loadout ها برای مپ های مختلف"
            )
        )
        val myAdapter = TricksAdapter(data)
        binding.recycleTricks.adapter = myAdapter
        binding.recycleTricks.layoutManager = LinearLayoutManager(context ,RecyclerView.VERTICAL , false)
    }




}