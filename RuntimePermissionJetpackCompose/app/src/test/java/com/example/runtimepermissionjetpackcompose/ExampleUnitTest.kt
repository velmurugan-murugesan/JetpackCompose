package com.example.runtimepermissionjetpackcompose

import org.junit.Test

import org.junit.Assert.*

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
    fun yearTest() {
        val input = 1010
        var a = input/ 100
        println("a"+ a)
        val b = input% 100
        println("b"+ b)
        if (b > 0) {
            a += 1
        }
        println("result = " +a)

    }
}