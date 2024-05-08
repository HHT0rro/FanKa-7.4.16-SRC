package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class aq extends af {
    private static final String Z = "CmdBaseDownload";

    public aq(String str) {
        super(str);
    }

    public IAppDownloadManager V(Context context, String str) {
        IAppDownloadManager Code = com.huawei.hms.ads.jsb.a.Code(context).Code();
        Code.Code(B(str));
        if (com.huawei.openalliance.ad.utils.v.B(context)) {
            Code.Code(true);
        }
        return Code;
    }
}
