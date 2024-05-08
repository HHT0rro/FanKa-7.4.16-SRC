package com.ishumei.smantifraud.l111l1111llIl;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Patterns;
import com.huawei.openalliance.ad.constant.u;
import com.ishumei.smantifraud.l1111l111111Il.l11l1111Ill;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class l111l1111llIl {
    public static Context l1111l111111Il() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
    
        return new org.json.JSONArray();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object l1111l111111Il(java.lang.reflect.Field r1, java.lang.Object r2) {
        /*
            java.lang.Class r1 = r1.getType()     // Catch: java.lang.Exception -> L5d
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            if (r1 == r0) goto L54
            java.lang.Class<java.lang.Double> r0 = java.lang.Double.class
            if (r1 == r0) goto L54
            java.lang.Class<java.lang.Float> r0 = java.lang.Float.class
            if (r1 == r0) goto L54
            java.lang.Class<java.lang.Long> r0 = java.lang.Long.class
            if (r1 != r0) goto L15
            goto L54
        L15:
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r1 != r0) goto L1f
            if (r2 != 0) goto L1e
            java.lang.String r1 = ""
            return r1
        L1e:
            return r2
        L1f:
            java.lang.Class<java.util.Map> r0 = java.util.Map.class
            if (r1 != r0) goto L33
            if (r2 != 0) goto L2b
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5d
            r1.<init>()     // Catch: java.lang.Exception -> L5d
            return r1
        L2b:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L5d
            java.util.Map r2 = (java.util.Map) r2     // Catch: java.lang.Exception -> L5d
            r1.<init>(r2)     // Catch: java.lang.Exception -> L5d
            return r1
        L33:
            java.lang.Class<java.util.List> r0 = java.util.List.class
            if (r1 == r0) goto L44
            java.lang.Class<java.util.Set> r0 = java.util.Set.class
            if (r1 != r0) goto L3c
            goto L44
        L3c:
            if (r2 != 0) goto L43
            java.lang.Object r1 = r1.newInstance()     // Catch: java.lang.Exception -> L5d
            return r1
        L43:
            return r2
        L44:
            if (r2 != 0) goto L4c
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Exception -> L5d
            r1.<init>()     // Catch: java.lang.Exception -> L5d
            return r1
        L4c:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Exception -> L5d
            java.util.Collection r2 = (java.util.Collection) r2     // Catch: java.lang.Exception -> L5d
            r1.<init>(r2)     // Catch: java.lang.Exception -> L5d
            return r1
        L54:
            if (r2 != 0) goto L5c
            r1 = -1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Exception -> L5d
            return r1
        L5c:
            return r2
        L5d:
            java.lang.Object r1 = new java.lang.Object
            r1.<init>()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il(java.lang.reflect.Field, java.lang.Object):java.lang.Object");
    }

    private static String l1111l111111Il(File file) {
        Throwable th;
        BufferedReader bufferedReader;
        if (!file.exists()) {
            throw new IOException("not exist");
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            return readLine;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    public static String l1111l111111Il(byte[] bArr) {
        try {
            return Base64.encodeToString(bArr, 2);
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    private static List<String> l1111l111111Il(File file, Set<String> set, int i10) {
        ArrayList arrayList = new ArrayList();
        if (!file.exists() || !file.canRead() || !file.isFile() || set == null || set.size() == 0) {
            return arrayList;
        }
        HashSet hashSet = new HashSet(set);
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            l1111l111111Il((Closeable) bufferedReader2);
                            return arrayList;
                        }
                        if (!l111l11111Il.l1111l111111Il(readLine)) {
                            Iterator<E> iterator2 = hashSet.iterator2();
                            if (i10 == 0) {
                                while (iterator2.hasNext()) {
                                    String str = (String) iterator2.next();
                                    if (readLine.contains(str)) {
                                        arrayList.add(str);
                                        iterator2.remove();
                                    }
                                }
                            } else if (i10 == 1) {
                                String lowerCase = readLine.toLowerCase();
                                while (iterator2.hasNext()) {
                                    String str2 = (String) iterator2.next();
                                    if (lowerCase.contains(str2.toLowerCase())) {
                                        arrayList.add(str2);
                                        iterator2.remove();
                                    }
                                }
                            } else if (i10 == 2) {
                                while (iterator2.hasNext()) {
                                    Matcher matcher = Pattern.compile((String) iterator2.next()).matcher(readLine);
                                    while (matcher.find()) {
                                        arrayList.add(matcher.group(0));
                                    }
                                }
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        throw new IOException(e);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        l1111l111111Il((Closeable) bufferedReader);
                        throw th;
                    }
                }
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static List<String> l1111l111111Il(String str, Set<String> set, int i10) {
        return l1111l111111Il(new File(str), set, i10);
    }

    private static List<Object> l1111l111111Il(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object opt = jSONArray.opt(i10);
            if (opt != null) {
                arrayList.add(l111l11111I1l(opt));
            }
        }
        return arrayList;
    }

    private static Map<String, Object> l1111l111111Il(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject == null) {
            return hashMap;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt != null) {
                hashMap.put(next, l111l11111I1l(opt));
            }
        }
        return hashMap;
    }

    private static JSONArray l1111l111111Il(Object obj) {
        if (!obj.getClass().isArray()) {
            throw new JSONException("Not a primitive data: " + ((Object) obj.getClass()));
        }
        int length = Array.getLength(obj);
        JSONArray jSONArray = new JSONArray();
        for (int i10 = 0; i10 < length; i10++) {
            jSONArray.put(l111l11111lIl(Array.get(obj, i10)));
        }
        return jSONArray;
    }

    private static JSONArray l1111l111111Il(Collection collection) {
        JSONArray jSONArray = new JSONArray();
        if (collection != null) {
            Iterator iterator2 = collection.iterator2();
            while (iterator2.hasNext()) {
                jSONArray.put(l111l11111lIl(iterator2.next()));
            }
        }
        return jSONArray;
    }

    public static JSONObject l1111l111111Il(Object obj, Set<String> set) {
        JSONObject jSONObject = new JSONObject();
        if (obj == null) {
            return jSONObject;
        }
        for (Field field : obj.getClass().getDeclaredFields()) {
            try {
                if (!field.getName().equals("serialVersionUID")) {
                    field.setAccessible(true);
                    Object obj2 = field.get(obj);
                    l11l1111Ill l11l1111ill = (l11l1111Ill) field.getAnnotation(l11l1111Ill.class);
                    if (l11l1111ill != null) {
                        String l1111l111111Il = l11l1111ill.l1111l111111Il();
                        if (!l111l11111Il((Object) l1111l111111Il) && !l111l11111Il(obj2) && (set == null || set.contains(l1111l111111Il))) {
                            jSONObject.put(l1111l111111Il, l1111l111111Il(field, obj2));
                        }
                    } else if (set == null || set.contains(field.getName())) {
                        jSONObject.put(field.getName(), obj2);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    private static JSONObject l1111l111111Il(Map<?, ?> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw new NullPointerException("key == null");
                }
                try {
                    jSONObject.put(str, l111l11111lIl(entry.getValue()));
                } catch (JSONException unused) {
                }
            }
        } catch (Exception unused2) {
        }
        return jSONObject;
    }

    public static void l1111l111111Il(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void l1111l111111Il(File file, String str) {
        FileWriter fileWriter;
        if (file == null || l111l11111Il.l1111l111111Il(str)) {
            throw new IOException("file or bytes empty");
        }
        FileWriter fileWriter2 = null;
        try {
            fileWriter = new FileWriter(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(str);
            fileWriter.close();
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            if (fileWriter2 != null) {
                fileWriter2.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0053  */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.nio.channels.FileChannel] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.nio.channels.FileChannel] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void l1111l111111Il(java.io.File r4, byte[] r5) {
        /*
            if (r5 == 0) goto L5a
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            r1.<init>(r4)     // Catch: java.lang.Throwable -> L3b java.lang.Exception -> L3f
            java.nio.channels.FileChannel r4 = r1.getChannel()     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L37
            java.nio.channels.FileLock r0 = r4.lock()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
        L14:
            boolean r2 = r5.hasRemaining()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            if (r2 == 0) goto L1e
            r4.write(r5)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            goto L14
        L1e:
            r1.flush()     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            if (r0 == 0) goto L26
            r0.release()
        L26:
            r4.close()
            l1111l111111Il(r1)
            return
        L2d:
            r5 = move-exception
            goto L4c
        L2f:
            r5 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
            goto L42
        L34:
            r5 = move-exception
            r4 = r0
            goto L4c
        L37:
            r5 = move-exception
            r4 = r0
            r0 = r1
            goto L41
        L3b:
            r5 = move-exception
            r4 = r0
            r1 = r4
            goto L4c
        L3f:
            r5 = move-exception
            r4 = r0
        L41:
            r1 = r4
        L42:
            java.io.IOException r2 = new java.io.IOException     // Catch: java.lang.Throwable -> L48
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L48
            throw r2     // Catch: java.lang.Throwable -> L48
        L48:
            r5 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L4c:
            if (r0 == 0) goto L51
            r0.release()
        L51:
            if (r4 == 0) goto L56
            r4.close()
        L56:
            l1111l111111Il(r1)
            throw r5
        L5a:
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r5 = "file or bytes empty"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ishumei.smantifraud.l111l1111llIl.l111l1111llIl.l1111l111111Il(java.io.File, byte[]):void");
    }

    private static void l1111l111111Il(String str, String str2) {
        if (l111l11111Il.l1111l111111Il(str) || l111l11111Il.l1111l111111Il(str2)) {
            throw new IOException("file or bytes empty");
        }
        byte[] bytes = str2.getBytes("utf-8");
        if (l111l11111Il.l1111l111111Il(str) || bytes == null) {
            throw new IOException("filename or byes empty");
        }
        try {
            l1111l111111Il(new File(str), bytes);
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    private static void l1111l111111Il(String str, byte[] bArr) {
        if (l111l11111Il.l1111l111111Il(str) || bArr == null) {
            throw new IOException("filename or byes empty");
        }
        try {
            l1111l111111Il(new File(str), bArr);
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    private static void l1111l111111Il(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean l1111l111111Il(String str) {
        try {
            return new File(((Object) Environment.getExternalStorageDirectory()) + "/" + str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private static byte[] l1111l111111Il(FileChannel fileChannel) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    ByteBuffer allocate = ByteBuffer.allocate(100);
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        int read = fileChannel.read(allocate, i10);
                        if (read <= 0) {
                            break;
                        }
                        i10 += read;
                        i11 += read;
                    }
                    byte[] array = allocate.array();
                    if (i11 >= 4 && (array[0] & 255) == 0 && (array[1] & 255) == 0 && (array[2] & 255) == 0 && (array[3] & 255) == 0) {
                        throw new IOException("read bytes not utf-8");
                    }
                    byteArrayOutputStream2.write(array, 0, i11);
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    l1111l111111Il((Closeable) byteArrayOutputStream2);
                    return byteArray;
                } catch (Exception e2) {
                    e = e2;
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    l1111l111111Il((Closeable) byteArrayOutputStream);
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static Object l111l11111I1l(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj instanceof JSONObject ? l1111l111111Il((JSONObject) obj) : obj instanceof JSONArray ? l1111l111111Il((JSONArray) obj) : obj;
    }

    private static String l111l11111I1l(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
            StringBuilder sb2 = new StringBuilder(digest.length << 1);
            for (byte b4 : digest) {
                int i10 = b4 & 255;
                if (i10 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            throw new IOException("fail to md5 data");
        }
    }

    public static boolean l111l11111I1l(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<String> l111l11111Il(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Exception e2;
        ArrayList arrayList = new ArrayList();
        try {
            bufferedReader = new BufferedReader(new FileReader(new File(str)));
            while (true) {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            l1111l111111Il((Closeable) bufferedReader);
                            return arrayList;
                        }
                        if (!l111l11111Il.l1111l111111Il(readLine)) {
                            arrayList.add(readLine);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        l1111l111111Il((Closeable) bufferedReader);
                        throw th;
                    }
                } catch (Exception e10) {
                    e2 = e10;
                    throw new IOException(e2);
                }
            }
        } catch (Exception e11) {
            bufferedReader = null;
            e2 = e11;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
            l1111l111111Il((Closeable) bufferedReader);
            throw th;
        }
    }

    private static boolean l111l11111Il(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return TextUtils.isEmpty((String) obj);
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).isEmpty();
        }
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    private static Object l111l11111lIl(Object obj) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject)) {
            return obj;
        }
        if (obj instanceof Collection) {
            JSONArray jSONArray = new JSONArray();
            Iterator iterator2 = ((Collection) obj).iterator2();
            while (iterator2.hasNext()) {
                jSONArray.put(l111l11111lIl(iterator2.next()));
            }
            return jSONArray;
        }
        if (obj.getClass().isArray()) {
            return l1111l111111Il(obj);
        }
        if (obj instanceof Map) {
            return l1111l111111Il((Map<?, ?>) obj);
        }
        if ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) {
            return obj;
        }
        if (obj.getClass().getPackage().getName().startsWith("java.")) {
            return obj.toString();
        }
        return null;
    }

    private static String l111l11111lIl(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b4 : bArr) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(u.bD);
            }
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString);
        }
        return stringBuffer.toString();
    }

    private static List<String> l111l11111lIl(File file, Set<String> set, int i10) {
        String[] list;
        ArrayList arrayList = new ArrayList();
        if (file.isDirectory() && set != null && set.size() != 0 && (list = file.list()) != null && list.length != 0) {
            HashSet hashSet = new HashSet(set);
            for (String str : list) {
                Iterator<E> iterator2 = hashSet.iterator2();
                if (i10 == 0) {
                    while (iterator2.hasNext()) {
                        String str2 = (String) iterator2.next();
                        if (str.contains(str2)) {
                            arrayList.add(str2);
                        }
                    }
                } else if (i10 == 1) {
                    String lowerCase = str.toLowerCase();
                    while (iterator2.hasNext()) {
                        String str3 = (String) iterator2.next();
                        if (lowerCase.contains(str3.toLowerCase())) {
                            arrayList.add(str3);
                        }
                    }
                } else if (i10 == 2) {
                    while (iterator2.hasNext()) {
                        if (Pattern.compile((String) iterator2.next()).matcher(str).find()) {
                            arrayList.add(str);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private static List<String> l111l11111lIl(String str, Set<String> set, int i10) {
        return TextUtils.isEmpty(str) ? Collections.emptyList() : l111l11111lIl(new File(str), set, i10);
    }

    public static boolean l111l11111lIl(String str) {
        Context context = com.ishumei.smantifraud.l111l11111lIl.l111l1111l1Il.l1111l111111Il;
        if (context == null) {
            return false;
        }
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission(str) == 0;
    }

    public static String l111l1111l1Il(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return l111l11111I1l(str.getBytes("utf-8"));
        } catch (Exception unused) {
            return "";
        }
    }

    private static String l111l1111lI1l(String str) {
        try {
            return l1111l111111Il(new File(str));
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    private static String l111l1111lIl(String str) {
        return (str == null || str.isEmpty()) ? "" : str.replaceAll(u.bD, "").toLowerCase();
    }

    public static byte[] l111l1111llIl(String str) {
        try {
            return Base64.decode(str.getBytes("utf-8"), 0);
        } catch (Exception e2) {
            throw new IOException(e2);
        }
    }

    private static String l11l1111I11l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Patterns.DOMAIN_NAME.matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    private static boolean l11l1111I1l(String str) {
        if (str == null) {
            return false;
        }
        return Patterns.IP_ADDRESS.matcher(str).matches();
    }

    private static String l11l1111lIIl(String str) {
        if (str != null && str.length() != 0) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (Exception unused) {
            }
        }
        return "";
    }
}
