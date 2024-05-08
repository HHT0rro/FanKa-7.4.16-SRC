package com.cupidapp.live.liveshow.view.music.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.recyclerview.FKLoadMoreListener;
import com.cupidapp.live.base.sensorslog.SensorsLogKeyButtonClick;
import com.cupidapp.live.base.view.BaseLayout;
import com.cupidapp.live.liveshow.view.music.FKLiveMusicFragment;
import com.cupidapp.live.liveshow.view.music.PlayMusicEvent;
import com.cupidapp.live.liveshow.view.music.adapter.FKMusicListRecyclerViewAdapter;
import com.cupidapp.live.liveshow.view.music.adapter.MusicListPromptViewModel;
import com.cupidapp.live.liveshow.view.music.model.MusicDataResult;
import com.cupidapp.live.liveshow.view.music.model.MusicListViewModel;
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
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.z;

/* compiled from: FKSearchMusicListLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKSearchMusicListLayout extends BaseLayout {

    /* renamed from: d */
    @NotNull
    public final Lazy f15819d;

    /* renamed from: e */
    public int f15820e;

    /* renamed from: f */
    public int f15821f;

    /* renamed from: g */
    @NotNull
    public String f15822g;

    /* renamed from: h */
    @NotNull
    public final Lazy f15823h;

    /* renamed from: i */
    @NotNull
    public Map<Integer, View> f15824i;

    /* compiled from: FKSearchMusicListLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements com.cupidapp.live.liveshow.view.music.d<MusicDataResult<MusicListViewModel>> {

        /* renamed from: b */
        public final /* synthetic */ int f15826b;

        public a(int i10) {
            this.f15826b = i10;
        }

        @Override // com.cupidapp.live.liveshow.view.music.d
        public void a(@NotNull String string, @Nullable Integer num) {
            s.i(string, "string");
            FKSearchMusicListLayout.this.getLoadMoreListener().c(false);
            if (this.f15826b == 1) {
                FKSearchMusicListLayout.this.getMusicListAdapter().j().clear();
                FKSearchMusicListLayout.this.getMusicListAdapter().d(new MusicListPromptViewModel(R$mipmap.icon_internet_error, R$string.internet_error));
            }
            FKSearchMusicListLayout.this.getMusicListAdapter().notifyDataSetChanged();
        }

        @Override // com.cupidapp.live.liveshow.view.music.d
        /* renamed from: b */
        public void success(@NotNull MusicDataResult<MusicListViewModel> data) {
            s.i(data, "data");
            FKSearchMusicListLayout.this.f15820e = data.getTotalPage();
            FKSearchMusicListLayout.this.f15821f = data.getCurrentPage() + 1;
            if (this.f15826b == 1) {
                FKSearchMusicListLayout.this.getMusicListAdapter().j().clear();
            }
            if (this.f15826b == 1 && data.isRecommend()) {
                FKSearchMusicListLayout.this.getMusicListAdapter().j().clear();
                FKSearchMusicListLayout.this.getMusicListAdapter().d(new MusicListPromptViewModel(R$mipmap.icon_empty_music_list, R$string.empty_music_list));
            } else {
                FKSearchMusicListLayout.this.getMusicListAdapter().e(data.getList());
            }
            FKSearchMusicListLayout.this.getMusicListAdapter().notifyDataSetChanged();
            FKSearchMusicListLayout.this.getLoadMoreListener().c(false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSearchMusicListLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15824i = new LinkedHashMap();
        this.f15819d = c.b(new Function0<FKMusicListRecyclerViewAdapter>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$musicListAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKMusicListRecyclerViewAdapter invoke() {
                FKMusicListRecyclerViewAdapter fKMusicListRecyclerViewAdapter = new FKMusicListRecyclerViewAdapter();
                final FKSearchMusicListLayout fKSearchMusicListLayout = FKSearchMusicListLayout.this;
                fKMusicListRecyclerViewAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.musicPlayButton), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$musicListAdapter$2$1$1
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
                            Context context2 = FKSearchMusicListLayout.this.getContext();
                            String musicId = ((MusicListViewModel) obj).getMusicModel().getMusicId();
                            s.h(musicId, "model.musicModel.musicId");
                            cVar.e(context2, musicId);
                        }
                    }
                })));
                return fKMusicListRecyclerViewAdapter;
            }
        });
        this.f15820e = 1;
        this.f15821f = 1;
        this.f15822g = "";
        this.f15823h = c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final FKSearchMusicListLayout fKSearchMusicListLayout = FKSearchMusicListLayout.this;
                return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$loadMoreListener$2.1
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
                        String str;
                        int i12;
                        i10 = FKSearchMusicListLayout.this.f15821f;
                        i11 = FKSearchMusicListLayout.this.f15820e;
                        if (i10 <= i11) {
                            FKSearchMusicListLayout fKSearchMusicListLayout2 = FKSearchMusicListLayout.this;
                            str = fKSearchMusicListLayout2.f15822g;
                            i12 = FKSearchMusicListLayout.this.f15821f;
                            fKSearchMusicListLayout2.p(str, i12);
                        }
                    }
                });
            }
        });
        o();
    }

    public final FKLoadMoreListener getLoadMoreListener() {
        return (FKLoadMoreListener) this.f15823h.getValue();
    }

    public final FKMusicListRecyclerViewAdapter getMusicListAdapter() {
        return (FKMusicListRecyclerViewAdapter) this.f15819d.getValue();
    }

    public static /* synthetic */ void q(FKSearchMusicListLayout fKSearchMusicListLayout, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 1;
        }
        fKSearchMusicListLayout.p(str, i10);
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15824i;
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

    public final void m() {
        getMusicListAdapter().j().clear();
        getMusicListAdapter().notifyDataSetChanged();
    }

    public final void o() {
        z.a(this, R$layout.layout_music_list, true);
        FKConflictListRecyclerView fKConflictListRecyclerView = (FKConflictListRecyclerView) e(R$id.searchMusicListRecyclerView);
        fKConflictListRecyclerView.setAdapter(getMusicListAdapter());
        fKConflictListRecyclerView.setLayoutManager(new LinearLayoutManager(fKConflictListRecyclerView.getContext()));
        fKConflictListRecyclerView.addOnScrollListener(getLoadMoreListener());
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull PlayMusicEvent event) {
        s.i(event, "event");
        if (getVisibility() != 0) {
            return;
        }
        List<Object> j10 = getMusicListAdapter().j();
        ArrayList<MusicListViewModel> arrayList = new ArrayList();
        for (Object obj : j10) {
            if (obj instanceof MusicListViewModel) {
                arrayList.add(obj);
            }
        }
        for (MusicListViewModel musicListViewModel : arrayList) {
            musicListViewModel.setPlaying(FKLiveMusicFragment.f15772i.a(event.getMusicId()) ? s.d(event.getMusicId(), musicListViewModel.getMusicModel().getMusicId()) : false);
        }
        getMusicListAdapter().notifyDataSetChanged();
    }

    public final void p(@NotNull String keyword, int i10) {
        s.i(keyword, "keyword");
        this.f15822g = keyword;
        com.cupidapp.live.liveshow.view.music.c.f15798a.g(getContext(), keyword, i10, new a(i10));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSearchMusicListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15824i = new LinkedHashMap();
        this.f15819d = c.b(new Function0<FKMusicListRecyclerViewAdapter>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$musicListAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKMusicListRecyclerViewAdapter invoke() {
                FKMusicListRecyclerViewAdapter fKMusicListRecyclerViewAdapter = new FKMusicListRecyclerViewAdapter();
                final FKSearchMusicListLayout fKSearchMusicListLayout = FKSearchMusicListLayout.this;
                fKMusicListRecyclerViewAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.musicPlayButton), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$musicListAdapter$2$1$1
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
                            Context context2 = FKSearchMusicListLayout.this.getContext();
                            String musicId = ((MusicListViewModel) obj).getMusicModel().getMusicId();
                            s.h(musicId, "model.musicModel.musicId");
                            cVar.e(context2, musicId);
                        }
                    }
                })));
                return fKMusicListRecyclerViewAdapter;
            }
        });
        this.f15820e = 1;
        this.f15821f = 1;
        this.f15822g = "";
        this.f15823h = c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final FKSearchMusicListLayout fKSearchMusicListLayout = FKSearchMusicListLayout.this;
                return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$loadMoreListener$2.1
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
                        String str;
                        int i12;
                        i10 = FKSearchMusicListLayout.this.f15821f;
                        i11 = FKSearchMusicListLayout.this.f15820e;
                        if (i10 <= i11) {
                            FKSearchMusicListLayout fKSearchMusicListLayout2 = FKSearchMusicListLayout.this;
                            str = fKSearchMusicListLayout2.f15822g;
                            i12 = FKSearchMusicListLayout.this.f15821f;
                            fKSearchMusicListLayout2.p(str, i12);
                        }
                    }
                });
            }
        });
        o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKSearchMusicListLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15824i = new LinkedHashMap();
        this.f15819d = c.b(new Function0<FKMusicListRecyclerViewAdapter>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$musicListAdapter$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKMusicListRecyclerViewAdapter invoke() {
                FKMusicListRecyclerViewAdapter fKMusicListRecyclerViewAdapter = new FKMusicListRecyclerViewAdapter();
                final FKSearchMusicListLayout fKSearchMusicListLayout = FKSearchMusicListLayout.this;
                fKMusicListRecyclerViewAdapter.l().j(i0.h(f.a(Integer.valueOf(R$id.musicPlayButton), new Function1<Object, p>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$musicListAdapter$2$1$1
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
                            Context context2 = FKSearchMusicListLayout.this.getContext();
                            String musicId = ((MusicListViewModel) obj).getMusicModel().getMusicId();
                            s.h(musicId, "model.musicModel.musicId");
                            cVar.e(context2, musicId);
                        }
                    }
                })));
                return fKMusicListRecyclerViewAdapter;
            }
        });
        this.f15820e = 1;
        this.f15821f = 1;
        this.f15822g = "";
        this.f15823h = c.b(new Function0<FKLoadMoreListener>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$loadMoreListener$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FKLoadMoreListener invoke() {
                final FKSearchMusicListLayout fKSearchMusicListLayout = FKSearchMusicListLayout.this;
                return new FKLoadMoreListener(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.music.view.FKSearchMusicListLayout$loadMoreListener$2.1
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
                        int i102;
                        int i11;
                        String str;
                        int i12;
                        i102 = FKSearchMusicListLayout.this.f15821f;
                        i11 = FKSearchMusicListLayout.this.f15820e;
                        if (i102 <= i11) {
                            FKSearchMusicListLayout fKSearchMusicListLayout2 = FKSearchMusicListLayout.this;
                            str = fKSearchMusicListLayout2.f15822g;
                            i12 = FKSearchMusicListLayout.this.f15821f;
                            fKSearchMusicListLayout2.p(str, i12);
                        }
                    }
                });
            }
        });
        o();
    }
}
