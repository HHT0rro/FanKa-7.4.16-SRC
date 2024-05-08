package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import b5.v;
import com.google.android.exoplayer2.drm.b;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface DrmSession {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class DrmSessionException extends IOException {
        public final int errorCode;

        public DrmSessionException(Throwable th, int i10) {
            super(th);
            this.errorCode = i10;
        }
    }

    void a(@Nullable b.a aVar);

    boolean b();

    @Nullable
    Map<String, String> c();

    void d(@Nullable b.a aVar);

    UUID e();

    @Nullable
    v f();

    @Nullable
    DrmSessionException getError();

    int getState();
}
