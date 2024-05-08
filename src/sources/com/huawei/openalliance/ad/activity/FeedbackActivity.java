package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.hms.ads.eo;
import com.huawei.hms.ads.ew;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kv;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.activity.a;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.feedback.FeedbackView;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.inter.data.n;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@AllApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FeedbackActivity extends a implements com.huawei.openalliance.ad.compliance.a {

    /* renamed from: o, reason: collision with root package name */
    private static AdFeedbackListener f32123o;

    /* renamed from: p, reason: collision with root package name */
    private static AdFeedbackListener f32124p;

    /* renamed from: q, reason: collision with root package name */
    private static WeakReference<Context> f32125q;

    private void Code(int i10, List<FeedbackInfo> list) {
        Toast.makeText(getApplicationContext(), R.string.hiad_feedback_reduce_such_content, 0).show();
        kv.Code(this, this.f32133c, list, 1);
        eo.Code(this, this.f32133c, 1 == i10 ? "2" : "4");
        AdFeedbackListener adFeedbackListener = f32124p;
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdDisliked();
        }
        AdFeedbackListener adFeedbackListener2 = f32123o;
        if (adFeedbackListener2 != null) {
            adFeedbackListener2.onAdDisliked();
        }
    }

    public static void Code(Context context, com.huawei.openalliance.ad.feedback.a aVar) {
        if (aVar == null) {
            return;
        }
        if (o.Code()) {
            gl.V("FeedbackActivity", "fast click");
            return;
        }
        n Code = ew.Code();
        if (Code == null) {
            gl.V("FeedbackActivity", "nativeAd is null");
            return;
        }
        f32124p = aVar.V();
        f32123o = aVar.I();
        AdContentData l10 = Code.l();
        if (l10 == null || aVar.Code() == null || !o.Code(l10.ax()) || f32124p == null) {
            gl.Z("FeedbackActivity", "startFeedbackActivity fail: invalid parameter.");
            D();
            return;
        }
        try {
            View Code2 = aVar.Code();
            int[] iArr = new int[2];
            f32125q = new WeakReference<>(Code2.getContext());
            Code2.getLocationInWindow(iArr);
            gl.V("FeedbackActivity", "startFeedbackActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            int[] iArr2 = new int[2];
            Code2.getLocationOnScreen(iArr2);
            int[] iArr3 = {Code2.getMeasuredWidth(), Code2.getMeasuredHeight()};
            Code2.getViewTreeObserver().addOnGlobalLayoutListener(new a.ViewTreeObserverOnGlobalLayoutListenerC0328a(Code2, context, iArr2));
            Intent intent = new Intent(context, (Class<?>) FeedbackActivity.class);
            intent.putExtra(ax.ao, iArr);
            intent.putExtra(ax.ap, iArr3);
            intent.setFlags(65536);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.setClipData(u.cG);
            context.startActivity(intent);
        } catch (Throwable th) {
            gl.I("FeedbackActivity", "startFeedbackActivity error: %s", th.getClass().getSimpleName());
            D();
        }
    }

    private void Code(List<FeedbackInfo> list) {
        Toast.makeText(getApplicationContext(), R.string.hiad_feedback_had_feedback, 0).show();
        kv.Code(this, this.f32133c, list, 2);
        eo.Code(this, this.f32133c, "1");
        AdFeedbackListener adFeedbackListener = f32124p;
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdLiked();
        }
        AdFeedbackListener adFeedbackListener2 = f32123o;
        if (adFeedbackListener2 != null) {
            adFeedbackListener2.onAdLiked();
        }
    }

    private static void D() {
        AdFeedbackListener adFeedbackListener = f32123o;
        if (adFeedbackListener != null) {
            adFeedbackListener.onAdFeedbackShowFailed();
        }
    }

    private static void F() {
        f32123o = null;
        f32124p = null;
    }

    private void S() {
        this.f32140j.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.FeedbackActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    FeedbackActivity feedbackActivity = FeedbackActivity.this;
                    eo.Code(feedbackActivity, feedbackActivity.f32133c, "3");
                } catch (Throwable th) {
                    gl.I("FeedbackActivity", "onClick error: %s", th.getClass().getSimpleName());
                }
                FeedbackActivity.this.finish();
            }
        });
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public boolean B() {
        n Code = ew.Code();
        if (Code == null) {
            return false;
        }
        this.f32133c = Code.l();
        return super.B();
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void Code() {
        this.f32140j = (RelativeLayout) findViewById(R.id.feedback_activity_root);
        this.f32141k = findViewById(R.id.margin_view);
        this.f32142l = findViewById(R.id.feedback_anchor_view);
        this.f32134d = (FeedbackView) findViewById(R.id.top_feedback_view);
        this.f32137g = (ImageView) findViewById(R.id.top_feedback_iv);
        this.f32135e = (FeedbackView) findViewById(R.id.bottom_feedback_view);
        this.f32138h = (ImageView) findViewById(R.id.bottom_feedback_iv);
    }

    @Override // com.huawei.openalliance.ad.compliance.a
    public void Code(int i10, FeedbackInfo feedbackInfo) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            arrayList.add(feedbackInfo);
        } catch (Throwable th) {
            gl.I("FeedbackActivity", "itemClickAction error: %s", th.getClass().getSimpleName());
        }
        if (i10 != 1) {
            if (i10 == 2) {
                Code(arrayList);
            } else if (i10 != 3) {
                gl.Code("FeedbackActivity", "invalid feedback type");
            }
            finish();
        }
        Code(i10, arrayList);
        finish();
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void I() {
        C();
        this.f32136f.Code(this.f32131a, this.f32132b);
        this.f32136f.setAdContentData(this.f32133c);
        this.f32136f.setFeedbackListener(this);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public int V() {
        return R.layout.hiad_activity_feedback;
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void Z() {
        D();
    }

    @Override // com.huawei.openalliance.ad.activity.a, android.app.Activity
    public void finish() {
        super.finish();
        gl.V("FeedbackActivity", "finish");
        RelativeLayout relativeLayout = this.f32140j;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(4);
        }
    }

    @Override // com.huawei.openalliance.ad.activity.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            S();
            eo.Code(this, this.f32133c, "0");
        } catch (Throwable th) {
            gl.I("FeedbackActivity", "onCreate error: %s", th.getClass().getSimpleName());
            D();
            finish();
        }
        ay.Code(this, f32125q.get());
    }

    @Override // com.huawei.openalliance.ad.activity.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ew.Code(null);
        F();
    }
}
