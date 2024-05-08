package com.bytedance.pangle.g;

import android.content.pm.Signature;
import android.util.ArraySet;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f10806a = new o(null, 0, null, null, null);

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Signature[] f10807b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10808c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final ArraySet<PublicKey> f10809d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public final Signature[] f10810e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public final int[] f10811f;

    public o(Signature[] signatureArr, int i10, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.f10807b = signatureArr;
        this.f10808c = i10;
        this.f10809d = arraySet;
        this.f10810e = signatureArr2;
        this.f10811f = iArr;
    }

    private static ArraySet<PublicKey> a(Signature[] signatureArr) {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method method = null;
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e2) {
                e2.printStackTrace();
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e10) {
                    e10.printStackTrace();
                } catch (InvocationTargetException e11) {
                    e11.printStackTrace();
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
        }
        return arraySet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        if (this.f10808c != oVar.f10808c || !a(this.f10807b, oVar.f10807b)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.f10809d;
        if (arraySet != null) {
            if (!arraySet.equals(oVar.f10809d)) {
                return false;
            }
        } else if (oVar.f10809d != null) {
            return false;
        }
        return Arrays.equals(this.f10810e, oVar.f10810e) && Arrays.equals(this.f10811f, oVar.f10811f);
    }

    public final int hashCode() {
        int hashCode = ((Arrays.hashCode(this.f10807b) * 31) + this.f10808c) * 31;
        ArraySet<PublicKey> arraySet = this.f10809d;
        return ((((hashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.f10810e)) * 31) + Arrays.hashCode(this.f10811f);
    }

    public o(Signature[] signatureArr, int i10, Signature[] signatureArr2, int[] iArr) {
        this(signatureArr, i10, a(signatureArr), signatureArr2, iArr);
    }

    public o(Signature[] signatureArr) {
        this(signatureArr, 2, null, null);
    }

    public static boolean a(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.d.a((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.d.a((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
        }
        return true;
    }
}
