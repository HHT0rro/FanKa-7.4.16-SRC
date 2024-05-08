package android.view;

import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface ContextMenu extends Menu {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ContextMenuInfo {
    }

    void clearHeader();

    ContextMenu setHeaderIcon(int i10);

    ContextMenu setHeaderIcon(Drawable drawable);

    ContextMenu setHeaderTitle(int i10);

    ContextMenu setHeaderTitle(CharSequence charSequence);

    ContextMenu setHeaderView(View view);
}
