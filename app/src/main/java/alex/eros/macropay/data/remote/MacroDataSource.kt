package alex.eros.macropay.data.remote

import alex.eros.macropay.data.Response
import alex.eros.macropay.data.UserDto
import alex.eros.macropay.repository.Webservice

class MacroDataSource (private val webservice: Webservice) {

    suspend fun getResponse(user: UserDto):Response{
        return webservice.getResponse(user)
    }
}