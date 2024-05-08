package com.cupidapp.live.mediapicker.holder;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.FloatRange;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderUtil;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.adapter.ImageEditViewModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.s;
import z0.z;

/* compiled from: ImageEditViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageEditViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17252c = new a(null);

    /* compiled from: ImageEditViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(@Nullable Context context) {
            s sVar = s.f54824a;
            return ((sVar.a() <= 0 ? h.k(this) : sVar.a()) - h.c(this, 218.0f)) - h.m(context);
        }

        public final float b(@Nullable Context context) {
            return c(context) + e();
        }

        public final float c(@Nullable Context context) {
            int a10 = a(context) - (h.c(this, 20.0f) * 2);
            float l10 = h.l(this) - h.c(this, 50.0f);
            return 0.75f > l10 / ((float) a10) ? l10 : (a10 * 3) / 4.0f;
        }

        @NotNull
        public final ImageEditViewHolder d(@NotNull ViewGroup parent) {
            kotlin.jvm.internal.s.i(parent, "parent");
            return new ImageEditViewHolder(z.b(parent, R$layout.view_holder_image_edit, false, 2, null));
        }

        public final int e() {
            return h.c(this, 12.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageEditViewHolder(@NotNull View itemView) {
        super(itemView);
        kotlin.jvm.internal.s.i(itemView, "itemView");
    }

    public static final void x(ImageEditViewHolder this$0, ValueAnimator animation) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        if (num != null) {
            int intValue = num.intValue();
            View view = this$0.itemView;
            int i10 = R$id.imageEditImageView;
            ((ImageLoaderView) view.findViewById(i10)).getLayoutParams().height = intValue;
            ((ImageLoaderView) this$0.itemView.findViewById(i10)).requestLayout();
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof ImageEditViewModel) {
            a aVar = f17252c;
            int c4 = (int) aVar.c(this.itemView.getContext());
            View view = this.itemView;
            int i10 = R$id.imageEditContainerLayout;
            ViewGroup.LayoutParams layoutParams = ((FrameLayout) view.findViewById(i10)).getLayoutParams();
            layoutParams.width = aVar.e() + c4;
            layoutParams.height = aVar.a(this.itemView.getContext());
            ((FrameLayout) this.itemView.findViewById(i10)).setLayoutParams(layoutParams);
            View view2 = this.itemView;
            int i11 = R$id.imageEditImageView;
            ViewGroup.LayoutParams layoutParams2 = ((ImageLoaderView) view2.findViewById(i11)).getLayoutParams();
            layoutParams2.width = c4;
            ImageEditViewModel imageEditViewModel = (ImageEditViewModel) obj;
            layoutParams2.height = (int) (c4 / imageEditViewModel.getFrameSize());
            ((ImageLoaderView) this.itemView.findViewById(i11)).setLayoutParams(layoutParams2);
            ImageLoaderUtil imageLoaderUtil = ImageLoaderUtil.f11832a;
            Context context = this.itemView.getContext();
            kotlin.jvm.internal.s.h(context, "itemView.context");
            imageLoaderUtil.d(context, imageEditViewModel.getPath(), new Function1<Drawable, p>() { // from class: com.cupidapp.live.mediapicker.holder.ImageEditViewHolder$config$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Drawable drawable) {
                    invoke2(drawable);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull Drawable it) {
                    kotlin.jvm.internal.s.i(it, "it");
                    ((ImageLoaderView) ImageEditViewHolder.this.itemView.findViewById(R$id.imageEditImageView)).setImageDrawable(it);
                }
            });
        }
    }

    public final void s(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        ((ImageLoaderView) this.itemView.findViewById(R$id.imageEditImageView)).setAlpha(f10);
    }

    public final void t(int i10) {
        ((ImageView) this.itemView.findViewById(R$id.imageTrimAndRotationImageView)).setVisibility(i10);
    }

    public final void u() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.itemView, View.SCALE_X, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.itemView, View.SCALE_Y, 1.2f, 1.0f);
        animatorSet.play(ofFloat).with(ofFloat2).with(ObjectAnimator.ofFloat((ImageLoaderView) this.itemView.findViewById(R$id.imageEditImageView), (Property<ImageLoaderView, Float>) View.ALPHA, 0.7f, 1.0f));
        animatorSet.setDuration(200L);
        animatorSet.start();
        t(0);
    }

    public final int v() {
        return (((FrameLayout) this.itemView.findViewById(R$id.imageEditContainerLayout)).getHeight() - ((ImageLoaderView) this.itemView.findViewById(R$id.imageEditImageView)).getHeight()) / 2;
    }

    public final void w(float f10) {
        ValueAnimator ofInt = ValueAnimator.ofInt(((ImageLoaderView) this.itemView.findViewById(R$id.imageEditImageView)).getHeight(), (int) (((ImageLoaderView) this.itemView.findViewById(r2)).getWidth() / f10));
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.mediapicker.holder.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ImageEditViewHolder.x(ImageEditViewHolder.this, valueAnimator);
            }
        });
        ofInt.start();
    }

    public final void y() {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.itemView, View.SCALE_X, 1.0f, 1.2f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.itemView, View.SCALE_Y, 1.0f, 1.2f);
        animatorSet.play(ofFloat).with(ofFloat2).with(ObjectAnimator.ofFloat((ImageLoaderView) this.itemView.findViewById(R$id.imageEditImageView), (Property<ImageLoaderView, Float>) View.ALPHA, 1.0f, 0.7f));
        animatorSet.setDuration(200L);
        animatorSet.start();
    }
}
