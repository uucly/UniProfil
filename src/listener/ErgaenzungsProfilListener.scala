

package listener

import java.awt.event.ItemListener
import java.awt.event.ItemEvent
import panels.InfoPanel
import menue.Menue

class ErgaenzungProfilListener(private var creditPoints: Double) extends ItemListener {

  override def itemStateChanged(e: ItemEvent): Unit = {
    val selected = e.getStateChange() equals ItemEvent.SELECTED

    if (selected) {
      Menue.ergaenungCreditPoints += creditPoints
    } else {
      Menue.ergaenungCreditPoints -= creditPoints
    }

    InfoPanel.load
  }
}