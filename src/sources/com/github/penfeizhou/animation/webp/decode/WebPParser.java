package com.github.penfeizhou.animation.webp.decode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class WebPParser {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class FormatException extends IOException {
        public FormatException() {
            super("WebP Format error");
        }
    }

    public static List<e> a(j4.a aVar) throws IOException {
        if (aVar.i("RIFF")) {
            aVar.skip(4L);
            if (aVar.i("WEBP")) {
                ArrayList arrayList = new ArrayList();
                while (aVar.available() > 0) {
                    arrayList.add(b(aVar));
                }
                return arrayList;
            }
            throw new FormatException();
        }
        throw new FormatException();
    }

    public static e b(j4.a aVar) throws IOException {
        e eVar;
        int b4 = aVar.b();
        int e2 = aVar.e();
        int h10 = aVar.h();
        if (k.f19289g == e2) {
            eVar = new k();
        } else if (b.f19262f == e2) {
            eVar = new b();
        } else if (c.f19265m == e2) {
            eVar = new c();
        } else if (a.f19261d == e2) {
            eVar = new a();
        } else if (i.f19287d == e2) {
            eVar = new i();
        } else if (j.f19288d == e2) {
            eVar = new j();
        } else if (g.f19286d == e2) {
            eVar = new g();
        } else if (m.f19298d == e2) {
            eVar = new m();
        } else if (f.f19285d == e2) {
            eVar = new f();
        } else {
            eVar = new e();
        }
        eVar.f19282a = e2;
        eVar.f19283b = h10;
        eVar.f19284c = b4;
        eVar.c(aVar);
        return eVar;
    }
}
