package com.example.myedt

import android.os.Parcel
import android.os.Parcelable


data class Enseignant (
    var nom: String? ="",
    var grade: String? ="",
    var enseignements: String? ="",
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(grade)
        parcel.writeString(enseignements)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Enseignant> {
        override fun createFromParcel(parcel: Parcel): Enseignant {
            return Enseignant(parcel)
        }

        override fun newArray(size: Int): Array<Enseignant?> {
            return arrayOfNulls(size)
        }
    }

}