package com.autonavi.base.ae.gmap.bean;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.huawei.openalliance.ad.constant.u;
import java.io.File;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class InitStorageParam {
    private static final String DIR_NAME = "terrain_dem_files";
    private static final String INIT_STORAGE_DIR = "mapcache";

    @JBindingInclude
    private int maxFileCount;

    @JBindingInclude
    private long maxFileSize;

    @JBindingInclude
    private String path;

    @JBindingInclude
    private int version;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class Holder {
        private static String sPath;

        public static void initPath(String str) {
            File file = new File(str);
            File file2 = new File(file, InitStorageParam.INIT_STORAGE_DIR);
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdir();
                }
                File file3 = new File(file2, InitStorageParam.DIR_NAME);
                if (!file3.exists()) {
                    file3.mkdir();
                }
                sPath = file3.getAbsolutePath();
            }
        }
    }

    private InitStorageParam(int i10, String str, int i11, long j10) {
        this.version = i10;
        this.path = str;
        this.maxFileCount = i11;
        this.maxFileSize = j10;
    }

    @JBindingInclude
    public static InitStorageParam obtain() {
        return new InitStorageParam();
    }

    @JBindingInclude
    public int getMaxFileCount() {
        return this.maxFileCount;
    }

    @JBindingInclude
    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    @JBindingInclude
    public String getPath() {
        return this.path;
    }

    @JBindingInclude
    public int getVersion() {
        return this.version;
    }

    @JBindingInclude
    public void setMaxFileCount(int i10) {
        this.maxFileCount = i10;
    }

    @JBindingInclude
    public void setMaxFileSize(long j10) {
        this.maxFileSize = j10;
    }

    @JBindingInclude
    public void setPath(String str) {
        this.path = str;
    }

    @JBindingInclude
    public void setVersion(int i10) {
        this.version = i10;
    }

    public String toString() {
        return "InitStorageParam{version=" + this.version + ", maxFileCount=" + this.maxFileCount + ", maxFileSize=" + this.maxFileSize + ", path='" + this.path + "'}";
    }

    @JBindingInclude
    public static InitStorageParam obtain(int i10, String str, int i11, long j10) {
        return new InitStorageParam(i10, str, i11, j10);
    }

    private InitStorageParam() {
        this(1, Holder.sPath, 1000, u.as);
    }
}
