package scripting

import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathFactory

class XPathExample {
    static void main(String[] args) {

        def testxml = '''
    <records>
      <car name="HSV Maloo" make="Holden" year="2006">
        <country>Australia</country>
        <record type="speed">Production Pickup Truck with speed of 271kph</record>
        <flags>
            <first_flag/>
            <second_flag/>
            <third_flag/>
        </flags>
      </car>
    </records>
  '''
//        println processXml(testxml, '//car/record/@type')
//        println processXml(testxml, '//car/country')
//        println processXml(testxml, '//car/@year')
        def xml = processXml(testxml, '//car/flags/first_flag')
        println xml

    }

    def static processXml(String xml, String xpathQuery) {
        def xpath = XPathFactory.newInstance().newXPath()
        def builder = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        def inputStream = new ByteArrayInputStream(xml.bytes)
        def records = builder.parse(inputStream).documentElement
        xpath.evaluate(xpathQuery, records)
    }
}