package csci3345

import slinky.core.annotations.react
import slinky.core._
import slinky.core.facade.ReactElement
import slinky.web.html._

@react class TopComponent extends Component {
  case class Props(msg: String)
  case class State(display: Int)

  def initialState: State = State(0)

  def render(): ReactElement = {
    state.display match {
      case 0 =>
        div (
          h1 (props.msg),
          button ("Screen 1", onClick := (e => setState(state.copy(display = 1)))),
          button ("Screen 2", onClick := (e => setState(state.copy(display = 2))))
        )
      case 1 => Screen1Component("Screen 1", () => setState(state.copy(display = 0)))
      case 2 => Screen2Component("Screen 2", () => setState(state.copy(display = 0)))
    }
  }
}