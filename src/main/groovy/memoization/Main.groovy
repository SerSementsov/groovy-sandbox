package memoization

class Main {
    static void main(String[] args) {
        def memfib
        def fib = {
            if (it < 3) it
            else memfib(it - 1) + memfib(it - 2)
        }
        memfib = fib.memoize()

        def start1 = System.nanoTime()
        def res1 = fib(40)
        println("regular fib time : " + (System.nanoTime() - start1)) //84_697_394 ns on my machine
        def start2 = System.nanoTime()
        def res2 = memfib(40)
        println("memoized fib time : " + (System.nanoTime() - start2)) //161_411 ns on my machine

        println "results: "
        println res1
        println res2
    }
}

