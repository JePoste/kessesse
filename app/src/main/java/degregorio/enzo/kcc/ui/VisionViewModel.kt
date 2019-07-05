package degregorio.enzo.kcc.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import degregorio.enzo.kcc.data.Vision
import degregorio.enzo.kcc.data.VisionRepository
import degregorio.enzo.kcc.service.ApiFactory
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class VisionViewModel : ViewModel(){

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : VisionRepository = VisionRepository(ApiFactory.visionApi)


    val visionLiveData = MutableLiveData<List<Vision>>()

    fun fetchVisions(imageString: String){
        scope.launch {
            val visions = repository.getImageVision(imageString)
            visionLiveData.postValue(visions)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}