package controllers

import javax.inject._

import play.api.mvc._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class ReactController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  def reactMain = Action { implicit request =>
    Ok(views.html.reactView())
  }
}