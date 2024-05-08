package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import b5.v;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: ExoMediaDrm.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface g {

    /* compiled from: ExoMediaDrm.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f19978a;

        /* renamed from: b, reason: collision with root package name */
        public final String f19979b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19980c;

        public a(byte[] bArr, String str, int i10) {
            this.f19978a = bArr;
            this.f19979b = str;
            this.f19980c = i10;
        }

        public byte[] a() {
            return this.f19978a;
        }

        public String b() {
            return this.f19979b;
        }
    }

    /* compiled from: ExoMediaDrm.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        void a(g gVar, @Nullable byte[] bArr, int i10, int i11, @Nullable byte[] bArr2);
    }

    /* compiled from: ExoMediaDrm.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        g a(UUID uuid);
    }

    /* compiled from: ExoMediaDrm.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final byte[] f19981a;

        /* renamed from: b, reason: collision with root package name */
        public final String f19982b;

        public d(byte[] bArr, String str) {
            this.f19981a = bArr;
            this.f19982b = str;
        }

        public byte[] a() {
            return this.f19981a;
        }

        public String b() {
            return this.f19982b;
        }
    }

    Class<? extends v> a();

    Map<String, String> b(byte[] bArr);

    d c();

    byte[] d() throws MediaDrmException;

    void e(byte[] bArr, byte[] bArr2);

    void f(@Nullable b bVar);

    @Nullable
    byte[] g(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException;

    v h(byte[] bArr) throws MediaCryptoException;

    void i(byte[] bArr) throws DeniedByServerException;

    void j(byte[] bArr);

    a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i10, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException;

    void release();
}
