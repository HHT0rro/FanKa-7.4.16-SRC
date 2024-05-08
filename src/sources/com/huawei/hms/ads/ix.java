package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.ErrorType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum ix implements ja {
    GENERIC("generic"),
    VIDEO("video");

    private static final boolean I = ip.Code(ip.f29316l);
    private final String Z;

    /* renamed from: com.huawei.hms.ads.ix$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[ix.values().length];
            Code = iArr;
            try {
                iArr[ix.GENERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[ix.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    ix(String str) {
        this.Z = str;
    }

    public static ErrorType Code(ix ixVar) {
        if (!I) {
            return null;
        }
        int i10 = AnonymousClass1.Code[ixVar.ordinal()];
        if (i10 == 1) {
            return ErrorType.GENERIC;
        }
        if (i10 != 2) {
            return null;
        }
        return ErrorType.VIDEO;
    }

    public static boolean Code() {
        return I;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.Z;
    }
}
