package com.bheap.scalautils

object FileUtils {
  import java.io.FileWriter
  import ResourceUtils._
  def writeFile(fileName:String, content:String) = 
    using (new FileWriter(fileName)) {
      fileWriter => fileWriter.write(content)
    }
}
