public class Ciphers {
    
    // Cipher index for Caesar Ciphers
    static String caesarCiphers[] = new String[]{
        "a b c d e f g h i j k l m n o p q r s t u v w x y z",
        "b c d e f g h i j k l m n o p q r s t u v w x y z a",
        "c d e f g h i j k l m n o p q r s t u v w x y z a b",
        "d e f g h i j k l m n o p q r s t u v w x y z a b c",
        "e f g h i j k l m n o p q r s t u v w x y z a b c d",
        "f g h i j k l m n o p q r s t u v w x y z a b c d e",
        "g h i j k l m n o p q r s t u v w x y z a b c d e f",
        "h i j k l m n o p q r s t u v w x y z a b c d e f g",
        "i j k l m n o p q r s t u v w x y z a b c d e f g h",
        "j k l m n o p q r s t u v w x y z a b c d e f g h i",
        "k l m n o p q r s t u v w x y z a b c d e f g h i j",
        "l m n o p q r s t u v w x y z a b c d e f g h i j k",
        "m n o p q r s t u v w x y z a b c d e f g h i j k l",
        "n o p q r s t u v w x y z a b c d e f g h i j k l m",
        "o p q r s t u v w x y z a b c d e f g h i j k l m n",
        "p q r s t u v w x y z a b c d e f g h i j k l m n o",
        "q r s t u v w x y z a b c d e f g h i j k l m n o p",
        "r s t u v w x y z a b c d e f g h i j k l m n o p q",
        "s t u v w x y z a b c d e f g h i j k l m n o p q r",
        "t u v w x y z a b c d e f g h i j k l m n o p q r s",
        "u v w x y z a b c d e f g h i j k l m n o p q r s t",
        "v w x y z a b c d e f g h i j k l m n o p q r s t u",
        "w x y z a b c d e f g h i j k l m n o p q r s t u v",
        "x y z a b c d e f g h i j k l m n o p q r s t u v w",
        "y z a b c d e f g h i j k l m n o p q r s t u v w x",
        "z a b c d e f g h i j k l m n o p q r s t u v w x y"
    };

    // Call on and prepare a Caesar Cipher Key
    public static String[] getCaesarKey (int shift) {
        String key = caesarCiphers[shift];
        String cipher[] = key.split(" ");
        return cipher;
    }
}