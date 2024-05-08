package com.inno.innosdk.utils;

import android.text.TextUtils;
import android.view.MotionEvent;
import com.inno.innosdk.bean.FcDeviceInfo;
import java.util.List;

/* compiled from: TouchAnalysisor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class r {
    public static void a(List<MotionEvent> list, String str) {
        long j10 = 0;
        String str2 = "";
        long j11 = 0;
        for (MotionEvent motionEvent : list) {
            if (motionEvent.getAction() == 0) {
                j10 = motionEvent.getEventTime();
            } else if (motionEvent.getAction() == 1) {
                j11 = motionEvent.getEventTime();
                str2 = String.format("%d,%d", Integer.valueOf(motionEvent.getToolType(0)), Integer.valueOf(motionEvent.getDeviceId()));
            }
        }
        String str3 = str2 + "," + j10 + "," + j11 + "," + list.size();
        if (!TextUtils.isEmpty(str)) {
            str3 = str3 + "," + str;
        }
        FcDeviceInfo fcDeviceInfo = new FcDeviceInfo("motion");
        fcDeviceInfo.mep = str3;
        com.inno.innosdk.b.b.a(fcDeviceInfo);
    }
}
