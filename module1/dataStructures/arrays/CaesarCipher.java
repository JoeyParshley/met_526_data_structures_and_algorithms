package cs526.module1.dataStructures.arrays;

public class CaesarCipher {
  // encryption and decryption arrays
  protected char[] encoder = new char[26];
  protected char[] decoder = new char[26];

  /**
   * Constructore initializes the encryption and decryption arrays
   * @param rotation - number of character to shift the initial character
   */
  public CaesarCipher(int rotation){
    for (int k = 0; k < 26; k++){
      encoder[k] = (char) ('A' + (k + rotation) % 26);
      decoder[k] = (char) ('A' + (k - rotation + 26) % 26);
    }
  }

  /**
   * Returns the string representing the encrypted message
   * @param message
   * @return
   */
  public String encrypt(String message){
    // use the encoder array
    return transform(message, encoder);
  }

  /**
   * Return the decrypted message given encrypted secret
   * @param message
   * @return
   */
  public String decrypt(String message){
    // use the decoder array
    return transform(message, decoder);
  }

  /**
   * Returns transformation of the original String using given code
   * @param original
   * @param code
   * @return
   */
  private String transform(String original, char[] code){
    char[] msg = original.toCharArray();

    for (int k=0; k < msg.length; k++){
      int j = msg[k] - 'A';
      msg[k] = code[j];
    }
    return  new String(msg);
  }

  public static void main(String[] args) {
    CaesarCipher cipher = new CaesarCipher(3);

    System.out.println("Encryption code = " + new String(cipher.encoder));
    System.out.println("Encryption code = " + new String(cipher.decoder));

    String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
    String coded = cipher.encrypt(message);
    System.out.println("Sectre: " + coded);
    String answer = cipher.decrypt(coded);
    System.out.println("Message: " + answer);
  }
}
