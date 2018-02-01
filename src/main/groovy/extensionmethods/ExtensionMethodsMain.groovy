package extensionmethods

class ExtensionMethodsMain {

    static void main(String[] args) {
        String.metaClass.myFunction = {-> delegate.length()}

        println "123".myFunction()

    }
}
