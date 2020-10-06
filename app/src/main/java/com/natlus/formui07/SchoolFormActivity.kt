package com.natlus.formui07

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.natlus.formui07.DataParcelize.ParentParcelize
import com.natlus.formui07.DataParcelize.PribadiParcelize
import com.natlus.formui07.DataParcelize.SchoolParcelize

class SchoolFormActivity : AppCompatActivity() {
    private val DATA_PARENT = "DATA_PARENT"
    private val DATA_SCHOOL = "DATA_SCHOOL"

    private lateinit var editTextUnivAsal: EditText
    private lateinit var editTextFakultasAsal: EditText
    private lateinit var editTextProdiAsal: EditText
    private lateinit var spinnerProvinsiUnivAsal: Spinner
    private lateinit var spinnerKotaUnivAsal: Spinner
    private lateinit var editTextAlamatUnivAsal: EditText
    private lateinit var editTextKodePos: EditText
    private lateinit var editTextAkreditasiUnivAsal: EditText
    private lateinit var editTextNilaiIPK: EditText
    private lateinit var btnGoToResult: Button

    private lateinit var dataProvinsi: Array<String>
    private lateinit var dataKota: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_form)

        setUp()
        loadDataSpinner()

        btnGoToResult.setOnClickListener {
            intentToResult()
        }
    }

    private fun setUp() {
        editTextUnivAsal = findViewById(R.id.editTextUnivAsal)
        editTextFakultasAsal = findViewById(R.id.editTextFakultasAsal)
        editTextProdiAsal = findViewById(R.id.editTextProdiAsal)
        spinnerProvinsiUnivAsal = findViewById(R.id.spinnerProvinsiUnivAsal)
        spinnerKotaUnivAsal = findViewById(R.id.spinnerKotaUnivAsal)
        editTextAlamatUnivAsal = findViewById(R.id.editTextAlamatUnivAsal)
        editTextKodePos = findViewById(R.id.editTextKodePos)
        editTextAkreditasiUnivAsal = findViewById(R.id.editTextAkreditasiUnivAsal)
        editTextNilaiIPK = findViewById(R.id.editTextNilaiIPK)
        btnGoToResult = findViewById(R.id.btnGoToResult)

        dataProvinsi = resources.getStringArray(R.array.dataProvinsi)
        dataKota = resources.getStringArray(R.array.dataKota)
    }

    private fun loadDataSpinner() {
        val adapterProvinsi = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataProvinsi)
        val adapterKota = ArrayAdapter(this, android.R.layout.simple_spinner_item, dataKota)

        adapterProvinsi.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterKota.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerProvinsiUnivAsal.adapter = adapterProvinsi
        spinnerKotaUnivAsal.adapter = adapterKota
    }

    private fun intentToResult() {
        val dataSchool = SchoolParcelize(
            namaUnivAsal = editTextUnivAsal.text.toString(),
            namaFakultasAsal = editTextFakultasAsal.text.toString(),
            namaProdiAsal = editTextProdiAsal.text.toString(),
            provinsiUnivAsal = spinnerProvinsiUnivAsal.selectedItem.toString(),
            kotaUnivAsal = spinnerKotaUnivAsal.selectedItem.toString(),
            alamatUnivAsal = editTextAlamatUnivAsal.text.toString(),
            kodePosUnivAsal = editTextKodePos.text.toString(),
            akreditasiUnivAsal = editTextAkreditasiUnivAsal.text.toString(),
            nilaiIPK = editTextNilaiIPK.text.toString(),
            dataParent = intent.getParcelableExtra<ParentParcelize>(DATA_PARENT)!!
        )

        val resultIntent = Intent(this, ResultFormActivity::class.java)
        resultIntent.putExtra(DATA_SCHOOL, dataSchool)
        startActivity(resultIntent)
    }
}