package fz

import java.net.URL

object resources {
  def get(path: String): URL = getClass.getResource(path)


  def sheet(path: String) = {

  }
}
