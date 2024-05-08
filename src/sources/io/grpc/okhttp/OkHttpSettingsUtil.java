package io.grpc.okhttp;

import io.grpc.okhttp.internal.framed.Settings;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
class OkHttpSettingsUtil {
    public static final int ENABLE_PUSH = 2;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_HEADER_LIST_SIZE = 6;

    public static int get(Settings settings, int i10) {
        return settings.get(i10);
    }

    public static boolean isSet(Settings settings, int i10) {
        return settings.isSet(i10);
    }

    public static void set(Settings settings, int i10, int i11) {
        settings.set(i10, 0, i11);
    }
}
