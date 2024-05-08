package dd;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* compiled from: WMPermission.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d {
    public static List<String> a(Activity activity, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (yc.a.c(activity, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static String[] b(List<String> list) {
        return (String[]) list.toArray(new String[list.size()]);
    }
}
