package fz.apps

import java.awt.{Color, Dimension}

import com.typesafe.config.ConfigFactory
import fz.sprites
import javax.swing.{BorderFactory, ImageIcon}

import scala.swing.{FlowPanel, Label, MainFrame}

object SpriteLibViewer extends App {
  val config = ConfigFactory.load("sheet.conf").getConfig("sheet")
  val lib = sprites.library.init(config)

  new MainFrame {
    title = "frogz"

    contents = new FlowPanel {
      contents ++= lib.zipWithIndex.flatMap {
        case (b, i) =>
          new Label(b.id) +:
            b.tiles.map { bi =>
              new Label {
                icon = new ImageIcon(bi) {
                  border = BorderFactory.createLineBorder(Color.black)
                }
              }
            }
      }
    }

    preferredSize = new Dimension(560, 690)
    pack()
    centerOnScreen()
    open()
  }
}
