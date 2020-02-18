package controllers

import javax.inject._

import edu.trinity.videoquizreact.shared.SharedMessages
import play.api.mvc._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action { implicit request =>
    Ok(views.html.index("<b>Testing</b>"))//SharedMessages.itWorks))
  }

  def tempPage = Action { implicit request =>
    Ok(views.html.tempPage(models.TempModel.data.map(_.year).distinct))
  }
  
  def temps(month: Int, year: Int) = Action { implicit request =>
    Ok(views.html.tempMonth(month, year, models.TempModel.data.
      filter(td => td.year == year && td.month == month)))
  }

  def tempsPost = Action.async { implicit request => Future {
    val oparams = request.body.asFormUrlEncoded
    oparams.map { params =>
      try {
        val month = params("month")(0).toInt
        val year = params("year")(0).toInt
        Ok(views.html.tempMonth(month, year, models.TempModel.data.
          filter(td => td.year == year && td.month == month)))
      } catch {
        case ex: NumberFormatException => Ok("NaN")
      }
    }.getOrElse(Ok("You screwed up.")) }
  }
}
