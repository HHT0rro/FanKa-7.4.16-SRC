package com.huawei.hianalytics;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.log.LogTag;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ConcurrentModificationException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g0 {
    public static final String lmn = LogTag.get(g0.class, new Class[0]);
    public static final Charset klm = Charset.forName("UTF-8");

    public static String lmn(InputStream inputStream, int i10) {
        byte[] bArr;
        byte[] bArr2 = new byte[i10];
        byte[] bArr3 = new byte[i10];
        int i11 = 0;
        while (true) {
            int read = inputStream.read(bArr3);
            if (read == -1) {
                break;
            }
            if (read > 0) {
                if (bArr2.length - i11 >= read) {
                    System.arraycopy((Object) bArr3, 0, (Object) bArr2, i11, read);
                } else {
                    byte[] bArr4 = new byte[(bArr2.length + read) << 1];
                    System.arraycopy((Object) bArr2, 0, (Object) bArr4, 0, i11);
                    System.arraycopy((Object) bArr3, 0, (Object) bArr4, i11, read);
                    bArr2 = bArr4;
                }
                i11 += read;
            }
        }
        if (i11 == 0) {
            return "";
        }
        if (i11 <= 0) {
            bArr = new byte[0];
        } else {
            bArr = new byte[i11];
            System.arraycopy((Object) bArr2, 0, (Object) bArr, 0, i11);
        }
        return new String(bArr, "UTF-8");
    }

    public static String lmn(File file) {
        byte[] bArr;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr2 = new byte[1024];
                    byte[] bArr3 = new byte[1024];
                    int i10 = 0;
                    while (true) {
                        int read = fileInputStream2.read(bArr3);
                        if (read == -1) {
                            break;
                        }
                        if (read > 0) {
                            if (bArr2.length - i10 >= read) {
                                System.arraycopy((Object) bArr3, 0, (Object) bArr2, i10, read);
                            } else {
                                byte[] bArr4 = new byte[(bArr2.length + read) << 1];
                                System.arraycopy((Object) bArr2, 0, (Object) bArr4, 0, i10);
                                System.arraycopy((Object) bArr3, 0, (Object) bArr4, i10, read);
                                bArr2 = bArr4;
                            }
                            i10 += read;
                        }
                    }
                    if (i10 == 0) {
                        lmn(fileInputStream2);
                        return "";
                    }
                    if (i10 <= 0) {
                        bArr = new byte[0];
                    } else {
                        byte[] bArr5 = new byte[i10];
                        System.arraycopy((Object) bArr2, 0, (Object) bArr5, 0, i10);
                        bArr = bArr5;
                    }
                    String str = new String(bArr, klm);
                    lmn(fileInputStream2);
                    return str;
                } catch (FileNotFoundException unused) {
                    fileInputStream = fileInputStream2;
                    HiLog.e(lmn, "getInfoFromFile(): No files need to be read");
                    lmn(fileInputStream);
                    return "";
                } catch (IOException unused2) {
                    fileInputStream = fileInputStream2;
                    HiLog.e(lmn, "getInfoFromFile(): stream.read or new string exception");
                    lmn(fileInputStream);
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    lmn(fileInputStream);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void lmn(File file, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    fileOutputStream.write(str.getBytes("UTF-8"));
                    fileOutputStream.flush();
                } catch (FileNotFoundException unused) {
                    fileOutputStream2 = fileOutputStream;
                    HiLog.e(lmn, "saveInfoToFile(): No files need to be read");
                    fileOutputStream = fileOutputStream2;
                    lmn(fileOutputStream);
                } catch (IOException unused2) {
                    fileOutputStream2 = fileOutputStream;
                    HiLog.e(lmn, "saveInfoToFile(): io exc from write info to file!");
                    fileOutputStream = fileOutputStream2;
                    lmn(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream2 = fileOutputStream;
                    lmn(fileOutputStream2);
                    throw th;
                }
            } catch (FileNotFoundException unused3) {
            } catch (IOException unused4) {
            }
            lmn(fileOutputStream);
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void lmn(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                HiLog.w(lmn, "closeQuietly(): Exception when closing the closeable!");
            }
        }
    }

    public static synchronized JSONObject lmn(LinkedHashMap<String, String> linkedHashMap) {
        JSONObject jSONObject;
        synchronized (g0.class) {
            jSONObject = new JSONObject();
            try {
                try {
                    try {
                        for (Map.Entry<String, String> entry : linkedHashMap.entrySet()) {
                            if (!TextUtils.isEmpty(entry.getKey())) {
                                jSONObject.put(entry.getKey(), entry.getValue());
                            }
                        }
                    } catch (JSONException e2) {
                        String str = lmn;
                        StringBuilder b4 = e9.a.b("getJsonFromMap: JSONException: mapValue");
                        b4.append(e2.getMessage());
                        HiLog.e(str, b4.toString());
                    }
                } catch (Exception e10) {
                    String str2 = lmn;
                    StringBuilder b10 = e9.a.b("getJsonFromMap: Exception: mapValue");
                    b10.append(e10.getMessage());
                    HiLog.e(str2, b10.toString());
                }
            } catch (ConcurrentModificationException e11) {
                String str3 = lmn;
                StringBuilder b11 = e9.a.b("getJsonFromMap: ConcurrentModificationException: mapValue");
                b11.append(e11.getMessage());
                HiLog.e(str3, b11.toString());
            }
        }
        return jSONObject;
    }
}
