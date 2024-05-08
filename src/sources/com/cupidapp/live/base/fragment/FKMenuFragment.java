package com.cupidapp.live.base.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.i0;
import kotlin.f;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;

/* compiled from: FKMenuFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKMenuFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static final a f11800g = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public FKMenuFragmentModel f11801e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f11802f = new LinkedHashMap();

    /* compiled from: FKMenuFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f11802f.clear();
    }

    @Nullable
    public View V0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f11802f;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void W0() {
        TextView backTextView = (TextView) V0(R$id.backTextView);
        s.h(backTextView, "backTextView");
        y.d(backTextView, new Function1<View, p>() { // from class: com.cupidapp.live.base.fragment.FKMenuFragment$bindClickEvent$1
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
                FKMenuFragment.this.dismiss();
            }
        });
        int i10 = R$id.recyclerView;
        ((RecyclerView) V0(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView = (RecyclerView) V0(i10);
        FKMenuFragmentAdapter fKMenuFragmentAdapter = new FKMenuFragmentAdapter();
        fKMenuFragmentAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.menuFragmentItemLayout), new Function1<Object, p>() { // from class: com.cupidapp.live.base.fragment.FKMenuFragment$bindClickEvent$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Object obj) {
                if (obj instanceof FKMenuFragmentItemModel) {
                    ((FKMenuFragmentItemModel) obj).getEvent().invoke();
                    FKMenuFragment.this.dismiss();
                }
            }
        })));
        FKMenuFragmentModel fKMenuFragmentModel = this.f11801e;
        if (fKMenuFragmentModel != null) {
            ArrayList<FKMenuFragmentItemModel> list = fKMenuFragmentModel.getList();
            if (list != null) {
                fKMenuFragmentAdapter.j().addAll(list);
            }
            fKMenuFragmentAdapter.notifyDataSetChanged();
        }
        recyclerView.setAdapter(fKMenuFragmentAdapter);
    }

    public final void X0() {
        FKMenuFragmentModel fKMenuFragmentModel = this.f11801e;
        if (fKMenuFragmentModel != null) {
            String title = fKMenuFragmentModel.getTitle();
            if (title == null || title.length() == 0) {
                ((TextView) V0(R$id.bottomTitle)).setVisibility(8);
            } else {
                int i10 = R$id.bottomTitle;
                TextView textView = (TextView) V0(i10);
                if (textView != null) {
                    textView.setText(fKMenuFragmentModel.getTitle());
                }
                ((TextView) V0(i10)).setVisibility(0);
            }
            if (fKMenuFragmentModel.isShowBackButton()) {
                V0(R$id.intervalView).setVisibility(0);
                ((TextView) V0(R$id.backTextView)).setVisibility(0);
            } else {
                V0(R$id.intervalView).setVisibility(8);
                ((TextView) V0(R$id.backTextView)).setVisibility(8);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_dialog_base_menu, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        X0();
        W0();
    }
}
