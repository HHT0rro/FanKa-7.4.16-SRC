package com.huawei.hms.ads;

import com.iab.omid.library.huawei.adsession.media.InteractionType;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum jf implements ja {
    CLICK("click"),
    INVITATION_ACCEPTED("invitationAccept");

    private static boolean Z;
    public String I;

    /* renamed from: com.huawei.hms.ads.jf$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] Code;

        static {
            int[] iArr = new int[jf.values().length];
            Code = iArr;
            try {
                iArr[jf.CLICK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Code[jf.INVITATION_ACCEPTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        Z = false;
        Z = ip.Code("com.iab.omid.library.huawei.adsession.media.InteractionType");
    }

    jf(String str) {
        this.I = str;
    }

    public static InteractionType Code(jf jfVar) {
        if (!Z) {
            return null;
        }
        int i10 = AnonymousClass1.Code[jfVar.ordinal()];
        if (i10 == 1) {
            return InteractionType.CLICK;
        }
        if (i10 != 2) {
            return null;
        }
        return InteractionType.INVITATION_ACCEPTED;
    }

    public static boolean Code() {
        return Z;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.I;
    }
}
