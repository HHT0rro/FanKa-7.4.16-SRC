package com.huawei.jmessage.sources;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventSource;
import com.huawei.jmessage.api.Subscriber;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class LifecycleSource extends EventSource {
    public static final String TOPIC = "PageLifecycle";

    /* renamed from: d, reason: collision with root package name */
    private static final String f32063d = "LifecycleSource";

    /* renamed from: a, reason: collision with root package name */
    private LifecycleOwnerGetter f32064a;

    /* renamed from: b, reason: collision with root package name */
    private Map<View, c> f32065b = new WeakHashMap();

    /* renamed from: c, reason: collision with root package name */
    private Set<View> f32066c = new HashSet();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class LifecycleEvent {

        /* renamed from: a, reason: collision with root package name */
        private View f32069a;

        /* renamed from: b, reason: collision with root package name */
        private Lifecycle.Event f32070b;

        /* renamed from: c, reason: collision with root package name */
        private LifecycleOwner f32071c;

        public Lifecycle.Event getEvent() {
            return this.f32070b;
        }

        public LifecycleOwner getLifecycleOwner() {
            return this.f32071c;
        }

        public String getLifecycleState() {
            Lifecycle.Event event = this.f32070b;
            return event == null ? "" : event.name();
        }

        public View getView() {
            return this.f32069a;
        }

        public void setEvent(Lifecycle.Event event) {
            this.f32070b = event;
        }

        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            this.f32071c = lifecycleOwner;
        }

        public void setView(View view) {
            this.f32069a = view;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class LifecycleOwnerGetter {
        public LifecycleOwnerGetter mNextGetter;

        public abstract LifecycleOwner getLifecycleOwner(View view, LifecycleOwner lifecycleOwner);

        public void setNextOwnerGetter(LifecycleOwnerGetter lifecycleOwnerGetter) {
            this.mNextGetter = lifecycleOwnerGetter;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            LifecycleSource.this.a(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b extends LifecycleOwnerGetter {
        private b() {
        }

        private LifecycleOwner a(View view) {
            try {
                return FragmentManager.findFragment(view);
            } catch (IllegalStateException unused) {
                ComponentCallbacks2 a10 = a(view.getContext());
                if (a10 instanceof LifecycleOwner) {
                    return (LifecycleOwner) a10;
                }
                return null;
            }
        }

        @Override // com.huawei.jmessage.sources.LifecycleSource.LifecycleOwnerGetter
        public LifecycleOwner getLifecycleOwner(View view, LifecycleOwner lifecycleOwner) {
            LifecycleOwner a10 = a(view);
            LifecycleOwnerGetter lifecycleOwnerGetter = this.mNextGetter;
            return lifecycleOwnerGetter != null ? lifecycleOwnerGetter.getLifecycleOwner(view, a10) : a10;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }

        private Activity a(Context context) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            return null;
        }
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onDispatch(@NonNull Subscriber subscriber, @NonNull EventCallback.Message message) {
        Object obj = message.payload;
        View a10 = a(subscriber);
        return a10 != null && (obj instanceof LifecycleEvent) && a10 == ((LifecycleEvent) obj).getView();
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onRelease() {
        Log.i(f32063d, "onRelease, PageLifecycle");
        a();
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onSubscribe(@NonNull Subscriber subscriber) {
        View a10 = a(subscriber);
        if (a10 == null || this.f32066c.contains(a10)) {
            return false;
        }
        this.f32066c.add(a10);
        if (a10.isAttachedToWindow()) {
            a(a10);
            return true;
        }
        a10.addOnAttachStateChangeListener(new a());
        return true;
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onUnsubscribe(@NonNull Subscriber subscriber) {
        View a10 = a(subscriber);
        if (a10 != null) {
            b(a10);
        }
    }

    public void setLifecycleOwnerGetter(LifecycleOwnerGetter lifecycleOwnerGetter) {
        this.f32064a = lifecycleOwnerGetter;
    }

    private View a(Subscriber subscriber) {
        Object param = subscriber.getParam();
        if (param instanceof View) {
            return (View) param;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view) {
        c cVar = this.f32065b.get(view);
        if (cVar != null) {
            cVar.a();
        }
        this.f32065b.remove(view);
        this.f32066c.remove(view);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private LifecycleOwner f32073a;

        /* renamed from: b, reason: collision with root package name */
        private LifecycleObserver f32074b;

        public c(LifecycleOwner lifecycleOwner) {
            this.f32073a = lifecycleOwner;
        }

        public void a(LifecycleEventObserver lifecycleEventObserver) {
            LifecycleOwner lifecycleOwner = this.f32073a;
            if (lifecycleOwner != null) {
                lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
                this.f32074b = lifecycleEventObserver;
            }
        }

        public void a() {
            LifecycleOwner lifecycleOwner = this.f32073a;
            if (lifecycleOwner != null) {
                lifecycleOwner.getLifecycle().removeObserver(this.f32074b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (this.f32065b.containsKey(view)) {
            return;
        }
        b bVar = new b(null);
        LifecycleOwnerGetter lifecycleOwnerGetter = this.f32064a;
        if (lifecycleOwnerGetter != null) {
            bVar.setNextOwnerGetter(lifecycleOwnerGetter);
        }
        LifecycleOwner lifecycleOwner = bVar.getLifecycleOwner(view, null);
        if (lifecycleOwner == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(view);
        c cVar = new c(lifecycleOwner);
        cVar.a(new LifecycleEventObserver() { // from class: com.huawei.jmessage.sources.LifecycleSource.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner2, @NonNull Lifecycle.Event event) {
                View view2 = (View) weakReference.get();
                if (view2 == null) {
                    return;
                }
                LifecycleEvent lifecycleEvent = new LifecycleEvent();
                lifecycleEvent.setView(view2);
                lifecycleEvent.setLifecycleOwner(lifecycleOwner2);
                lifecycleEvent.setEvent(event);
                LifecycleSource.this.fire(lifecycleEvent);
                if (event == Lifecycle.Event.ON_DESTROY) {
                    LifecycleSource.this.b(view2);
                }
            }
        });
        this.f32065b.put(view, cVar);
    }

    private void a() {
        Iterator<c> iterator2 = this.f32065b.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a();
        }
    }
}
