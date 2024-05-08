package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.m;
import java.io.IOException;

/* compiled from: LoadErrorHandlingPolicy.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface h {

    /* compiled from: LoadErrorHandlingPolicy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f22886a;

        /* renamed from: b, reason: collision with root package name */
        public final int f22887b;

        /* renamed from: c, reason: collision with root package name */
        public final int f22888c;

        /* renamed from: d, reason: collision with root package name */
        public final int f22889d;

        public a(int i10, int i11, int i12, int i13) {
            this.f22886a = i10;
            this.f22887b = i11;
            this.f22888c = i12;
            this.f22889d = i13;
        }

        public boolean a(int i10) {
            if (i10 == 1) {
                if (this.f22886a - this.f22887b <= 1) {
                    return false;
                }
            } else if (this.f22888c - this.f22889d <= 1) {
                return false;
            }
            return true;
        }
    }

    /* compiled from: LoadErrorHandlingPolicy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f22890a;

        /* renamed from: b, reason: collision with root package name */
        public final long f22891b;

        public b(int i10, long j10) {
            com.google.android.exoplayer2.util.a.a(j10 >= 0);
            this.f22890a = i10;
            this.f22891b = j10;
        }
    }

    /* compiled from: LoadErrorHandlingPolicy.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final m f22892a;

        /* renamed from: b, reason: collision with root package name */
        public final MediaLoadData f22893b;

        /* renamed from: c, reason: collision with root package name */
        public final IOException f22894c;

        /* renamed from: d, reason: collision with root package name */
        public final int f22895d;

        public c(m mVar, MediaLoadData mediaLoadData, IOException iOException, int i10) {
            this.f22892a = mVar;
            this.f22893b = mediaLoadData;
            this.f22894c = iOException;
            this.f22895d = i10;
        }
    }

    long a(c cVar);

    @Nullable
    b b(a aVar, c cVar);

    void c(long j10);

    int d(int i10);
}
