/**
 * Copyright (C) 2011-2012 Bheap Ltd - http://www.bheap.co.uk.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bheap.scalautils

/** Provide some bootstrapped file functionality.
  *
  * @author <a href="mailto:ross@bheap.co.uk">rossputin</a>
  * @since 1.0 */
object FileUtils {

  import java.io.FileWriter
  import ResourceUtils._

  /** Write a file using with close handled by resource management. */
  def writeFile(fileName: String, content: String) = 
    using (new FileWriter(fileName)) {
      fileWriter => fileWriter.write(content)
    }

  /** Write a file with flush and close handled by resource management. */
  def writeFileWithFlush(fileName: String, content: String) = 
    usingFlush(new FileWriter(fileName)) {
      fileWriter => fileWriter.write(content)
    }
}
