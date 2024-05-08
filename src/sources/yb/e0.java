package yb;

import android.database.Cursor;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* compiled from: Utils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e0 {
    public static List<Object> a(Cursor cursor, int i10) {
        ArrayList arrayList = new ArrayList(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            Object b4 = b(cursor, i11);
            if (zb.a.f55048c) {
                String str = null;
                if (b4 != null) {
                    str = b4.getClass().isArray() ? "array(" + b4.getClass().getComponentType().getName() + ")" : b4.getClass().getName();
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("column ");
                sb2.append(i11);
                sb2.append(" ");
                sb2.append(cursor.getType(i11));
                sb2.append(": ");
                sb2.append(b4);
                sb2.append(str == null ? "" : " (" + str + ")");
            }
            arrayList.add(b4);
        }
        return arrayList;
    }

    public static Object b(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i10));
        }
        if (type == 3) {
            return cursor.getString(i10);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i10);
    }

    @RequiresApi(api = 21)
    public static Locale c(String str) {
        return Locale.forLanguageTag(str);
    }

    public static Locale d(String str) {
        return c(str);
    }
}
