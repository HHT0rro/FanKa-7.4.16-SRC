package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: Menu.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class MenuKt {
    public static final boolean contains(@NotNull Menu menu, @NotNull MenuItem item) {
        s.i(menu, "<this>");
        s.i(item, "item");
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (s.d(menu.getItem(i10), item)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(@NotNull Menu menu, @NotNull Function1<? super MenuItem, p> action) {
        s.i(menu, "<this>");
        s.i(action, "action");
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = menu.getItem(i10);
            s.h(item, "getItem(index)");
            action.invoke(item);
        }
    }

    public static final void forEachIndexed(@NotNull Menu menu, @NotNull Function2<? super Integer, ? super MenuItem, p> action) {
        s.i(menu, "<this>");
        s.i(action, "action");
        int size = menu.size();
        for (int i10 = 0; i10 < size; i10++) {
            Integer valueOf = Integer.valueOf(i10);
            MenuItem item = menu.getItem(i10);
            s.h(item, "getItem(index)");
            action.mo1743invoke(valueOf, item);
        }
    }

    @NotNull
    public static final MenuItem get(@NotNull Menu menu, int i10) {
        s.i(menu, "<this>");
        MenuItem item = menu.getItem(i10);
        s.h(item, "getItem(index)");
        return item;
    }

    @NotNull
    public static final kotlin.sequences.g<MenuItem> getChildren(@NotNull final Menu menu) {
        s.i(menu, "<this>");
        return new kotlin.sequences.g<MenuItem>() { // from class: androidx.core.view.MenuKt$children$1
            @Override // kotlin.sequences.g
            @NotNull
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(Menu.this);
            }
        };
    }

    public static final int getSize(@NotNull Menu menu) {
        s.i(menu, "<this>");
        return menu.size();
    }

    public static final boolean isEmpty(@NotNull Menu menu) {
        s.i(menu, "<this>");
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull Menu menu) {
        s.i(menu, "<this>");
        return menu.size() != 0;
    }

    @NotNull
    public static final Iterator<MenuItem> iterator(@NotNull Menu menu) {
        s.i(menu, "<this>");
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(@NotNull Menu menu, @NotNull MenuItem item) {
        s.i(menu, "<this>");
        s.i(item, "item");
        menu.removeItem(item.getItemId());
    }

    public static final void removeItemAt(@NotNull Menu menu, int i10) {
        p pVar;
        s.i(menu, "<this>");
        MenuItem item = menu.getItem(i10);
        if (item != null) {
            menu.removeItem(item.getItemId());
            pVar = p.f51048a;
        } else {
            pVar = null;
        }
        if (pVar == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
