package com.example.myedt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailSeanceActivity : AppCompatActivity() {


    lateinit var seance: Seance



    lateinit var titreView: TextView

    lateinit var descriptionView: TextView
    lateinit var enseignantView: TextView
    lateinit var dateView: TextView
    lateinit var dureeView: TextView
    lateinit var enseignants: MutableList<Enseignant>

    companion object {

        val EXTRA_Seance = "seance"


    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_seance)

        enseignants =mutableListOf<Enseignant>()

        enseignants.add(Enseignant("Ens Chalal Rachid", "Pr","Méthodologies d'analyse et conception de système d'information"))

        enseignants.add(Enseignant("Ens Challal Yacine", "MBC","Système d'exploitation, Sécurité, Réseaux"))

        enseignants.add(Enseignant("Ens BOUSBIA Nabila", "MBC","Patrons de Conception, Programmation Orientée Objet, Génie logiciel, Architecture des Ordinateurs , Base de données"))

        enseignants.add(Enseignant("Ens IMLOUL Salima", "MAA","Probabilités et Statistiques, Processus Aléatoires et Simulation, Analyse Mathématique"))

        enseignants.add(Enseignant("Ens ACHOUR Djaouida", "MAA","Analyse Mathématique 2,Analyse Mathématique 3"))

        enseignants.add(Enseignant("Ens DEBAILI Sarah", "Vac","Anglais"))

        enseignants.add(Enseignant("Ens KHELOUFI Ramdan", "MAA","Analyse Numérique, Algèbre"))

        enseignants.add(Enseignant("Ens ADMANE Lotfi", "MCA","Assurance qualité,TIC en Organisation,Management"))

        enseignants.add(Enseignant("Ens ANANE Mohamed", "MCB","Architecture des Ordinateurs 1,Introduction à la sécurité informatique"))

















        val extras:Bundle? =intent.extras
        if (extras != null) {
            //enseignant= extras.getParcelable(EnseignantDetailActivity.EXTRA_Enseignant)!!
            seance= extras.getParcelable<Seance>(EXTRA_Seance)!!
        }


        titreView = findViewById(R.id.titreView) as TextView
        descriptionView = findViewById(R.id.descriptionView) as TextView
        enseignantView = findViewById(R.id.enseignantView) as TextView
        dateView = findViewById(R.id.dateView) as TextView
        dureeView = findViewById(R.id.dureeView) as TextView




        titreView.text = seance.titre
        descriptionView.text = seance.description
        enseignantView.text= enseignants[seance.enseignantIndex].nom
        dateView.text = seance.date
        dureeView.text = seance.duree.toString()

        enseignantView.setOnClickListener(){

            intent = Intent(this, EnseignantDetailActivity::class.java)
            intent.putExtra(
                "nom",
                enseignants[seance.enseignantIndex].nom
            )

            intent.putExtra(
                "grade",
                enseignants[seance.enseignantIndex].grade
            )


            intent.putExtra(
                "ens",
                enseignants[seance.enseignantIndex].enseignements
            )


            startActivity(intent)


        }


    }


}