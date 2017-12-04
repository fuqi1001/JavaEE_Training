package InterviewQuestion.apple;

public class replaceSpaces {
    public static void replace(char[] str, String replaceStr, int len) {
        int countSpace = 0;
        int newLength = 0;
        for(int i = 0 ; i < len; i++) {
            char c = str[i];
            if(c == ' ') {
                countSpace++;
            }
        }

        newLength = len + replaceStr.length() * countSpace - 1;
        int index = newLength - 1;
        char[] rs = replaceStr.toCharArray();
        for(int i = len - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                for(int j = replaceStr.length() - 1; j >= 0; j--) {
                    str[index--] = rs[j];
                }
            } else {
                str[index--] = str[i];
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        char[] ch = {'t', 'h', 'e', ' ', 'd', 'o', 'g', ' ', ' ', ' ', ' ', ' ', ' '};
        int length = 6;
        replace(ch, "%02", 7);
    }
}
