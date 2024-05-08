package com.kuaishou.weapon.p0;

import android.os.Build;
import android.text.TextUtils;
import io.flutter.plugins.imagepicker.ImagePickerCache;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kuaishou.weapon.p0.do, reason: invalid class name */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class Cdo {

    /* renamed from: com.kuaishou.weapon.p0.do$a */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class a {
        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, ImagePickerCache.MAP_KEY_PATH_LIST).get(classLoader);
            Field a10 = dq.a(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) a10.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            a10.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$b */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, ImagePickerCache.MAP_KEY_PATH_LIST).get(classLoader);
            Field a10 = dq.a(obj, "nativeLibraryDirectories");
            Collection collection = (List) a10.get(obj);
            if (collection == null) {
                collection = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(collection);
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                if (file.equals((File) iterator2.next())) {
                    return;
                }
            }
            arrayList.add(file);
            a10.set(obj, arrayList);
            if (a10.get(obj) != arrayList) {
                dq.b(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object obj2 = (Object[]) dq.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field a11 = dq.a(obj, "nativeLibraryPathElements");
            a11.set(obj, obj2);
            if (a11.get(obj) != obj2) {
                dq.b(obj, "nativeLibraryPathElements").set(obj, obj2);
            }
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$c */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class c {
        private c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, ImagePickerCache.MAP_KEY_PATH_LIST).get(classLoader);
            List list = (List) dq.a(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (file.equals((File) iterator2.next())) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            dq.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dq.a(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$d */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class d {
        private d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            Object obj = dq.a(classLoader, ImagePickerCache.MAP_KEY_PATH_LIST).get(classLoader);
            List list = (List) dq.a(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            Iterator iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (file.equals((File) iterator2.next())) {
                    return;
                }
            }
            list.add(file);
            List list2 = (List) dq.a(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            dq.a(obj, "nativeLibraryPathElements").set(obj, (Object[]) dq.a(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }
    }

    /* renamed from: com.kuaishou.weapon.p0.do$e */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class e {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(ClassLoader classLoader, File file) {
            String str;
            String path = file.getPath();
            Field a10 = dq.a(classLoader, "libPath");
            String valueOf = String.valueOf(a10.get(classLoader));
            if (TextUtils.isEmpty(valueOf)) {
                str = path;
            } else {
                str = valueOf + com.huawei.openalliance.ad.constant.u.bD + path;
            }
            a10.set(classLoader, str);
            Field a11 = dq.a(classLoader, "libraryPathElements");
            List list = (List) a11.get(classLoader);
            Iterator iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (path.equals((String) iterator2.next())) {
                    return;
                }
            }
            list.add(path);
            a11.set(classLoader, list);
        }
    }

    public static synchronized void a(ClassLoader classLoader, File file) {
        synchronized (Cdo.class) {
            if (file != null) {
                if (file.exists()) {
                    int i10 = Build.VERSION.SDK_INT;
                    if ((i10 == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || i10 > 25) {
                        try {
                            d.b(classLoader, file);
                            return;
                        } catch (Throwable unused) {
                            b.b(classLoader, file);
                            return;
                        }
                    } else if (i10 == 24) {
                        try {
                            c.b(classLoader, file);
                            return;
                        } finally {
                            return;
                        }
                    } else {
                        if (i10 >= 23) {
                            try {
                                b.b(classLoader, file);
                                return;
                            } finally {
                                return;
                            }
                        }
                        a.b(classLoader, file);
                        return;
                    }
                }
            }
        }
    }
}
