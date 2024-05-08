package com.cupidapp.live.liveshow.view.label;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.network.gson.BaseLiveShowTagModel;
import com.cupidapp.live.base.network.gson.FanClubTagModel;
import com.cupidapp.live.base.network.gson.LiveShowTagModel;
import com.cupidapp.live.base.network.gson.LiveShowTagType;
import com.cupidapp.live.base.utils.ImageWithHeightModel;
import com.cupidapp.live.base.utils.NetWorkDrawableHelper;
import com.cupidapp.live.liveshow.view.FanClubMedalView;
import com.cupidapp.live.profile.model.FansClubMedalModel;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.u;
import z0.y;

/* compiled from: LiveLabelListView.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveLabelListView extends FrameLayout {

    /* renamed from: b */
    @NotNull
    public final String f15684b;

    /* renamed from: c */
    @Nullable
    public Integer f15685c;

    /* renamed from: d */
    @Nullable
    public FansClubMedalModel f15686d;

    /* renamed from: e */
    @Nullable
    public Drawable f15687e;

    /* renamed from: f */
    @NotNull
    public Map<Integer, Drawable> f15688f;

    /* renamed from: g */
    @NotNull
    public Map<Integer, View> f15689g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLabelListView(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15689g = new LinkedHashMap();
        this.f15684b = "翻咔 ";
        this.f15688f = new LinkedHashMap();
    }

    public static final void l(FanClubMedalView clubMedalView, LiveLabelListView this$0, View view, Map map, SpannableStringBuilder builder, TextView textView) {
        s.i(this$0, "this$0");
        s.i(builder, "$builder");
        s.i(textView, "$textView");
        s.h(clubMedalView, "clubMedalView");
        Bitmap e2 = y.e(clubMedalView);
        if (e2 != null) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this$0.getContext().getResources(), e2);
            bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
            Integer num = this$0.f15685c;
            if (num != null) {
                this$0.f15688f.put(Integer.valueOf(num.intValue()), bitmapDrawable);
            }
        }
        this$0.removeView(view);
        this$0.i(map, builder, textView);
    }

    public static /* synthetic */ void o(LiveLabelListView liveLabelListView, List list, Map map, float f10, int i10, boolean z10, int i11, Object obj) {
        liveLabelListView.n(list, map, (i11 & 4) != 0 ? 11.0f : f10, (i11 & 8) != 0 ? Integer.MAX_VALUE : i10, (i11 & 16) != 0 ? false : z10);
    }

    public static final void p(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void q(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void i(Map<String, Integer> map, SpannableStringBuilder spannableStringBuilder, TextView textView) {
        Iterator<Map.Entry<Integer, Drawable>> iterator2 = this.f15688f.entrySet().iterator2();
        while (iterator2.hasNext()) {
            Drawable value = iterator2.next().getValue();
            if (value != null) {
                m(value, spannableStringBuilder);
            }
        }
        j(map, spannableStringBuilder, textView);
    }

    public final void j(Map<String, Integer> map, SpannableStringBuilder spannableStringBuilder, TextView textView) {
        if (map != null) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String key = entry.getKey();
                int intValue = entry.getValue().intValue();
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) key);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(intValue), length, spannableStringBuilder.length(), 17);
            }
        }
        textView.setText(spannableStringBuilder);
    }

    public final void k(final Map<String, Integer> map, final SpannableStringBuilder spannableStringBuilder, final TextView textView) {
        if (this.f15686d != null && this.f15687e != null) {
            final View inflate = LayoutInflater.from(getContext()).inflate(R$layout.layout_fan_club_medal_view, (ViewGroup) null);
            final FanClubMedalView fanClubMedalView = (FanClubMedalView) inflate.findViewById(R$id.fan_club_medal_view);
            FansClubMedalModel fansClubMedalModel = this.f15686d;
            s.f(fansClubMedalModel);
            Drawable drawable = this.f15687e;
            s.f(drawable);
            fanClubMedalView.b(fansClubMedalModel, drawable);
            addView(inflate);
            fanClubMedalView.post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.label.c
                @Override // java.lang.Runnable
                public final void run() {
                    LiveLabelListView.l(FanClubMedalView.this, this, inflate, map, spannableStringBuilder, textView);
                }
            });
            return;
        }
        i(map, spannableStringBuilder, textView);
    }

    public final void m(Drawable drawable, SpannableStringBuilder spannableStringBuilder) {
        com.cupidapp.live.base.view.a aVar = new com.cupidapp.live.base.view.a(drawable);
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) this.f15684b);
        spannableStringBuilder.setSpan(aVar, length, length + 2, 17);
    }

    public final void n(@Nullable List<? extends BaseLiveShowTagModel> list, @Nullable final Map<String, Integer> map, float f10, int i10, boolean z10) {
        r();
        removeAllViews();
        final TextView textView = new TextView(getContext());
        textView.setTextSize(f10);
        textView.setGravity(16);
        textView.setMaxLines(i10);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setLineSpacing(h.c(textView, 2.0f), 1.0f);
        if (z10) {
            u.a(textView);
        }
        addView(textView);
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int i11 = 0;
        if (list == null || list.isEmpty()) {
            j(map, spannableStringBuilder, textView);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (BaseLiveShowTagModel baseLiveShowTagModel : list) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.s.s();
            }
            BaseLiveShowTagModel baseLiveShowTagModel2 = baseLiveShowTagModel;
            int type = baseLiveShowTagModel2.getType();
            if (type == LiveShowTagType.LiveTag.getType()) {
                LiveShowTagModel liveShowTagModel = baseLiveShowTagModel2 instanceof LiveShowTagModel ? (LiveShowTagModel) baseLiveShowTagModel2 : null;
                if (liveShowTagModel != null) {
                    arrayList.add(new ImageWithHeightModel(liveShowTagModel.getLabel(), h.c(this, 12.0f), null, 4, null));
                }
            } else if (type == LiveShowTagType.FanClubTag.getType()) {
                FanClubTagModel fanClubTagModel = baseLiveShowTagModel2 instanceof FanClubTagModel ? (FanClubTagModel) baseLiveShowTagModel2 : null;
                if (fanClubTagModel != null) {
                    this.f15685c = Integer.valueOf(i11);
                    this.f15686d = fanClubTagModel.getLabel();
                    if (fanClubTagModel.getLabel().getBadgeIcon() != null) {
                        arrayList.add(new ImageWithHeightModel(fanClubTagModel.getLabel().getBadgeIcon(), h.c(this, 16.0f), null, 4, null));
                    }
                }
            }
            i11 = i12;
        }
        if (arrayList.isEmpty()) {
            j(map, spannableStringBuilder, textView);
            return;
        }
        NetWorkDrawableHelper netWorkDrawableHelper = NetWorkDrawableHelper.f12282a;
        Context context = getContext();
        s.h(context, "context");
        Flowable observeOn = NetWorkDrawableHelper.g(netWorkDrawableHelper, context, arrayList, false, 4, null).onErrorReturnItem(kotlin.collections.s.j()).observeOn(AndroidSchedulers.mainThread());
        final Function1<List<? extends Drawable>, p> function1 = new Function1<List<? extends Drawable>, p>() { // from class: com.cupidapp.live.liveshow.view.label.LiveLabelListView$configLabelListView$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(List<? extends Drawable> list2) {
                invoke2(list2);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends Drawable> list2) {
                Integer num;
                Map map2;
                s.h(list2, "list");
                LiveLabelListView liveLabelListView = LiveLabelListView.this;
                int i13 = 0;
                for (Drawable drawable : list2) {
                    int i14 = i13 + 1;
                    if (i13 < 0) {
                        kotlin.collections.s.s();
                    }
                    Drawable drawable2 = drawable;
                    num = liveLabelListView.f15685c;
                    if (num != null && i13 == num.intValue()) {
                        liveLabelListView.f15687e = drawable2;
                    }
                    Integer valueOf = Integer.valueOf(i13);
                    map2 = liveLabelListView.f15688f;
                    map2.put(valueOf, drawable2);
                    i13 = i14;
                }
                LiveLabelListView.this.k(map, spannableStringBuilder, textView);
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.liveshow.view.label.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LiveLabelListView.p(Function1.this, obj);
            }
        };
        final Function1<Throwable, p> function12 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.liveshow.view.label.LiveLabelListView$configLabelListView$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                LiveLabelListView.this.j(map, spannableStringBuilder, textView);
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.liveshow.view.label.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                LiveLabelListView.q(Function1.this, obj);
            }
        });
    }

    public final void r() {
        this.f15685c = null;
        this.f15686d = null;
        this.f15687e = null;
        this.f15688f.clear();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLabelListView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15689g = new LinkedHashMap();
        this.f15684b = "翻咔 ";
        this.f15688f = new LinkedHashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveLabelListView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15689g = new LinkedHashMap();
        this.f15684b = "翻咔 ";
        this.f15688f = new LinkedHashMap();
    }
}
