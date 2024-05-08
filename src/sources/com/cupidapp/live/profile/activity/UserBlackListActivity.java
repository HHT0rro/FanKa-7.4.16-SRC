package com.cupidapp.live.profile.activity;

import android.view.View;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.fragment.FKBaseFragment;
import com.cupidapp.live.profile.fragment.UserBlackListFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UserBlackListActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UserBlackListActivity extends FKBaseListActivity {

    /* renamed from: s, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f17676s = new LinkedHashMap();

    @Override // com.cupidapp.live.profile.activity.FKBaseListActivity
    @Nullable
    public View j1(int i10) {
        Map<Integer, View> map = this.f17676s;
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

    @Override // com.cupidapp.live.profile.activity.FKBaseListActivity
    @NotNull
    public FKBaseFragment k1() {
        return new UserBlackListFragment();
    }

    @Override // com.cupidapp.live.profile.activity.FKBaseListActivity
    @NotNull
    public String l1() {
        String string = getString(R$string.blacklist);
        kotlin.jvm.internal.s.h(string, "getString(R.string.blacklist)");
        return string;
    }
}
