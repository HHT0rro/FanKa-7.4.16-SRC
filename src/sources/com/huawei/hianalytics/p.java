package com.huawei.hianalytics;

import android.content.Context;
import com.huawei.hianalytics.core.crypto.HexUtil;
import com.huawei.hianalytics.core.log.HiLog;
import java.io.File;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class p {
    public Context klm = c.klm().lmn().lmn();
    public String lmn;

    public p() {
        try {
            this.lmn = this.klm.getFilesDir().getCanonicalPath() + File.separator;
        } catch (IOException e2) {
            StringBuilder b4 = e9.a.b("get fileRootDirectory error!");
            b4.append(e2.getMessage());
            HiLog.e("ComponentManager", b4.toString());
        }
    }

    public static boolean klm(File file) {
        File[] listFiles;
        if (file == null || !file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (!file2.delete()) {
                    StringBuilder b4 = e9.a.b("delete file failed : ");
                    b4.append(file2.getName());
                    HiLog.i("ComponentManager", b4.toString());
                }
            } else if (file2.isDirectory()) {
                klm(file2);
            }
        }
        return file.delete();
    }

    public final void lmn(String str, String str2) {
        File file = new File(lmn(str));
        File file2 = new File(lmn(str), "hianalytics_" + str);
        if (!file.exists() && file.mkdirs()) {
            HiLog.i("ComponentManager", "file directory is mkdirs");
        }
        if (lmn(file2)) {
            g0.lmn(file2, str2);
        } else {
            HiLog.w("ComponentManager", "refreshComponent():file is not found,and file is create failed");
        }
    }

    public static boolean lmn() {
        File file;
        try {
            file = new File(c.klm().lmn.f28748e.getFilesDir().getCanonicalPath() + File.separator + "/hianalytics_");
        } catch (IOException e2) {
            StringBuilder b4 = e9.a.b("deleteComponentFile get pPath error!");
            b4.append(e2.getMessage());
            HiLog.e("ComponentManager", b4.toString());
            file = null;
        }
        return klm(file);
    }

    public final String klm(String str) {
        File file = new File(lmn(str), "hianalytics_" + str);
        if (lmn(file)) {
            return g0.lmn(file);
        }
        String initRandomKey = HexUtil.initRandomKey(128);
        g0.lmn(file, initRandomKey);
        return initRandomKey;
    }

    public final boolean lmn(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            HiLog.e("ComponentManager", "create new file error!");
            return false;
        }
    }

    public final String lmn(String str) {
        return this.lmn + "/hianalytics_/component/".replace("component", str);
    }
}
