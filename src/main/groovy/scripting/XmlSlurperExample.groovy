package scripting

class XmlSlurperExample {

    static void main(String[] args) {
        String directoryPath = /C:\Users\sese0615\Documents\NC_Sources\TFNCAM_new\toms_common\scm/
        File[] files = getFiles(directoryPath)

        def slurper = new XmlSlurper()

        for (File file : files) {
            def xmlFile = slurper.parse(file)
            String pkg = xmlFile.@'package'
            if (pkg.contains("billingaiprovider")) {
                print xmlFile
            }
        }
    }
}
