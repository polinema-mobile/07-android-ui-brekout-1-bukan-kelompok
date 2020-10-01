package com.natlus.formui07

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.natlus.formui07.DataParcelize.PribadiParcelize

class ParentFormActivity : AppCompatActivity() {
    private val DATA_PRIBADI = "DATA_PRIBADI"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_form)

        getDataPribadi()
    }

    private fun getDataPribadi() {
        val dataPribadi = intent.getParcelableExtra<PribadiParcelize>(DATA_PRIBADI)
        Log.e(DATA_PRIBADI, dataPribadi.toString())
    }
}