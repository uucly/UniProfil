
package listener

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import panels.RightPanel
import panels.InfoPanel
import panels.LeftPanel

class ClearButtonListener extends MouseAdapter {

  override def mouseClicked(evt: MouseEvent) = {

    try {
      RightPanel.load()
      LeftPanel.load()
      RightPanel.getProfil.resetPoints
      LeftPanel.getProfil.resetPoints

    } catch {
      case ex: Exception => //nothing
    }

    InfoPanel.load
  }
}