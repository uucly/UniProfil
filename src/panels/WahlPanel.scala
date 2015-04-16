package panels

object WahlPanel extends TModulPanel {

  
  name = "WahlPanel"
  def clearAll = {
    _profil = null
    removeAll()
    repaint()
  }

}