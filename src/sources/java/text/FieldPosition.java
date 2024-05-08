package java.text;

import java.text.Format;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class FieldPosition {
    private Format.Field attribute;
    int beginIndex;
    int endIndex;
    int field;

    public FieldPosition(int field) {
        this.field = 0;
        this.endIndex = 0;
        this.beginIndex = 0;
        this.field = field;
    }

    public FieldPosition(Format.Field attribute) {
        this(attribute, -1);
    }

    public FieldPosition(Format.Field attribute, int fieldID) {
        this.field = 0;
        this.endIndex = 0;
        this.beginIndex = 0;
        this.attribute = attribute;
        this.field = fieldID;
    }

    public Format.Field getFieldAttribute() {
        return this.attribute;
    }

    public int getField() {
        return this.field;
    }

    public int getBeginIndex() {
        return this.beginIndex;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public void setBeginIndex(int bi) {
        this.beginIndex = bi;
    }

    public void setEndIndex(int ei) {
        this.endIndex = ei;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Format.FieldDelegate getFieldDelegate() {
        return new Delegate();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof FieldPosition)) {
            return false;
        }
        FieldPosition other = (FieldPosition) obj;
        Format.Field field = this.attribute;
        if (field == null) {
            if (other.attribute != null) {
                return false;
            }
        } else if (!field.equals(other.attribute)) {
            return false;
        }
        return this.beginIndex == other.beginIndex && this.endIndex == other.endIndex && this.field == other.field;
    }

    public int hashCode() {
        return (this.field << 24) | (this.beginIndex << 16) | this.endIndex;
    }

    public String toString() {
        return getClass().getName() + "[field=" + this.field + ",attribute=" + ((Object) this.attribute) + ",beginIndex=" + this.beginIndex + ",endIndex=" + this.endIndex + ']';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean matchesField(Format.Field attribute) {
        Format.Field field = this.attribute;
        if (field != null) {
            return field.equals(attribute);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean matchesField(Format.Field attribute, int field) {
        Format.Field field2 = this.attribute;
        if (field2 != null) {
            return field2.equals(attribute);
        }
        return field == this.field;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public class Delegate implements Format.FieldDelegate {
        private boolean encounteredField;

        private Delegate() {
        }

        @Override // java.text.Format.FieldDelegate
        public void formatted(Format.Field attr, Object value, int start, int end, StringBuffer buffer) {
            if (!this.encounteredField && FieldPosition.this.matchesField(attr)) {
                FieldPosition.this.setBeginIndex(start);
                FieldPosition.this.setEndIndex(end);
                this.encounteredField = start != end;
            }
        }

        @Override // java.text.Format.FieldDelegate
        public void formatted(int fieldID, Format.Field attr, Object value, int start, int end, StringBuffer buffer) {
            if (!this.encounteredField && FieldPosition.this.matchesField(attr, fieldID)) {
                FieldPosition.this.setBeginIndex(start);
                FieldPosition.this.setEndIndex(end);
                this.encounteredField = start != end;
            }
        }
    }
}
