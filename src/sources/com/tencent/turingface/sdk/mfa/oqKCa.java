package com.tencent.turingface.sdk.mfa;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import java.util.Objects;
import javax.security.auth.x500.X500Principal;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class oqKCa {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class spXPg extends oqKCa {

        /* renamed from: a, reason: collision with root package name */
        public KeyGenParameterSpec.Builder f45899a;

        public spXPg(String str, int i10) {
            this.f45899a = null;
            this.f45899a = new KeyGenParameterSpec.Builder(str, i10);
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            return this.f45899a.build();
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa b(String... strArr) {
            this.f45899a.setSignaturePaddings(strArr);
            return this;
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa a(String... strArr) {
            this.f45899a.setDigests(strArr);
            return this;
        }
    }

    public static oqKCa a(String str, int i10) {
        if (Build.VERSION.SDK_INT >= 23) {
            return new spXPg(str, i10);
        }
        return new ShGzN(str, i10);
    }

    public abstract oqKCa a(String... strArr);

    public abstract AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    public abstract oqKCa b(String... strArr);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ShGzN extends oqKCa {

        /* renamed from: a, reason: collision with root package name */
        public final String f45895a;

        /* renamed from: b, reason: collision with root package name */
        public int f45896b;

        /* renamed from: c, reason: collision with root package name */
        public String[] f45897c;

        /* renamed from: d, reason: collision with root package name */
        public String[] f45898d;

        public ShGzN(String str, int i10) {
            Objects.requireNonNull(str, "keystoreAlias == null");
            if (!str.isEmpty()) {
                this.f45895a = str;
                this.f45896b = i10;
                return;
            }
            throw new IllegalArgumentException("keystoreAlias must not be empty");
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final AlgorithmParameterSpec a() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            Class<?> cls = Class.forName("android.security.keystore.KeyGenParameterSpec");
            Class<Integer> cls2 = Integer.TYPE;
            Class<Boolean> cls3 = Boolean.TYPE;
            return (AlgorithmParameterSpec) cls.getConstructor(String.class, cls2, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, cls2, String[].class, String[].class, String[].class, String[].class, cls3, cls3, cls2).newInstance(this.f45895a, -1, null, null, null, null, null, null, null, null, Integer.valueOf(this.f45896b), this.f45897c, null, this.f45898d, null, Boolean.TRUE, Boolean.FALSE, -1);
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa b(String... strArr) {
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.f45898d = strArr;
            return this;
        }

        @Override // com.tencent.turingface.sdk.mfa.oqKCa
        public final oqKCa a(String... strArr) {
            if (strArr.length > 0) {
                strArr = (String[]) strArr.clone();
            }
            this.f45897c = strArr;
            return this;
        }
    }
}
