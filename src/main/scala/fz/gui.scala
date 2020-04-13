package fz

import java.awt.Dimension

import fz.canvas.Canvas

import scala.swing.BorderPanel.Position
import scala.swing.{BorderPanel, MainFrame}

object gui {
  def apply(canvas: Canvas): MainFrame =
    new MainFrame {
      title = "bomz"

      contents = new BorderPanel {
        add(canvas, Position.Center)
      }

      preferredSize = new Dimension(480, 480)
      pack()
      centerOnScreen()
      open()
    }
}
