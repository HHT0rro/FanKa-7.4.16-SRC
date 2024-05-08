package java.text;

import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public abstract class BreakIterator implements Cloneable {
    public static final int DONE = -1;

    public abstract int current();

    public abstract int first();

    public abstract int following(int i10);

    public abstract CharacterIterator getText();

    public abstract int last();

    public abstract int next();

    public abstract int next(int i10);

    public abstract int previous();

    public abstract void setText(CharacterIterator characterIterator);

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new InternalError(e2);
        }
    }

    public int preceding(int offset) {
        int pos = following(offset);
        while (pos >= offset && pos != -1) {
            pos = previous();
        }
        return pos;
    }

    public boolean isBoundary(int offset) {
        if (offset == 0) {
            return true;
        }
        int boundary = following(offset - 1);
        if (boundary != -1) {
            return boundary == offset;
        }
        throw new IllegalArgumentException();
    }

    public void setText(String newText) {
        setText(new StringCharacterIterator(newText));
    }

    public static BreakIterator getWordInstance() {
        return getWordInstance(Locale.getDefault());
    }

    public static BreakIterator getWordInstance(Locale locale) {
        return new IcuIteratorWrapper(android.icu.text.BreakIterator.getWordInstance(locale));
    }

    public static BreakIterator getLineInstance() {
        return getLineInstance(Locale.getDefault());
    }

    public static BreakIterator getLineInstance(Locale locale) {
        return new IcuIteratorWrapper(android.icu.text.BreakIterator.getLineInstance(locale));
    }

    public static BreakIterator getCharacterInstance() {
        return getCharacterInstance(Locale.getDefault());
    }

    public static BreakIterator getCharacterInstance(Locale locale) {
        return new IcuIteratorWrapper(android.icu.text.BreakIterator.getCharacterInstance(locale));
    }

    public static BreakIterator getSentenceInstance() {
        return getSentenceInstance(Locale.getDefault());
    }

    public static BreakIterator getSentenceInstance(Locale locale) {
        return new IcuIteratorWrapper(android.icu.text.BreakIterator.getSentenceInstance(locale));
    }

    public static synchronized Locale[] getAvailableLocales() {
        Locale[] availableLocales;
        synchronized (BreakIterator.class) {
            availableLocales = android.icu.text.BreakIterator.getAvailableLocales();
        }
        return availableLocales;
    }
}
