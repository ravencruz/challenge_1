package challenge.amazon

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEqualIgnoringCase
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ScheduleTest: StringSpec({

    "length should return size of string" {
        val schedule = Schedule()
        val arrivals = intArrayOf(1, 3, 3, 5, 7)
        val duration = intArrayOf(2, 2, 1, 2, 1)
        val joinedTable = schedule.removeLongest(arrivals, duration)
        println("res: ${joinedTable.joinToString()}")
        joinedTable.size shouldBe 4

        val resArrivals = joinedTable.map { it.first }
        val resDurations = joinedTable.map { it.second }

        resArrivals.joinToString() shouldBeEqualIgnoringCase "1, 3, 5, 7"
        resDurations.joinToString() shouldBeEqualIgnoringCase "2, 1, 2, 1"
    }
})