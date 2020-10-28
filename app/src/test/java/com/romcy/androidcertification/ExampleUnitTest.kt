package com.romcy.androidcertification

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

    var numberOfPlayers = 0
    private lateinit var newArray: IntArray
    var list = listOf<Int>()
    private var levelsOfWinner: Int = 0

    fun numPlayers(k: Int, scores: Array<Int>): Int {
        var allDifferent: Int = 0
        val mapValues = scores.groupBy { it }
            .mapValues { it.value.count() }.toSortedMap()
        mapValues.forEach { (key, value) ->
            if (value == 1) {
                allDifferent += 1
            }
        }

        return when {
            allDifferent == scores.size -> k
            scores.size - allDifferent == 2 -> {
                scores.size
            }
            scores.size - allDifferent == 3 -> {
                k + 1
            }
            else -> {
                0
            }
        }
    }

}