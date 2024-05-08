package com.taobao.wireless.security.adapter.common;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: com.taobao.wireless.security.adapter.common.г, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0598 {

    /* renamed from: а, reason: contains not printable characters */
    private FileChannel f213 = null;

    /* renamed from: б, reason: contains not printable characters */
    private FileLock f214 = null;

    /* renamed from: в, reason: contains not printable characters */
    private RandomAccessFile f215 = null;

    /* renamed from: г, reason: contains not printable characters */
    private File f216 = null;

    /* renamed from: д, reason: contains not printable characters */
    private boolean f217;

    /* renamed from: е, reason: contains not printable characters */
    private String f218;

    /* renamed from: ё, reason: contains not printable characters */
    private Context f219;

    public C0598(Context context, String str) {
        this.f217 = true;
        this.f218 = null;
        this.f219 = null;
        this.f219 = context;
        this.f218 = str;
        this.f217 = m2887();
    }

    /* renamed from: в, reason: contains not printable characters */
    private boolean m2887() {
        try {
            File filesDir = this.f219.getFilesDir();
            if ((filesDir != null && filesDir.exists()) || ((filesDir = this.f219.getFilesDir()) != null && filesDir.exists())) {
                this.f216 = new File(filesDir.getAbsolutePath() + "/" + this.f218);
                if (!this.f216.exists()) {
                    this.f216.createNewFile();
                }
            }
        } catch (Exception unused) {
            File file = this.f216;
            if (file != null && !file.exists()) {
                try {
                    this.f216.createNewFile();
                } catch (Exception unused2) {
                }
            }
        }
        File file2 = this.f216;
        return file2 != null && file2.exists();
    }

    /* renamed from: а, reason: contains not printable characters */
    public boolean m2888() {
        if (!this.f217) {
            this.f217 = m2887();
            if (!this.f217) {
                return true;
            }
        }
        try {
            if (this.f216 == null) {
                return false;
            }
            this.f215 = new RandomAccessFile(this.f216, "rw");
            this.f213 = this.f215.getChannel();
            this.f214 = this.f213.lock();
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: б, reason: contains not printable characters */
    public boolean m2889() {
        boolean z10 = true;
        if (!this.f217) {
            return true;
        }
        try {
            if (this.f214 != null) {
                this.f214.release();
                this.f214 = null;
            }
        } catch (IOException unused) {
            z10 = false;
        }
        try {
            if (this.f213 != null) {
                this.f213.close();
                this.f213 = null;
            }
        } catch (IOException unused2) {
            z10 = false;
        }
        try {
            if (this.f215 == null) {
                return z10;
            }
            this.f215.close();
            this.f215 = null;
            return z10;
        } catch (IOException unused3) {
            return false;
        }
    }
}
