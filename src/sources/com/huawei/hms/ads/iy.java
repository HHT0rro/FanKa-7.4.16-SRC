package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.FriendlyObstructionPurpose;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum iy implements ja {
    VIDEO_CONTROLS,
    CLOSE_AD,
    NOT_VISIBLE,
    OTHER;

    private static boolean B;

    /* renamed from: com.huawei.hms.ads.iy$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[iy.values().length];
            Code = iArr;
            try {
                iArr[iy.VIDEO_CONTROLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[iy.CLOSE_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[iy.NOT_VISIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[iy.OTHER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        B = false;
        B = ip.Code(ip.f29317m);
    }

    public static FriendlyObstructionPurpose Code(iy iyVar) {
        if (!B) {
            return null;
        }
        int i10 = AnonymousClass1.Code[iyVar.ordinal()];
        if (i10 == 1) {
            return FriendlyObstructionPurpose.VIDEO_CONTROLS;
        }
        if (i10 == 2) {
            return FriendlyObstructionPurpose.CLOSE_AD;
        }
        if (i10 == 3) {
            return FriendlyObstructionPurpose.NOT_VISIBLE;
        }
        if (i10 != 4) {
            return null;
        }
        return FriendlyObstructionPurpose.OTHER;
    }

    public static boolean Code() {
        return B;
    }
}
