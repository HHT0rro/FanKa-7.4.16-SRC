package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import o6.v;

/* compiled from: Aes128DataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a implements com.google.android.exoplayer2.upstream.a {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f21487a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f21488b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f21489c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public CipherInputStream f21490d;

    public a(com.google.android.exoplayer2.upstream.a aVar, byte[] bArr, byte[] bArr2) {
        this.f21487a = aVar;
        this.f21488b = bArr;
        this.f21489c = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        try {
            Cipher n10 = n();
            try {
                n10.init(2, new SecretKeySpec(this.f21488b, AESEncrypt.ALGORITHM), new IvParameterSpec(this.f21489c));
                o6.k kVar = new o6.k(this.f21487a, bVar);
                this.f21490d = new CipherInputStream(kVar, n10);
                kVar.b();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        if (this.f21490d != null) {
            this.f21490d = null;
            this.f21487a.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final void d(v vVar) {
        com.google.android.exoplayer2.util.a.e(vVar);
        this.f21487a.d(vVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final Map<String, List<String>> e() {
        return this.f21487a.e();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public final Uri i() {
        return this.f21487a.i();
    }

    public Cipher n() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // o6.g
    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        com.google.android.exoplayer2.util.a.e(this.f21490d);
        int read = this.f21490d.read(bArr, i10, i11);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
