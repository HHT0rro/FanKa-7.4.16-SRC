package androidx.tracing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: Access modifiers changed from: package-private */
@RequiresApi(29)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String str, int i10) {
        android.os.Trace.beginAsyncSection(str, i10);
    }

    public static void endAsyncSection(@NonNull String str, int i10) {
        android.os.Trace.endAsyncSection(str, i10);
    }

    public static void setCounter(@NonNull String str, int i10) {
        android.os.Trace.setCounter(str, i10);
    }
}
