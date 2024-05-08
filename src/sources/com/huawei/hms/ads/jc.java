package com.huawei.hms.ads;

import com.huawei.appgallery.agd.base.api.AgdManager;
import com.iab.omid.library.huawei.adsession.Owner;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum jc implements ja {
    NATIVE(AgdManager.SOURCE_NATIVE),
    JAVASCRIPT("javascript"),
    NONE("none");

    private static boolean Z;
    private final String B;

    /* renamed from: com.huawei.hms.ads.jc$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[jc.values().length];
            Code = iArr;
            try {
                iArr[jc.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[jc.JAVASCRIPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[jc.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        Z = false;
        Z = ip.Code(ip.f29319o);
    }

    jc(String str) {
        this.B = str;
    }

    public static Owner Code(jc jcVar) {
        if (!Z) {
            return null;
        }
        int i10 = AnonymousClass1.Code[jcVar.ordinal()];
        if (i10 == 1) {
            return Owner.NATIVE;
        }
        if (i10 == 2) {
            return Owner.JAVASCRIPT;
        }
        if (i10 != 3) {
            return null;
        }
        return Owner.NONE;
    }

    public static boolean Code() {
        return Z;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.B;
    }
}
