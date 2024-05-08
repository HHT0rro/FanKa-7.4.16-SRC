package com.cupidapp.live.maskparty.helper;

import android.view.ViewGroup;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.maskparty.holder.MaskPartyChatDiceViewHolder;
import com.cupidapp.live.maskparty.holder.MaskPartyChatImageViewHolder;
import com.cupidapp.live.maskparty.holder.MaskPartyChatNotifyViewHolder;
import com.cupidapp.live.maskparty.holder.MaskPartyChatSnapImageViewHolder;
import com.cupidapp.live.maskparty.holder.MaskPartyChatTextViewHolder;
import com.cupidapp.live.maskparty.holder.MaskPartyChatUserInfoUiModel;
import com.cupidapp.live.maskparty.holder.MaskPartyChatUserInfoViewHolder;
import com.cupidapp.live.maskparty.holder.PublicProfileModel;
import com.cupidapp.live.maskparty.holder.ScriptCompleteTaskViewHolder;
import com.cupidapp.live.maskparty.holder.ScriptKillPromptModel;
import com.cupidapp.live.maskparty.holder.ScriptKillViewHolder;
import com.cupidapp.live.maskparty.holder.ScriptPublicProfileViewHolder;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageType;
import com.cupidapp.live.maskparty.model.ScriptTaskScoreModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.s;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyChatTypeRegistry.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatTypeRegistry {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MaskPartyChatTypeRegistry f16339a = new MaskPartyChatTypeRegistry();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final List<MaskPartyChatItemViewTypeModel> f16340b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final Lazy f16341c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final Lazy f16342d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final Lazy f16343e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final Lazy f16344f;

    static {
        MaskPartyChatMessageType maskPartyChatMessageType = MaskPartyChatMessageType.InboxMessageText;
        MaskPartyChatTextViewHolder.a aVar = MaskPartyChatTextViewHolder.f16358d;
        MaskPartyChatMessageType maskPartyChatMessageType2 = MaskPartyChatMessageType.InboxMessageImage;
        MaskPartyChatImageViewHolder.a aVar2 = MaskPartyChatImageViewHolder.f16354d;
        MaskPartyChatMessageType maskPartyChatMessageType3 = MaskPartyChatMessageType.InboxMessageSnapImage;
        MaskPartyChatSnapImageViewHolder.a aVar3 = MaskPartyChatSnapImageViewHolder.f16357d;
        MaskPartyChatMessageType maskPartyChatMessageType4 = MaskPartyChatMessageType.InboxMessageNotice;
        MaskPartyChatNotifyViewHolder.a aVar4 = MaskPartyChatNotifyViewHolder.f16355d;
        MaskPartyChatMessageType maskPartyChatMessageType5 = MaskPartyChatMessageType.InboxMessageDice;
        MaskPartyChatDiceViewHolder.a aVar5 = MaskPartyChatDiceViewHolder.f16353d;
        f16340b = s.m(new MaskPartyChatItemViewTypeModel(maskPartyChatMessageType, true, aVar), new MaskPartyChatItemViewTypeModel(maskPartyChatMessageType, false, aVar), new MaskPartyChatItemViewTypeModel(maskPartyChatMessageType2, true, aVar2), new MaskPartyChatItemViewTypeModel(maskPartyChatMessageType2, false, aVar2), new MaskPartyChatItemViewTypeModel(maskPartyChatMessageType3, true, aVar3), new MaskPartyChatItemViewTypeModel(maskPartyChatMessageType3, false, aVar3), new MaskPartyChatItemViewTypeModel(maskPartyChatMessageType4, true, aVar4), new MaskPartyChatItemViewTypeModel(maskPartyChatMessageType4, false, aVar4), new MaskPartyChatItemViewTypeModel(maskPartyChatMessageType5, true, aVar5), new MaskPartyChatItemViewTypeModel(maskPartyChatMessageType5, false, aVar5));
        f16341c = c.b(new Function0<Integer>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyChatTypeRegistry$userInfoViewTypeCode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                List list;
                list = MaskPartyChatTypeRegistry.f16340b;
                return Integer.valueOf(list.size());
            }
        });
        f16342d = c.b(new Function0<Integer>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyChatTypeRegistry$scriptKillPromptViewTypeCode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                List list;
                list = MaskPartyChatTypeRegistry.f16340b;
                return Integer.valueOf(list.size() + 1);
            }
        });
        f16343e = c.b(new Function0<Integer>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyChatTypeRegistry$scriptCompleteTaskViewTypeCode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                List list;
                list = MaskPartyChatTypeRegistry.f16340b;
                return Integer.valueOf(list.size() + 2);
            }
        });
        f16344f = c.b(new Function0<Integer>() { // from class: com.cupidapp.live.maskparty.helper.MaskPartyChatTypeRegistry$scriptPublicProfileViewTypeCode$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                List list;
                list = MaskPartyChatTypeRegistry.f16340b;
                return Integer.valueOf(list.size() + 3);
            }
        });
    }

    public final int b(@NotNull Object model) {
        kotlin.jvm.internal.s.i(model, "model");
        if (model instanceof MaskPartyChatMessageModel) {
            Iterator<MaskPartyChatItemViewTypeModel> iterator2 = f16340b.iterator2();
            int i10 = 0;
            while (true) {
                if (!iterator2.hasNext()) {
                    i10 = -1;
                    break;
                }
                MaskPartyChatItemViewTypeModel next = iterator2.next();
                MaskPartyChatMessageModel maskPartyChatMessageModel = (MaskPartyChatMessageModel) model;
                if (kotlin.jvm.internal.s.d(next.getType().getValue(), maskPartyChatMessageModel.getType()) && next.isMe() == maskPartyChatMessageModel.getMine()) {
                    break;
                }
                i10++;
            }
            if (i10 >= 0 && i10 < f16340b.size()) {
                return i10;
            }
            throw new IllegalStateException(("MaskPartyChatTypeRegistry getItemViewTypeCode, index:" + i10 + " totalCount:" + f16340b.size()).toString());
        }
        if (model instanceof MaskPartyChatUserInfoUiModel) {
            return f();
        }
        if (model instanceof ScriptKillPromptModel) {
            return d();
        }
        if (model instanceof ScriptTaskScoreModel) {
            return c();
        }
        if (model instanceof PublicProfileModel) {
            return e();
        }
        throw new IllegalStateException(("MaskPartyChatTypeRegistry getItemViewTypeCode model is not MaskPartyChatMessageModel, model:" + model).toString());
    }

    public final int c() {
        return ((Number) f16343e.getValue()).intValue();
    }

    public final int d() {
        return ((Number) f16342d.getValue()).intValue();
    }

    public final int e() {
        return ((Number) f16344f.getValue()).intValue();
    }

    public final int f() {
        return ((Number) f16341c.getValue()).intValue();
    }

    @NotNull
    public final FKBaseRecyclerViewHolder g(@NotNull ViewGroup parent, int i10) {
        kotlin.jvm.internal.s.i(parent, "parent");
        if (i10 == f()) {
            return MaskPartyChatUserInfoViewHolder.f16359c.a(parent);
        }
        if (i10 == d()) {
            return ScriptKillViewHolder.f16361c.a(parent);
        }
        if (i10 == c()) {
            return ScriptCompleteTaskViewHolder.f16360c.a(parent);
        }
        if (i10 == e()) {
            return ScriptPublicProfileViewHolder.f16362c.a(parent);
        }
        MaskPartyChatItemViewTypeModel maskPartyChatItemViewTypeModel = f16340b.get(i10);
        return maskPartyChatItemViewTypeModel.getFactory().a(parent, maskPartyChatItemViewTypeModel.isMe());
    }
}
