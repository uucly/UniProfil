
package listener

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import panels.RightPanel
import panels.InfoPanel
import panels.WahlPanel

class ClearButtonListener extends MouseAdapter {

  override def mouseClicked(evt: MouseEvent) = {

    try {
      RightPanel._profil.load(RightPanel)
      WahlPanel._profil.load(WahlPanel)
      RightPanel._profil.resetPoints
      WahlPanel._profil.resetPoints

    } catch {
      case ex: Exception => //nothing
    }

    InfoPanel.load
  }
}