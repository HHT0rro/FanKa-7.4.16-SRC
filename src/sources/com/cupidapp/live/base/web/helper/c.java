package com.cupidapp.live.base.web.helper;

import android.os.Build;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Locale;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: WebViewDataDirectoryHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f13100a = new c();

    public final boolean a() {
        String MANUFACTURER = Build.MANUFACTURER;
        s.h(MANUFACTURER, "MANUFACTURER");
        Locale locale = Locale.getDefault();
        s.h(locale, "getDefault()");
        String lowerCase = MANUFACTURER.toLowerCase(locale);
        s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return s.d(lowerCase, "huawei");
    }

    public final void b(File file, boolean z10) {
        if (z10) {
            try {
                if (file.exists()) {
                    return;
                }
                file.createNewFile();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003d A[Catch: Exception -> 0x011d, TryCatch #0 {Exception -> 0x011d, blocks: (B:6:0x000c, B:10:0x0031, B:15:0x003d, B:16:0x0046, B:18:0x0076, B:19:0x00fe, B:20:0x0102, B:22:0x0108, B:25:0x0119, B:32:0x008f, B:34:0x00d1), top: B:5:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0076 A[Catch: Exception -> 0x011d, TryCatch #0 {Exception -> 0x011d, blocks: (B:6:0x000c, B:10:0x0031, B:15:0x003d, B:16:0x0046, B:18:0x0076, B:19:0x00fe, B:20:0x0102, B:22:0x0108, B:25:0x0119, B:32:0x008f, B:34:0x00d1), top: B:5:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(@org.jetbrains.annotations.NotNull android.content.Context r9) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.web.helper.c.c(android.content.Context):void");
    }

    public final void d(File file) {
        try {
            FileLock tryLock = new RandomAccessFile(file, "rw").getChannel().tryLock();
            if (tryLock != null) {
                tryLock.close();
            } else {
                b(file, file.delete());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            b(file, file.exists() ? file.delete() : false);
        }
    }
}
