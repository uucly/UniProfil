
package panels

import javax.swing.JPanel
import javax.swing.BoxLayout
import profils.Profil

trait TModulPanel extends JPanel {
  setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS))
  var _profil: Profil = null
  def clearAll
  def resetPoints = {
    _profil.resetPoints
  }
  
  var name: String = null
}