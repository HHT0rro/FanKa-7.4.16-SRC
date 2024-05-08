package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.w0;
import java.io.IOException;

/* compiled from: MediaSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface s {

    /* compiled from: MediaSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends q {
        public a(Object obj) {
            super(obj);
        }

        public a c(Object obj) {
            return new a(super.a(obj));
        }

        public a(Object obj, long j10) {
            super(obj, j10);
        }

        public a(Object obj, long j10, int i10) {
            super(obj, j10, i10);
        }

        public a(Object obj, int i10, int i11, long j10) {
            super(obj, i10, i11, j10);
        }

        public a(q qVar) {
            super(qVar);
        }
    }

    /* compiled from: MediaSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a(s sVar, Timeline timeline);
    }

    void a(b bVar, @Nullable o6.v vVar);

    void b(b bVar);

    void c(z zVar);

    w0 d();

    p e(a aVar, o6.b bVar, long j10);

    void f() throws IOException;

    @Nullable
    Timeline g();

    void i(Handler handler, z zVar);

    void j(p pVar);

    void k(b bVar);

    void l(b bVar);

    void p(Handler handler, com.google.android.exoplayer2.drm.b bVar);

    void r(com.google.android.exoplayer2.drm.b bVar);

    boolean s();
}
