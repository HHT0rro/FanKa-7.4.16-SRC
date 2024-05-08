package com.cupidapp.live.notify.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.view.RoundedFrameLayout;
import com.cupidapp.live.match.model.NearbyUserModel;
import com.cupidapp.live.notify.model.DailyHeartModel;
import java.util.Arrays;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: DailyHeartViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DailyHeartViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17574c = new a(null);

    /* compiled from: DailyHeartViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final DailyHeartViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new DailyHeartViewHolder(z.b(parent, R$layout.item_heart_beat, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyHeartViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof DailyHeartModel) {
            int l10 = (h.l(this) - h.c(this, 16.0f)) / 2;
            RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.daily_root);
            s.h(relativeLayout, "itemView.daily_root");
            y.n(relativeLayout, Integer.valueOf(l10), Integer.valueOf((l10 * 4) / 3));
            ((RoundedFrameLayout) this.itemView.findViewById(R$id.heartRootLayout)).setCornerRadius(h.c(this, 8.0f));
            DailyHeartModel dailyHeartModel = (DailyHeartModel) obj;
            NearbyUserModel fromUser = dailyHeartModel.getFromUser();
            if (dailyHeartModel.getMosaic()) {
                ((ImageView) this.itemView.findViewById(R$id.followImageButton)).setVisibility(8);
                ((ImageView) this.itemView.findViewById(R$id.lockImg)).setVisibility(0);
                this.itemView.findViewById(R$id.mask_view).setVisibility(0);
            } else {
                ((ImageView) this.itemView.findViewById(R$id.followImageButton)).setVisibility(0);
                ((ImageView) this.itemView.findViewById(R$id.lockImg)).setVisibility(8);
                this.itemView.findViewById(R$id.mask_view).setVisibility(8);
            }
            View view = this.itemView;
            int i10 = R$id.heartUserAge;
            TextView textView = (TextView) view.findViewById(i10);
            s.h(textView, "itemView.heartUserAge");
            u.a(textView);
            TextView textView2 = (TextView) this.itemView.findViewById(i10);
            String summaryInfo = fromUser.getSummaryInfo();
            boolean z10 = true;
            textView2.setText(summaryInfo == null || summaryInfo.length() == 0 ? "" : fromUser.getSummaryInfo());
            String remainTime = dailyHeartModel.getRemainTime();
            if (remainTime == null || remainTime.length() == 0) {
                ((TextView) this.itemView.findViewById(R$id.heart_remain_time_txt)).setVisibility(8);
            } else {
                View view2 = this.itemView;
                int i11 = R$id.heart_remain_time_txt;
                ((TextView) view2.findViewById(i11)).setVisibility(0);
                TextView textView3 = (TextView) this.itemView.findViewById(i11);
                kotlin.jvm.internal.y yVar = kotlin.jvm.internal.y.f51038a;
                String string = this.itemView.getContext().getString(R$string.remains);
                s.h(string, "itemView.context.getString(R.string.remains)");
                String format = String.format(string, Arrays.copyOf(new Object[]{dailyHeartModel.getRemainTime()}, 1));
                s.h(format, "format(format, *args)");
                textView3.setText(format);
            }
            String userSpecialLabel = fromUser.getUserSpecialLabel();
            if (userSpecialLabel != null && userSpecialLabel.length() != 0) {
                z10 = false;
            }
            if (z10) {
                ((TextView) this.itemView.findViewById(R$id.daily_like_tag)).setVisibility(4);
            } else {
                View view3 = this.itemView;
                int i12 = R$id.daily_like_tag;
                ((TextView) view3.findViewById(i12)).setVisibility(0);
                ((TextView) this.itemView.findViewById(i12)).setText(fromUser.getUserSpecialLabel());
            }
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.heartUserAvatarImageView);
            s.h(imageLoaderView, "itemView.heartUserAvatarImageView");
            ImageLoaderView.g(imageLoaderView, fromUser.getFaceAvatarImage(), null, null, 6, null);
        }
    }
}
