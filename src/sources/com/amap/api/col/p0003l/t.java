package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.amap.api.col.p0003l.fk;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.tools.GLFileUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AuthTask.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class t extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public WeakReference<IAMapDelegate> f6921a;

    /* renamed from: b, reason: collision with root package name */
    private Context f6922b;

    public t(Context context, IAMapDelegate iAMapDelegate) {
        this.f6921a = null;
        this.f6922b = context;
        this.f6921a = new WeakReference<>(iAMapDelegate);
    }

    private void b(JSONObject jSONObject) {
        IAMapDelegate iAMapDelegate;
        IAMapDelegate iAMapDelegate2;
        IAMapDelegate iAMapDelegate3;
        if (jSONObject == null) {
            return;
        }
        try {
            x.a().a(jSONObject.optJSONObject("1A1"));
            if (!x.a().a("feature_terrain") && (iAMapDelegate3 = this.f6921a.get()) != null) {
                iAMapDelegate3.setTerrainAuth(false);
                dx.a(new AMapException(AMapException.FEATURE_TERRAIN_NOT_SUPPORT));
            }
            if (!x.a().a("feature_gltf") && (iAMapDelegate2 = this.f6921a.get()) != null) {
                IGlOverlayLayer glOverlayLayer = iAMapDelegate2.getGlOverlayLayer();
                if (glOverlayLayer != null) {
                    glOverlayLayer.clearOverlayByType("GLTFOVERLAY");
                }
                dx.a(new AMapException(AMapException.FEATURE_GLTF_NOT_SUPPORT));
            }
            if (x.a().a("feature_mvt") || (iAMapDelegate = this.f6921a.get()) == null) {
                return;
            }
            IGlOverlayLayer glOverlayLayer2 = iAMapDelegate.getGlOverlayLayer();
            if (glOverlayLayer2 != null) {
                glOverlayLayer2.clearOverlayByType("MVTTILEOVERLAY");
            }
            dx.a(new AMapException(AMapException.FEATURE_MVT_NOT_SUPPORT));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16G");
            boolean a10 = fk.a(optJSONObject.optString("able", ""), false);
            boolean a11 = fk.a(optJSONObject.optString("removeCache", ""), false);
            boolean a12 = fk.a(optJSONObject.optString("uploadInfo", ""), false);
            Cdo.a(a10);
            Cdo.b(a11);
            Cdo.c(a12);
        } catch (Throwable unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            dn.a(this.f6922b, "amap_param", "overlay_use_old_type", Boolean.valueOf(fk.a(jSONObject.optJSONObject("17W").optString("able", ""), false) ? false : true));
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        super.interrupt();
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x029a A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00c4, B:25:0x00cd, B:27:0x00d1, B:29:0x00d9, B:31:0x00e3, B:34:0x00f7, B:35:0x00fc, B:37:0x0102, B:38:0x0107, B:40:0x010d, B:42:0x0114, B:44:0x0118, B:46:0x011e, B:48:0x0129, B:53:0x01a2, B:71:0x01d8, B:73:0x01dd, B:75:0x01e1, B:77:0x01e9, B:79:0x01f6, B:81:0x01fa, B:83:0x0209, B:85:0x020d, B:87:0x0215, B:90:0x0279, B:92:0x027d, B:94:0x0284, B:96:0x0288, B:98:0x028f, B:100:0x0293, B:102:0x029a, B:104:0x029e, B:105:0x02a3, B:107:0x02b3, B:109:0x02b9, B:150:0x019a, B:56:0x01a6, B:58:0x01ae, B:60:0x01b4, B:62:0x01c0, B:64:0x01c6, B:67:0x01d3), top: B:2:0x0016, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02b3 A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00c4, B:25:0x00cd, B:27:0x00d1, B:29:0x00d9, B:31:0x00e3, B:34:0x00f7, B:35:0x00fc, B:37:0x0102, B:38:0x0107, B:40:0x010d, B:42:0x0114, B:44:0x0118, B:46:0x011e, B:48:0x0129, B:53:0x01a2, B:71:0x01d8, B:73:0x01dd, B:75:0x01e1, B:77:0x01e9, B:79:0x01f6, B:81:0x01fa, B:83:0x0209, B:85:0x020d, B:87:0x0215, B:90:0x0279, B:92:0x027d, B:94:0x0284, B:96:0x0288, B:98:0x028f, B:100:0x0293, B:102:0x029a, B:104:0x029e, B:105:0x02a3, B:107:0x02b3, B:109:0x02b9, B:150:0x019a, B:56:0x01a6, B:58:0x01ae, B:60:0x01b4, B:62:0x01c0, B:64:0x01c6, B:67:0x01d3), top: B:2:0x0016, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0252 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01a2 A[Catch: all -> 0x02c5, TRY_LEAVE, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00c4, B:25:0x00cd, B:27:0x00d1, B:29:0x00d9, B:31:0x00e3, B:34:0x00f7, B:35:0x00fc, B:37:0x0102, B:38:0x0107, B:40:0x010d, B:42:0x0114, B:44:0x0118, B:46:0x011e, B:48:0x0129, B:53:0x01a2, B:71:0x01d8, B:73:0x01dd, B:75:0x01e1, B:77:0x01e9, B:79:0x01f6, B:81:0x01fa, B:83:0x0209, B:85:0x020d, B:87:0x0215, B:90:0x0279, B:92:0x027d, B:94:0x0284, B:96:0x0288, B:98:0x028f, B:100:0x0293, B:102:0x029a, B:104:0x029e, B:105:0x02a3, B:107:0x02b3, B:109:0x02b9, B:150:0x019a, B:56:0x01a6, B:58:0x01ae, B:60:0x01b4, B:62:0x01c0, B:64:0x01c6, B:67:0x01d3), top: B:2:0x0016, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01dd A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00c4, B:25:0x00cd, B:27:0x00d1, B:29:0x00d9, B:31:0x00e3, B:34:0x00f7, B:35:0x00fc, B:37:0x0102, B:38:0x0107, B:40:0x010d, B:42:0x0114, B:44:0x0118, B:46:0x011e, B:48:0x0129, B:53:0x01a2, B:71:0x01d8, B:73:0x01dd, B:75:0x01e1, B:77:0x01e9, B:79:0x01f6, B:81:0x01fa, B:83:0x0209, B:85:0x020d, B:87:0x0215, B:90:0x0279, B:92:0x027d, B:94:0x0284, B:96:0x0288, B:98:0x028f, B:100:0x0293, B:102:0x029a, B:104:0x029e, B:105:0x02a3, B:107:0x02b3, B:109:0x02b9, B:150:0x019a, B:56:0x01a6, B:58:0x01ae, B:60:0x01b4, B:62:0x01c0, B:64:0x01c6, B:67:0x01d3), top: B:2:0x0016, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01f6 A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00c4, B:25:0x00cd, B:27:0x00d1, B:29:0x00d9, B:31:0x00e3, B:34:0x00f7, B:35:0x00fc, B:37:0x0102, B:38:0x0107, B:40:0x010d, B:42:0x0114, B:44:0x0118, B:46:0x011e, B:48:0x0129, B:53:0x01a2, B:71:0x01d8, B:73:0x01dd, B:75:0x01e1, B:77:0x01e9, B:79:0x01f6, B:81:0x01fa, B:83:0x0209, B:85:0x020d, B:87:0x0215, B:90:0x0279, B:92:0x027d, B:94:0x0284, B:96:0x0288, B:98:0x028f, B:100:0x0293, B:102:0x029a, B:104:0x029e, B:105:0x02a3, B:107:0x02b3, B:109:0x02b9, B:150:0x019a, B:56:0x01a6, B:58:0x01ae, B:60:0x01b4, B:62:0x01c0, B:64:0x01c6, B:67:0x01d3), top: B:2:0x0016, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0209 A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00c4, B:25:0x00cd, B:27:0x00d1, B:29:0x00d9, B:31:0x00e3, B:34:0x00f7, B:35:0x00fc, B:37:0x0102, B:38:0x0107, B:40:0x010d, B:42:0x0114, B:44:0x0118, B:46:0x011e, B:48:0x0129, B:53:0x01a2, B:71:0x01d8, B:73:0x01dd, B:75:0x01e1, B:77:0x01e9, B:79:0x01f6, B:81:0x01fa, B:83:0x0209, B:85:0x020d, B:87:0x0215, B:90:0x0279, B:92:0x027d, B:94:0x0284, B:96:0x0288, B:98:0x028f, B:100:0x0293, B:102:0x029a, B:104:0x029e, B:105:0x02a3, B:107:0x02b3, B:109:0x02b9, B:150:0x019a, B:56:0x01a6, B:58:0x01ae, B:60:0x01b4, B:62:0x01c0, B:64:0x01c6, B:67:0x01d3), top: B:2:0x0016, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0279 A[Catch: all -> 0x02c5, TRY_ENTER, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00c4, B:25:0x00cd, B:27:0x00d1, B:29:0x00d9, B:31:0x00e3, B:34:0x00f7, B:35:0x00fc, B:37:0x0102, B:38:0x0107, B:40:0x010d, B:42:0x0114, B:44:0x0118, B:46:0x011e, B:48:0x0129, B:53:0x01a2, B:71:0x01d8, B:73:0x01dd, B:75:0x01e1, B:77:0x01e9, B:79:0x01f6, B:81:0x01fa, B:83:0x0209, B:85:0x020d, B:87:0x0215, B:90:0x0279, B:92:0x027d, B:94:0x0284, B:96:0x0288, B:98:0x028f, B:100:0x0293, B:102:0x029a, B:104:0x029e, B:105:0x02a3, B:107:0x02b3, B:109:0x02b9, B:150:0x019a, B:56:0x01a6, B:58:0x01ae, B:60:0x01b4, B:62:0x01c0, B:64:0x01c6, B:67:0x01d3), top: B:2:0x0016, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0284 A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00c4, B:25:0x00cd, B:27:0x00d1, B:29:0x00d9, B:31:0x00e3, B:34:0x00f7, B:35:0x00fc, B:37:0x0102, B:38:0x0107, B:40:0x010d, B:42:0x0114, B:44:0x0118, B:46:0x011e, B:48:0x0129, B:53:0x01a2, B:71:0x01d8, B:73:0x01dd, B:75:0x01e1, B:77:0x01e9, B:79:0x01f6, B:81:0x01fa, B:83:0x0209, B:85:0x020d, B:87:0x0215, B:90:0x0279, B:92:0x027d, B:94:0x0284, B:96:0x0288, B:98:0x028f, B:100:0x0293, B:102:0x029a, B:104:0x029e, B:105:0x02a3, B:107:0x02b3, B:109:0x02b9, B:150:0x019a, B:56:0x01a6, B:58:0x01ae, B:60:0x01b4, B:62:0x01c0, B:64:0x01c6, B:67:0x01d3), top: B:2:0x0016, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x028f A[Catch: all -> 0x02c5, TryCatch #1 {all -> 0x02c5, blocks: (B:3:0x0016, B:7:0x001d, B:22:0x00c4, B:25:0x00cd, B:27:0x00d1, B:29:0x00d9, B:31:0x00e3, B:34:0x00f7, B:35:0x00fc, B:37:0x0102, B:38:0x0107, B:40:0x010d, B:42:0x0114, B:44:0x0118, B:46:0x011e, B:48:0x0129, B:53:0x01a2, B:71:0x01d8, B:73:0x01dd, B:75:0x01e1, B:77:0x01e9, B:79:0x01f6, B:81:0x01fa, B:83:0x0209, B:85:0x020d, B:87:0x0215, B:90:0x0279, B:92:0x027d, B:94:0x0284, B:96:0x0288, B:98:0x028f, B:100:0x0293, B:102:0x029a, B:104:0x029e, B:105:0x02a3, B:107:0x02b3, B:109:0x02b9, B:150:0x019a, B:56:0x01a6, B:58:0x01ae, B:60:0x01b4, B:62:0x01c0, B:64:0x01c6, B:67:0x01d3), top: B:2:0x0016, inners: #4 }] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 747
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.t.run():void");
    }

    private static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            dz.a(jSONObject.optJSONObject("17E"));
        } catch (Throwable unused) {
        }
    }

    private static void a(Context context, fu fuVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("16V");
            boolean a10 = fk.a(optJSONObject.optString("di", ""), false);
            String optString = optJSONObject.optString("dis", "");
            boolean a11 = fk.a(optJSONObject.optString("able", ""), false);
            boolean a12 = fk.a(optJSONObject.optString("isFilter", ""), true);
            if (!a10 || fv.e(optString)) {
                ha.a(fuVar).a(context, a11, a12);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(fk.b.a aVar) {
        if (aVar != null) {
            try {
                dt.a(this.f6922b, "maploc", "ue", Boolean.valueOf(aVar.f5810a));
                JSONObject jSONObject = aVar.f5812c;
                int optInt = jSONObject.optInt("fn", 1000);
                int optInt2 = jSONObject.optInt("mpn", 0);
                if (optInt2 > 500) {
                    optInt2 = 500;
                }
                if (optInt2 < 30) {
                    optInt2 = 30;
                }
                ik.a(optInt, fk.a(jSONObject.optString("igu"), false));
                dt.a(this.f6922b, "maploc", "opn", Integer.valueOf(optInt2));
            } catch (Throwable th) {
                gy.b(th, "AuthUtil", "loadConfigDataUploadException");
            }
        }
    }

    private Pair<JSONObject, fk.b.a> a(StringBuilder sb2) {
        String str;
        JSONObject jSONObject;
        fk.b.a aVar;
        WeakReference<IAMapDelegate> weakReference;
        try {
            long longValue = dn.a(this.f6922b, "cloud_config_pull", "cloud_config_pull_timestamp", (Long) 0L).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - longValue) >= 86400000) {
                str = sb2.toString();
                str.replaceAll(";;", ";");
                dn.a(this.f6922b, "cloud_config_pull", "cloud_config_pull_timestamp", (Object) new Long(currentTimeMillis));
            } else {
                str = "";
            }
            fk.b a10 = fk.a(this.f6922b, dx.a(), str, (Map<String, String>) null);
            if (fk.f5771a != 1 && str != "" && a10 != null && (weakReference = this.f6921a) != null && weakReference.get() != null) {
                Message obtainMessage = this.f6921a.get().getMainHandler().obtainMessage();
                obtainMessage.what = 2;
                String str2 = a10.f5803c;
                if (str2 != null) {
                    obtainMessage.obj = str2;
                }
                this.f6921a.get().getMainHandler().sendMessage(obtainMessage);
            }
            String str3 = GLFileUtil.getCacheDir(this.f6922b).getAbsolutePath() + "/authCustomConfigName";
            if (!TextUtils.isEmpty(str) && a10 != null && (jSONObject = a10.f5806f) != null) {
                GLFileUtil.writeDatasToFile(str3, jSONObject.toString().getBytes());
            } else {
                jSONObject = new JSONObject(new String(GLFileUtil.readFileContents(str3)));
            }
            String str4 = GLFileUtil.getCacheDir(this.f6922b).getAbsolutePath() + "/authLogConfigName";
            if (!TextUtils.isEmpty(str) && a10 != null && a10.f5807g != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("IsExceptionUpdate", a10.f5807g.f5810a);
                jSONObject2.put("mOfflineLoc", a10.f5807g.f5812c);
                GLFileUtil.writeDatasToFile(str4, jSONObject2.toString().getBytes());
                aVar = a10.f5807g;
            } else {
                byte[] readFileContents = GLFileUtil.readFileContents(str4);
                fk.b.a aVar2 = new fk.b.a();
                JSONObject jSONObject3 = new JSONObject(new String(readFileContents));
                aVar2.f5810a = jSONObject3.getBoolean("IsExceptionUpdate");
                if (jSONObject3.has("mOfflineLoc")) {
                    aVar2.f5812c = jSONObject3.getJSONObject("mOfflineLoc");
                }
                aVar = aVar2;
            }
            return new Pair<>(jSONObject, aVar);
        } catch (Throwable unused) {
            return null;
        }
    }
}
