package com.cupidapp.live.liveshow.view.music;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Property;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment;
import com.cupidapp.live.base.view.FKRecyclerTitleLayout;
import com.cupidapp.live.base.view.FKTitleViewModel;
import com.cupidapp.live.base.view.TitleConfigModel;
import com.cupidapp.live.liveshow.activity.FKBaseLiveActivity;
import com.cupidapp.live.liveshow.entity.FKLiveUtil;
import com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment;
import com.cupidapp.live.liveshow.view.music.adapter.FKMusicListViewFragment;
import com.cupidapp.live.liveshow.view.music.adapter.FKMusicListViewPagerAdapter;
import com.cupidapp.live.liveshow.view.music.d;
import com.cupidapp.live.liveshow.view.music.model.MusicDataResult;
import com.cupidapp.live.liveshow.view.music.model.MusicSheetModel;
import com.cupidapp.live.liveshow.view.music.view.ConfigMusicPlayerEvent;
import com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout;
import com.hifive.sdk.entity.HifiveMusicDetailModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r;
import kotlin.collections.t;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q1.g;
import z0.h;
import z0.v;
import z0.y;

/* compiled from: FKLiveMusicFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLiveMusicFragment extends BaseBottomSheetDialogFragment {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f15772i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static ZGPlayerState f15773j = ZGPlayerState.ZGPlayerStateStopped;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public static HifiveMusicDetailModel f15774k;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public g f15776f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15777g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15778h = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public final b f15775e = new b();

    /* compiled from: FKLiveMusicFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(@Nullable String str) {
            HifiveMusicDetailModel b4 = b();
            return s.d(str, b4 != null ? b4.getMusicId() : null) && c() != ZGPlayerState.ZGPlayerStateStopped;
        }

        @Nullable
        public final HifiveMusicDetailModel b() {
            return FKLiveMusicFragment.f15774k;
        }

        @NotNull
        public final ZGPlayerState c() {
            return FKLiveMusicFragment.f15773j;
        }

        public final void d(@Nullable HifiveMusicDetailModel hifiveMusicDetailModel) {
            FKLiveMusicFragment.f15774k = hifiveMusicDetailModel;
        }

        public final void e(@NotNull ZGPlayerState zGPlayerState) {
            s.i(zGPlayerState, "<set-?>");
            FKLiveMusicFragment.f15773j = zGPlayerState;
        }
    }

    /* compiled from: FKLiveMusicFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends com.cupidapp.live.liveshow.entity.b {
        public b() {
        }

        public static final void b(FKLiveMusicFragment this$0, long j10) {
            s.i(this$0, "this$0");
            ((TextView) this$0.W0(R$id.musicProcess)).setText(v.k(j10));
        }

        @Override // com.cupidapp.live.liveshow.entity.b, com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
        public void onPlayEnd(int i10) {
            super.onPlayEnd(i10);
            FKLiveUtil.f14913a.u(ZGPlayerState.ZGPlayerStateStopped);
            FKLiveMusicFragment.this.e1(false);
            TextView textView = (TextView) FKLiveMusicFragment.this.W0(R$id.musicProcess);
            Context context = FKLiveMusicFragment.this.getContext();
            textView.setText(context != null ? context.getString(R$string.init_record_time) : null);
            HifiveMusicDetailModel b4 = FKLiveMusicFragment.f15772i.b();
            if (b4 != null) {
                EventBus c4 = EventBus.c();
                String musicId = b4.getMusicId();
                s.h(musicId, "it.musicId");
                c4.l(new PlayMusicEvent(musicId));
                EventBus.c().l(new ConfigMusicPlayerEvent(false, b4));
            }
        }

        @Override // com.cupidapp.live.liveshow.entity.b, com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
        public void onPlayPause(int i10) {
            super.onPlayPause(i10);
            FKLiveUtil.f14913a.u(ZGPlayerState.ZGPlayerStatePaused);
            FKLiveMusicFragment.this.e1(false);
        }

        @Override // com.cupidapp.live.liveshow.entity.b, com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
        public void onPlayResume(int i10) {
            super.onPlayResume(i10);
            FKLiveUtil.f14913a.u(ZGPlayerState.ZGPlayerStatePlaying);
            FKLiveMusicFragment.this.e1(true);
        }

        @Override // com.cupidapp.live.liveshow.entity.b, com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
        public void onPlayStart(int i10) {
            super.onPlayStart(i10);
            FKLiveUtil.f14913a.u(ZGPlayerState.ZGPlayerStatePlaying);
            FKLiveMusicFragment.this.n1();
            FKLiveMusicFragment.this.e1(true);
            HifiveMusicDetailModel b4 = FKLiveMusicFragment.f15772i.b();
            if (b4 != null) {
                EventBus c4 = EventBus.c();
                String musicId = b4.getMusicId();
                s.h(musicId, "it.musicId");
                c4.l(new PlayMusicEvent(musicId));
                EventBus.c().l(new ConfigMusicPlayerEvent(true, b4));
            }
        }

        @Override // com.cupidapp.live.liveshow.entity.b, com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
        public void onPlayStop(int i10) {
            super.onPlayStop(i10);
            FKLiveUtil.f14913a.u(ZGPlayerState.ZGPlayerStateStopped);
        }

        @Override // com.cupidapp.live.liveshow.entity.b, com.zego.zegoavkit2.IZegoMediaPlayerWithIndexCallback
        public void onProcessInterval(final long j10, int i10) {
            super.onProcessInterval(j10, i10);
            Dialog dialog = FKLiveMusicFragment.this.getDialog();
            boolean z10 = false;
            if (dialog != null && !dialog.isShowing()) {
                z10 = true;
            }
            if (z10) {
                return;
            }
            TextView textView = (TextView) FKLiveMusicFragment.this.W0(R$id.musicProcess);
            final FKLiveMusicFragment fKLiveMusicFragment = FKLiveMusicFragment.this;
            textView.post(new Runnable() { // from class: com.cupidapp.live.liveshow.view.music.b
                @Override // java.lang.Runnable
                public final void run() {
                    FKLiveMusicFragment.b.b(FKLiveMusicFragment.this, j10);
                }
            });
        }
    }

    /* compiled from: FKLiveMusicFragment.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            s.i(animation, "animation");
            ((RelativeLayout) FKLiveMusicFragment.this.W0(R$id.musicPlayLayout)).setVisibility(0);
        }
    }

    public static final boolean i1(FKLiveMusicFragment this$0, TextView textView, int i10, KeyEvent keyEvent) {
        s.i(this$0, "this$0");
        if (i10 != 3) {
            return true;
        }
        this$0.k1();
        return true;
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment
    public void O0() {
        this.f15778h.clear();
    }

    @Nullable
    public View W0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15778h;
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

    public final void e1(boolean z10) {
        if (isResumed()) {
            ((ImageView) W0(R$id.musicPlayImage)).setImageResource(z10 ? R$mipmap.icon_music_pause : R$mipmap.icon_music_play);
        }
    }

    public final void f1() {
        Dialog dialog;
        if (!isAdded() || (dialog = getDialog()) == null) {
            return;
        }
        dialog.hide();
    }

    public final void g1() {
        com.cupidapp.live.liveshow.view.music.c.f15798a.a(getContext(), new d<MusicDataResult<MusicSheetModel>>() { // from class: com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment$initTitle$1
            @Override // com.cupidapp.live.liveshow.view.music.d
            public void a(@NotNull String str, @Nullable Integer num) {
                d.a.a(this, str, num);
            }

            @Override // com.cupidapp.live.liveshow.view.music.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void success(@NotNull MusicDataResult<MusicSheetModel> data) {
                s.i(data, "data");
                List<MusicSheetModel> list = data.getList();
                ArrayList arrayList = new ArrayList(t.t(list, 10));
                Iterator<MusicSheetModel> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(iterator2.next().getSheetName());
                }
                FKRecyclerTitleLayout fKRecyclerTitleLayout = (FKRecyclerTitleLayout) FKLiveMusicFragment.this.W0(R$id.musicSheetTitle);
                if (fKRecyclerTitleLayout != null) {
                    ArrayList arrayList2 = new ArrayList(t.t(arrayList, 10));
                    Iterator<E> iterator22 = arrayList.iterator2();
                    while (iterator22.hasNext()) {
                        arrayList2.add(new FKTitleViewModel((String) iterator22.next(), new TitleConfigModel(16.0f, -1, true), new TitleConfigModel(14.0f, -8618884, true), null, false, 24, null));
                    }
                    FKRecyclerTitleLayout.d(fKRecyclerTitleLayout, arrayList2, 0, 2, null);
                }
                FKRecyclerTitleLayout fKRecyclerTitleLayout2 = (FKRecyclerTitleLayout) FKLiveMusicFragment.this.W0(R$id.musicSheetTitle);
                if (fKRecyclerTitleLayout2 != null) {
                    final FKLiveMusicFragment fKLiveMusicFragment = FKLiveMusicFragment.this;
                    fKRecyclerTitleLayout2.setTitleClickListener(new Function2<Integer, FKTitleViewModel, p>() { // from class: com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment$initTitle$1$success$2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        /* renamed from: invoke */
                        public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, FKTitleViewModel fKTitleViewModel) {
                            invoke(num.intValue(), fKTitleViewModel);
                            return p.f51048a;
                        }

                        public final void invoke(int i10, @NotNull FKTitleViewModel fKTitleViewModel) {
                            s.i(fKTitleViewModel, "<anonymous parameter 1>");
                            ((ViewPager2) FKLiveMusicFragment.this.W0(R$id.musicSheetViewPager)).setCurrentItem(i10);
                        }
                    });
                }
                FKLiveMusicFragment fKLiveMusicFragment2 = FKLiveMusicFragment.this;
                List<MusicSheetModel> list2 = data.getList();
                ArrayList arrayList3 = new ArrayList(t.t(list2, 10));
                Iterator<MusicSheetModel> iterator23 = list2.iterator2();
                while (iterator23.hasNext()) {
                    arrayList3.add(iterator23.next().getSheetId());
                }
                fKLiveMusicFragment2.j1(arrayList3);
            }
        });
    }

    public final void h1() {
        int i10 = R$id.searchMusicEditText;
        ((EditText) W0(i10)).getPaint().setFakeBoldText(true);
        int i11 = R$id.quitPlayMusicButton;
        ((TextView) W0(i11)).getPaint().setFakeBoldText(true);
        ((TextView) W0(R$id.musicProcess)).getPaint().setFakeBoldText(true);
        View blankClickView = W0(R$id.blankClickView);
        s.h(blankClickView, "blankClickView");
        y.d(blankClickView, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment$initView$1
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
                Dialog dialog = FKLiveMusicFragment.this.getDialog();
                if (dialog != null) {
                    dialog.hide();
                }
                EventBus.c().o(new FKLiveMusicDismissEvent(false));
            }
        });
        TextView quitPlayMusicButton = (TextView) W0(i11);
        s.h(quitPlayMusicButton, "quitPlayMusicButton");
        y.d(quitPlayMusicButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment$initView$2
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
                List<Fragment> fragments;
                FragmentManager fragmentManager;
                FragmentTransaction beginTransaction;
                FragmentTransaction remove;
                FKLiveUtil.f14913a.H();
                FKLiveMusicFragment.this.dismiss();
                FragmentManager fragmentManager2 = FKLiveMusicFragment.this.getFragmentManager();
                if (fragmentManager2 == null || (fragments = fragmentManager2.getFragments()) == null) {
                    return;
                }
                FKLiveMusicFragment fKLiveMusicFragment = FKLiveMusicFragment.this;
                for (Fragment fragment : fragments) {
                    if ((fragment instanceof FKMusicListViewFragment) && (fragmentManager = fKLiveMusicFragment.getFragmentManager()) != null && (beginTransaction = fragmentManager.beginTransaction()) != null && (remove = beginTransaction.remove(fragment)) != null) {
                        remove.commit();
                    }
                }
            }
        });
        ImageView musicPlayImage = (ImageView) W0(R$id.musicPlayImage);
        s.h(musicPlayImage, "musicPlayImage");
        y.d(musicPlayImage, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment$initView$3

            /* compiled from: FKLiveMusicFragment.kt */
            @kotlin.d
            /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f15782a;

                static {
                    int[] iArr = new int[ZGPlayerState.values().length];
                    try {
                        iArr[ZGPlayerState.ZGPlayerStatePlaying.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[ZGPlayerState.ZGPlayerStatePaused.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[ZGPlayerState.ZGPlayerStateStopped.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f15782a = iArr;
                }
            }

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
                HifiveMusicDetailModel b4;
                FKLiveMusicFragment.a aVar = FKLiveMusicFragment.f15772i;
                int i12 = a.f15782a[aVar.c().ordinal()];
                if (i12 == 1) {
                    FKLiveMusicFragment.this.l1(true);
                    FKLiveUtil.f14913a.l();
                    return;
                }
                if (i12 == 2) {
                    FKLiveUtil.f14913a.q();
                    return;
                }
                if (i12 == 3 && (b4 = aVar.b()) != null) {
                    FKLiveMusicFragment fKLiveMusicFragment = FKLiveMusicFragment.this;
                    String expires = b4.getFile().getExpires();
                    s.h(expires, "it.file.expires");
                    if (Long.parseLong(expires) > System.currentTimeMillis()) {
                        FKLiveUtil fKLiveUtil = FKLiveUtil.f14913a;
                        String url = b4.getFile().getUrl();
                        s.h(url, "it.file.url");
                        fKLiveUtil.B(url);
                        fKLiveUtil.x(b4.getDuration());
                        return;
                    }
                    c cVar = c.f15798a;
                    Context context = fKLiveMusicFragment.getContext();
                    String musicId = b4.getMusicId();
                    s.h(musicId, "it.musicId");
                    cVar.e(context, musicId);
                }
            }
        });
        ((EditText) W0(i10)).setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.cupidapp.live.liveshow.view.music.a
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i12, KeyEvent keyEvent) {
                boolean i13;
                i13 = FKLiveMusicFragment.i1(FKLiveMusicFragment.this, textView, i12, keyEvent);
                return i13;
            }
        });
        ImageView clearSearchButton = (ImageView) W0(R$id.clearSearchButton);
        s.h(clearSearchButton, "clearSearchButton");
        y.d(clearSearchButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment$initView$5
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
                ((EditText) FKLiveMusicFragment.this.W0(R$id.searchMusicEditText)).setText("");
            }
        });
        TextView cancelSearchButton = (TextView) W0(R$id.cancelSearchButton);
        s.h(cancelSearchButton, "cancelSearchButton");
        y.d(cancelSearchButton, new Function1<View, p>() { // from class: com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment$initView$6
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
                Context context = FKLiveMusicFragment.this.getContext();
                if (context != null) {
                    h.p(context, (EditText) FKLiveMusicFragment.this.W0(R$id.searchMusicEditText));
                }
                ((TextView) FKLiveMusicFragment.this.W0(R$id.cancelSearchButton)).setVisibility(8);
                ((ImageView) FKLiveMusicFragment.this.W0(R$id.clearSearchButton)).setVisibility(8);
                FKLiveMusicFragment fKLiveMusicFragment = FKLiveMusicFragment.this;
                int i12 = R$id.searchMusicEditText;
                ((EditText) fKLiveMusicFragment.W0(i12)).setText("");
                ((EditText) FKLiveMusicFragment.this.W0(i12)).setCompoundDrawablesWithIntrinsicBounds(0, 0, R$mipmap.icon_search, 0);
                FKLiveMusicFragment fKLiveMusicFragment2 = FKLiveMusicFragment.this;
                int i13 = R$id.searchMusicListLayout;
                ((FKSearchMusicListLayout) fKLiveMusicFragment2.W0(i13)).m();
                ((FKSearchMusicListLayout) FKLiveMusicFragment.this.W0(i13)).setVisibility(8);
                ((FKRecyclerTitleLayout) FKLiveMusicFragment.this.W0(R$id.musicSheetTitle)).setVisibility(0);
                ((ViewPager2) FKLiveMusicFragment.this.W0(R$id.musicSheetViewPager)).setVisibility(0);
            }
        });
    }

    public final void j1(List<String> list) {
        ViewPager2 viewPager2;
        FragmentActivity activity = getActivity();
        if (activity != null && (viewPager2 = (ViewPager2) W0(R$id.musicSheetViewPager)) != null) {
            viewPager2.setAdapter(new FKMusicListViewPagerAdapter(activity, list));
        }
        ViewPager2 viewPager22 = (ViewPager2) W0(R$id.musicSheetViewPager);
        if (viewPager22 != null) {
            viewPager22.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment$initViewPagerView$2
                @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
                public void onPageSelected(int i10) {
                    ((FKRecyclerTitleLayout) FKLiveMusicFragment.this.W0(R$id.musicSheetTitle)).g(i10);
                }
            });
        }
    }

    public final void k1() {
        int i10 = R$id.searchMusicEditText;
        String obj = StringsKt__StringsKt.P0(((EditText) W0(i10)).getText().toString()).toString();
        if (obj.length() == 0) {
            return;
        }
        Context context = getContext();
        if (context != null) {
            h.p(context, (EditText) W0(i10));
        }
        FKSearchMusicListLayout searchMusicListLayout = (FKSearchMusicListLayout) W0(R$id.searchMusicListLayout);
        s.h(searchMusicListLayout, "searchMusicListLayout");
        FKSearchMusicListLayout.q(searchMusicListLayout, obj, 0, 2, null);
    }

    public final void l1(boolean z10) {
        this.f15777g = z10;
    }

    public final void m1(@Nullable FragmentManager fragmentManager) {
        if (!isAdded()) {
            if (fragmentManager != null) {
                show(fragmentManager, FKLiveMusicFragment.class.getSimpleName());
            }
        } else {
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.show();
            }
        }
    }

    public final void n1() {
        int i10 = R$id.musicPlayLayout;
        if (((RelativeLayout) W0(i10)).getVisibility() == 0) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((RelativeLayout) W0(i10), (Property<RelativeLayout, Float>) View.TRANSLATION_Y, h.c(this, 52.0f), 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.addListener(new c());
        ofFloat.start();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        return inflater.inflate(R$layout.fragment_live_music, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentActivity activity = getActivity();
        FKBaseLiveActivity fKBaseLiveActivity = activity instanceof FKBaseLiveActivity ? (FKBaseLiveActivity) activity : null;
        if (fKBaseLiveActivity != null) {
            fKBaseLiveActivity.D1();
        }
        FKLiveUtil.f14913a.H();
        f15774k = null;
        EventBus.c().o(new FKLiveMusicDismissEvent(true));
        O0();
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (f15773j == ZGPlayerState.ZGPlayerStatePlaying) {
            this.f15777g = false;
            FKLiveUtil.f14913a.l();
        }
    }

    @Override // com.cupidapp.live.base.fragment.BaseBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (f15773j != ZGPlayerState.ZGPlayerStatePaused || this.f15777g) {
            return;
        }
        FKLiveUtil.f14913a.q();
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
        Dialog dialog = getDialog();
        if (dialog != null) {
            z0.d.g(dialog, 0.0f);
        }
        FKLiveUtil.f14913a.z(this.f15775e);
        FragmentActivity activity = getActivity();
        FKBaseLiveActivity fKBaseLiveActivity = activity instanceof FKBaseLiveActivity ? (FKBaseLiveActivity) activity : null;
        if (fKBaseLiveActivity != null) {
            fKBaseLiveActivity.w1(new Function2<Integer, Boolean, p>() { // from class: com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment$onViewCreated$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ p mo1743invoke(Integer num, Boolean bool) {
                    invoke(num.intValue(), bool.booleanValue());
                    return p.f51048a;
                }

                public final void invoke(int i10, boolean z10) {
                    if (z10) {
                        ((EditText) FKLiveMusicFragment.this.W0(R$id.searchMusicEditText)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        ((TextView) FKLiveMusicFragment.this.W0(R$id.cancelSearchButton)).setVisibility(0);
                        ((FKRecyclerTitleLayout) FKLiveMusicFragment.this.W0(R$id.musicSheetTitle)).setVisibility(8);
                        ((ViewPager2) FKLiveMusicFragment.this.W0(R$id.musicSheetViewPager)).setVisibility(8);
                        ((FKSearchMusicListLayout) FKLiveMusicFragment.this.W0(R$id.searchMusicListLayout)).setVisibility(0);
                        ((RelativeLayout) FKLiveMusicFragment.this.W0(R$id.musicContainerLayout)).setTranslationY(-(((RelativeLayout) FKLiveMusicFragment.this.W0(R$id.musicListContainerLayout)).getHeight() / 2));
                        return;
                    }
                    ((RelativeLayout) FKLiveMusicFragment.this.W0(R$id.musicContainerLayout)).setTranslationY(0.0f);
                }
            });
        }
        this.f15776f = new g(r.e((EditText) W0(R$id.searchMusicEditText)), new Function1<Boolean, p>() { // from class: com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment$onViewCreated$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return p.f51048a;
            }

            public final void invoke(boolean z10) {
                ((ImageView) FKLiveMusicFragment.this.W0(R$id.clearSearchButton)).setVisibility(z10 ? 0 : 8);
            }
        });
        h1();
        g1();
    }
}
