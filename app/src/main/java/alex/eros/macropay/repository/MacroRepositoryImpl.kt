package alex.eros.macropay.repository

import alex.eros.macropay.data.Response
import alex.eros.macropay.data.UserDto
import alex.eros.macropay.data.remote.MacroDataSource

class MacroRepositoryImpl (private val datosource:MacroDataSource):MacroRepository {

    override suspend fun getResponse(user:UserDto): Response = datosource.getResponse(user)
}