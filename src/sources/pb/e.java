package pb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import sun.util.locale.LanguageTag;

/* compiled from: MemoryCacheUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class e {

    /* compiled from: MemoryCacheUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.substring(0, str.lastIndexOf("_")).compareTo(str2.substring(0, str2.lastIndexOf("_")));
        }
    }

    public static Comparator<String> a() {
        return new a();
    }

    public static String b(String str, jb.c cVar) {
        return str + "_" + cVar.b() + LanguageTag.PRIVATEUSE + cVar.a();
    }

    public static void c(String str, hb.a aVar) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : aVar.keys()) {
            if (str2.startsWith(str)) {
                arrayList.add(str2);
            }
        }
        Iterator<E> iterator2 = arrayList.iterator2();
        while (iterator2.hasNext()) {
            aVar.remove((String) iterator2.next());
        }
    }
}
