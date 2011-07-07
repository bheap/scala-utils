# S C A L A - U T I L S

## About

A collection of simple to use libraries, replicating the handy File and Resource utils we see across languages like Java and Ruby.

## Features

- FileUtils provides concise functionality to write to files
- ResourceUtils provides concise functionality to manage resources

Thats it, nothing more, no bloat, no million things we think we (or you) will need.

## Requirements

- Scala 2.8.x + (Lets face is, you really should be on at least 2.8.x)
- SBT 0.10.x

## Install

- `git clone git://github.com/bheap/scala-utils`
- `cd scala-utils`
- `sbt update publish-local`

## Usage

### FileUtils

    import com.bheap.scalautils.FileUtils._
    writeFile("somefile.txt", "some content")

### ResourceUtils

    import com.bheap.scalautils.ResourceUtils._
    def someMethodNeedingResourceManagement(someResource: String) = 
      using (.. some resource ..) {
	    resourceAction => resourceAction.action(...)
      }