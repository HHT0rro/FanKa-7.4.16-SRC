package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.k1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g1 extends k1.b<Long> {

    /* renamed from: q, reason: collision with root package name */
    public long f47314q;

    /* renamed from: r, reason: collision with root package name */
    public String f47315r;

    public g1(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i10, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i10);
        this.f47314q = 0L;
        this.f47315r = str6;
    }

    public static g1 k(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new g1(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    @Override // com.xiaomi.push.k1.a
    public Object b() {
        return Long.valueOf(this.f47314q);
    }

    @Override // com.xiaomi.push.k1.b
    public void j(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.f47314q = list.get(0).longValue();
    }

    @Override // com.xiaomi.push.k1.b
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Long i(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }
}
