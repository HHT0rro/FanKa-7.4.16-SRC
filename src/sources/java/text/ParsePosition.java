package java.text;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ParsePosition {
    int errorIndex = -1;
    int index;

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ParsePosition(int index) {
        this.index = 0;
        this.index = index;
    }

    public void setErrorIndex(int ei) {
        this.errorIndex = ei;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ParsePosition)) {
            return false;
        }
        ParsePosition other = (ParsePosition) obj;
        return this.index == other.index && this.errorIndex == other.errorIndex;
    }

    public int hashCode() {
        return (this.errorIndex << 16) | this.index;
    }

    public String toString() {
        return getClass().getName() + "[index=" + this.index + ",errorIndex=" + this.errorIndex + ']';
    }
}
