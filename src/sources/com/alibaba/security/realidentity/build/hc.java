package com.alibaba.security.realidentity.build;

import android.content.Context;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.build.j;
import java.util.HashMap;

/* compiled from: AbsUploadFileManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class hc implements hd {

    /* renamed from: a, reason: collision with root package name */
    public Context f3808a;

    public hc(Context context) {
        this.f3808a = context;
    }

    private static void a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", str);
        hashMap.put("fileType", str2);
        hashMap.put("fileLength", -1L);
        j.a.f3944a.collectLog(TrackLog.createOssUploadFileBeginLog(JsonUtils.toJSON(hashMap)));
    }

    public static void a(String str, String str2, String str3, String str4, String str5, long j10) {
        HashMap hashMap = new HashMap();
        hashMap.put("fileName", str);
        hashMap.put("fileType", str2);
        hashMap.put("fileLength", -1L);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("ossUrl", str3);
        hashMap2.put("errorCode", str4);
        hashMap2.put("errorMsg", str5);
        j.a.f3944a.collectLog(TrackLog.createOssUploadFileEndLog(JsonUtils.toJSON(hashMap), JsonUtils.toJSON(hashMap2), j10));
    }
}
