package io.microshow.rxffmpeg;

import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class RxFFmpegCommandSupport {
    public static String[] getBoxblur(String str, String str2, String str3, boolean z10) {
        RxFFmpegCommandList rxFFmpegCommandList = new RxFFmpegCommandList();
        rxFFmpegCommandList.append("-i");
        rxFFmpegCommandList.append(str);
        rxFFmpegCommandList.append("-vf");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("boxblur=");
        if (TextUtils.isEmpty(str3)) {
            str3 = "5:1";
        }
        sb2.append(str3);
        rxFFmpegCommandList.append(sb2.toString());
        rxFFmpegCommandList.append("-preset");
        rxFFmpegCommandList.append("superfast");
        rxFFmpegCommandList.append(str2);
        return rxFFmpegCommandList.build(z10);
    }
}
