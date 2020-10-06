package com.natlus.formui07

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.natlus.formui07.DataParcelize.ParentParcelize
import com.natlus.formui07.DataParcelize.PribadiParcelize

class ParentFormActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"
    private val DATA_PARENT = "DATA_PARENT"

    private lateinit var editTextNamaAyah: EditText
    private lateinit var editTextNikAyah: EditText
    private lateinit var editTextNamaIbu: EditText
    private lateinit var editTextNikIbu: EditText
    private lateinit var editTextLahirAyah: EditText
    private lateinit var editTextLahirIbu: EditText
    private lateinit var editTextAlamat: EditText
    private lateinit var editTextPhone: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPendidikanAyah: EditText
    private lateinit var editTextPendidikanIbu: EditText
    private lateinit var editTextPekerjaanAyah: EditText
    private lateinit var editTextPekerjaanIbu: EditText
    private lateinit var btnParenttoSchool: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_form)

        setUp()

        btnParenttoSchool.setOnClickListener {
            intentToSchool()
        }
    }

    private fun setUp() {
        editTextNamaAyah = findViewById(R.id.editTextNamaAyah)
        editTextNikAyah = findViewById(R.id.editTextNikAyah)
        editTextNamaIbu = findViewById(R.id.editTextNamaIbu)
        editTextNikIbu = findViewById(R.id.editTextNikIbu)
        editTextLahirAyah = findViewById(R.id.editTextLahirAyah)
        editTextLahirIbu = findViewById(R.id.editTextLahirIbu)
        editTextAlamat = findViewById(R.id.editTextAlamat)
        editTextPhone = findViewById(R.id.editTextPhone)
        editTextEmail = findViewById(R.id.editTextEmail)
        editTextPendidikanAyah = findViewById(R.id.editTextPendidikanAyah)
        editTextPendidikanIbu = findViewById(R.id.editTextPendidikanIbu)
        editTextPekerjaanAyah = findViewById(R.id.editTextPekerjaanAyah)
        editTextPekerjaanIbu = findViewById(R.id.editTextPekerjaanIbu)
        btnParenttoSchool = findViewById(R.id.btnParenttoSchool)

        val dataPribadi = intent.getParcelableExtra<PribadiParcelize>(DATA_PRIBADI)!!
        Log.e(DATA_PRIBADI, dataPribadi.toString())
    }

    private fun intentToSchool() {
        val dataParent = ParentParcelize(
            namaAyah = editTextNamaAyah.text.toString(),
            nikAyah = editTextNikAyah.text.toString(),
            namaIbu = editTextNamaIbu.text.toString(),
            nikIbu = editTextNikIbu.text.toString(),
            tanggalLahirAyah = editTextLahirAyah.text.toString(),
            tanggalLahirIbu = editTextLahirIbu.text.toString(),
            alamatParent = editTextAlamat.text.toString(),
            phoneOrtu = editTextPhone.text.toString(),
            pendidikanAyah = editTextPendidikanAyah.text.toString(),
            pendidikanIbu = editTextPendidikanIbu.text.toString(),
            pekerjaanAyah = editTextPekerjaanAyah.text.toString(),
            pekerjaanIbu = editTextPekerjaanIbu.text.toString(),
            dataPribadi = intent.getParcelableExtra<PribadiParcelize>(DATA_PRIBADI)!!
        )

        val resultIntent = Intent(this, SchoolFormActivity::class.java)
        resultIntent.putExtra(DATA_PARENT, dataParent)
        startActivity(resultIntent)
    }
}