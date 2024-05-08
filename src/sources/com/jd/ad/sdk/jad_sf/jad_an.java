package com.jd.ad.sdk.jad_sf;

import android.text.TextUtils;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_ob.jad_hu;
import com.jd.ad.sdk.jad_sf.jad_bo;
import com.jd.ad.sdk.jad_vi.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: DataCache.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class jad_an {
    public final Map<String, Object> jad_an = new HashMap();
    public final ReadWriteLock jad_bo = new ReentrantReadWriteLock();

    /* compiled from: DataCache.java */
    /* renamed from: com.jd.ad.sdk.jad_sf.jad_an$jad_an, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class RunnableC0392jad_an implements Runnable {
        public final /* synthetic */ String jad_an;
        public final /* synthetic */ Object jad_bo;

        public RunnableC0392jad_an(jad_an jad_anVar, String str, Object obj) {
            this.jad_an = str;
            this.jad_bo = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            jad_cp.jad_an((jad_dq) null, this.jad_an, this.jad_bo);
        }
    }

    /* compiled from: DataCache.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class jad_bo {
        public static final jad_an jad_an = new jad_an();
    }

    public boolean jad_an(String str, boolean z10) {
        try {
            if (z10) {
                return this.jad_an.containsKey(str);
            }
            if (jad_hu.jad_dq(com.jd.ad.sdk.jad_do.jad_bo.jad_an())) {
                return jad_bo.jad_an.jad_an.jad_an(str, z10);
            }
            return jad_cp.jad_an(str);
        } catch (Exception unused) {
            return false;
        }
    }

    public synchronized void jad_bo(String str, Object obj) {
        try {
            if (!this.jad_an.containsKey(str)) {
                this.jad_an.put(str, obj);
            } else {
                Object obj2 = this.jad_an.get(str);
                if (obj2 != null && !obj2.equals(obj)) {
                    this.jad_an.put(str, obj);
                }
            }
        } catch (Exception e2) {
            Logger.w("Exception while mem: ", e2.getMessage());
        }
    }

    public int jad_cp(String str) {
        Object jad_bo2 = jad_bo.jad_an.jad_bo(str);
        if (jad_bo2 == null || !(jad_bo2 instanceof Integer)) {
            return -1;
        }
        return ((Integer) jad_bo2).intValue();
    }

    public String jad_dq(String str) {
        Object jad_bo2 = jad_bo.jad_an.jad_bo(str);
        return (jad_bo2 == null || !(jad_bo2 instanceof String)) ? "" : (String) jad_bo2;
    }

    public void jad_an(String str, Object obj) {
        this.jad_bo.writeLock().lock();
        try {
            if (jad_hu.jad_dq(com.jd.ad.sdk.jad_do.jad_bo.jad_an())) {
                jad_bo.jad_an.jad_an.jad_an(str, obj);
            } else {
                WorkExecutor.execute(new RunnableC0392jad_an(this, str, obj));
            }
        } catch (Exception e2) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_SAVE_CACHE_OTHER_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e2.getMessage()));
        } finally {
            this.jad_bo.writeLock().unlock();
        }
    }

    public Object jad_bo(String str) {
        Object obj;
        this.jad_bo.readLock().lock();
        try {
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.jad_bo.readLock().unlock();
            throw th;
        }
        if (this.jad_an.containsKey(str)) {
            obj = this.jad_an.get(str);
            this.jad_bo.readLock().unlock();
            return obj;
        }
        obj = null;
        this.jad_bo.readLock().unlock();
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T jad_an(String str, Class<T> cls) {
        T t2;
        this.jad_bo.readLock().lock();
        T t10 = null;
        try {
            if (jad_hu.jad_dq(com.jd.ad.sdk.jad_do.jad_bo.jad_an())) {
                t2 = jad_bo.jad_an.jad_an.jad_an(str, (Class) cls);
            } else if (this.jad_an.containsKey(str)) {
                t2 = jad_an(cls, this.jad_an.get(str));
            } else {
                t2 = jad_an(cls, jad_cp.jad_an((jad_dq) null, str, (Class<?>) cls));
            }
            t10 = t2;
        } catch (Exception e2) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_READ_CACHE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e2.getMessage()));
        } finally {
            this.jad_bo.readLock().unlock();
        }
        return t10;
    }

    public final <T> T jad_an(Class<T> cls, Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            String valueOf = String.valueOf(obj);
            if (TextUtils.isEmpty(valueOf)) {
                return null;
            }
            if (cls == String.class) {
                obj = (T) valueOf;
            } else if (cls == Integer.TYPE) {
                obj = (T) Integer.valueOf(valueOf);
            } else if (cls == Long.TYPE) {
                obj = (T) Long.valueOf(valueOf);
            } else if (cls == Float.TYPE) {
                obj = (T) Float.valueOf(valueOf);
            } else if (cls == Boolean.TYPE) {
                obj = (T) Boolean.valueOf(valueOf);
            } else if (cls == Double.TYPE) {
                obj = (T) Double.valueOf(valueOf);
            }
            return (T) obj;
        } catch (Exception e2) {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.CACHE_READ_CACHE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e2.getMessage()));
            return null;
        }
    }

    public void jad_an(String str, String str2) {
        byte[] bytes;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String ja2 = ANEProxy.ja(str2);
                if (!TextUtils.isEmpty(ja2) && (bytes = ja2.getBytes(Charset.forName("UTF-8"))) != null && bytes.length > 0) {
                    jad_bo.jad_an.jad_an(str, (Object) new String(bytes));
                }
            }
        } catch (Exception e2) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while s2ce: ");
            jad_an.append(e2.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
        }
    }

    public String jad_an(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String str2 = (String) jad_bo.jad_an.jad_an(str, String.class);
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            String jb2 = ANEProxy.jb(str2);
            return TextUtils.isEmpty(jb2) ? "" : jb2;
        } catch (Exception e2) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while gfcd: ");
            jad_an.append(e2.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
            return "";
        }
    }
}
