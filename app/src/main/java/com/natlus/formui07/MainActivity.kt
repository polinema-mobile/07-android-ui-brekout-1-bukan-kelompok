package com.natlus.formui07

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val DATA_JENIS = "DATA_JENIS"
    private val DATA_MHS = "DATA_MHS"
    private val DATA_NAMA = "DATA_NAMA"
    private val DATA_NIM = "DATA_NIM"
    private val DATA_DATE = "DATA_DATE"
    private val DATA_KELAMIN = "DATA_KELAMIN"
    private val DATA_JURUSAN = "DATA_JURUSAN"
    private lateinit var nama: String
    private var nim: Int = 0
    private lateinit var dob: String
    private lateinit var kelamin: String
    private lateinit var jurusan: String
    private lateinit var btnIntent: Button
    private lateinit var btnParcelable: Button
    private lateinit var spinenrJurusan: Spinner
    private lateinit var radioGroupKelamin: RadioGroup
    private lateinit var radioButtonChecked: RadioButton
    private lateinit var editTextDate: EditText
    private lateinit var editTextNama: EditText
    private lateinit var editTextNim: EditText
    private var jurusanList = arrayOf(
        "Akutansi",
        "Teknik Informatika",
        "Teknik Mesin",
        "Teknik Sipil",
        "Manajemen Informatika"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUp()
        dataSpinner()
        datePicker()
        buttonListener()
    }

    private fun setUp() {
        btnIntent = findViewById(R.id.buttonIntent)
        btnParcelable = findViewById(R.id.buttonParcel)
        spinenrJurusan = findViewById(R.id.spinner)
        radioGroupKelamin = findViewById(R.id.radioGroup)
        editTextDate = findViewById(R.id.editTextDate)
        editTextNim = findViewById(R.id.editTextNIM)
        editTextNama = findViewById(R.id.editTextNama)
    }

    private fun datePicker() {
        editTextDate.setOnClickListener {
            val cal = Calendar.getInstance()
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(
                this,
                { view, year, monthOfYear, dayOfMonth ->
                    val bulan = monthOfYear + 1
                    editTextDate.setText("$dayOfMonth/$bulan/$year")
                },
                year,
                month,
                day
            )
            dpd.show()
        }
    }

    private fun radioButtonSelection(): String {
        val selected: Int = radioGroup!!.checkedRadioButtonId
        radioButtonChecked = findViewById(selected)
        return radioButtonChecked.text.toString()
    }

    private fun dataSpinner() {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, jurusanList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinenrJurusan.adapter = adapter
    }

    private fun buttonListener() {
        btnParcelable.setOnClickListener {
            getDataMhs()

            val dataMhs = Mahasiswa(nama, nim, dob, kelamin, jurusan)
            val resultIntent = Intent(this, ResultFormActivity::class.java)
            resultIntent.putExtra(DATA_JENIS, "Parcelable")
            resultIntent.putExtra(DATA_MHS, dataMhs)
            startActivity(resultIntent)
        }

        btnIntent.setOnClickListener {
            getDataMhs()

            val resultIntent = Intent(this, ResultFormActivity::class.java)
            resultIntent.putExtra(DATA_JENIS, "Intent")
            resultIntent.putExtra(DATA_NAMA, nama)
            resultIntent.putExtra(DATA_NIM, nim)
            resultIntent.putExtra(DATA_DATE, dob)
            resultIntent.putExtra(DATA_KELAMIN, kelamin)
            resultIntent.putExtra(DATA_JURUSAN, jurusan)
            startActivity(resultIntent)
        }
    }

    private fun getDataMhs() {
        nama = editTextNama.text.toString()
        nim = editTextNim.text.toString().toInt()
        dob = editTextDate.text.toString()
        kelamin = radioButtonSelection()
        jurusan = spinenrJurusan.selectedItem.toString()
    }
}