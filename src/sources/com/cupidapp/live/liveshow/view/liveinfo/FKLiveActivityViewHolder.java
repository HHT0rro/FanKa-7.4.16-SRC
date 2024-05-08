package com.cupidapp.live.liveshow.view.liveinfo;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.liveshow.model.LiveActivityModel;
import kotlin.collections.r;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: FKLiveShowActivityLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveActivityViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15704c = new a(null);

    /* compiled from: FKLiveShowActivityLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveActivityViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKLiveActivityViewHolder(z.b(parent, R$layout.view_holder_live_show_activity, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveActivityViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
        int i10 = R$id.activity_textview;
        ((TextView) itemView.findViewById(i10)).getPaint().setFakeBoldText(true);
        TextView textView = (TextView) itemView.findViewById(i10);
        s.h(textView, "itemView.activity_textview");
        u.f(textView, 13);
        ((TextView) itemView.findViewById(R$id.activity_badge_textview)).getPaint().setFakeBoldText(true);
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof LiveActivityModel) {
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.activity_imageview);
            s.h(imageLoaderView, "itemView.activity_imageview");
            LiveActivityModel liveActivityModel = (LiveActivityModel) obj;
            ImageLoaderView.g(imageLoaderView, liveActivityModel.getIconImage(), null, null, 6, null);
            View view = this.itemView;
            int i10 = R$id.activity_textview;
            ((TextView) view.findViewById(i10)).setText(liveActivityModel.getText());
            ((TextView) this.itemView.findViewById(i10)).setTextColor(h.b(liveActivityModel.getTextColor()));
            String badge = liveActivityModel.getBadge();
            if (!(badge == null || badge.length() == 0)) {
                View view2 = this.itemView;
                int i11 = R$id.activity_badge_textview;
                TextView textView = (TextView) view2.findViewById(i11);
                s.h(textView, "itemView.activity_badge_textview");
                textView.setVisibility(0);
                ((TextView) this.itemView.findViewById(i11)).setText(liveActivityModel.getBadge());
                ((TextView) this.itemView.findViewById(i11)).setTextColor(h.b(liveActivityModel.getBadgeColor()));
                TextView textView2 = (TextView) this.itemView.findViewById(i11);
                s.h(textView2, "itemView.activity_badge_textview");
                y.i(textView2, (r18 & 1) != 0 ? 0.0f : 1000.0f, r.e(Integer.valueOf(h.b(liveActivityModel.getBadgeBgColor()))), (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : null, (r18 & 8) != 0 ? null : Integer.valueOf(z0.h.c(this, 2.0f)), (r18 & 16) != 0 ? null : Integer.valueOf(h.b(liveActivityModel.getBadgeColor())), (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
                return;
            }
            TextView textView3 = (TextView) this.itemView.findViewById(R$id.activity_badge_textview);
            s.h(textView3, "itemView.activity_badge_textview");
            textView3.setVisibility(8);
        }
    }
}
