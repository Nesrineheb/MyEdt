package com.example.myedt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class EnseignantDetailActivity : AppCompatActivity() {

    lateinit var gradeView: TextView
    lateinit var enseignementView: TextView
    lateinit var titreView : TextView


    companion object {

        val EXTRA_Enseignant = "enseignant"


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enseignant_detail)


        titreView = findViewById(R.id.titreView) as TextView
        gradeView = findViewById(R.id.gradeView) as TextView
        enseignementView = findViewById(R.id.enseignementView) as TextView




        titreView.text=intent.getStringExtra("nom")
        gradeView.text=intent.getStringExtra("grade")

        enseignementView.text=intent.getStringExtra("ens")




    }
}