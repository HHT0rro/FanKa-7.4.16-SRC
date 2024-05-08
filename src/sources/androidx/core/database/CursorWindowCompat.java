package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class CursorWindowCompat {

    @RequiresApi(15)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        public static CursorWindow createCursorWindow(String str) {
            return new CursorWindow(str);
        }
    }

    @RequiresApi(28)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static CursorWindow createCursorWindow(String str, long j10) {
            return new CursorWindow(str, j10);
        }
    }

    private CursorWindowCompat() {
    }

    @NonNull
    public static CursorWindow create(@Nullable String str, long j10) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createCursorWindow(str, j10);
        }
        return Api15Impl.createCursorWindow(str);
    }
}
