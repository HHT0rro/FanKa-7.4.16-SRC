package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UpdateItem.java */
@hi(a = "update_item", b = true)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bi extends bl {

    /* renamed from: n, reason: collision with root package name */
    private String f5123n = "";

    /* renamed from: o, reason: collision with root package name */
    private Context f5124o;

    public bi() {
    }

    private void i() {
        this.f5135d = dx.c(this.f5124o) + this.f5144m + ".zip.tmp";
    }

    public final String a() {
        return this.f5123n;
    }

    public final void b(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                if ("".equals(str) || (jSONObject = new JSONObject(str).getJSONObject("file")) == null) {
                    return;
                }
                this.f5132a = jSONObject.optString("title");
                this.f5134c = jSONObject.optString("code");
                this.f5133b = jSONObject.optString("url");
                this.f5135d = jSONObject.optString("fileName");
                this.f5137f = jSONObject.optLong("lLocalLength");
                this.f5138g = jSONObject.optLong("lRemoteLength");
                this.f5143l = jSONObject.optInt("mState");
                this.f5136e = jSONObject.optString("version");
                this.f5139h = jSONObject.optString("localPath");
                this.f5123n = jSONObject.optString("vMapFileNames");
                this.f5140i = jSONObject.optInt("isSheng");
                this.f5141j = jSONObject.optInt("mCompleteCode");
                this.f5142k = jSONObject.optString("mCityCode");
                String a10 = a(jSONObject, "pinyin");
                this.f5144m = a10;
                if ("".equals(a10)) {
                    String str2 = this.f5133b;
                    String substring = str2.substring(str2.lastIndexOf("/") + 1);
                    this.f5144m = substring.substring(0, substring.lastIndexOf("."));
                }
            } catch (Throwable th) {
                gy.b(th, "UpdateItem", "readFileToJSONObject");
                th.printStackTrace();
            }
        }
    }

    public final void a(String str) {
        this.f5123n = str;
    }

    public bi(OfflineMapCity offlineMapCity, Context context) {
        this.f5124o = context;
        this.f5132a = offlineMapCity.getCity();
        this.f5134c = offlineMapCity.getAdcode();
        this.f5133b = offlineMapCity.getUrl();
        this.f5138g = offlineMapCity.getSize();
        this.f5136e = offlineMapCity.getVersion();
        this.f5142k = offlineMapCity.getCode();
        this.f5140i = 0;
        this.f5143l = offlineMapCity.getState();
        this.f5141j = offlineMapCity.getcompleteCode();
        this.f5144m = offlineMapCity.getPinyin();
        i();
    }

    private static String a(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || "[]".equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }

    public bi(OfflineMapProvince offlineMapProvince, Context context) {
        this.f5124o = context;
        this.f5132a = offlineMapProvince.getProvinceName();
        this.f5134c = offlineMapProvince.getProvinceCode();
        this.f5133b = offlineMapProvince.getUrl();
        this.f5138g = offlineMapProvince.getSize();
        this.f5136e = offlineMapProvince.getVersion();
        this.f5140i = 1;
        this.f5143l = offlineMapProvince.getState();
        this.f5141j = offlineMapProvince.getcompleteCode();
        this.f5144m = offlineMapProvince.getPinyin();
        i();
    }

    public final void b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", this.f5132a);
            jSONObject2.put("code", this.f5134c);
            jSONObject2.put("url", this.f5133b);
            jSONObject2.put("fileName", this.f5135d);
            jSONObject2.put("lLocalLength", this.f5137f);
            jSONObject2.put("lRemoteLength", this.f5138g);
            jSONObject2.put("mState", this.f5143l);
            jSONObject2.put("version", this.f5136e);
            jSONObject2.put("localPath", this.f5139h);
            String str = this.f5123n;
            if (str != null) {
                jSONObject2.put("vMapFileNames", str);
            }
            jSONObject2.put("isSheng", this.f5140i);
            jSONObject2.put("mCompleteCode", this.f5141j);
            jSONObject2.put("mCityCode", this.f5142k);
            jSONObject2.put("pinyin", this.f5144m);
            jSONObject.put("file", jSONObject2);
            File file = new File(this.f5135d + ".dt");
            file.delete();
            OutputStreamWriter outputStreamWriter = null;
            try {
                try {
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");
                    try {
                        outputStreamWriter2.write(jSONObject.toString());
                        try {
                            outputStreamWriter2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } catch (IOException e10) {
                        e = e10;
                        outputStreamWriter = outputStreamWriter2;
                        gy.b(e, "UpdateItem", "saveJSONObjectToFile");
                        e.printStackTrace();
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e12) {
                                e12.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e13) {
                    e = e13;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            gy.b(th3, "UpdateItem", "saveJSONObjectToFile parseJson");
            th3.printStackTrace();
        }
    }
}
