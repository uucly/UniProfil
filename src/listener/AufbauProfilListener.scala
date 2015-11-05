

package listener

import java.awt.event.ItemListener
import java.awt.event.ItemEvent
import panels.InfoPanel
import menue.Menue

class AufbauProfilListener(private var creditPoints: Double) extends ItemListener {


  override def itemStateChanged(e: ItemEvent): Unit = {
    val selected = e.getStateChange() equals ItemEvent.SELECTED

    if (selected) {
      Menue.aufbauCreditPoints += creditPoints
    } else {
      Menue.aufbauCreditPoints -= creditPoints
    }

    InfoPanel.load
  }
}