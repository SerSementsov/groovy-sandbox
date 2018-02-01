package powersoftwo

import java.util.stream.Collectors

class Main {

    static void main(String[] args) {
        println getPowersOfTwo_JavaStyle(10)
        println getPowersOfTwo_Java8Style(10)
        println getPowersOfTwo_GroovyStyle(10)
    }

    static List<Integer> getPowersOfTwo_JavaStyle(int n) {
        def powers = new ArrayList<Integer>()

        for (int i = 0; i < n; i++) {
            powers.add(Math.pow(2, i) as Integer)
        }
        return powers
    }


    static List<Integer> getPowersOfTwo_Java8Style(int n) {
        return (0..<n).stream()
                .map { 2**it }
                .collect(Collectors.toList())
    }

    static List<Integer> getPowersOfTwo_GroovyStyle(int n) {
        return (0..<n).collect { 2**it }
    }
}
