

package panels

import javax.swing.JPanel
import javax.swing.JLabel
import javax.swing.BoxLayout
import javax.swing.JButton
import listener.ClearButtonListener
import menue.ProfilMenue

object InfoPanel extends JPanel {

  setLayout(new BoxLayout(this, BoxLayout.Y_AXIS))
  load
  
  
  //Functions
  def load = {
    removeAll()
    val textAufbau = new JLabel("Aufbauf�cher")
    val punkteAufbau = new JLabel("Punkte: " + ProfilMenue.aufbauCreditPoints + " von 32")

    val textPflicht = new JLabel("Pflichtf�cher")
    val punktePflicht = new JLabel("Punkte: " + sumPflichtPoints + " von " + sumOfPflicht)

    val textWahl = new JLabel("Wahlpflichtf�cher")
    val punkteWahl = new JLabel("Punkte: " + sumWahlPoints + " von " + (46 - sumOfPflicht))

    val textErg = new JLabel("Erg�nzungsf�cher")
    val punkteErg = new JLabel("Punkte: " + ProfilMenue.ergaenungCreditPoints + " von 8")

    val textKey = new JLabel("Schl�sselqualifikationen")
    val punkteKey = new JLabel("Punkte: " + ProfilMenue.keyCreditPoints + " von 4")
    val gesamtPunkte = new JLabel("Gesamt: " + sumAll)
    val trenner = new JLabel("--------------------------------------------")

    val clearButton = new JButton("clear profil points")
    clearButton.addMouseListener(new ClearButtonListener)
    add(textAufbau)
    add(punkteAufbau)
    add(textPflicht)
    add(punktePflicht)
    add(textWahl)
    add(punkteWahl)
    add(textErg)
    add(punkteErg)
    add(textKey)
    add(punkteKey)
    add(trenner)
    add(gesamtPunkte)
    add(clearButton)
    revalidate()
  }

  def sumOfPflicht = {
    try {
      RightPanel._profil.getAllPoints + WahlPanel._profil.getAllPoints
    } catch {
      case e: Exception => 0f
    }
  }

  def sumAll = (ProfilMenue.aufbauCreditPoints + sumWahlPoints + sumPflichtPoints + ProfilMenue.ergaenungCreditPoints + ProfilMenue.keyCreditPoints)
  
  def sumPflichtPoints = {
    try {
      RightPanel._profil.pflichtPoints + WahlPanel._profil.pflichtPoints
    } catch {
      case ex: Exception => 0f
    }
  }

  def sumWahlPoints = {
    try {
      RightPanel._profil.wahlPoints + WahlPanel._profil.wahlPoints
    } catch {
      case ex: Exception => 0f
    }
  }

}