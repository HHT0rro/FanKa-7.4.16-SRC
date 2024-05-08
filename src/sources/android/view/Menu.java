package android.view;

import android.content.ComponentName;
import android.content.Intent;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface Menu {
    public static final int CATEGORY_ALTERNATIVE = 262144;
    public static final int CATEGORY_CONTAINER = 65536;
    public static final int CATEGORY_MASK = -65536;
    public static final int CATEGORY_SECONDARY = 196608;
    public static final int CATEGORY_SHIFT = 16;
    public static final int CATEGORY_SYSTEM = 131072;
    public static final int FIRST = 1;
    public static final int FLAG_ALWAYS_PERFORM_CLOSE = 2;
    public static final int FLAG_APPEND_TO_GROUP = 1;
    public static final int FLAG_PERFORM_NO_CLOSE = 1;
    public static final int NONE = 0;
    public static final int SUPPORTED_MODIFIERS_MASK = 69647;
    public static final int USER_MASK = 65535;
    public static final int USER_SHIFT = 0;

    MenuItem add(int i10);

    MenuItem add(int i10, int i11, int i12, int i13);

    MenuItem add(int i10, int i11, int i12, CharSequence charSequence);

    MenuItem add(CharSequence charSequence);

    int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr);

    SubMenu addSubMenu(int i10);

    SubMenu addSubMenu(int i10, int i11, int i12, int i13);

    SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence);

    SubMenu addSubMenu(CharSequence charSequence);

    void clear();

    void close();

    MenuItem findItem(int i10);

    MenuItem getItem(int i10);

    boolean hasVisibleItems();

    boolean isShortcutKey(int i10, KeyEvent keyEvent);

    boolean performIdentifierAction(int i10, int i11);

    boolean performShortcut(int i10, KeyEvent keyEvent, int i11);

    void removeGroup(int i10);

    void removeItem(int i10);

    void setGroupCheckable(int i10, boolean z10, boolean z11);

    void setGroupEnabled(int i10, boolean z10);

    void setGroupVisible(int i10, boolean z10);

    void setQwertyMode(boolean z10);

    int size();

    default void setOptionalIconsVisible(boolean visible) {
    }

    default void setGroupDividerEnabled(boolean groupDividerEnabled) {
    }
}
