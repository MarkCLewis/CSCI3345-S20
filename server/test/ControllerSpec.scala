import org.scalatestplus.play._
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._
import controllers.Application

class ControllerSpec extends PlaySpec {
  "Application#index" must {
    "be valid" in {
      val controller = new Application(Helpers.stubControllerComponents())
      val result = controller.index.apply(FakeRequest())
      val bodyText = contentAsString(result)
      bodyText must include ("Play and Scala.js")
    }
  }
}