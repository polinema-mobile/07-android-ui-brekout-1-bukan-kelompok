package com.natlus.formui07

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.natlus.formui07.DataParcelize.PribadiParcelize

class ResultFormActivity : AppCompatActivity() {
    private val DATA_COMPLETE = "DATA_COMPLETE"
    private lateinit var textNama: TextView
    private lateinit var textNim: TextView
    private lateinit var textDob: TextView
    private lateinit var textKelamin: TextView
    private lateinit var textJurusan: TextView
    private lateinit var nama: String
    private lateinit var nim: String
    private lateinit var dob: String
    private lateinit var kelamin: String
    private lateinit var jurusan: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_form)

        setUp()
    }

    private fun setUp() {
        textNama = findViewById(R.id.namaValue)
        textNim = findViewById(R.id.nimValue)
        textDob = findViewById(R.id.tglValue)
        textKelamin = findViewById(R.id.jkValue)
        textJurusan = findViewById(R.id.jurusanValue)
    }

    private fun getData() {
        val dataPribadi = intent.getParcelableExtra<PribadiParcelize>(DATA_COMPLETE)
    }

    private fun setTextView() {
        textNama.text = nama
        textNim.text = nim
        textDob.text = dob
        textKelamin.text = kelamin
        textJurusan.text = jurusan
    }
}