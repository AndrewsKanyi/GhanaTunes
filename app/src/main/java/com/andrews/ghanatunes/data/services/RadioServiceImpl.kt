package com.andrews.ghanatunes.data.services

import com.andrews.ghanatunes.domain.model.RadioModel
import com.andrews.ghanatunes.repositories.IRadioService
import okhttp3.OkHttpClient
import okhttp3.Request
import java.net.URL
import javax.inject.Inject


class RadioServiceImpl @Inject constructor (
    val client: OkHttpClient
) : IRadioService{
    override fun loadRadios(): Collection<RadioModel> {
        val request: Request = Request.Builder().url("https://streema.com/radios/country/Ghana").build()
        client.newCall(request).execute().use{
            response ->
            if(response.isRedirect) throw Exception("Ciao Mondo")
        }
        return listOf<RadioModel>()
    }

}