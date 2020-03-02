import org.scalatestplus.play._

class TempModelSpec extends PlaySpec {
  "TempDataModel" must {
    "have years 1946 to 2014" in {
      models.TempModel.yearRange(0, 3000).map(_.year).toSet mustBe ((1946 to 2014).toSet)
    }
    
    "give the right month" in {
      models.TempModel.monthOfData(5, 2001).forall(td => td.month == 5 && td.year == 2001) mustBe true
    }
  }
}