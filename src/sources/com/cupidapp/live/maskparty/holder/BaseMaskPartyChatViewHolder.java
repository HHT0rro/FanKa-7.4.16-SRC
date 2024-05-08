package com.cupidapp.live.maskparty.holder;

import android.view.View;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.utils.PopupWindowLocationModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageBindLongClickEvent;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyLongClickActionType;
import com.cupidapp.live.maskparty.model.MessageActionType;
import com.cupidapp.live.maskparty.view.MaskPartyChatMessageStateView;
import com.cupidapp.live.maskparty.view.MaskPartyChatTimeStampView;
import com.cupidapp.live.profile.model.User;
import com.google.android.material.badge.BadgeDrawable;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;

/* compiled from: BaseMaskPartyChatViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class BaseMaskPartyChatViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f16352c = new a(null);

    /* compiled from: BaseMaskPartyChatViewHolder.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseMaskPartyChatViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    public static final boolean t(MaskPartyChatMessageModel model, BaseMaskPartyChatViewHolder this$0, View view, View view2) {
        s.i(model, "$model");
        s.i(this$0, "this$0");
        s.i(view, "$view");
        if (model.getActionType() == MessageActionType.AutoInsertSysMessage) {
            return true;
        }
        ArrayList<MaskPartyLongClickActionType> u10 = this$0.u(model);
        if (!(u10 == null || u10.isEmpty())) {
            EventBus.c().l(new MaskPartyChatMessageBindLongClickEvent(u10, model, this$0.z(view, model.getMine())));
        }
        return true;
    }

    @Nullable
    public abstract MaskPartyChatMessageStateView A();

    @Nullable
    public abstract MaskPartyChatTimeStampView B();

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MaskPartyChatMessageModel) {
            MaskPartyChatMessageModel maskPartyChatMessageModel = (MaskPartyChatMessageModel) obj;
            if (maskPartyChatMessageModel.getMine()) {
                x(maskPartyChatMessageModel);
                MaskPartyChatMessageStateView A = A();
                if (A != null) {
                    A.a(maskPartyChatMessageModel);
                    return;
                }
                return;
            }
            ImageLoaderView y10 = y();
            if (y10 != null) {
                User sender = maskPartyChatMessageModel.getSender();
                ImageLoaderView.g(y10, sender != null ? sender.getMaskOrRealAvatarImage(maskPartyChatMessageModel.getMask()) : null, null, null, 6, null);
            }
            w(maskPartyChatMessageModel);
        }
    }

    public final void s(@NotNull final View view, @NotNull final MaskPartyChatMessageModel model) {
        s.i(view, "view");
        s.i(model, "model");
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.cupidapp.live.maskparty.holder.a
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean t2;
                t2 = BaseMaskPartyChatViewHolder.t(MaskPartyChatMessageModel.this, this, view, view2);
                return t2;
            }
        });
    }

    @Nullable
    public abstract ArrayList<MaskPartyLongClickActionType> u(@NotNull MaskPartyChatMessageModel maskPartyChatMessageModel);

    public final void v(long j10, long j11) {
        MaskPartyChatTimeStampView B = B();
        if (B == null) {
            return;
        }
        if (j10 - j11 > TTAdConstant.AD_MAX_EVENT_TIME) {
            B.setVisibility(0);
            B.setTimeStamp(j10);
        } else {
            B.setVisibility(8);
        }
    }

    public abstract void w(@NotNull MaskPartyChatMessageModel maskPartyChatMessageModel);

    public abstract void x(@NotNull MaskPartyChatMessageModel maskPartyChatMessageModel);

    @Nullable
    public abstract ImageLoaderView y();

    public final PopupWindowLocationModel z(View view, boolean z10) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new PopupWindowLocationModel(view, z10 ? BadgeDrawable.TOP_END : BadgeDrawable.TOP_START, new Pair(Integer.valueOf(z10 ? h.c(this, 16.0f) : iArr[0]), Integer.valueOf(iArr[1])));
    }
}
