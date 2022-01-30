package com.example.controlesprogramasdetv.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.controlesprogramasdetv.model.ProgramaTv


@Dao
interface ProgramTvDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
   /* suspend*/ fun addProgramTv(programtv : ProgramaTv)

    @Query(value = "SELECT * FROM program_Tv ORDER BY id DESC")
    fun readAllData(): LiveData<List<ProgramaTv>>

    @Query(value = "SELECT * FROM program_Tv WHERE :id = id")
    fun selectFindById(id:Long): LiveData<ProgramaTv>

    @Update
    fun updateProgramTv(programtv: ProgramaTv)

    @Query(value = "DELETE  FROM program_tv Where :id = id")
    fun deleteProgramaById(id: Long)

    @Query(value = "DELETE FROM program_Tv")
    fun deleteAll()
}