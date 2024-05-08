package com.cupidapp.live.chat.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.sensorslog.PopupName;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.view.decoration.FKAddExtraSpacingDecoration;
import com.cupidapp.live.chat.adapter.ChatStatusAdapter;
import com.cupidapp.live.chat.fragment.ConfigChatStateFragment;
import com.cupidapp.live.chat.model.ChatStatusItemModel;
import com.cupidapp.live.chat.viewmodel.ChatStatusViewModel;
import com.cupidapp.live.profile.model.User;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.v;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.u;
import z0.y;

/* compiled from: ConfigChatStateFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConfigChatStateFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final b f13140j = new b(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public SensorPosition f13142f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public a f13144h;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13145i = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f13141e = kotlin.c.b(new Function0<ChatStatusAdapter>() { // from class: com.cupidapp.live.chat.fragment.ConfigChatStateFragment$adapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ChatStatusAdapter invoke() {
            ChatStatusAdapter chatStatusAdapter = new ChatStatusAdapter();
            final ConfigChatStateFragment configChatStateFragment = ConfigChatStateFragment.this;
            chatStatusAdapter.l().g(new Function1<Object, p>() { // from class: com.cupidapp.live.chat.fragment.ConfigChatStateFragment$adapter$2$1$1
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
                    ConfigChatStateFragment.a aVar;
                    if (obj instanceof ChatStatusItemModel) {
                        aVar = ConfigChatStateFragment.this.f13144h;
                        if (aVar != null) {
                            aVar.a((ChatStatusItemModel) obj);
                        }
                        ConfigChatStateFragment.this.dismiss();
                    }
                }
            });
            return chatStatusAdapter;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f13143g = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(ChatStatusViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.chat.fragment.ConfigChatStateFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            s.h(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            s.h(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.cupidapp.live.chat.fragment.ConfigChatStateFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            s.h(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    });

    /* compiled from: ConfigChatStateFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {

        /* compiled from: ConfigChatStateFragment.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.chat.fragment.ConfigChatStateFragment$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class C0149a {
            public static void a(@NotNull a aVar) {
            }
        }

        void a(@NotNull ChatStatusItemModel chatStatusItemModel);

        void dismiss();
    }

    /* compiled from: ConfigChatStateFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable FragmentManager fragmentManager, @NotNull SensorPosition position, @Nullable a aVar) {
            s.i(position, "position");
            if (fragmentManager == null) {
                return;
            }
            new ConfigChatStateFragment().d1(fragmentManager, ConfigChatStateFragment.class.getSimpleName(), position, aVar);
        }
    }

    public static final void c1(ConfigChatStateFragment this$0, List it) {
        s.i(this$0, "this$0");
        if (it == null || it.isEmpty()) {
            return;
        }
        this$0.Z0().j().clear();
        List<Object> j10 = this$0.Z0().j();
        s.h(it, "it");
        j10.addAll(it);
        this$0.Z0().notifyDataSetChanged();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f13145i.clear();
    }

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f13145i;
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

    public final void Y0() {
        ImageView chat_state_close_img = (ImageView) W0(R$id.chat_state_close_img);
        s.h(chat_state_close_img, "chat_state_close_img");
        y.d(chat_state_close_img, new Function1<View, p>() { // from class: com.cupidapp.live.chat.fragment.ConfigChatStateFragment$bindClickEvent$1
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
                ConfigChatStateFragment.this.Q0();
            }
        });
    }

    public final ChatStatusAdapter Z0() {
        return (ChatStatusAdapter) this.f13141e.getValue();
    }

    public final ChatStatusViewModel a1() {
        return (ChatStatusViewModel) this.f13143g.getValue();
    }

    public final void b1() {
        a1().getChatStatusListLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.chat.fragment.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ConfigChatStateFragment.c1(ConfigChatStateFragment.this, (List) obj);
            }
        });
    }

    public final void d1(@NotNull FragmentManager manager, @Nullable String str, @NotNull SensorPosition sensorPosition, @Nullable a aVar) {
        s.i(manager, "manager");
        s.i(sensorPosition, "sensorPosition");
        this.f13144h = aVar;
        this.f13142f = sensorPosition;
        super.show(manager, str);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        return inflater.inflate(R$layout.fragment_config_chat_state, viewGroup, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O0();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        s.i(dialog, "dialog");
        a aVar = this.f13144h;
        if (aVar != null) {
            aVar.dismiss();
        }
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R0(3, true);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        int i10 = R$id.status_rv;
        RecyclerView status_rv = (RecyclerView) W0(i10);
        s.h(status_rv, "status_rv");
        U0(status_rv);
        User X = p1.g.f52734a.X();
        if (X != null) {
            ImageLoaderView chat_state_user_avatar_img = (ImageLoaderView) W0(R$id.chat_state_user_avatar_img);
            s.h(chat_state_user_avatar_img, "chat_state_user_avatar_img");
            ImageLoaderView.g(chat_state_user_avatar_img, X.getAvatarImage(), null, null, 6, null);
            int i11 = R$id.chat_state_user_name_text;
            TextView chat_state_user_name_text = (TextView) W0(i11);
            s.h(chat_state_user_name_text, "chat_state_user_name_text");
            u.c(chat_state_user_name_text, 5, false, 2, null);
            ((TextView) W0(i11)).setText(getString(R$string.right_italic_text_with_space, X.getName()));
        }
        Y0();
        j1.i.g(j1.i.f50236a, PopupName.CHAT_STATUS_SET, this.f13142f, null, 4, null);
        ((RecyclerView) W0(i10)).setLayoutManager(new GridLayoutManager(getContext(), Z0().v()));
        ((RecyclerView) W0(i10)).addItemDecoration(new FKAddExtraSpacingDecoration(z0.h.c(this, 6.0f), 0, z0.h.c(this, 6.0f), z0.h.c(this, 24.0f), 0, 0, 48, null));
        ((RecyclerView) W0(i10)).setAdapter(Z0());
        b1();
        a1().loadChatStatusList();
    }
}
