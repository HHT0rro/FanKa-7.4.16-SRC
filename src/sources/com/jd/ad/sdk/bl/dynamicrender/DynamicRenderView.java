package com.jd.ad.sdk.bl.dynamicrender;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.sys.a;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.QuickCardField;
import com.jd.ad.sdk.R;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicCountdownListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.error.JADError;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.jad_ep.jad_iv;
import com.jd.ad.sdk.jad_hu.jad_hu;
import com.jd.ad.sdk.jad_js.jad_jt;
import com.jd.ad.sdk.jad_js.jad_na;
import com.jd.ad.sdk.jad_js.jad_sf;
import com.jd.ad.sdk.jad_js.jad_uh;
import com.jd.ad.sdk.jad_kv.jad_ly;
import com.jd.ad.sdk.jad_vi.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.lottie.LottieAnimationView;
import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class DynamicRenderView extends FrameLayout {
    public static final /* synthetic */ int jad_pa = 0;
    public double jad_an;
    public double jad_bo;
    public IDynamicRenderCallback jad_cn;
    public double jad_cp;
    public IDynamicCountdownListener jad_do;
    public double jad_dq;
    public int jad_ep;
    public double jad_er;
    public final CountDownLatch jad_fq;
    public boolean jad_fs;
    public boolean jad_gr;
    public Exception jad_hs;
    public ShakeListener jad_hu;
    public int jad_it;
    public String jad_iv;
    public int jad_jt;
    public float jad_ju;
    public double jad_jw;
    public float jad_kv;
    public double jad_kx;
    public float jad_lw;
    public String jad_ly;
    public float jad_mx;
    public double jad_mz;
    public double jad_na;
    public jad_dq jad_ny;
    public int jad_ob;
    public final Runnable jad_oz;
    public int jad_pc;
    public int jad_qd;
    public int jad_re;
    public LottieAnimationView jad_sf;
    public List<String> jad_tg;
    public List<String> jad_uh;
    public List<String> jad_vi;
    public final Map<String, com.jd.ad.sdk.jad_hu.jad_an> jad_wj;
    public String jad_xk;
    public final JSONObject jad_yl;
    public final Map<String, Bitmap> jad_zm;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface IDynamicRenderCallback {
        void onAnimationEnd();

        void onDynamicRenderFailed(int i10, String str);

        void onDynamicRenderSuccess(View view);

        void onFullLottieViewClick(Context context);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_an implements Runnable {
        public jad_an() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DynamicRenderView dynamicRenderView = DynamicRenderView.this;
            IDynamicCountdownListener iDynamicCountdownListener = dynamicRenderView.jad_do;
            if (iDynamicCountdownListener != null) {
                iDynamicCountdownListener.onAdCountdown(dynamicRenderView.jad_ep);
            }
            DynamicRenderView dynamicRenderView2 = DynamicRenderView.this;
            if (dynamicRenderView2.jad_fs) {
                dynamicRenderView2.jad_ep--;
            }
            if (dynamicRenderView2.jad_ep > 0) {
                dynamicRenderView2.postDelayed(dynamicRenderView2.jad_oz, 1000L);
            } else {
                dynamicRenderView2.removeCallbacks(dynamicRenderView2.jad_oz);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_bo extends com.jd.ad.sdk.jad_bm.jad_an<Bitmap> {
        public final /* synthetic */ jad_na jad_dq;
        public final /* synthetic */ Map jad_er;

        public jad_bo(jad_na jad_naVar, Map map) {
            this.jad_dq = jad_naVar;
            this.jad_er = map;
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_er
        public void jad_an(@Nullable Drawable drawable) {
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_er
        public void jad_an(@NonNull Object obj, @Nullable com.jd.ad.sdk.jad_en.jad_bo jad_boVar) {
            jad_na jad_naVar = this.jad_dq;
            DynamicRenderView.this.jad_zm.put(this.jad_dq.jad_cp, jad_hu.jad_an((Bitmap) obj, jad_naVar.jad_an, jad_naVar.jad_bo));
            Map map = this.jad_er;
            if (map == null || map.size() != DynamicRenderView.this.jad_zm.size()) {
                return;
            }
            try {
                DynamicRenderView.this.jad_fq.await();
                DynamicRenderView dynamicRenderView = DynamicRenderView.this;
                IDynamicRenderCallback iDynamicRenderCallback = dynamicRenderView.jad_cn;
                if (iDynamicRenderCallback == null || !dynamicRenderView.jad_gr) {
                    return;
                }
                iDynamicRenderCallback.onDynamicRenderSuccess(dynamicRenderView);
            } catch (Exception e2) {
                StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("loadImages error:");
                jad_an.append(Log.getStackTraceString(e2));
                Logger.d(jad_an.toString());
                IDynamicRenderCallback iDynamicRenderCallback2 = DynamicRenderView.this.jad_cn;
                if (iDynamicRenderCallback2 != null) {
                    JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                    iDynamicRenderCallback2.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new String[0]));
                }
            }
        }

        @Override // com.jd.ad.sdk.jad_bm.jad_an, com.jd.ad.sdk.jad_bm.jad_er
        public void jad_cp(@Nullable Drawable drawable) {
            IDynamicRenderCallback iDynamicRenderCallback = DynamicRenderView.this.jad_cn;
            if (iDynamicRenderCallback != null) {
                JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                iDynamicRenderCallback.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new String[0]));
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_cp implements Runnable {
        public final /* synthetic */ DynamicRenderView jad_an;
        public final /* synthetic */ Context jad_bo;
        public final /* synthetic */ JSONObject jad_cp;
        public final /* synthetic */ String jad_dq;

        public jad_cp(DynamicRenderView dynamicRenderView, DynamicRenderView dynamicRenderView2, Context context, JSONObject jSONObject, String str) {
            this.jad_an = dynamicRenderView2;
            this.jad_bo = context;
            this.jad_cp = jSONObject;
            this.jad_dq = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                DynamicRenderView dynamicRenderView = this.jad_an;
                if (dynamicRenderView != null) {
                    dynamicRenderView.jad_an(this.jad_bo, this.jad_cp, this.jad_dq);
                }
            } catch (Exception unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_dq implements ActLifecycle.jad_an {
        public jad_dq() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_an() {
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_bo() {
            DynamicRenderView dynamicRenderView = DynamicRenderView.this;
            int i10 = DynamicRenderView.jad_pa;
            dynamicRenderView.jad_dq();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class jad_er {
        public String jad_an;
        public float jad_bo;
        public float jad_cp;
        public List<String> jad_dq = new ArrayList();
        public List<String> jad_er = new ArrayList();
        public List<String> jad_fs = new ArrayList();
        public int jad_hu;
        public int jad_iv;
        public IDynamicRenderCallback jad_jt;
        public String jad_jw;
        public float jad_kx;
        public float jad_ly;
        public int jad_mz;
    }

    public DynamicRenderView(Context context, jad_er jad_erVar) {
        super(context);
        this.jad_an = 1.0d;
        this.jad_bo = 1.0d;
        this.jad_cp = 1.0d;
        this.jad_fs = true;
        this.jad_jt = 0;
        this.jad_tg = new ArrayList();
        this.jad_uh = new ArrayList();
        this.jad_vi = new ArrayList();
        this.jad_wj = new HashMap();
        this.jad_yl = new JSONObject();
        this.jad_zm = new HashMap();
        this.jad_gr = true;
        this.jad_hs = null;
        this.jad_it = 100;
        this.jad_ju = 0.0f;
        this.jad_kv = 1.0f;
        this.jad_lw = 0.0f;
        this.jad_mx = 0.0f;
        this.jad_oz = new jad_an();
        jad_bo();
        jad_an();
        this.jad_fq = new CountDownLatch(1);
        jad_an(jad_erVar, context);
        jad_an(context);
    }

    private void setCanvasWH(JSONObject jSONObject) {
        this.jad_dq = jSONObject.getInt(IAdInterListener.AdReqParam.WIDTH);
        this.jad_er = jSONObject.getInt("h");
    }

    private void setFixedLayerPosition(JSONArray jSONArray) {
        Double valueOf;
        Double valueOf2;
        Double valueOf3 = Double.valueOf(jSONArray.getDouble(0));
        Double valueOf4 = Double.valueOf(jSONArray.getDouble(1));
        if (valueOf3.doubleValue() > this.jad_dq / 2.0d) {
            double doubleValue = valueOf3.doubleValue();
            double d10 = this.jad_an;
            valueOf = Double.valueOf((doubleValue * d10) - ((d10 - 1.0d) * this.jad_dq));
        } else {
            valueOf = Double.valueOf(valueOf3.doubleValue() * this.jad_an);
        }
        if (valueOf4.doubleValue() > this.jad_er / 2.0d) {
            double doubleValue2 = valueOf4.doubleValue();
            double d11 = this.jad_bo;
            valueOf2 = Double.valueOf((doubleValue2 * d11) - ((d11 - 1.0d) * this.jad_er));
        } else {
            valueOf2 = Double.valueOf(valueOf4.doubleValue() * this.jad_bo);
        }
        jSONArray.put(0, valueOf);
        jSONArray.put(1, valueOf2);
    }

    private void setTransformParams(JSONObject jSONObject) {
        setCanvasWH(jSONObject);
        int i10 = this.jad_pc;
        double d10 = this.jad_dq;
        if (d10 > ShadowDrawableWrapper.COS_45 && i10 > 0) {
            double d11 = this.jad_jw;
            if (d11 > ShadowDrawableWrapper.COS_45) {
                double d12 = d10 / i10;
                this.jad_an = (d10 / d12) / d11;
                this.jad_bo = (this.jad_er / d12) / this.jad_kx;
            }
        }
        double d13 = this.jad_kx;
        if (d13 <= ShadowDrawableWrapper.COS_45 || d10 <= ShadowDrawableWrapper.COS_45) {
            return;
        }
        double d14 = this.jad_er;
        if (d14 <= ShadowDrawableWrapper.COS_45) {
            return;
        }
        this.jad_cp = (this.jad_jw / d13) / (d10 / d14);
    }

    public int getAdAnimationType() {
        return this.jad_jt;
    }

    public int getAdClickAreaValue() {
        return this.jad_it;
    }

    public Exception getLoadImagesException() {
        return this.jad_hs;
    }

    public LottieAnimationView getLottieView() {
        return this.jad_sf;
    }

    public final void jad_an() {
        com.jd.ad.sdk.jad_na.jad_an jad_an2 = com.jd.ad.sdk.jad_pc.jad_an.jad_an();
        if (jad_an2 == null) {
            return;
        }
        this.jad_ju = jad_an2.jad_cp;
        float f10 = jad_an2.jad_dq;
        this.jad_kv = f10;
        this.jad_lw = jad_an2.jad_er;
        this.jad_mx = jad_an2.jad_fs;
        if (f10 <= 0.0f) {
            this.jad_kv = 1.0f;
        }
    }

    public final void jad_bo() {
        jad_dq jad_dqVar = new jad_dq();
        this.jad_ny = jad_dqVar;
        ActLifecycle.jad_bo.add(jad_dqVar);
    }

    public final void jad_cp() {
        if (this.jad_qd == CommonConstants.AdTriggerSourceType.CLICK.ordinal()) {
            if (this.jad_re == CommonConstants.ClickAreaType.FULL_SCREEN_CLICK.getTemplateId()) {
                this.jad_jt = 1;
                return;
            } else {
                this.jad_jt = 0;
                return;
            }
        }
        if (this.jad_qd == CommonConstants.AdTriggerSourceType.SHAKE.ordinal()) {
            this.jad_jt = 2;
        } else if (this.jad_qd == CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal()) {
            this.jad_jt = 3;
        }
    }

    public final void jad_dq() {
        ShakeListener shakeListener = this.jad_hu;
        if (shakeListener != null) {
            shakeListener.unregister();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LottieAnimationView lottieAnimationView = this.jad_sf;
        if (lottieAnimationView != null) {
            lottieAnimationView.destroyDrawingCache();
            this.jad_sf = null;
        }
        jad_dq();
        jad_dq jad_dqVar = this.jad_ny;
        CopyOnWriteArrayList<ActLifecycle.jad_an> copyOnWriteArrayList = ActLifecycle.jad_bo;
        if (jad_dqVar != null) {
            copyOnWriteArrayList.remove(jad_dqVar);
        }
        this.jad_ny = null;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        this.jad_fs = z10;
        if (!z10) {
            removeCallbacks(this.jad_oz);
        } else if (this.jad_do != null && this.jad_ep > 0) {
            post(this.jad_oz);
        }
        if (this.jad_fs) {
            ShakeListener shakeListener = this.jad_hu;
            if (shakeListener != null) {
                shakeListener.register();
                return;
            }
            return;
        }
        jad_dq();
    }

    public void play() {
        LottieAnimationView lottieAnimationView = this.jad_sf;
        if (lottieAnimationView != null) {
            lottieAnimationView.jad_dq();
        } else {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_PLAY_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(new String[0]));
        }
    }

    public void startCount(@NonNull IDynamicCountdownListener iDynamicCountdownListener) {
        if (iDynamicCountdownListener == null) {
            return;
        }
        this.jad_do = iDynamicCountdownListener;
        int i10 = this.jad_ep;
        if (i10 < 1 || i10 > 30) {
            this.jad_ep = 5;
        }
        Runnable runnable = this.jad_oz;
        if (runnable != null) {
            post(runnable);
        }
    }

    public static boolean jad_an(DynamicRenderView dynamicRenderView, Context context, int i10, int i11, int i12, int i13, int i14) {
        dynamicRenderView.getClass();
        int i15 = i13 - i11;
        float abs = Math.abs(i12 - i10);
        float f10 = i14;
        return abs > ScreenUtils.dip2px(context, f10) || ((float) Math.abs(i15)) > ScreenUtils.dip2px(context, f10);
    }

    public void jad_an(String str, com.jd.ad.sdk.jad_hu.jad_an jad_anVar) {
        try {
            JSONObject optJSONObject = this.jad_yl.optJSONObject(str);
            if (optJSONObject == null) {
                Logger.d("动态化渲染不阻断问题：" + str + "不存在");
                return;
            }
            int i10 = optJSONObject.getInt(Attributes.Style.INDEX);
            Rect rect = (Rect) optJSONObject.get("rect");
            jad_anVar.jad_cp = i10;
            jad_anVar.jad_bo = rect;
            this.jad_wj.put(str, jad_anVar);
            if (str.equals(this.jad_xk)) {
                int width = rect.width();
                int height = rect.height();
                int i11 = (int) (this.jad_jw * this.jad_kx);
                if (i11 > 0) {
                    this.jad_it = ((width * height) * 100) / i11;
                }
            }
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_ADD_EVENT_ERROR;
            sb2.append(jad_anVar2.jad_an);
            sb2.append("-");
            sb2.append(jad_anVar2.jad_an(new String[0]));
            throw new Exception(sb2.toString(), e2);
        }
    }

    public void jad_an(Context context, JSONObject jSONObject, String str) {
        try {
            Map<String, jad_na> jad_an2 = jad_an(jSONObject, str);
            if (jad_an2 != null && !jad_an2.isEmpty()) {
                Iterator<String> iterator2 = jad_an2.h().iterator2();
                while (iterator2.hasNext()) {
                    jad_na jad_naVar = jad_an2.get(iterator2.next());
                    if (jad_naVar == null) {
                        IDynamicRenderCallback iDynamicRenderCallback = this.jad_cn;
                        if (iDynamicRenderCallback != null) {
                            JADError jADError = JADError.RENDER_IMAGE_LOAD_FAIL_ERROR;
                            iDynamicRenderCallback.onDynamicRenderFailed(jADError.getCode(), jADError.getMessage(new String[0]));
                            return;
                        }
                        return;
                    }
                    com.jd.ad.sdk.jad_ep.jad_cp.jad_bo(context).jad_er().jad_an(jad_ly.jad_bo).jad_an(jad_naVar.jad_dq).jad_an((jad_iv) new jad_bo(jad_naVar, jad_an2));
                }
                return;
            }
            this.jad_fq.await();
            IDynamicRenderCallback iDynamicRenderCallback2 = this.jad_cn;
            if (iDynamicRenderCallback2 == null || !this.jad_gr) {
                return;
            }
            iDynamicRenderCallback2.onDynamicRenderSuccess(this);
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOAD_IMAGES_ERROR;
            sb2.append(jad_anVar.jad_an);
            sb2.append("-");
            sb2.append(jad_anVar.jad_an(new String[0]));
            this.jad_hs = new Exception(sb2.toString(), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void jad_an(Context context) {
        LottieAnimationView lottieAnimationView;
        try {
            View inflate = LayoutInflater.from(context).inflate(R.layout.jad_dynamic_render_layout, (ViewGroup) null);
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) inflate.findViewById(R.id.animation_view);
            this.jad_sf = lottieAnimationView2;
            lottieAnimationView2.setCacheComposition(false);
            addView(inflate);
            try {
                String jad_an2 = jad_an(jad_an(context, this.jad_iv, this.jad_ly, this.jad_ob, this));
                Map<String, jad_uh<jad_jt>> map = com.jd.ad.sdk.jad_js.jad_hu.jad_an;
                com.jd.ad.sdk.jad_zi.jad_iv jad_ivVar = new com.jd.ad.sdk.jad_zi.jad_iv(com.jd.ad.sdk.jad_zi.jad_er.jad_an(new ByteArrayInputStream(jad_an2.getBytes())));
                String[] strArr = com.jd.ad.sdk.jad_ud.jad_cp.jad_er;
                jad_sf<jad_jt> jad_an3 = com.jd.ad.sdk.jad_js.jad_hu.jad_an((com.jd.ad.sdk.jad_ud.jad_cp) new com.jd.ad.sdk.jad_ud.jad_fs(jad_ivVar), (String) null, true);
                Throwable th = jad_an3.jad_bo;
                if (th == null) {
                    jad_jt jad_jtVar = jad_an3.jad_an;
                    if (jad_jtVar != null) {
                        this.jad_sf.setComposition(jad_jtVar);
                        LottieAnimationView lottieAnimationView3 = this.jad_sf;
                        if (lottieAnimationView3 != null) {
                            lottieAnimationView3.setOnTouchListener(new com.jd.ad.sdk.jad_hu.jad_iv(this, context));
                            this.jad_sf.setOnClickListener(new com.jd.ad.sdk.bl.dynamicrender.jad_bo(this, context));
                        }
                        LottieAnimationView lottieAnimationView4 = this.jad_sf;
                        if (lottieAnimationView4 != null) {
                            try {
                                lottieAnimationView4.setFontAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_er());
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        LottieAnimationView lottieAnimationView5 = this.jad_sf;
                        Map<String, Bitmap> map2 = this.jad_zm;
                        if (lottieAnimationView5 != null && context != null) {
                            lottieAnimationView5.setImageAssetDelegate(new com.jd.ad.sdk.jad_hu.jad_jt(map2, context));
                        }
                        LottieAnimationView lottieAnimationView6 = this.jad_sf;
                        if (lottieAnimationView6 != null && context != null) {
                            lottieAnimationView6.jad_er.jad_cp.jad_bo.add(new com.jd.ad.sdk.bl.dynamicrender.jad_an(this, context));
                        }
                        double d10 = this.jad_kx;
                        if (d10 > ShadowDrawableWrapper.COS_45) {
                            double d11 = this.jad_er;
                            if (d11 > ShadowDrawableWrapper.COS_45 && this.jad_jw / d10 != this.jad_dq / d11 && (lottieAnimationView = this.jad_sf) != null) {
                                lottieAnimationView.setScaleType(ImageView.ScaleType.FIT_XY);
                            }
                        }
                        ViewGroup.LayoutParams layoutParams = getLayoutParams();
                        int i10 = (int) this.jad_jw;
                        int i11 = (int) this.jad_kx;
                        if (layoutParams == null) {
                            layoutParams = new FrameLayout.LayoutParams(i10, i11);
                        } else {
                            layoutParams.height = i11;
                            layoutParams.width = i10;
                        }
                        setLayoutParams(layoutParams);
                        return;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR;
                    sb2.append(jad_anVar.jad_an);
                    sb2.append("-");
                    sb2.append(jad_anVar.jad_an(new String[0]));
                    throw new Exception(sb2.toString());
                }
                StringBuilder sb3 = new StringBuilder();
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar2 = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_LOTTIE_PARSE_ERROR;
                sb3.append(jad_anVar2.jad_an);
                sb3.append("-");
                sb3.append(jad_anVar2.jad_an(new String[0]));
                throw new Exception(sb3.toString(), th);
            } catch (Exception e10) {
                StringBuilder sb4 = new StringBuilder();
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar3 = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_VAR_REPLACE_ERROR;
                sb4.append(jad_anVar3.jad_an);
                sb4.append("-");
                sb4.append(jad_anVar3.jad_an(new String[0]));
                throw new Exception(sb4.toString(), e10);
            }
        } finally {
        }
    }

    public String jad_an(Context context, String str, String str2, int i10, DynamicRenderView dynamicRenderView) {
        JSONObject jSONObject = new JSONObject(str);
        WorkExecutor.execute(new jad_cp(this, dynamicRenderView, context, jSONObject, str2));
        int optInt = jSONObject.optInt("fr");
        if (i10 > 5) {
            JSONArray jSONArray = jSONObject.getJSONArray("layers");
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i11);
                String string = jSONObject2.getString("nm");
                int i12 = (i10 - 5) * optInt;
                if (string.equals("sdkStaticSkipButton")) {
                    jSONObject2.put("op", i12);
                }
                if (string.equals("sdkSkipButton")) {
                    jSONObject2.put("ip", i12);
                }
            }
            str = jSONObject.toString();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("countDownTemplate");
        if (optJSONObject != null) {
            String jSONObject3 = optJSONObject.toString();
            StringBuilder sb2 = new StringBuilder();
            int i13 = i10 <= 5 ? i10 : 5;
            for (int i14 = i13; i14 > 0; i14--) {
                StringBuilder jad_an2 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("");
                int i15 = (i10 - i14) * optInt;
                jad_an2.append(i15);
                String replace = jSONObject3.replace("${startTime}", jad_an2.toString());
                StringBuilder jad_an3 = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("");
                jad_an3.append(i15 + optInt);
                String replaceAll = replace.replace("${endTime}", jad_an3.toString()).replaceAll("\\$\\{count\\}", "" + i14);
                if (i14 != i13) {
                    sb2.append(",");
                }
                sb2.append(replaceAll);
            }
            str = str.replace("\"${countDown}\"", sb2.toString());
        }
        int i16 = i10 * optInt;
        return str.replace("${materialImage}", str2).replace("${totalTime}", "" + i16);
    }

    public final Map<String, jad_na> jad_an(JSONObject jSONObject, String str) {
        int length;
        JSONArray jSONArray = jSONObject.getJSONArray(QuickCardField.ASSETS);
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i10);
            String optString = optJSONObject.optString(t.f36217b);
            String optString2 = optJSONObject.optString(t.f36224i);
            String optString3 = optJSONObject.optString("id");
            int optInt = optJSONObject.optInt(IAdInterListener.AdReqParam.WIDTH);
            int optInt2 = optJSONObject.optInt("h");
            if (!TextUtils.isEmpty(optString)) {
                hashMap.put(optString3, new jad_na(optInt, optInt2, optString3, optString.equals("${materialImage}") ? str : optString, optString2));
            }
        }
        return hashMap;
    }

    public static String jad_an(DynamicRenderView dynamicRenderView, int i10, int i11) {
        Iterator<String> iterator2 = dynamicRenderView.jad_wj.h().iterator2();
        com.jd.ad.sdk.jad_hu.jad_an jad_anVar = null;
        while (iterator2.hasNext()) {
            com.jd.ad.sdk.jad_hu.jad_an jad_anVar2 = dynamicRenderView.jad_wj.get(iterator2.next());
            if (jad_anVar2 != null && jad_anVar2.jad_bo.contains(i10, i11)) {
                if (jad_anVar != null) {
                    if (jad_anVar.jad_cp > jad_anVar2.jad_cp) {
                    }
                }
                jad_anVar = jad_anVar2;
            }
        }
        return jad_anVar == null ? "" : jad_anVar.jad_an;
    }

    public final String jad_an(String str) {
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i10;
        String str5 = "a";
        String str6 = "layers";
        String str7 = "k";
        int i11 = 0;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            jad_cp();
            setTransformParams(jSONObject2);
            JSONArray jSONArray3 = jSONObject2.getJSONArray("layers");
            JSONArray jSONArray4 = new JSONArray();
            int i12 = 0;
            while (i12 < jSONArray3.length()) {
                JSONObject jSONObject3 = jSONArray3.getJSONObject(i12);
                String str8 = (String) jSONObject3.get("nm");
                if (this.jad_vi.contains(str8)) {
                    str2 = str5;
                    str3 = str6;
                    str4 = str7;
                    jSONObject = jSONObject2;
                    jSONArray = jSONArray3;
                    jSONArray2 = jSONArray4;
                } else {
                    JSONObject jSONObject4 = jSONObject3.getJSONObject(MediationConstant.ADN_KS);
                    JSONArray jSONArray5 = jSONObject4.getJSONObject(t.f36217b).getJSONArray(str7);
                    JSONArray jSONArray6 = jSONObject4.getJSONObject(t.f36222g).getJSONArray(str7);
                    JSONArray jSONArray7 = jSONObject4.getJSONObject(str5).getJSONArray(str7);
                    double d10 = jSONArray6.getDouble(i11);
                    double d11 = jSONArray6.getDouble(1);
                    jSONObject = jSONObject2;
                    if (this.jad_tg.contains(str8)) {
                        jSONArray = jSONArray3;
                        jSONArray6.put(0, this.jad_an * d10);
                        jSONArray6.put(1, this.jad_bo * d11);
                        setFixedLayerPosition(jSONArray5);
                    } else {
                        jSONArray = jSONArray3;
                    }
                    if (this.jad_uh.contains(str8)) {
                        jSONArray6.put(1, this.jad_cp * d11);
                        JSONArray jSONArray8 = jSONObject4.getJSONObject(str5).getJSONArray(str7);
                        str3 = str6;
                        str4 = str7;
                        str2 = str5;
                        jSONArray5.put(1, Double.valueOf(Double.valueOf(jSONArray5.getDouble(1)).doubleValue() - (jSONArray8.getDouble(1) * (this.jad_cp - 1.0d))));
                    } else {
                        str2 = str5;
                        str3 = str6;
                        str4 = str7;
                    }
                    if ("sdkMaterialImage".equals(str8)) {
                        double d12 = this.jad_mz;
                        if (d12 != ShadowDrawableWrapper.COS_45) {
                            jSONArray2 = jSONArray4;
                            double d13 = this.jad_jw;
                            if (d13 != ShadowDrawableWrapper.COS_45) {
                                double d14 = ((this.jad_kx / d13) / (this.jad_na / d12)) * d10;
                                double d15 = 100.0d;
                                if (d14 < 100.0d) {
                                    i10 = 0;
                                    d15 = (100.0d / d14) * 100.0d;
                                    d14 = 100.0d;
                                } else {
                                    i10 = 0;
                                }
                                jSONArray6.put(i10, d14);
                                jSONArray6.put(1, d15);
                            }
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put(Attributes.Style.INDEX, i12);
                            jSONObject5.put("rect", jad_an(jSONArray5, jSONArray7, jSONObject3, jSONArray6));
                            this.jad_yl.put(str8, jSONObject5);
                            jSONArray2.put(jSONObject3);
                        }
                    }
                    jSONArray2 = jSONArray4;
                    JSONObject jSONObject52 = new JSONObject();
                    jSONObject52.put(Attributes.Style.INDEX, i12);
                    jSONObject52.put("rect", jad_an(jSONArray5, jSONArray7, jSONObject3, jSONArray6));
                    this.jad_yl.put(str8, jSONObject52);
                    jSONArray2.put(jSONObject3);
                }
                i12++;
                jSONArray4 = jSONArray2;
                str6 = str3;
                str7 = str4;
                str5 = str2;
                jSONObject2 = jSONObject;
                jSONArray3 = jSONArray;
                i11 = 0;
            }
            JSONObject jSONObject6 = jSONObject2;
            jSONObject6.put(str6, jSONArray4);
            return jSONObject6.toString();
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.RENDER_DYNAMIC_VIEW_INIT_JSON_PARSE_ERROR;
            sb2.append(jad_anVar.jad_an);
            sb2.append("-");
            sb2.append(jad_anVar.jad_an(new String[0]));
            throw new Exception(sb2.toString(), e2);
        }
    }

    public final Rect jad_an(JSONArray jSONArray, JSONArray jSONArray2, JSONObject jSONObject, JSONArray jSONArray3) {
        Double valueOf;
        Double valueOf2;
        double d10 = this.jad_dq;
        double d11 = d10 > ShadowDrawableWrapper.COS_45 ? this.jad_jw / d10 : 1.0d;
        double d12 = this.jad_er;
        double d13 = d12 > ShadowDrawableWrapper.COS_45 ? this.jad_kx / d12 : 1.0d;
        if (jSONObject.getInt(a.f4666g) != 1) {
            valueOf = Double.valueOf(jSONObject.getDouble(IAdInterListener.AdReqParam.WIDTH));
            valueOf2 = Double.valueOf(jSONObject.getDouble("h"));
        } else {
            valueOf = Double.valueOf(jSONObject.getDouble("sw"));
            valueOf2 = Double.valueOf(jSONObject.getDouble("sh"));
        }
        double d14 = jSONArray3.getDouble(0) / 100.0d;
        double d15 = jSONArray3.getDouble(1) / 100.0d;
        int i10 = (int) (((jSONArray.getDouble(0) - jSONArray2.getDouble(0)) - ((d14 - 1.0d) * (valueOf.doubleValue() / 2.0d))) * d11);
        int i11 = (int) (((jSONArray.getDouble(1) - jSONArray2.getDouble(1)) - ((d15 - 1.0d) * (valueOf2.doubleValue() / 2.0d))) * d13);
        return new Rect(i10, i11, ((int) (valueOf.doubleValue() * d14 * d11)) + i10, ((int) (valueOf2.doubleValue() * d15 * d13)) + i11);
    }

    public final void jad_an(jad_er jad_erVar, Context context) {
        this.jad_iv = jad_erVar.jad_an;
        this.jad_jw = jad_erVar.jad_bo;
        this.jad_kx = jad_erVar.jad_cp;
        this.jad_ly = jad_erVar.jad_jw;
        this.jad_mz = jad_erVar.jad_kx;
        this.jad_na = jad_erVar.jad_ly;
        int i10 = jad_erVar.jad_mz;
        this.jad_ob = i10;
        this.jad_ep = i10;
        this.jad_tg = jad_erVar.jad_dq;
        this.jad_uh = jad_erVar.jad_er;
        this.jad_vi = jad_erVar.jad_fs;
        this.jad_cn = jad_erVar.jad_jt;
        this.jad_pc = ScreenUtils.getPhoneWidth(context);
        this.jad_qd = jad_erVar.jad_hu;
        this.jad_re = jad_erVar.jad_iv;
    }
}
