package com.ss.android.downloadlib.addownload.ej;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {

    /* renamed from: m, reason: collision with root package name */
    private static volatile l f38601m;
    private long dk = 0;
    private ConcurrentHashMap<String, np> ej = new ConcurrentHashMap<>();

    /* renamed from: l, reason: collision with root package name */
    private HashMap<String, Integer> f38602l = new HashMap<>();
    private List<String> np = new CopyOnWriteArrayList();

    public static l m() {
        if (f38601m == null) {
            synchronized (l.class) {
                if (f38601m == null) {
                    f38601m = new l();
                }
            }
        }
        return f38601m;
    }

    public long dk() {
        return this.dk;
    }

    public void ej() {
        this.dk = System.currentTimeMillis();
    }

    public int dk(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (this.f38602l == null) {
            this.f38602l = new HashMap<>();
        }
        if (this.f38602l.containsKey(str)) {
            return this.f38602l.get(str).intValue();
        }
        return 0;
    }

    public void m(String str, np npVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ej.put(str, npVar);
    }

    public void m(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.ej.remove(str);
    }

    @WorkerThread
    public static void m(com.ss.android.downloadad.api.m.dk dkVar) {
        DownloadInfo downloadInfo;
        if (dkVar == null || dkVar.dk() <= 0 || (downloadInfo = Downloader.getInstance(c.getContext()).getDownloadInfo(dkVar.x())) == null) {
            return;
        }
        m(downloadInfo);
    }

    @WorkerThread
    public static void m(DownloadInfo downloadInfo) {
        if (downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("delete_file_after_install", 0) == 0) {
            return;
        }
        try {
            String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                file.delete();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
