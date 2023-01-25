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
import org.jsoup.select.Elements
import java.net.URL
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext
import kotlin.math.log

class RadioServiceImpl @Inject constructor(
    val client: OkHttpClient
) : IRadioService {
    val TAG: String = "RadioServiceImp"
    val radiosFromService: Flow<List<RadioModel>> = flow {

        emit(listOf<RadioModel>())
    }.flowOn(Dispatchers.Default)

    override suspend fun loadRadios(): List<RadioModel> {
        Log.d(TAG, "loadRadios: Here 3")
        Log.d(TAG, "loadRadios: Here1")
        return withContext(Dispatchers.IO) {
            val request =
                Request.Builder().url("https://streema.com/radios/country/Ghana").build()


            try {
                val document: Document =
                    Jsoup.connect("https://streema.com/radios/country/Ghana").get()
                val resultingJson: Elements = document.select(".item")

                val nodesList: List<Node> = document.childNodes()
                val nodeConunt: Int = resultingJson.size

            } catch (e: Exception) {
                Log.d(TAG, "loadRadios: Exception happened here")
            }

            mutableListOf<RadioModel>()
        }
    }
}


