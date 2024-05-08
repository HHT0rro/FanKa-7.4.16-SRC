package com.google.android.exoplayer2.source.rtsp;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.rtsp.g;
import java.io.IOException;

/* compiled from: RtpDataChannel.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a extends com.google.android.exoplayer2.upstream.a {

    /* compiled from: RtpDataChannel.java */
    /* renamed from: com.google.android.exoplayer2.source.rtsp.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface InterfaceC0200a {
        @Nullable
        InterfaceC0200a a();

        a b(int i10) throws IOException;
    }

    int c();

    String k();

    @Nullable
    g.b p();
}
