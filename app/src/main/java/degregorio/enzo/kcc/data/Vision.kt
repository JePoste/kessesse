package degregorio.enzo.kcc.data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

data class Vision(
    var mid: String,
    var description: String,
    var score: Float
)

data class ResponseWrapper(
    val labelAnnotations: Array<Vision>

)

data class VisionApiResponse(
    val responses: Array<ResponseWrapper>
)

interface VisionApi{
    @POST("/v1/images:annotate")
    fun getVision(@Body requestObject: ApiRequestObjectWrapper): Deferred<Response<VisionApiResponse>>
}