package com.example.controlesprogramasdetv.fragments.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.controlesprogramasdetv.data.ProgramTvDatabase
import com.example.controlesprogramasdetv.repository.ProgramTvRepository
import com.example.controlesprogramasdetv.model.ProgramaTv
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddModelView(application: Application): AndroidViewModel(application) {
    private  val repository: ProgramTvRepository


    init {
        val programaTvDao = ProgramTvDatabase.getDatabase(application).programtvDao()
        repository = ProgramTvRepository(programaTvDao)
    }

    fun insertProgramTv(programtv : ProgramaTv){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertProgram(programtv)
        }
    }
}