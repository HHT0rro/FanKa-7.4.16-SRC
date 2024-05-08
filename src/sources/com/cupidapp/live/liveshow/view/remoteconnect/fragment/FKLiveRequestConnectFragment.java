package com.cupidapp.live.liveshow.view.remoteconnect.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.LinkDictTipsModel;
import com.cupidapp.live.base.permission.PermissionType;
import com.cupidapp.live.base.permission.RxPermissionHelperKt;
import com.cupidapp.live.base.permission.b;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.base.view.button.FKUniversalButton;
import com.cupidapp.live.liveshow.model.LiveConnectRequestCheckResult;
import com.cupidapp.live.liveshow.model.LiveConnectType;
import com.cupidapp.live.liveshow.view.remoteconnect.view.LiveConnectItemView;
import com.cupidapp.live.liveshow.view.remoteconnect.viewmodel.RequestLiveConnectViewModel;
import com.cupidapp.live.profile.model.User;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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
import z0.y;

/* compiled from: FKLiveRequestConnectFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveRequestConnectFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f15849i = new a(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final Lazy f15850e;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public final Lazy f15851f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public j f15852g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15853h = new LinkedHashMap();

    /* compiled from: FKLiveRequestConnectFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKLiveRequestConnectFragment a(@NotNull LiveConnectRequestCheckResult result, @NotNull j listener) {
            s.i(result, "result");
            s.i(listener, "listener");
            FKLiveRequestConnectFragment fKLiveRequestConnectFragment = new FKLiveRequestConnectFragment();
            Bundle bundle = new Bundle();
            z0.g.d(bundle, result);
            fKLiveRequestConnectFragment.setArguments(bundle);
            fKLiveRequestConnectFragment.f15852g = listener;
            return fKLiveRequestConnectFragment;
        }
    }

    /* compiled from: FKLiveRequestConnectFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15854a;

        static {
            int[] iArr = new int[LiveConnectType.values().length];
            try {
                iArr[LiveConnectType.VideoConnect.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f15854a = iArr;
        }
    }

    /* compiled from: FKLiveRequestConnectFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends ClickableSpan {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry<String, String> f15856c;

        public c(Map.Entry<String, String> entry) {
            this.f15856c = entry;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            j.a.b(com.cupidapp.live.base.router.j.f12156c, FKLiveRequestConnectFragment.this.getContext(), this.f15856c.getValue(), null, 4, null);
        }
    }

    /* compiled from: FKLiveRequestConnectFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements com.cupidapp.live.base.permission.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<p> f15857a;

        public d(Function0<p> function0) {
            this.f15857a = function0;
        }

        @Override // com.cupidapp.live.base.permission.b
        public void a() {
            this.f15857a.invoke();
        }

        @Override // com.cupidapp.live.base.permission.b
        public void b() {
            b.a.b(this);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void c() {
            b.a.c(this);
        }

        @Override // com.cupidapp.live.base.permission.b
        public void d() {
            b.a.a(this);
        }
    }

    public FKLiveRequestConnectFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveRequestConnectFragment$special$$inlined$viewModels$default$1
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
        this.f15850e = FragmentViewModelLazyKt.createViewModelLazy(this, v.b(RequestLiveConnectViewModel.class), new Function0<ViewModelStore>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveRequestConnectFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                s.h(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.f15851f = kotlin.c.b(new Function0<xb.b>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveRequestConnectFragment$rxPermissions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final xb.b invoke() {
                return new xb.b(FKLiveRequestConnectFragment.this);
            }
        });
    }

    public static final void e1(FKLiveRequestConnectFragment this$0, CompoundButton compoundButton, boolean z10) {
        s.i(this$0, "this$0");
        this$0.i1().setCheckBoxStatus(z10);
    }

    public static final void k1(FKLiveRequestConnectFragment this$0, Integer num) {
        s.i(this$0, "this$0");
        this$0.p1(num);
        j jVar = this$0.f15852g;
        if (jVar != null) {
            jVar.a();
        }
    }

    public static final void l1(FKLiveRequestConnectFragment this$0, Object obj) {
        s.i(this$0, "this$0");
        this$0.r1();
        j jVar = this$0.f15852g;
        if (jVar != null) {
            jVar.b();
        }
    }

    public static final void m1(FKLiveRequestConnectFragment this$0, Boolean it) {
        s.i(this$0, "this$0");
        FKUniversalButton fKUniversalButton = (FKUniversalButton) this$0.a1(R$id.request_connect_button);
        s.h(it, "it");
        fKUniversalButton.a(it.booleanValue());
    }

    public static final void n1(final FKLiveRequestConnectFragment this$0, LiveConnectType liveConnectType) {
        s.i(this$0, "this$0");
        this$0.q1(liveConnectType == LiveConnectType.VideoConnect, new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveRequestConnectFragment$initObserve$4$1
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
                RequestLiveConnectViewModel i12;
                i12 = FKLiveRequestConnectFragment.this.i1();
                i12.requestLiveConnect();
            }
        });
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15853h.clear();
    }

    @Nullable
    public View a1(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15853h;
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

    public final void d1() {
        LiveConnectItemView voice_connect_view = (LiveConnectItemView) a1(R$id.voice_connect_view);
        s.h(voice_connect_view, "voice_connect_view");
        y.d(voice_connect_view, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveRequestConnectFragment$bindClickEvent$1
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
                RequestLiveConnectViewModel i12;
                p1.g gVar = p1.g.f52734a;
                LiveConnectType liveConnectType = LiveConnectType.VoiceConnect;
                gVar.w2(liveConnectType);
                i12 = FKLiveRequestConnectFragment.this.i1();
                i12.setConnectType(liveConnectType);
                ((LiveConnectItemView) FKLiveRequestConnectFragment.this.a1(R$id.voice_connect_view)).d(true);
                ((LiveConnectItemView) FKLiveRequestConnectFragment.this.a1(R$id.video_connect_view)).d(false);
            }
        });
        LiveConnectItemView video_connect_view = (LiveConnectItemView) a1(R$id.video_connect_view);
        s.h(video_connect_view, "video_connect_view");
        y.d(video_connect_view, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveRequestConnectFragment$bindClickEvent$2
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
                RequestLiveConnectViewModel i12;
                p1.g gVar = p1.g.f52734a;
                LiveConnectType liveConnectType = LiveConnectType.VideoConnect;
                gVar.w2(liveConnectType);
                i12 = FKLiveRequestConnectFragment.this.i1();
                i12.setConnectType(liveConnectType);
                ((LiveConnectItemView) FKLiveRequestConnectFragment.this.a1(R$id.video_connect_view)).d(true);
                ((LiveConnectItemView) FKLiveRequestConnectFragment.this.a1(R$id.voice_connect_view)).d(false);
            }
        });
        ((CheckBox) a1(R$id.connect_agree_checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                FKLiveRequestConnectFragment.e1(FKLiveRequestConnectFragment.this, compoundButton, z10);
            }
        });
        FKUniversalButton request_connect_button = (FKUniversalButton) a1(R$id.request_connect_button);
        s.h(request_connect_button, "request_connect_button");
        y.d(request_connect_button, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveRequestConnectFragment$bindClickEvent$4
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
                RequestLiveConnectViewModel i12;
                i12 = FKLiveRequestConnectFragment.this.i1();
                i12.connectClick();
            }
        });
        FKUniversalButton cancel_connect_button = (FKUniversalButton) a1(R$id.cancel_connect_button);
        s.h(cancel_connect_button, "cancel_connect_button");
        y.d(cancel_connect_button, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.FKLiveRequestConnectFragment$bindClickEvent$5
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
                RequestLiveConnectViewModel i12;
                i12 = FKLiveRequestConnectFragment.this.i1();
                i12.cancelRequestConnect();
            }
        });
    }

    public final void f1(LinkDictTipsModel linkDictTipsModel) {
        SpannableStringBuilder c4;
        Map<String, String> linkDict = linkDictTipsModel.getLinkDict();
        if (linkDict == null || linkDict.isEmpty()) {
            ((TextView) a1(R$id.connect_agree_protocol_textView)).setText(linkDictTipsModel.getContent());
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        for (Map.Entry<String, String> entry : linkDictTipsModel.getLinkDict().entrySet()) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.s.s();
            }
            Map.Entry<String, String> entry2 = entry;
            arrayList.add(i10, entry2.getKey());
            arrayList2.add(i10, new c(entry2));
            i10 = i11;
        }
        c4 = q1.d.f53006a.c(linkDictTipsModel.getContent(), arrayList, (r18 & 4) != 0 ? null : -15066598, (r18 & 8) != 0 ? null : 0, (r18 & 16) != 0 ? false : false, (r18 & 32) != 0 ? null : arrayList2, (r18 & 64) != 0 ? null : null);
        int i12 = R$id.connect_agree_protocol_textView;
        ((TextView) a1(i12)).setText(c4);
        ((TextView) a1(i12)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void g1(LiveConnectRequestCheckResult liveConnectRequestCheckResult) {
        LiveConnectType R = p1.g.f52734a.R();
        if ((R == null ? -1 : b.f15854a[R.ordinal()]) == 1) {
            String videoError = liveConnectRequestCheckResult != null ? liveConnectRequestCheckResult.getVideoError() : null;
            if (videoError == null || videoError.length() == 0) {
                i1().setConnectType(LiveConnectType.VideoConnect);
            }
        } else {
            String voiceError = liveConnectRequestCheckResult != null ? liveConnectRequestCheckResult.getVoiceError() : null;
            if (voiceError == null || voiceError.length() == 0) {
                i1().setConnectType(LiveConnectType.VoiceConnect);
            }
        }
        LiveConnectItemView liveConnectItemView = (LiveConnectItemView) a1(R$id.voice_connect_view);
        String string = getString(R$string.voice_connect);
        s.h(string, "getString(R.string.voice_connect)");
        liveConnectItemView.b(R$mipmap.icon_voice_live_connect, string, liveConnectRequestCheckResult != null ? liveConnectRequestCheckResult.getVoiceError() : null, R == LiveConnectType.VoiceConnect || R == null);
        LiveConnectItemView liveConnectItemView2 = (LiveConnectItemView) a1(R$id.video_connect_view);
        String string2 = getString(R$string.video_connect);
        s.h(string2, "getString(R.string.video_connect)");
        liveConnectItemView2.b(R$mipmap.icon_video_live_connect, string2, liveConnectRequestCheckResult != null ? liveConnectRequestCheckResult.getVideoError() : null, R == LiveConnectType.VideoConnect);
    }

    public final xb.b h1() {
        return (xb.b) this.f15851f.getValue();
    }

    public final RequestLiveConnectViewModel i1() {
        return (RequestLiveConnectViewModel) this.f15850e.getValue();
    }

    public final void j1() {
        i1().getRequestConnectLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKLiveRequestConnectFragment.k1(FKLiveRequestConnectFragment.this, (Integer) obj);
            }
        });
        i1().getCancelRequestLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKLiveRequestConnectFragment.l1(FKLiveRequestConnectFragment.this, obj);
            }
        });
        i1().getConnectButtonStatus().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKLiveRequestConnectFragment.m1(FKLiveRequestConnectFragment.this, (Boolean) obj);
            }
        });
        i1().getConnectButtonClickLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.cupidapp.live.liveshow.view.remoteconnect.fragment.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FKLiveRequestConnectFragment.n1(FKLiveRequestConnectFragment.this, (LiveConnectType) obj);
            }
        });
    }

    public final void o1() {
        LinkDictTipsModel connectionTips;
        Bundle arguments = getArguments();
        LiveConnectRequestCheckResult liveConnectRequestCheckResult = arguments != null ? (LiveConnectRequestCheckResult) z0.g.b(arguments, LiveConnectRequestCheckResult.class) : null;
        g1(liveConnectRequestCheckResult);
        boolean z10 = false;
        if (liveConnectRequestCheckResult != null && liveConnectRequestCheckResult.getHasRequest()) {
            z10 = true;
        }
        if (z10) {
            p1(null);
        } else {
            r1();
        }
        p1.g gVar = p1.g.f52734a;
        ConstantsResult q10 = gVar.q();
        if (q10 != null && (connectionTips = q10.getConnectionTips()) != null) {
            f1(connectionTips);
        }
        ImageLoaderView request_avatar_imageview = (ImageLoaderView) a1(R$id.request_avatar_imageview);
        s.h(request_avatar_imageview, "request_avatar_imageview");
        User X = gVar.X();
        ImageLoaderView.g(request_avatar_imageview, X != null ? X.getAvatarImage() : null, null, null, 6, null);
        i1().setCheckBoxStatus(true);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_live_show_start_connect, viewGroup, false);
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
        o1();
        j1();
        d1();
    }

    public final void p1(Integer num) {
        ConstraintLayout live_connect_layout = (ConstraintLayout) a1(R$id.live_connect_layout);
        s.h(live_connect_layout, "live_connect_layout");
        live_connect_layout.setVisibility(8);
        ConstraintLayout request_connect_layout = (ConstraintLayout) a1(R$id.request_connect_layout);
        s.h(request_connect_layout, "request_connect_layout");
        request_connect_layout.setVisibility(0);
        ((TextView) a1(R$id.request_connect_title_textview)).setText(getString(R$string.has_sent_link_request));
        if (num != null) {
            ((TextView) a1(R$id.subtitle_textView)).setText(getString(R$string.wait_count_for_viewer, num));
        }
    }

    public final void q1(boolean z10, Function0<p> function0) {
        Context context = getContext();
        if (context != null) {
            ArrayList arrayList = new ArrayList();
            if (z10) {
                arrayList.add(PermissionType.CameraPermission);
            }
            arrayList.add(PermissionType.AudioPermission);
            RxPermissionHelperKt.m(context, h1(), arrayList, new d(function0), false, 16, null);
        }
    }

    public final void r1() {
        ConstraintLayout live_connect_layout = (ConstraintLayout) a1(R$id.live_connect_layout);
        s.h(live_connect_layout, "live_connect_layout");
        live_connect_layout.setVisibility(0);
        ConstraintLayout request_connect_layout = (ConstraintLayout) a1(R$id.request_connect_layout);
        s.h(request_connect_layout, "request_connect_layout");
        request_connect_layout.setVisibility(8);
        TextView textView = (TextView) a1(R$id.request_connect_title_textview);
        Context context = getContext();
        textView.setText(context != null ? context.getString(R$string.send_link_request) : null);
    }

    public final void s1(@Nullable FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            return;
        }
        show(fragmentManager, FKLiveRequestConnectFragment.class.getSimpleName());
    }
}
