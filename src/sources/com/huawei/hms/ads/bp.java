package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class bp {
    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x002f. Please report as an issue. */
    public static int Code(int i10) {
        if (i10 == -1) {
            return 1006;
        }
        if (i10 == 200) {
            return 1000;
        }
        if (i10 != 204) {
            if (i10 == 496) {
                return 1007;
            }
            if (i10 == 498 || i10 == 804) {
                return 1001;
            }
            if (i10 == 1001) {
                return 1002;
            }
            if (i10 != 1100) {
                if (i10 == 704) {
                    return 1008;
                }
                if (i10 == 705) {
                    return 1009;
                }
                if (i10 != 801) {
                    if (i10 != 802) {
                        switch (i10) {
                            case 700:
                                break;
                            case 701:
                                break;
                            case 702:
                                break;
                            default:
                                switch (i10) {
                                    case 900:
                                        break;
                                    case 901:
                                        break;
                                    case 902:
                                        break;
                                    default:
                                        return 1010;
                                }
                        }
                    }
                    return 1003;
                }
                return 1004;
            }
        }
        return 1005;
    }
}
