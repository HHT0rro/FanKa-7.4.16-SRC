package androidx.core.database;

import android.database.Cursor;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Cursor.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class CursorKt {
    @Nullable
    public static final byte[] getBlobOrNull(@NotNull Cursor cursor, int i10) {
        s.i(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return cursor.getBlob(i10);
    }

    @Nullable
    public static final Double getDoubleOrNull(@NotNull Cursor cursor, int i10) {
        s.i(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Double.valueOf(cursor.getDouble(i10));
    }

    @Nullable
    public static final Float getFloatOrNull(@NotNull Cursor cursor, int i10) {
        s.i(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Float.valueOf(cursor.getFloat(i10));
    }

    @Nullable
    public static final Integer getIntOrNull(@NotNull Cursor cursor, int i10) {
        s.i(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Integer.valueOf(cursor.getInt(i10));
    }

    @Nullable
    public static final Long getLongOrNull(@NotNull Cursor cursor, int i10) {
        s.i(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Long.valueOf(cursor.getLong(i10));
    }

    @Nullable
    public static final Short getShortOrNull(@NotNull Cursor cursor, int i10) {
        s.i(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return Short.valueOf(cursor.getShort(i10));
    }

    @Nullable
    public static final String getStringOrNull(@NotNull Cursor cursor, int i10) {
        s.i(cursor, "<this>");
        if (cursor.isNull(i10)) {
            return null;
        }
        return cursor.getString(i10);
    }
}
