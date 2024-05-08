package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ReedSolomonEncoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class q6 {

    /* renamed from: a, reason: collision with root package name */
    private final o3 f31431a;

    /* renamed from: b, reason: collision with root package name */
    private final List<p3> f31432b;

    public q6(o3 o3Var) {
        this.f31431a = o3Var;
        ArrayList arrayList = new ArrayList();
        this.f31432b = arrayList;
        arrayList.add(new p3(o3Var, new int[]{1}));
    }

    private p3 a(int i10) {
        if (i10 >= this.f31432b.size()) {
            List<p3> list = this.f31432b;
            p3 p3Var = list.get(list.size() - 1);
            for (int size = this.f31432b.size(); size <= i10; size++) {
                o3 o3Var = this.f31431a;
                p3Var = p3Var.c(new p3(o3Var, new int[]{1, o3Var.a((size - 1) + o3Var.a())}));
                this.f31432b.add(p3Var);
            }
        }
        return this.f31432b.get(i10);
    }

    public void a(int[] iArr, int i10) {
        if (i10 != 0) {
            int length = iArr.length - i10;
            if (length > 0) {
                p3 a10 = a(i10);
                int[] iArr2 = new int[length];
                System.arraycopy((Object) iArr, 0, (Object) iArr2, 0, length);
                int[] a11 = new p3(this.f31431a, iArr2).a(i10, 1).b(a10)[1].a();
                int length2 = i10 - a11.length;
                for (int i11 = 0; i11 < length2; i11++) {
                    iArr[length + i11] = 0;
                }
                System.arraycopy((Object) a11, 0, (Object) iArr, length + length2, a11.length);
                return;
            }
            try {
                throw new IllegalArgumentException("No data bytes provided");
            } catch (Exception e2) {
                throw e2;
            }
        }
        try {
            throw new IllegalArgumentException("No error correction bytes");
        } catch (Exception e10) {
            throw e10;
        }
    }
}
