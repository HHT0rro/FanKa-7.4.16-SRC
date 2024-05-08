package com.cupidapp.live.hashtag.list;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.cupidapp.live.hashtag.model.HashTag;
import com.cupidapp.live.hashtag.model.ui.HashTagClassifyModel;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: HashTagListBindings.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {
    @BindingAdapter({"classifies"})
    public static final void a(@NotNull RecyclerView rv, @Nullable List<HashTagClassifyModel> list) {
        s.i(rv, "rv");
        HashTagClassifyAdapter hashTagClassifyAdapter = (HashTagClassifyAdapter) rv.getAdapter();
        if (list == null || hashTagClassifyAdapter == null) {
            return;
        }
        hashTagClassifyAdapter.c(list);
    }

    @BindingAdapter({"contents"})
    public static final void b(@NotNull RecyclerView rv, @Nullable Pair<Boolean, ? extends List<HashTag>> pair) {
        s.i(rv, "rv");
        HashTagContentAdapter hashTagContentAdapter = (HashTagContentAdapter) rv.getAdapter();
        if (hashTagContentAdapter == null || pair == null || pair.getSecond() == null) {
            return;
        }
        hashTagContentAdapter.d(pair.getSecond(), pair.getFirst().booleanValue());
    }
}
