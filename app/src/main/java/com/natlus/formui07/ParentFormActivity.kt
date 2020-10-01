package com.natlus.formui07

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.natlus.formui07.DataParcelize.ParentParcelize
import com.natlus.formui07.DataParcelize.PribadiParcelize

class ParentFormActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"

    private lateinit var namaAyah: String
    private var nikAyah: Int = 0
    private lateinit var namaIbu: String
    private var nikIbu: Int = 0
    private lateinit var tanggalLahirAyah: String
    private lateinit var tanggalLahirIbu: String
    private lateinit var alamatParent: String
    private lateinit var kodePos: String
    private lateinit var phoneOrtu: String
    private lateinit var pendidikanAyah: String
    private lateinit var pendidikanIbu: String
    private lateinit var pekerjaanAyah: String
    private lateinit var pekerjaanIbu: String
    private lateinit var dataPribadi: PribadiParcelize

    private lateinit var btnParenttoSchool: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_form)

        setUp()
        getDataPribadi()

        btnParenttoSchool.setOnClickListener {
            intentToSchool()
        }
    }

    private fun setUp() {
        btnParenttoSchool = findViewById(R.id.btnParenttoSchool)
    }

    private fun getDataPribadi() {
        val dataPribadi = intent.getParcelableExtra<PribadiParcelize>(DATA_PRIBADI)
        Log.e(DATA_PRIBADI, dataPribadi.toString())
    }

    private fun intentToSchool() {
        val dataParent = ParentParcelize(
            namaAyah,
            nikAyah,
            namaIbu,
            nikIbu,
            tanggalLahirAyah,
            tanggalLahirIbu,
            alamatParent,
            kodePos,
            phoneOrtu,
            pendidikanAyah,
            pendidikanIbu,
            pekerjaanAyah,
            pekerjaanIbu,
            dataPribadi
        )

        val resultIntent = Intent(this, SchoolFormActivity::class.java)
        resultIntent.putExtra(DATA_PARENT, dataParent)
        startActivity(resultIntent)
    }
}