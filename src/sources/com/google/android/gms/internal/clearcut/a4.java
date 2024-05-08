package com.google.android.gms.internal.clearcut;

import com.android.internal.logging.nano.MetricsProto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a4 implements Cloneable {

    /* renamed from: b, reason: collision with root package name */
    public Object f23787b;

    /* renamed from: c, reason: collision with root package name */
    public List<Object> f23788c = new ArrayList();

    public final byte[] a() throws IOException {
        byte[] bArr = new byte[d()];
        c(x3.q(bArr));
        return bArr;
    }

    public final void c(x3 x3Var) throws IOException {
        if (this.f23787b != null) {
            throw new NoSuchMethodError();
        }
        Iterator<Object> iterator2 = this.f23788c.iterator2();
        if (iterator2.hasNext()) {
            iterator2.next();
            throw new NoSuchMethodError();
        }
    }

    public final int d() {
        if (this.f23787b != null) {
            throw new NoSuchMethodError();
        }
        Iterator<Object> iterator2 = this.f23788c.iterator2();
        if (!iterator2.hasNext()) {
            return 0;
        }
        iterator2.next();
        throw new NoSuchMethodError();
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final a4 clone() {
        Object clone;
        a4 a4Var = new a4();
        try {
            List<Object> list = this.f23788c;
            if (list == null) {
                a4Var.f23788c = null;
            } else {
                a4Var.f23788c.addAll(list);
            }
            Object obj = this.f23787b;
            if (obj != null) {
                if (obj instanceof c4) {
                    clone = (c4) ((c4) obj).clone();
                } else if (obj instanceof byte[]) {
                    clone = ((byte[]) obj).clone();
                } else {
                    int i10 = 0;
                    if (obj instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) obj;
                        byte[][] bArr2 = new byte[bArr.length];
                        a4Var.f23787b = bArr2;
                        while (i10 < bArr.length) {
                            bArr2[i10] = (byte[]) bArr[i10].clone();
                            i10++;
                        }
                    } else if (obj instanceof boolean[]) {
                        clone = ((boolean[]) obj).clone();
                    } else if (obj instanceof int[]) {
                        clone = ((int[]) obj).clone();
                    } else if (obj instanceof long[]) {
                        clone = ((long[]) obj).clone();
                    } else if (obj instanceof float[]) {
                        clone = ((float[]) obj).clone();
                    } else if (obj instanceof double[]) {
                        clone = ((double[]) obj).clone();
                    } else if (obj instanceof c4[]) {
                        c4[] c4VarArr = (c4[]) obj;
                        c4[] c4VarArr2 = new c4[c4VarArr.length];
                        a4Var.f23787b = c4VarArr2;
                        while (i10 < c4VarArr.length) {
                            c4VarArr2[i10] = (c4) c4VarArr[i10].clone();
                            i10++;
                        }
                    }
                }
                a4Var.f23787b = clone;
            }
            return a4Var;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public final boolean equals(Object obj) {
        List<Object> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a4)) {
            return false;
        }
        a4 a4Var = (a4) obj;
        if (this.f23787b != null && a4Var.f23787b != null) {
            throw null;
        }
        List<Object> list2 = this.f23788c;
        if (list2 != null && (list = a4Var.f23788c) != null) {
            return list2.equals(list);
        }
        try {
            return Arrays.equals(a(), a4Var.a());
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(a()) + MetricsProto.MetricsEvent.DIALOG_SUPPORT_PHONE;
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
