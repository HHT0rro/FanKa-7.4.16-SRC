package com.cupidapp.live.liveshow.view.comment;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.SensorScene;
import com.cupidapp.live.base.sensorslog.SensorsLogLiveShow;
import com.cupidapp.live.base.sensorslog.SensorsLogMatch;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.liveshow.adapter.FKLiveGiftMessageViewModel;
import com.cupidapp.live.liveshow.constants.FKLiveConstantsData;
import com.cupidapp.live.liveshow.model.GiftItemModel;
import com.cupidapp.live.liveshow.model.LiveShowModel;
import com.cupidapp.live.liveshow.view.giftpicker.fragment.OpenLiveGiftEvent;
import com.cupidapp.live.liveshow.view.label.LiveLabelListView;
import com.cupidapp.live.liveshow.view.miniprofile.ShowLiveMiniProfileViewModel;
import com.cupidapp.live.profile.model.User;
import com.cupidapp.live.track.group.GroupSocialLog;
import com.irisdt.client.live.LiveProtos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: FKLiveGiftMessageLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveGiftMessageLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    public boolean f15369b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String f15370c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public FKLiveGiftMessageViewModel f15371d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15372e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftMessageLayout(@NotNull Context context, boolean z10, @Nullable String str) {
        super(context);
        s.i(context, "context");
        this.f15372e = new LinkedHashMap();
        g(z10, str);
    }

    public static /* synthetic */ void h(FKLiveGiftMessageLayout fKLiveGiftMessageLayout, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        fKLiveGiftMessageLayout.g(z10, str);
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15372e;
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

    public final void d() {
        ConstraintLayout rootLayout = (ConstraintLayout) a(R$id.rootLayout);
        s.h(rootLayout, "rootLayout");
        y.d(rootLayout, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveGiftMessageLayout$bindClickEvent$1
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
                User sender;
                FKLiveGiftMessageViewModel giftMessageViewModel = FKLiveGiftMessageLayout.this.getGiftMessageViewModel();
                if (giftMessageViewModel == null || (sender = giftMessageViewModel.getSender()) == null) {
                    return;
                }
                GroupSocialLog.f18708a.u(SensorScene.Live.getValue(), sender.userId(), (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? false : false, (r13 & 16) != 0 ? null : null);
                EventBus.c().l(new ShowLiveMiniProfileViewModel(sender.userId(), SensorsLogMatch.AlohaGetPosition.SendGift, null, false, false, false, 52, null));
            }
        });
        ImageLoaderView giftImageView = (ImageLoaderView) a(R$id.giftImageView);
        s.h(giftImageView, "giftImageView");
        y.d(giftImageView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.comment.FKLiveGiftMessageLayout$bindClickEvent$2
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
                boolean z10;
                GiftItemModel giftModel;
                String str;
                z10 = FKLiveGiftMessageLayout.this.f15369b;
                if (z10) {
                    return;
                }
                FKLiveGiftMessageViewModel giftMessageViewModel = FKLiveGiftMessageLayout.this.getGiftMessageViewModel();
                if (giftMessageViewModel == null || (giftModel = giftMessageViewModel.getOriginalGift()) == null) {
                    FKLiveGiftMessageViewModel giftMessageViewModel2 = FKLiveGiftMessageLayout.this.getGiftMessageViewModel();
                    giftModel = giftMessageViewModel2 != null ? giftMessageViewModel2.getGiftModel() : null;
                }
                EventBus.c().l(new OpenLiveGiftEvent(giftModel != null ? giftModel.getItemId() : null, giftModel != null ? giftModel.getFenceId() : null, null, 4, null));
                LiveShowModel liveShowModel = FKLiveConstantsData.INSTANCE.getLiveShowModel();
                if (liveShowModel != null) {
                    FKLiveGiftMessageLayout fKLiveGiftMessageLayout = FKLiveGiftMessageLayout.this;
                    SensorsLogLiveShow sensorsLogLiveShow = SensorsLogLiveShow.f12212a;
                    String itemId = liveShowModel.getItemId();
                    String userId = liveShowModel.getUser().userId();
                    LiveProtos.Type type = LiveProtos.Type.COMMENT_GIFT;
                    str = fKLiveGiftMessageLayout.f15370c;
                    sensorsLogLiveShow.f(itemId, userId, type, (r13 & 8) != 0 ? null : str, (r13 & 16) != 0 ? null : null);
                }
            }
        });
    }

    public final void e(FKLiveGiftMessageViewModel fKLiveGiftMessageViewModel) {
        ArrayList arrayList;
        GradientDrawable.Orientation orientation;
        List z02;
        String backgroundColor = fKLiveGiftMessageViewModel.getBackgroundColor();
        if (backgroundColor == null || (z02 = StringsKt__StringsKt.z0(backgroundColor, new String[]{","}, false, 0, 6, null)) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(t.t(z02, 10));
            Iterator<E> iterator2 = z02.iterator2();
            while (iterator2.hasNext()) {
                arrayList2.add(Integer.valueOf(h.b((String) iterator2.next())));
            }
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            ((ConstraintLayout) a(R$id.rootLayout)).setBackgroundResource(R$drawable.gift_layout_bg);
        } else {
            String gradientDirection = fKLiveGiftMessageViewModel.getGradientDirection();
            if (s.d(gradientDirection, "LR")) {
                orientation = GradientDrawable.Orientation.LEFT_RIGHT;
            } else {
                orientation = s.d(gradientDirection, "TB") ? GradientDrawable.Orientation.TOP_BOTTOM : GradientDrawable.Orientation.LEFT_RIGHT;
            }
            GradientDrawable.Orientation orientation2 = orientation;
            ConstraintLayout rootLayout = (ConstraintLayout) a(R$id.rootLayout);
            s.h(rootLayout, "rootLayout");
            float c4 = z0.h.c(this, 8.0f);
            Integer valueOf = Integer.valueOf(z0.h.c(this, 1.0f));
            String borderColor = fKLiveGiftMessageViewModel.getBorderColor();
            y.i(rootLayout, (r18 & 1) != 0 ? 0.0f : c4, arrayList, (r18 & 4) != 0 ? GradientDrawable.Orientation.LEFT_RIGHT : orientation2, (r18 & 8) != 0 ? null : valueOf, (r18 & 16) != 0 ? null : borderColor != null ? Integer.valueOf(h.b(borderColor)) : null, (r18 & 32) != 0 ? 0.0f : 0.0f, (r18 & 64) != 0 ? 0.0f : 0.0f);
        }
        if (fKLiveGiftMessageViewModel.getLeftTopImage() != null) {
            int i10 = R$id.left_top_imageView;
            ImageLoaderView left_top_imageView = (ImageLoaderView) a(i10);
            s.h(left_top_imageView, "left_top_imageView");
            left_top_imageView.setVisibility(0);
            ImageLoaderView left_top_imageView2 = (ImageLoaderView) a(i10);
            s.h(left_top_imageView2, "left_top_imageView");
            ImageLoaderView.g(left_top_imageView2, fKLiveGiftMessageViewModel.getLeftTopImage(), null, null, 6, null);
        } else {
            ImageLoaderView left_top_imageView3 = (ImageLoaderView) a(R$id.left_top_imageView);
            s.h(left_top_imageView3, "left_top_imageView");
            left_top_imageView3.setVisibility(4);
        }
        if (fKLiveGiftMessageViewModel.getRightTopImage() != null) {
            int i11 = R$id.right_top_imageView;
            ImageLoaderView right_top_imageView = (ImageLoaderView) a(i11);
            s.h(right_top_imageView, "right_top_imageView");
            right_top_imageView.setVisibility(0);
            ImageLoaderView right_top_imageView2 = (ImageLoaderView) a(i11);
            s.h(right_top_imageView2, "right_top_imageView");
            ImageLoaderView.g(right_top_imageView2, fKLiveGiftMessageViewModel.getRightTopImage(), null, null, 6, null);
        } else {
            ImageLoaderView right_top_imageView3 = (ImageLoaderView) a(R$id.right_top_imageView);
            s.h(right_top_imageView3, "right_top_imageView");
            right_top_imageView3.setVisibility(4);
        }
        if (fKLiveGiftMessageViewModel.getLeftBottomImage() != null) {
            int i12 = R$id.left_bottom_imageView;
            ImageLoaderView left_bottom_imageView = (ImageLoaderView) a(i12);
            s.h(left_bottom_imageView, "left_bottom_imageView");
            left_bottom_imageView.setVisibility(0);
            ImageLoaderView left_bottom_imageView2 = (ImageLoaderView) a(i12);
            s.h(left_bottom_imageView2, "left_bottom_imageView");
            ImageLoaderView.g(left_bottom_imageView2, fKLiveGiftMessageViewModel.getLeftBottomImage(), null, null, 6, null);
        } else {
            ImageLoaderView left_bottom_imageView3 = (ImageLoaderView) a(R$id.left_bottom_imageView);
            s.h(left_bottom_imageView3, "left_bottom_imageView");
            left_bottom_imageView3.setVisibility(4);
        }
        if (fKLiveGiftMessageViewModel.getRightBottomImage() != null) {
            int i13 = R$id.right_bottom_imageView;
            ImageLoaderView right_bottom_imageView = (ImageLoaderView) a(i13);
            s.h(right_bottom_imageView, "right_bottom_imageView");
            right_bottom_imageView.setVisibility(0);
            ImageLoaderView right_bottom_imageView2 = (ImageLoaderView) a(i13);
            s.h(right_bottom_imageView2, "right_bottom_imageView");
            ImageLoaderView.g(right_bottom_imageView2, fKLiveGiftMessageViewModel.getRightBottomImage(), null, null, 6, null);
        } else {
            ImageLoaderView right_bottom_imageView3 = (ImageLoaderView) a(R$id.right_bottom_imageView);
            s.h(right_bottom_imageView3, "right_bottom_imageView");
            right_bottom_imageView3.setVisibility(4);
        }
        if (fKLiveGiftMessageViewModel.getRightTopImage() == null && fKLiveGiftMessageViewModel.getRightBottomImage() == null) {
            ConstraintLayout rootLayout2 = (ConstraintLayout) a(R$id.rootLayout);
            s.h(rootLayout2, "rootLayout");
            y.m(rootLayout2, null, null, 0, null, 11, null);
        } else {
            ConstraintLayout rootLayout3 = (ConstraintLayout) a(R$id.rootLayout);
            s.h(rootLayout3, "rootLayout");
            y.m(rootLayout3, null, null, Integer.valueOf(z0.h.c(this, 28.0f)), null, 11, null);
        }
    }

    public final void f(FKLiveGiftMessageViewModel fKLiveGiftMessageViewModel) {
        String desc;
        if (fKLiveGiftMessageViewModel == null) {
            return;
        }
        e(fKLiveGiftMessageViewModel);
        ImageLoaderView userAvatarView = (ImageLoaderView) a(R$id.userAvatarView);
        s.h(userAvatarView, "userAvatarView");
        User sender = fKLiveGiftMessageViewModel.getSender();
        ImageLoaderView.g(userAvatarView, sender != null ? sender.getAvatarImage() : null, null, null, 6, null);
        String desc2 = fKLiveGiftMessageViewModel.getDesc();
        if (desc2 == null || desc2.length() == 0) {
            desc = getContext().getString(R$string.have_send_some_gift, fKLiveGiftMessageViewModel.getGiftModel().getName());
        } else {
            desc = fKLiveGiftMessageViewModel.getDesc();
        }
        s.h(desc, "if (model.desc.isNullOrE…     model.desc\n        }");
        User sender2 = fKLiveGiftMessageViewModel.getSender();
        String str = z0.t.p(sender2 != null ? sender2.getName() : null, 8, null, 2, null) + "：";
        int a10 = this.f15369b ? -14522 : h.a(-1, 0.5f);
        LiveLabelListView live_gift_message_label_view = (LiveLabelListView) a(R$id.live_gift_message_label_view);
        s.h(live_gift_message_label_view, "live_gift_message_label_view");
        LiveLabelListView.o(live_gift_message_label_view, fKLiveGiftMessageViewModel.getLabelList(), i0.h(kotlin.f.a(str, Integer.valueOf(a10)), kotlin.f.a(desc, -1)), 11.0f, 0, false, 24, null);
        int c4 = z0.h.c(this, this.f15369b ? 38.0f : 34.0f);
        int i10 = R$id.giftImageView;
        ImageLoaderView giftImageView = (ImageLoaderView) a(i10);
        s.h(giftImageView, "giftImageView");
        y.o(giftImageView, Integer.valueOf(c4), null, 2, null);
        ImageLoaderView giftImageView2 = (ImageLoaderView) a(i10);
        s.h(giftImageView2, "giftImageView");
        ImageLoaderView.g(giftImageView2, fKLiveGiftMessageViewModel.getGiftModel().getImage(), null, null, 6, null);
        if (fKLiveGiftMessageViewModel.getCount() > 1) {
            int i11 = R$id.giftCountView;
            ((TextView) a(i11)).setVisibility(0);
            ((TextView) a(i11)).getPaint().setFakeBoldText(true);
            ((TextView) a(i11)).setText(getContext().getString(R$string.gift_count, Integer.valueOf(fKLiveGiftMessageViewModel.getCount())));
            return;
        }
        ((TextView) a(R$id.giftCountView)).setVisibility(8);
    }

    public final void g(boolean z10, String str) {
        this.f15369b = z10;
        this.f15370c = str;
        z.a(this, R$layout.recycler_item_gift_message, true);
        d();
    }

    @Nullable
    public final FKLiveGiftMessageViewModel getGiftMessageViewModel() {
        return this.f15371d;
    }

    public final void setGiftMessageViewModel(@Nullable FKLiveGiftMessageViewModel fKLiveGiftMessageViewModel) {
        this.f15371d = fKLiveGiftMessageViewModel;
        f(fKLiveGiftMessageViewModel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15372e = new LinkedHashMap();
        h(this, false, null, 3, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKLiveGiftMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15372e = new LinkedHashMap();
        h(this, false, null, 3, null);
    }
}
