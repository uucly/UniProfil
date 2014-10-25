

import java.awt.event.ItemListener
import java.awt.event.ItemEvent

class AufbauProfilListener(private var creditPoints: Double) extends ItemListener {

  override def itemStateChanged(e: ItemEvent): Unit = {
    val selected = e.getStateChange() equals ItemEvent.SELECTED

    if (selected) {
      ProfilMenue.aufbauCreditPoints += creditPoints
    } else {
      ProfilMenue.aufbauCreditPoints -= creditPoints
    }

    InfoPanel.load
  }
}