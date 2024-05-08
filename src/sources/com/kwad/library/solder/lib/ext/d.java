package com.kwad.library.solder.lib.ext;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import io.flutter.plugins.imagepicker.ImagePickerCache;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, ImagePickerCache.MAP_KEY_PATH_LIST).get(classLoader);
            Field c4 = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) c4.get(obj);
            ArrayList arrayList = new ArrayList();
            for (File file2 : fileArr) {
                if (!file.equals(file2)) {
                    arrayList.add(file2);
                }
            }
            arrayList.add(file);
            c4.set(obj, arrayList.toArray(new File[0]));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, ImagePickerCache.MAP_KEY_PATH_LIST).get(classLoader);
            Field c4 = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories");
            Collection collection = (List) c4.get(obj);
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
            c4.set(obj, arrayList);
            if (c4.get(obj) != arrayList) {
                com.kwad.library.solder.lib.ext.e.d(obj, "nativeLibraryDirectories").set(obj, arrayList);
            }
            List list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list == null) {
                list = new ArrayList(2);
            }
            ArrayList arrayList2 = new ArrayList(arrayList.size() + list.size() + 1);
            arrayList2.addAll(arrayList);
            arrayList2.addAll(list);
            Object obj2 = (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList2, null, new ArrayList());
            Field c10 = com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements");
            c10.set(obj, obj2);
            if (c10.get(obj) != obj2) {
                com.kwad.library.solder.lib.ext.e.d(obj, "nativeLibraryPathElements").set(obj, obj2);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class c {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, ImagePickerCache.MAP_KEY_PATH_LIST).get(classLoader);
            List list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories").get(obj);
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
            List list2 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class, File.class, List.class).invoke(obj, arrayList, null, new ArrayList()));
        }
    }

    /* renamed from: com.kwad.library.solder.lib.ext.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class C0508d {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            Object obj = com.kwad.library.solder.lib.ext.e.c(classLoader, ImagePickerCache.MAP_KEY_PATH_LIST).get(classLoader);
            List list = (List) com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryDirectories").get(obj);
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
            List list2 = (List) com.kwad.library.solder.lib.ext.e.c(obj, "systemNativeLibraryDirectories").get(obj);
            if (list2 == null) {
                list2 = new ArrayList(2);
            }
            ArrayList arrayList = new ArrayList(list.size() + list2.size() + 1);
            arrayList.addAll(list);
            arrayList.addAll(list2);
            com.kwad.library.solder.lib.ext.e.c(obj, "nativeLibraryPathElements").set(obj, (Object[]) com.kwad.library.solder.lib.ext.e.b(obj, "makePathElements", List.class).invoke(obj, arrayList));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class e {
        /* JADX INFO: Access modifiers changed from: private */
        public static void d(ClassLoader classLoader, File file) {
            String str;
            String path = file.getPath();
            Field c4 = com.kwad.library.solder.lib.ext.e.c(classLoader, "libPath");
            String valueOf = String.valueOf(c4.get(classLoader));
            if (TextUtils.isEmpty(valueOf)) {
                str = path;
            } else {
                str = valueOf + u.bD + path;
            }
            c4.set(classLoader, str);
            Field c10 = com.kwad.library.solder.lib.ext.e.c(classLoader, "libraryPathElements");
            List list = (List) c10.get(classLoader);
            Iterator iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                if (path.equals((String) iterator2.next())) {
                    return;
                }
            }
            list.add(path);
            c10.set(classLoader, list);
        }
    }

    public static synchronized void c(ClassLoader classLoader, File file) {
        synchronized (d.class) {
            if (file != null) {
                if (file.exists()) {
                    int i10 = Build.VERSION.SDK_INT;
                    if ((i10 == 25 && Build.VERSION.PREVIEW_SDK_INT != 0) || i10 > 25) {
                        try {
                            C0508d.d(classLoader, file);
                            return;
                        } catch (Throwable th) {
                            com.kwad.library.solder.lib.a.e("Sodler.ShareLibraryLoader", String.format("installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(Build.VERSION.SDK_INT), th.getMessage()));
                            b.d(classLoader, file);
                            return;
                        }
                    }
                    if (i10 == 24) {
                        try {
                            c.d(classLoader, file);
                            return;
                        } finally {
                            a.d(classLoader, file);
                            return;
                        }
                    }
                    if (i10 >= 23) {
                        try {
                            b.d(classLoader, file);
                            return;
                        } finally {
                            a.d(classLoader, file);
                            return;
                        }
                    }
                    a.d(classLoader, file);
                    return;
                }
            }
            com.kwad.library.solder.lib.a.e("Sodler.ShareLibraryLoader", String.format("installNativeLibraryPath, folder %s is illegal", file));
        }
    }
}
