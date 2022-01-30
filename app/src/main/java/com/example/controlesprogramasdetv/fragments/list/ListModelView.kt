package com.example.controlesprogramasdetv.fragments.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.controlesprogramasdetv.data.ProgramTvDatabase
import com.example.controlesprogramasdetv.repository.ProgramTvRepository
import com.example.controlesprogramasdetv.model.ProgramaTv
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListModelView (application : Application): AndroidViewModel(application){
    private  val repository: ProgramTvRepository
    var selectProgram: LiveData<List<ProgramaTv>>

    init {
        val programDao = ProgramTvDatabase.getDatabase(application).programtvDao()
        repository =  ProgramTvRepository(programDao)
        selectProgram = repository.readAllData
    }

    fun deleteall(){
        viewModelScope.launch(Dispatchers.IO){ repository.deleteall()}
    }
}