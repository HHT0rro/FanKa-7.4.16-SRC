package com.kwad.sdk.collector.model.jni;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.collector.model.c;
import com.kwad.sdk.utils.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class AppRunningInfoNative extends NativeObject implements b<AppRunningInfoNative> {
    private static SimpleDateFormat anE = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    public AppRunningInfoNative(long j10, String str, String str2) {
        this.mPtr = AppStatusNative.nativeCreateAppRunningInfo(j10, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: AD, reason: merged with bridge method [inline-methods] */
    public AppRunningInfoNative clone() {
        AppRunningInfoNative appRunningInfoNative = new AppRunningInfoNative(AppStatusNative.appRunningInfoGetGranularity(this), AppStatusNative.appRunningInfoGetName(this), AppStatusNative.appRunningInfoGetPackageName(this));
        c.a(appRunningInfoNative, AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return appRunningInfoNative;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AppRunningInfoNative appRunningInfoNative) {
        if (appRunningInfoNative == null) {
            return 1;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) - c.c(appRunningInfoNative);
        if (appRunningInfoGetLastRunningTime == 0) {
            return 0;
        }
        return appRunningInfoGetLastRunningTime > 0 ? 1 : -1;
    }

    private static String ab(long j10) {
        return anE.format(new Date(j10));
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j10 = this.mPtr;
        if (j10 != 0) {
            AppStatusNative.nativeDeleteAppRunningInfo(j10);
            this.mPtr = 0L;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppRunningInfoNative appRunningInfoNative = (AppRunningInfoNative) obj;
        long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (appRunningInfoGetGranularity != AppStatusNative.appRunningInfoGetGranularity(appRunningInfoNative)) {
            return false;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this);
        String appRunningInfoGetName = AppStatusNative.appRunningInfoGetName(this);
        String appRunningInfoGetPackageName = AppStatusNative.appRunningInfoGetPackageName(this);
        if (appRunningInfoGetGranularity == 0) {
            appRunningInfoGetGranularity = 1;
        }
        if (appRunningInfoGetLastRunningTime / appRunningInfoGetGranularity == AppStatusNative.appRunningInfoGetLastRunningTime(appRunningInfoNative) / appRunningInfoGetGranularity && appRunningInfoGetName.equals(AppStatusNative.appRunningInfoGetName(appRunningInfoNative))) {
            return appRunningInfoGetPackageName.equals(AppStatusNative.appRunningInfoGetPackageName(appRunningInfoNative));
        }
        return false;
    }

    public int hashCode() {
        long appRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (appRunningInfoGetGranularity == 0) {
            appRunningInfoGetGranularity = 1;
        }
        long appRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) / appRunningInfoGetGranularity;
        return (((AppStatusNative.appRunningInfoGetName(this).hashCode() * 31) + AppStatusNative.appRunningInfoGetPackageName(this).hashCode()) * 31) + ((int) (appRunningInfoGetLastRunningTime ^ (appRunningInfoGetLastRunningTime >>> 32)));
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "name", AppStatusNative.appRunningInfoGetName(this));
        t.putValue(jSONObject, "packageName", AppStatusNative.appRunningInfoGetPackageName(this));
        t.putValue(jSONObject, "lastRunningTime", AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return jSONObject;
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + c.b(this) + "', lastRunningTime=" + ab(c.c(this)) + '}';
    }

    public AppRunningInfoNative(long j10) {
        this.mPtr = j10;
    }
}
