package com.example.controlesprogramasdetv.fragments.update

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.controlesprogramasdetv.data.ProgramTvDatabase
import com.example.controlesprogramasdetv.model.ProgramaTv
import com.example.controlesprogramasdetv.repository.ProgramTvRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateViewModel (application : Application): AndroidViewModel(application) {
    private val repository: ProgramTvRepository

    init {
        val programDao = ProgramTvDatabase.getDatabase(application).programtvDao()
        repository = ProgramTvRepository(programDao)
    }

    fun selectProgramTvbyId(id: Long): LiveData<ProgramaTv> {
        return repository.selectProgramfindByID(id)
    }

    fun updateProgramTv(programaTv: ProgramaTv){
        viewModelScope.launch(Dispatchers.IO){ repository.updateProgramTv(programaTv)  }
    }
    fun deleteProgram(id: Long){
        viewModelScope.launch(Dispatchers.IO){ repository.deletePrograma(id)  }
    }

}