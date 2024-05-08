package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class i8 extends x4<i8, a> implements e6 {
    private static final i8 zze;
    private static volatile o6<i8> zzf;
    private byte zzd = 2;
    private g5<zzmt> zzc = x4.w();

    /* compiled from: com.google.android.gms:play-services-vision-face-contour-internal@@16.1.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a extends x4.b<i8, a> implements e6 {
        public a() {
            super(i8.zze);
        }

        public /* synthetic */ a(h8 h8Var) {
            this();
        }
    }

    static {
        i8 i8Var = new i8();
        zze = i8Var;
        x4.q(i8.class, i8Var);
    }

    public static i8 A() {
        return zze;
    }

    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.o6<com.google.android.gms.internal.vision.i8>, com.google.android.gms.internal.vision.x4$a] */
    @Override // com.google.android.gms.internal.vision.x4
    public final Object n(int i10, Object obj, Object obj2) {
        o6<i8> o6Var;
        h8 h8Var = null;
        switch (h8.f25508a[i10 - 1]) {
            case 1:
                return new i8();
            case 2:
                return new a(h8Var);
            case 3:
                return x4.o(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzc", zzmt.class});
            case 4:
                return zze;
            case 5:
                o6<i8> o6Var2 = zzf;
                o6<i8> o6Var3 = o6Var2;
                if (o6Var2 == null) {
                    synchronized (i8.class) {
                        o6<i8> o6Var4 = zzf;
                        o6Var = o6Var4;
                        if (o6Var4 == null) {
                            ?? aVar = new x4.a(zze);
                            zzf = aVar;
                            o6Var = aVar;
                        }
                    }
                    o6Var3 = o6Var;
                }
                return o6Var3;
            case 6:
                return Byte.valueOf(this.zzd);
            case 7:
                this.zzd = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzmt x(int i10) {
        return this.zzc.get(i10);
    }

    public final List<zzmt> y() {
        return this.zzc;
    }

    public final int z() {
        return this.zzc.size();
    }
}
