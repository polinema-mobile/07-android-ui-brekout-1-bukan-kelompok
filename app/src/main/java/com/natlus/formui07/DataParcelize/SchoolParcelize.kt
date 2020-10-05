package com.natlus.formui07.DataParcelize

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SchoolParcelize(
    var namaUnivAsal:String,
    var namaFakultasAsal:String,
    var namaProdiAsal:String,
    var provinsiUnivAsal:String,
    var kotaUnivAsal:String,
    var alamatUnivAsal:String,
    var kodePosUnivAsal:String,
    var akreditasiUnivAsal:String,
    var nilaiIPK:String,
    var dataParent: ParentParcelize
) : Parcelable