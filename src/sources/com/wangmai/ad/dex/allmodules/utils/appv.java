package com.wangmai.ad.dex.allmodules.utils;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.bean.VirtualClickAdSlotInfo;
import com.wangmai.ad.dex.allmodules.utils.appa;
import com.wangmai.ad.dex.allmodules.view.WMBaseViewGroup;
import com.wangmai.ad.dex.allmodules.view.WMGestureProxyView;
import com.wangmai.common.utils.ThreadUtils;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: SlideClickHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appv extends com.wangmai.ad.dex.allmodules.utils.appa {
    private static final String appg = "appv";
    private static ArrayBlockingQueue<appa.appc> apph = new ArrayBlockingQueue<>(1);
    private float appf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: SlideClickHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ appa.appc f46865appa;
        final /* synthetic */ int appb;
        final /* synthetic */ float appc;
        final /* synthetic */ float appd;
        final /* synthetic */ float appe;
        final /* synthetic */ float appf;

        appa(appv appvVar, appa.appc appcVar, int i10, float f10, float f11, float f12, float f13) {
            this.f46865appa = appcVar;
            this.appb = i10;
            this.appc = f10;
            this.appd = f11;
            this.appe = f12;
            this.appf = f13;
        }

        @Override // java.lang.Runnable
        public void run() {
            appa.appa.appf.appd.appe(appv.appg, "触发滑动点击>>>:" + ((Object) this.f46865appa));
            this.f46865appa.appa(this.appb, this.appc, this.appd, this.appe, this.appf);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: SlideClickHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements GestureDetector.OnGestureListener {
        appb() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            float x10 = motionEvent2.getX() - motionEvent.getX();
            float y10 = motionEvent2.getY() - motionEvent.getY();
            if (Math.abs(x10) > Math.abs(y10)) {
                if (Math.abs(x10) <= appv.this.appf) {
                    appa.appa.appf.appd.appe(appv.appg, "无效横向滑动:" + x10 + "<" + appv.this.appf);
                } else if (x10 > 0.0f) {
                    appv.this.appa(3, motionEvent.getX(), motionEvent.getY(), motionEvent2.getX(), motionEvent2.getY());
                } else {
                    appv.this.appa(1, motionEvent.getX(), motionEvent.getY(), motionEvent2.getX(), motionEvent2.getY());
                }
            } else if (Math.abs(y10) <= appv.this.appf) {
                appa.appa.appf.appd.appe(appv.appg, "无效纵向滑动:" + y10 + "<" + appv.this.appf);
            } else if (y10 > 0.0f) {
                appv.this.appa(4, motionEvent.getX(), motionEvent.getY(), motionEvent2.getX(), motionEvent2.getY());
            } else {
                appv.this.appa(2, motionEvent.getX(), motionEvent.getY(), motionEvent2.getX(), motionEvent2.getY());
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    public appv(Context context, String str, ApiBean.Optimization optimization, boolean z10) {
        super(context, str, optimization, z10);
        this.appf = optimization.getSlideClickPixel();
    }

    protected boolean appb() {
        return (appd() || appf()) ? false : true;
    }

    public GestureDetector appc() {
        return new GestureDetector(this.f46821appa, new appb());
    }

    public boolean appd() {
        VirtualClickAdSlotInfo appa2 = appa();
        if (appa2 == null || appa2.isExpired() || appa2.getSlideClickedCount() <= this.appd.getSlideClickFrequency()) {
            return false;
        }
        appa.appa.appf.appd.appe(appg, "未触发滑动点击逻辑（点击频次限制）");
        return true;
    }

    protected boolean appe() {
        if (!((this.appc || this.appd.getInteractiveObjs() == null || this.appd.getInteractiveObjs().isEmpty()) ? false : true)) {
            return false;
        }
        appa.appa.appf.appd.appe(appg, "未触发滑动点击逻辑（互动形式限制）");
        return true;
    }

    protected boolean appf() {
        VirtualClickAdSlotInfo appa2 = appa();
        if (appa2 != null) {
            long currentTimeMillis = System.currentTimeMillis() - appa2.getLastSlideClickTime();
            if (currentTimeMillis < ((long) (this.appd.getSlideClickInterval() * 1000))) {
                appa.appa.appf.appd.appe(appg, "未触发滑动点击逻辑（点击时间间隔限制）", currentTimeMillis + " < " + (this.appd.getSlideClickInterval() * 1000));
                return true;
            }
        }
        return false;
    }

    protected boolean appg() {
        ApiBean.Optimization optimization = this.appd;
        boolean z10 = optimization == null || optimization.getSlideClickPixel() <= 0 || this.appd.getSlideClickFrequency() <= 0;
        if (z10) {
            appa.appa.appf.appd.appe(appg, "未触发滑动点击逻辑（无效配置限制）");
        }
        return z10;
    }

    public void apph() {
        appb(appf.appn);
    }

    public void appa(Activity activity, appa.appc appcVar) {
        try {
            if (appa(appf.appn) || appa(activity, null, appcVar) || appg() || appe()) {
                return;
            }
            appa.appa.appf.appd.appe(appg, "启用本次滑动点击监听");
            apph.clear();
            apph.offer(appcVar);
            appa(activity);
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appg, "registerSlideClickListener error:" + th.toString());
        }
    }

    public void appa(WMBaseViewGroup wMBaseViewGroup, appa.appc appcVar) {
        try {
            if (appa(appf.appn) || appa(null, wMBaseViewGroup, appcVar) || appg() || appe()) {
                return;
            }
            appa.appa.appf.appd.appe(appg, "启用本次滑动点击监听");
            apph.clear();
            apph.offer(appcVar);
            wMBaseViewGroup.setGestureDetector(appc());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appg, "registerSlideClickListener error:" + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appa(int i10, float f10, float f11, float f12, float f13) {
        if (appb()) {
            try {
                appa.appc poll = apph.poll();
                if (poll != null) {
                    ThreadUtils.runOnUIThread(new appa(this, poll, i10, f10, f11, f12, f13));
                }
            } catch (Throwable th) {
                appa.appa.appf.appd.appe(appg, "doSlideClick error:" + th);
            }
        }
    }

    private boolean appa(Activity activity, View view, appa.appc appcVar) {
        boolean z10 = (activity == null && view == null) || appcVar == null;
        if (z10) {
            appa.appa.appf.appd.appe(appg, "未触发滑动点击逻辑（无效参数限制）:activity:" + ((Object) activity) + "targetView:" + ((Object) view) + ",callbackListener:" + ((Object) appcVar));
        }
        return z10;
    }

    public void appa(appa.appc appcVar) {
        if (apph == null || appcVar == null) {
            return;
        }
        appa.appa.appf.appd.appa(appg, "销毁滑动点击监测", appcVar);
        apph.remove(appcVar);
    }

    public void appa(Activity activity) {
        try {
            if (activity == null) {
                appa.appa.appf.appd.appe(appg, "Activity为空，无法实现目标视图代理");
                return;
            }
            ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
            appa.appa.appf.appd.appa(appg, "decorView=" + ((Object) viewGroup));
            if (viewGroup == null) {
                appa.appa.appf.appd.appe(appg, "代理失败，当前窗口缺失decorView");
                return;
            }
            if (Objects.equals(viewGroup.getTag(), "tag_proxy")) {
                appa.appa.appf.appd.appe(appg, "当前页面视图已被代理，无需重复操作");
                return;
            }
            viewGroup.setTag("tag_proxy");
            appa.appa.appf.appd.appa(appg, "decorView.getChildCount=" + viewGroup.getChildCount());
            for (int i10 = 0; i10 < viewGroup.getChildCount(); i10++) {
                appa.appa.appf.appd.appa(appg, "decorView.childView=" + ((Object) viewGroup.getChildAt(i10)));
            }
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(16908290);
            appa.appa.appf.appd.appa(appg, "contentView=" + ((Object) viewGroup2));
            if (viewGroup2 == null) {
                appa.appa.appf.appd.appe(appg, "代理失败，当前窗口缺失contentView");
                return;
            }
            appa.appa.appf.appd.appa(appg, "contentView.getChildCount=" + viewGroup2.getChildCount());
            for (int i11 = 0; i11 < viewGroup2.getChildCount(); i11++) {
                appa.appa.appf.appd.appa(appg, "contentView.childView=" + ((Object) viewGroup2.getChildAt(i11)));
            }
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getChildAt(0);
            viewGroup2.removeAllViews();
            WMGestureProxyView wMGestureProxyView = new WMGestureProxyView(activity);
            wMGestureProxyView.setLayoutParams((ViewGroup.MarginLayoutParams) viewGroup3.getLayoutParams());
            wMGestureProxyView.addView(viewGroup3);
            viewGroup2.addView(wMGestureProxyView);
            wMGestureProxyView.setGestureDetector(appc());
        } catch (Throwable th) {
            appa.appa.appf.appd.appe(appg, "replaceWindowContentView error:" + th.toString());
        }
    }
}
