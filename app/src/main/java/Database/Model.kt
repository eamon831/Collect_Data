package Database

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "model_table")
data class Model(
    @PrimaryKey(autoGenerate = true)
    val Id:Int,
    val Name:String,
    val Education:String,
    val Age:String,
    val Number:String
)