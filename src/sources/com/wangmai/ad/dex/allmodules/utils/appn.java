package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import com.wangmai.ad.dex.allmodules.utils.appf;
import com.wangmai.common.runnable.HasTypeRunnable;
import com.wangmai.common.utils.Utils;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.db.DownloadManager;
import com.wangmai.okhttp.model.Progress;
import com.wangmai.okserver.OkDownload;
import com.wangmai.okserver.download.DownloadListener;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: DownLoadUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appn {

    /* renamed from: appa, reason: collision with root package name */
    private final List<String> f46854appa;
    private int appb;
    private String appc;
    private boolean appd;
    private appq appe;
    private final Map<String, Integer> appf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DownLoadUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements HasTypeRunnable<appf.appq> {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ appm f46855appa;
        final /* synthetic */ int appb;
        final /* synthetic */ String appc;
        final /* synthetic */ Context appd;

        appa(appm appmVar, int i10, String str, Context context) {
            this.f46855appa = appmVar;
            this.appb = i10;
            this.appc = str;
            this.appd = context;
        }

        @Override // com.wangmai.common.runnable.HasTypeRunnable
        /* renamed from: appa, reason: merged with bridge method [inline-methods] */
        public void run(appf.appq appqVar) {
            String absolutePath;
            String str;
            try {
                String appa2 = appqVar.appa();
                appa.appa.appf.appd.appa("DownLoadUtil", "download-actualUrl", appa2);
                if (!appn.this.f46854appa.contains(appa2)) {
                    this.f46855appa.appb();
                    if (this.appb == 1) {
                        absolutePath = appn.this.appe.appa().getAbsolutePath();
                        str = Utils.md5Decode(appa2) + ".apk";
                    } else if (this.appb == 0) {
                        absolutePath = appn.this.appe.appc().getAbsolutePath();
                        str = Utils.md5Decode(appa2) + appa2.substring(appa2.lastIndexOf("."));
                    } else {
                        absolutePath = appn.this.appe.appb().getAbsolutePath();
                        str = Utils.md5Decode(appa2) + appa2.substring(appa2.lastIndexOf("."));
                    }
                    String str2 = absolutePath;
                    String str3 = str;
                    String str4 = str2 + File.separator + str3;
                    if (!new File(str4).exists()) {
                        appa.appa.appf.appd.appa("DownLoadUtil", "【file not exists start download】", str2, str3, appa2, Integer.valueOf(this.appb));
                        appn.this.f46854appa.add(appa2);
                        appn.this.appb(this.appc, appa2, this.appd, appo.appa(appa2), str2, str3, this.f46855appa);
                        return;
                    } else {
                        appa.appa.appf.appd.appa("DownLoadUtil", "【file already exists local path】:" + str4);
                        this.f46855appa.appa(str4);
                        return;
                    }
                }
                appa.appa.appf.appd.appa("DownLoadUtil", "【file downloading....】");
                this.f46855appa.appc();
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("DownLoadUtil", "urlIsValidForApk-run exception:" + th.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DownLoadUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb extends DownloadListener {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Context f46856appa;
        final /* synthetic */ int appb;
        final /* synthetic */ String appc;
        final /* synthetic */ appm appd;
        final /* synthetic */ String appe;
        final /* synthetic */ String appf;
        final /* synthetic */ String appg;
        final /* synthetic */ String apph;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        appb(Object obj, Context context, int i10, String str, appm appmVar, String str2, String str3, String str4, String str5) {
            super(obj);
            this.f46856appa = context;
            this.appb = i10;
            this.appc = str;
            this.appd = appmVar;
            this.appe = str2;
            this.appf = str3;
            this.appg = str4;
            this.apph = str5;
        }

        @Override // com.wangmai.okserver.ProgressListener
        /* renamed from: appa, reason: merged with bridge method [inline-methods] */
        public void onFinish(File file, Progress progress) {
            try {
                appa.appa.appf.appd.appa("DownLoadUtil", "onFinish  " + ((Object) progress));
                appn.this.f46854appa.remove(this.appe);
                appn.this.appf.remove(this.appe);
                appa.appa.appf.appd.appa("DownLoadUtil", "下载完毕,文件信息:", this.apph, Integer.valueOf(appn.this.appb), Boolean.valueOf(appn.this.appd));
                if (this.appd != null) {
                    this.appd.appa(this.apph);
                }
                if (appn.this.appd) {
                    return;
                }
                appa.appa.appf.appd.appa("DownLoadUtil", "dateTime----bitmap");
                String str = this.appc;
                if (appn.this.appb == 1) {
                    str = Utils.getAppName(this.f46856appa, this.apph);
                }
                appo.appa(this.f46856appa, this.appb, this.appg + File.separator + this.appc, str + "下载完成", appn.this.appc);
            } catch (Throwable th) {
                appa.appa.appf.appd.appe("DownLoadUtil", "文件下载完成，处理异常：" + th.toString());
            }
        }

        @Override // com.wangmai.okserver.ProgressListener
        public void onError(Progress progress) {
            appa.appa.appf.appd.appa("DownLoadUtil", "onError:" + progress.exception.getMessage());
            int intValue = appn.this.appf.get(this.appe) != null ? ((Integer) appn.this.appf.get(this.appe)).intValue() : 0;
            if (intValue < 2) {
                OkDownload.getInstance().getTask(this.appe).remove(true);
                appn.this.appb(this.appf, this.appe, this.f46856appa, this.appb, this.appg, this.appc, this.appd);
                appn.this.appf.put(this.appe, Integer.valueOf(intValue + 1));
                return;
            }
            appa.appa.appf.appd.appe("DownLoadUtil", "download failed:" + progress.exception.getMessage());
            appn.this.f46854appa.remove(this.appe);
            try {
                File file = new File(this.apph);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable unused) {
            }
            if (!appn.this.appd) {
                appo.appa(this.f46856appa, this.appb, "下载失败", "下载失败：" + this.appc);
            }
            appm appmVar = this.appd;
            if (appmVar != null) {
                appmVar.appa();
            }
            OkDownload.getInstance().getTask(this.appe).unRegister(this);
        }

        @Override // com.wangmai.okserver.ProgressListener
        public void onProgress(Progress progress) {
            appa.appa.appf.appd.appa("DownLoadUtil", "onProgress  " + ((Object) progress));
            int i10 = (int) ((((float) progress.currentSize) / ((float) progress.totalSize)) * ((float) 100));
            if (!appn.this.appd) {
                appo.appa(this.f46856appa, this.appb, i10, 100, "正在下载:" + this.appc, "下载进度：" + i10 + "%");
            }
            appm appmVar = this.appd;
            if (appmVar != null) {
                appmVar.appa(i10);
            }
        }

        @Override // com.wangmai.okserver.ProgressListener
        public void onRemove(Progress progress) {
            appa.appa.appf.appd.appa("DownLoadUtil", "onRemove  " + ((Object) progress));
            appn.this.f46854appa.remove(this.appe);
        }

        @Override // com.wangmai.okserver.ProgressListener
        public void onStart(Progress progress) {
            appa.appa.appf.appd.appa("DownLoadUtil", "onStart  " + ((Object) progress));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DownLoadUtil.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class appc {

        /* renamed from: appa, reason: collision with root package name */
        private static final appn f46857appa = new appn(null);
    }

    /* synthetic */ appn(appa appaVar) {
        this();
    }

    private appn() {
        this.f46854appa = new ArrayList();
        this.appe = appq.appd();
        this.appf = new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appb(String str, String str2, Context context, int i10, String str3, String str4, appm appmVar) {
        try {
            OkDownload.restore(DownloadManager.getInstance().getAll());
            if (OkDownload.getInstance().hasTask(str2)) {
                appa.appa.appf.appd.appa("DownLoadUtil", "下载任务已存在actualUrl：" + str2 + "\tprogress" + ((Object) OkDownload.getInstance().getTask(str2).progress));
                OkDownload.getInstance().getTask(str2).register(appa(str, str2, context, i10, str3, str4, appmVar)).start();
            } else {
                appa.appa.appf.appd.appa("DownLoadUtil", "下载任务不存在actualUrl：" + str2);
                OkDownload.request(str2, OkHttp.get(str)).register(appa(str, str2, context, i10, str3, str4, appmVar)).folder(str3).fileName(str4).save().start();
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("DownLoadUtil", "startDownload error:" + th.toString());
        }
    }

    public static appn appa() {
        return appc.f46857appa;
    }

    public void appa(Context context, String str, boolean z10, int i10, String str2, appm appmVar) {
        if (appmVar == null) {
            return;
        }
        this.appb = i10;
        this.appc = str;
        this.appd = z10;
        appf.appa(str2, new appa(appmVar, i10, str2, context));
    }

    private DownloadListener appa(String str, String str2, Context context, int i10, String str3, String str4, appm appmVar) {
        return new appb(str2, context, i10, str4, appmVar, str2, str, str3, str3 + File.separator + str4);
    }

    public static String appa(long j10) {
        if (j10 <= 0) {
            return "0";
        }
        double d10 = j10;
        int log10 = (int) (Math.log10(d10) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.##").format(d10 / Math.pow(1024.0d, log10)) + " " + new String[]{"B", "kB", "MB", "GB", "TB"}[log10];
    }
}
