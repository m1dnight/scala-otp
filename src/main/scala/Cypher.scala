object Cypher {
  def encrypt(secretText: String, key: String): Array[Byte] = {
    val keyBytes: Array[Byte] = key.getBytes()
    val inputBytes: Array[Byte] = secretText.getBytes();
    val outputBytes = new Array[Byte](inputBytes.length)

    for ((inputByte, idx) <- inputBytes.view.zipWithIndex) {
      val keyByte = keyBytes(idx)
      outputBytes(idx) = (inputByte ^ keyByte).toByte
    }
    return outputBytes
  }

  def decrypt(encryptedTextBytes: Array[Byte], key: String): String = {
    val keyBytes: Array[Byte] = key.getBytes()
    val secretTextBytes = new Array[Byte](encryptedTextBytes.length)

    for ((encryptedTextByte, idx) <- encryptedTextBytes.view.zipWithIndex) {
      val keyByte = keyBytes(idx)
      secretTextBytes(idx) = (encryptedTextByte ^ keyByte).toByte
    }
    return new String(secretTextBytes)
  }

  def hexStringToBytes(hexString: String): Array[Byte] = {
    var input = hexString.trim
    val hexStrings = input.split(" ")
    val bytes = new Array[Byte](hexStrings.length)

    for ((hexString, idx) <- hexStrings.view.zipWithIndex) {
      bytes(idx) = Integer.parseInt(hexString, 16).toByte
    }

    return bytes;
  }

  def bytesToHexString(bytes: Array[Byte]): String = {
    var result = "";
    for (byte <- bytes) {
      val hexStr = Integer.toHexString(byte);
      result = result.concat(" ").concat(hexStr)
    }
    return result.trim;
  }
}
