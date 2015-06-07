
package listener

import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import panels.InfoPanel
import panels.RightPanel
import panels.LeftPanel
import wahlPflicht.WahlPflichtManager

class ClearButtonListener extends MouseAdapter {

  override def mouseClicked(evt: MouseEvent) = {

    LeftPanel.buttons.foreach(b => { b.setEnabled(true); b.setSelected(false) })
    RightPanel.buttons.foreach(b => { b.setEnabled(true); b.setSelected(false) })
    LeftPanel.getProfil.resetPoints
    RightPanel.getProfil.resetPoints

    
    RightPanel.load
    LeftPanel.load
    InfoPanel.load
  }
}