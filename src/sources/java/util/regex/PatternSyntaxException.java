package java.util.regex;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class PatternSyntaxException extends IllegalArgumentException {
    private static final long serialVersionUID = -3864639126226059218L;
    private final String desc;
    private final int index;
    private final String pattern;

    public PatternSyntaxException(String desc, String regex, int index) {
        this.desc = desc;
        this.pattern = regex;
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    public String getDescription() {
        return this.desc;
    }

    public String getPattern() {
        return this.pattern;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.desc);
        if (this.index >= 0) {
            sb2.append(" near index ");
            sb2.append(this.index);
        }
        sb2.append(System.lineSeparator());
        sb2.append(this.pattern);
        int i10 = this.index;
        if (i10 >= 0 && (str = this.pattern) != null && i10 < str.length()) {
            sb2.append(System.lineSeparator());
            for (int i11 = 0; i11 < this.index; i11++) {
                char c4 = '\t';
                if (this.pattern.charAt(i11) != '\t') {
                    c4 = ' ';
                }
                sb2.append(c4);
            }
            sb2.append('^');
        }
        return sb2.toString();
    }
}
