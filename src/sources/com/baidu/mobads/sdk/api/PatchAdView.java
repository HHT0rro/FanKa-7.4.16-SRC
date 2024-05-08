package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.as;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PatchAdView extends RelativeLayout {
    private static final String AD_CLICKED = "onAdClicked";
    private static final String PLAY_END = "playCompletion";
    private static final String PLAY_ERROR = "playFailure";
    private static final String PLAY_START = "onAdShow";
    private static final String TAG = "PacthAdView";
    private View mAdView;
    private IPatchAdListener mListener;
    private ClassLoader mLoader;
    private final String mRemoteClassName;
    private Context mViewContext;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class InvocationHandlerImp implements InvocationHandler {
        public InvocationHandlerImp() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            if (name.equals(PatchAdView.PLAY_END)) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.playCompletion();
                }
            } else if (name.equals(PatchAdView.PLAY_ERROR)) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.playError();
                }
            } else if (name.equals(PatchAdView.PLAY_START)) {
                if (PatchAdView.this.mListener != null) {
                    PatchAdView.this.mListener.onAdShow();
                }
            } else if (name.equals(PatchAdView.AD_CLICKED) && PatchAdView.this.mListener != null) {
                PatchAdView.this.mListener.onAdClicked();
            }
            return null;
        }
    }

    public PatchAdView(Context context) {
        super(context);
        this.mRemoteClassName = x.f10424i;
        init(context);
        setBackgroundColor(Color.parseColor("#000000"));
    }

    private void init(Context context) {
        this.mViewContext = context;
        Object[] objArr = {context};
        ClassLoader a10 = br.a(context);
        this.mLoader = a10;
        View view = (View) as.a(this.mRemoteClassName, a10, (Class<?>[]) new Class[]{Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public long getCurrentPosition() {
        View view = this.mAdView;
        if (view == null) {
            return 0L;
        }
        Object a10 = as.a(this.mRemoteClassName, view, this.mLoader, "getCurrentPosition", new Class[0], new Object[0]);
        if (a10 instanceof Number) {
            return ((Long) a10).longValue();
        }
        return 0L;
    }

    public long getDuration() {
        View view = this.mAdView;
        if (view == null) {
            return 0L;
        }
        Object a10 = as.a(this.mRemoteClassName, view, this.mLoader, "getDuration", new Class[0], new Object[0]);
        if (a10 instanceof Number) {
            return ((Long) a10).longValue();
        }
        return 0L;
    }

    public void setAdData(XAdVideoResponse xAdVideoResponse) {
        View view;
        if (xAdVideoResponse == null || (view = this.mAdView) == null) {
            return;
        }
        as.a(this.mRemoteClassName, view, this.mLoader, "setAdData", new Class[]{Object.class}, xAdVideoResponse);
    }

    public void setPatchAdListener(IPatchAdListener iPatchAdListener) {
        this.mListener = iPatchAdListener;
        try {
            Class<?> a10 = as.a("com.component.patchad.IPatchAdListener", this.mLoader);
            if (a10 != null) {
                Object newProxyInstance = Proxy.newProxyInstance(a10.getClassLoader(), new Class[]{a10}, new InvocationHandlerImp());
                View view = this.mAdView;
                if (view != null) {
                    as.a(this.mRemoteClassName, view, this.mLoader, "setPatchAdListener", new Class[]{a10}, newProxyInstance);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setVideoVolume(boolean z10) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "setVideoVolume", new Class[]{Boolean.TYPE}, Boolean.valueOf(z10));
        }
    }
}
