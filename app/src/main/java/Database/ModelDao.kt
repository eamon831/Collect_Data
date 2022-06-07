package Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ModelDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addmodel(model: Model)

    @Query("SELECT * FROM model_table ORDER BY Id ASC")
    fun readAllData(): LiveData<List<Model>>

}