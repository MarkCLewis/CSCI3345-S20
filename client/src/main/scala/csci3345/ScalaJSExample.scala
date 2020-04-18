package csci3345

import org.scalajs.dom

import slinky.core._
import slinky.web.ReactDOM
import slinky.web.html._
import org.scalajs.dom.document

object ScalaJSExample {

  def main(args: Array[String]): Unit = {
    if (document.getElementById("content") != null) {
      document.getElementById("content").innerHTML = "This is set in Scala.js"
    }
    // dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    println("Call the react stuff.")
    ReactDOM.render(
      TopComponent("Hello World!"),
      dom.document.getElementById("root")
    )

  }
}
