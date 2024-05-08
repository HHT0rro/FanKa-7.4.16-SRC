package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class f1 extends h1 {
    public f1(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static f1 j(Context context, String str, int i10) {
        fc.c.l("delete  messages when db size is too bigger");
        String c4 = k1.b(context).c(str);
        if (TextUtils.isEmpty(c4)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rowDataId in (select ");
        sb2.append("rowDataId from " + c4);
        sb2.append(" order by createTimeStamp asc");
        sb2.append(" limit ?)");
        return new f1(str, sb2.toString(), new String[]{String.valueOf(i10)}, "a job build to delete history message");
    }

    @Override // com.xiaomi.push.k1.a
    public void f(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a10 = p1.a(c());
            long j10 = d1.f47169b;
            if (a10 <= j10) {
                fc.c.l("db size is suitable");
                return;
            }
            long j11 = (long) ((((a10 - j10) * 1.2d) / j10) * longValue);
            k(j11);
            z0.b(context).i("begin delete " + j11 + "noUpload messages , because db size is " + a10 + "B");
            super.f(context, obj);
        }
    }

    public final void k(long j10) {
        String[] strArr = this.f47896j;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        strArr[0] = String.valueOf(j10);
    }
}
