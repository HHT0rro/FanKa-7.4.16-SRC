package com.google.protobuf;

import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY = new TextFormatParseLocation(-1, -1);
    private final int column;
    private final int line;

    private TextFormatParseLocation(int i10, int i11) {
        this.line = i10;
        this.column = i11;
    }

    public static TextFormatParseLocation create(int i10, int i11) {
        if (i10 == -1 && i11 == -1) {
            return EMPTY;
        }
        if (i10 >= 0 && i11 >= 0) {
            return new TextFormatParseLocation(i10, i11);
        }
        throw new IllegalArgumentException(String.format("line and column values must be >= 0: line %d, column: %d", Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TextFormatParseLocation)) {
            return false;
        }
        TextFormatParseLocation textFormatParseLocation = (TextFormatParseLocation) obj;
        return this.line == textFormatParseLocation.getLine() && this.column == textFormatParseLocation.getColumn();
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int hashCode() {
        return Arrays.hashCode(new int[]{this.line, this.column});
    }

    public String toString() {
        return String.format("ParseLocation{line=%d, column=%d}", Integer.valueOf(this.line), Integer.valueOf(this.column));
    }
}
