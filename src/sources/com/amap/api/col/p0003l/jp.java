package com.amap.api.col.p0003l;

import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* compiled from: CollectionUploader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class jp {
    public static boolean a(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        byte[] bArr2 = null;
        try {
            kw kwVar = new kw();
            kwVar.f6715b.put("Content-Type", "application/octet-stream");
            kwVar.f6715b.put("aps_c_src", Base64.encodeToString(kw.a().getBytes(), 2));
            kwVar.f6715b.put("aps_c_key", Base64.encodeToString(kw.b().getBytes(), 2));
            kwVar.f6717d = bArr;
            if (jg.f6559a) {
                kwVar.f6714a = "http://cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            } else {
                kwVar.f6714a = (jg.f6560b ? "https://" : "http://") + "cgicol.amap.com/collection/collectData?src=baseCol&ver=v74&";
            }
            kx a10 = kk.b().a(kwVar);
            if (a10 != null && a10.f6719a == 200) {
                bArr2 = a10.f6721c;
            }
            if (bArr2 != null) {
                return "true".equals(new String(bArr2, StandardCharsets.UTF_8));
            }
            return false;
        } catch (Exception e2) {
            kv.a(e2);
            return false;
        }
    }
}
