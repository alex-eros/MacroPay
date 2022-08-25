package alex.eros.macropay.presentation

import alex.eros.macropay.core.Resource
import alex.eros.macropay.data.UserDto
import alex.eros.macropay.repository.MacroRepository
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MacroViewModel(private val repo:MacroRepository):ViewModel(){

    fun getResponse(user:UserDto) = liveData(Dispatchers.IO) {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(repo.getResponse(user)))
        }catch (e:Exception){
            emit(Resource.Failure(e))
        }
    }
}

class MacroViewModelFactory(private val repo:MacroRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MacroRepository::class.java).newInstance(repo)
    }
}