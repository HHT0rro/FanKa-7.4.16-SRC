package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.ImpressionType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum jb implements ja {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED("unspecified"),
    LOADED("loaded"),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");

    private static boolean D;
    private final String L;

    /* renamed from: com.huawei.hms.ads.jb$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[jb.values().length];
            Code = iArr;
            try {
                iArr[jb.DEFINED_BY_JAVASCRIPT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[jb.UNSPECIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[jb.LOADED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[jb.BEGIN_TO_RENDER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[jb.ONE_PIXEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Code[jb.VIEWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Code[jb.AUDIBLE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Code[jb.OTHER.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        D = false;
        D = ip.Code(ip.f29318n);
    }

    jb(String str) {
        this.L = str;
    }

    public static ImpressionType Code(jb jbVar) {
        if (!D) {
            return null;
        }
        switch (AnonymousClass1.Code[jbVar.ordinal()]) {
            case 1:
                return ImpressionType.DEFINED_BY_JAVASCRIPT;
            case 2:
                return ImpressionType.UNSPECIFIED;
            case 3:
                return ImpressionType.LOADED;
            case 4:
                return ImpressionType.BEGIN_TO_RENDER;
            case 5:
                return ImpressionType.ONE_PIXEL;
            case 6:
                return ImpressionType.VIEWABLE;
            case 7:
                return ImpressionType.AUDIBLE;
            case 8:
                return ImpressionType.OTHER;
            default:
                return null;
        }
    }

    public static boolean Code() {
        return D;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.L;
    }
}
