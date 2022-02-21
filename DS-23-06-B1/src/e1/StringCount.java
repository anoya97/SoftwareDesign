package e1;

public class StringCount {
    public static int countWords(String text) {
        int count = 0;
        if (text != null) {
            for (int i = 0; i < text.length(); i++) {
                if (((i > 0) && (text.charAt(i) != ' ') && (text.charAt(i - 1) == ' ')) || ((text.charAt(0) != ' ') && (i == 0)))
                    count++;
            }
            return count;
        }
        return count;
    }

    public static int countChar(String text, char c){
        int count = 0;

        if(text != null) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == c)
                    count++;
            }
            return count;
        }
        return count;
    }

    public static int countCharIgnoringCase( String text , char c) {
        int count = 0;
        if (text != null) {
            for (int i = 0; i < text.length(); i++) {
                if (text.charAt(i) == c && (text.charAt(i) > 0 && text.charAt(i) <= 64))
                    count++;
                else if (text.charAt(i) == c && (text.charAt(i) >= 91 && text.charAt(i) <= 96))
                    count++;
                else if ((text.charAt(i) > 64 && text.charAt(i) < 91) || (text.charAt(i) > 96 && text.charAt(i) < 123)) {
                    if (text.charAt(i) == c || text.charAt(i) == c + 32 || text.charAt(i) == c - 32)
                        count++;
                } else if(c == 'ñ' || c == 'Ñ'){
                    if (text.charAt(i) == 'ñ' || text.charAt(i) == 'Ñ')
                        count++;
                }

            }
            return count;
        }
        return count;
    }

    public static boolean isPasswordSafe (String password){
        int specialCharacters = 0, upperCase = 0, lowerCase = 0, digit = 0;
        if(password.length() >= 8){
            for(int i = 0; i < password.length(); i++){
                if((password.charAt(i) >= 'A' && password.charAt(i) <= 'Z'))
                    upperCase++;
                if(password.charAt(i) >= 'a' && password.charAt(i) <= 'z')
                    lowerCase++;
                if(password.charAt(i) == '?' || password.charAt(i) == '@' || password.charAt(i) == '#' || password.charAt(i)=='.' || password.charAt(i)==','|| password.charAt(i)== '$')
                    specialCharacters++;
                if(password.charAt(i) >= '0' && password.charAt(i) <= '9')
                    digit++;
            }
        }
        return (digit >= 1 && specialCharacters >= 1 && lowerCase >= 1 && upperCase >= 1);
    }
}
