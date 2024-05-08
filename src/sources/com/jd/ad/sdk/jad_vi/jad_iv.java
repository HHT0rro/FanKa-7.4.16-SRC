package com.jd.ad.sdk.jad_vi;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.jad_xk.jad_kx;
import com.jd.ad.sdk.jad_xk.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: EventUploadManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class jad_iv implements jad_kx.jad_an {
    public ConcurrentLinkedQueue<jad_dq> jad_cp;
    public com.jd.ad.sdk.jad_vi.jad_cp jad_dq;
    public ConcurrentLinkedQueue<jad_dq> jad_er;
    public final AtomicBoolean jad_an = new AtomicBoolean(false);
    public final AtomicInteger jad_bo = new AtomicInteger(1);
    public boolean jad_fs = true;
    public String jad_jt = "";

    /* compiled from: EventUploadManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_an implements Runnable {
        public final /* synthetic */ JSONObject jad_an;

        public jad_an(JSONObject jSONObject) {
            this.jad_an = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver jad_an;
            com.jd.ad.sdk.jad_na.jad_dq jad_dqVar;
            StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("event: ");
            jad_an2.append((Object) this.jad_an);
            Logger.d(jad_an2.toString());
            jad_iv jad_ivVar = jad_iv.this;
            jad_dq jad_an3 = jad_iv.jad_an(this.jad_an);
            jad_iv.this.getClass();
            com.jd.ad.sdk.jad_na.jad_cp jad_cp = com.jd.ad.sdk.jad_pc.jad_an.jad_cp();
            String str = (jad_cp == null || (jad_dqVar = jad_cp.jad_bo) == null) ? "" : jad_dqVar.jad_an;
            if (jad_ivVar.jad_cp == null) {
                jad_ivVar.jad_cp = new ConcurrentLinkedQueue<>();
            }
            if (jad_ivVar.jad_er == null) {
                jad_ivVar.jad_er = new ConcurrentLinkedQueue<>();
            }
            jad_ivVar.jad_cp.add(jad_an3);
            if (jad_ivVar.jad_fs) {
                com.jd.ad.sdk.jad_vi.jad_cp jad_cpVar = jad_ivVar.jad_dq;
                if (jad_cpVar != null) {
                    jad_cpVar.jad_an(jad_an3, jad_ivVar.jad_jt);
                }
            } else {
                String str2 = jad_ivVar.jad_jt;
                synchronized (com.jd.ad.sdk.jad_re.jad_an.class) {
                    List<String> list = com.jd.ad.sdk.jad_re.jad_an.jad_an;
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            if (!TextUtils.isEmpty(jad_an3.jad_an().toString()) && (jad_an = com.jd.ad.sdk.jad_re.jad_an.jad_an()) != null) {
                                Uri parse = Uri.parse(com.jd.ad.sdk.jad_re.jad_an.jad_bo() + "db_event/update");
                                ContentValues contentValues = new ContentValues();
                                contentValues.put("event", jad_an3.jad_an().toString());
                                contentValues.put(ContentProviderManager.PLUGIN_PROCESS_NAME, str2);
                                contentValues.put("key", Integer.valueOf(jad_an3.jad_an));
                                jad_an.update(parse, contentValues, null, null);
                            }
                        } catch (Exception e2) {
                            Logger.w("Exception while multi process saving events: ", e2.getMessage());
                        }
                    }
                }
            }
            if (jad_ivVar.jad_cp.size() >= jad_ivVar.jad_bo.get()) {
                jad_ivVar.jad_an(str);
            }
        }
    }

    /* compiled from: EventUploadManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class jad_bo implements Runnable {
        public final /* synthetic */ String[] jad_an;

        public jad_bo(String[] strArr) {
            this.jad_an = strArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.jd.ad.sdk.jad_xk.jad_fs jad_an = jad_jt.jad_an();
                for (int i10 = 0; i10 < this.jad_an.length; i10++) {
                    jad_kx.jad_bo jad_an2 = com.jd.ad.sdk.jad_xk.jad_bo.jad_an();
                    jad_an2.jad_er = this.jad_an[i10];
                    jad_an2.jad_bo = jad_an;
                    jad_an2.jad_cp = 50000;
                    jad_an2.jad_dq = 100000;
                    jad_an2.jad_jt = jad_iv.this;
                    jad_an2.jad_an(com.jd.ad.sdk.jad_cn.jad_bo.jad_bo);
                }
            } catch (Exception e2) {
                Logger.w("Exception while gw event: ", e2.getMessage());
            }
        }
    }

    /* compiled from: EventUploadManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class jad_cp {
        public static final jad_iv jad_an = new jad_iv();
    }

    public void jad_bo(JSONObject jSONObject) {
        jad_er.jad_an.execute(new jad_an(jSONObject));
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x036a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0254  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.jd.ad.sdk.jad_vi.jad_dq jad_an(org.json.JSONObject r13) {
        /*
            Method dump skipped, instructions count: 905
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_vi.jad_iv.jad_an(org.json.JSONObject):com.jd.ad.sdk.jad_vi.jad_dq");
    }

    public static jad_dq jad_an(String str, int i10) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "tp", 5);
        JsonUtils.put(jSONObject, "extp", 1);
        JsonUtils.put(jSONObject, "ercd", Integer.valueOf(com.jd.ad.sdk.jad_uh.jad_an.CRASH_ERROR.jad_an));
        JsonUtils.put(jSONObject, "erin", str);
        JsonUtils.put(jSONObject, "crt", Integer.valueOf(i10));
        return jad_an(jSONObject);
    }

    public final synchronized void jad_an(String str) {
        ConcurrentLinkedQueue<jad_dq> concurrentLinkedQueue;
        try {
            concurrentLinkedQueue = this.jad_cp;
        } catch (Exception unused) {
            this.jad_an.set(false);
        }
        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty() && !this.jad_an.get()) {
            if (com.jd.ad.sdk.jad_tg.jad_an.jad_bo) {
                return;
            }
            this.jad_an.set(true);
            Iterator<jad_dq> iterator2 = this.jad_cp.iterator2();
            for (int i10 = 0; i10 < this.jad_bo.get(); i10++) {
                if (iterator2.hasNext()) {
                    this.jad_er.add(iterator2.next());
                }
            }
            if (this.jad_er.isEmpty()) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            byte[] jad_an2 = jad_jt.jad_an(this.jad_er);
            if (jad_an2 == null) {
                return;
            }
            com.jd.ad.sdk.jad_xk.jad_er jad_erVar = new com.jd.ad.sdk.jad_xk.jad_er(jad_an2);
            com.jd.ad.sdk.jad_xk.jad_fs jad_an3 = jad_jt.jad_an();
            jad_kx.jad_bo jad_an4 = com.jd.ad.sdk.jad_xk.jad_bo.jad_an();
            jad_an4.jad_er = str;
            jad_an4.jad_fs = jad_erVar;
            jad_an4.jad_bo = jad_an3;
            jad_an4.jad_cp = 50000;
            jad_an4.jad_dq = 100000;
            jad_an4.jad_jt = this;
            jad_an4.jad_an(com.jd.ad.sdk.jad_cn.jad_bo.jad_bo);
            jad_an();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        if (r1.inTransaction() != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ac, code lost:
    
        r0.jad_an.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00aa, code lost:
    
        if (r1.inTransaction() != false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void jad_an() {
        /*
            Method dump skipped, instructions count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_vi.jad_iv.jad_an():void");
    }

    public void jad_an(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return;
        }
        jad_er.jad_an.execute(new jad_bo(strArr));
    }

    @Override // com.jd.ad.sdk.jad_xk.jad_kx.jad_an
    public void jad_an(jad_ly jad_lyVar) {
        com.jd.ad.sdk.jad_na.jad_dq jad_dqVar;
        this.jad_an.set(false);
        if (this.jad_cp.size() >= this.jad_bo.get()) {
            com.jd.ad.sdk.jad_na.jad_cp jad_cp2 = com.jd.ad.sdk.jad_pc.jad_an.jad_cp();
            jad_an((jad_cp2 == null || (jad_dqVar = jad_cp2.jad_bo) == null) ? "" : jad_dqVar.jad_an);
        }
    }

    @Override // com.jd.ad.sdk.jad_xk.jad_kx.jad_an
    public void jad_an(int i10, String str) {
        this.jad_an.set(false);
    }
}
