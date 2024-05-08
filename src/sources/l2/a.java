package l2;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.cupidapp.live.liveshow.beauty.databeauty.license.EffectLicenseProvider;
import com.effectsar.labcv.effectsdk.EffectsSDKEffectConstants;
import com.effectsar.labcv.effectsdk.RenderManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* compiled from: EffectManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Context f51581a;

    /* renamed from: c, reason: collision with root package name */
    public l2.c f51583c;

    /* renamed from: d, reason: collision with root package name */
    public EffectLicenseProvider f51584d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC0783a f51585e;

    /* renamed from: f, reason: collision with root package name */
    public String f51586f;

    /* renamed from: g, reason: collision with root package name */
    public String f51587g;

    /* renamed from: h, reason: collision with root package name */
    public Set<b> f51588h = new HashSet();

    /* renamed from: i, reason: collision with root package name */
    public Set<String> f51589i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public boolean f51590j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f51591k = false;

    /* renamed from: l, reason: collision with root package name */
    public float f51592l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    public String f51593m = "";

    /* renamed from: b, reason: collision with root package name */
    public RenderManager f51582b = new RenderManager();

    /* compiled from: EffectManager.java */
    /* renamed from: l2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface InterfaceC0783a {
        void a();
    }

    /* compiled from: EffectManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f51594a;

        /* renamed from: b, reason: collision with root package name */
        public String f51595b;

        /* renamed from: c, reason: collision with root package name */
        public float f51596c;

        public b(String str, String str2, float f10) {
            this.f51594a = str;
            this.f51595b = str2;
            this.f51596c = f10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return Objects.equals(this.f51594a, bVar.f51594a) && Objects.equals(this.f51595b, bVar.f51595b);
        }

        public int hashCode() {
            return Objects.hash(this.f51594a, this.f51595b);
        }
    }

    /* compiled from: EffectManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class c extends b {

        /* renamed from: d, reason: collision with root package name */
        public int f51597d;

        /* renamed from: e, reason: collision with root package name */
        public long f51598e;

        /* renamed from: f, reason: collision with root package name */
        public long f51599f;

        /* renamed from: g, reason: collision with root package name */
        public String f51600g;
    }

    public a(Context context, l2.c cVar, EffectLicenseProvider effectLicenseProvider) {
        this.f51581a = context;
        this.f51583c = cVar;
        this.f51584d = effectLicenseProvider;
    }

    public boolean a(String[] strArr) {
        String c4 = this.f51583c.c();
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (TextUtils.isEmpty(strArr[i10]) || strArr[i10].contains(this.f51581a.getPackageName())) {
                strArr2[i10] = strArr[i10];
            } else {
                strArr2[i10] = c4 + strArr[i10];
            }
        }
        if (this.f51591k) {
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (!this.f51589i.contains(strArr2[i11])) {
                    this.f51590j = true;
                    break;
                }
                i11++;
            }
            this.f51589i.addAll(Arrays.asList(strArr2));
        }
        boolean z10 = this.f51582b.appendComposerNodes(strArr2) == 0;
        if (this.f51591k && this.f51590j) {
            this.f51582b.loadResourceWithTimeout(-1);
            this.f51590j = false;
        }
        return z10;
    }

    public boolean b(String str, int i10) {
        if (i10 == 0 || i10 == -11 || i10 == 1) {
            return true;
        }
        String str2 = str + " error: " + i10;
        q2.c.b(str2);
        String formatErrorCode = RenderManager.formatErrorCode(i10);
        if (formatErrorCode != null) {
            str2 = formatErrorCode;
        }
        Intent intent = new Intent("com.effectsar.labcv.core.check_result:action");
        intent.putExtra("msg", str2);
        LocalBroadcastManager.getInstance(this.f51581a).sendBroadcast(intent);
        return false;
    }

    public void c() {
        this.f51582b.cleanPipeline();
    }

    public final boolean d(String[] strArr, String str) {
        boolean z10 = false;
        for (String str2 : strArr) {
            if (TextUtils.equals(str2, str)) {
                z10 = true;
            }
        }
        return z10;
    }

    public int e() {
        q2.c.a("destroyEffectSDK");
        this.f51582b.release();
        this.f51590j = false;
        this.f51589i.clear();
        q2.c.a("destroyEffectSDK finish");
        return 0;
    }

    public final String[] f(Set<b> set) {
        if (set == null || set.size() == 0) {
            return new String[0];
        }
        HashSet hashSet = new HashSet();
        Iterator<b> iterator2 = set.iterator2();
        while (iterator2.hasNext()) {
            hashSet.add(iterator2.next().f51594a);
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public String g(String str) {
        return this.f51583c.b(str);
    }

    public int h() {
        String str;
        try {
            str = this.f51581a.getPackageManager().getPackageInfo(this.f51581a.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            str = null;
        }
        q2.c.b("Effect SDK version =" + str);
        if (!this.f51584d.b("getLicensePath")) {
            return this.f51584d.d();
        }
        int init = this.f51582b.init(this.f51581a, this.f51583c.a(), this.f51584d.a(), this.f51581a.getCacheDir().getAbsolutePath(), true, this.f51584d.e() == EffectLicenseProvider.LICENSE_MODE_ENUM.ONLINE_LICENSE, ((ActivityManager) this.f51581a.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 196608 ? 1 : 0);
        if (!b("mRenderManager.init", init)) {
            return init;
        }
        t(true);
        m(false);
        this.f51582b.setResourceLicense(this.f51584d.c());
        InterfaceC0783a interfaceC0783a = this.f51585e;
        if (interfaceC0783a != null) {
            interfaceC0783a.a();
        }
        return init;
    }

    public void i() {
        this.f51582b.cleanPipeline();
    }

    public boolean j(int i10, int i11, int i12, int i13, EffectsSDKEffectConstants.Rotation rotation, long j10) {
        p2.a.e("effectProcess");
        if (this.f51591k && this.f51590j) {
            this.f51582b.loadResourceWithTimeout(-1);
            this.f51590j = false;
        }
        boolean processTexture = this.f51582b.processTexture(i10, i11, i12, i13, rotation, j10);
        p2.a.f("effectProcess");
        return processTexture;
    }

    public void k() {
        q2.c.a("recover status");
        if (!TextUtils.isEmpty(this.f51586f)) {
            this.f51582b.setFilter(this.f51586f);
        }
        if (!TextUtils.isEmpty(this.f51587g)) {
            this.f51582b.setSticker(this.f51587g);
        }
        q2.c.a("mSavedComposerNodes size =" + this.f51588h.size() + "  " + ((Object) this.f51588h));
        if (this.f51588h.size() > 0) {
            String[] f10 = f(this.f51588h);
            String c4 = this.f51583c.c();
            int length = f10.length;
            String[] strArr = new String[length];
            for (int i10 = 0; i10 < f10.length; i10++) {
                if (TextUtils.isEmpty(f10[i10]) || f10[i10].contains(this.f51581a.getPackageName())) {
                    strArr[i10] = f10[i10];
                } else {
                    strArr[i10] = c4 + f10[i10];
                }
            }
            if (this.f51591k) {
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (!this.f51589i.contains(strArr[i11])) {
                        this.f51590j = true;
                        break;
                    }
                    i11++;
                }
                this.f51589i.clear();
                this.f51589i.addAll(Arrays.asList(strArr));
            }
            this.f51582b.setComposerNodes(strArr);
            if (this.f51591k && this.f51590j) {
                this.f51582b.loadResourceWithTimeout(-1);
                this.f51590j = false;
            }
            for (b bVar : this.f51588h) {
                if (bVar instanceof c) {
                    c cVar = (c) bVar;
                    this.f51582b.sendMessage(cVar.f51597d, cVar.f51598e, cVar.f51599f, cVar.f51600g);
                } else {
                    String str = bVar.f51594a;
                    if (!TextUtils.isEmpty(str) && !bVar.f51594a.contains(this.f51581a.getPackageName())) {
                        str = c4 + bVar.f51594a;
                    }
                    q2.c.a("updateComposerNodes node =" + str + " key = " + bVar.f51595b + " intensity =" + bVar.f51596c);
                    this.f51582b.updateComposerNodes(str, bVar.f51595b, bVar.f51596c);
                }
            }
        }
        v(this.f51592l);
    }

    public boolean l(String[] strArr) {
        String c4 = this.f51583c.c();
        String[] strArr2 = new String[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (TextUtils.isEmpty(strArr[i10]) || strArr[i10].contains(this.f51581a.getPackageName())) {
                strArr2[i10] = strArr[i10];
            } else {
                strArr2[i10] = c4 + strArr[i10];
            }
            Iterator<b> iterator2 = this.f51588h.iterator2();
            while (iterator2.hasNext()) {
                if (TextUtils.equals(iterator2.next().f51594a, strArr[i10])) {
                    iterator2.remove();
                }
            }
        }
        if (this.f51591k) {
            this.f51589i.removeAll(Arrays.asList(strArr2));
        }
        return this.f51582b.removeComposerNodes(strArr2) == 0;
    }

    public boolean m(boolean z10) {
        return this.f51582b.set3Buffer(z10);
    }

    public void n(boolean z10) {
        RenderManager renderManager = this.f51582b;
        if (renderManager == null) {
            return;
        }
        renderManager.setCameraPostion(z10);
    }

    public boolean o(String[] strArr) {
        return p(strArr, null);
    }

    public boolean p(String[] strArr, String[] strArr2) {
        Iterator<b> iterator2 = this.f51588h.iterator2();
        while (iterator2.hasNext()) {
            if (!d(strArr, iterator2.next().f51594a)) {
                iterator2.remove();
            }
        }
        String c4 = this.f51583c.c();
        int length = strArr.length;
        String[] strArr3 = new String[length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (TextUtils.isEmpty(strArr[i10]) || strArr[i10].contains(this.f51581a.getPackageName())) {
                strArr3[i10] = strArr[i10];
            } else {
                strArr3[i10] = c4 + strArr[i10];
            }
        }
        if (this.f51591k) {
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (!this.f51589i.contains(strArr3[i11])) {
                    this.f51590j = true;
                    break;
                }
                i11++;
            }
            this.f51589i.clear();
            this.f51589i.addAll(Arrays.asList(strArr3));
        }
        boolean z10 = this.f51582b.setComposerNodesWithTags(strArr3, strArr2) == 0;
        if (this.f51591k && this.f51590j) {
            this.f51582b.loadResourceWithTimeout(-1);
            this.f51590j = false;
        }
        return z10;
    }

    public boolean q(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = this.f51583c.d(str);
        }
        this.f51586f = str;
        return this.f51582b.setFilter(str);
    }

    public void r(InterfaceC0783a interfaceC0783a) {
        this.f51585e = interfaceC0783a;
    }

    public boolean s(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = this.f51583c.b(str);
        }
        this.f51587g = str;
        return this.f51582b.setSticker(str);
    }

    public boolean t(boolean z10) {
        q2.c.a("setUseBuiltinSensor " + z10);
        return this.f51582b.useBuiltinSensor(z10) == 0;
    }

    public boolean u(String str, String str2, float f10) {
        b bVar = new b(str, str2, f10);
        if (this.f51588h.contains(bVar)) {
            this.f51588h.remove(bVar);
        }
        this.f51588h.add(bVar);
        if (!TextUtils.isEmpty(str) && !str.contains(this.f51581a.getPackageName())) {
            str = this.f51583c.c() + str;
        }
        q2.c.a("updateComposerNodes node =" + str + " key = " + str2 + " intensity =" + f10);
        return this.f51582b.updateComposerNodes(str, str2, f10) == 0;
    }

    public boolean v(float f10) {
        boolean updateIntensity = this.f51582b.updateIntensity(EffectsSDKEffectConstants.IntensityType.Filter.getId(), f10);
        if (updateIntensity) {
            this.f51592l = f10;
        }
        return updateIntensity;
    }
}
