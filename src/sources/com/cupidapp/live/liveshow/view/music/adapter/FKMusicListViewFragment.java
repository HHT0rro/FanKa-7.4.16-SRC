package com.cupidapp.live.liveshow.view.music.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment;
import com.cupidapp.live.liveshow.view.music.PlayMusicEvent;
import com.cupidapp.live.liveshow.view.music.model.MusicDataResult;
import com.cupidapp.live.liveshow.view.music.model.MusicListViewModel;
import com.cupidapp.live.liveshow.view.music.view.FKConflictListRecyclerView;
import com.hifive.sdk.entity.HifiveMusicDetailModel;
import he.j;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.c;
import kotlin.collections.i0;
import kotlin.d;
import kotlin.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKMusicSheetViewPagerAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKMusicListViewFragment extends FKBaseFragment {

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f15786j = new a(null);

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15791i = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name */
    public int f15787e = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f15788f = 1;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public final Lazy f15789g = c.b(new Function0<FKMusicListRecyclerViewAdapter>() { // from class: com.cupidapp.live.liveshow.view.music.adapter.FKMusicListViewFragment$musicListAdapter$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKMusicListRecyclerViewAdapter invoke() {
            FKMusicListRecyclerViewAdapter fKMusicListRecyclerViewAdapter = new FKMusicListRecyclerViewAdapter();
            final FKMusicListViewFragment fKMusicListViewFragment = FKMusicListViewFragment.this;
            fKMusicListRecyclerViewAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.musicPlayButton), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.music.adapter.FKMusicListViewFragment$musicListAdapter$2$1$1
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
                    if (obj instanceof MusicListViewModel) {
                        SensorsLogKeyButtonClick.AnchorLiveShowRoom.PlayMusic.click();
                        com.cupidapp.live.liveshow.view.music.c cVar = com.cupidapp.live.liveshow.view.music.c.f15798a;
                        Context context = FKMusicListViewFragment.this.getContext();
                        String musicId = ((MusicListViewModel) obj).getMusicModel().getMusicId();
                        s.h(musicId, "model.musicModel.musicId");
                        cVar.e(context, musicId);
                    }
                }
            })));
            return fKMusicListRecyclerViewAdapter;
        }
    });

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Lazy f15790h = c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.liveshow.view.music.adapter.FKMusicListViewFragment$loadMoreListener$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final FKLoadMoreListener invoke() {
            final FKMusicListViewFragment fKMusicListViewFragment = FKMusicListViewFragment.this;
            return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.music.adapter.FKMusicListViewFragment$loadMoreListener$2.1
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
                    int i10;
                    int i11;
                    int i12;
                    i10 = FKMusicListViewFragment.this.f15787e;
                    i11 = FKMusicListViewFragment.this.f15788f;
                    if (i10 <= i11) {
                        FKMusicListViewFragment fKMusicListViewFragment2 = FKMusicListViewFragment.this;
                        i12 = fKMusicListViewFragment2.f15787e;
                        fKMusicListViewFragment2.b1(i12);
                    }
                }
            });
        }
    });

    /* compiled from: FKMusicSheetViewPagerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKMusicListViewFragment a(@NotNull String sheetId) {
            s.i(sheetId, "sheetId");
            FKMusicListViewFragment fKMusicListViewFragment = new FKMusicListViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("MUSIC_SHEET_ID", sheetId);
            fKMusicListViewFragment.setArguments(bundle);
            return fKMusicListViewFragment;
        }
    }

    /* compiled from: FKMusicSheetViewPagerAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicListViewModel>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f15793b;

        public b(int i10) {
            this.f15793b = i10;
        }

        @Override // com.cupidapp.live.liveshow.view.music.d
        public void a(@NotNull String string, @Nullable Integer num) {
            s.i(string, "string");
            FKMusicListViewFragment.this.a1().c(false);
        }

        @Override // com.cupidapp.live.liveshow.view.music.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void success(@NotNull MusicDataResult<MusicListViewModel> data) {
            s.i(data, "data");
            FKMusicListViewFragment.this.f15788f = data.getTotalPage();
            FKMusicListViewFragment.this.f15787e = data.getCurrentPage() + 1;
            if (this.f15793b == 1) {
                FKMusicListViewFragment.this.d1().j().clear();
            }
            FKMusicListViewFragment.this.d1().e(data.getList());
            FKMusicListViewFragment.this.d1().notifyDataSetChanged();
            FKMusicListViewFragment.this.a1().c(false);
        }
    }

    public static /* synthetic */ void c1(FKMusicListViewFragment fKMusicListViewFragment, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        fKMusicListViewFragment.b1(i10);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment
    public void N0() {
        this.f15791i.clear();
    }

    @Nullable
    public View S0(int i10) {
        View findViewById;
        Map<Integer, View> map = this.f15791i;
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

    public final FKLoadMoreListener a1() {
        return (FKLoadMoreListener) this.f15790h.getValue();
    }

    public final void b1(int i10) {
        String string;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("MUSIC_SHEET_ID")) == null) {
            return;
        }
        com.cupidapp.live.liveshow.view.music.c.f15798a.b(getContext(), string, i10, new b(i10));
    }

    public final FKMusicListRecyclerViewAdapter d1() {
        return (FKMusicListRecyclerViewAdapter) this.f15789g.getValue();
    }

    public final void e1() {
        FKConflictListRecyclerView fKConflictListRecyclerView = (FKConflictListRecyclerView) S0(R$id.musicListRecyclerView);
        fKConflictListRecyclerView.setAdapter(d1());
        fKConflictListRecyclerView.setLayoutManager(new LinearLayoutManager(fKConflictListRecyclerView.getContext()));
        fKConflictListRecyclerView.addOnScrollListener(a1());
    }

    public final void f1(String str) {
        List<Object> j10 = d1().j();
        ArrayList<MusicListViewModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof MusicListViewModel) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (s.d(((MusicListViewModel) obj2).getMusicModel().getMusicId(), str)) {
                arrayList2.add(obj2);
            }
        }
        boolean isEmpty = arrayList2.isEmpty();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (((MusicListViewModel) obj3).isPlaying()) {
                arrayList3.add(obj3);
            }
        }
        boolean isEmpty2 = arrayList3.isEmpty();
        if (isEmpty && isEmpty2) {
            return;
        }
        for (MusicListViewModel musicListViewModel : arrayList) {
            musicListViewModel.setPlaying(FKLiveMusicFragment.f15772i.a(str) ? s.d(musicListViewModel.getMusicModel().getMusicId(), str) : false);
        }
        d1().notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        s.i(inflater, "inflater");
        return inflater.inflate(R$layout.fragment_music_sheet_view_pager, viewGroup, false);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        N0();
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PlayMusicEvent event) {
        s.i(event, "event");
        f1(event.getMusicId());
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        HifiveMusicDetailModel b4 = FKLiveMusicFragment.f15772i.b();
        f1(b4 != null ? b4.getMusicId() : null);
    }

    @Override // com.cupidapp.live.base.fragment.FKBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        s.i(view, "view");
        super.onViewCreated(view, bundle);
        e1();
        c1(this, 0, 1, null);
    }
}
