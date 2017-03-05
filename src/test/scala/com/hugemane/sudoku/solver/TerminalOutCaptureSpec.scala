package com.hugemane.sudoku.solver

import java.io.ByteArrayOutputStream

import org.scalatest.BeforeAndAfterEach

trait TerminalOutCaptureSpec extends TestSpec with BeforeAndAfterEach {
  protected var consoleOutputCapture: ByteArrayOutputStream = _

  override protected def beforeEach() {
    consoleOutputCapture = new ByteArrayOutputStream
    Console.setOut(consoleOutputCapture)
  }

  def terminalOutput = new String(consoleOutputCapture.toByteArray)
}
