package com.cupidapp.live.liveshow.view.viewerenter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$styleable;
import com.cupidapp.live.base.grpc.LiveUserEntryModel;
import com.cupidapp.live.base.network.download.LaunchDownloader;
import com.cupidapp.live.liveshow.view.label.LiveLabelListView;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKLiveViewerEnterDefaultLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKLiveViewerEnterDefaultLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public final float f16013b;

    /* renamed from: c, reason: collision with root package name */
    public final float f16014c;

    /* renamed from: d, reason: collision with root package name */
    public final float f16015d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final AlphaAnimation f16016e;

    /* renamed from: f, reason: collision with root package name */
    public final Animation f16017f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f16018g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final List<LiveUserEntryModel> f16019h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f16020i;

    /* compiled from: FKLiveViewerEnterDefaultLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            FKLiveViewerEnterDefaultLayout.this.f16019h.remove(0);
            FKLiveViewerEnterDefaultLayout.this.f16018g = false;
            FKLiveViewerEnterDefaultLayout.this.setVisibility(4);
            FKLiveViewerEnterDefaultLayout.this.n();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }

    /* compiled from: FKLiveViewerEnterDefaultLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@Nullable Animation animation) {
            FKLiveViewerEnterDefaultLayout fKLiveViewerEnterDefaultLayout = FKLiveViewerEnterDefaultLayout.this;
            fKLiveViewerEnterDefaultLayout.startAnimation(fKLiveViewerEnterDefaultLayout.f16016e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@Nullable Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@Nullable Animation animation) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveViewerEnterDefaultLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f16020i = new LinkedHashMap();
        this.f16013b = 23.0f;
        this.f16014c = 34.0f;
        this.f16015d = 45.0f;
        this.f16016e = new AlphaAnimation(1.0f, 0.0f);
        this.f16017f = AnimationUtils.loadAnimation(getContext(), R$anim.anim_view_left_in);
        this.f16019h = new ArrayList();
        l(this, context, null, 2, null);
    }

    public static /* synthetic */ void l(FKLiveViewerEnterDefaultLayout fKLiveViewerEnterDefaultLayout, Context context, AttributeSet attributeSet, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            attributeSet = null;
        }
        fKLiveViewerEnterDefaultLayout.k(context, attributeSet);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f16020i;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void f(boolean z10) {
        if (z10) {
            ((TextView) a(R$id.viewerEnterUserNameTextView)).setTextSize(13.0f);
            ((TextView) a(R$id.viewerEnterMessageTextView)).setTextSize(13.0f);
        } else {
            ((TextView) a(R$id.viewerEnterUserNameTextView)).setTextSize(11.0f);
            ((TextView) a(R$id.viewerEnterMessageTextView)).setTextSize(11.0f);
        }
    }

    public final void g(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile != null) {
            ((Group) a(R$id.viewerEnterBackgroundGroup)).setVisibility(0);
            int height = decodeFile.getHeight();
            float f10 = height;
            float f11 = this.f16014c * f10;
            float f12 = this.f16013b;
            float f13 = (this.f16015d * f10) / f12;
            int i10 = (int) (f11 / f12);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, i10, height);
            Bitmap createBitmap2 = Bitmap.createBitmap(decodeFile, i10, 0, 1, height);
            Bitmap createBitmap3 = Bitmap.createBitmap(decodeFile, (int) (decodeFile.getWidth() - f13), 0, (int) f13, height);
            int i11 = R$id.backgroundLeadingView;
            ((ImageView) a(i11)).setImageBitmap(createBitmap);
            ((ImageView) a(R$id.backgroundCenterView)).setImageBitmap(createBitmap2);
            int i12 = R$id.backgroundTrailingView;
            ((ImageView) a(i12)).setImageBitmap(createBitmap3);
            int i13 = R$id.viewerEnterRootLayout;
            ((ConstraintLayout) a(i13)).measure(View.MeasureSpec.makeMeasureSpec(h.l(this), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(h.l(this), Integer.MIN_VALUE));
            float measuredHeight = (this.f16014c * ((ConstraintLayout) a(i13)).getMeasuredHeight()) / this.f16013b;
            float measuredHeight2 = (this.f16015d * ((ConstraintLayout) a(i13)).getMeasuredHeight()) / this.f16013b;
            int i14 = (int) measuredHeight;
            ((ImageView) a(i11)).getLayoutParams().width = i14;
            ViewGroup.LayoutParams layoutParams = ((ImageView) a(i12)).getLayoutParams();
            int i15 = (int) measuredHeight2;
            layoutParams.width = i15;
            ((LinearLayout) a(R$id.viewerEnterUserInfoLayout)).setPadding(i14, 0, i15, 0);
            ((ConstraintLayout) a(i13)).setBackground(null);
            return;
        }
        h();
    }

    public final void h() {
        ((LinearLayout) a(R$id.viewerEnterUserInfoLayout)).setPadding(h.c(this, 5.0f), 0, h.c(this, 5.0f), 0);
        ((ConstraintLayout) a(R$id.viewerEnterRootLayout)).setBackgroundResource(R$drawable.shape_pink_live_show_system_message);
    }

    public final void i(LiveUserEntryModel liveUserEntryModel) {
        User user;
        if (liveUserEntryModel == null || (user = liveUserEntryModel.getUser()) == null) {
            return;
        }
        boolean z10 = true;
        this.f16018g = true;
        setVisibility(0);
        LiveLabelListView viewer_enter_live_label_view = (LiveLabelListView) a(R$id.viewer_enter_live_label_view);
        s.h(viewer_enter_live_label_view, "viewer_enter_live_label_view");
        viewer_enter_live_label_view.n(liveUserEntryModel.getEnterDecorationLabels(), null, (r12 & 4) != 0 ? 11.0f : 0.0f, (r12 & 8) != 0 ? Integer.MAX_VALUE : 1, (r12 & 16) != 0 ? false : false);
        ((TextView) a(R$id.viewerEnterUserNameTextView)).setText(user.getName());
        ((Group) a(R$id.viewerEnterBackgroundGroup)).setVisibility(8);
        String decoration = liveUserEntryModel.getDecoration();
        if (!(decoration == null || decoration.length() == 0)) {
            String s2 = LaunchDownloader.f11925a.s(liveUserEntryModel.getDecoration());
            if (s2 != null && s2.length() != 0) {
                z10 = false;
            }
            if (!z10) {
                g(s2);
            } else {
                h();
            }
        } else {
            String background = liveUserEntryModel.getBackground();
            if (background != null && background.length() != 0) {
                z10 = false;
            }
            if (!z10) {
                j(liveUserEntryModel.getBackground());
            } else {
                h();
            }
        }
        startAnimation(this.f16017f);
    }

    public final void j(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(h.c(gradientDrawable, 5.0f));
        gradientDrawable.setColor(com.cupidapp.live.base.utils.h.b(str));
        gradientDrawable.setAlpha(153);
        ((LinearLayout) a(R$id.viewerEnterUserInfoLayout)).setPadding(h.c(this, 5.0f), 0, h.c(this, 5.0f), 0);
        ((ConstraintLayout) a(R$id.viewerEnterRootLayout)).setBackground(gradientDrawable);
    }

    public final void k(Context context, AttributeSet attributeSet) {
        z.a(this, R$layout.layout_live_viewer_enter_default, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FKLiveViewerEnterDefaultLayout);
        s.h(obtainStyledAttributes, "context.obtainStyledAttr…ViewerEnterDefaultLayout)");
        f(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f16016e.setDuration(300L);
        this.f16016e.setStartOffset(2000L);
        this.f16016e.setAnimationListener(new a());
        this.f16017f.setAnimationListener(new b());
    }

    public final void m(@NotNull LiveUserEntryModel model) {
        s.i(model, "model");
        this.f16019h.add(model);
        n();
    }

    public final void n() {
        if (this.f16018g) {
            return;
        }
        i((LiveUserEntryModel) CollectionsKt___CollectionsKt.V(this.f16019h));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f16016e.cancel();
        this.f16017f.cancel();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveViewerEnterDefaultLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f16020i = new LinkedHashMap();
        this.f16013b = 23.0f;
        this.f16014c = 34.0f;
        this.f16015d = 45.0f;
        this.f16016e = new AlphaAnimation(1.0f, 0.0f);
        this.f16017f = AnimationUtils.loadAnimation(getContext(), R$anim.anim_view_left_in);
        this.f16019h = new ArrayList();
        k(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveViewerEnterDefaultLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f16020i = new LinkedHashMap();
        this.f16013b = 23.0f;
        this.f16014c = 34.0f;
        this.f16015d = 45.0f;
        this.f16016e = new AlphaAnimation(1.0f, 0.0f);
        this.f16017f = AnimationUtils.loadAnimation(getContext(), R$anim.anim_view_left_in);
        this.f16019h = new ArrayList();
        k(context, attributeSet);
    }
}
