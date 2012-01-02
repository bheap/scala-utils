package com.bheap.scalautils

/** Provide some resource management functionality.
  *
  * Ensure resources are closed.
  *
  * @author <a href="mailto:ross@bheap.co.uk">rossputin</a>
  * @since 1.0 */
object ResourceUtils {
  def using[A <: {def close(): Unit}, B](ioResource: A)(f: A => B): B = try { f(ioResource) } finally { ioResource.close() }
}
