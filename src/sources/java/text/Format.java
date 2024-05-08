package java.text;

import java.io.Serializable;
import java.text.AttributedCharacterIterator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class Format implements Serializable, Cloneable {
    private static final long serialVersionUID = -299282585814624189L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public interface FieldDelegate {
        void formatted(int i10, Field field, Object obj, int i11, int i12, StringBuffer stringBuffer);

        void formatted(Field field, Object obj, int i10, int i11, StringBuffer stringBuffer);
    }

    public abstract StringBuffer format(Object obj, StringBuffer stringBuffer, FieldPosition fieldPosition);

    public abstract Object parseObject(String str, ParsePosition parsePosition);

    public final String format(Object obj) {
        return format(obj, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public AttributedCharacterIterator formatToCharacterIterator(Object obj) {
        return createAttributedCharacterIterator(format(obj));
    }

    public Object parseObject(String source) throws ParseException {
        ParsePosition pos = new ParsePosition(0);
        Object result = parseObject(source, pos);
        if (pos.index == 0) {
            throw new ParseException("Format.parseObject(String) failed", pos.errorIndex);
        }
        return result;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributedCharacterIterator createAttributedCharacterIterator(String s2) {
        AttributedString as = new AttributedString(s2);
        return as.getIterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributedCharacterIterator createAttributedCharacterIterator(AttributedCharacterIterator[] iterators) {
        AttributedString as = new AttributedString(iterators);
        return as.getIterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributedCharacterIterator createAttributedCharacterIterator(String string, AttributedCharacterIterator.Attribute key, Object value) {
        AttributedString as = new AttributedString(string);
        as.addAttribute(key, value);
        return as.getIterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AttributedCharacterIterator createAttributedCharacterIterator(AttributedCharacterIterator iterator, AttributedCharacterIterator.Attribute key, Object value) {
        AttributedString as = new AttributedString(iterator);
        as.addAttribute(key, value);
        return as.getIterator();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    public static class Field extends AttributedCharacterIterator.Attribute {
        private static final long serialVersionUID = 276966692217360283L;

        /* JADX INFO: Access modifiers changed from: protected */
        public Field(String name) {
            super(name);
        }
    }
}
