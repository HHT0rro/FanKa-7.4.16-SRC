package com.cupidapp.live.profile.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.imageloader.BlurModel;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.match.helper.FloatAvatarHelper;
import com.cupidapp.live.profile.model.NearByGuideModel;
import com.cupidapp.live.profile.model.NearByGuideUserModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.z;

/* compiled from: NearByGuideViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearByGuideViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f17812d = new a(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final FloatAvatarHelper<NearByGuideUserModel> f17813c;

    /* compiled from: NearByGuideViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final NearByGuideViewHolder a(@NotNull ViewGroup parent, @NotNull FloatAvatarHelper<NearByGuideUserModel> animHelper) {
            s.i(parent, "parent");
            s.i(animHelper, "animHelper");
            return new NearByGuideViewHolder(z.b(parent, R$layout.item_nearby_guide, false, 2, null), animHelper);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NearByGuideViewHolder(@NotNull View itemView, @NotNull FloatAvatarHelper<NearByGuideUserModel> animHelper) {
        super(itemView);
        s.i(itemView, "itemView");
        s.i(animHelper, "animHelper");
        this.f17813c = animHelper;
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof NearByGuideModel) {
            NearByGuideModel nearByGuideModel = (NearByGuideModel) obj;
            ((TextView) this.itemView.findViewById(R$id.near_by_guide_des)).setText(nearByGuideModel.getSubtitle());
            List<NearByGuideUserModel> list = nearByGuideModel.getList();
            if (list == null || list.isEmpty()) {
                return;
            }
            TextView textView = (TextView) this.itemView.findViewById(R$id.near_by_guide_distance);
            if (textView != null) {
                u.a(textView);
            }
            this.f17813c.k(nearByGuideModel.getList(), (ImageLoaderView) this.itemView.findViewById(R$id.near_guide_firstAvatarImg), (ImageLoaderView) this.itemView.findViewById(R$id.near_guide_secondAvatarImg), new Function2<NearByGuideUserModel, NearByGuideUserModel, p>() { // from class: com.cupidapp.live.profile.holder.NearByGuideViewHolder$config$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(NearByGuideUserModel nearByGuideUserModel, NearByGuideUserModel nearByGuideUserModel2) {
                    invoke2(nearByGuideUserModel, nearByGuideUserModel2);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull NearByGuideUserModel firstData, @NotNull NearByGuideUserModel secondData) {
                    s.i(firstData, "firstData");
                    s.i(secondData, "secondData");
                    ImageLoaderView imageLoaderView = (ImageLoaderView) NearByGuideViewHolder.this.itemView.findViewById(R$id.near_guide_firstAvatarImg);
                    if (imageLoaderView != null) {
                        ImageLoaderView.g(imageLoaderView, firstData.getAvatarImage(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(4.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
                    }
                    ImageLoaderView imageLoaderView2 = (ImageLoaderView) NearByGuideViewHolder.this.itemView.findViewById(R$id.near_guide_secondAvatarImg);
                    if (imageLoaderView2 != null) {
                        ImageLoaderView.g(imageLoaderView2, secondData.getAvatarImage(), new b(false, null, null, null, null, null, null, 0, 0, null, null, null, new BlurModel(4.0f, 0, 2, null), false, 0, 0, false, null, null, 520191, null), null, 4, null);
                    }
                    TextView textView2 = (TextView) NearByGuideViewHolder.this.itemView.findViewById(R$id.near_by_guide_distance);
                    if (textView2 == null) {
                        return;
                    }
                    textView2.setText(firstData.getDistanceDes());
                }
            });
        }
    }
}
