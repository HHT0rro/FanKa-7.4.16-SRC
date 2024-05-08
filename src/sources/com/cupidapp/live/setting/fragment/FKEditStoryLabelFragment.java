package com.cupidapp.live.setting.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.network.model.StateResult;
import com.cupidapp.live.base.view.FKTitleBarLayout;
import com.cupidapp.live.databinding.FragmentEditStoryLabelBinding;
import com.cupidapp.live.profile.model.FKStoryLabelItemModel;
import com.cupidapp.live.setting.viewmodel.FKStoryLabelViewModel;
import com.cupidapp.live.track.group.GroupSocialLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKEditStoryLabelFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKEditStoryLabelFragment extends FKBaseFragment {

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static final a f18114h = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public FragmentEditStoryLabelBinding f18115e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f18116f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f18117g = new LinkedHashMap();

    /* compiled from: FKEditStoryLabelFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKEditStoryLabelFragment a(@NotNull FKStoryLabelItemModel label) {
            kotlin.jvm.internal.s.i(label, "label");
            FKEditStoryLabelFragment fKEditStoryLabelFragment = new FKEditStoryLabelFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, label);
            fKEditStoryLabelFragment.setArguments(bundle);
            return fKEditStoryLabelFragment;
        }
    }

    /* compiled from: TextView.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable editable) {
            String obj;
            String e2 = (editable == null || (obj = editable.toString()) == null) ? null : z0.t.e(obj);
            FKEditStoryLabelFragment fKEditStoryLabelFragment = FKEditStoryLabelFragment.this;
            int i10 = R$id.edit_story_label_text;
            if (!kotlin.jvm.internal.s.d(((EditText) fKEditStoryLabelFragment.T0(i10)).getText().toString(), e2)) {
                ((EditText) FKEditStoryLabelFragment.this.T0(i10)).setText(e2);
                ((EditText) FKEditStoryLabelFragment.this.T0(i10)).setSelection(e2 != null ? e2.length() : 0);
            }
            FKStoryLabelViewModel V0 = FKEditStoryLabelFragment.this.V0();
            if (e2 == null) {
                e2 = "";
            }
            V0.setLabelContent(e2);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public FKEditStoryLabelFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.setting.fragment.FKEditStoryLabelFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.f18116f = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.v.b(FKStoryLabelViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.setting.fragment.FKEditStoryLabelFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                kotlin.jvm.internal.s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
    }

    public static final void X0(FKEditStoryLabelFragment this$0, StateResult stateResult) {
        kotlin.jvm.internal.s.i(this$0, "this$0");
        if (stateResult instanceof StateResult.c) {
            GroupSocialLog groupSocialLog = GroupSocialLog.f18708a;
            FKStoryLabelItemModel fKStoryLabelItemModel = (FKStoryLabelItemModel) stateResult.getData();
            groupSocialLog.V(fKStoryLabelItemModel != null ? fKStoryLabelItemModel.getId() : null);
            FragmentActivity activity = this$0.getActivity();
            if (activity != null) {
                activity.setResult(-1);
            }
            FragmentActivity activity2 = this$0.getActivity();
            if (activity2 != null) {
                activity2.finish();
                return;
            }
            return;
        }
        if (stateResult instanceof StateResult.a) {
            com.cupidapp.live.base.view.h.f12779a.r(this$0.getContext(), R$string.enter_the_corresponding_content);
        }
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f18117g.clear();
    }

    @Nullable
    public View T0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f18117g;
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

    public final FKStoryLabelViewModel V0() {
        return (FKStoryLabelViewModel) this.f18116f.getValue();
    }

    public final void W0() {
        V0().getSaveStoryLabelLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.setting.fragment.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKEditStoryLabelFragment.X0(FKEditStoryLabelFragment.this, (StateResult) obj);
            }
        });
    }

    public final void Y0(FKStoryLabelItemModel fKStoryLabelItemModel) {
        FKTitleBarLayout fKTitleBarLayout = (FKTitleBarLayout) T0(R$id.edit_story_label_title_layout);
        fKTitleBarLayout.setLeftImageClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.FKEditStoryLabelFragment$initView$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FragmentActivity activity = FKEditStoryLabelFragment.this.getActivity();
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        fKTitleBarLayout.setRightTextClickEvent(new Function1<View, kotlin.p>() { // from class: com.cupidapp.live.setting.fragment.FKEditStoryLabelFragment$initView$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ kotlin.p invoke(View view) {
                invoke2(view);
                return kotlin.p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable View view) {
                FKEditStoryLabelFragment.this.V0().saveStoryLabel();
            }
        });
        int i10 = R$id.edit_story_label_text;
        ((EditText) T0(i10)).setText(fKStoryLabelItemModel.getContent());
        EditText edit_story_label_text = (EditText) T0(i10);
        kotlin.jvm.internal.s.h(edit_story_label_text, "edit_story_label_text");
        edit_story_label_text.addTextChangedListener(new b());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(inflater, "inflater");
        FragmentEditStoryLabelBinding b4 = FragmentEditStoryLabelBinding.b(inflater, viewGroup, false);
        kotlin.jvm.internal.s.h(b4, "inflate(inflater, container, false)");
        this.f18115e = b4;
        if (b4 == null) {
            kotlin.jvm.internal.s.A("binding");
            b4 = null;
        }
        return b4.getRoot();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        kotlin.jvm.internal.s.i(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        FragmentEditStoryLabelBinding fragmentEditStoryLabelBinding = null;
        FKStoryLabelItemModel fKStoryLabelItemModel = arguments != null ? (FKStoryLabelItemModel) z0.g.b(arguments, FKStoryLabelItemModel.class) : null;
        if (fKStoryLabelItemModel == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        FragmentEditStoryLabelBinding fragmentEditStoryLabelBinding2 = this.f18115e;
        if (fragmentEditStoryLabelBinding2 == null) {
            kotlin.jvm.internal.s.A("binding");
            fragmentEditStoryLabelBinding2 = null;
        }
        fragmentEditStoryLabelBinding2.d(V0());
        FragmentEditStoryLabelBinding fragmentEditStoryLabelBinding3 = this.f18115e;
        if (fragmentEditStoryLabelBinding3 == null) {
            kotlin.jvm.internal.s.A("binding");
        } else {
            fragmentEditStoryLabelBinding = fragmentEditStoryLabelBinding3;
        }
        fragmentEditStoryLabelBinding.setLifecycleOwner(getViewLifecycleOwner());
        V0().editStoryLabel(fKStoryLabelItemModel);
        Y0(fKStoryLabelItemModel);
        W0();
    }
}
