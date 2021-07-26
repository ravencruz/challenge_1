package challenge.amazon

class Schedule {

    fun removeLongest(arrivals: IntArray, duration: IntArray): MutableList<Pair<Int, Int>> {

        val res = mutableListOf< Pair<Int, Int> >()
        val duplicatesIndices = mutableListOf<Int>()

        arrivals.forEachIndexed { index, arrival ->
            println("index: $index, arrival: $arrival")

            if (index !in duplicatesIndices) {

                // has duplicates?
                val acc = mutableListOf< Pair<Int, Int> >()
                val duplicated = arrivals.foldIndexed(acc) { innerIndex, acc, elem ->
                    if (innerIndex > index && elem == arrival) {
                        acc.add(Pair(innerIndex, elem))
                    }
                    acc
                }

                // has duplicates?
                if (duplicated.isEmpty()) {
                    res.add(Pair(arrivals[index], duration[index]))
                } else {
                    println("duplicate of $index : $duplicated")

                    // quien tiene la menor duracion ?
                    var indexLessDuration = index
                    duplicated.forEach { duple ->
                        if (duration[indexLessDuration] > duration[duple.first]) {
                            indexLessDuration = duple.first
                        }
                    }

                    println("index less duration: $indexLessDuration")
                    res.add(Pair(arrivals[indexLessDuration], duration[indexLessDuration]))

                    // agregar los indices que no son mayores que mi indice actual en la lista de no revisar
                    if (indexLessDuration > index) {
                        duplicatesIndices.add(indexLessDuration)
                    }
                    duplicated.forEach { (dupIndex, _) ->
                        if (dupIndex > index && dupIndex != indexLessDuration) {
                            duplicatesIndices.add(dupIndex)
                        }
                    }
                }

            }





        }
        return res
    }

}