package InterviewQuestion.apple;

public interface StringBufferVariant {
    StringBufferVariant append(String newText);
    char charAt(int index) throws StringIndexOutOfBoundsException;
    int length();
    String toString();

    public static class StringIndexOutOfBoundsException extends Exception {}
}


