package controllers

import javax.inject._

import edu.trinity.videoquizreact.shared.SharedMessages
import play.api.mvc._

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index("<b>Testing</b>"))//SharedMessages.itWorks))
  }

  def tempPage = Action {
    Ok(views.html.tempPage(models.TempModel.data.map(_.year).distinct))
  }
  
  def temps(month: Int, year: Int) = Action {
    Ok(views.html.tempMonth(month, year, models.TempModel.data.
      filter(td => td.year == year && td.month == month)))
  }
}
