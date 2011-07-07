package com.bheap.scalautils

/** Provide some bootstrapped file functionality.
  *
  * @author <a href="mailto:ross@bheap.co.uk">rossputin</a>
  * @since 1.0 */
object FileUtils {
  import java.io.FileWriter
  import ResourceUtils._
  def writeFile(fileName: String, content: String) = 
    using (new FileWriter(fileName)) {
      fileWriter => fileWriter.write(content)
    }
}
