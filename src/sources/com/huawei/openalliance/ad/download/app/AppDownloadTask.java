package com.huawei.openalliance.ad.download.app;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.download.DownloadTask;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

@DataKeep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class AppDownloadTask extends DownloadTask {
    private static final String TAG = "AppDownloadTask";

    @com.huawei.openalliance.ad.annotations.d
    private AdContentData adContentData;
    private Integer agdDownloadSource;
    private int apiVer;

    @com.huawei.openalliance.ad.annotations.d
    private AppInfo appInfo;
    private String apptaskInfo;
    private String contentId;
    private String curInstallWay;
    private String customData;
    private Integer downloadSource;
    private Integer downloadSourceMutable;

    @com.huawei.openalliance.ad.annotations.d
    private int installResult;

    @com.huawei.openalliance.ad.annotations.d
    private Queue<String> installWayQueue = new ConcurrentLinkedQueue();
    private String requestId;
    private String showId;
    private String slotId;

    @com.huawei.openalliance.ad.annotations.d
    private long startTime;
    private String templateId;
    private String userId;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a {
        private AppInfo Code;
        private boolean V;

        public a Code(AppInfo appInfo) {
            this.Code = appInfo;
            return this;
        }

        public a Code(boolean z10) {
            this.V = z10;
            return this;
        }

        public AppDownloadTask Code() {
            if (this.Code == null) {
                return null;
            }
            AppDownloadTask appDownloadTask = new AppDownloadTask();
            appDownloadTask.Code(this.V);
            appDownloadTask.Code(this.Code);
            appDownloadTask.Code(this.Code.Z());
            appDownloadTask.V(this.Code.C());
            appDownloadTask.Code(this.Code.B());
            appDownloadTask.V(0);
            appDownloadTask.V(this.Code);
            return appDownloadTask;
        }
    }

    private boolean I(AppInfo appInfo) {
        if (appInfo == null) {
            return true;
        }
        return appInfo.S() && TextUtils.isEmpty(appInfo.C());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(AppInfo appInfo) {
        String p10;
        if (appInfo == null) {
            return;
        }
        try {
            this.installWayQueue.clear();
            String g3 = appInfo.g();
            if (!TextUtils.isEmpty(g3)) {
                this.installWayQueue.offer(g3);
            }
            p10 = appInfo.p();
        } finally {
            try {
            } finally {
            }
        }
        if (TextUtils.isEmpty(p10)) {
            return;
        }
        String[] split = p10.split(",");
        if (split != null && split.length > 0) {
            for (String str : split) {
                if (c(str) || b(str) || !p()) {
                    this.installWayQueue.offer(str);
                }
            }
        }
    }

    private boolean b(String str) {
        AppInfo appInfo;
        return (!"7".equals(str) || (appInfo = this.appInfo) == null || TextUtils.isEmpty(appInfo.h())) ? false : true;
    }

    private boolean c(String str) {
        return !TextUtils.isEmpty(str) && (str.equals("8") || str.equals("6") || str.equals("5"));
    }

    private boolean p() {
        AppInfo appInfo = this.appInfo;
        return appInfo == null || TextUtils.isEmpty(appInfo.Code()) || TextUtils.isEmpty(this.appInfo.Z()) || I(this.appInfo) || this.appInfo.B() <= 0;
    }

    private boolean q() {
        Integer num;
        return this.installWayQueue.size() > 1 && ((num = this.agdDownloadSource) == null || num.intValue() == 2);
    }

    public void B(int i10) {
        this.installResult = i10;
    }

    public void B(String str) {
        this.apptaskInfo = str;
    }

    public void C(int i10) {
        this.apiVer = i10;
    }

    public void C(String str) {
        this.contentId = str;
    }

    public void Code(AdContentData adContentData) {
        this.adContentData = adContentData;
    }

    public void Code(AppInfo appInfo) {
        this.appInfo = appInfo;
    }

    public void Code(Integer num) {
        if (this.downloadSource == null) {
            this.downloadSource = num;
        }
    }

    public void D(String str) {
        this.requestId = str;
    }

    @Override // com.huawei.openalliance.ad.download.DownloadTask
    public String F() {
        AppInfo appInfo = this.appInfo;
        if (appInfo != null) {
            return appInfo.Code();
        }
        return null;
    }

    public void F(String str) {
        this.userId = str;
    }

    public void I(long j10) {
        this.startTime = j10;
    }

    public void I(Integer num) {
        this.agdDownloadSource = num;
    }

    public void I(String str) {
        this.showId = str;
    }

    public AppInfo L() {
        AppInfo appInfo = this.appInfo;
        if (appInfo != null && TextUtils.isEmpty(appInfo.e())) {
            this.appInfo.V(UUID.randomUUID().toString());
        }
        return this.appInfo;
    }

    public void L(String str) {
        this.curInstallWay = str;
    }

    public void S(String str) {
        this.customData = str;
    }

    public void V(Integer num) {
        this.downloadSourceMutable = num;
    }

    public void Z(String str) {
        this.slotId = str;
    }

    public Integer a() {
        return this.downloadSourceMutable;
    }

    public void a(String str) {
        this.templateId = str;
    }

    public Integer b() {
        return this.downloadSource;
    }

    public Integer c() {
        return this.agdDownloadSource;
    }

    public String d() {
        return this.showId;
    }

    public String e() {
        return this.contentId;
    }

    @Override // com.huawei.openalliance.ad.download.DownloadTask
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public AdContentData f() {
        return this.adContentData;
    }

    public String g() {
        return this.customData;
    }

    public String h() {
        return this.userId;
    }

    @Override // com.huawei.openalliance.ad.download.DownloadTask
    public int hashCode() {
        return super.hashCode();
    }

    public String i() {
        return this.requestId;
    }

    public String j() {
        if (!TextUtils.isEmpty(this.curInstallWay)) {
            return this.curInstallWay;
        }
        AppInfo appInfo = this.appInfo;
        return appInfo != null ? appInfo.g() : "4";
    }

    public boolean k() {
        return "7".equals(j());
    }

    public boolean l() {
        boolean z10 = false;
        if (!q()) {
            return false;
        }
        if (this.installWayQueue.poll() != null && !this.installWayQueue.isEmpty()) {
            z10 = true;
        }
        L(this.installWayQueue.peek());
        return z10;
    }

    public boolean m() {
        AppInfo appInfo = this.appInfo;
        return (appInfo == null || TextUtils.isEmpty(appInfo.Code()) || !c(j())) ? false : true;
    }

    public int n() {
        return this.installResult;
    }

    public long o() {
        return this.startTime;
    }
}
