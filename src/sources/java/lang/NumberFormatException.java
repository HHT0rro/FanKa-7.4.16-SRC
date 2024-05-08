package java.lang;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class NumberFormatException extends IllegalArgumentException {
    static final long serialVersionUID = -2848938806368998894L;

    public NumberFormatException() {
    }

    public NumberFormatException(String s2) {
        super(s2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static NumberFormatException forInputString(String s2) {
        return new NumberFormatException("For input string: \"" + s2 + "\"");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NumberFormatException forInputString(String s2, int radix) {
        String str;
        StringBuilder append = new StringBuilder().append("For input string: \"").append(s2).append("\"");
        if (radix == 10) {
            str = "";
        } else {
            str = " under radix " + radix;
        }
        return new NumberFormatException(append.append(str).toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static NumberFormatException forCharSequence(CharSequence s2, int beginIndex, int endIndex, int errorIndex) {
        return new NumberFormatException("Error at index " + (errorIndex - beginIndex) + " in: \"" + ((Object) s2.subSequence(beginIndex, endIndex)) + "\"");
    }
}
