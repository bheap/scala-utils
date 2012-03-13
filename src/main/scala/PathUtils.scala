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

import scala.annotation.tailrec
import scala.collection.mutable.Stack

import java.io.File

/** Convenience utility object for working with path structures and directory trees.
  *
  * @author <a href="mailto:barrie@bheap.co.uk">Barrie McGuire</a> 
  * @since 1.0 */
object PathUtils {

  /** Given a file return a stack containing the file itself and all of it's parent files
    *
    * @param file the file
    * @return a stack containing a file and all of it's parents */
	def getParentFiles(file: File): Stack[File] = {	
		@tailrec def internal(f: File, s: Stack[File]): Stack[File] = {
			s.push(f)
		  if (f.getParentFile != null) internal(f.getParentFile, s) else s
		}
		internal(file, Stack[File]())
	}
	
  /* Calculates the relative path between a specified root directory and a target path.
   *
   * @param rootPath The absolute path of the root directory.
   * @param targetPath The path to the target file or directory.
   * @return The relative path between the specified root directory and the target path. */
  def relativise(rootPath: File, targetPath: File): String = {
	  if (rootPath == targetPath) "."  // Paths are already equal
    else if (! targetPath.isAbsolute) targetPath.toString  // Target already relative
	  else {
		  // Find common root
		  val root = getParentFiles(rootPath)
		  val target = getParentFiles(targetPath) 
		  while (root.size > 0 && target.size > 0 && root.head == target.head) {
			  root.pop
			  target.pop
		  }
		
		  // Create relative path components
		  val prefix = root.map(a => if (a == root.last && target.size == 0) ".." else ".." + File.separator)
  		val path = target.map(a => if (a == target.last) a.getName else a.getName + File.separator)
		  
  		// Build path
      (prefix ++ path).mkString("")
    } 
  }	
}