package data.source

internal class SessionDataSourceImpl : SessionDataSource {
    private var authorization: String? = null
    override suspend fun setAuthorization(value: String) {
        authorization = value
    }

    override suspend fun getAuthorization(): String = authorization.orEmpty()
}