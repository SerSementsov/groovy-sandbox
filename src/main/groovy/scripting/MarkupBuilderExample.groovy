package scripting

import groovy.xml.MarkupBuilder

import java.time.LocalDateTime

class MarkupBuilderExample {

    static void main(String[] args) {
        args = new String[2]
        args[0] = "C:\\so_products.sql"
        args[1] = "attr_id"

        if (!(args.size() in (1..2))) {
            println "wrong number of arguments"
            println "please pass filename as 1st argument"
            println "and optionally word as 2nd argument"
            return
        }

        def content = new File(args[0]).text

        def symbolsCount = content.size()
        def wordsCount = content.split(/\W+/).size()
        def stringCount = content.count(args[1])

        println "Symbols count: ".padRight(15) + symbolsCount
        println "Words count : ".padRight(15) + wordsCount
        println "Word count: ".padRight(15) + stringCount
        println("---------------------------------------")


        def file = new File("1.xml")
        file.withWriter { Writer w ->
            def builder = new MarkupBuilder(w)
            builder.report {
                'file-name' args[0]
                'mandatory-params' {
                    'symbols-count' symbolsCount
                    'words-count' wordsCount
                    'current-date' LocalDateTime.now()
                }
                if (stringCount) {
                    'optional-params' {
                        string args[1]
                        occurrences stringCount
                    }
                }
            }
        }

        println file.text
    }
}