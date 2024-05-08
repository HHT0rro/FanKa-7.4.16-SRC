package com.huawei.hms.ads;

import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class gk extends gj {
    private static final long I = 4194304;
    private static final String V = "FileLogNode";
    private File Z;

    private gk() {
    }

    public static gq Code() {
        return new go(new gk());
    }

    private static void Code(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void Code(String str) {
        if (str == null || this.Z == null) {
            return;
        }
        String str2 = str + '\n';
        if (V(str2)) {
            I(str2);
        }
    }

    private void I(String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        OutputStreamWriter outputStreamWriter;
        OutputStreamWriter outputStreamWriter2 = null;
        try {
            fileOutputStream = new FileOutputStream(this.Z, true);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                try {
                    outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
                } catch (FileNotFoundException | IOException unused) {
                } catch (Throwable th) {
                    th = th;
                }
            } catch (FileNotFoundException | IOException unused2) {
                bufferedOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
            }
        } catch (FileNotFoundException | IOException unused3) {
            fileOutputStream = null;
            bufferedOutputStream = null;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            bufferedOutputStream = null;
        }
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            Code(outputStreamWriter);
        } catch (FileNotFoundException | IOException unused4) {
            outputStreamWriter2 = outputStreamWriter;
            Code(outputStreamWriter2);
            Code(bufferedOutputStream);
            Code(fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            outputStreamWriter2 = outputStreamWriter;
            Code(outputStreamWriter2);
            Code(bufferedOutputStream);
            Code(fileOutputStream);
            throw th;
        }
        Code(bufferedOutputStream);
        Code(fileOutputStream);
    }

    private boolean V(String str) {
        if (this.Z.length() + str.length() > 4194304) {
            File file = new File(this.Z.getPath() + ".bak");
            if (!(file.exists() ? file.delete() : true) || !this.Z.renameTo(file)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.huawei.hms.ads.gq
    public gq Code(String str, String str2) {
        if (str2 != null && !str2.isEmpty() && this.Z == null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    File canonicalFile = new File(str, "Log").getCanonicalFile();
                    if (canonicalFile.isDirectory() || com.huawei.openalliance.ad.utils.p.Code(canonicalFile)) {
                        File file = new File(canonicalFile, str2 + ".log");
                        this.Z = file;
                        file.setReadable(true);
                        this.Z.setWritable(true);
                        this.Z.setExecutable(false, false);
                        return this;
                    }
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("file path error. ");
                sb2.append(th.getClass().getSimpleName());
            }
        }
        return this;
    }

    @Override // com.huawei.hms.ads.gq
    public void Code(gs gsVar, int i10, String str) {
        if (gsVar == null) {
            return;
        }
        Code(gsVar.Code() + gsVar.V());
        gq gqVar = this.Code;
        if (gqVar != null) {
            gqVar.Code(gsVar, i10, str);
        }
    }
}
