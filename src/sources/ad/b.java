package ad;

import android.content.Context;
import android.text.TextUtils;
import com.wangmai.appsdkdex.WMAdSdk;
import com.wangmai.common.bean.AppConfigRespBean;
import com.wangmai.common.utils.AesUtil;
import com.wangmai.common.utils.AppConfigUtil;
import com.wangmai.common.utils.ConstantInfo;
import com.wangmai.common.utils.DebugLog;
import com.wangmai.common.utils.GZIPUtils;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.PrivateInfoHelper;
import com.wangmai.okhttp.OkHttp;
import com.wangmai.okhttp.callback.ByteCallback;
import com.wangmai.okhttp.model.Response;
import com.wangmai.okhttp.request.PostRequest;

/* compiled from: HttpNetUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f803a = "dexc";

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f804b;

    /* compiled from: HttpNetUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a extends ByteCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f805a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f806b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0011b f807c;

        public a(long j10, Context context, InterfaceC0011b interfaceC0011b) {
            this.f805a = j10;
            this.f806b = context;
            this.f807c = interfaceC0011b;
        }

        @Override // com.wangmai.okhttp.callback.AbsCallback, com.wangmai.okhttp.callback.Callback
        public void onError(Response<byte[]> response) {
            super.onError(response);
            Throwable exception = response.getException();
            DebugLog.release_e(b.f803a, zc.b.a("joju!dpogjh!fssps;") + exception.toString() + zc.b.a("-dpef;") + response.code());
            InterfaceC0011b interfaceC0011b = this.f807c;
            if (interfaceC0011b != null) {
                interfaceC0011b.a();
            }
        }

        @Override // com.wangmai.okhttp.callback.Callback
        public void onSuccess(Response<byte[]> response) {
            try {
                String str = b.f803a;
                DebugLog.D(str, zc.b.a("TEL扞樌捗ꆎ辯鏸搗遘瘷�") + (System.currentTimeMillis() - this.f805a) + zc.b.a("!nt"));
                AppConfigRespBean appConfigRespBean = (AppConfigRespBean) GsonUtils.getInstance().fromJson(GZIPUtils.unZipStringToByte(AesUtil.decryptToByte(response.body(), ConstantInfo.getAppToken())), AppConfigRespBean.class);
                if (appConfigRespBean != null && appConfigRespBean.getNbr().getCode() == 0) {
                    DebugLog.release_d(str, zc.b.a("gfudi!bqq!dpogjh!tvddftt;") + GsonUtils.getInstance().toJson(appConfigRespBean));
                    WMAdSdk.f46890m = appConfigRespBean.getRealmName();
                    WMAdSdk.f46891n = appConfigRespBean.getTrackHost();
                    AppConfigUtil.getInstance().saveAppConfig(this.f806b, appConfigRespBean);
                    PrivateInfoHelper.BeanInfo beanInfo = (PrivateInfoHelper.BeanInfo) GsonUtils.getInstance().fromJson(GsonUtils.getInstance().toJson(appConfigRespBean.getAppConfig().getAppPermissionConfig()), PrivateInfoHelper.BeanInfo.class);
                    if (beanInfo != null) {
                        PrivateInfoHelper.putPrivateInfo(this.f806b, beanInfo);
                    } else {
                        PrivateInfoHelper.putPrivateInfo(this.f806b, new PrivateInfoHelper.BeanInfo());
                    }
                    InterfaceC0011b interfaceC0011b = this.f807c;
                    if (interfaceC0011b != null) {
                        interfaceC0011b.onSuccess();
                        return;
                    }
                    return;
                }
                DebugLog.release_e(str, zc.b.a("joju!dpogjh!fssps!") + ((Object) appConfigRespBean));
                InterfaceC0011b interfaceC0011b2 = this.f807c;
                if (interfaceC0011b2 != null) {
                    interfaceC0011b2.a();
                }
            } catch (Throwable th) {
                DebugLog.release_e(b.f803a, zc.b.a("joju!dpogjh!gbjmfe!") + th);
                InterfaceC0011b interfaceC0011b3 = this.f807c;
                if (interfaceC0011b3 != null) {
                    interfaceC0011b3.a();
                }
            }
        }
    }

    /* compiled from: HttpNetUtils.java */
    /* renamed from: ad.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface InterfaceC0011b {
        void a();

        void onSuccess();
    }

    public static b a() {
        if (f804b == null) {
            synchronized (b.class) {
                if (f804b == null) {
                    f804b = new b();
                }
            }
        }
        return f804b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(Context context, String str, InterfaceC0011b interfaceC0011b) {
        long currentTimeMillis = System.currentTimeMillis();
        String json = GsonUtils.getInstance().toJson(c.a(context, ConstantInfo.getAppToken(), ConstantInfo.getAppKey()));
        byte[] encryptByt = AesUtil.encryptByt(GZIPUtils.compress(json, zc.b.a("vug.9")), ConstantInfo.getAppToken());
        if (TextUtils.isEmpty(str)) {
            str = zc.b.a("iuuqt;00tel/npcbet/bexbohnbj/dpn0");
        }
        DebugLog.D(f803a, zc.b.a("鏸搗TEL扞樌捗ꆎ辯!vsm>") + str + zc.b.a("tel0bqq0nd/bqj") + zc.b.a("\u000bebub>") + json);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(zc.b.a("tel0bqq0nd/bqj"));
        ((PostRequest) OkHttp.post(sb2.toString()).headers(zc.b.a("Dpoufou.Uzqf"), zc.b.a("bqqmjdbujpo0ktpo"))).upBytes(encryptByt).execute(new a(currentTimeMillis, context, interfaceC0011b));
    }
}
