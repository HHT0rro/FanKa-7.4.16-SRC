package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b5.w;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.g;
import com.google.android.exoplayer2.extractor.mp4.k;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.huawei.openalliance.ad.constant.bb;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: FrameworkMediaDrm.java */
@RequiresApi(18)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class h implements g {

    /* renamed from: d, reason: collision with root package name */
    public static final g.c f19983d = new g.c() { // from class: b5.y
        @Override // com.google.android.exoplayer2.drm.g.c
        public final com.google.android.exoplayer2.drm.g a(UUID uuid) {
            com.google.android.exoplayer2.drm.g x10;
            x10 = com.google.android.exoplayer2.drm.h.x(uuid);
            return x10;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final UUID f19984a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaDrm f19985b;

    /* renamed from: c, reason: collision with root package name */
    public int f19986c;

    public h(UUID uuid) throws UnsupportedSchemeException {
        com.google.android.exoplayer2.util.a.e(uuid);
        com.google.android.exoplayer2.util.a.b(!com.google.android.exoplayer2.h.f20705b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f19984a = uuid;
        MediaDrm mediaDrm = new MediaDrm(r(uuid));
        this.f19985b = mediaDrm;
        this.f19986c = 1;
        if (com.google.android.exoplayer2.h.f20707d.equals(uuid) && y()) {
            t(mediaDrm);
        }
    }

    public static byte[] n(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        int q10 = parsableByteArray.q();
        short s2 = parsableByteArray.s();
        short s10 = parsableByteArray.s();
        if (s2 == 1 && s10 == 1) {
            short s11 = parsableByteArray.s();
            Charset charset = com.google.common.base.c.f25963e;
            String B = parsableByteArray.B(s11, charset);
            if (B.contains("<LA_URL>")) {
                return bArr;
            }
            int indexOf = B.indexOf("</DATA>");
            if (indexOf == -1) {
                m.h("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
            }
            String substring = B.substring(0, indexOf);
            String substring2 = B.substring(indexOf);
            StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + 26 + String.valueOf(substring2).length());
            sb2.append(substring);
            sb2.append("<LA_URL>https://x</LA_URL>");
            sb2.append(substring2);
            String sb3 = sb2.toString();
            int i10 = q10 + 52;
            ByteBuffer allocate = ByteBuffer.allocate(i10);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putInt(i10);
            allocate.putShort(s2);
            allocate.putShort(s10);
            allocate.putShort((short) (sb3.length() * 2));
            allocate.put(sb3.getBytes(charset));
            return allocate.array();
        }
        m.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
        return bArr;
    }

    public static byte[] o(UUID uuid, byte[] bArr) {
        return com.google.android.exoplayer2.h.f20706c.equals(uuid) ? b5.a.a(bArr) : bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        if ("AFTT".equals(r0) == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] p(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = com.google.android.exoplayer2.h.f20708e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L18
            byte[] r1 = com.google.android.exoplayer2.extractor.mp4.k.e(r4, r3)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r4 = r1
        L10:
            byte[] r4 = n(r4)
            byte[] r4 = com.google.android.exoplayer2.extractor.mp4.k.a(r0, r4)
        L18:
            int r1 = com.google.android.exoplayer2.util.j0.f22990a
            r2 = 23
            if (r1 >= r2) goto L26
            java.util.UUID r1 = com.google.android.exoplayer2.h.f20707d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L58
        L26:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5f
            java.lang.String r0 = com.google.android.exoplayer2.util.j0.f22992c
            java.lang.String r1 = "Amazon"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
            java.lang.String r0 = com.google.android.exoplayer2.util.j0.f22993d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
        L58:
            byte[] r3 = com.google.android.exoplayer2.extractor.mp4.k.e(r4, r3)
            if (r3 == 0) goto L5f
            return r3
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.h.p(java.util.UUID, byte[]):byte[]");
    }

    public static String q(UUID uuid, String str) {
        return (j0.f22990a < 26 && com.google.android.exoplayer2.h.f20706c.equals(uuid) && (bb.Code.equals(str) || "audio/mp4".equals(str))) ? "cenc" : str;
    }

    public static UUID r(UUID uuid) {
        return (j0.f22990a >= 27 || !com.google.android.exoplayer2.h.f20706c.equals(uuid)) ? uuid : com.google.android.exoplayer2.h.f20705b;
    }

    public static void t(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    public static DrmInitData.SchemeData v(UUID uuid, List<DrmInitData.SchemeData> list) {
        boolean z10;
        if (!com.google.android.exoplayer2.h.f20707d.equals(uuid)) {
            return list.get(0);
        }
        if (j0.f22990a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int i10 = 0;
            for (int i11 = 0; i11 < list.size(); i11++) {
                DrmInitData.SchemeData schemeData2 = list.get(i11);
                byte[] bArr = (byte[]) com.google.android.exoplayer2.util.a.e(schemeData2.data);
                if (!j0.c(schemeData2.mimeType, schemeData.mimeType) || !j0.c(schemeData2.licenseServerUrl, schemeData.licenseServerUrl) || !k.c(bArr)) {
                    z10 = false;
                    break;
                }
                i10 += bArr.length;
            }
            z10 = true;
            if (z10) {
                byte[] bArr2 = new byte[i10];
                int i12 = 0;
                for (int i13 = 0; i13 < list.size(); i13++) {
                    byte[] bArr3 = (byte[]) com.google.android.exoplayer2.util.a.e(list.get(i13).data);
                    int length = bArr3.length;
                    System.arraycopy((Object) bArr3, 0, (Object) bArr2, i12, length);
                    i12 += length;
                }
                return schemeData.copyWithData(bArr2);
            }
        }
        for (int i14 = 0; i14 < list.size(); i14++) {
            DrmInitData.SchemeData schemeData3 = list.get(i14);
            int g3 = k.g((byte[]) com.google.android.exoplayer2.util.a.e(schemeData3.data));
            int i15 = j0.f22990a;
            if (i15 < 23 && g3 == 0) {
                return schemeData3;
            }
            if (i15 >= 23 && g3 == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(g.b bVar, MediaDrm mediaDrm, byte[] bArr, int i10, int i11, byte[] bArr2) {
        bVar.a(this, bArr, i10, i11, bArr2);
    }

    public static /* synthetic */ g x(UUID uuid) {
        try {
            return z(uuid);
        } catch (UnsupportedDrmException unused) {
            String valueOf = String.valueOf(uuid);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 53);
            sb2.append("Failed to instantiate a FrameworkMediaDrm for uuid: ");
            sb2.append(valueOf);
            sb2.append(".");
            m.c("FrameworkMediaDrm", sb2.toString());
            return new e();
        }
    }

    public static boolean y() {
        return "ASUS_Z00AD".equals(j0.f22993d);
    }

    public static h z(UUID uuid) throws UnsupportedDrmException {
        try {
            return new h(uuid);
        } catch (UnsupportedSchemeException e2) {
            throw new UnsupportedDrmException(1, e2);
        } catch (Exception e10) {
            throw new UnsupportedDrmException(2, e10);
        }
    }

    @Override // com.google.android.exoplayer2.drm.g
    public Class<w> a() {
        return w.class;
    }

    @Override // com.google.android.exoplayer2.drm.g
    public Map<String, String> b(byte[] bArr) {
        return this.f19985b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public g.d c() {
        MediaDrm.ProvisionRequest provisionRequest = this.f19985b.getProvisionRequest();
        return new g.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.g
    public byte[] d() throws MediaDrmException {
        return this.f19985b.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void e(byte[] bArr, byte[] bArr2) {
        this.f19985b.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void f(@Nullable final g.b bVar) {
        this.f19985b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: b5.x
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i10, int i11, byte[] bArr2) {
                com.google.android.exoplayer2.drm.h.this.w(bVar, mediaDrm, bArr, i10, i11, bArr2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.g
    @Nullable
    public byte[] g(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (com.google.android.exoplayer2.h.f20706c.equals(this.f19984a)) {
            bArr2 = b5.a.b(bArr2);
        }
        return this.f19985b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void i(byte[] bArr) throws DeniedByServerException {
        this.f19985b.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void j(byte[] bArr) {
        this.f19985b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public g.a k(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i10, @Nullable HashMap<String, String> hashMap) throws NotProvisionedException {
        byte[] bArr2;
        String str;
        DrmInitData.SchemeData schemeData = null;
        if (list != null) {
            schemeData = v(this.f19984a, list);
            bArr2 = p(this.f19984a, (byte[]) com.google.android.exoplayer2.util.a.e(schemeData.data));
            str = q(this.f19984a, schemeData.mimeType);
        } else {
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f19985b.getKeyRequest(bArr, bArr2, str, i10, hashMap);
        byte[] o10 = o(this.f19984a, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeData != null && !TextUtils.isEmpty(schemeData.licenseServerUrl)) {
            defaultUrl = schemeData.licenseServerUrl;
        }
        return new g.a(o10, defaultUrl, j0.f22990a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public synchronized void release() {
        int i10 = this.f19986c - 1;
        this.f19986c = i10;
        if (i10 == 0) {
            this.f19985b.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.g
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public w h(byte[] bArr) throws MediaCryptoException {
        return new w(r(this.f19984a), bArr, j0.f22990a < 21 && com.google.android.exoplayer2.h.f20707d.equals(this.f19984a) && "L3".equals(u("securityLevel")));
    }

    public String u(String str) {
        return this.f19985b.getPropertyString(str);
    }
}
