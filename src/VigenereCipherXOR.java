import java.io.UnsupportedEncodingException;

public class VigenereCipherXOR {
    public static char[] encryption(String pPlain_Text, String pKey) {
        /*
        Encryption plain_text by Vigenere Cipher with XOR, using key
         */
        char[] txt = pPlain_Text.toCharArray();
        char[] key = pKey.toCharArray();
        char[] res = new char[pPlain_Text.length()];

        for (int i = 0; i < txt.length; i++) {
            res[i] = (char) (txt[i] ^ key[i % key.length]);
        }

        return res;
    }

    public static String decryption(char[] pText, String pKey) {
        char[] res = new char[pText.length];
        char[] key = pKey.toCharArray();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (char) (pText[i] ^ key[i % key.length]);
        }

        return new String(res);
    }

    static final char[] HEX_CHAR_TABLE = {
            '0', '1', '2', '3',
            '4', '5', '6', '7',
            '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F'
    };

    public static String convertByteArrayToHexString5( char[] CharArray ) throws UnsupportedEncodingException {
        char[] HexChars = new char[2 * CharArray.length];
        int index = 0;

        for ( char each_char : CharArray ) {
            HexChars[index++] = HEX_CHAR_TABLE[ ((int)each_char & 0xFF) >>> 4];
            HexChars[index++] = HEX_CHAR_TABLE[ ((int)each_char & 0xFF) & 0xF];
        }

        return new String(HexChars);
    }

    public static void main(String[] args) throws Exception {
        String Plain_Text = "Hello!";
        char[] key = {(char)0xA1, (char)0x2F};
        String Key = new String(key);
        char[] Cipher_Text = VigenereCipherXOR.encryption(Plain_Text, Key);
        System.out.println( "Plain_Text:\t\t\t" + Plain_Text );
        System.out.println( "Cipher_Text (in hex format):\t" + VigenereCipherXOR.convertByteArrayToHexString5(Cipher_Text) );
        String Decryption_Text = VigenereCipherXOR.decryption(Cipher_Text, Key);
        System.out.println( "Decryption_Text:\t" + Decryption_Text );

    }
}
