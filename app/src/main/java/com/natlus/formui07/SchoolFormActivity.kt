package com.natlus.formui07

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.natlus.formui07.DataParcelize.ParentParcelize
import com.natlus.formui07.DataParcelize.PribadiParcelize
import com.natlus.formui07.DataParcelize.SchoolParcelize

class SchoolFormActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"
    private val DATA_SCHOOL = "DATA_SCHOOL"

    private lateinit var namaUnivAsal: String
    private lateinit var namaFakultasAsal: String
    private lateinit var namaProdiAsal: String
    private lateinit var provinsiUnivAsal: String
    private lateinit var kotaUnivAsal: String
    private lateinit var alamatUnivAsal: String
    private lateinit var kodePosUnivAsal: String
    private lateinit var akreditasiUnivAsal: String
    private lateinit var nilaiIPK: String
    private lateinit var dataPribadi: PribadiParcelize
    private lateinit var dataParent: ParentParcelize

    private lateinit var btnGoToResult: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_form)

        setUp()

        btnGoToResult.setOnClickListener {
            intentToResult()
        }
    }

    private fun setUp() {
        btnGoToResult = findViewById(R.id.btnGoToResult)
    }

    private fun intentToResult() {
        val dataSchool = SchoolParcelize(
            namaUnivAsal,
            namaFakultasAsal,
            namaProdiAsal,
            provinsiUnivAsal,
            kotaUnivAsal,
            alamatUnivAsal,
            kodePosUnivAsal,
            akreditasiUnivAsal,
            nilaiIPK,
            dataPribadi,
            dataParent
        )

        val resultIntent = Intent(this, ResultFormActivity::class.java)
        resultIntent.putExtra(DATA_SCHOOL, dataSchool)
        startActivity(resultIntent)
    }
}