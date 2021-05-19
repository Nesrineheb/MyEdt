package com.example.myedt

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity(), View.OnClickListener{
    lateinit var seances: MutableList<Seance>

    lateinit var adapter: SeanceAdapter
    lateinit var enseignants: MutableList<Enseignant>


    lateinit var titreView: TextView

    lateinit var descriptionView: TextView
    lateinit var enseignantView: TextView
    lateinit var dateView: TextView
    lateinit var dureeView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//



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





// les seances
        seances =mutableListOf<Seance>()

        seances.add(Seance("AL", "A la fin de l’unité l’étudiant sera en mesure de : Souligner les importances des architectures et leur impact sur le produit final Définir la notion d'architecture et les points de vue architecturaux Identifier les enjeux des choix architecturaux Identifier les principaux styles architecturaux Concevoir une architecture à partir des attributs de qualité"
            ,"17/05/2020",0,1))
        seances.add(Seance("ALG1", "Consolider les acquis du secondaire concernant l’algèbre générale. Acquérir les techniques de décomposition des fractions rationnelles Exploiter les résultats obtenus pour l’étude des structures linéaires dans les unités algèbre2 et analyse2."
            ,"17/05/2020",1,2))
        seances.add(Seance("ALSDD", "Ce module aborde les aspects fondamentaux de la science informatique. Parmi les objectifs, nous pouvons citer :"
            ,"18/05/2020",2,1))
        seances.add(Seance("ANAD", "L’utilisation de l’analyse de données s’étend à des domaines très vastes, dont la reconnaissance de formes, Data mining, prédiction, marketing, biostatistique"
            ,"22/04/2020",3,2))
        seances.add(Seance("ANAL3", "Le thème central est le concept de fonction réelle à une variable réelle. Le programme est organisé autour de trois objectifs"
            ,"27/06/2020",4,1))
        seances.add(Seance("ANG1", "This is an ESP (English for Specific Purposes) course aimed at the improvement of the students’ language skills in the context of computing and information technology The course is focused on the four skills: listening and speaking, reading and writing in addition to a language focus aimed to cover key points of grammar."
            ,"14/06/2020",5,3))
        seances.add(Seance("ANUM", "L'analyse numérique est l'étude des méthodes permettant d'évaluer numériquement des nombres, des fonctions .... C’est un outil essentiel pour l'ingénieur. La modélisation de la majorité des situations réelles (le classement des pages web, le traitement d’images",
            "26/05/2020",6,2))
        seances.add(Seance("AQUA", "Appréhender l'intérêt de la démarche \"qualité \" dans le domaine des sciences et technologies, pour avoir soi-même confiance et inspirer confiance dans les actions engagées et les décisions prises pour l'analyse, la conception, la production et l’évaluation de processus et projets, particulièrement dans le contexte des processus IT et/ou projetsIT)."
            ,"12/05/2020",7,1))
        seances.add(Seance("ARCH", "Ce cours permet à l’étudiant de comprendre la relation entre la performance et la structure des différents composants fonctionnels d’un processeur. A l’issue de ce cours, l’étudiant comprendra comment l’architecture d’un processeur affecte la performance des programmes exécutés sur la machine. Le cours présente les techniques proposées"
            ,"9/05/2020",8,2))














            adapter= SeanceAdapter(seances, this)

            val recyclerView = findViewById(R.id.seances_recycler_view) as RecyclerView
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter








    }

    override fun onClick(view: View?) {



        if (view != null) {
            if (view.tag != null) {


                showDetailActivity(view.tag as Int)


            }
        }
    }


    fun showDetailActivity(seanceIndex: Int) {
        val seance =  seances[seanceIndex]


        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {

            val extras: Bundle = bundleOf()
            extras.putParcelable(DetailSeanceActivity.EXTRA_Seance,seance)

            val intent = Intent(this, DetailSeanceActivity::class.java)
            intent.putExtras(extras)
            startActivity(intent)
        }
        else{

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

                val intent = Intent(this, EnseignantDetailActivity::class.java)

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
}