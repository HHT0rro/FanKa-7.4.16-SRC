package com.huawei.hms.base.log;

import android.os.Process;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.android.internal.accessibility.common.ShortcutConstants;
import java.text.SimpleDateFormat;
import java.util.Locale;
import org.apache.commons.io.IOUtils;

/* compiled from: LogRecord.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private String f29619b;

    /* renamed from: c, reason: collision with root package name */
    private String f29620c;

    /* renamed from: d, reason: collision with root package name */
    private int f29621d;

    /* renamed from: g, reason: collision with root package name */
    private String f29624g;

    /* renamed from: h, reason: collision with root package name */
    private int f29625h;

    /* renamed from: i, reason: collision with root package name */
    private int f29626i;

    /* renamed from: j, reason: collision with root package name */
    private int f29627j;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f29618a = new StringBuilder();

    /* renamed from: e, reason: collision with root package name */
    private long f29622e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f29623f = 0;

    public e(int i10, String str, int i11, String str2) {
        this.f29620c = "HMS";
        this.f29627j = i10;
        this.f29619b = str;
        this.f29621d = i11;
        if (str2 != null) {
            this.f29620c = str2;
        }
        b();
    }

    public static String a(int i10) {
        return i10 != 3 ? i10 != 4 ? i10 != 5 ? i10 != 6 ? String.valueOf(i10) : ExifInterface.LONGITUDE_EAST : "W" : "I" : "D";
    }

    private e b() {
        this.f29622e = System.currentTimeMillis();
        Thread currentThread = Thread.currentThread();
        this.f29623f = currentThread.getId();
        this.f29625h = Process.myPid();
        StackTraceElement[] stackTrace = currentThread.getStackTrace();
        int length = stackTrace.length;
        int i10 = this.f29627j;
        if (length > i10) {
            StackTraceElement stackTraceElement = stackTrace[i10];
            this.f29624g = stackTraceElement.getFileName();
            this.f29626i = stackTraceElement.getLineNumber();
        }
        return this;
    }

    public String c() {
        StringBuilder sb2 = new StringBuilder();
        b(sb2);
        return sb2.toString();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        b(sb2);
        a(sb2);
        return sb2.toString();
    }

    public <T> e a(T t2) {
        this.f29618a.append((Object) t2);
        return this;
    }

    public e a(Throwable th) {
        a((e) '\n').a((e) Log.getStackTraceString(th));
        return this;
    }

    public String a() {
        StringBuilder sb2 = new StringBuilder();
        a(sb2);
        return sb2.toString();
    }

    private StringBuilder a(StringBuilder sb2) {
        sb2.append(' ');
        sb2.append(this.f29618a.toString());
        return sb2;
    }

    private StringBuilder b(StringBuilder sb2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
        sb2.append('[');
        sb2.append(simpleDateFormat.format(Long.valueOf(this.f29622e)));
        String a10 = a(this.f29621d);
        sb2.append(' ');
        sb2.append(a10);
        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb2.append(this.f29620c);
        sb2.append(IOUtils.DIR_SEPARATOR_UNIX);
        sb2.append(this.f29619b);
        sb2.append(' ');
        sb2.append(this.f29625h);
        sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        sb2.append(this.f29623f);
        sb2.append(' ');
        sb2.append(this.f29624g);
        sb2.append(ShortcutConstants.SERVICES_SEPARATOR);
        sb2.append(this.f29626i);
        sb2.append(']');
        return sb2;
    }
}
