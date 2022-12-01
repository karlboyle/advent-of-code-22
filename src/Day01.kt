import java.io.File

fun main() {
    fun parseInput(input: String): List<List<Int>> {
        val data = input.split("\n\n").map { elf ->
            elf.lines().map { it.toInt() }
        }
        return data
    }

    fun List<List<Int>>.topNElves(n: Int): Int {
        return map { it.sum() }
            .sortedDescending()
            .take(n)
            .sum()
    }

    fun part1(input: String): Int {
        val data = parseInput(input)
        return data.topNElves(1)
    }

    fun part2(input: String): Int {
        val data = parseInput(input)
        return data.topNElves(3)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = File("src/Day01_test.txt").readText()
    check(part1(testInput) == 24000)

    val input = File("src/Day01.txt").readText()
    println(part1(input))
    println(part2(input))
}
