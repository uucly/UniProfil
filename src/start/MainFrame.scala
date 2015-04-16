
package start

import javax.swing.JFrame
import java.awt.BorderLayout
import java.awt.GridLayout
import javax.swing.JPanel
import javax.swing.border.CompoundBorder
import javax.swing.border.LineBorder
import java.awt.Color
import javax.swing.JScrollPane
import panels.RightPanel
import panels.InfoPanel
import panels.WahlPanel
import menue.ProfilMenue

object MainFrame extends JFrame {

  def load = {
    init

    setPanelBorder(RightPanel)
    setPanelBorder(WahlPanel)

    val scrollPanelLeft = new JScrollPane
    val scrollPanelRight = new JScrollPane
    
    scrollPanelLeft.setViewportView(RightPanel)
    scrollPanelRight.setViewportView(WahlPanel)

    val mainPanel = new JPanel
    mainPanel.setLayout(new GridLayout(0, 3))
    mainPanel.add(scrollPanelLeft)
    mainPanel.add(scrollPanelRight)
    mainPanel.add(InfoPanel)
    add(mainPanel, BorderLayout.CENTER)
    add(ProfilMenue, BorderLayout.NORTH)
    setVisible(true)
  }
  
  // Functions
  private def init = {
    setSize(1300, 700)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  }

  private def setPanelBorder = (panel: JPanel) => panel.setBorder(new CompoundBorder(panel.getBorder(), new LineBorder(Color.red, 4)))
}