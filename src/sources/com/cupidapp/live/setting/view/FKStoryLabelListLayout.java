package com.cupidapp.live.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.e;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.base.view.dialog.ActionSheetItemType;
import com.cupidapp.live.base.view.dialog.FKActionSheetDialog;
import com.cupidapp.live.base.view.dialog.FKActionSheetItemModel;
import com.cupidapp.live.base.view.h;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.setting.activity.FKEditStoryLabelActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKStoryLabelListLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStoryLabelListLayout extends BaseLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f18207f = new a(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public final List<FKStoryLabelItemModel> f18208d;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18209e;

    /* compiled from: FKStoryLabelListLayout.kt */
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
    public FKStoryLabelListLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f18209e = new LinkedHashMap();
        this.f18208d = new ArrayList();
        o();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f18209e;
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

    public final void k(@Nullable List<FKStoryLabelItemModel> list) {
        boolean z10 = true;
        if ((!this.f18208d.isEmpty()) && s.d(list, this.f18208d)) {
            return;
        }
        this.f18208d.clear();
        ((LinearLayout) e(R$id.story_label_container)).removeAllViews();
        if (list != null && !list.isEmpty()) {
            z10 = false;
        }
        if (!z10) {
            for (FKStoryLabelItemModel fKStoryLabelItemModel : list) {
                this.f18208d.add(fKStoryLabelItemModel);
                ((LinearLayout) e(R$id.story_label_container)).addView(m(fKStoryLabelItemModel));
            }
        }
        int i10 = R$id.story_label_container;
        if (((LinearLayout) e(i10)).getChildCount() < 3) {
            LinearLayout linearLayout = (LinearLayout) e(i10);
            Context context = getContext();
            s.h(context, "context");
            linearLayout.addView(new FKEmptyStoryLabelLayout(context));
        }
        l();
    }

    public final void l() {
        ((TextView) e(R$id.story_label_title_text)).setText(getContext().getString(R$string.story_label, Integer.valueOf(this.f18208d.size()), 3));
    }

    public final FKStoryLabelItemLayout m(final FKStoryLabelItemModel fKStoryLabelItemModel) {
        Context context = getContext();
        s.h(context, "context");
        FKStoryLabelItemLayout fKStoryLabelItemLayout = new FKStoryLabelItemLayout(context);
        fKStoryLabelItemLayout.d(fKStoryLabelItemModel, new Function0<p>() { // from class: com.cupidapp.live.setting.view.FKStoryLabelListLayout$createLabelView$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FKStoryLabelListLayout.this.q(fKStoryLabelItemModel);
            }
        });
        return fKStoryLabelItemLayout;
    }

    public final void o() {
        z.a(this, R$layout.layout_story_label, true);
        ((TextView) e(R$id.story_label_title_text)).getPaint().setFakeBoldText(true);
    }

    public final void p() {
        x2.a N = NetworkClient.f11868a.N();
        List<FKStoryLabelItemModel> list = this.f18208d;
        ArrayList arrayList = new ArrayList(t.t(list, 10));
        Iterator<FKStoryLabelItemModel> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().getId());
        }
        Disposable disposed = N.m0(arrayList).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.setting.view.FKStoryLabelListLayout$saveLabels$$inlined$handle$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(null, this)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            H(disposed);
        }
        s.h(disposed, "disposed");
    }

    public final void q(final FKStoryLabelItemModel fKStoryLabelItemModel) {
        final int indexOf = this.f18208d.indexOf(fKStoryLabelItemModel);
        ArrayList arrayList = new ArrayList();
        FKActionSheetItemModel fKActionSheetItemModel = new FKActionSheetItemModel(R$string.edit, null, null, null, null, new Function0<p>() { // from class: com.cupidapp.live.setting.view.FKStoryLabelListLayout$showMoreDialog$edit$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (FKStoryLabelItemModel.this.getOnline()) {
                    FKEditStoryLabelActivity.a aVar = FKEditStoryLabelActivity.f17956r;
                    Context context = this.getContext();
                    s.h(context, "context");
                    aVar.a(context, FKStoryLabelItemModel.this);
                    return;
                }
                h.f12779a.r(this.getContext(), R$string.story_label_offline_prompt);
            }
        }, 30, null);
        FKActionSheetItemModel fKActionSheetItemModel2 = new FKActionSheetItemModel(R$string.delete, ActionSheetItemType.Warning, null, null, null, new Function0<p>() { // from class: com.cupidapp.live.setting.view.FKStoryLabelListLayout$showMoreDialog$delete$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                list = FKStoryLabelListLayout.this.f18208d;
                list.remove(indexOf);
                FKStoryLabelListLayout fKStoryLabelListLayout = FKStoryLabelListLayout.this;
                int i10 = R$id.story_label_container;
                ((LinearLayout) fKStoryLabelListLayout.e(i10)).removeViewAt(indexOf);
                LinearLayout story_label_container = (LinearLayout) FKStoryLabelListLayout.this.e(i10);
                s.h(story_label_container, "story_label_container");
                if (((View) SequencesKt___SequencesKt.m(SequencesKt___SequencesKt.j(ViewGroupKt.getChildren(story_label_container), new Function1<View, Boolean>() { // from class: com.cupidapp.live.setting.view.FKStoryLabelListLayout$showMoreDialog$delete$1$emptyView$1
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull View it) {
                        s.i(it, "it");
                        return Boolean.valueOf(it instanceof FKEmptyStoryLabelLayout);
                    }
                }))) == null) {
                    LinearLayout linearLayout = (LinearLayout) FKStoryLabelListLayout.this.e(i10);
                    Context context = FKStoryLabelListLayout.this.getContext();
                    s.h(context, "context");
                    linearLayout.addView(new FKEmptyStoryLabelLayout(context));
                }
                FKStoryLabelListLayout.this.l();
                FKStoryLabelListLayout.this.p();
            }
        }, 28, null);
        FKActionSheetItemModel fKActionSheetItemModel3 = new FKActionSheetItemModel(R$string.move_up, null, null, null, null, new Function0<p>() { // from class: com.cupidapp.live.setting.view.FKStoryLabelListLayout$showMoreDialog$up$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                FKStoryLabelItemLayout m10;
                list = FKStoryLabelListLayout.this.f18208d;
                int i10 = indexOf;
                Collections.swap((List<?>) list, i10, i10 - 1);
                FKStoryLabelListLayout fKStoryLabelListLayout = FKStoryLabelListLayout.this;
                int i11 = R$id.story_label_container;
                ((LinearLayout) fKStoryLabelListLayout.e(i11)).removeViewAt(indexOf);
                LinearLayout linearLayout = (LinearLayout) FKStoryLabelListLayout.this.e(i11);
                m10 = FKStoryLabelListLayout.this.m(fKStoryLabelItemModel);
                linearLayout.addView(m10, indexOf - 1);
                FKStoryLabelListLayout.this.p();
            }
        }, 30, null);
        arrayList.add(fKActionSheetItemModel);
        arrayList.add(fKActionSheetItemModel2);
        if (indexOf > 0) {
            arrayList.add(fKActionSheetItemModel3);
        }
        FKActionSheetDialog.f12692f.a(getContext()).f(arrayList).h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStoryLabelListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f18209e = new LinkedHashMap();
        this.f18208d = new ArrayList();
        o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStoryLabelListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f18209e = new LinkedHashMap();
        this.f18208d = new ArrayList();
        o();
    }
}
