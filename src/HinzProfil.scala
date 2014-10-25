import javax.swing.JRadioButton
import javax.swing.JLabel
import javax.swing.JCheckBoxMenuItem

object HinzProfil extends Profil {

  _checkBox = new JCheckBoxMenuItem("Hinz Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Hinz"

  _pflichtMap = Map(("Struktur- und Objektextraktion in 2D und 3D", 4), ("Bildsequenzanalyse", 2), ("Statistische Mustererkennung\nWissensbasierte Bildanalyse", 5))

  def load(panel: TBlaPanel) = {

    choosenPanel = panel
    panel.removeAll()
  
    panel.add(new JLabel("-----------------------------------------------------------------"))
    panel.add(new JLabel("                              Pflicht"))
    panel.add(new JLabel("-----------------------------------------------------------------"))

    addProfil(_pflichtMap, panel)

    panel.add(new JLabel("-----------------------------------------------------------------"))
    panel.add(new JLabel("                              Wahl"))
    panel.add(new JLabel("-----------------------------------------------------------------"))

    loadWahlFile("Hinz_Wahl.txt", panel)
 
    panel.revalidate()
  }
}