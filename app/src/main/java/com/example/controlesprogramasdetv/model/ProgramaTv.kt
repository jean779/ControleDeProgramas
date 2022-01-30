package com.example.controlesprogramasdetv.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "program_Tv")
data class ProgramaTv (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val nameProgram: String,
    val synopsis: String,
    val ageGroup: Int,
    val host: String,
    val time: String,
    val broadcaster: String
)