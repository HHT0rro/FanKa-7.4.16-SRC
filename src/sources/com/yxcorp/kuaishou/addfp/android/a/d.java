package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.yxcorp.kuaishou.addfp.android.b.g;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d {

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f48576d;

    /* renamed from: a, reason: collision with root package name */
    private e f48577a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap f48578b = new ConcurrentHashMap(10);

    /* renamed from: c, reason: collision with root package name */
    private Context f48579c;

    private d(Context context) {
        this.f48577a = null;
        try {
            this.f48579c = context;
            this.f48577a = new e(context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static d a(Context context) {
        if (f48576d == null) {
            synchronized (d.class) {
                if (f48576d == null) {
                    f48576d = new d(context);
                }
            }
        }
        return f48576d;
    }

    private String a(HashMap hashMap) {
        ObjectOutputStream objectOutputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
            th = th;
            objectOutputStream = null;
        }
        try {
            objectOutputStream.writeObject(hashMap);
            String str = new String(Base64.encode(com.yxcorp.kuaishou.addfp.android.b.b.c(byteArrayOutputStream.toByteArray(), "20212102sjcudiab".getBytes()), 0));
            try {
                objectOutputStream.close();
            } catch (IOException unused) {
            }
            return str;
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                if (objectOutputStream == null) {
                    return "";
                }
                try {
                    objectOutputStream.close();
                    return "";
                } catch (IOException unused2) {
                    return "";
                }
            } catch (Throwable th3) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th3;
            }
        }
    }

    public static void a(Context context, String str) {
        Throwable th;
        FileWriter fileWriter;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(context, false), new String(Base64.decode("Lm91a2R0ZnQ=", 0)));
                new File(file.getParent()).mkdirs();
                fileWriter = new FileWriter(file, false);
            } catch (Throwable th2) {
                th = th2;
                fileWriter = null;
            }
            try {
                fileWriter.write(str);
                fileWriter.flush();
                fileWriter.close();
                fileWriter.close();
            } catch (Throwable th3) {
                th = th3;
                try {
                    th.printStackTrace();
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (Throwable th4) {
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th4;
                }
            }
        } catch (IOException unused2) {
        }
    }

    public synchronized Pair a() {
        byte[] bArr;
        try {
            if (this.f48578b != null) {
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.f48578b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb2.toString()), this.f48578b);
                }
            }
            this.f48578b.clear();
            String b4 = this.f48577a.b();
            if (!TextUtils.isEmpty(b4)) {
                try {
                    bArr = Base64.decode(b4, 0);
                } catch (Throwable unused) {
                    bArr = null;
                }
                if (bArr == null) {
                    try {
                        bArr = Base64.decode(b4, 8);
                    } catch (Throwable unused2) {
                    }
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(com.yxcorp.kuaishou.addfp.android.b.b.b(bArr, "20212102sjcudiab".getBytes())));
                    this.f48578b.put("cache_e", jSONObject.optString("cache_e", ""));
                    this.f48578b.put("cache_m", jSONObject.optString("cache_m", ""));
                    this.f48578b.put("c_time", Long.toString(jSONObject.optLong("c_time", 0L)));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ConcurrentHashMap concurrentHashMap = this.f48578b;
            if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                StringBuilder sb3 = new StringBuilder();
                if (!TextUtils.isEmpty((String) this.f48578b.get("cache_e"))) {
                    return Pair.create(Pair.create(Boolean.TRUE, sb3.toString()), this.f48578b);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return Pair.create(Pair.create(Boolean.TRUE, "8"), null);
    }

    public String a(String str) {
        try {
            File file = new File(com.yxcorp.kuaishou.addfp.android.b.b.a(this.f48579c, false), new String(Base64.decode(str, 0)));
            if (!file.exists()) {
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb2.toString().trim();
                }
                sb2.append(readLine);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public synchronized void a(String str, String str2) {
        byte[] bArr;
        HashMap hashMap = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.f48578b.put("c_time", Long.toString(currentTimeMillis));
            this.f48578b.put("cache_e", str);
            this.f48578b.put("cache_m", str2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("c_time", currentTimeMillis);
            jSONObject.put("cache_e", str);
            jSONObject.put("cache_m", str2);
            byte[] c4 = com.yxcorp.kuaishou.addfp.android.b.b.c(jSONObject.toString().getBytes(), "20212102sjcudiab".getBytes());
            try {
                bArr = Base64.encode(c4, 0);
            } catch (Throwable unused) {
                bArr = null;
            }
            if (bArr == null) {
                try {
                    bArr = Base64.encode(c4, 8);
                } catch (Throwable unused2) {
                }
            }
            if (bArr != null) {
                this.f48577a.a(new String(bArr));
            }
        } catch (Throwable unused3) {
        }
        try {
            String a10 = com.yxcorp.kuaishou.addfp.c.a.a.a(this.f48579c, "k_w_o_d_out_dtt");
            if (TextUtils.isEmpty(a10) && g.a(this.f48579c, new String[]{com.kuaishou.weapon.p0.g.f36123i, com.kuaishou.weapon.p0.g.f36124j})) {
                a10 = a("Lm91a2R0ZnQ=");
            }
            if (!TextUtils.isEmpty(a10) && (hashMap = b(a10)) != null) {
                c cVar = b.f48570a;
                String a11 = cVar.a();
                if (!TextUtils.isEmpty(a11)) {
                    if (hashMap.containsKey(a11)) {
                        hashMap.remove(a11);
                    }
                    hashMap.put(cVar.a(), str);
                }
            }
            if (hashMap == null || hashMap.size() == 0) {
                hashMap = new LinkedHashMap();
                hashMap.put(b.f48570a.a(), str);
            }
            String a12 = a(hashMap);
            if (!TextUtils.isEmpty(a12)) {
                try {
                    Settings.System.putString(this.f48579c.getContentResolver(), "k_w_o_d_out_dtt", a12);
                } catch (Throwable unused4) {
                }
                if (g.a(this.f48579c, new String[]{com.kuaishou.weapon.p0.g.f36123i, com.kuaishou.weapon.p0.g.f36124j})) {
                    a(this.f48579c, a12);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public LinkedHashMap b(String str) {
        Throwable th;
        ObjectInputStream objectInputStream = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                ObjectInputStream objectInputStream2 = new ObjectInputStream(new ByteArrayInputStream(com.yxcorp.kuaishou.addfp.android.b.b.b(Base64.decode(str.getBytes(), 0), "20212102sjcudiab".getBytes())));
                try {
                    LinkedHashMap linkedHashMap = (LinkedHashMap) objectInputStream2.readObject();
                    try {
                        objectInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return linkedHashMap;
                } catch (Throwable th2) {
                    th = th2;
                    objectInputStream = objectInputStream2;
                    try {
                        th.printStackTrace();
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return new LinkedHashMap();
                    } catch (Throwable th3) {
                        if (objectInputStream != null) {
                            try {
                                objectInputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
        return new LinkedHashMap();
    }
}
