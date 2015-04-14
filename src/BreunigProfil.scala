
import javax.swing.JRadioButton
import javax.swing.JCheckBoxMenuItem
import javax.swing.JLabel
import scala.io.Source

object BreunigProfil extends Profil {

  _checkBox = new JCheckBoxMenuItem("Breunig Profil")
  _checkBox.addItemListener(new ProfilListener(this))
  name = "Breunig"
  _pflichtMap = Map(("GeoDB", 4), ("3D/4D GIS", 4), ("Projekt Geoinformatik", 4))

  var wahlModul = Source.fromFile("Breunig_Wahl.txt").getLines.toList;
  
  def load(panel: TBlaPanel) = {

    choosenPanel = panel
    panel.removeAll()

    // Pflicht
    panel.add(new JLabel("-----------------------------------------------------------------"))
    panel.add(new JLabel("                              Pflicht"))
    panel.add(new JLabel("-----------------------------------------------------------------"))

    addProfil(_pflichtMap, panel)

    panel.add(new JLabel("-----------------------------------------------------------------"))
    panel.add(new JLabel("                              Wahl"))
    panel.add(new JLabel("-----------------------------------------------------------------"))

    val modulsToShow = loadWahlModule(wahlModul);
    loadWahlFile(modulsToShow, panel)
    panel.revalidate()
  }
}