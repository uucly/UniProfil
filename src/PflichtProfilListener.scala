

import java.awt.event.ItemEvent
import java.awt.event.ItemListener

class PflichtProfilListener(private var creditPoints: Double,private val profil:Profil) extends ItemListener {

  override def itemStateChanged(e: ItemEvent): Unit = {
    val selected = e.getStateChange() equals ItemEvent.SELECTED
    
    if (selected) {
      profil.pflichtPoints += creditPoints 
    } else {
      profil.pflichtPoints -=creditPoints 
    }

    InfoPanel.load
  }
}