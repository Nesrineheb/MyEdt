package com.example.myedt

import android.os.Parcel
import android.os.Parcelable

data class Seance(
    var titre: String? ="",
    var description: String? ="",
    var date: String? ="",
    var enseignantIndex: Int=0,
    var duree: Int =0 ): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titre)
        parcel.writeString(description)
        parcel.writeString(date)
        parcel.writeInt(enseignantIndex)
        parcel.writeInt(duree)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Seance> {
        override fun createFromParcel(parcel: Parcel): Seance {
            return Seance(parcel)
        }

        override fun newArray(size: Int): Array<Seance?> {
            return arrayOfNulls(size)
        }
    }


}