package com.ishumei.smantifraud.l111l11111I1l;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Base64;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.flexiblelayout.n;
import com.huawei.quickcard.base.Attributes;
import com.kuaishou.weapon.p0.an;
import com.kuaishou.weapon.p0.g;
import com.nirvana.tools.logger.cache.db.DBHelpTool;
import dalvik.system.BaseDexClassLoader;
import io.flutter.plugins.imagepicker.ImagePickerCache;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l1111l111111Il {
    private static final String l1111l111111Il = "eJy1Wt9P5DYQ/l9WPPQktBHcG1SVDriiVYFbEdpKoHtwkiHrrmOnsbPAnfq/d5xNgpM4u9k4vOyheH5883k8Htv39HO2hrfZ2QwYJMDV7HgWMvLjB36JCNvQtSffpILEu4LXJVGrGyrV0ddaNgG1EhEKK+GrjPIYv0ka44dfPt38QzbEY4TH3nbsHAdTkpFkdvb0/Xim3lKYnZ38d1xBoFwu17GBgPAoEzTySJp6X9KU0ZAoKviShGsSwy3h+JuZKGJQCy4VYQyiUkq+I1qUkHJFmacDMQGhdzWzoZIpWj2xoBLS8wtulplIIVO08GVieXfd5WI3PTM9ONeD85LXGtppC9rp5NDcwR4PxA/hFkobf5qJDY0g83xQCrXlkQ9hnkEriHbK3VT6oeAKE9S73P57D1KwDWSHR1YanJcG5y2DQwONYGPLIIWLLl0J/uY9VH/Zk/oKNjSEReSyuhCDLVUcMCz2kNe3ojiu4g0YWN6tZPDMIFTerYjoM21ioPKuUqxIeLTF3OA9yG0FBdfHVTlkmC8+YeA4yRxBQHSAp5iJgLCh2XxdSHcql3JL5cUHZG6Wc4TfV5NDnA+qehLmPucczWLhxioUgpRmLd5Vim05gzgUkWsXIA+o77wbIA4JmV4JLlD8rQlnNOiQ8ufe6Rm4ZRpyi6213q0BYbYTM028loF9e0NfNOk6niCacnBcJIby2Ciwi0G4U3UxhoJztsArhNaqi1mpaNLYXUvZQe1LubwH9i/mhKdRsanQyIAVisSrKMNIIOOEGbvUEn8BPb6+fcAeGcvkcESo5F37twWwD8CUyjwYSZOfB+UymBoUZgt16mgWaMAVgFM70wQwtpUJVEJCC4yA5aCEUCvvovrrS0RS1a29UZTh2nGhIgTGmLChGEzGJZq4EdsyY0LpGjIlhwALVxiIba9sp6oiCnQlA95EJ7jp8rIwZ6TuPoif/rI1RbXwvBG5LQgUdUr0G8rh5C5PgmJk9CSjP6d0t8IYm/U0DGnkxIpPE+yBKGHuzBRgnLjpBTP6gIMrPnXi5w7Ui8jW3/DwTpRw4qcA48RPLxgnfjhJYEqO7kgCzjxpUFNy1QQ1li9JE8d8whSfIpcKIK5rbbo8KuA455EByTWHakBTcTRN/tBEunVr2EjKMKNYHF3bRunWtdmBjOUlXYUi57Yrm8GAiublsrRS8bLYQ8OLvWnECuS90Gfq/Y0/lsb9loQTtItSNs4RQ537/uLKxW2Gfke4vd+qDWUWzY2Krizbjeze5ysYyeSFK5XooPhmd12F0nX8sFU6gEs8eo7y5Nd6w51RfVxw23ppvAqEZlB39c0LoEPvGwkeXRzxfGHMHYcMCc/6JqDOsp5iibr3IHOmHC5etQ+pD2fjMOgRv1QfXB711T8nARvjk0o98LVQ33uBb179gGLEthWw8nToGQfkxskKP6o8MgO8GuCrsHOwL8HjQ50xItWaixduvyPouOw5P6KVP7SV7jWB7XKw1/qIS8Ly9USOB780TJSgH3feoAZCMCD2C4EApNKYxsO5QAsVJMtNRm3lMqNKn0vPH/f0N9W1RqU5rzRnu155zGoXRYyOJRiVr1OpF3kujRuc3rBq4aNK+ryxOrvhdDWsUcSp1JVq/MTUfgbBt6X5++CwgPpmgydAxk/HHWoPmYlvXEveYkOJRoZOhlXpA+LI4N8cF0ol8Wca4S6yc2Yq0fut5nm/RB1rLSIkDur/K/H+Sb/XLIFHuGgWxQNRz2VizUzLP8r2ihizU8kIOd8iML4hhHkDgv2K8rVZ2vXTAAqH+k0rISlJqVe+We4r8sL2CjiwmtuQPVPWOJsXVYwK73fKGk8lv1JO1W87t5QG9f1F7XPT+ekkzg+Gs6vsfm5sbUFOWdShyHxWu9ASzalqI36ahK8KTYezA9G0N1YLFD0414MmkO//A9zgF+k=";

    /* renamed from: com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static Map<String, Integer> l1111l111111Il() {
            Intent registerReceiver;
            HashMap hashMap = new HashMap();
            Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
            if (context == null) {
                return hashMap;
            }
            try {
                registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            } catch (Exception unused) {
            }
            if (registerReceiver == null) {
                return hashMap;
            }
            int intExtra = registerReceiver.getIntExtra("status", 0);
            int intExtra2 = registerReceiver.getIntExtra(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, 0);
            int intExtra3 = registerReceiver.getIntExtra(n.f28264e, 100);
            int intExtra4 = registerReceiver.getIntExtra("temperature", 0);
            int intExtra5 = registerReceiver.getIntExtra("voltage", 0);
            hashMap.put("status", Integer.valueOf(intExtra));
            hashMap.put(DBHelpTool.RecordEntry.COLUMN_NAME_LEVEL, Integer.valueOf(intExtra2));
            hashMap.put(n.f28264e, Integer.valueOf(intExtra3));
            hashMap.put("temp", Integer.valueOf(intExtra4));
            hashMap.put("vol", Integer.valueOf(intExtra5));
            return hashMap;
        }
    }

    /* renamed from: com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il$l1111l111111Il, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class C0353l1111l111111Il {
        private static int l1111l111111Il = 1;
        private static int l111l11111I1l = 3;
        private static int l111l11111lIl = 2;
        private String l111l11111Il;
        private String l111l1111l1Il;
        private List<String> l111l1111lI1l;
        private int l111l1111lIl;
        private String l111l1111llIl;

        private C0353l1111l111111Il() {
        }

        public /* synthetic */ C0353l1111l111111Il(byte b4) {
            this();
        }

        private String l111l1111l1Il() {
            return this.l111l11111Il;
        }

        public final String l1111l111111Il() {
            return this.l111l1111l1Il;
        }

        public final void l1111l111111Il(int i10) {
            this.l111l1111lIl = i10;
        }

        public final void l1111l111111Il(String str) {
            this.l111l11111Il = str;
        }

        public final void l1111l111111Il(List<String> list) {
            this.l111l1111lI1l = list;
        }

        public final List<String> l111l11111I1l() {
            return this.l111l1111lI1l;
        }

        public final void l111l11111I1l(String str) {
            this.l111l1111llIl = str;
        }

        public final int l111l11111Il() {
            return this.l111l1111lIl;
        }

        public final String l111l11111lIl() {
            return this.l111l1111llIl;
        }

        public final void l111l11111lIl(String str) {
            this.l111l1111l1Il = str;
        }
    }

    private static int l1111l111111Il(boolean z10) {
        return z10 ? 1 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0071 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0071 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Map<java.lang.String, java.lang.Object> l1111l111111Il() {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: java.lang.Exception -> Lf6
            r1.<init>()     // Catch: java.lang.Exception -> Lf6
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Exception -> Lf6
            java.lang.String r3 = l11l111l1Il()     // Catch: java.lang.Exception -> Lf6
            r2.<init>(r3)     // Catch: java.lang.Exception -> Lf6
            r3 = 0
            r4 = 0
        L15:
            int r5 = r2.length()     // Catch: java.lang.Exception -> Lf6
            if (r4 >= r5) goto L6d
            org.json.JSONObject r5 = r2.getJSONObject(r4)     // Catch: java.lang.Exception -> L6a
            java.lang.String r6 = "key"
            java.lang.String r6 = r5.getString(r6)     // Catch: java.lang.Exception -> L6a
            java.lang.String r7 = "clazz"
            java.lang.String r7 = r5.getString(r7)     // Catch: java.lang.Exception -> L6a
            java.lang.String r8 = "method"
            java.lang.String r8 = r5.getString(r8)     // Catch: java.lang.Exception -> L6a
            java.lang.String r9 = "param"
            org.json.JSONArray r9 = r5.getJSONArray(r9)     // Catch: java.lang.Exception -> L6a
            java.lang.String r10 = "type"
            int r5 = r5.getInt(r10)     // Catch: java.lang.Exception -> L6a
            com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il$l1111l111111Il r10 = new com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il$l1111l111111Il     // Catch: java.lang.Exception -> L6a
            r10.<init>(r3)     // Catch: java.lang.Exception -> L6a
            r10.l1111l111111Il(r6)     // Catch: java.lang.Exception -> L6a
            r10.l111l11111lIl(r7)     // Catch: java.lang.Exception -> L6a
            r10.l111l11111I1l(r8)     // Catch: java.lang.Exception -> L6a
            r10.l1111l111111Il(r5)     // Catch: java.lang.Exception -> L6a
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch: java.lang.Exception -> L6a
            r5.<init>()     // Catch: java.lang.Exception -> L6a
            r6 = 0
        L54:
            int r7 = r9.length()     // Catch: java.lang.Exception -> L6a
            if (r6 >= r7) goto L64
            java.lang.String r7 = r9.getString(r6)     // Catch: java.lang.Exception -> L6a
            r5.add(r7)     // Catch: java.lang.Exception -> L6a
            int r6 = r6 + 1
            goto L54
        L64:
            r10.l1111l111111Il(r5)     // Catch: java.lang.Exception -> L6a
            r1.add(r10)     // Catch: java.lang.Exception -> L6a
        L6a:
            int r4 = r4 + 1
            goto L15
        L6d:
            java.util.Iterator r1 = r1.iterator2()     // Catch: java.lang.Exception -> Lf6
        L71:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Exception -> Lf6
            if (r2 == 0) goto Lf6
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Exception -> Lf6
            com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il$l1111l111111Il r2 = (com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.C0353l1111l111111Il) r2     // Catch: java.lang.Exception -> Lf6
            java.lang.String r4 = r2.l1111l111111Il()     // Catch: java.lang.Exception -> L71
            java.lang.String r5 = "/"
            java.lang.String r6 = "."
            java.lang.String r4 = r4.replace(r5, r6)     // Catch: java.lang.Exception -> L71
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.Exception -> L71
            int r5 = r2.l111l11111Il()     // Catch: java.lang.Exception -> L71
            java.util.List r6 = r2.l111l11111I1l()     // Catch: java.lang.Exception -> L71
            r7 = 3
            r8 = 1
            if (r5 != r7) goto Lc7
            if (r6 == 0) goto Lab
            int r5 = r6.size()     // Catch: java.lang.Exception -> L71
            if (r5 != 0) goto La2
            goto Lab
        La2:
            java.lang.Class[] r5 = l1111l111111Il(r6)     // Catch: java.lang.Exception -> L71
            java.lang.reflect.Constructor r4 = r4.getConstructor(r5)     // Catch: java.lang.Exception -> L71
            goto Lb1
        Lab:
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L71
            java.lang.reflect.Constructor r4 = r4.getConstructor(r5)     // Catch: java.lang.Exception -> L71
        Lb1:
            int r4 = r4.getModifiers()     // Catch: java.lang.Exception -> L71
            boolean r4 = java.lang.reflect.Modifier.isNative(r4)     // Catch: java.lang.Exception -> L71
            if (r4 == 0) goto L71
            java.lang.String r2 = r2.l1111l111111Il()     // Catch: java.lang.Exception -> L71
        Lbf:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Exception -> L71
            r0.put(r2, r4)     // Catch: java.lang.Exception -> L71
            goto L71
        Lc7:
            if (r6 == 0) goto Ldd
            int r5 = r6.size()     // Catch: java.lang.Exception -> L71
            if (r5 != 0) goto Ld0
            goto Ldd
        Ld0:
            java.lang.Class[] r5 = l1111l111111Il(r6)     // Catch: java.lang.Exception -> L71
            java.lang.String r6 = r2.l111l11111lIl()     // Catch: java.lang.Exception -> L71
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r6, r5)     // Catch: java.lang.Exception -> L71
            goto Le7
        Ldd:
            java.lang.String r5 = r2.l111l11111lIl()     // Catch: java.lang.Exception -> L71
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L71
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r5, r6)     // Catch: java.lang.Exception -> L71
        Le7:
            int r4 = r4.getModifiers()     // Catch: java.lang.Exception -> L71
            boolean r4 = java.lang.reflect.Modifier.isNative(r4)     // Catch: java.lang.Exception -> L71
            if (r4 == 0) goto L71
            java.lang.String r2 = r2.l1111l111111Il()     // Catch: java.lang.Exception -> L71
            goto Lbf
        Lf6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l1111l111111Il():java.util.Map");
    }

    private static void l1111l111111Il(Class<?> cls, String str, Set<Object> set) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            set.addAll(((Map) declaredField.get(null)).h());
        } catch (Throwable unused) {
        }
    }

    private static boolean l1111l111111Il(ClassLoader classLoader, String str) {
        if (classLoader == null || !(classLoader instanceof BaseDexClassLoader)) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("dalvik.system.DexPathList");
            Method method = Class.forName("dalvik.system.DexPathList$Element").getMethod("toString", null);
            Field declaredField = cls.getDeclaredField("dexElements");
            declaredField.setAccessible(true);
            Field declaredField2 = BaseDexClassLoader.class.getDeclaredField(ImagePickerCache.MAP_KEY_PATH_LIST);
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField.get(declaredField2.get(classLoader));
            for (Object obj : objArr) {
                String str2 = (String) method.invoke(obj, null);
                if (str2 != null && str2.contains(str)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static boolean l1111l111111Il(String str) {
        try {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            if (l1111l111111Il(systemClassLoader, str) || l1111l111111Il(systemClassLoader.getParent(), str)) {
                return true;
            }
            ClassLoader classLoader = l1111l111111Il.class.getClassLoader();
            if (l1111l111111Il(classLoader, str)) {
                return true;
            }
            return l1111l111111Il(classLoader.getParent(), str);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0027. Please report as an issue. */
    private static Class[] l1111l111111Il(List<String> list) {
        GenericDeclaration genericDeclaration;
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            str.hashCode();
            char c4 = 65535;
            switch (str.hashCode()) {
                case -1325958191:
                    if (str.equals("double")) {
                        c4 = 0;
                        break;
                    }
                    break;
                case 104431:
                    if (str.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 3039496:
                    if (str.equals("byte")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 3052374:
                    if (str.equals("char")) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 3327612:
                    if (str.equals("long")) {
                        c4 = 4;
                        break;
                    }
                    break;
                case 64711720:
                    if (str.equals("boolean")) {
                        c4 = 5;
                        break;
                    }
                    break;
                case 97526364:
                    if (str.equals("float")) {
                        c4 = 6;
                        break;
                    }
                    break;
                case 109413500:
                    if (str.equals("short")) {
                        c4 = 7;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    genericDeclaration = Double.TYPE;
                    break;
                case 1:
                    genericDeclaration = Integer.TYPE;
                    break;
                case 2:
                    genericDeclaration = Byte.TYPE;
                    break;
                case 3:
                    genericDeclaration = Character.TYPE;
                    break;
                case 4:
                    genericDeclaration = Long.TYPE;
                    break;
                case 5:
                    genericDeclaration = Boolean.TYPE;
                    break;
                case 6:
                    genericDeclaration = Float.TYPE;
                    break;
                case 7:
                    genericDeclaration = Short.TYPE;
                    break;
                default:
                    genericDeclaration = Class.forName(str);
                    break;
            }
            arrayList.add(genericDeclaration);
        }
        Class[] clsArr = new Class[arrayList.size()];
        arrayList.toArray(clsArr);
        return clsArr;
    }

    private static String[] l1111l111111Il(Throwable th) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            th.printStackTrace(new PrintStream(byteArrayOutputStream));
            return byteArrayOutputStream.toString().split("\n");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean l111l11111I1l() {
        try {
            return l1111l111111Il("XposedBridge.jar");
        } catch (Exception unused) {
            return false;
        }
    }

    public static Set<Object> l111l11111Il() {
        HashSet hashSet = new HashSet();
        try {
            Class<?> loadClass = ClassLoader.getSystemClassLoader().loadClass(an.f35797a);
            l1111l111111Il(loadClass, "fieldCache", hashSet);
            l1111l111111Il(loadClass, "methodCache", hashSet);
            l1111l111111Il(loadClass, "constructorCache", hashSet);
        } catch (Throwable unused) {
        }
        return hashSet;
    }

    public static List<String> l111l11111lIl() {
        Context context;
        InputMethodManager inputMethodManager;
        List<InputMethodInfo> inputMethodList;
        ArrayList arrayList = new ArrayList();
        try {
            context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        } catch (Exception unused) {
        }
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null || (inputMethodList = inputMethodManager.getInputMethodList()) == null) {
            return arrayList;
        }
        Iterator<InputMethodInfo> iterator2 = inputMethodList.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().toString());
        }
        return arrayList;
    }

    public static Map<String, Object> l111l1111l1Il() {
        Field field;
        boolean z10;
        Class<?> cls;
        Method method;
        HashMap hashMap = new HashMap();
        try {
            Field[] declaredFields = ClassLoader.getSystemClassLoader().loadClass(an.f35798b).getDeclaredFields();
            int length = declaredFields.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    field = null;
                    break;
                }
                field = declaredFields[i10];
                if ("sHookedMethodCallbacks".equals(field.getName())) {
                    break;
                }
                if ("hookedMethodCallbacks".equals(field.getName())) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            z10 = false;
        } catch (Exception unused) {
        }
        if (field == null) {
            return hashMap;
        }
        field.setAccessible(true);
        Map map = (Map) field.get(null);
        if (z10) {
            cls = null;
            method = null;
        } else {
            cls = ClassLoader.getSystemClassLoader().loadClass("de.robv.android.xposed.XposedBridge$CopyOnWriteSortedSet");
            method = cls.getDeclaredMethod("getSnapshot", new Class[0]);
            method.setAccessible(true);
        }
        for (Object obj : map.entrySet()) {
            String obj2 = ((Map.Entry) obj).getKey().toString();
            Set set = (Set) hashMap.get(obj2);
            if (set == null) {
                set = new HashSet();
                hashMap.put(obj2, set);
            }
            Object value = ((Map.Entry) obj).getValue();
            Object[] array = (cls == null || !cls.isInstance(value)) ? TreeSet.class.isInstance(value) ? ((TreeSet) value).toArray() : null : (Object[]) method.invoke(value, new Object[0]);
            if (array != null) {
                for (Object obj3 : array) {
                    set.add(obj3.getClass().getName());
                }
            }
        }
        return hashMap;
    }

    public static String l111l1111lI1l() {
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return "";
        }
        if (Build.VERSION.SDK_INT < 23) {
            return "1111111";
        }
        Locale locale = Locale.US;
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(l1111l111111Il(context.checkSelfPermission(g.f36117c) == 0));
        objArr[1] = Integer.valueOf(l1111l111111Il(context.checkSelfPermission(g.f36124j) == 0));
        objArr[2] = Integer.valueOf(l1111l111111Il(context.checkSelfPermission("android.permission.WRITE_SETTINGS") == 0));
        objArr[3] = Integer.valueOf(l1111l111111Il(context.checkSelfPermission(g.f36118d) == 0));
        objArr[4] = Integer.valueOf(l1111l111111Il(context.checkSelfPermission(g.f36116b) == 0));
        objArr[5] = Integer.valueOf(l1111l111111Il(context.checkSelfPermission(g.f36121g) == 0));
        objArr[6] = Integer.valueOf(l1111l111111Il(context.checkSelfPermission(g.f36122h) == 0));
        return String.format(locale, "%d%d%d%d%d%d%d", objArr);
    }

    public static String l111l1111lIl() {
        StringBuilder sb2 = new StringBuilder();
        try {
            Method method = Class.forName("android.os.ServiceManager").getMethod("getService", String.class);
            method.setAccessible(true);
            Object invoke = method.invoke(null, "location");
            Object invoke2 = method.invoke(null, "phone");
            sb2.append("locateServiceName:");
            sb2.append(invoke.getClass().getName());
            sb2.append("|");
            sb2.append("phoneServiceName:");
            sb2.append(invoke2.getClass().getName());
        } catch (Throwable unused) {
        }
        return sb2.toString();
    }

    public static Map<String, Object> l111l1111llIl() {
        HashMap hashMap = new HashMap();
        try {
            Object invoke = Class.forName("android.content.Context").getDeclaredMethod("getSystemService", String.class).invoke(com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il, "accessibility");
            Method declaredMethod = invoke.getClass().getDeclaredMethod("isEnabled", new Class[0]);
            Method declaredMethod2 = invoke.getClass().getDeclaredMethod("getEnabledAccessibilityServiceList", Integer.TYPE);
            Object invoke2 = declaredMethod.invoke(invoke, new Object[0]);
            List list = (List) declaredMethod2.invoke(invoke, -1);
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                Object invoke3 = obj.getClass().getDeclaredMethod("getId", new Class[0]).invoke(obj, new Object[0]);
                if (invoke3 == null) {
                    Object invoke4 = obj.getClass().getDeclaredMethod("getResolveInfo", new Class[0]).invoke(obj, new Object[0]);
                    arrayList.add(invoke4 == null ? obj.toString() : invoke4.toString());
                } else {
                    arrayList.add((String) invoke3);
                }
            }
            hashMap.put(Attributes.Style.ENABLE, ((Boolean) invoke2).booleanValue() ? "1" : "0");
            hashMap.put("service", arrayList);
            hashMap.put("suc", "1");
        } catch (Throwable th) {
            hashMap.put("e", th.getMessage());
            hashMap.put("suc", "-1");
        }
        return hashMap;
    }

    public static List<String> l111l11IlIlIl() {
        try {
            String[] list = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il.getAssets().list("ghplugin");
            if (list != null) {
                return Arrays.asList(list);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String l11l1111I11l() {
        if (Build.VERSION.SDK_INT < 23) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        try {
            Field declaredField = Class.forName("de.robv.android.xposed.XposedInit").getDeclaredField("loadedModules");
            declaredField.setAccessible(true);
            Iterator it = ((ArraySet) declaredField.get(null)).iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toString());
            }
        } catch (Throwable unused) {
        }
        return TextUtils.join("|", arrayList);
    }

    public static String l11l1111I1l() {
        if (Build.VERSION.SDK_INT >= 28) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        try {
            Class<?> cls = Class.forName("android.app.ApplicationLoaders");
            Field declaredField = cls.getDeclaredField("gApplicationLoaders");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = cls.getDeclaredField("mLoaders");
            declaredField2.setAccessible(true);
            for (Map.Entry entry : ((Map) declaredField2.get(obj)).entrySet()) {
                String str = (String) entry.getKey();
                try {
                    Class.forName(an.f35799c, false, (ClassLoader) entry.getValue());
                    arrayList.add(str);
                } catch (ClassNotFoundException unused) {
                }
            }
        } catch (Throwable unused2) {
        }
        return TextUtils.join("|", arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x007b A[Catch: Exception -> 0x00c7, TRY_LEAVE, TryCatch #4 {Exception -> 0x00c7, blocks: (B:38:0x0067, B:39:0x0075, B:41:0x007b), top: B:37:0x0067 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.List<java.lang.String> l11l1111I1ll() {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.HashSet r1 = new java.util.HashSet
            r1.<init>()
            android.content.Context r2 = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il
            if (r2 != 0) goto Lf
            return r0
        Lf:
            r3 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L61
            java.io.FileReader r5 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L61
            java.lang.String r6 = "/proc/self/maps"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L61
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L5a java.lang.Exception -> L61
        L1c:
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L55 java.lang.Exception -> L58
            if (r3 == 0) goto L51
            java.lang.String r5 = "/data/app/"
            int r5 = r3.indexOf(r5)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L55
            r6 = -1
            if (r5 != r6) goto L2c
            goto L1c
        L2c:
            java.lang.String r7 = "-"
            int r7 = r3.indexOf(r7, r5)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L55
            if (r7 != r6) goto L3c
            java.lang.String r6 = "/"
            int r7 = r5 + 10
            int r7 = r3.indexOf(r6, r7)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L55
        L3c:
            int r5 = r5 + 10
            java.lang.String r3 = r3.substring(r5, r7)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L55
            java.lang.String r5 = r2.getPackageName()     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L55
            boolean r5 = r3.equals(r5)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L55
            if (r5 == 0) goto L4d
            goto L1c
        L4d:
            r1.add(r3)     // Catch: java.lang.Exception -> L1c java.lang.Throwable -> L55
            goto L1c
        L51:
            r4.close()     // Catch: java.io.IOException -> L67
            goto L67
        L55:
            r0 = move-exception
            r3 = r4
            goto L5b
        L58:
            r3 = r4
            goto L62
        L5a:
            r0 = move-exception
        L5b:
            if (r3 == 0) goto L60
            r3.close()     // Catch: java.io.IOException -> L60
        L60:
            throw r0
        L61:
        L62:
            if (r3 == 0) goto L67
            r3.close()     // Catch: java.io.IOException -> L67
        L67:
            java.lang.String r3 = "xposedmodule"
            java.lang.String r4 = "xposedminversion"
            java.lang.String r5 = "xposeddescription"
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: java.lang.Exception -> Lc7
            java.util.Iterator r1 = r1.iterator2()     // Catch: java.lang.Exception -> Lc7
        L75:
            boolean r6 = r1.hasNext()     // Catch: java.lang.Exception -> Lc7
            if (r6 == 0) goto Lc7
            java.lang.Object r6 = r1.next()     // Catch: java.lang.Exception -> Lc7
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> Lc7
            r7 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r7 = r2.getApplicationInfo(r6, r7)     // Catch: java.lang.Exception -> L75
            android.os.Bundle r8 = r7.metaData     // Catch: java.lang.Exception -> L75
            if (r8 != 0) goto L8c
            goto L75
        L8c:
            java.lang.Object r9 = r8.get(r3)     // Catch: java.lang.Exception -> L75
            java.lang.Object r10 = r8.get(r4)     // Catch: java.lang.Exception -> L75
            java.lang.Object r8 = r8.get(r5)     // Catch: java.lang.Exception -> L75
            if (r9 == 0) goto L75
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L75
            r12 = 29
            if (r11 < r12) goto La3
            java.lang.String r7 = ""
            goto Lab
        La3:
            java.lang.CharSequence r7 = r7.loadLabel(r2)     // Catch: java.lang.Exception -> L75
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> L75
        Lab:
            java.lang.String r11 = ","
            r12 = 5
            java.lang.Object[] r12 = new java.lang.Object[r12]     // Catch: java.lang.Exception -> L75
            r13 = 0
            r12[r13] = r6     // Catch: java.lang.Exception -> L75
            r6 = 1
            r12[r6] = r7     // Catch: java.lang.Exception -> L75
            r6 = 2
            r12[r6] = r9     // Catch: java.lang.Exception -> L75
            r6 = 3
            r12[r6] = r10     // Catch: java.lang.Exception -> L75
            r6 = 4
            r12[r6] = r8     // Catch: java.lang.Exception -> L75
            java.lang.String r6 = android.text.TextUtils.join(r11, r12)     // Catch: java.lang.Exception -> L75
            r0.add(r6)     // Catch: java.lang.Exception -> L75
            goto L75
        Lc7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.smantifraud.l111l11111I1l.l1111l111111Il.l11l1111I1ll():java.util.List");
    }

    public static Map<String, Object> l11l1111Il() {
        ActivityManager activityManager;
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService("activity")) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap(3);
        hashSet.add("user.zposed.app");
        hashSet.add("user.zposed.system");
        for (ActivityManager.RunningServiceInfo runningServiceInfo : activityManager.getRunningServices(Integer.MAX_VALUE)) {
            if (hashSet.contains(runningServiceInfo.process)) {
                hashMap.put(runningServiceInfo.process, 1);
            }
        }
        return hashMap;
    }

    public static int l11l1111Il1l() {
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return 0;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) context.getFilesDir());
        sb2.append(File.separator);
        sb2.append("exp_base.apk");
        return new File(sb2.toString()).exists() ? 1 : 0;
    }

    public static List<String> l11l1111Ill() {
        boolean z10;
        String[] strArr = {"java.lang.Throwable", "at com.ishumei", "at android.view.View", "at android.os.Handler", "at android.os.Looper", "at android.app.ActivityThread", "at java.lang.reflect.Method", "at com.android.internal.os"};
        String[] l1111l111111Il2 = l1111l111111Il(new Throwable());
        ArrayList arrayList = new ArrayList();
        if (l1111l111111Il2 == null) {
            return arrayList;
        }
        for (String str : l1111l111111Il2) {
            int i10 = 0;
            while (true) {
                if (i10 >= 8) {
                    z10 = false;
                    break;
                }
                if (str.trim().startsWith(strArr[i10])) {
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (!z10) {
                arrayList.add(str.trim());
            }
        }
        return arrayList;
    }

    public static String l11l1111lIIl() {
        ArrayList arrayList = new ArrayList();
        try {
            Field declaredField = Class.forName("de.robv.android.xposed.XposedInit").getDeclaredField("loadedPackagesInProcess");
            declaredField.setAccessible(true);
            arrayList.addAll((Set) declaredField.get(null));
        } catch (Throwable unused) {
        }
        return TextUtils.join("|", arrayList);
    }

    public static Map<String, Object> l11l111l11Il() {
        Location location = new Location(GeocodeSearch.GPS);
        if (location.getLongitude() < 1.0E-4d || location.getLatitude() < 1.0E-4d) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("location", location.toString());
        hashMap.put("lo", Double.valueOf(location.getLongitude()));
        hashMap.put("la", Double.valueOf(location.getLatitude()));
        return hashMap;
    }

    public static int l11l111l1I1l() {
        if (Build.VERSION.SDK_INT < 26) {
            return 0;
        }
        try {
            FileDescriptor fd2 = new FileOutputStream(com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il.getApplicationInfo().dataDir + File.separator + "tmp.data").getFD();
            Field declaredField = fd2.getClass().getDeclaredField("descriptor");
            declaredField.setAccessible(true);
            int intValue = ((Integer) declaredField.get(fd2)).intValue();
            StringBuilder sb2 = new StringBuilder("/proc/self/fd/");
            sb2.append(intValue);
            return new File(Files.readSymbolicLink(Paths.get(sb2.toString(), new String[0])).toString().replace("tmp.data", "..")).canRead() ? 1 : 0;
        } catch (Exception unused) {
            return 2;
        }
    }

    private static String l11l111l1Il() {
        try {
            return new String(com.ishumei.smantifraud.l111l1111llIl.l111l1111lI1l.l1111l111111Il(Base64.decode(l1111l111111Il, 0)));
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean l11l111l1lll() {
        try {
            Class.forName(an.f35797a);
        } catch (Throwable th) {
            String[] l1111l111111Il2 = l1111l111111Il(th);
            if (l1111l111111Il2 != null) {
                for (String str : l1111l111111Il2) {
                    if (str.contains("de.robvf.android.xposed.XposedHelpers")) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static List<String> l11l11IlIIll() {
        String readLine;
        try {
            ArrayList arrayList = new ArrayList();
            Process exec = Runtime.getRuntime().exec(new String[]{"sh", "-c", "set"});
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                readLine = bufferedReader.readLine();
                if (TextUtils.isEmpty(readLine)) {
                    break;
                }
                if (readLine.contains("V_SO_PATH") || readLine.contains("V_SO_PATH") || readLine.contains("V_REPLACE") || readLine.contains("VMOS_ROOT_DIR")) {
                    arrayList.add(readLine);
                }
            }
            for (String readLine2 = new BufferedReader(new InputStreamReader(exec.getErrorStream())).readLine(); !TextUtils.isEmpty(readLine2); readLine2 = bufferedReader.readLine()) {
                if (readLine2.contains("libva.so")) {
                    arrayList.add(readLine);
                }
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }
}
