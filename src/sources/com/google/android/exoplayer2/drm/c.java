package com.google.android.exoplayer2.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import b5.r;
import b5.v;
import b5.z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.b;

/* compiled from: DrmSessionManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f19974a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final c f19975b;

    /* compiled from: DrmSessionManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class a implements c {
        @Override // com.google.android.exoplayer2.drm.c
        @Nullable
        public DrmSession a(Looper looper, @Nullable b.a aVar, Format format) {
            if (format.f19547p == null) {
                return null;
            }
            return new f(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ b b(Looper looper, b.a aVar, Format format) {
            return r.a(this, looper, aVar, format);
        }

        @Override // com.google.android.exoplayer2.drm.c
        @Nullable
        public Class<z> c(Format format) {
            if (format.f19547p != null) {
                return z.class;
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ void prepare() {
            r.b(this);
        }

        @Override // com.google.android.exoplayer2.drm.c
        public /* synthetic */ void release() {
            r.c(this);
        }
    }

    /* compiled from: DrmSessionManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f19976a = new b() { // from class: b5.s
            @Override // com.google.android.exoplayer2.drm.c.b
            public final void release() {
                t.a();
            }
        };

        void release();
    }

    static {
        a aVar = new a();
        f19974a = aVar;
        f19975b = aVar;
    }

    @Nullable
    DrmSession a(Looper looper, @Nullable b.a aVar, Format format);

    b b(Looper looper, @Nullable b.a aVar, Format format);

    @Nullable
    Class<? extends v> c(Format format);

    void prepare();

    void release();
}
