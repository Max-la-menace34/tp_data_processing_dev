
import com.github.polomarcus.utils.ClimateService
import com.github.polomarcus.model.CO2Record
import org.scalatest.funsuite.AnyFunSuite

//@See https://www.scalatest.org/scaladoc/3.1.2/org/scalatest/funsuite/AnyFunSuite.html
class ClimateServiceTest extends AnyFunSuite {
  test("containsWordGlobalWarming - non climate related words should return false") {
    assert(!ClimateService.isClimateRelated("pizza"))
  }

  test("isClimateRelated - climate related words should return true") {
    assert(ClimateService.isClimateRelated("climate change"))
    assert(ClimateService.isClimateRelated("IPCC"))
  }

  //@TODO
  test("parseRawData") {
<<<<<<< HEAD:src/test/scala/ClimateServiceTest.scala
    val list1 = List((2003, 1, 355.2), (2004, 1, 375.2))
    val output = List(Some(CO2Record(2003, 1, 355.2)), Some(CO2Record(2004, 1, 375.2)))
=======
    val firstRecord = (2003, 1, 355.2)
    val secondRecord = (2004, 1, 375.2)
    val list1 = List(firstRecord, secondRecord)

    val co2RecordWithType = CO2Record(firstRecord._1, firstRecord._2, firstRecord._3)
    val co2RecordWithType2 = CO2Record(secondRecord._1, secondRecord._2, secondRecord._3)

    val output = List(Some(co2RecordWithType), Some(co2RecordWithType2))
>>>>>>> 1a0b0b03f788c9ad1a1a48792701b8f13ad3c1f6:tp-functional-programming-scala/src/test/scala/ClimateServiceTest.scala
    assert(ClimateService.parseRawData(list1) == output)
  }
  test("getMinMax"){
    val list2 =List(1,2,3,4,5)
    assert(ClimateService.getMinMax(list2) == (1,5))
  }
  //@TODO
  test("filterDecemberData") {
    assert(true == false)
  }
  
}
