package com.natlus.formui07

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mahasiswa(
    var nama: String,
    var nim: Int,
    var date: String,
    var gender: Char,
    var jurusan: String
) : Parcelable