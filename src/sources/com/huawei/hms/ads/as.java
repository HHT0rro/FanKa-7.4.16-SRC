package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.au;
import com.huawei.hms.ads.jsb.inner.data.AppDownloadInfo;
import com.huawei.openalliance.ad.download.app.b;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class as extends aq {
    private static final String Z = "JsbOnAgReserveStatusChange";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements com.huawei.openalliance.ad.download.f {
        private static final byte[] Code = new byte[0];
        private static a V;
        private String I;
        private Map<String, RemoteCallResultCallback<String>> Z = Collections.synchronizedMap(new au.c(5));

        private a(Context context) {
            gl.V("jsb", "ReserveStatusListener init");
            b.Code(context).Code(this);
        }

        public static a Code(Context context) {
            a aVar;
            synchronized (Code) {
                if (V == null) {
                    V = new a(context);
                }
                aVar = V;
            }
            return aVar;
        }

        public void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.Z.put(str2, remoteCallResultCallback);
            this.I = str;
        }

        @Override // com.huawei.openalliance.ad.download.f
        public void Code(String str, int i10) {
            Map<String, RemoteCallResultCallback<String>> map = this.Z;
            if (map == null || map.size() <= 0) {
                return;
            }
            Iterator<RemoteCallResultCallback<String>> iterator2 = this.Z.values().iterator2();
            while (iterator2.hasNext()) {
                af.Code(iterator2.next(), this.I, 1000, com.huawei.openalliance.ad.utils.z.V(new AppDownloadInfo(str, i10)), false);
            }
        }
    }

    public as() {
        super(ai.f29029e);
    }

    @Override // com.huawei.hms.ads.af, com.huawei.hms.ads.ac
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        a.Code(context).Code(remoteCallResultCallback, this.Code, this.I);
    }
}
