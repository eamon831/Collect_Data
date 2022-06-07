package Database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) :AndroidViewModel(application) {
     val reaAllData:LiveData<List<Model>>
    private val repository: ModelRepository

    init {
        val modeldao=ModelDataBase.getdtabse(application).modeldao()
        repository= ModelRepository(modeldao)
        reaAllData=repository.reaAllData

    }
    fun addModel(model: Model){
        viewModelScope.launch (Dispatchers.IO){
            repository.addModel(model)
        }

    }
}