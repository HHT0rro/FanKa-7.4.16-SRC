package com.opensource.svgaplayer;

import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.proto.MovieEntity;
import java.io.File;
import java.io.FileInputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;

/* compiled from: SVGAParser.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class SVGAParser$decodeFromSVGAFileCacheKey$1 implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SVGAParser f37926b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f37927c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f37928d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ SVGAParser.c f37929e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ SVGAParser.d f37930f;

    public SVGAParser$decodeFromSVGAFileCacheKey$1(SVGAParser sVGAParser, String str, String str2, SVGAParser.c cVar, SVGAParser.d dVar) {
        this.f37926b = sVGAParser;
        this.f37927c = str;
        this.f37928d = str2;
        this.f37929e = cVar;
        this.f37930f = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ub.c cVar;
        StringBuilder sb2;
        byte[] B;
        boolean A;
        byte[] w3;
        int i10;
        int i11;
        try {
            try {
                cVar = ub.c.f54010a;
                cVar.e("SVGAParser", "================ decode " + this.f37927c + " from svga cachel file to entity ================");
                FileInputStream fileInputStream = new FileInputStream(SVGACache.f37881c.e(this.f37928d));
                try {
                    B = this.f37926b.B(fileInputStream);
                    if (B != null) {
                        A = this.f37926b.A(B);
                        if (A) {
                            this.f37926b.p(this.f37928d, this.f37929e, this.f37927c);
                        } else {
                            cVar.e("SVGAParser", "inflate start");
                            w3 = this.f37926b.w(B);
                            if (w3 != null) {
                                cVar.e("SVGAParser", "inflate complete");
                                MovieEntity decode = MovieEntity.ADAPTER.decode(w3);
                                s.e(decode, "MovieEntity.ADAPTER.decode(it)");
                                File file = new File(this.f37928d);
                                i10 = this.f37926b.f37907b;
                                i11 = this.f37926b.f37908c;
                                final SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity(decode, file, i10, i11);
                                cVar.e("SVGAParser", "SVGAVideoEntity prepare start");
                                sVGAVideoEntity.u(new Function0<p>() { // from class: com.opensource.svgaplayer.SVGAParser$decodeFromSVGAFileCacheKey$1$$special$$inlined$use$lambda$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ p invoke() {
                                        invoke2();
                                        return p.f51048a;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        ub.c.f54010a.e("SVGAParser", "SVGAVideoEntity prepare success");
                                        SVGAParser$decodeFromSVGAFileCacheKey$1 sVGAParser$decodeFromSVGAFileCacheKey$1 = this;
                                        sVGAParser$decodeFromSVGAFileCacheKey$1.f37926b.y(SVGAVideoEntity.this, sVGAParser$decodeFromSVGAFileCacheKey$1.f37929e, sVGAParser$decodeFromSVGAFileCacheKey$1.f37927c);
                                    }
                                }, this.f37930f);
                            } else {
                                this.f37926b.z(new Exception("inflate(bytes) cause exception"), this.f37929e, this.f37927c);
                            }
                        }
                    } else {
                        this.f37926b.z(new Exception("readAsBytes(inputStream) cause exception"), this.f37929e, this.f37927c);
                    }
                    p pVar = p.f51048a;
                    kotlin.io.b.a(fileInputStream, null);
                    sb2 = new StringBuilder();
                } finally {
                }
            } catch (Exception e2) {
                this.f37926b.z(e2, this.f37929e, this.f37927c);
                cVar = ub.c.f54010a;
                sb2 = new StringBuilder();
            }
            sb2.append("================ decode ");
            sb2.append(this.f37927c);
            sb2.append(" from svga cachel file to entity end ================");
            cVar.e("SVGAParser", sb2.toString());
        } catch (Throwable th) {
            ub.c.f54010a.e("SVGAParser", "================ decode " + this.f37927c + " from svga cachel file to entity end ================");
            throw th;
        }
    }
}
