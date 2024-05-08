package com.baidu.mobads.sdk.internal;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class av extends au {

    /* renamed from: b, reason: collision with root package name */
    public static final String f9843b = "logout";

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f9844c = {"#", "#", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", "W", ExifInterface.LONGITUDE_EAST, "A"};

    @Override // com.baidu.mobads.sdk.internal.au, com.baidu.mobads.sdk.internal.aw.a
    @NonNull
    public String a() {
        return f9843b;
    }

    @Override // com.baidu.mobads.sdk.internal.au, com.baidu.mobads.sdk.internal.aw.a
    public void a(int i10, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory c4 = aa.a().c();
            if (c4 != null) {
                c4.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + f9844c[i10] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + "\n");
            }
        } catch (Throwable unused) {
        }
    }
}
