package java.time.format;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public enum SignStyle {
    NORMAL,
    ALWAYS,
    NEVER,
    NOT_NEGATIVE,
    EXCEEDS_PAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean parse(boolean positive, boolean strict, boolean fixedWidth) {
        switch (this) {
            case NORMAL:
                return (positive && strict) ? false : true;
            case ALWAYS:
            case EXCEEDS_PAD:
                return true;
            case NEVER:
            case NOT_NEGATIVE:
            default:
                return (strict || fixedWidth) ? false : true;
        }
    }
}
