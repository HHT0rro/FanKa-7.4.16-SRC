package com.huawei.quickcard.framework.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.IVirtualView;
import com.huawei.quickcard.views.div.Div;
import com.huawei.quickcard.views.image.Image;
import com.huawei.quickcard.views.list.QList;
import com.huawei.quickcard.views.list.listitem.QListItem;
import com.huawei.quickcard.views.progress.CircularProgress;
import com.huawei.quickcard.views.progress.HorizontalProgress;
import com.huawei.quickcard.views.stack.component.Stack;
import com.huawei.quickcard.views.text.component.Text;
import com.huawei.quickcard.views.text.span.Span;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ComponentRegistry {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33960a = "ComponentRegistry";

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Component> f33961b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Map<String, IVirtualView> f33962c = new HashMap();

    static {
        register(new Div());
        register(new Text());
        register(new Image());
        register(new Stack());
        register(new QList());
        register(new QListItem());
        registers(new HorizontalProgress());
        registers(new CircularProgress());
        registerVirtualView(new Span());
        registerVirtualView(new com.huawei.quickcard.a());
    }

    private static void a(String str, Component component) {
        CardLogUtils.i(f33960a, "register " + str);
        f33961b.put(str, component);
    }

    @Nullable
    public static Component get(String str) {
        Map<String, Component> map = f33961b;
        Component component = map.get(str);
        return component == null ? map.get(Attributes.Component.DIV) : component;
    }

    public static IVirtualView getVirtualView(String str) {
        return f33962c.get(str);
    }

    @NonNull
    public static List<String> querySupportedComponent() {
        return new LinkedList(f33961b.h());
    }

    public static void register(Component component) {
        a(component.getName(), component);
    }

    public static void registerVirtualView(IVirtualView iVirtualView) {
        a(iVirtualView.getName(), iVirtualView);
    }

    public static void registers(@NonNull Component component) {
        String[] names = component.getNames();
        if (names == null || names.length <= 0) {
            return;
        }
        for (String str : names) {
            a(str, component);
        }
    }

    private static void a(String str, IVirtualView iVirtualView) {
        CardLogUtils.i(f33960a, "register " + str);
        f33962c.put(str, iVirtualView);
    }
}
