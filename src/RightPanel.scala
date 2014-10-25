
import java.awt.Component
import javax.swing.BoxLayout

object RightPanel extends TBlaPanel {
  
  name = "RightPanel"

  def clearAll = {
    _profil = null
    removeAll()
    repaint()
  }
  
}