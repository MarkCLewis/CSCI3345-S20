package csci3345

import slinky.core._
import slinky.core.facade.ReactElement
import slinky.web.html._
import slinky.core.annotations.react

@react class Screen1Component extends Component {
  case class Props(msg: String, goBack: () => Unit)
  case class State(text: String)

  def initialState: State = State("")

  def render(): ReactElement = {
    div (
      props.msg,
      br (),
      input (value := state.text, onChange := (e => setState(state.copy(text = e.target.value)))),
      br (),
      button ("Return", onClick := (e => props.goBack()))
    )
  }
}