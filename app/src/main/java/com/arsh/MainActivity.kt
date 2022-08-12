package com.arsh

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import  com.arsh.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = getSharedPreferences(resources.getString(R.string.app_name), MODE_PRIVATE)
        editor = sharedPreferences.edit()
        if (sharedPreferences.contains("Data")){
            binding.editText.setText(sharedPreferences.getString("Data",""))
        }

        binding.btn.setOnClickListener{
            if (binding.editText.text.isNullOrEmpty()==false){
                editor.putString("Data",binding.editText.text.toString())
                editor.apply()

            }else{
                Toast.makeText(this,"enter value to save",Toast.LENGTH_SHORT)
            }
        }
        binding.remove.setOnClickListener{
            editor.clear()
            editor.apply()


        }
    }
}