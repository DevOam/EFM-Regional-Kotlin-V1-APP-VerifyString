package com.example.efm_kotlin_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var buttonOk:Button
    lateinit var stringOfUser:EditText
    lateinit var emptyOrBlankText:TextView
    lateinit var acronymText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonOk=findViewById(R.id.button)
        stringOfUser=findViewById(R.id.string)
        emptyOrBlankText=findViewById(R.id.emptyOrBlank)
        acronymText=findViewById(R.id.acronym)
        buttonOk.setOnClickListener {
            val stringEnterByUser:String=stringOfUser.text.toString()
            vérifieString(stringEnterByUser)
            acronymText.text=stringEnterByUser.acronym()
        }
    }
    fun vérifieString(str:String){
        if (str.isBlank()){
            emptyOrBlankText.text="it is Blank"
        }else if(str.isEmpty()){
            emptyOrBlankText.text="it is Empty"
        }else {
            emptyOrBlankText.text="not blank or empty"
        }
    }
    fun String.acronym(): String {
        val mots= this.split(" ").filter { it.isNotBlank() }
        val acronym = StringBuilder()
        for (mot in mots) {
            acronym.append(mot[0].toUpperCase())
        }
        return acronym.toString()}
}