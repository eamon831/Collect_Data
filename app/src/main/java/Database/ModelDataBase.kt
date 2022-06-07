package Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
@Database(entities = [Model::class],version = 1,exportSchema = false)
abstract  class ModelDataBase: RoomDatabase() {
    abstract fun modeldao():ModelDao
    companion object{
        @Volatile
        private var INSTANCE:ModelDataBase?=null

        fun getdtabse(context :Context):ModelDataBase{
            val tempinstance= INSTANCE
            if(tempinstance!=null){
                return tempinstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(context.applicationContext
                ,ModelDataBase::class.java,
                "Model_Database").build()
                INSTANCE=instance
                return instance
            }
        }
    }
}