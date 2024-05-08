package com.cupidapp.live.liveshow.view.music.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cupidapp.live.R$drawable;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder;
import com.cupidapp.live.base.utils.h;
import com.cupidapp.live.liveshow.view.music.model.MusicListViewModel;
import com.hifive.sdk.entity.HifiveMusicAuthorModel;
import com.hifive.sdk.entity.HifiveMusicModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.v;
import z0.z;

/* compiled from: FKMusicListRecyclerViewAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKMusicListViewHolder extends FKBaseRecyclerViewHolder {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f15794c = new a(null);

    /* compiled from: FKMusicListRecyclerViewAdapter.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FKMusicListViewHolder a(@NotNull ViewGroup parent) {
            s.i(parent, "parent");
            return new FKMusicListViewHolder(z.b(parent, R$layout.view_holder_music_list, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKMusicListViewHolder(@NotNull View itemView) {
        super(itemView);
        s.i(itemView, "itemView");
    }

    @Override // com.cupidapp.live.base.recyclerview.FKBaseRecyclerViewHolder
    public void n(@Nullable Object obj) {
        if (obj instanceof MusicListViewModel) {
            MusicListViewModel musicListViewModel = (MusicListViewModel) obj;
            HifiveMusicModel musicModel = musicListViewModel.getMusicModel();
            ImageLoaderView imageLoaderView = (ImageLoaderView) this.itemView.findViewById(R$id.musicCoverImage);
            s.h(imageLoaderView, "itemView.musicCoverImage");
            ImageLoaderView.f(imageLoaderView, new b(false, musicModel.getCover().getUrl(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
            View view = this.itemView;
            int i10 = R$id.musicName;
            boolean z10 = true;
            ((TextView) view.findViewById(i10)).getPaint().setFakeBoldText(true);
            View view2 = this.itemView;
            int i11 = R$id.singerName;
            ((TextView) view2.findViewById(i11)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(R$id.musicDuration)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(R$id.musicPlayButton)).getPaint().setFakeBoldText(true);
            ((TextView) this.itemView.findViewById(i10)).setText(musicModel.getMusicName());
            List<HifiveMusicAuthorModel> artist = musicModel.getArtist();
            if (artist != null && !artist.isEmpty()) {
                z10 = false;
            }
            if (!z10) {
                TextView textView = (TextView) this.itemView.findViewById(i11);
                List<HifiveMusicAuthorModel> artist2 = musicModel.getArtist();
                s.h(artist2, "musicModel.artist");
                ArrayList arrayList = new ArrayList(t.t(artist2, 10));
                Iterator<HifiveMusicAuthorModel> iterator2 = artist2.iterator2();
                while (iterator2.hasNext()) {
                    arrayList.add(iterator2.next().getName());
                }
                Iterator<E> iterator22 = arrayList.iterator2();
                if (iterator22.hasNext()) {
                    Object next = iterator22.next();
                    while (iterator22.hasNext()) {
                        next = ((String) next) + "," + ((String) iterator22.next());
                    }
                    textView.setText((CharSequence) next);
                } else {
                    throw new UnsupportedOperationException("Empty collection can't be reduced.");
                }
            }
            ((TextView) this.itemView.findViewById(R$id.musicDuration)).setText(v.j(musicListViewModel.getMusicModel().getDuration()));
            r(musicListViewModel.isPlaying());
        }
    }

    public final void r(boolean z10) {
        int i10 = z10 ? R$drawable.shape_red_15_alpha_fourteen_corenrs_bg : R$drawable.shape_red_fourteen_corners_bg;
        int a10 = z10 ? h.a(-1, 0.6f) : -1;
        String string = this.itemView.getContext().getString(z10 ? R$string.music_is_playing : R$string.play_music);
        s.h(string, "if (isPlaying) itemView.…ring(R.string.play_music)");
        View view = this.itemView;
        int i11 = R$id.musicPlayButton;
        ((TextView) view.findViewById(i11)).setBackgroundResource(i10);
        ((TextView) this.itemView.findViewById(i11)).setTextColor(a10);
        ((TextView) this.itemView.findViewById(i11)).setText(string);
        ((TextView) this.itemView.findViewById(i11)).setEnabled(!z10);
    }
}
