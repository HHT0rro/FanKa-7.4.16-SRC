package com.bytedance.pangle.util.b.a;

import com.android.internal.logging.nano.MetricsProto;
import com.bytedance.pangle.util.b.b.d;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {
    public static void a(d dVar, ByteArrayOutputStream byteArrayOutputStream) {
        List<com.bytedance.pangle.util.b.b.c> list;
        com.bytedance.pangle.util.b.b.a aVar = dVar.f10988a;
        if (aVar == null || (list = aVar.f10975a) == null || list.size() <= 0) {
            return;
        }
        for (com.bytedance.pangle.util.b.b.c cVar : dVar.f10988a.f10975a) {
            c cVar2 = dVar.f10990c;
            if (cVar != null) {
                byte[] bArr = {0, 0};
                cVar2.a((OutputStream) byteArrayOutputStream, 33639248);
                cVar2.a(byteArrayOutputStream, 0);
                cVar2.a(byteArrayOutputStream, 0);
                cVar2.a(byteArrayOutputStream, 0);
                cVar2.a(byteArrayOutputStream, cVar.f10978a);
                cVar2.a(byteArrayOutputStream, 2081);
                cVar2.a(byteArrayOutputStream, MetricsProto.MetricsEvent.DIALOG_LEGACY_VPN_CONFIG);
                cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f10979b);
                cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f10980c);
                cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f10981d);
                byte[] bArr2 = new byte[0];
                String str = cVar.f10985h;
                if (str != null && str.trim().length() > 0) {
                    bArr2 = cVar.f10985h.getBytes(Charset.forName("UTF-8"));
                }
                cVar2.a(byteArrayOutputStream, bArr2.length);
                int i10 = cVar.f10983f;
                cVar2.a(byteArrayOutputStream, i10);
                cVar2.a(byteArrayOutputStream, 0);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr);
                cVar2.a((OutputStream) byteArrayOutputStream, (int) cVar.f10986i);
                if (bArr2.length > 0) {
                    byteArrayOutputStream.write(bArr2);
                }
                if (i10 > 0) {
                    byteArrayOutputStream.write(new byte[i10]);
                }
            } else {
                throw new IOException("input parameters is null, cannot write local file header");
            }
        }
    }
}
