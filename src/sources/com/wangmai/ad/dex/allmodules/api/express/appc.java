package com.wangmai.ad.dex.allmodules.api.express;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.utils.appc;
import com.wangmai.ad.dex.allmodules.utils.appg;
import com.wangmai.ad.dex.allmodules.utils.appm;
import com.wangmai.ad.dex.allmodules.utils.appn;
import com.wangmai.appsdkdex.WMDexAdHelper;
import com.wangmai.appsdkdex.utils.VisibilityUtils;
import com.wangmai.common.runnable.HasTypeRunnable;
import com.wangmai.common.utils.GsonUtils;
import com.wangmai.common.utils.SharedPreferencesHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: NativeTempletProcesserNew.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appc {

    /* renamed from: appa, reason: collision with root package name */
    private int f46534appa;
    private int appb;
    private String appc;
    private List<String> appd;
    private String appe;
    private String appf;
    private int appg;
    private int apph;
    private int appi;
    private int appj;
    private int appk;
    private int appl;
    int appm;
    long appn;
    String appo;
    List<String> appp;
    String appq;
    private int appr;
    private Context apps;
    private ApiBean appt;
    private ViewGroup appu;
    private com.wangmai.ad.dex.allmodules.utils.appc appv;
    private NativeTempletViewNew appw;
    private appa.appa.appd.appc appx;
    public float appy = -999.0f;
    public float appz = -999.0f;

    /* renamed from: a, reason: collision with root package name */
    public float f46533a = -999.0f;

    /* renamed from: b, reason: collision with root package name */
    public float f46535b = -999.0f;

    /* renamed from: c, reason: collision with root package name */
    public boolean f46536c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: NativeTempletProcesserNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements HasTypeRunnable<ApiBean> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
        /* compiled from: NativeTempletProcesserNew.java */
        /* renamed from: com.wangmai.ad.dex.allmodules.api.express.appc$appa$appa, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
        public class C0663appa implements appc.appa {
            C0663appa() {
            }

            @Override // com.wangmai.ad.dex.allmodules.utils.appc.appa
            public void appa() {
                if (appc.this.appx != null) {
                    appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress onClick");
                    appc.this.appx.onClick();
                }
            }
        }

        appa() {
        }

        @Override // com.wangmai.common.runnable.HasTypeRunnable
        /* renamed from: appa, reason: merged with bridge method [inline-methods] */
        public void run(ApiBean apiBean) {
            if (apiBean == null) {
                appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress 广告获取失败");
                if (appc.this.appx != null) {
                    appc.this.appx.onNoAd("广告获取失败");
                    return;
                }
                return;
            }
            ApiBean.RespObj respObj = apiBean.getRespObj();
            ApiBean.WxadBean wxad = respObj.getWxad();
            if (apiBean != null && apiBean.getOptimization() != null && apiBean.getOptimization().getReportObject() != null) {
                appc.this.appi = apiBean.getOptimization().getReportObject().getShrand();
                appc.this.appj = apiBean.getOptimization().getReportObject().getShcrandom();
            }
            appc appcVar = appc.this;
            appcVar.appv = new com.wangmai.ad.dex.allmodules.utils.appc(appcVar.appu, appc.this.apps, appc.this.appi, appc.this.appj, appc.this.f46534appa, appc.this.appb, apiBean);
            appc.this.appv.appa(new C0663appa());
            if (respObj.getError_code() == 0 && wxad != null) {
                appc.this.appt = apiBean;
                appc.this.appb(respObj.getNurl());
                appc.this.appb(apiBean);
                appc.this.appa(apiBean);
                appc.this.appa(apiBean.getInvalidCridList());
                appc.this.appl();
                appc.this.appa(apiBean, wxad);
                return;
            }
            appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress 广告请求失败：" + respObj.getError_code());
            appc.this.appa(apiBean.getInvalidCridList());
            if (appc.this.appx != null) {
                appc.this.appx.onNoAd("广告请求失败：" + respObj.getError_code());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: NativeTempletProcesserNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements VisibilityUtils.ViewVisibilityChangeListener {
        appb() {
        }

        @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
        public void invisible() {
            try {
                if (appc.this.appw != null) {
                    appc.this.appw.appa(false);
                    appc.this.appk();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.wangmai.appsdkdex.utils.VisibilityUtils.ViewVisibilityChangeListener
        public void visible() {
            try {
                if (!appc.this.f46536c) {
                    appc.this.f46536c = true;
                    appc.this.appx.onExposure();
                    appc.this.appv.appa();
                    appc.this.appx.appa();
                }
                if (appc.this.appw != null) {
                    appc.this.appw.appa(true);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: NativeTempletProcesserNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appd implements View.OnTouchListener {
        appd() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                try {
                    appc.this.appy = motionEvent.getX();
                    appc.this.appz = motionEvent.getY();
                    appc.this.f46533a = motionEvent.getX();
                    appc.this.f46535b = motionEvent.getY();
                    int nextInt = new Random().nextInt(100) + 1;
                    if (appc.this.apph > 0 && nextInt <= appc.this.apph) {
                        if (appg.appa(appc.this.apps, appc.this.appu).booleanValue() && appc.this.appv != null) {
                            appa.appa.appf.appd.appe("NativeTempletProcNew", "IPA.MW NativeExpress p touchListener 广告容器可见");
                            appc.this.appv.appa("", false, com.wangmai.ad.dex.allmodules.utils.appf.appl, appc.this.appy, appc.this.appz, appc.this.f46533a, appc.this.f46535b);
                        } else {
                            appa.appa.appf.appd.appe("NativeTempletProcNew", "IPA.MW NativeExpress p touchListener 广告容器不可见");
                        }
                    }
                } catch (Throwable th) {
                    appa.appa.appf.appd.appe("NativeTempletProcNew", "IPA.MW NativeExpress p touchListener exception2:" + th.toString());
                }
            }
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: NativeTempletProcesserNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public interface appf {
        void appa();

        void appa(MotionEvent motionEvent);

        void appa(String str);

        void appb();

        void appc();

        void appd();

        void onClick();

        void start();
    }

    public appc(Context context, String str, String str2, int i10, int i11, int i12, appa.appa.appd.appc appcVar) {
        this.apps = context;
        this.appc = str;
        this.appf = str2;
        this.apph = i10;
        this.appx = appcVar;
        this.f46534appa = i11;
        this.appb = i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appl() {
        try {
            this.appw = new NativeTempletViewNew(WMDexAdHelper.getTopActivity(), this.appt, new appb());
            this.appw.setListener(new C0664appc());
            this.appw.setOnTouchListener(new appd());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletProcNew", "fetchNewNativiteView error:" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: NativeTempletProcesserNew.java */
    /* renamed from: com.wangmai.ad.dex.allmodules.api.express.appc$appc, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class C0664appc implements appf {

        /* renamed from: appa, reason: collision with root package name */
        private long f46540appa = 0;

        C0664appc() {
        }

        private synchronized void appe() {
            try {
                if (this.f46540appa == 0 || System.currentTimeMillis() - this.f46540appa > com.wangmai.ad.dex.allmodules.utils.appf.appc) {
                    this.f46540appa = System.currentTimeMillis();
                    if (appg.appa(appc.this.apps, appc.this.appu).booleanValue() && appc.this.appv != null) {
                        appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress p ad interaction广告容器可见");
                        appc.this.appv.appa("", false, com.wangmai.ad.dex.allmodules.utils.appf.appl, appc.this.appy, appc.this.appz, appc.this.f46533a, appc.this.f46535b);
                    } else {
                        appa.appa.appf.appd.appe("NativeTempletProcNew", "IPA.MW NativeExpress p ad interaction 广告容器不可见");
                    }
                }
            } finally {
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.api.express.appc.appf
        public void appa(MotionEvent motionEvent) {
            appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress p NativeTempletView touchEvent");
            appe();
        }

        @Override // com.wangmai.ad.dex.allmodules.api.express.appc.appf
        public void appb() {
            if (appc.this.appx == null) {
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.api.express.appc.appf
        public void appc() {
            appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress p NativeTempletView swipe", Float.valueOf(appc.this.appy));
            appe();
        }

        @Override // com.wangmai.ad.dex.allmodules.api.express.appc.appf
        public void appd() {
            if (appc.this.appx != null) {
                appc.this.appx.onAdClose();
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.api.express.appc.appf
        public void onClick() {
            appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress p NativeTempletView onClick", Float.valueOf(appc.this.appy));
            appe();
        }

        @Override // com.wangmai.ad.dex.allmodules.api.express.appc.appf
        public void start() {
            if (appc.this.appx == null) {
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.api.express.appc.appf
        public void appa() {
            appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress p NativeTempletView shake", Float.valueOf(appc.this.appy));
            appe();
        }

        @Override // com.wangmai.ad.dex.allmodules.api.express.appc.appf
        public void appa(String str) {
            appa.appa.appf.appd.appe("NativeTempletProcNew", "IPA.MW NativeExpress p vedioReflux:" + str);
        }
    }

    public void appc(int i10) {
        this.appl = i10;
    }

    public String appd() {
        return this.appq;
    }

    public int appe() {
        return this.appk;
    }

    public List<String> appf() {
        return this.appp;
    }

    public int appg() {
        return this.appl;
    }

    public int apph() {
        return this.appr;
    }

    public String appi() {
        return this.appo;
    }

    public void appj() {
        try {
            if (this.appw != null) {
                appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress onDestroy");
                this.appw.appa();
                appa.appa.appf.appb.appa(this.appw);
                appa.appa.appf.appb.appb(this.appw);
                this.appw.setOnClickListener(null);
                this.appw.setOnTouchListener(null);
                this.appw.setListener(null);
                this.appw = null;
            }
            if (this.appv != null) {
                this.appv.appb();
                this.appv = null;
            }
            if (this.appt != null) {
                this.appt.setRespObj(null);
                this.appt = null;
            }
            this.appx = null;
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletProcNew", "onDestroy:" + th.toString());
        }
    }

    public void appk() {
        NativeTempletViewNew nativeTempletViewNew = this.appw;
        if (nativeTempletViewNew != null) {
            nativeTempletViewNew.appc();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: NativeTempletProcesserNew.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appe implements appm {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ String f46542appa;
        final /* synthetic */ ApiBean.WxadBean appb;

        appe(String str, ApiBean.WxadBean wxadBean) {
            this.f46542appa = str;
            this.appb = wxadBean;
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa() {
            appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress p 视频物料下载失败");
            if (appc.this.appx != null) {
                appc.this.appx.onNoAd("暂无广告");
            }
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa(int i10) {
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appb() {
            appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress p downLoad material start, request url：" + this.f46542appa);
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appc() {
            appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress p downloading material...");
        }

        @Override // com.wangmai.ad.dex.allmodules.utils.appm
        public void appa(String str) {
            appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress p downLoad material success, request url：" + this.f46542appa);
            appc.this.appa((ApiBean.WxadBean) GsonUtils.getInstance().fromJson(GsonUtils.getInstance().toJson(this.appb), ApiBean.WxadBean.class));
            if (appc.this.appw != null) {
                appc.this.appw.setVideo(this.f46542appa);
                if (appc.this.appx != null) {
                    appc.this.appu.addView(appc.this.appw);
                    appc.this.appx.onRenderSuccess(appc.this.appu, 0, 0);
                    appc.this.appx.onAdRequest();
                    return;
                }
                return;
            }
            appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress p NativeTemplateView is null");
            if (appc.this.appx != null) {
                appc.this.appx.onNoAd("暂无广告");
            }
        }
    }

    void appb(ApiBean apiBean) {
        try {
            appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress DspBidPrice:" + apiBean.getAdPrice().getDspBidPrice(), "MediaBidPrice:" + apiBean.getAdPrice().getMediaBidPrice());
            appb((int) Math.round(apiBean.getAdPrice().getDspBidPrice() * 100.0d));
            appc((int) Math.round(apiBean.getAdPrice().getMediaBidPrice() * 100.0d));
            appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress DspBidPrice:" + appe(), "MediaBidPrice:" + appg());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletProcNew", "IPA.MW NativeExpress setDspAndMediaPrice exception" + th.toString());
        }
    }

    public long appc() {
        return this.appn;
    }

    public void appd(int i10) {
        this.appr = i10;
    }

    public void appa(ViewGroup viewGroup) {
        try {
            this.appu = viewGroup;
            appa.appa.appf.appd.appa("NativeTempletProcNew", "Api NativeExpress load viewGroup:" + ((Object) this.appu));
            appa();
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("NativeTempletProcNew", "Api NativeExpress load error:" + th.toString());
            appa.appa.appd.appc appcVar = this.appx;
            if (appcVar != null) {
                appcVar.onNoAd("暂无广告");
            }
        }
    }

    public void appb(int i10) {
        this.appk = i10;
    }

    public int appb() {
        return this.appm;
    }

    public void appb(String str) {
        this.appo = str;
    }

    void appa() {
        try {
            if (this.appu != null) {
                appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress requestId:" + this.appf, "slotId:" + this.appc);
                com.wangmai.ad.dex.allmodules.appc.appb.appa(this.apps, "NativeTempletProcNew", this.appc, this.appf, new appa());
            } else {
                appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress 广告加载失败：viewGroup is null");
                if (this.appx != null) {
                    this.appx.onNoAd("暂无广告");
                }
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress 广告加载失败：" + th.toString());
            appa.appa.appd.appc appcVar = this.appx;
            if (appcVar != null) {
                appcVar.onNoAd("暂无广告");
            }
        }
    }

    void appa(ApiBean apiBean) {
        try {
            if (apiBean.getOptimization() == null || apiBean.getOptimization().getAdCache() == null) {
                return;
            }
            appa(apiBean.getOptimization().getAdCache().getCacheTime() * 60 * 1000);
            appa(apiBean.getOptimization().getAdCache().getExpireTime());
            appa(apiBean.getOptimization().getAdCache().getCrid());
            appd(apiBean.getOptimization().getAdCache().getThirdSlotIdKey());
            appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress adCacheTime:" + appb(), "expireTime:" + appc(), "ThirdSlotIdKey:" + apph());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletProcNew", "IPA.MW NativeExpress setAdCache exception" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(ApiBean apiBean, ApiBean.WxadBean wxadBean) {
        try {
            this.appg = wxadBean.getCreative_type();
            if (this.appg == 0) {
                appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress p 未知交互类型:" + this.appg);
                if (this.appx != null) {
                    this.appx.onNoAd("暂无广告");
                    return;
                }
                return;
            }
            appa(wxadBean);
            int i10 = this.appg;
            if (i10 == 2 || i10 == 3) {
                if (this.appx != null) {
                    this.appx.onADIsVideo(false);
                }
                String image_src = wxadBean.getImage_src();
                if (TextUtils.isEmpty(image_src)) {
                    appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress p 图片物料无效");
                    if (this.appx != null) {
                        this.appx.onNoAd("暂无广告");
                        return;
                    }
                    return;
                }
                ArrayList arrayList = new ArrayList();
                String[] split = image_src.split(";");
                for (int i11 = 0; i11 < split.length; i11++) {
                    arrayList.add(split[i11]);
                    if (i11 == split.length - 1) {
                        this.appw.setImage(arrayList);
                    }
                    if (this.appx == null) {
                        return;
                    }
                }
                if (this.appx != null) {
                    this.appu.addView(this.appw);
                    this.appx.onRenderSuccess(this.appu, 0, 0);
                    this.appx.onAdRequest();
                    return;
                }
                return;
            }
            if (i10 == 5) {
                if (this.appx != null) {
                    this.appx.onADIsVideo(false);
                }
                this.appw.setWebContent(wxadBean.getDescription());
                if (this.appx != null) {
                    this.appu.addView(this.appw);
                    this.appx.onRenderSuccess(this.appu, 0, 0);
                    this.appx.onAdRequest();
                    return;
                }
                return;
            }
            if (i10 != 6) {
                return;
            }
            if (this.appx != null) {
                this.appx.onADIsVideo(true);
            }
            ApiBean.Video video = wxadBean.getVideo();
            if (video == null) {
                appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress p 视频物料无效");
                if (this.appx != null) {
                    this.appx.onNoAd("暂无广告");
                    return;
                }
                return;
            }
            if (video.getExt() != null) {
                this.appw.appa(video.getExt().getPreimgurl(), video.getExt().getEndimgurl());
            }
            if (video.getV_type() == 1) {
                String v_url = video.getV_url();
                if (appa.appa.appf.appb.appa(this.apps) == 1) {
                    if (TextUtils.isEmpty(v_url)) {
                        return;
                    }
                    appn.appa().appa(this.apps, "", true, 0, v_url, new appe(v_url, wxadBean));
                    return;
                }
                appa.appa.appf.appd.appa("NativeTempletProcNew", "IPA.MW NativeExpress 非Wifi环境，跳过视频物料下载");
                appa((ApiBean.WxadBean) GsonUtils.getInstance().fromJson(GsonUtils.getInstance().toJson(wxadBean), ApiBean.WxadBean.class));
                if (this.appw != null) {
                    this.appw.setVideo(v_url);
                    if (this.appx != null) {
                        this.appu.addView(this.appw);
                        this.appx.onRenderSuccess(this.appu, 0, 0);
                        this.appx.onAdRequest();
                        return;
                    }
                    return;
                }
                appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress p NativeTemplateView is null");
                if (this.appx != null) {
                    this.appx.onNoAd("暂无广告");
                    return;
                }
                return;
            }
            appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress 暂不支持该种视频物料类型:" + video.getV_type());
            if (this.appx != null) {
                this.appx.onNoAd("暂无广告");
            }
        } catch (Throwable th) {
            appa.appa.appf.appd.appb("NativeTempletProcNew", "IPA.MW NativeExpress p :" + th.toString());
            appa.appa.appd.appc appcVar = this.appx;
            if (appcVar != null) {
                appcVar.onNoAd("暂无广告");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(ApiBean.WxadBean wxadBean) {
        try {
            this.appd = wxadBean.getInstalled_track_urls();
            this.appe = wxadBean.getApp_package();
            if (this.appe == null || this.appd == null || this.appd.size() <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("installed_track_urls_size", Integer.valueOf(this.appd.size()));
            for (int i10 = 0; i10 < this.appd.size(); i10++) {
                hashMap.put("installed_track_urls" + i10, this.appd.get(i10));
            }
            hashMap.put("brand_name", this.appe);
            SharedPreferencesHelper.getInstance(this.apps).savePreferencesMap(hashMap);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe("NativeTempletProcNew", "IPA.MW NativeExpress p loadUrl exception：" + th.toString());
        }
    }

    public void appa(int i10) {
        this.appm = i10;
    }

    public void appa(long j10) {
        this.appn = j10;
    }

    public void appa(List<String> list) {
        this.appp = list;
    }

    public void appa(String str) {
        this.appq = str;
    }
}
