package com.huawei.hms.ads;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class dx {
    public static int Code(int i10) {
        if (i10 == -4 || i10 == 804) {
            return 1;
        }
        if (i10 == -1 || i10 == -2) {
            return 2;
        }
        if (i10 == 204 || i10 == 700 || i10 == 800 || i10 == 900 || i10 == -3 || i10 == 498 || i10 == 494) {
            return 3;
        }
        if (i10 == 1001) {
            return 5;
        }
        if (i10 == 701 || i10 == 801 || i10 == 901) {
            return 4;
        }
        if (i10 == 704) {
            return 6;
        }
        if (i10 == 705) {
            return 7;
        }
        return i10 == 706 ? 8 : 0;
    }
}
