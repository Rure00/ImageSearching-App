package com.project.imagesearchingapp

import com.project.imagesearchingapp.model.api.ImageSearchResponse
import com.project.imagesearchingapp.model.api.RetrofitClient
import com.project.imagesearchingapp.model.api.RetrofitService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import java.time.LocalDateTime

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun retrofit() = runTest {
        val service = RetrofitClient.getInstance().create(RetrofitService::class.java)
        var result: ImageSearchResponse

        launch {
            println("hi")
            result =  service.getImages( query = "아이브")
            println("hi2")
            println(result.toString())
        }
    }
}