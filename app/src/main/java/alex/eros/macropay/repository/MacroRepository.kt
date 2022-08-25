package alex.eros.macropay.repository

import alex.eros.macropay.data.Response
import alex.eros.macropay.data.UserDto

interface MacroRepository {

    suspend fun getResponse(user:UserDto):Response

}