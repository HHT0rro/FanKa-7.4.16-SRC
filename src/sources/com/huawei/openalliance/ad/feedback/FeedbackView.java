package com.huawei.openalliance.ad.feedback;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huawei.hms.ads.ea;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.nativead.R;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.openalliance.ad.utils.aa;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.bd;
import com.huawei.openalliance.ad.utils.o;
import com.huawei.openalliance.ad.utils.y;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FeedbackView extends PPSBaseDialogContentView implements d {

    /* renamed from: g, reason: collision with root package name */
    private LinearLayout f32424g;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f32425h;

    /* renamed from: i, reason: collision with root package name */
    private FlowLayoutView f32426i;

    /* renamed from: j, reason: collision with root package name */
    private FlowLayoutView f32427j;

    /* renamed from: k, reason: collision with root package name */
    private ViewStub f32428k;

    /* renamed from: l, reason: collision with root package name */
    private View f32429l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f32430m;

    /* renamed from: n, reason: collision with root package name */
    private com.huawei.openalliance.ad.compliance.a f32431n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f32432o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f32433p;

    /* renamed from: q, reason: collision with root package name */
    private com.huawei.openalliance.ad.feedback.b f32434q;

    /* renamed from: r, reason: collision with root package name */
    private a f32435r;

    /* renamed from: s, reason: collision with root package name */
    private c f32436s;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends b {
        private com.huawei.openalliance.ad.compliance.a I;

        public a(Context context) {
            super(context);
        }

        public void Code(com.huawei.openalliance.ad.compliance.a aVar) {
            this.I = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.huawei.openalliance.ad.compliance.a aVar;
            com.huawei.openalliance.ad.feedback.b bVar = this.Code;
            if (bVar == null) {
                return;
            }
            boolean Z = bVar.Z();
            gl.Code("FeedbackView", "click to complain:%s", Boolean.valueOf(Z));
            if (!Z || (aVar = this.I) == null) {
                return;
            }
            aVar.Code(3, this.Code.I());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class b implements View.OnClickListener {
        public com.huawei.openalliance.ad.feedback.b Code;
        public final Context V;

        public b(Context context) {
            this.V = context;
        }

        public void Code(com.huawei.openalliance.ad.feedback.b bVar) {
            this.Code = bVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c extends b {
        public c(Context context) {
            super(context);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.huawei.openalliance.ad.feedback.b bVar = this.Code;
            if (bVar == null) {
                return;
            }
            gl.Code("FeedbackView", "click to why this ad:%s", Boolean.valueOf(bVar.Code(this.V)));
        }
    }

    public FeedbackView(Context context) {
        super(context);
        this.f32432o = true;
        this.f32433p = true;
    }

    public FeedbackView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32432o = true;
        this.f32433p = true;
    }

    public FeedbackView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f32432o = true;
        this.f32433p = true;
    }

    public FeedbackView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f32432o = true;
        this.f32433p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(int i10, FeedbackInfo feedbackInfo) {
        com.huawei.openalliance.ad.compliance.a aVar = this.f32431n;
        if (aVar != null) {
            aVar.Code(i10, feedbackInfo);
        }
    }

    private void Code(FlowLayoutView flowLayoutView, List<FeedbackInfo> list, final int i10) {
        flowLayoutView.removeAllViews();
        if (aa.Code(list)) {
            gl.V("FeedbackView", "feedbackInfoList is null");
            return;
        }
        gl.V("FeedbackView", "initFlowLayout, feedType: %s, feedbackList.size: %s", Integer.valueOf(i10), Integer.valueOf(list.size()));
        for (final FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null && !TextUtils.isEmpty(feedbackInfo.Code())) {
                String Code = feedbackInfo.Code();
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.hiad_feedback_unlike_label_item, (ViewGroup) flowLayoutView, false);
                if (inflate instanceof TextView) {
                    TextView textView = (TextView) inflate;
                    textView.setText(Code);
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.feedback.FeedbackView.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            try {
                                if (FeedbackView.this.f32432o) {
                                    FeedbackView.this.f32432o = false;
                                    view.setSelected(!view.isSelected());
                                    view.postDelayed(new Runnable() { // from class: com.huawei.openalliance.ad.feedback.FeedbackView.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            FeedbackView.this.f32432o = true;
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            FeedbackView.this.Code(i10, feedbackInfo);
                                        }
                                    }, 200L);
                                }
                            } catch (Throwable th) {
                                gl.I("FeedbackView", "onClick error, %s", th.getClass().getSimpleName());
                            }
                        }
                    });
                    flowLayoutView.addView(textView);
                }
            }
        }
        flowLayoutView.setDefaultDisplayMode(ay.I() ? -1 : 1);
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code() {
        View view;
        try {
            this.f32433p = ea.Code(getContext()).V();
            gl.V("FeedbackView", "adapterView mFeedbackViewPaddingLeft = %s, mFeedbackViewPaddingRight= %s", Integer.valueOf(this.f32743a), Integer.valueOf(this.f32744b));
            if (V() && (view = this.V) != null) {
                view.setPadding(this.f32743a, 0, this.f32744b, 0);
                com.huawei.openalliance.ad.feedback.b bVar = this.f32434q;
                if (bVar != null) {
                    List<FeedbackInfo> Code = bVar.Code();
                    List<FeedbackInfo> V = this.f32434q.V();
                    FeedbackInfo I = this.f32434q.I();
                    if (o.Code(Code)) {
                        bd.Code((View) this.f32424g, true);
                        Code(this.f32426i, Code, 2);
                    } else {
                        bd.Code((View) this.f32424g, false);
                    }
                    if (o.Code(V)) {
                        bd.Code((View) this.f32425h, true);
                        Code(this.f32427j, V, 1);
                    } else {
                        bd.Code((View) this.f32425h, false);
                    }
                    if (this.f32433p) {
                        if (I == null || !I.Z()) {
                            ViewStub viewStub = this.f32428k;
                            if (viewStub != null) {
                                viewStub.setVisibility(8);
                            }
                        } else {
                            ((TextView) findViewById(R.id.complain_tv)).setText(I.Code());
                        }
                    }
                    View findViewById = findViewById(R.id.extra_area);
                    this.f32429l = findViewById;
                    if (findViewById != null) {
                        findViewById.setOnClickListener(!this.f32433p ? this.f32436s : this.f32435r);
                    }
                }
                this.V.requestLayout();
                this.V.getViewTreeObserver().addOnGlobalLayoutListener(this.f32746d);
            }
        } catch (Throwable th) {
            gl.I("FeedbackView", "adapterView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void Code(Context context) {
        try {
            View inflate = LayoutInflater.from(context).inflate(R.layout.hiad_feedback_view, this);
            this.Code = inflate;
            this.f32424g = (LinearLayout) inflate.findViewById(R.id.feedback_positive_ll);
            this.f32425h = (LinearLayout) this.Code.findViewById(R.id.feedback_negative_ll);
            this.V = this.Code.findViewById(R.id.feedback_view_root);
            this.I = this.Code.findViewById(R.id.feedback_scrollview);
            this.f32426i = (FlowLayoutView) this.Code.findViewById(R.id.feedback_positive_flv);
            this.f32427j = (FlowLayoutView) this.Code.findViewById(R.id.feedback_negative_flv);
            this.f32428k = (ViewStub) this.Code.findViewById(R.id.feedback_viewstub);
            this.f32434q = new com.huawei.openalliance.ad.feedback.b(this);
            this.f32435r = new a(getContext());
            this.f32436s = new c(getContext());
            this.f32435r.Code(this.f32434q);
            this.f32436s.Code(this.f32434q);
        } catch (Throwable th) {
            gl.I("FeedbackView", "initView error, %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void V(Context context) {
        boolean V = ea.Code(context).V();
        this.f32433p = V;
        gl.Code("FeedbackView", "isChinaRom = %s", Boolean.valueOf(V));
        ViewStub viewStub = this.f32428k;
        if (viewStub == null) {
            return;
        }
        viewStub.setLayoutResource(!this.f32433p ? R.layout.hiad_whythisad_viewstub : R.layout.hiad_complain_viewstub);
        this.f32428k.inflate();
        ImageView imageView = (ImageView) findViewById(R.id.right_arrow);
        this.f32430m = imageView;
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.hiad_feedback_right_arrow);
            if (ay.I()) {
                this.f32430m.setImageBitmap(y.V(drawable));
            }
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setAdContentData(AdContentData adContentData) {
        com.huawei.openalliance.ad.feedback.b bVar = this.f32434q;
        if (bVar != null) {
            bVar.Code(getContext(), adContentData);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSBaseDialogContentView
    public void setFeedbackListener(com.huawei.openalliance.ad.compliance.a aVar) {
        this.f32431n = aVar;
        a aVar2 = this.f32435r;
        if (aVar2 != null) {
            aVar2.Code(aVar);
        }
    }
}
