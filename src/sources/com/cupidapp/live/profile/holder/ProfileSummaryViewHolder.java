package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ImageModel;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.profile.model.ProfileMBTIModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.y;
import z0.z;

/* compiled from: ProfileSummaryViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ProfileSummaryViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f17829c = new a(null);

    /* compiled from: ProfileSummaryViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final ProfileSummaryViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            ProfileSummaryViewHolder profileSummaryViewHolder = new ProfileSummaryViewHolder(z.b(parent, R$layout.view_holder_profile_summary, false, 2, null));
            profileSummaryViewHolder.q();
            return profileSummaryViewHolder;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileSummaryViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00a1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0076 A[SYNTHETIC] */
    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void n(@org.jetbrains.annotations.Nullable java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.profile.holder.ProfileSummaryViewHolder.n(java.lang.Object):void");
    }

    public final void r(String str, Integer num, ImageModel imageModel) {
        View view = this.itemView;
        int i10 = R$id.profileInfoLinearLayout;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(i10);
        s.h(linearLayout, "itemView.profileInfoLinearLayout");
        View b4 = z.b(linearLayout, R$layout.layout_profile_summary_spec_item, false, 2, null);
        int i11 = R$id.specContentTextView;
        ((TextView) b4.findViewById(i11)).setText(str);
        ((TextView) b4.findViewById(i11)).getPaint().setFakeBoldText(true);
        if (num != null) {
            ((ImageLoaderView) b4.findViewById(R$id.specIconImageView)).setImageResource(num.intValue());
        } else {
            ImageLoaderView imageLoaderView = (ImageLoaderView) b4.findViewById(R$id.specIconImageView);
            s.h(imageLoaderView, "itemLayout.specIconImageView");
            ImageLoaderView.g(imageLoaderView, imageModel, null, null, 6, null);
        }
        ((LinearLayout) this.itemView.findViewById(i10)).addView(b4);
    }

    public final void s(List<ProfileMBTIModel> list) {
        if (list == null || list.isEmpty()) {
            ((HorizontalScrollView) this.itemView.findViewById(R$id.mbti_scroll_view)).setVisibility(8);
            return;
        }
        ((HorizontalScrollView) this.itemView.findViewById(R$id.mbti_scroll_view)).setVisibility(0);
        ((LinearLayout) this.itemView.findViewById(R$id.mbti_container_layout)).removeAllViews();
        int i10 = 0;
        for (ProfileMBTIModel profileMBTIModel : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            final ProfileMBTIModel profileMBTIModel2 = profileMBTIModel;
            View view = this.itemView;
            int i12 = R$id.mbti_container_layout;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(i12);
            s.h(linearLayout, "itemView.mbti_container_layout");
            View b4 = z.b(linearLayout, R$layout.layout_profile_mbti_item, false, 2, null);
            ImageLoaderView mbti_img = (ImageLoaderView) b4.findViewById(R$id.mbti_img);
            s.h(mbti_img, "mbti_img");
            ImageLoaderView.g(mbti_img, profileMBTIModel2.getIcon(), null, null, 6, null);
            ((TextView) b4.findViewById(R$id.mbti_title_txt)).setText(profileMBTIModel2.getTitle());
            ((TextView) b4.findViewById(R$id.mbti_subtitle_txt)).setText(profileMBTIModel2.getSubtitle());
            y.d(b4, new Function1<View, p>() { // from class: com.cupidapp.live.profile.holder.ProfileSummaryViewHolder$configMBTILayout$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view2) {
                    invoke2(view2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view2) {
                    j.a.b(j.f12156c, ProfileSummaryViewHolder.this.itemView.getContext(), profileMBTIModel2.getJumpUrl(), null, 4, null);
                }
            });
            ((LinearLayout) this.itemView.findViewById(i12)).addView(b4);
            if (i10 == 0) {
                y.l(b4, Integer.valueOf(h.c(this, 16.0f)), 0, Integer.valueOf(h.c(this, 6.0f)), 0);
            } else if (i10 == list.size() - 1) {
                y.l(b4, Integer.valueOf(h.c(this, 6.0f)), 0, Integer.valueOf(h.c(this, 16.0f)), 0);
            } else {
                y.l(b4, Integer.valueOf(h.c(this, 6.0f)), 0, Integer.valueOf(h.c(this, 6.0f)), 0);
            }
            i10 = i11;
        }
    }
}
