package com.github.penfeizhou.animation.webp.decode;

import android.text.TextUtils;
import java.io.IOException;

/* compiled from: BaseChunk.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f19282a;

    /* renamed from: b, reason: collision with root package name */
    public int f19283b;

    /* renamed from: c, reason: collision with root package name */
    public int f19284c;

    public static int a(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 4) {
            return -1159790593;
        }
        return ((str.charAt(3) & 255) << 24) | (str.charAt(0) & 255) | ((str.charAt(1) & 255) << 8) | ((str.charAt(2) & 255) << 16);
    }

    public void b(j4.a aVar) throws IOException {
    }

    public final void c(j4.a aVar) throws IOException {
        int available = aVar.available();
        b(aVar);
        int available2 = available - aVar.available();
        int i10 = this.f19283b;
        int i11 = i10 + (i10 & 1);
        if (available2 > i11) {
            throw new IOException("Out of chunk area");
        }
        if (available2 < i11) {
            aVar.skip(i11 - available2);
        }
    }
}
