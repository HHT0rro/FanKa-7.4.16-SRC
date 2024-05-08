package com.huawei.hms.ads;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.iab.omid.library.huawei.adsession.media.Position;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum jh implements ja {
    PREROLL(IAdInterListener.AdProdType.PRODUCT_PREROLL),
    MIDROLL("midroll"),
    POSTROLL("postroll"),
    STANDALONE("standalone");

    private static boolean B;
    private final String C;

    /* renamed from: com.huawei.hms.ads.jh$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[jh.values().length];
            Code = iArr;
            try {
                iArr[jh.PREROLL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[jh.MIDROLL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[jh.POSTROLL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[jh.STANDALONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static {
        B = false;
        B = ip.Code("com.iab.omid.library.huawei.adsession.media.Position");
    }

    jh(String str) {
        this.C = str;
    }

    public static Position Code(jh jhVar) {
        if (!B) {
            return null;
        }
        int i10 = AnonymousClass1.Code[jhVar.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return Position.PREROLL;
        }
        if (i10 == 3) {
            return Position.POSTROLL;
        }
        if (i10 != 4) {
            return null;
        }
        return Position.STANDALONE;
    }

    public static boolean Code() {
        return B;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.C;
    }
}
