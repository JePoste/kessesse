package degregorio.enzo.kcc.data

data class ApiRequestObjectWrapper(
    var requests: Array<ApiRequestObject>
)

data class ApiRequestObject(
    var image: ApiRequestImageObject,
    var features: Array<ApiRequestFeatureObject>
)
data class ApiRequestImageObject(
    var content: String
)

data class ApiRequestFeatureObject(
    var type: String = "LABEL_DETECTION",
    var maxResults: Int = 3
)