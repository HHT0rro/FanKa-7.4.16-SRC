package com.huawei.hms.ads;

import com.android.internal.os.PowerProfile;
import com.iab.omid.library.huawei.adsession.CreativeType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum iw implements ja {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    HTML_DISPLAY("htmlDisplay"),
    NATIVE_DISPLAY("nativeDisplay"),
    VIDEO("video"),
    AUDIO(PowerProfile.POWER_AUDIO);

    private static boolean C;
    private final String S;

    /* renamed from: com.huawei.hms.ads.iw$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[iw.values().length];
            Code = iArr;
            try {
                iArr[iw.DEFINED_BY_JAVASCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[iw.HTML_DISPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[iw.NATIVE_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[iw.VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[iw.AUDIO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        C = false;
        C = ip.Code(ip.f29315k);
    }

    iw(String str) {
        this.S = str;
    }

    public static CreativeType Code(iw iwVar) {
        if (!C) {
            return null;
        }
        int i10 = AnonymousClass1.Code[iwVar.ordinal()];
        if (i10 == 1) {
            return CreativeType.DEFINED_BY_JAVASCRIPT;
        }
        if (i10 == 2) {
            return CreativeType.HTML_DISPLAY;
        }
        if (i10 == 3) {
            return CreativeType.NATIVE_DISPLAY;
        }
        if (i10 == 4) {
            return CreativeType.VIDEO;
        }
        if (i10 != 5) {
            return null;
        }
        return CreativeType.AUDIO;
    }

    public static boolean Code() {
        return C;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }
}
