package com.alibaba.wireless.security.framework.utils;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* renamed from: com.alibaba.wireless.security.framework.utils.в, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class C0051 {

    /* renamed from: а, reason: contains not printable characters */
    private FileChannel f54 = null;

    /* renamed from: б, reason: contains not printable characters */
    private FileLock f55 = null;

    /* renamed from: в, reason: contains not printable characters */
    private RandomAccessFile f56 = null;

    /* renamed from: г, reason: contains not printable characters */
    private File f57 = null;

    /* renamed from: д, reason: contains not printable characters */
    private boolean f58;

    /* renamed from: е, reason: contains not printable characters */
    private String f59;

    public C0051(Context context, String str) {
        this.f58 = true;
        this.f59 = str;
        this.f58 = m1829();
    }

    /* renamed from: в, reason: contains not printable characters */
    private boolean m1829() {
        try {
            File file = new File(this.f59);
            this.f57 = file;
            if (!file.exists()) {
                this.f57.createNewFile();
            }
        } catch (Exception unused) {
            File file2 = this.f57;
            if (file2 != null && !file2.exists()) {
                try {
                    this.f57.createNewFile();
                } catch (Exception unused2) {
                }
            }
        }
        File file3 = this.f57;
        return file3 != null && file3.exists();
    }

    /* renamed from: а, reason: contains not printable characters */
    public boolean m1830() {
        if (!this.f58) {
            boolean m1829 = m1829();
            this.f58 = m1829;
            if (!m1829) {
                return true;
            }
        }
        try {
            if (this.f57 != null) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.f57, "rw");
                this.f56 = randomAccessFile;
                FileChannel channel = randomAccessFile.getChannel();
                this.f54 = channel;
                this.f55 = channel.lock();
                return true;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return false;
    }

    /* renamed from: б, reason: contains not printable characters */
    public boolean m1831() {
        boolean z10 = true;
        if (!this.f58) {
            return true;
        }
        try {
            FileLock fileLock = this.f55;
            if (fileLock != null) {
                fileLock.release();
                this.f55 = null;
            }
        } catch (IOException unused) {
            z10 = false;
        }
        try {
            FileChannel fileChannel = this.f54;
            if (fileChannel != null) {
                fileChannel.close();
                this.f54 = null;
            }
        } catch (IOException unused2) {
            z10 = false;
        }
        try {
            RandomAccessFile randomAccessFile = this.f56;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.f56 = null;
            }
            return z10;
        } catch (IOException unused3) {
            return false;
        }
    }
}
