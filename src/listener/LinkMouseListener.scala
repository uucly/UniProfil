
package listener

import java.awt.event.MouseEvent
import java.awt.event.MouseAdapter
import java.net.URI
import javax.swing.JLabel
import java.awt.Color

class LinkMouseListener(val label: JLabel) extends MouseAdapter {

  private val uri = "http://gug.bgu.kit.edu/downloads/gug_msc_modul_handbuch.pdf"

  override def mouseClicked(evt: MouseEvent) = {

    try {
      val desktop = java.awt.Desktop.getDesktop();
      desktop.browse(new URI(uri));
    } catch {
      case ex: Exception => error("no connection")
    }
  }

  override def mouseEntered(evt: MouseEvent) = {
    label.setForeground(Color.RED);
  }

  override def mouseExited(evt: MouseEvent) = {
    label.setForeground(Color.BLACK);
  }
}