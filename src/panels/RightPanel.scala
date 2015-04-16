
package panels

object RightPanel extends TModulPanel {
  
  name = "RightPanel"

  def clearAll = {
    _profil = null
    removeAll()
    repaint()
  }
  
}