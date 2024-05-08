package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o {
    private static long Code = 0;
    private static final int I = 1500;
    private static long V;

    public static boolean Code() {
        if (Math.abs(System.currentTimeMillis() - Code) < 500 || Math.abs(System.currentTimeMillis() - V) < 1500) {
            return true;
        }
        Code = System.currentTimeMillis();
        return false;
    }

    public static boolean Code(List<FeedbackInfo> list) {
        if (aa.Code(list)) {
            return false;
        }
        for (FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null && feedbackInfo.Z()) {
                return true;
            }
        }
        return false;
    }

    public static void V() {
        V = System.currentTimeMillis();
    }
}
