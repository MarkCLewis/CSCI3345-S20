import org.scalatest._
import org.scalatestplus.play._
import play.api.http.MimeTypes
import play.api.test._
import org.scalatestplus.play.guice.GuiceOneServerPerSuite

class BrowserTempSpec extends PlaySpec with GuiceOneServerPerSuite with OneBrowserPerSuite with HtmlUnitFactory {
  "The TempApp" must {
    "display a month table" in {
      go to s"http://localhost:$port/tempPage"
      pageTitle mustBe "Historical Temperatures"
      click on "month"
      textField("month").value = "5"
      click on "year"
      textField("year").value = "1986"
      submit()
      eventually { pageTitle mustBe "Tempurature for 5/1986" }
    }
  }
}