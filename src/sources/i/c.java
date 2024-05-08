package i;

import java.util.Arrays;
import java.util.List;

/* compiled from: AnimatableGradientColorValue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c extends n<j.c, j.c> {
    public c(List<o.a<j.c>> list) {
        super(e(list));
    }

    public static o.a<j.c> d(o.a<j.c> aVar) {
        j.c cVar = aVar.f52211b;
        j.c cVar2 = aVar.f52212c;
        if (cVar == null || cVar2 == null || cVar.d().length == cVar2.d().length) {
            return aVar;
        }
        float[] f10 = f(cVar.d(), cVar2.d());
        return aVar.b(cVar.a(f10), cVar2.a(f10));
    }

    public static List<o.a<j.c>> e(List<o.a<j.c>> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            list.set(i10, d(list.get(i10)));
        }
        return list;
    }

    public static float[] f(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy((Object) fArr, 0, (Object) fArr3, 0, fArr.length);
        System.arraycopy((Object) fArr2, 0, (Object) fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f10 = Float.NaN;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (fArr3[i11] != f10) {
                fArr3[i10] = fArr3[i11];
                i10++;
                f10 = fArr3[i11];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i10);
    }

    @Override // i.m
    public f.a<j.c, j.c> a() {
        return new f.e(this.f49672a);
    }

    @Override // i.n, i.m
    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    @Override // i.n, i.m
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    @Override // i.n
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
