package com.cupidapp.live.liveshow.view.music.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.imageloader.b;
import com.cupidapp.live.base.view.BaseLayout;
import com.hifive.sdk.entity.HifiveMusicAuthorModel;
import com.hifive.sdk.entity.HifiveMusicDetailModel;
import he.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.t;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.h;
import z0.z;

/* compiled from: FKMusicPlayerLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKMusicPlayerLayout extends BaseLayout {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f15818d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKMusicPlayerLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f15818d = new LinkedHashMap();
        g();
    }

    @Nullable
    public View e(int i10) {
        Map<Integer, View> map = this.f15818d;
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

    public final void f(HifiveMusicDetailModel hifiveMusicDetailModel) {
        ImageLoaderView musicPlayerImage = (ImageLoaderView) e(R$id.musicPlayerImage);
        s.h(musicPlayerImage, "musicPlayerImage");
        ImageLoaderView.f(musicPlayerImage, new b(false, hifiveMusicDetailModel.getCover().getUrl(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
        ((TextView) e(R$id.musicNameText)).setText(hifiveMusicDetailModel.getMusicName());
        List<HifiveMusicAuthorModel> artist = hifiveMusicDetailModel.getArtist();
        if (artist == null || artist.isEmpty()) {
            return;
        }
        TextView textView = (TextView) e(R$id.singerNameText);
        List<HifiveMusicAuthorModel> artist2 = hifiveMusicDetailModel.getArtist();
        s.h(artist2, "music.artist");
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
            return;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public final void g() {
        z.a(this, R$layout.layout_music_player, true);
        int i10 = R$id.musicNameText;
        ((TextView) e(i10)).getPaint().setFakeBoldText(true);
        int i11 = R$id.singerNameText;
        ((TextView) e(i11)).getPaint().setFakeBoldText(true);
        ((TextView) e(i10)).setMaxWidth(h.l(this) / 2);
        ((TextView) e(i11)).setMaxWidth(h.l(this) / 2);
    }

    @j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ConfigMusicPlayerEvent event) {
        s.i(event, "event");
        setVisibility(0);
        if (event.isPlaying()) {
            f(event.getMusic());
        } else {
            ((TextView) e(R$id.musicNameText)).setText(getContext().getString(R$string.music_play_end));
            ((TextView) e(R$id.singerNameText)).setText(getContext().getString(R$string.play_next_music));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKMusicPlayerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f15818d = new LinkedHashMap();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKMusicPlayerLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f15818d = new LinkedHashMap();
        g();
    }
}
