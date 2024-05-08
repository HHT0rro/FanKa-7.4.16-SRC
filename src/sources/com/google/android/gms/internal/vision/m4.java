package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.x4;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class m4 extends n4<x4.f> {
    @Override // com.google.android.gms.internal.vision.n4
    public final int a(Map.Entry<?, ?> entry) {
        return ((x4.f) entry.getKey()).f25684c;
    }

    @Override // com.google.android.gms.internal.vision.n4
    public final r4<x4.f> b(Object obj) {
        return ((x4.c) obj).zzc;
    }

    @Override // com.google.android.gms.internal.vision.n4
    public final Object c(l4 l4Var, c6 c6Var, int i10) {
        return l4Var.b(c6Var, i10);
    }

    @Override // com.google.android.gms.internal.vision.n4
    public final void d(z7 z7Var, Map.Entry<?, ?> entry) throws IOException {
        x4.f fVar = (x4.f) entry.getKey();
        if (fVar.f25686e) {
            switch (p4.f25581a[fVar.f25685d.ordinal()]) {
                case 1:
                    u6.l(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 2:
                    u6.y(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 3:
                    u6.C(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 4:
                    u6.G(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 5:
                    u6.T(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 6:
                    u6.N(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 7:
                    u6.a0(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 8:
                    u6.d0(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 9:
                    u6.W(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 10:
                    u6.b0(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 11:
                    u6.Q(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 12:
                    u6.Z(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 13:
                    u6.K(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 14:
                    u6.T(fVar.f25684c, (List) entry.getValue(), z7Var, false);
                    return;
                case 15:
                    u6.w(fVar.f25684c, (List) entry.getValue(), z7Var);
                    return;
                case 16:
                    u6.j(fVar.f25684c, (List) entry.getValue(), z7Var);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    u6.x(fVar.f25684c, (List) entry.getValue(), z7Var, p6.a().b(list.get(0).getClass()));
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 == null || list2.isEmpty()) {
                        return;
                    }
                    u6.k(fVar.f25684c, (List) entry.getValue(), z7Var, p6.a().b(list2.get(0).getClass()));
                    return;
                default:
                    return;
            }
        }
        switch (p4.f25581a[fVar.f25685d.ordinal()]) {
            case 1:
                z7Var.k(fVar.f25684c, ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                z7Var.l(fVar.f25684c, ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                z7Var.j(fVar.f25684c, ((Long) entry.getValue()).longValue());
                return;
            case 4:
                z7Var.e(fVar.f25684c, ((Long) entry.getValue()).longValue());
                return;
            case 5:
                z7Var.d(fVar.f25684c, ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                z7Var.F(fVar.f25684c, ((Long) entry.getValue()).longValue());
                return;
            case 7:
                z7Var.n(fVar.f25684c, ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                z7Var.D(fVar.f25684c, ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                z7Var.o(fVar.f25684c, ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                z7Var.i(fVar.f25684c, ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                z7Var.b(fVar.f25684c, ((Long) entry.getValue()).longValue());
                return;
            case 12:
                z7Var.m(fVar.f25684c, ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                z7Var.G(fVar.f25684c, ((Long) entry.getValue()).longValue());
                return;
            case 14:
                z7Var.d(fVar.f25684c, ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                z7Var.H(fVar.f25684c, (zzht) entry.getValue());
                return;
            case 16:
                z7Var.s(fVar.f25684c, (String) entry.getValue());
                return;
            case 17:
                z7Var.K(fVar.f25684c, entry.getValue(), p6.a().b(entry.getValue().getClass()));
                return;
            case 18:
                z7Var.J(fVar.f25684c, entry.getValue(), p6.a().b(entry.getValue().getClass()));
                return;
            default:
                return;
        }
    }

    @Override // com.google.android.gms.internal.vision.n4
    public final boolean e(c6 c6Var) {
        return c6Var instanceof x4.c;
    }

    @Override // com.google.android.gms.internal.vision.n4
    public final r4<x4.f> f(Object obj) {
        return ((x4.c) obj).x();
    }

    @Override // com.google.android.gms.internal.vision.n4
    public final void g(Object obj) {
        b(obj).i();
    }
}
