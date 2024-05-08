package m;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: DropShadowEffectParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class k {

    /* renamed from: f, reason: collision with root package name */
    public static final JsonReader.a f51748f = JsonReader.a.a("ef");

    /* renamed from: g, reason: collision with root package name */
    public static final JsonReader.a f51749g = JsonReader.a.a("nm", com.kuaishou.weapon.p0.t.f36218c);

    /* renamed from: a, reason: collision with root package name */
    public i.a f51750a;

    /* renamed from: b, reason: collision with root package name */
    public i.b f51751b;

    /* renamed from: c, reason: collision with root package name */
    public i.b f51752c;

    /* renamed from: d, reason: collision with root package name */
    public i.b f51753d;

    /* renamed from: e, reason: collision with root package name */
    public i.b f51754e;

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0052, code lost:
    
        if (r0.equals("Opacity") == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.airbnb.lottie.parser.moshi.JsonReader r6, com.airbnb.lottie.LottieComposition r7) throws java.io.IOException {
        /*
            r5 = this;
            r6.d()
            java.lang.String r0 = ""
        L5:
            boolean r1 = r6.i()
            if (r1 == 0) goto L90
            com.airbnb.lottie.parser.moshi.JsonReader$a r1 = m.k.f51749g
            int r1 = r6.y(r1)
            if (r1 == 0) goto L8a
            r2 = 1
            if (r1 == r2) goto L1d
            r6.z()
            r6.A()
            goto L5
        L1d:
            r0.hashCode()
            r1 = -1
            int r3 = r0.hashCode()
            r4 = 0
            switch(r3) {
                case 353103893: goto L55;
                case 397447147: goto L4c;
                case 1041377119: goto L41;
                case 1379387491: goto L36;
                case 1383710113: goto L2b;
                default: goto L29;
            }
        L29:
            r2 = -1
            goto L5f
        L2b:
            java.lang.String r2 = "Softness"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L34
            goto L29
        L34:
            r2 = 4
            goto L5f
        L36:
            java.lang.String r2 = "Shadow Color"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L3f
            goto L29
        L3f:
            r2 = 3
            goto L5f
        L41:
            java.lang.String r2 = "Direction"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L4a
            goto L29
        L4a:
            r2 = 2
            goto L5f
        L4c:
            java.lang.String r3 = "Opacity"
            boolean r3 = r0.equals(r3)
            if (r3 != 0) goto L5f
            goto L29
        L55:
            java.lang.String r2 = "Distance"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L5e
            goto L29
        L5e:
            r2 = 0
        L5f:
            switch(r2) {
                case 0: goto L82;
                case 1: goto L7b;
                case 2: goto L74;
                case 3: goto L6d;
                case 4: goto L66;
                default: goto L62;
            }
        L62:
            r6.A()
            goto L5
        L66:
            i.b r1 = m.d.e(r6, r7)
            r5.f51754e = r1
            goto L5
        L6d:
            i.a r1 = m.d.c(r6, r7)
            r5.f51750a = r1
            goto L5
        L74:
            i.b r1 = m.d.f(r6, r7, r4)
            r5.f51752c = r1
            goto L5
        L7b:
            i.b r1 = m.d.f(r6, r7, r4)
            r5.f51751b = r1
            goto L5
        L82:
            i.b r1 = m.d.e(r6, r7)
            r5.f51753d = r1
            goto L5
        L8a:
            java.lang.String r0 = r6.r()
            goto L5
        L90:
            r6.f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m.k.a(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):void");
    }

    @Nullable
    public j b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        i.b bVar;
        i.b bVar2;
        i.b bVar3;
        i.b bVar4;
        while (jsonReader.i()) {
            if (jsonReader.y(f51748f) != 0) {
                jsonReader.z();
                jsonReader.A();
            } else {
                jsonReader.b();
                while (jsonReader.i()) {
                    a(jsonReader, lottieComposition);
                }
                jsonReader.e();
            }
        }
        i.a aVar = this.f51750a;
        if (aVar == null || (bVar = this.f51751b) == null || (bVar2 = this.f51752c) == null || (bVar3 = this.f51753d) == null || (bVar4 = this.f51754e) == null) {
            return null;
        }
        return new j(aVar, bVar, bVar2, bVar3, bVar4);
    }
}
