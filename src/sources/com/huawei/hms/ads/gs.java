package com.huawei.hms.ads;

import android.os.Process;
import android.util.Log;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.text.SimpleDateFormat;
import org.apache.commons.io.IOUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class gs {
    private static final String Code = "HA";
    private String C;
    private String I;
    private int S;
    private String V;
    private int Z;
    private long B = 0;
    private final StringBuilder F = new StringBuilder();

    public gs(String str, int i10, String str2) {
        this.V = null;
        this.I = Code;
        this.Z = 0;
        this.V = str;
        this.Z = i10;
        if (str2 != null) {
            this.I = str2;
        }
        I();
    }

    private StringBuilder Code(StringBuilder sb2) {
        SimpleDateFormat Code2 = com.huawei.openalliance.ad.utils.v.Code("yyyy-MM-dd HH:mm:ss.SSS");
        sb2.append('[');
        sb2.append(Code2.format(Long.valueOf(this.B)));
        String Code3 = gp.Code(this.Z);
        sb2.append(' ');
        sb2.append(Code3);
        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb2.append(this.V);
        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb2.append(this.I);
        sb2.append(' ');
        sb2.append(this.S);
        sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        sb2.append(this.C);
        sb2.append(']');
        return sb2;
    }

    private gs I() {
        this.B = System.currentTimeMillis();
        this.C = Thread.currentThread().getName();
        this.S = Process.myPid();
        return this;
    }

    private StringBuilder V(StringBuilder sb2) {
        sb2.append(' ');
        sb2.append((CharSequence) this.F);
        return sb2;
    }

    public <T> gs Code(T t2) {
        this.F.append((Object) t2);
        return this;
    }

    public gs Code(Throwable th) {
        if (th != null) {
            Code((gs) '\n').Code((gs) Log.getStackTraceString(th));
        }
        return this;
    }

    public String Code() {
        StringBuilder sb2 = new StringBuilder();
        Code(sb2);
        return sb2.toString();
    }

    public String V() {
        StringBuilder sb2 = new StringBuilder();
        V(sb2);
        return sb2.toString();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Code(sb2);
        V(sb2);
        return sb2.toString();
    }
}
