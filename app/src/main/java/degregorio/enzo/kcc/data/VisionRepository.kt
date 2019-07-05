package degregorio.enzo.kcc.data

import android.util.Log
import degregorio.enzo.kcc.service.BaseRepository

class VisionRepository(private val api: VisionApi) : BaseRepository() {

    suspend fun getImageVision(imageString: String): List<Vision>? {

        var requestObject = ApiRequestObjectWrapper(
            arrayOf(
                ApiRequestObject(
                    ApiRequestImageObject(
                        imageString
                    ),
                    arrayOf(
                        ApiRequestFeatureObject()
                    )
                )
            )
        )
        val visionResponse = safeApiCall(
            call = { api.getVision(requestObject).await() },
            errorMessage = "Error Fetching Vision"
        )

        return visionResponse?.responses?.get(0)?.labelAnnotations?.toList() ?: listOf(Vision("No match found", "No match found", 1.toFloat()))
    }

}