package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.poisearch.PoiSearchV2;

/* compiled from: PoiHandler.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
abstract class ac<T, V> extends f<T, V> {
    public ac(Context context, T t2) {
        super(context, t2);
    }

    public static String a(PoiSearchV2.ShowFields showFields) {
        if (showFields == null || showFields.getValue() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if ((showFields.getValue() & 1) != 0) {
            sb2.append("children,");
        }
        if ((showFields.getValue() & 2) != 0) {
            sb2.append("business,");
        }
        if ((showFields.getValue() & 4) != 0) {
            sb2.append("indoor,");
        }
        if ((showFields.getValue() & 8) != 0) {
            sb2.append("navi,");
        }
        if ((showFields.getValue() & 16) != 0) {
            sb2.append("photos,");
        }
        if (sb2.length() <= 0) {
            return null;
        }
        sb2.replace(sb2.length() - 1, sb2.length(), "");
        return sb2.toString();
    }

    public static boolean c(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }
}
