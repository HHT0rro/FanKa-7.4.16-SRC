package com.huawei.hms.ads;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.iab.omid.library.huawei.adsession.media.Position;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum jm implements ja {
    PREROLL(IAdInterListener.AdProdType.PRODUCT_PREROLL),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");

    private static boolean B;
    private final String C;

    /* renamed from: com.huawei.hms.ads.jm$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[jm.values().length];
            Code = iArr;
            try {
                iArr[jm.PREROLL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[jm.MIDROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[jm.POSTROLL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[jm.STANDALONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        B = false;
        B = ip.Code("com.iab.omid.library.huawei.adsession.media.Position");
    }

    jm(String str) {
        this.C = str;
    }

    public static Position Code(jm jmVar) {
        if (!B) {
            return null;
        }
        int i10 = AnonymousClass1.Code[jmVar.ordinal()];
        if (i10 != 1 && i10 != 2) {
            if (i10 == 3) {
                return Position.POSTROLL;
            }
            if (i10 != 4) {
                return null;
            }
            return Position.STANDALONE;
        }
        return Position.PREROLL;
    }

    public static boolean Code() {
        return B;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.C;
    }
}
