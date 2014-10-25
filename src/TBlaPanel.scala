
import javax.swing.JPanel
import javax.swing.BoxLayout
import java.awt.Component
import java.awt.BorderLayout
import java.awt.GridLayout

trait TBlaPanel extends JPanel {
  setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS))
  var _profil: Profil = null
  def clearAll
  def resetPoints = {
    _profil.resetPoints
  }
  
  var name: String = null
}