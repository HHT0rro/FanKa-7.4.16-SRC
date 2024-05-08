package kc;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.ia;
import com.xiaomi.push.ip;
import com.xiaomi.push.n7;
import com.xiaomi.push.o6;
import com.xiaomi.push.p0;
import com.xiaomi.push.s7;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicLong f50875a = new AtomicLong(0);

    /* renamed from: b, reason: collision with root package name */
    public static SimpleDateFormat f50876b;

    /* renamed from: c, reason: collision with root package name */
    public static String f50877c;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        f50876b = simpleDateFormat;
        f50877c = simpleDateFormat.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static synchronized String a() {
        String str;
        synchronized (z.class) {
            String format = f50876b.format(Long.valueOf(System.currentTimeMillis()));
            if (!TextUtils.equals(f50877c, format)) {
                f50875a.set(0L);
                f50877c = format;
            }
            str = format + "-" + f50875a.incrementAndGet();
        }
        return str;
    }

    public static ArrayList<ip> b(List<hu> list, String str, String str2, int i10) {
        String str3;
        if (list == null) {
            str3 = "requests can not be null in TinyDataHelper.transToThriftObj().";
        } else {
            if (list.size() != 0) {
                ArrayList<ip> arrayList = new ArrayList<>();
                ht htVar = new ht();
                int i11 = 0;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    hu huVar = list.get(i12);
                    if (huVar != null) {
                        int length = o6.c(huVar).length;
                        if (length > i10) {
                            fc.c.n("TinyData is too big, ignore upload request item:" + huVar.d());
                        } else {
                            if (i11 + length > i10) {
                                ip ipVar = new ip("-1", false);
                                ipVar.d(str);
                                ipVar.b(str2);
                                ipVar.c(ia.UploadTinyData.f329a);
                                ipVar.a(s7.h(o6.c(htVar)));
                                arrayList.add(ipVar);
                                htVar = new ht();
                                i11 = 0;
                            }
                            htVar.a(huVar);
                            i11 += length;
                        }
                    }
                }
                if (htVar.a() != 0) {
                    ip ipVar2 = new ip("-1", false);
                    ipVar2.d(str);
                    ipVar2.b(str2);
                    ipVar2.c(ia.UploadTinyData.f329a);
                    ipVar2.a(s7.h(o6.c(htVar)));
                    arrayList.add(ipVar2);
                }
                return arrayList;
            }
            str3 = "requests.length is 0 in TinyDataHelper.transToThriftObj().";
        }
        fc.c.n(str3);
        return null;
    }

    public static void c(Context context, String str, String str2, long j10, String str3) {
        hu huVar = new hu();
        huVar.d(str);
        huVar.c(str2);
        huVar.a(j10);
        huVar.b(str3);
        huVar.a("push_sdk_channel");
        huVar.g(context.getPackageName());
        huVar.e(context.getPackageName());
        huVar.a(true);
        huVar.b(System.currentTimeMillis());
        huVar.f(a());
        a0.a(context, huVar);
    }

    public static boolean d(hu huVar, boolean z10) {
        String str;
        if (huVar == null) {
            str = "item is null, verfiy ClientUploadDataItem failed.";
        } else if (!z10 && TextUtils.isEmpty(huVar.f301a)) {
            str = "item.channel is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(huVar.f308d)) {
            str = "item.category is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (TextUtils.isEmpty(huVar.f307c)) {
            str = "item.name is null or empty, verfiy ClientUploadDataItem failed.";
        } else if (!p0.i(huVar.f308d)) {
            str = "item.category can only contain ascii char, verfiy ClientUploadDataItem failed.";
        } else if (p0.i(huVar.f307c)) {
            String str2 = huVar.f306b;
            if (str2 == null || str2.length() <= 10240) {
                return false;
            }
            str = "item.data is too large(" + huVar.f306b.length() + "), max size for data is 10240 , verfiy ClientUploadDataItem failed.";
        } else {
            str = "item.name can only contain ascii char, verfiy ClientUploadDataItem failed.";
        }
        fc.c.i(str);
        return true;
    }

    public static boolean e(String str) {
        return !n7.j() || "com.miui.hybrid".equals(str);
    }
}
