package Database

import androidx.lifecycle.LiveData

class ModelRepository(private  val modelDao: ModelDao) {
    val reaAllData:LiveData<List<Model>> =modelDao.readAllData()
    suspend fun addModel(model: Model){
        modelDao.addmodel(model)
    }
}