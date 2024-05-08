package com.cupidapp.live.mediapicker.holder;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.mediapicker.adapter.AddImageViewModel;
import com.cupidapp.live.mediapicker.holder.ImageEditViewHolder;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: AddImageViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AddImageViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17247c = new a(null);

    /* compiled from: AddImageViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AddImageViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new AddImageViewHolder(z.b(parent, R$layout.view_holder_add_image, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddImageViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    public static final void t(AddImageViewHolder this$0, ValueAnimator animation) {
        s.i(this$0, "this$0");
        s.i(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Integer num = animatedValue instanceof Integer ? (Integer) animatedValue : null;
        if (num != null) {
            int intValue = num.intValue();
            View view = this$0.itemView;
            int i10 = R$id.addImageView;
            view.findViewById(i10).getLayoutParams().height = intValue;
            this$0.itemView.findViewById(i10).requestLayout();
        }
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof AddImageViewModel) {
            ImageEditViewHolder.a aVar = ImageEditViewHolder.f17252c;
            int c4 = (int) aVar.c(this.itemView.getContext());
            View view = this.itemView;
            int i10 = R$id.addImageContainerLayout;
            ViewGroup.LayoutParams layoutParams = ((FrameLayout) view.findViewById(i10)).getLayoutParams();
            layoutParams.width = aVar.e() + c4;
            layoutParams.height = aVar.a(this.itemView.getContext());
            ((FrameLayout) this.itemView.findViewById(i10)).setLayoutParams(layoutParams);
            View view2 = this.itemView;
            int i11 = R$id.addImageView;
            ViewGroup.LayoutParams layoutParams2 = view2.findViewById(i11).getLayoutParams();
            layoutParams2.width = c4;
            layoutParams2.height = (int) (c4 / ((AddImageViewModel) obj).getFrameSize());
            this.itemView.findViewById(i11).setLayoutParams(layoutParams2);
        }
    }

    public final void s(float f10) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.itemView.findViewById(R$id.addImageView).getHeight(), (int) (this.itemView.findViewById(r2).getWidth() / f10));
        ofInt.setDuration(200L);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.cupidapp.live.mediapicker.holder.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AddImageViewHolder.t(AddImageViewHolder.this, valueAnimator);
            }
        });
        ofInt.start();
    }
}
