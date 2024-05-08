package sun.util.locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class Extension {

    /* renamed from: id, reason: collision with root package name */
    private String f53749id;
    private final char key;
    private String value;

    /* JADX INFO: Access modifiers changed from: protected */
    public Extension(char key) {
        this.key = key;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Extension(char key, String value) {
        this.key = key;
        setValue(value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setValue(String value) {
        this.value = value;
        this.f53749id = this.key + "-" + value;
    }

    public char getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String getID() {
        return this.f53749id;
    }

    public String toString() {
        return getID();
    }
}
