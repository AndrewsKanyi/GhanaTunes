package com.andrews.ghanatunes.data.services

import android.util.Log
import com.andrews.ghanatunes.domain.model.RadioModel
import com.andrews.ghanatunes.repositories.IRadioService
import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.nodes.Node
import org.jsoup.nodes.TextNode
import org.jsoup.select.Elements
import java.net.URL
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.math.log

class RadioServiceImpl @Inject constructor(
    val client: OkHttpClient
) : IRadioService {
    val TAG: String = "RadioServiceImpl"
    val radiosFromService: Flow<List<RadioModel>> = flow {

        emit(listOf<RadioModel>())
    }.flowOn(Dispatchers.Default)

    override suspend fun loadRadios(): MutableList<RadioModel> {

        return withContext(Dispatchers.IO) {
            var returnRadios:Collection<RadioModel> = emptyList()
            val request =
                Request.Builder().url("https://streema.com/radios/country/Ghana").build()

            try {
                val document: Document =
                    Jsoup.connect("https://streema.com/radios/country/Ghana").get()
                val resultRadios: Elements = document.select(".item")
                resultRadios.forEach{ it ->
                    val imageSource:String? = it.select("img").first()?.attr("src")
                    val actualRadioName:String? = (it.select("div.item-name > h5 > a").first()?.childNodes()?.first() as TextNode).toString().trim()
                    val currentRadioName: String = actualRadioName.toString().trim()
                    val radioLink:String = "https://streema.com"+it.select("div.item-name > h5 > a").attr("href")

                    returnRadios +=RadioModel(currentRadioName,radioLink, "")
                }

                Log.d(TAG, "loadRadios: ${returnRadios.size}")
            } catch (e: Exception) {
                Log.d(TAG, "loadRadios: Exception happened here")
            }

            mutableListOf<RadioModel>()
        }
    }
}


