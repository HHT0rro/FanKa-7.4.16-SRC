package com.cupidapp.live.liveshow.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.view.timepicker.OptionsModel;
import com.cupidapp.live.base.view.timepicker.OptionsPickerWrapper;
import com.cupidapp.live.base.view.timepicker.h;
import com.cupidapp.live.liveshow.model.LiveActivityItemModel;
import com.cupidapp.live.track.group.GroupLiveLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;
import z0.z;

/* compiled from: LiveActivitySelectLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveActivitySelectLayout extends FrameLayout {

    /* renamed from: e, reason: collision with root package name */
    public static boolean f15299e;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f15300f;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final Lazy f15303b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15304c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final a f15298d = new a(null);

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final List<LiveActivityItemModel> f15301g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final List<LiveActivityItemModel> f15302h = new ArrayList();

    /* compiled from: LiveActivitySelectLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final List<LiveActivityItemModel> a() {
            return LiveActivitySelectLayout.f15302h;
        }

        public final boolean b() {
            return LiveActivitySelectLayout.f15299e;
        }

        @NotNull
        public final List<LiveActivityItemModel> c() {
            return LiveActivitySelectLayout.f15301g;
        }

        public final void d(boolean z10) {
            LiveActivitySelectLayout.f15300f = z10;
        }

        public final void e(@NotNull Context context, boolean z10, @Nullable List<LiveActivityItemModel> list, @Nullable List<LiveActivityItemModel> list2) {
            s.i(context, "context");
            d(z10);
            c().clear();
            a().clear();
            if (!(list == null || list.isEmpty())) {
                c().addAll(list);
            }
            if (list2 == null || list2.isEmpty()) {
                List<LiveActivityItemModel> a10 = a();
                String string = context.getString(R$string.no_activity_at_the_moment);
                s.h(string, "context.getString(R.stri…o_activity_at_the_moment)");
                a10.add(new LiveActivityItemModel(null, string));
                return;
            }
            a().addAll(list2);
            List<LiveActivityItemModel> a11 = a();
            String string2 = context.getString(R$string.not_participating_temporarily);
            s.h(string2, "context.getString(R.stri…articipating_temporarily)");
            a11.add(new LiveActivityItemModel(null, string2));
        }

        public final void f(boolean z10) {
            LiveActivitySelectLayout.f15299e = z10;
        }
    }

    /* compiled from: LiveActivitySelectLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.base.view.timepicker.h {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveActivityItemModel f15306b;

        public b(LiveActivityItemModel liveActivityItemModel) {
            this.f15306b = liveActivityItemModel;
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void a(int i10, int i11, int i12) {
            LiveActivitySelectLayout.this.n(this.f15306b, LiveActivitySelectLayout.f15298d.a().get(i10));
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void b(int i10, int i11, int i12) {
            h.a.c(this, i10, i11, i12);
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void onCancel() {
            h.a.a(this);
        }

        @Override // com.cupidapp.live.base.view.timepicker.h
        public void onConfirm() {
            h.a.b(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveActivitySelectLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15304c = new LinkedHashMap();
        this.f15303b = kotlin.c.b(LiveActivitySelectLayout$optionsPicker$2.INSTANCE);
        m();
    }

    private final OptionsPickerWrapper getOptionsPicker() {
        return (OptionsPickerWrapper) this.f15303b.getValue();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f15304c;
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

    public final void j(int i10) {
        GroupLiveLog.f18698a.m(i10 + 1);
    }

    public final void k() {
        ((LinearLayout) a(R$id.select_activity_layout)).removeAllViews();
        Iterator<LiveActivityItemModel> iterator2 = f15301g.iterator2();
        while (iterator2.hasNext()) {
            l(iterator2.next());
        }
        if (f15301g.size() <= 1) {
            l(null);
        }
    }

    public final void l(final LiveActivityItemModel liveActivityItemModel) {
        String string;
        final TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, z0.h.c(textView, 40.0f)));
        textView.setPadding(z0.h.c(textView, 12.0f), 0, z0.h.c(textView, 12.0f), 0);
        textView.setBackgroundResource(R$drawable.rect_cor_6_sk_19ffffff_sd_19ffffff);
        textView.setGravity(16);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        if (liveActivityItemModel == null || (string = liveActivityItemModel.getTitle()) == null) {
            string = textView.getContext().getString(R$string.select_live_activity);
        }
        textView.setText(string);
        textView.setTextColor(liveActivityItemModel == null ? com.cupidapp.live.base.utils.h.a(-1, 0.4f) : -1);
        textView.setTextSize(14.0f);
        u.e(textView, 0, 0, R$mipmap.icon_live_activity_arrow, 0, 11, null);
        ((LinearLayout) a(R$id.select_activity_layout)).addView(textView);
        y.m(textView, null, Integer.valueOf(z0.h.c(this, 6.0f)), null, Integer.valueOf(z0.h.c(this, 6.0f)), 5, null);
        y.d(textView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.LiveActivitySelectLayout$createItemView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                LiveActivitySelectLayout.f15298d.f(true);
                Context context = LiveActivitySelectLayout.this.getContext();
                s.h(context, "context");
                z0.h.q(context, null, 1, null);
                LiveActivitySelectLayout.this.o(liveActivityItemModel);
                LiveActivitySelectLayout liveActivitySelectLayout = LiveActivitySelectLayout.this;
                liveActivitySelectLayout.j(((LinearLayout) liveActivitySelectLayout.a(R$id.select_activity_layout)).indexOfChild(textView));
            }
        });
    }

    public final void m() {
        z.a(this, R$layout.layout_live_activity_select, true);
        if (f15300f) {
            a(R$id.septal_line_view).setVisibility(0);
            ((TextView) a(R$id.participate_in_activities_textview)).setVisibility(0);
            k();
        } else {
            a(R$id.septal_line_view).setVisibility(8);
            ((TextView) a(R$id.participate_in_activities_textview)).setVisibility(8);
            ((LinearLayout) a(R$id.select_activity_layout)).removeAllViews();
        }
    }

    public final void n(LiveActivityItemModel liveActivityItemModel, LiveActivityItemModel liveActivityItemModel2) {
        List<LiveActivityItemModel> list = f15301g;
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<LiveActivityItemModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getId());
        }
        if (liveActivityItemModel == null) {
            if (liveActivityItemModel2.getId() != null && !arrayList.contains(liveActivityItemModel2.getId())) {
                f15301g.add(liveActivityItemModel2);
            }
        } else if (arrayList.contains(liveActivityItemModel.getId())) {
            int indexOf = arrayList.indexOf(liveActivityItemModel.getId());
            if (liveActivityItemModel2.getId() == null) {
                f15301g.remove(indexOf);
            } else if (arrayList.contains(liveActivityItemModel2.getId())) {
                if (!s.d(liveActivityItemModel.getId(), liveActivityItemModel2.getId())) {
                    int indexOf2 = arrayList.indexOf(liveActivityItemModel2.getId());
                    List<LiveActivityItemModel> list2 = f15301g;
                    list2.set(indexOf, liveActivityItemModel2);
                    list2.set(indexOf2, liveActivityItemModel);
                }
            } else {
                f15301g.set(indexOf, liveActivityItemModel2);
            }
        }
        ((LinearLayout) a(R$id.select_activity_layout)).removeAllViews();
        Iterator<LiveActivityItemModel> iterator22 = f15301g.iterator2();
        while (iterator22.hasNext()) {
            l(iterator22.next());
        }
        if (f15301g.size() <= 1) {
            l(null);
        }
    }

    public final void o(LiveActivityItemModel liveActivityItemModel) {
        Typeface typeface;
        String title;
        List<LiveActivityItemModel> list = f15302h;
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<LiveActivityItemModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(z0.t.p(iterator2.next().getTitle(), 14, null, 2, null));
        }
        OptionsPickerWrapper s2 = OptionsPickerWrapper.i(getOptionsPicker(), getContext(), new OptionsModel(arrayList, (liveActivityItemModel == null || (title = liveActivityItemModel.getTitle()) == null) ? null : z0.t.p(title, 14, null, 2, null)), null, null, 12, null).s(new b(liveActivityItemModel));
        if (Build.VERSION.SDK_INT >= 28) {
            typeface = Typeface.create(Typeface.DEFAULT, 500, false);
        } else {
            typeface = Typeface.DEFAULT_BOLD;
        }
        Typeface typeface2 = typeface;
        s.h(typeface2, "if (Build.VERSION.SDK_IN…LT_BOLD\n                }");
        OptionsPickerWrapper.u(OptionsPickerWrapper.g(OptionsPickerWrapper.o(s2, 22, 2.0f, 5, 0, -15066598, -3750202, typeface2, false, null, 384, null).p(Integer.valueOf(R$drawable.rect_top_cor_16_sd_ffffff), true, R$string.complete, 14.0f, -49088, 2131886363, 14.0f, -5658199), false, 1, null), false, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f15299e = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveActivitySelectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15304c = new LinkedHashMap();
        this.f15303b = kotlin.c.b(LiveActivitySelectLayout$optionsPicker$2.INSTANCE);
        m();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveActivitySelectLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15304c = new LinkedHashMap();
        this.f15303b = kotlin.c.b(LiveActivitySelectLayout$optionsPicker$2.INSTANCE);
        m();
    }
}
