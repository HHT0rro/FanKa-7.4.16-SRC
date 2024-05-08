package android.view;

import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface SubMenu extends Menu {
    void clearHeader();

    MenuItem getItem();

    SubMenu setHeaderIcon(int i10);

    SubMenu setHeaderIcon(Drawable drawable);

    SubMenu setHeaderTitle(int i10);

    SubMenu setHeaderTitle(CharSequence charSequence);

    SubMenu setHeaderView(View view);

    SubMenu setIcon(int i10);

    SubMenu setIcon(Drawable drawable);
}
