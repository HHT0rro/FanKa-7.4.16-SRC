package java.text;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class CollationKey implements Comparable<CollationKey> {
    private final String source;

    @Override // java.lang.Comparable
    public abstract int compareTo(CollationKey collationKey);

    public abstract byte[] toByteArray();

    public String getSourceString() {
        return this.source;
    }

    protected CollationKey(String source) {
        if (source == null) {
            throw new NullPointerException();
        }
        this.source = source;
    }
}
