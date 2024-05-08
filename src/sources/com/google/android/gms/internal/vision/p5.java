package com.google.android.gms.internal.vision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class p5 extends n5 {

    /* renamed from: c, reason: collision with root package name */
    public static final Class<?> f25582c = Collections.unmodifiableList(Collections.emptyList()).getClass();

    public p5() {
        super();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <L> List<L> e(Object obj, long j10, int i10) {
        l5 l5Var;
        List<L> arrayList;
        List<L> f10 = f(obj, j10);
        if (f10.isEmpty()) {
            if (f10 instanceof o5) {
                arrayList = new l5(i10);
            } else if ((f10 instanceof n6) && (f10 instanceof g5)) {
                arrayList = ((g5) f10).zza(i10);
            } else {
                arrayList = new ArrayList<>(i10);
            }
            p7.j(obj, j10, arrayList);
            return arrayList;
        }
        if (f25582c.isAssignableFrom(f10.getClass())) {
            ArrayList arrayList2 = new ArrayList(f10.size() + i10);
            arrayList2.addAll(f10);
            p7.j(obj, j10, arrayList2);
            l5Var = arrayList2;
        } else if (f10 instanceof o7) {
            l5 l5Var2 = new l5(f10.size() + i10);
            l5Var2.addAll((o7) f10);
            p7.j(obj, j10, l5Var2);
            l5Var = l5Var2;
        } else {
            if (!(f10 instanceof n6) || !(f10 instanceof g5)) {
                return f10;
            }
            g5 g5Var = (g5) f10;
            if (g5Var.zza()) {
                return f10;
            }
            g5 zza = g5Var.zza(f10.size() + i10);
            p7.j(obj, j10, zza);
            return zza;
        }
        return l5Var;
    }

    public static <E> List<E> f(Object obj, long j10) {
        return (List) p7.F(obj, j10);
    }

    @Override // com.google.android.gms.internal.vision.n5
    public final <E> void b(Object obj, Object obj2, long j10) {
        List f10 = f(obj2, j10);
        List e2 = e(obj, j10, f10.size());
        int size = e2.size();
        int size2 = f10.size();
        if (size > 0 && size2 > 0) {
            e2.addAll(f10);
        }
        if (size > 0) {
            f10 = e2;
        }
        p7.j(obj, j10, f10);
    }

    @Override // com.google.android.gms.internal.vision.n5
    public final void d(Object obj, long j10) {
        Object unmodifiableList;
        List list = (List) p7.F(obj, j10);
        if (list instanceof o5) {
            unmodifiableList = ((o5) list).zze();
        } else {
            if (f25582c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof n6) && (list instanceof g5)) {
                g5 g5Var = (g5) list;
                if (g5Var.zza()) {
                    g5Var.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        p7.j(obj, j10, unmodifiableList);
    }
}
