package java.text;

import java.text.AttributedCharacterIterator;
import java.util.Map;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* compiled from: AttributedString.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
class AttributeEntry implements Map.Entry<AttributedCharacterIterator.Attribute, Object> {
    private AttributedCharacterIterator.Attribute key;
    private Object value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributeEntry(AttributedCharacterIterator.Attribute key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object o10) {
        if (!(o10 instanceof AttributeEntry)) {
            return false;
        }
        AttributeEntry other = (AttributeEntry) o10;
        return other.key.equals(this.key) && Objects.equals(other.value, this.value);
    }

    @Override // java.util.Map.Entry
    public AttributedCharacterIterator.Attribute getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object newValue) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        int hashCode = this.key.hashCode();
        Object obj = this.value;
        return hashCode ^ (obj == null ? 0 : obj.hashCode());
    }

    public String toString() {
        return this.key.toString() + "=" + this.value.toString();
    }
}
