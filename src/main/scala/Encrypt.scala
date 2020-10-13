import scala.io.StdIn

object Encrypt extends App {

  val toEncrypt = StdIn.readLine("Secret text: ")
  val key = StdIn.readLine("Key: ")

  val encryptedBytes = Cypher.encrypt(toEncrypt, key)
  val encryptedBytesHex = Cypher.bytesToHexString(encryptedBytes)
  println("Result:")
  println(encryptedBytesHex)
}

