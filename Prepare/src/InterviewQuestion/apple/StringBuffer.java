package InterviewQuestion.apple;

public class StringBuffer implements StringBufferVariant {
    String str;
    public StringBuffer() {
        this.str = "";
    }

    public StringBuffer(String str) {
        this.str = str;
    }

    @Override
    public StringBufferVariant append(String newText) {
        return null;
    }

    @Override
    public char charAt(int index) throws StringIndexOutOfBoundsException {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }
}
