package com.example.controlesprogramasdetv.repository

import androidx.lifecycle.LiveData
import com.example.controlesprogramasdetv.data.ProgramTvDao
import com.example.controlesprogramasdetv.model.ProgramaTv


class ProgramTvRepository(private val programTvdao: ProgramTvDao){

    val readAllData: LiveData<List<ProgramaTv>> = programTvdao.readAllData()

    suspend fun insertProgram(programtv: ProgramaTv){
        programTvdao.addProgramTv(programtv)
    }

    fun selectProgramfindByID(id: Long):LiveData<ProgramaTv>{
        return programTvdao.selectFindById(id)
    }

    fun updateProgramTv(programtv: ProgramaTv){
       programTvdao.updateProgramTv(programtv)
    }

    fun deletePrograma(id: Long){
        programTvdao.deleteProgramaById(id)
    }

    fun deleteall(){
        programTvdao.deleteAll()
    }

}