

package listener

import java.awt.event.ItemListener
import java.awt.event.ItemEvent
import panels.InfoPanel
import menue.ProfilMenue

class ErgaenzungProfilListener(private var creditPoints: Double) extends ItemListener {

  override def itemStateChanged(e: ItemEvent): Unit = {
    val selected = e.getStateChange() equals ItemEvent.SELECTED

    if (selected) {
      ProfilMenue.ergaenungCreditPoints += creditPoints
    } else {
      ProfilMenue.ergaenungCreditPoints -= creditPoints
    }

    InfoPanel.load
  }
}