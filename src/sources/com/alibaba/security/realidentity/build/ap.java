package com.alibaba.security.realidentity.build;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.realidentity.build.j;
import java.net.InetAddress;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DnsHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ap extends AsyncTask<String, Void, Map<String, Boolean>> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3098a = ap.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private final a f3099b;

    /* compiled from: DnsHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(Map<String, Boolean> map);
    }

    public ap(a aVar) {
        this.f3099b = aVar;
    }

    private static Map<String, Boolean> a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String host = URI.create(str).getHost();
                if (!TextUtils.isEmpty(host)) {
                    InetAddress[] allByName = InetAddress.getAllByName(host);
                    HashMap hashMap = new HashMap();
                    for (InetAddress inetAddress : allByName) {
                        hashMap.put(inetAddress.getHostAddress(), Boolean.valueOf(inetAddress.isReachable(100)));
                    }
                    return hashMap;
                }
            }
            return null;
        } catch (Throwable th) {
            j.a.f3944a.collectLog(TrackLog.createSimpleSdk(f3098a, "getIpAddress", th.getMessage()));
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public /* synthetic */ Map<String, Boolean> doInBackground(String[] strArr) {
        String[] strArr2 = strArr;
        if (strArr2 == null || strArr2.length <= 0) {
            return null;
        }
        return a(strArr2[0]);
    }

    @Override // android.os.AsyncTask
    public /* synthetic */ void onPostExecute(Map<String, Boolean> map) {
        Map<String, Boolean> map2 = map;
        super.onPostExecute(map2);
        this.f3099b.a(map2);
    }

    private static Map<String, Boolean> a(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return null;
        }
        return a(strArr[0]);
    }

    private void a(Map<String, Boolean> map) {
        super.onPostExecute(map);
        this.f3099b.a(map);
    }
}
