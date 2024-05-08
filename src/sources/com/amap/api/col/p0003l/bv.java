package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Utility.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class bv {
    public static long a() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return 0L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return statFs.getFreeBlocks() * statFs.getBlockSize();
    }

    private static ArrayList<OfflineMapCity> b(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray("cities");
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        if (optJSONArray == null) {
            return arrayList;
        }
        if (optJSONArray.length() == 0) {
            arrayList.add(c(jSONObject));
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (optJSONObject != null) {
                arrayList.add(c(optJSONObject));
            }
        }
        return arrayList;
    }

    private static String c(String str) {
        return "000001".equals(str) ? "100000" : str;
    }

    private static OfflineMapCity c(JSONObject jSONObject) throws JSONException {
        OfflineMapCity offlineMapCity = new OfflineMapCity();
        offlineMapCity.setAdcode(c(a(jSONObject, "adcode")));
        offlineMapCity.setUrl(a(jSONObject, "url"));
        offlineMapCity.setCity(a(jSONObject, "name"));
        offlineMapCity.setCode(a(jSONObject, "citycode"));
        offlineMapCity.setPinyin(a(jSONObject, "pinyin"));
        offlineMapCity.setJianpin(a(jSONObject, "jianpin"));
        offlineMapCity.setVersion(a(jSONObject, "version"));
        offlineMapCity.setSize(Long.parseLong(a(jSONObject, "size")));
        return offlineMapCity;
    }

    public static List<OfflineMapProvince> a(String str, Context context) throws JSONException {
        if (str != null && !"".equals(str)) {
            return a(new JSONObject(str), context);
        }
        return new ArrayList();
    }

    public static boolean b(File file) throws IOException, Exception {
        if (file == null || !file.exists()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (int i10 = 0; i10 < listFiles.length; i10++) {
                if (listFiles[i10].isFile()) {
                    if (!listFiles[i10].delete()) {
                        return false;
                    }
                } else if (!b(listFiles[i10])) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static List<OfflineMapProvince> a(JSONObject jSONObject, Context context) throws JSONException {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        ArrayList arrayList = new ArrayList();
        if (!jSONObject.has("result")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("result", new JSONObject().put("offlinemap_with_province_vfour", jSONObject));
                c(jSONObject2.toString(), context);
                optJSONObject = jSONObject2.optJSONObject("result");
            } catch (JSONException e2) {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("result");
                gy.b(e2, "Utility", "parseJson");
                e2.printStackTrace();
                optJSONObject = optJSONObject3;
            }
        } else {
            optJSONObject = jSONObject.optJSONObject("result");
        }
        if (optJSONObject != null) {
            JSONObject optJSONObject4 = optJSONObject.optJSONObject("offlinemap_with_province_vfour");
            if (optJSONObject4 == null) {
                return arrayList;
            }
            optJSONObject2 = optJSONObject4.optJSONObject("offlinemapinfo_with_province");
        } else {
            optJSONObject2 = jSONObject.optJSONObject("offlinemapinfo_with_province");
        }
        if (optJSONObject2 == null) {
            return arrayList;
        }
        if (optJSONObject2.has("version")) {
            ay.f5079d = a(optJSONObject2, "version");
        }
        JSONArray optJSONArray = optJSONObject2.optJSONArray("provinces");
        if (optJSONArray == null) {
            return arrayList;
        }
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            JSONObject optJSONObject5 = optJSONArray.optJSONObject(i10);
            if (optJSONObject5 != null) {
                arrayList.add(a(optJSONObject5));
            }
        }
        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("others");
        JSONObject jSONObject3 = null;
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            jSONObject3 = optJSONArray2.getJSONObject(0);
        }
        if (jSONObject3 == null) {
            return arrayList;
        }
        arrayList.add(a(jSONObject3));
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public static String c(File file) {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer = new StringBuffer();
        ?? r22 = 0;
        r22 = 0;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            } catch (FileNotFoundException e2) {
                                e = e2;
                                gy.b(e, "MapDownloadManager", "readOfflineSD filenotfound");
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e10) {
                                        e10.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            } catch (IOException e11) {
                                e = e11;
                                gy.b(e, "MapDownloadManager", "readOfflineSD io");
                                e.printStackTrace();
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (IOException e12) {
                                        e12.printStackTrace();
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return null;
                            }
                        }
                        String stringBuffer2 = stringBuffer.toString();
                        try {
                            bufferedReader.close();
                        } catch (IOException e13) {
                            e13.printStackTrace();
                        }
                        try {
                            fileInputStream.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                        return stringBuffer2;
                    } catch (FileNotFoundException e15) {
                        e = e15;
                        bufferedReader = null;
                    } catch (IOException e16) {
                        e = e16;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        if (r22 != 0) {
                            try {
                                r22.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                throw th;
                            } catch (IOException e18) {
                                e18.printStackTrace();
                                throw th;
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e19) {
                    e = e19;
                    bufferedReader = null;
                    fileInputStream = null;
                } catch (IOException e20) {
                    e = e20;
                    bufferedReader = null;
                    fileInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = null;
                }
            } catch (Throwable th3) {
                th = th3;
                r22 = file;
            }
        } catch (IOException e21) {
            e21.printStackTrace();
        }
    }

    public static void b(String str, Context context) throws IOException, Exception {
        File[] listFiles = new File(dx.c(context)).listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (file.exists() && file.getName().contains(str)) {
                b(file);
            }
        }
        a(dx.c(context));
    }

    public static String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str.substring(str.lastIndexOf("/") + 1, str.indexOf(".zip"));
        } catch (Throwable th) {
            gy.b(th, "Utility", "getZipFileNameFromUrl");
            return null;
        }
    }

    private static OfflineMapProvince a(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return null;
        }
        OfflineMapProvince offlineMapProvince = new OfflineMapProvince();
        offlineMapProvince.setUrl(a(jSONObject, "url"));
        offlineMapProvince.setProvinceName(a(jSONObject, "name"));
        offlineMapProvince.setJianpin(a(jSONObject, "jianpin"));
        offlineMapProvince.setPinyin(a(jSONObject, "pinyin"));
        offlineMapProvince.setProvinceCode(c(a(jSONObject, "adcode")));
        offlineMapProvince.setVersion(a(jSONObject, "version"));
        offlineMapProvince.setSize(Long.parseLong(a(jSONObject, "size")));
        offlineMapProvince.setCityList(b(jSONObject));
        return offlineMapProvince;
    }

    public static void c(String str, Context context) {
        if ("".equals(dx.c(context))) {
            return;
        }
        File file = new File(dx.c(context) + "offlinemapv4.png");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                gy.b(e2, "OfflineUpdateCityHandlerAbstract", "writeSD dirCreate");
                e2.printStackTrace();
            }
        }
        if (a() <= 1048576) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    fileOutputStream2.write(str.getBytes("utf-8"));
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    fileOutputStream = fileOutputStream2;
                    gy.b(e, "OfflineUpdateCityHandlerAbstract", "writeSD filenotfound");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e12) {
                            e12.printStackTrace();
                        }
                    }
                } catch (IOException e13) {
                    e = e13;
                    fileOutputStream = fileOutputStream2;
                    gy.b(e, "OfflineUpdateCityHandlerAbstract", "writeSD io");
                    e.printStackTrace();
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e14) {
                            e14.printStackTrace();
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e15) {
                            e15.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e16) {
                e = e16;
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static long a(File file) {
        long length;
        if (!file.isDirectory()) {
            return file.length();
        }
        File[] listFiles = file.listFiles();
        long j10 = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                length = a(file2);
            } else {
                length = file2.length();
            }
            j10 += length;
        }
        return j10;
    }

    public static String a(Context context, String str) {
        try {
            return dx.a(dr.a(context).open(str));
        } catch (Throwable th) {
            gy.b(th, "MapDownloadManager", "readOfflineAsset");
            th.printStackTrace();
            return null;
        }
    }

    public static void a(String str) {
        File[] listFiles;
        File file = new File(str);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.exists() && file2.isDirectory()) {
                    String[] list = file2.list();
                    if (list == null) {
                        file2.delete();
                    } else if (list.length == 0) {
                        file2.delete();
                    }
                }
            }
        }
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || "[]".equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }
}
