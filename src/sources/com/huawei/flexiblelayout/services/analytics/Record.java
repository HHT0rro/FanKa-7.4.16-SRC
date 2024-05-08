package com.huawei.flexiblelayout.services.analytics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.BuildConfig;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.version.Version;
import com.huawei.hms.push.AttributionReporter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Record {

    /* renamed from: b, reason: collision with root package name */
    private static final SdkInfo f28505b;

    /* renamed from: c, reason: collision with root package name */
    private static final AppInfo f28506c;

    /* renamed from: a, reason: collision with root package name */
    private FLEngine f28507a;
    public final String mEvent;
    public final LinkedHashMap<String, String> mParams = new LinkedHashMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class AppInfo {

        /* renamed from: a, reason: collision with root package name */
        private volatile Map<String, String> f28508a;

        private AppInfo() {
        }

        private String b(Context context) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
            } catch (PackageManager.NameNotFoundException unused) {
                return "";
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> a(Context context) {
            if (this.f28508a == null) {
                synchronized (AppInfo.class) {
                    if (this.f28508a == null) {
                        this.f28508a = new HashMap(4);
                        this.f28508a.put("appPackage", context.getPackageName());
                        this.f28508a.put(AttributionReporter.APP_VERSION, b(context));
                    }
                }
            }
            return this.f28508a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class SdkInfo {

        /* renamed from: a, reason: collision with root package name */
        private volatile Map<String, String> f28511a;

        private SdkInfo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, String> a() {
            if (this.f28511a == null) {
                synchronized (SdkInfo.class) {
                    if (this.f28511a == null) {
                        this.f28511a = new HashMap(4);
                        this.f28511a.put("flayoutSdkVersion", BuildConfig.FLAYOUT_SDK_VERSION);
                        Map<String, String> map = this.f28511a;
                        new Version();
                        map.put("flayoutSdkApiLevel", String.valueOf(1));
                    }
                }
            }
            return this.f28511a;
        }
    }

    static {
        f28505b = new SdkInfo();
        f28506c = new AppInfo();
    }

    public Record(String str) {
        this.mEvent = str;
    }

    public static Builder builder(String str) {
        return new Builder(str);
    }

    public void report() {
        AnalyticsService analyticsService = (AnalyticsService) this.f28507a.getService(AnalyticsService.class);
        if (analyticsService != null) {
            analyticsService.report(this);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final String f28509a;

        /* renamed from: b, reason: collision with root package name */
        private final HashMap<String, String> f28510b = new HashMap<>();

        public Builder(String str) {
            this.f28509a = str;
        }

        public Record build(@NonNull Context context) {
            Record record = new Record(this.f28509a);
            this.f28510b.putAll(Record.f28505b.a());
            this.f28510b.putAll(Record.f28506c.a(context));
            record.mParams.putAll(this.f28510b);
            record.f28507a = FLEngine.getInstance(context);
            this.f28510b.clear();
            return record;
        }

        public Builder code(int i10) {
            put("code", Integer.valueOf(i10));
            return this;
        }

        public Builder put(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.f28510b.put(str, str2);
            }
            return this;
        }

        public Builder uri(String str) {
            put("uri", str);
            return this;
        }

        public Builder put(String str, Number number) {
            if (!TextUtils.isEmpty(str)) {
                this.f28510b.put(str, String.valueOf(number));
            }
            return this;
        }

        public Builder put(String str, boolean z10) {
            if (!TextUtils.isEmpty(str)) {
                this.f28510b.put(str, String.valueOf(z10));
            }
            return this;
        }
    }
}
