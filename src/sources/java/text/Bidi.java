package java.text;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public final class Bidi {
    public static final int DIRECTION_DEFAULT_LEFT_TO_RIGHT = -2;
    public static final int DIRECTION_DEFAULT_RIGHT_TO_LEFT = -1;
    public static final int DIRECTION_LEFT_TO_RIGHT = 0;
    public static final int DIRECTION_RIGHT_TO_LEFT = 1;
    private final android.icu.text.Bidi bidiBase;

    private static int translateConstToIcu(int javaInt) {
        switch (javaInt) {
            case -2:
                return 126;
            case -1:
                return 127;
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return 0;
        }
    }

    public Bidi(String paragraph, int flags) {
        if (paragraph == null) {
            throw new IllegalArgumentException("paragraph is null");
        }
        this.bidiBase = new android.icu.text.Bidi(paragraph.toCharArray(), 0, null, 0, paragraph.length(), translateConstToIcu(flags));
    }

    public Bidi(AttributedCharacterIterator paragraph) {
        if (paragraph == null) {
            throw new IllegalArgumentException("paragraph is null");
        }
        this.bidiBase = new android.icu.text.Bidi(paragraph);
    }

    public Bidi(char[] text, int textStart, byte[] embeddings, int embStart, int paragraphLength, int flags) {
        if (text == null) {
            throw new IllegalArgumentException("text is null");
        }
        if (paragraphLength < 0) {
            throw new IllegalArgumentException("bad length: " + paragraphLength);
        }
        if (textStart < 0 || paragraphLength > text.length - textStart) {
            throw new IllegalArgumentException("bad range: " + textStart + " length: " + paragraphLength + " for text of length: " + text.length);
        }
        if (embeddings != null && (embStart < 0 || paragraphLength > embeddings.length - embStart)) {
            throw new IllegalArgumentException("bad range: " + embStart + " length: " + paragraphLength + " for embeddings of length: " + text.length);
        }
        this.bidiBase = new android.icu.text.Bidi(text, textStart, embeddings, embStart, paragraphLength, translateConstToIcu(flags));
    }

    private Bidi(android.icu.text.Bidi bidiBase) {
        this.bidiBase = bidiBase;
    }

    public Bidi createLineBidi(int lineStart, int lineLimit) {
        if (lineStart < 0 || lineLimit < 0 || lineStart > lineLimit || lineLimit > getLength()) {
            throw new IllegalArgumentException("Invalid ranges (start=" + lineStart + ", limit=" + lineLimit + ", length=" + getLength() + ")");
        }
        if (lineStart == lineLimit) {
            return new Bidi(new android.icu.text.Bidi(new char[0], 0, new byte[0], 0, 0, translateConstToIcu(0)));
        }
        return new Bidi(this.bidiBase.createLineBidi(lineStart, lineLimit));
    }

    public boolean isMixed() {
        return this.bidiBase.isMixed();
    }

    public boolean isLeftToRight() {
        return this.bidiBase.isLeftToRight();
    }

    public boolean isRightToLeft() {
        return this.bidiBase.isRightToLeft();
    }

    public int getLength() {
        return this.bidiBase.getLength();
    }

    public boolean baseIsLeftToRight() {
        return this.bidiBase.baseIsLeftToRight();
    }

    public int getBaseLevel() {
        return this.bidiBase.getParaLevel();
    }

    public int getLevelAt(int offset) {
        try {
            return this.bidiBase.getLevelAt(offset);
        } catch (IllegalArgumentException e2) {
            return getBaseLevel();
        }
    }

    public int getRunCount() {
        int runCount = this.bidiBase.countRuns();
        if (runCount == 0) {
            return 1;
        }
        return runCount;
    }

    public int getRunLevel(int run) {
        if (run == getRunCount()) {
            return getBaseLevel();
        }
        return this.bidiBase.countRuns() == 0 ? this.bidiBase.getBaseLevel() : this.bidiBase.getRunLevel(run);
    }

    public int getRunStart(int run) {
        if (run == getRunCount()) {
            return getBaseLevel();
        }
        if (this.bidiBase.countRuns() == 0) {
            return 0;
        }
        return this.bidiBase.getRunStart(run);
    }

    public int getRunLimit(int run) {
        if (run == getRunCount()) {
            return getBaseLevel();
        }
        return this.bidiBase.countRuns() == 0 ? this.bidiBase.getLength() : this.bidiBase.getRunLimit(run);
    }

    public static boolean requiresBidi(char[] text, int start, int limit) {
        if (start < 0 || start > limit || limit > text.length) {
            throw new IllegalArgumentException("Value start " + start + " is out of range 0 to " + limit);
        }
        return android.icu.text.Bidi.requiresBidi(text, start, limit);
    }

    public static void reorderVisually(byte[] levels, int levelStart, Object[] objects, int objectStart, int count) {
        if (levelStart < 0 || levels.length <= levelStart) {
            throw new IllegalArgumentException("Value levelStart " + levelStart + " is out of range 0 to " + (levels.length - 1));
        }
        if (objectStart < 0 || objects.length <= objectStart) {
            throw new IllegalArgumentException("Value objectStart " + levelStart + " is out of range 0 to " + (objects.length - 1));
        }
        if (count < 0 || objects.length < objectStart + count) {
            throw new IllegalArgumentException("Value count " + levelStart + " is out of range 0 to " + (objects.length - objectStart));
        }
        android.icu.text.Bidi.reorderVisually(levels, levelStart, objects, objectStart, count);
    }

    public String toString() {
        return getClass().getName() + "[direction: " + ((int) this.bidiBase.getDirection()) + " baseLevel: " + this.bidiBase.getBaseLevel() + " length: " + this.bidiBase.getLength() + " runs: " + this.bidiBase.getRunCount() + "]";
    }
}
