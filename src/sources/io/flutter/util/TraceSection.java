package io.flutter.util;

import androidx.annotation.NonNull;
import androidx.tracing.Trace;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class TraceSection implements AutoCloseable {
    private TraceSection(String str) {
        begin(str);
    }

    public static void begin(@NonNull String str) {
        Trace.beginSection(cropSectionName(str));
    }

    public static void beginAsyncSection(String str, int i10) {
        Trace.beginAsyncSection(cropSectionName(str), i10);
    }

    private static String cropSectionName(@NonNull String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void end() throws RuntimeException {
        Trace.endSection();
    }

    public static void endAsyncSection(String str, int i10) {
        Trace.endAsyncSection(cropSectionName(str), i10);
    }

    public static TraceSection scoped(String str) {
        return new TraceSection(str);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        end();
    }
}
