package data.source

internal interface SessionDataSource {
    suspend fun setAuthorization(value: String)
    suspend fun getAuthorization() : String
}