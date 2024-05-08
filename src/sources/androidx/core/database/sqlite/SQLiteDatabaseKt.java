package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SQLiteDatabase.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(@NotNull SQLiteDatabase sQLiteDatabase, boolean z10, @NotNull Function1<? super SQLiteDatabase, ? extends T> body) {
        s.i(sQLiteDatabase, "<this>");
        s.i(body, "body");
        if (z10) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = body.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            r.b(1);
            sQLiteDatabase.endTransaction();
            r.a(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z10, Function1 body, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        s.i(sQLiteDatabase, "<this>");
        s.i(body, "body");
        if (z10) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = body.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            r.b(1);
            sQLiteDatabase.endTransaction();
            r.a(1);
        }
    }
}
