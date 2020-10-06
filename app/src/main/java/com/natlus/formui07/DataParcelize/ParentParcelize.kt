package com.natlus.formui07.DataParcelize

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ParentParcelize(
    var namaAyah: String,
    var nikAyah: String,
    var namaIbu: String,
    var nikIbu: String,
    var tanggalLahirAyah: String,
    var tanggalLahirIbu: String,
    var alamatParent: String,
    var phoneOrtu: String,
    var pendidikanAyah: String,
    var pendidikanIbu: String,
    var pekerjaanAyah: String,
    var pekerjaanIbu: String,
    var dataPribadi: PribadiParcelize
) : Parcelable