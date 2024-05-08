package com.huawei.flexiblelayout;

import android.text.TextUtils;
import android.view.View;
import androidx.collection.ArrayMap;
import com.huawei.flexiblelayout.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: ElementSelectExecutor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f28116a = "ESExecutor";

    /* renamed from: b, reason: collision with root package name */
    private static Pattern f28117b = Pattern.compile("((\\s+|((\\s+)~(\\s+)))+\\.[\\w-]+)+\\s*");

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, f0> f28118c;

    static {
        ArrayMap arrayMap = new ArrayMap();
        f28118c = arrayMap;
        arrayMap.put("~", i0.a());
        f28118c.put(" ", h0.a());
    }

    public static List<d0> a(View view, String str) {
        if (!a(str)) {
            Log.w(f28116a, "execute, is not selectExpr: " + str);
            return null;
        }
        int indexOf = str.indexOf(".");
        String trim = str.substring(0, indexOf).trim();
        if (TextUtils.isEmpty(trim)) {
            trim = " ";
        }
        String trim2 = str.substring(indexOf).trim();
        ArrayList arrayList = new ArrayList();
        a(arrayList, view, trim2, trim);
        return arrayList;
    }

    private static void a(List<d0> list, View view, String str, String str2) {
        int indexOf = str.indexOf(".", 1);
        if (indexOf <= 0) {
            f0 f0Var = f28118c.get(str2);
            if (f0Var != null) {
                list.addAll(f0Var.a(view, str));
                return;
            }
            return;
        }
        a(list, view, str, str2, indexOf);
    }

    private static void a(List<d0> list, View view, String str, String str2, int i10) {
        String trim = str.substring(0, i10).trim();
        String str3 = " ";
        int indexOf = trim.indexOf(" ");
        if (indexOf != -1) {
            str3 = trim.substring(indexOf).trim();
            trim = trim.substring(0, indexOf).trim();
        }
        f0 f0Var = f28118c.get(str2);
        if (f0Var != null) {
            list.clear();
            list.addAll(f0Var.a(view, trim));
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        list.clear();
        String trim2 = str.substring(i10).trim();
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            a(list, ((d0) iterator2.next()).a(), trim2, str3);
        }
    }

    private static boolean a(String str) {
        return f28117b.matcher(str).matches();
    }
}
