package com.jd.ad.sdk.jad_n_an;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.jd.ad.sdk.bl.dynamicrender.ShakeListener;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.baseinfo.JADScreenInfoUtils;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ScreenUtils;
import com.jd.ad.sdk.jad_n_an.jad_n_an;
import com.jd.ad.sdk.logger.Logger;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeInteractionListener;
import com.jd.ad.sdk.nativead.JADNativeSplashInteractionListener;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: JADNativeViewController.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_n_dq {
    public JADNative jad_n_an;
    public JADNativeInteractionListener jad_n_bo;
    public ViewGroup jad_n_fs;
    public int jad_n_hu;
    public int jad_n_iv;
    public List<View> jad_n_jt;
    public ShakeListener jad_n_kx;
    public int jad_n_mz;
    public jad_n_jw jad_n_na;
    public boolean jad_n_cp = false;
    public int jad_n_dq = 0;
    public int jad_n_er = 100;
    public int jad_n_jw = CommonConstants.AdTriggerSourceType.CLICK.ordinal();
    public final Application.ActivityLifecycleCallbacks jad_n_ob = new jad_n_iv();
    public Application jad_n_ly = JADMediator.getInstance().getFoundationService().getApplication();

    /* compiled from: JADNativeViewController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_n_an extends ShakeListener {
        public final /* synthetic */ float jad_n_an;
        public final /* synthetic */ float jad_n_bo;
        public final /* synthetic */ float jad_n_cp;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public jad_n_an(Context context, float f10, float f11, float f12, boolean z10, float f13, float f14, float f15) {
            super(context, f10, f11, f12, z10);
            this.jad_n_an = f13;
            this.jad_n_bo = f14;
            this.jad_n_cp = f15;
        }

        @Override // com.jd.ad.sdk.bl.dynamicrender.ShakeListener
        public void onShake() {
            JADNative jADNative = jad_n_dq.this.jad_n_an;
            if (jADNative == null || jADNative.getSlot() == null) {
                return;
            }
            if (jad_n_dq.this.jad_n_an.getSlot().getAdType() == 1) {
                jad_n_dq jad_n_dqVar = jad_n_dq.this;
                jad_n_dqVar.jad_n_jw = jad_n_dq.jad_n_an(jad_n_dqVar, this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
                jad_n_dq jad_n_dqVar2 = jad_n_dq.this;
                jad_n_dq.jad_n_an(jad_n_dqVar2, jad_n_dqVar2.jad_n_fs);
                return;
            }
            jad_n_dq jad_n_dqVar3 = jad_n_dq.this;
            ViewGroup viewGroup = jad_n_dqVar3.jad_n_fs;
            if (viewGroup == null || !jad_n_dq.jad_n_bo(jad_n_dqVar3, viewGroup)) {
                return;
            }
            jad_n_dq jad_n_dqVar4 = jad_n_dq.this;
            if (jad_n_dq.jad_n_an(jad_n_dqVar4, jad_n_dqVar4.jad_n_fs.getContext(), jad_n_dq.this.jad_n_an.getInstanceId())) {
                jad_n_dq jad_n_dqVar5 = jad_n_dq.this;
                jad_n_dqVar5.jad_n_jw = jad_n_dq.jad_n_an(jad_n_dqVar5, this.jad_n_an, this.jad_n_bo, this.jad_n_cp);
                jad_n_dq jad_n_dqVar6 = jad_n_dq.this;
                jad_n_dq.jad_n_an(jad_n_dqVar6, jad_n_dqVar6.jad_n_fs);
            }
        }
    }

    /* compiled from: JADNativeViewController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_n_bo implements View.OnTouchListener {
        public final /* synthetic */ float[] jad_n_an;
        public final /* synthetic */ float[] jad_n_bo;
        public final /* synthetic */ float jad_n_cp;

        public jad_n_bo(float[] fArr, float[] fArr2, float f10) {
            this.jad_n_an = fArr;
            this.jad_n_bo = fArr2;
            this.jad_n_cp = f10;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.jad_n_an[0] = motionEvent.getX();
                this.jad_n_an[1] = motionEvent.getY();
                return true;
            }
            if (action == 1) {
                this.jad_n_bo[0] = motionEvent.getX();
                this.jad_n_bo[1] = motionEvent.getY();
                if (Math.abs(this.jad_n_bo[1] - this.jad_n_an[1]) > ScreenUtils.dip2px(jad_n_dq.this.jad_n_fs.getContext(), this.jad_n_cp) || Math.abs(this.jad_n_bo[0] - this.jad_n_an[0]) > ScreenUtils.dip2px(jad_n_dq.this.jad_n_fs.getContext(), this.jad_n_cp)) {
                    jad_n_dq.this.jad_n_jw = CommonConstants.AdTriggerSourceType.SLIDE_UP.ordinal();
                    jad_n_dq jad_n_dqVar = jad_n_dq.this;
                    jad_n_dq.jad_n_an(jad_n_dqVar, jad_n_dqVar.jad_n_fs);
                }
            }
            return false;
        }
    }

    /* compiled from: JADNativeViewController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_n_cp implements JADExposureListener {
        public final /* synthetic */ ViewGroup jad_n_an;

        public jad_n_cp(ViewGroup viewGroup) {
            this.jad_n_an = viewGroup;
        }

        @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
        public void onDelayExposure(long j10, String str, int i10) {
            jad_n_dq.jad_n_an(jad_n_dq.this, true, str, i10);
        }

        @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
        public void onExposure(String str) {
            jad_n_dq.jad_n_an(jad_n_dq.this, false, str, CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
        }

        @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
        public void onFinishExposure() {
            jad_n_dq.jad_n_an(jad_n_dq.this, (View) this.jad_n_an, false);
        }

        @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
        public void onPreExposure(String str) {
            jad_n_dq.this.jad_n_cp = false;
            jad_n_dq.jad_n_an(jad_n_dq.this, false, str, CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
        }
    }

    /* compiled from: JADNativeViewController.java */
    /* renamed from: com.jd.ad.sdk.jad_n_an.jad_n_dq$jad_n_dq, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class ViewOnTouchListenerC0377jad_n_dq implements View.OnTouchListener {
        public ViewOnTouchListenerC0377jad_n_dq() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (jad_n_dq.this.jad_n_an == null) {
                return false;
            }
            JADMediator.getInstance().getTouchService().onViewTouch(view, motionEvent, jad_n_dq.this.jad_n_an.getInstanceId());
            return false;
        }
    }

    /* compiled from: JADNativeViewController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_n_er implements View.OnClickListener {
        public final /* synthetic */ View jad_n_an;
        public final /* synthetic */ boolean jad_n_bo;

        public jad_n_er(View view, boolean z10) {
            this.jad_n_an = view;
            this.jad_n_bo = z10;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            jad_n_dq.jad_n_an(jad_n_dq.this, this.jad_n_an);
            if (this.jad_n_bo) {
                jad_n_dq.jad_n_an(jad_n_dq.this, this.jad_n_an, false);
            }
        }
    }

    /* compiled from: JADNativeViewController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_n_fs implements jad_n_an.jad_n_cp {
        public jad_n_fs() {
        }
    }

    /* compiled from: JADNativeViewController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_n_hu implements View.OnClickListener {
        public jad_n_hu() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            jad_n_dq.jad_n_an(jad_n_dq.this, view, true);
        }
    }

    /* compiled from: JADNativeViewController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_n_iv implements Application.ActivityLifecycleCallbacks {
        public jad_n_iv() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NonNull Activity activity) {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
            int hashCode = activity.hashCode();
            jad_n_dq jad_n_dqVar = jad_n_dq.this;
            if (hashCode == jad_n_dqVar.jad_n_mz) {
                jad_n_dq.jad_n_an(jad_n_dqVar);
                jad_n_dq jad_n_dqVar2 = jad_n_dq.this;
                Application application = jad_n_dqVar2.jad_n_ly;
                if (application != null && (activityLifecycleCallbacks = jad_n_dqVar2.jad_n_ob) != null) {
                    application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                }
                jad_n_dq.this.jad_n_an();
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NonNull Activity activity) {
            int hashCode = activity.hashCode();
            jad_n_dq jad_n_dqVar = jad_n_dq.this;
            if (hashCode == jad_n_dqVar.jad_n_mz) {
                jad_n_dq.jad_n_an(jad_n_dqVar);
                jad_n_dq.jad_n_an(jad_n_dq.this, false);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NonNull Activity activity) {
            int hashCode = activity.hashCode();
            jad_n_dq jad_n_dqVar = jad_n_dq.this;
            if (hashCode == jad_n_dqVar.jad_n_mz) {
                jad_n_dqVar.jad_n_iv();
                jad_n_dq.jad_n_an(jad_n_dq.this, true);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NonNull Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NonNull Activity activity) {
            int hashCode = activity.hashCode();
            jad_n_dq jad_n_dqVar = jad_n_dq.this;
            if (hashCode == jad_n_dqVar.jad_n_mz) {
                jad_n_dq.jad_n_an(jad_n_dqVar);
                jad_n_dq.jad_n_an(jad_n_dq.this, false);
            }
        }
    }

    /* compiled from: JADNativeViewController.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_n_jt implements View.OnClickListener {
        public final /* synthetic */ com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_an;

        public jad_n_jt(com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar) {
            this.jad_n_an = jad_n_anVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            jad_n_dq.jad_n_an(jad_n_dq.this, view, true);
            this.jad_n_an.jad_n_bo();
        }
    }

    /* compiled from: JADNativeViewController.java */
    @RequiresApi(api = 18)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class jad_n_jw implements ViewTreeObserver.OnWindowFocusChangeListener {
        public jad_n_jw() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z10) {
            jad_n_dq.jad_n_an(jad_n_dq.this, z10);
        }
    }

    public jad_n_dq(@NonNull JADNative jADNative, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @NonNull JADNativeInteractionListener jADNativeInteractionListener) {
        this.jad_n_hu = 0;
        this.jad_n_iv = 0;
        this.jad_n_mz = jADNative.getActivity() != null ? jADNative.getActivity().hashCode() : -1;
        this.jad_n_an = jADNative;
        this.jad_n_fs = viewGroup;
        this.jad_n_jt = list;
        this.jad_n_bo = jADNativeInteractionListener;
        if (jADNativeInteractionListener != null) {
            jad_n_an((View) viewGroup);
            jad_n_an(viewGroup);
            JADNative jADNative2 = this.jad_n_an;
            if (jADNative2 == null || jADNative2.getSlot() == null) {
                return;
            }
            jad_n_an(list, this.jad_n_an.getSlot().getAdType() == 4);
            if (this.jad_n_an.getSlot().getAdType() == 1) {
                jad_n_bo(list2);
            } else {
                jad_n_an(list2);
            }
            if (jADNative.getSlot().getEventInteractionType() == 1) {
                jad_n_jt();
            }
            if (jADNative.getSlot().getEventInteractionType() == 2) {
                jad_n_hu();
            }
        }
        this.jad_n_hu = JADMediator.getInstance().getInitService().getDs(jad_n_fs());
        this.jad_n_iv = JADMediator.getInstance().getInitService().getR(jad_n_fs());
    }

    public static int jad_n_an(jad_n_dq jad_n_dqVar, float f10, float f11, float f12) {
        jad_n_dqVar.getClass();
        CommonConstants.AdTriggerSourceType adTriggerSourceType = CommonConstants.AdTriggerSourceType.SHAKE;
        int ordinal = adTriggerSourceType.ordinal();
        if (f12 > 0.0f) {
            if (f10 > 0.0f && f11 > 0.0f) {
                return CommonConstants.AdTriggerSourceType.SHAKE_ALL.ordinal();
            }
            if (f10 > 0.0f) {
                return CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_TIME.ordinal();
            }
            return f11 > 0.0f ? CommonConstants.AdTriggerSourceType.SHAKE_ANGLE_TIME.ordinal() : ordinal;
        }
        if (f10 > 0.0f && f11 > 0.0f) {
            return CommonConstants.AdTriggerSourceType.SHAKE_ACCELERATION_ANGLE.ordinal();
        }
        if (f10 > 0.0f) {
            return adTriggerSourceType.ordinal();
        }
        return f11 > 0.0f ? CommonConstants.AdTriggerSourceType.SHAKE_ANGLE.ordinal() : ordinal;
    }

    public static boolean jad_n_bo(jad_n_dq jad_n_dqVar, View view) {
        jad_n_dqVar.getClass();
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect) || rect.top <= 0) {
            return false;
        }
        int width = rect.width() * rect.height();
        int height = view.getHeight() * view.getWidth();
        return ((width == 0 || height == 0) ? 0 : (int) (new BigDecimal(String.valueOf(width)).divide(new BigDecimal(String.valueOf(height)), 2, 4).floatValue() * 100.0f)) == 100;
    }

    public final int jad_n_cp() {
        if (jad_n_dq() != null) {
            return jad_n_dq().getEventInteractionType();
        }
        return CommonConstants.AdTriggerSourceType.CLICK.ordinal();
    }

    public final JADSlot jad_n_dq() {
        JADNative jADNative = this.jad_n_an;
        if (jADNative != null) {
            return jADNative.getSlot();
        }
        return null;
    }

    public final String jad_n_er() {
        JADNative jADNative = this.jad_n_an;
        return (jADNative == null || jADNative.getSlot() == null) ? "" : this.jad_n_an.getSlot().getRequestId();
    }

    public final String jad_n_fs() {
        return jad_n_dq() != null ? jad_n_dq().getSlotID() : "";
    }

    public final void jad_n_hu() {
        if (this.jad_n_fs == null) {
            return;
        }
        float[] fArr = {0.0f, 0.0f};
        float[] fArr2 = {0.0f, 0.0f};
        float swipeLength = JADMediator.getInstance().getInitService().getSwipeLength();
        if (swipeLength <= 0.0f) {
            swipeLength = 1.0f;
        }
        this.jad_n_fs.setOnTouchListener(new jad_n_bo(fArr, fArr2, swipeLength));
    }

    public final void jad_n_iv() {
        ViewGroup viewGroup = this.jad_n_fs;
        if (viewGroup == null) {
            return;
        }
        if (this.jad_n_na == null) {
            this.jad_n_na = new jad_n_jw();
        }
        viewGroup.getViewTreeObserver().addOnWindowFocusChangeListener(this.jad_n_na);
    }

    public final void jad_n_jt() {
        JADNative jADNative;
        float feedShakeSensitivityValue;
        float feedShakeAngleValue;
        float feedShakeTimeValue;
        boolean z10;
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        if (this.jad_n_fs == null || (jADNative = this.jad_n_an) == null || jADNative.getSlot() == null) {
            return;
        }
        if (this.jad_n_an.getSlot().getAdType() == 1) {
            feedShakeSensitivityValue = JADMediator.getInstance().getInitService().getShakeSensitivityValue();
            feedShakeAngleValue = JADMediator.getInstance().getInitService().getShakeAngleValue();
            feedShakeTimeValue = JADMediator.getInstance().getInitService().getShakeTimeValue();
            z10 = true;
        } else {
            feedShakeSensitivityValue = JADMediator.getInstance().getInitService().getFeedShakeSensitivityValue();
            feedShakeAngleValue = JADMediator.getInstance().getInitService().getFeedShakeAngleValue();
            feedShakeTimeValue = JADMediator.getInstance().getInitService().getFeedShakeTimeValue();
            z10 = false;
        }
        Application application = this.jad_n_ly;
        if (application != null && -1 != this.jad_n_mz && (activityLifecycleCallbacks = this.jad_n_ob) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.jad_n_ly.registerActivityLifecycleCallbacks(this.jad_n_ob);
        }
        jad_n_iv();
        float f10 = (feedShakeSensitivityValue == 0.0f && feedShakeAngleValue == 0.0f) ? 15.0f : feedShakeSensitivityValue;
        jad_n_an jad_n_anVar = new jad_n_an(this.jad_n_fs.getContext(), f10, feedShakeAngleValue, feedShakeTimeValue, z10, f10, feedShakeAngleValue, feedShakeTimeValue);
        this.jad_n_kx = jad_n_anVar;
        jad_n_anVar.register();
    }

    public static void jad_n_an(jad_n_dq jad_n_dqVar, View view) {
        long j10;
        long j11;
        long j12;
        int i10;
        jad_n_dqVar.getClass();
        if (view == null || jad_n_dqVar.jad_n_fs == null || jad_n_dqVar.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getExposureService().setViewForceExposure(jad_n_dqVar.jad_n_an.getInstanceId());
        int onViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(view.getContext(), view, jad_n_dqVar.jad_n_an.getInstanceId());
        if (onViewClicked != -2) {
            String jad_n_er2 = jad_n_dqVar.jad_n_er();
            String jad_n_fs2 = jad_n_dqVar.jad_n_fs();
            int jad_n_bo2 = jad_n_dqVar.jad_n_bo();
            int jad_n_cp2 = jad_n_dqVar.jad_n_cp();
            if (jad_n_dqVar.jad_n_dq() != null) {
                int modelClickAreaType = jad_n_dqVar.jad_n_dq().getModelClickAreaType();
                jad_n_dqVar.jad_n_dq().setClickTime(System.currentTimeMillis());
                long clickTime = jad_n_dqVar.jad_n_dq().getClickTime() - jad_n_dqVar.jad_n_dq().getLoadTime();
                i10 = modelClickAreaType;
                j11 = jad_n_dqVar.jad_n_dq().getClickTime() - jad_n_dqVar.jad_n_dq().getLoadSucTime();
                j12 = jad_n_dqVar.jad_n_dq().getClickTime() - jad_n_dqVar.jad_n_dq().getShowTime();
                j10 = clickTime;
            } else {
                j10 = 0;
                j11 = 0;
                j12 = 0;
                i10 = 0;
            }
            JADMediator.getInstance().getEventService().reportClickEvent(jad_n_er2, jad_n_fs2, jad_n_bo2, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(jad_n_fs2), 2, onViewClicked, j10, j11, j12, jad_n_dqVar.jad_n_dq, jad_n_dqVar.jad_n_er, jad_n_cp2, jad_n_dqVar.jad_n_jw, i10, jad_n_dqVar.jad_n_hu, jad_n_dqVar.jad_n_iv);
        }
        JADNativeInteractionListener jADNativeInteractionListener = jad_n_dqVar.jad_n_bo;
        if (jADNativeInteractionListener != null) {
            jADNativeInteractionListener.onClick(view);
        }
    }

    public final void jad_n_bo(List<View> list) {
        JADNative jADNative = this.jad_n_an;
        if (jADNative == null) {
            return;
        }
        com.jd.ad.sdk.jad_n_an.jad_n_an jad_n_anVar = new com.jd.ad.sdk.jad_n_an.jad_n_an(jADNative);
        if (this.jad_n_an.getSlot() != null) {
            jad_n_anVar.jad_n_an = this.jad_n_an.getSlot().getSkipTime();
        }
        JADNativeInteractionListener jADNativeInteractionListener = this.jad_n_bo;
        if (jADNativeInteractionListener != null && (jADNativeInteractionListener instanceof JADNativeSplashInteractionListener)) {
            jad_n_anVar.jad_n_cp = new WeakReference<>((JADNativeSplashInteractionListener) jADNativeInteractionListener);
            jad_n_anVar.jad_n_bo = new jad_n_fs();
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view != null) {
                jad_n_an(view);
                jad_n_anVar.jad_n_hu = view;
                view.addOnAttachStateChangeListener(new com.jd.ad.sdk.jad_n_an.jad_n_bo(jad_n_anVar));
                View view2 = jad_n_anVar.jad_n_hu;
                if (view2 == null ? false : ViewCompat.isAttachedToWindow(view2)) {
                    Logger.d("Native ad setSkipView startCount");
                    jad_n_anVar.jad_n_an();
                }
                view.setOnClickListener(new jad_n_jt(jad_n_anVar));
            }
        }
    }

    public static boolean jad_n_an(jad_n_dq jad_n_dqVar, Context context, String str) {
        WeakReference<View> weakReference;
        jad_n_dqVar.getClass();
        if (context != null && !TextUtils.isEmpty(str)) {
            double d10 = Double.MAX_VALUE;
            ConcurrentHashMap<String, WeakReference<View>> nativeExposureFeedShakeViewMap = JADMediator.getInstance().getExposureService().getNativeExposureFeedShakeViewMap();
            if (nativeExposureFeedShakeViewMap != null) {
                int screenWidth = JADScreenInfoUtils.getScreenWidth(context) / 2;
                int screenHeight = JADScreenInfoUtils.getScreenHeight(context) / 2;
                String str2 = "";
                for (String str3 : nativeExposureFeedShakeViewMap.h()) {
                    if (!TextUtils.isEmpty(str3) && (weakReference = nativeExposureFeedShakeViewMap.get(str3)) != null && weakReference.get() != null) {
                        View view = weakReference.get();
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        int i10 = iArr[0];
                        int i11 = iArr[1];
                        int width = view.getWidth();
                        int height = (view.getHeight() / 2) + i11;
                        int abs = Math.abs(((width / 2) + i10) - screenWidth);
                        int abs2 = Math.abs(height - screenHeight);
                        double sqrt = Math.sqrt((abs2 * abs2) + (abs * abs));
                        if (sqrt < d10) {
                            str2 = str3;
                            d10 = sqrt;
                        }
                    }
                }
                JADNative jADNative = jad_n_dqVar.jad_n_an;
                if (jADNative != null && str2.equals(jADNative.getInstanceId())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int jad_n_bo() {
        if (jad_n_dq() != null) {
            return jad_n_dq().getAdType();
        }
        return 0;
    }

    public static void jad_n_an(jad_n_dq jad_n_dqVar, boolean z10, String str, int i10) {
        long j10;
        long j11;
        int i11;
        long j12;
        long j13;
        int i12;
        List<View> list;
        View next;
        JADNative jADNative;
        jad_n_dqVar.getClass();
        try {
            jad_n_dqVar.jad_n_dq = 0;
            jad_n_dqVar.jad_n_er = 0;
            if (jad_n_dqVar.jad_n_fs != null && (list = jad_n_dqVar.jad_n_jt) != null && list.size() != 0) {
                JADNative jADNative2 = jad_n_dqVar.jad_n_an;
                if (jADNative2 != null && jADNative2.getSlot() != null && jad_n_dqVar.jad_n_an.getSlot().getAdType() != 1) {
                    jad_n_dqVar.jad_n_dq = 0;
                    jad_n_dqVar.jad_n_er = 100;
                } else {
                    Iterator<View> iterator2 = jad_n_dqVar.jad_n_jt.iterator2();
                    int i13 = 0;
                    while (iterator2.hasNext() && (next = iterator2.next()) != null && (jADNative = jad_n_dqVar.jad_n_an) != null && jADNative.getSlot() != null) {
                        int measuredWidth = (int) (jad_n_dqVar.jad_n_fs.getMeasuredWidth() * jad_n_dqVar.jad_n_fs.getMeasuredHeight());
                        i13 += next.getMeasuredWidth() * next.getMeasuredHeight();
                        if (measuredWidth > 0) {
                            jad_n_dqVar.jad_n_er = (i13 * 100) / measuredWidth;
                            if (i13 < measuredWidth) {
                                jad_n_dqVar.jad_n_dq = 5;
                            } else {
                                jad_n_dqVar.jad_n_dq = 4;
                            }
                        } else {
                            jad_n_dqVar.jad_n_dq = 0;
                            jad_n_dqVar.jad_n_er = 0;
                        }
                    }
                }
            }
        } catch (Exception e2) {
            Logger.w("Exception while calculate area: " + e2.getMessage(), new Object[0]);
        }
        if (z10) {
            String jad_n_er2 = jad_n_dqVar.jad_n_er();
            String jad_n_fs2 = jad_n_dqVar.jad_n_fs();
            int jad_n_bo2 = jad_n_dqVar.jad_n_bo();
            if (jad_n_dqVar.jad_n_dq() != null) {
                int modelClickAreaType = jad_n_dqVar.jad_n_dq().getModelClickAreaType();
                jad_n_dqVar.jad_n_dq().setDelayShowTime(System.currentTimeMillis());
                i12 = modelClickAreaType;
                j12 = jad_n_dqVar.jad_n_dq().getDelayShowTime() - jad_n_dqVar.jad_n_dq().getLoadTime();
                j13 = jad_n_dqVar.jad_n_dq().getDelayShowTime() - jad_n_dqVar.jad_n_dq().getLoadSucTime();
            } else {
                j12 = 0;
                j13 = 0;
                i12 = 0;
            }
            JADMediator.getInstance().getEventService().reportExposureEvent(jad_n_er2, jad_n_fs2, jad_n_bo2, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(jad_n_fs2), 2, i10, j12, j13, jad_n_dqVar.jad_n_dq, jad_n_dqVar.jad_n_er, jad_n_dqVar.jad_n_cp(), i12, str, jad_n_dqVar.jad_n_hu, jad_n_dqVar.jad_n_iv);
            JADNativeInteractionListener jADNativeInteractionListener = jad_n_dqVar.jad_n_bo;
            if (jADNativeInteractionListener != null) {
                jADNativeInteractionListener.onExposure();
                return;
            }
            return;
        }
        String jad_n_er3 = jad_n_dqVar.jad_n_er();
        String jad_n_fs3 = jad_n_dqVar.jad_n_fs();
        int jad_n_bo3 = jad_n_dqVar.jad_n_bo();
        if (jad_n_dqVar.jad_n_dq() != null) {
            int modelClickAreaType2 = jad_n_dqVar.jad_n_dq().getModelClickAreaType();
            jad_n_dqVar.jad_n_dq().setShowTime(System.currentTimeMillis());
            i11 = modelClickAreaType2;
            j10 = jad_n_dqVar.jad_n_dq().getShowTime() - jad_n_dqVar.jad_n_dq().getLoadTime();
            j11 = jad_n_dqVar.jad_n_dq().getShowTime() - jad_n_dqVar.jad_n_dq().getLoadSucTime();
        } else {
            j10 = 0;
            j11 = 0;
            i11 = 0;
        }
        JADMediator.getInstance().getEventService().reportExposureEvent(jad_n_er3, jad_n_fs3, jad_n_bo3, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(jad_n_fs3), 2, i10, j10, j11, jad_n_dqVar.jad_n_dq, jad_n_dqVar.jad_n_er, jad_n_dqVar.jad_n_cp(), i11, str, jad_n_dqVar.jad_n_hu, jad_n_dqVar.jad_n_iv);
    }

    public final void jad_n_an(ViewGroup viewGroup) {
        JADNative jADNative;
        if (viewGroup == null || (jADNative = this.jad_n_an) == null || jADNative.getSlot() == null) {
            return;
        }
        JADMediator.getInstance().getExposureService().registerExposureView(this.jad_n_an.getInstanceId());
        if (this.jad_n_an.getSlot().getEventInteractionType() == 1) {
            JADMediator.getInstance().getExposureService().registerNativeExposureFeedShakeView(this.jad_n_an.getInstanceId(), viewGroup);
        }
        JADMediator.getInstance().getExposureService().setViewExposureCallback(this.jad_n_an.getInstanceId(), this.jad_n_an.getSlot().getAdType(), viewGroup, new jad_n_cp(viewGroup));
    }

    public final void jad_n_an(View view) {
        if (view == null || this.jad_n_an == null) {
            return;
        }
        JADMediator.getInstance().getTouchService().registerTouchView(this.jad_n_an.getInstanceId());
        view.setClickable(true);
        view.setOnTouchListener(new ViewOnTouchListenerC0377jad_n_dq());
    }

    public final void jad_n_an(List<View> list, boolean z10) {
        try {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(new jad_n_er(view, z10));
                    jad_n_an(view);
                }
            }
        } catch (Exception e2) {
            Logger.w("Exception while click:" + e2.getMessage(), new Object[0]);
        }
    }

    public final void jad_n_an(List<View> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (View view : list) {
            if (view != null) {
                try {
                    view.setOnClickListener(new jad_n_hu());
                } catch (Exception e2) {
                    Logger.w("Exception while click:" + e2.getMessage(), new Object[0]);
                }
                jad_n_an(view);
            }
        }
    }

    public static void jad_n_an(jad_n_dq jad_n_dqVar, View view, boolean z10) {
        long j10;
        long j11;
        long j12;
        if (jad_n_dqVar.jad_n_cp) {
            return;
        }
        if (jad_n_dqVar.jad_n_an != null) {
            JADMediator.getInstance().getExposureService().setViewForceExposure(jad_n_dqVar.jad_n_an.getInstanceId());
            JADMediator.getInstance().getTouchService().unregisterTouchView(jad_n_dqVar.jad_n_an.getInstanceId());
            if (jad_n_dqVar.jad_n_an.getSlot() != null && jad_n_dqVar.jad_n_an.getSlot().getAdType() == 2) {
                JADMediator.getInstance().getExposureService().unregisterNativeExposureFeedShakeView(jad_n_dqVar.jad_n_an.getInstanceId());
            }
        }
        jad_n_dqVar.jad_n_cp = true;
        if (z10) {
            String jad_n_er2 = jad_n_dqVar.jad_n_er();
            String jad_n_fs2 = jad_n_dqVar.jad_n_fs();
            int jad_n_bo2 = jad_n_dqVar.jad_n_bo();
            if (jad_n_dqVar.jad_n_dq() != null) {
                jad_n_dqVar.jad_n_dq().setClickTime(System.currentTimeMillis());
                long clickTime = jad_n_dqVar.jad_n_dq().getClickTime() - jad_n_dqVar.jad_n_dq().getLoadTime();
                j11 = jad_n_dqVar.jad_n_dq().getClickTime() - jad_n_dqVar.jad_n_dq().getLoadSucTime();
                j12 = jad_n_dqVar.jad_n_dq().getClickTime() - jad_n_dqVar.jad_n_dq().getShowTime();
                j10 = clickTime;
            } else {
                j10 = 0;
                j11 = 0;
                j12 = 0;
            }
            JADMediator.getInstance().getEventService().reportCloseEvent(jad_n_er2, jad_n_fs2, jad_n_bo2, CommonConstants.AdTmp.TEMPLATE_UNKNOWN.getTemplateId(), JADMediator.getInstance().getInitService().getSen(jad_n_fs2), 2, -1, j10, j11, j12, jad_n_dqVar.jad_n_dq, jad_n_dqVar.jad_n_er, CommonConstants.ClickFrom.CLOSE.ordinal(), jad_n_dqVar.jad_n_hu, jad_n_dqVar.jad_n_iv);
        }
        JADNativeInteractionListener jADNativeInteractionListener = jad_n_dqVar.jad_n_bo;
        if (jADNativeInteractionListener != null) {
            jADNativeInteractionListener.onClose(view);
        }
    }

    public void jad_n_an() {
        if (this.jad_n_an != null) {
            JADMediator.getInstance().getExposureService().unregisterExposureView(this.jad_n_an.getInstanceId());
            JADMediator.getInstance().getTouchService().unregisterTouchView(this.jad_n_an.getInstanceId());
            if (this.jad_n_an.getSlot() != null && this.jad_n_an.getSlot().getAdType() == 2) {
                JADMediator.getInstance().getExposureService().unregisterNativeExposureFeedShakeView(this.jad_n_an.getInstanceId());
            }
        }
        this.jad_n_bo = null;
        this.jad_n_an = null;
        this.jad_n_fs = null;
        this.jad_n_jt = null;
    }

    public static void jad_n_an(jad_n_dq jad_n_dqVar) {
        ViewGroup viewGroup = jad_n_dqVar.jad_n_fs;
        if (viewGroup == null || jad_n_dqVar.jad_n_na == null) {
            return;
        }
        viewGroup.getViewTreeObserver().removeOnWindowFocusChangeListener(jad_n_dqVar.jad_n_na);
        jad_n_dqVar.jad_n_na = null;
    }

    public static void jad_n_an(jad_n_dq jad_n_dqVar, boolean z10) {
        if (z10) {
            ShakeListener shakeListener = jad_n_dqVar.jad_n_kx;
            if (shakeListener != null) {
                shakeListener.register();
                return;
            }
            return;
        }
        ShakeListener shakeListener2 = jad_n_dqVar.jad_n_kx;
        if (shakeListener2 != null) {
            shakeListener2.unregister();
        }
    }
}
