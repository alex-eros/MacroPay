package alex.eros.macropay.repository

import alex.eros.macropay.application.AppConstants
import alex.eros.macropay.data.Response
import alex.eros.macropay.data.UserDto
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

interface Webservice  {

    @POST
    fun getResponse(user:UserDto):Response

}

object RetrofitClient{

    val webservice by lazy {

        Retrofit.Builder()
            .baseUrl(AppConstants.url)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(Webservice::class.java)
    }

}