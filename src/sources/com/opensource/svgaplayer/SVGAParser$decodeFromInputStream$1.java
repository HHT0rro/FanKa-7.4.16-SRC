package com.opensource.svgaplayer;

import com.opensource.svgaplayer.SVGAParser;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.p;

/* compiled from: SVGAParser.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class SVGAParser$decodeFromInputStream$1 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SVGAParser f37917b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ InputStream f37918c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f37919d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SVGAParser.c f37920e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f37921f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ SVGAParser.d f37922g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ boolean f37923h;

    /* compiled from: SVGAParser.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f37924b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ SVGAParser$decodeFromInputStream$1 f37925c;

        public a(byte[] bArr, SVGAParser$decodeFromInputStream$1 sVGAParser$decodeFromInputStream$1) {
            this.f37924b = bArr;
            this.f37925c = sVGAParser$decodeFromInputStream$1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            File e2 = SVGACache.f37881c.e(this.f37925c.f37919d);
            try {
                File file = e2.exists() ^ true ? e2 : null;
                if (file != null) {
                    file.createNewFile();
                }
                new FileOutputStream(e2).write(this.f37924b);
                p pVar = p.f51048a;
            } catch (Exception e10) {
                ub.c.f54010a.c("SVGAParser", "create cache file fail.", e10);
                e2.delete();
            }
        }
    }

    public SVGAParser$decodeFromInputStream$1(SVGAParser sVGAParser, InputStream inputStream, String str, SVGAParser.c cVar, String str2, SVGAParser.d dVar, boolean z10) {
        this.f37917b = sVGAParser;
        this.f37918c = inputStream;
        this.f37919d = str;
        this.f37920e = cVar;
        this.f37921f = str2;
        this.f37922g = dVar;
        this.f37923h = z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
    
        if (r3 != false) goto L10;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opensource.svgaplayer.SVGAParser$decodeFromInputStream$1.run():void");
    }
}
