package com.example.codtricks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import com.example.codtricks.databinding.ActivityMainBinding
import com.example.codtricks.fragments.FragmentGuns
import com.example.codtricks.fragments.FragmentMaps
import com.example.codtricks.fragments.FragmentTricks

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBarMain)
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this ,
            binding.drawerMain ,
            binding.toolBarMain ,
            R.string.open_drawer ,
            R.string.close_drawer
        )
        actionBarDrawerToggle.syncState()

        firstRun(FragmentTricks())
        binding.bottomNavigationMain.setOnItemSelectedListener {

            when (it.itemId){
                R.id.menu_tricks_bottom -> {
                    replaceFragment(FragmentTricks())
                }
                R.id.menu_guns_bottom -> {
                    replaceFragment(FragmentGuns())
                }
                R.id.menu_maps_bottom -> {
                    replaceFragment(FragmentMaps())
                }
            }
            true
        }
        binding.bottomNavigationMain.setOnItemReselectedListener {  }




    }

    fun replaceFragment (fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container , fragment)
        transaction.commit()

    }
    fun firstRun (fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container , fragment)
        transaction.commit()
        binding.bottomNavigationMain.selectedItemId = R.id.menu_tricks_bottom
    }
}