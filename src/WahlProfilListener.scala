

import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class WahlProfilListener(private var creditPoints: Double, private val profil: Profil) extends ItemListener {

  override def itemStateChanged(e: ItemEvent): Unit = {
    val selected = e.getStateChange() equals ItemEvent.SELECTED

    if (selected) {
      profil.wahlPoints += creditPoints
    } else {
      profil.wahlPoints -= creditPoints
    }

    InfoPanel.load
  }
}