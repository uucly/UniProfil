
package start

import javax.swing.JFrame
import java.awt.BorderLayout
import java.awt.GridLayout
import javax.swing.JPanel
import javax.swing.border.CompoundBorder
import javax.swing.border.LineBorder
import java.awt.Color
import javax.swing.JScrollPane
import panels.LeftPanel
import panels.InfoPanel
import panels.RightPanel
import menue.Menue

object MainFrame extends JFrame {

  def load = {
    init

    setPanelBorder(LeftPanel)
    setPanelBorder(RightPanel)

    val scrollPanelLeft = new JScrollPane
    val scrollPanelRight = new JScrollPane
    
    scrollPanelLeft.setViewportView(LeftPanel)
    scrollPanelRight.setViewportView(RightPanel)

    val mainPanel = new JPanel
    mainPanel.setLayout(new GridLayout(0, 3))
    mainPanel.add(scrollPanelLeft)
    mainPanel.add(scrollPanelRight)
    mainPanel.add(InfoPanel)
    add(mainPanel, BorderLayout.CENTER)
    add(Menue, BorderLayout.NORTH)
    setVisible(true)
  }
  
  // Functions
  private def init = {
    setSize(1300, 700)
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  }

  private def setPanelBorder = (panel: JPanel) => panel.setBorder(new CompoundBorder(panel.getBorder(), new LineBorder(Color.red, 4)))
}