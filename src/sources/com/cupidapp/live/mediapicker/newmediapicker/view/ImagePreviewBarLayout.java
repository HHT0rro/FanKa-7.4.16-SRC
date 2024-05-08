package com.cupidapp.live.mediapicker.newmediapicker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$anim;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.mediapicker.newmediapicker.adapter.ImagePreviewBarAdapter;
import com.cupidapp.live.mediapicker.newmediapicker.data.ImagePickedData;
import com.cupidapp.live.mediapicker.newmediapicker.model.LocalMediaPicked;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ImagePreviewBarLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImagePreviewBarLayout extends RelativeLayout {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public Function0<p> f17369b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public Function2<? super LocalMediaPicked, ? super Integer, p> f17370c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public ImagePreviewBarAdapter f17371d;

    /* renamed from: e, reason: collision with root package name */
    public int f17372e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17373f;

    /* compiled from: ImagePreviewBarLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a {
        void onFinish();
    }

    /* compiled from: ImagePreviewBarLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f17375b;

        public b(a aVar) {
            this.f17375b = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            s.i(animation, "animation");
            ImagePreviewBarLayout.this.setEnabled(true);
            ImagePreviewBarLayout.this.setVisibility(8);
            a aVar = this.f17375b;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            s.i(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            s.i(animation, "animation");
            ImagePreviewBarLayout.this.setEnabled(false);
        }
    }

    /* compiled from: ImagePreviewBarLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f17377b;

        public c(a aVar) {
            this.f17377b = aVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@NotNull Animation animation) {
            s.i(animation, "animation");
            ImagePreviewBarLayout.this.setEnabled(true);
            a aVar = this.f17377b;
            if (aVar != null) {
                aVar.onFinish();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@NotNull Animation animation) {
            s.i(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@NotNull Animation animation) {
            s.i(animation, "animation");
            ImagePreviewBarLayout.this.setEnabled(false);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImagePreviewBarLayout(@NotNull Context context) {
        this(context, null, 0);
        s.i(context, "context");
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f17373f;
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

    public final void b(@Nullable a aVar) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.anim_activity_top_to_bottom);
        loadAnimation.setDuration(200L);
        loadAnimation.setAnimationListener(new b(aVar));
        startAnimation(loadAnimation);
    }

    public final void c() {
        z.a(this, R$layout.layout_preview_image_bar, true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(0);
        int i10 = R$id.previewImageRecycler;
        ((RecyclerView) a(i10)).setLayoutManager(linearLayoutManager);
        ((RecyclerView) a(i10)).setAdapter(this.f17371d);
        Button previewComplete = (Button) a(R$id.previewComplete);
        s.h(previewComplete, "previewComplete");
        y.d(previewComplete, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.view.ImagePreviewBarLayout$initView$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                Function0<p> completeClick = ImagePreviewBarLayout.this.getCompleteClick();
                if (completeClick != null) {
                    completeClick.invoke();
                }
            }
        });
        RelativeLayout previewImageBarBg = (RelativeLayout) a(R$id.previewImageBarBg);
        s.h(previewImageBarBg, "previewImageBarBg");
        y.d(previewImageBarBg, new Function1<View, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.view.ImagePreviewBarLayout$initView$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(View view) {
                invoke2(view);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
            }
        });
        this.f17371d.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.mediapicker.newmediapicker.view.ImagePreviewBarLayout$initView$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof LocalMediaPicked) {
                    int index = ImagePickedData.INSTANCE.index(((LocalMediaPicked) obj).getMedia());
                    Function2<LocalMediaPicked, Integer, p> itemClick = ImagePreviewBarLayout.this.getItemClick();
                    if (itemClick != null) {
                        itemClick.mo1743invoke(obj, Integer.valueOf(index));
                    }
                }
            }
        });
    }

    public final void d(@Nullable a aVar) {
        setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R$anim.anim_activity_bottom_to_top);
        loadAnimation.setDuration(200L);
        loadAnimation.setAnimationListener(new c(aVar));
        startAnimation(loadAnimation);
    }

    public final void e(int i10) {
        this.f17371d.j().clear();
        ImagePickedData imagePickedData = ImagePickedData.INSTANCE;
        if (imagePickedData.size() > 0) {
            this.f17371d.e(imagePickedData.getList());
            this.f17371d.notifyDataSetChanged();
            if (i10 > -1) {
                ((RecyclerView) a(R$id.previewImageRecycler)).scrollToPosition(i10);
            }
        }
    }

    @NotNull
    public final ImagePreviewBarAdapter getAdapter() {
        return this.f17371d;
    }

    public final int getCheckedIndex() {
        return this.f17372e;
    }

    @Nullable
    public final Function0<p> getCompleteClick() {
        return this.f17369b;
    }

    @Nullable
    public final Function2<LocalMediaPicked, Integer, p> getItemClick() {
        return this.f17370c;
    }

    public final void setAdapter(@NotNull ImagePreviewBarAdapter imagePreviewBarAdapter) {
        s.i(imagePreviewBarAdapter, "<set-?>");
        this.f17371d = imagePreviewBarAdapter;
    }

    public final void setBackground(int i10) {
        ((RelativeLayout) a(R$id.previewImageBarBg)).setBackgroundColor(i10);
    }

    public final void setCheckedIndex(int i10) {
        this.f17372e = i10;
    }

    public final void setCheckedItem(@Nullable Integer num) {
        if (num != null) {
            num.intValue();
            if (this.f17372e != num.intValue()) {
                this.f17372e = num.intValue();
                this.f17371d.v(num.intValue());
                this.f17371d.notifyDataSetChanged();
            }
        }
    }

    public final void setCompleteClick(@Nullable Function0<p> function0) {
        this.f17369b = function0;
    }

    public final void setCompleteText(@NotNull String text) {
        s.i(text, "text");
        ((Button) a(R$id.previewComplete)).setText(text);
    }

    public final void setItemClick(@Nullable Function2<? super LocalMediaPicked, ? super Integer, p> function2) {
        this.f17370c = function2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImagePreviewBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        s.i(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePreviewBarLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f17373f = new LinkedHashMap();
        this.f17371d = new ImagePreviewBarAdapter();
        this.f17372e = -1;
        c();
    }
}
