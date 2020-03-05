package exampleThreads

import allmodels.examples.DuplicateWithThreadsClass
import allmodels.examples.GlobalVariables

object DuplicateExampleWithThreads {
    fun duplicateExampleWithThreads() {
        val startTime = System.currentTimeMillis()
        val threads = ArrayList<DuplicateWithThreadsClass>()


        for (index in 0 until GlobalVariables.T) {
            threads.add(
                index, DuplicateWithThreadsClass(
                    index * (GlobalVariables.N / GlobalVariables.T),
                    (index + 1) * (GlobalVariables.N / GlobalVariables.T)
                )
            )
        }

        val threadsStartTime = System.currentTimeMillis()
        for (thread in threads) {
            thread.start()
        }

        for (thread in threads) {
            try {
                thread.join()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

        }
        println()
        println("DUPLICATE WITH THREADS: TOTAL TIME: ${System.currentTimeMillis() - startTime}, CALCULATIONS TIME: ${System.currentTimeMillis() - threadsStartTime}")

    }
}
