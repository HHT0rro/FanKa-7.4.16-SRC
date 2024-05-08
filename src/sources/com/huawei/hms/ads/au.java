package com.huawei.hms.ads;

import com.huawei.hms.ads.jsb.inner.data.AppDownloadInfo;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.listeners.AppDownloadListener;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class au extends aq {
    private static final String Z = "JsbOnDownloadChange";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements AppDownloadListener {
        private String Code;
        private String I;
        private String V;
        private Map<String, RemoteCallResultCallback<String>> Z = Collections.synchronizedMap(new c(5));
        private Map<String, RemoteCallResultCallback<String>> B = Collections.synchronizedMap(new c(5));
        private Map<String, RemoteCallResultCallback<String>> C = Collections.synchronizedMap(new c(5));

        public a() {
            gl.Code("jsb", "DownloadListener init");
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.download.app.k kVar, com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
            Map<String, RemoteCallResultCallback<String>> map = this.Z;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (Map.Entry<String, RemoteCallResultCallback<String>> entry : this.Z.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    RemoteCallResultCallback<String> value = entry.getValue();
                    if (value != null) {
                        af.Code(value, this.Code, 1000, com.huawei.openalliance.ad.utils.z.V(new AppDownloadInfo(appInfo, kVar)), false);
                    }
                    if (kVar == com.huawei.openalliance.ad.download.app.k.DOWNLOADFAILED) {
                        AppDownloadTask V = com.huawei.openalliance.ad.download.app.g.I().V(appInfo);
                        Map<String, RemoteCallResultCallback<String>> map2 = this.B;
                        if (map2 != null && map2.size() > 0 && this.B.get(key) != null) {
                            af.Code(this.B.get(key), this.V, 1000, com.huawei.openalliance.ad.utils.z.V(new AppDownloadInfo(appInfo, V != null ? V.S() : 0)), false);
                        }
                    }
                }
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo) {
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, int i10) {
            AppDownloadTask V = com.huawei.openalliance.ad.download.app.g.I().V(appInfo);
            if (V != null) {
                Code(dw.Code(V), appInfo);
            }
            Map<String, RemoteCallResultCallback<String>> map = this.B;
            if (map == null || map.size() <= 0) {
                return;
            }
            Iterator<RemoteCallResultCallback<String>> iterator2 = this.B.values().iterator2();
            while (iterator2.hasNext()) {
                af.Code(iterator2.next(), this.V, 1000, com.huawei.openalliance.ad.utils.z.V(new AppDownloadInfo(appInfo, i10)), false);
            }
        }

        public void Code(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.Z.put(str2, remoteCallResultCallback);
            this.Code = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
        public void Code(String str) {
            Map<String, RemoteCallResultCallback<String>> map = this.C;
            if (map == null || map.size() <= 0) {
                return;
            }
            for (RemoteCallResultCallback<String> remoteCallResultCallback : this.C.values()) {
                if (remoteCallResultCallback != null) {
                    af.Code(remoteCallResultCallback, this.I, 1000, com.huawei.openalliance.ad.utils.z.V(new AppDownloadInfo(str)), false);
                }
            }
        }

        public void I(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.C.put(str2, remoteCallResultCallback);
            this.I = str;
        }

        public void V(RemoteCallResultCallback<String> remoteCallResultCallback, String str, String str2) {
            this.B.put(str2, remoteCallResultCallback);
            this.V = str;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {
        private static a Code = new a();

        static {
            gl.Code(au.Z, "register global Jsb app download Listener.");
            com.huawei.openalliance.ad.download.a.Code().V(Code);
        }

        private b() {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c<K, V> extends LinkedHashMap<K, V> {
        private static final long Code = 8139502072983476335L;
        private final int V;

        public c(int i10) {
            this.V = i10;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.V;
        }
    }

    public au(String str) {
        super(str);
    }

    public a V() {
        return b.Code;
    }
}
