package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.PlayerState;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum jl implements ja {
    MINIMIZED("minimized"),
    COLLAPSED("collapsed"),
    NORMAL("normal"),
    EXPANDED("expanded"),
    FULLSCREEN("fullscreen");

    private static boolean C;
    private final String S;

    /* renamed from: com.huawei.hms.ads.jl$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[jl.values().length];
            Code = iArr;
            try {
                iArr[jl.MINIMIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[jl.COLLAPSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Code[jl.NORMAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Code[jl.EXPANDED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Code[jl.FULLSCREEN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        C = false;
        C = ip.Code("com.iab.omid.library.huawei.adsession.media.PlayerState");
    }

    jl(String str) {
        this.S = str;
    }

    public static PlayerState Code(jl jlVar) {
        if (!C) {
            return null;
        }
        int i10 = AnonymousClass1.Code[jlVar.ordinal()];
        if (i10 == 1) {
            return PlayerState.MINIMIZED;
        }
        if (i10 == 2) {
            return PlayerState.COLLAPSED;
        }
        if (i10 == 3) {
            return PlayerState.NORMAL;
        }
        if (i10 == 4) {
            return PlayerState.EXPANDED;
        }
        if (i10 != 5) {
            return null;
        }
        return PlayerState.FULLSCREEN;
    }

    public static boolean Code() {
        return C;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.S;
    }
}