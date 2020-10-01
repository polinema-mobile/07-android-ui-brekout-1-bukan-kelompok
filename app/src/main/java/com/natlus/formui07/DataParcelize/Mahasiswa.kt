package com.natlus.formui07.DataParcelize

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mahasiswa(
    var nama: String,
    var nim: Int,
    var date: String,
    var gender: String,
    var jurusan: String
) : Parcelable