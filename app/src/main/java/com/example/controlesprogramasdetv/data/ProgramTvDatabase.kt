package com.example.controlesprogramasdetv.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.controlesprogramasdetv.model.ProgramaTv


@Database(entities = [ProgramaTv::class], version = 1, exportSchema = false)
abstract class ProgramTvDatabase: RoomDatabase(){

    abstract fun programtvDao(): ProgramTvDao

    companion object{
        @Volatile
        private var INSTANCE: ProgramTvDatabase? = null

        fun getDatabase(context: Context): ProgramTvDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProgramTvDatabase::class.java,
                    "programtv_database"
                ).build()
                INSTANCE = instance
                return  instance
            }


        }
    }
}