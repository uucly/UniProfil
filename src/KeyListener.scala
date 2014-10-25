

import java.awt.event.ItemListener
import java.awt.event.ItemEvent

class KeyListener(private var creditPoints: Double) extends ItemListener {

  override def itemStateChanged(e: ItemEvent): Unit = {
    val selected = e.getStateChange() equals ItemEvent.SELECTED

    if (selected) {
      ProfilMenue.keyCreditPoints += creditPoints
    } else {
      ProfilMenue.keyCreditPoints -= creditPoints
    }

    InfoPanel.load
  }
}