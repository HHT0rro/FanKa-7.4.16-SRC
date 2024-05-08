package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import o6.v;

/* compiled from: DataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface a extends o6.g {

    /* compiled from: DataSource.java */
    /* renamed from: com.google.android.exoplayer2.upstream.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface InterfaceC0208a {
        a a();
    }

    long a(b bVar) throws IOException;

    void close() throws IOException;

    void d(v vVar);

    Map<String, List<String>> e();

    @Nullable
    Uri i();
}
