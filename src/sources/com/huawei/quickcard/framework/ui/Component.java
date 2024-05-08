package com.huawei.quickcard.framework.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.core.R;
import com.huawei.quickcard.framework.blur.BlurAttribute;
import com.huawei.quickcard.framework.processor.ActionsAttribute;
import com.huawei.quickcard.framework.processor.BorderProcessor;
import com.huawei.quickcard.framework.processor.ContentDescriptionProcessor;
import com.huawei.quickcard.framework.processor.DirProcessor;
import com.huawei.quickcard.framework.processor.DisableProcessor;
import com.huawei.quickcard.framework.processor.EventProcessor;
import com.huawei.quickcard.framework.processor.ExposureProcessor;
import com.huawei.quickcard.framework.processor.ExtendExposureProcessor;
import com.huawei.quickcard.framework.processor.FlexCommonStyle;
import com.huawei.quickcard.framework.processor.FocusableProcessor;
import com.huawei.quickcard.framework.processor.FoolProofingProcessor;
import com.huawei.quickcard.framework.processor.HeightStyle;
import com.huawei.quickcard.framework.processor.IDProcessor;
import com.huawei.quickcard.framework.processor.MarginStyle;
import com.huawei.quickcard.framework.processor.OpacityProcessor;
import com.huawei.quickcard.framework.processor.OutLineProcessor;
import com.huawei.quickcard.framework.processor.PaddingStyle;
import com.huawei.quickcard.framework.processor.PositionStyle;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.processor.ShowAttribute;
import com.huawei.quickcard.framework.processor.TagAttribute;
import com.huawei.quickcard.framework.processor.WidthStyle;
import com.huawei.quickcard.framework.processor.animation.AnimationProcessor;
import com.huawei.quickcard.framework.processor.animation.TransformProcessor;
import com.huawei.quickcard.framework.processor.background.BackgroundImageProcessor;
import com.huawei.quickcard.framework.processor.background.BackgroundStyle;
import com.huawei.quickcard.framework.value.QuickCardValue;
import com.huawei.quickcard.g0;
import com.huawei.quickcard.p1;
import com.huawei.quickcard.s;
import com.huawei.quickcard.utils.ValueUtils;
import com.huawei.quickcard.utils.ViewUtils;
import com.huawei.quickcard.w0;
import com.huawei.quickcard.w1;
import com.huawei.quickcard.watcher.IWatcherManager;
import com.huawei.quickcard.watcher.Watcher;
import com.huawei.quickcard.z0;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class Component<T extends View> {

    /* renamed from: c, reason: collision with root package name */
    private final Handler f33955c = new a(Looper.getMainLooper());

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, PropertyProcessor<T>> f33953a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final ActionsAttribute<T> f33954b = new ActionsAttribute<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            Object obj = message.obj;
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (bVar.f33957a != null) {
                    bVar.f33957a.render(bVar.f33958b, bVar.f33959c);
                }
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private RenderPipeline f33957a;

        /* renamed from: b, reason: collision with root package name */
        private CardContext f33958b;

        /* renamed from: c, reason: collision with root package name */
        private View f33959c;

        private b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public Component() {
        a();
        b();
    }

    private void a() {
        WidthStyle widthStyle = new WidthStyle();
        addProcessor("width", widthStyle);
        addProcessor(Attributes.Style.MIN_WIDTH, widthStyle);
        addProcessor("maxWidth", widthStyle);
        HeightStyle heightStyle = new HeightStyle();
        addProcessor("height", heightStyle);
        addProcessor(Attributes.Style.MIN_HEIGHT, heightStyle);
        addProcessor("maxHeight", heightStyle);
        BackgroundStyle backgroundStyle = new BackgroundStyle();
        addProcessor("backgroundColor", backgroundStyle);
        addProcessor("backgroundImage", backgroundStyle);
        addProcessor(Attributes.Style.BACKGROUND, backgroundStyle);
        BackgroundImageProcessor backgroundImageProcessor = new BackgroundImageProcessor();
        addProcessor(Attributes.Style.BACKGROUND_SIZE, backgroundImageProcessor);
        addProcessor(Attributes.Style.BACKGROUND_POSITION, backgroundImageProcessor);
        addProcessor(Attributes.Style.BACKGROUND_REPEAT, backgroundImageProcessor);
        addProcessor(Attributes.Style.ACTIONS, this.f33954b);
        addProcessor("show", new ShowAttribute());
        addProcessor("tag", new TagAttribute());
        PaddingStyle paddingStyle = new PaddingStyle();
        addProcessor("padding", paddingStyle);
        addProcessor("paddingLeft", paddingStyle);
        addProcessor("paddingRight", paddingStyle);
        addProcessor("paddingTop", paddingStyle);
        addProcessor("paddingBottom", paddingStyle);
        addProcessor(Attributes.Style.PADDING_INLINE_START, paddingStyle);
        addProcessor(Attributes.Style.PADDING_INLINE_END, paddingStyle);
        MarginStyle marginStyle = new MarginStyle();
        addProcessor("margin", marginStyle);
        addProcessor("marginLeft", marginStyle);
        addProcessor("marginRight", marginStyle);
        addProcessor("marginTop", marginStyle);
        addProcessor("marginBottom", marginStyle);
        addProcessor(Attributes.Style.MARGIN_INLINE_START, marginStyle);
        addProcessor(Attributes.Style.MARGIN_INLINE_END, marginStyle);
        FlexCommonStyle flexCommonStyle = new FlexCommonStyle();
        addProcessor("flex", flexCommonStyle);
        addProcessor(Attributes.Style.FLEX_GROW, flexCommonStyle);
        addProcessor(Attributes.Style.FLEX_SHRINK, flexCommonStyle);
        addProcessor(Attributes.Style.FLEX_BASIS, flexCommonStyle);
        BorderProcessor borderProcessor = new BorderProcessor();
        addProcessor(Attributes.Style.BORDER_COLOR, borderProcessor);
        addProcessor(Attributes.Style.BORDER_LEFT_COLOR, borderProcessor);
        addProcessor(Attributes.Style.BORDER_TOP_COLOR, borderProcessor);
        addProcessor(Attributes.Style.BORDER_RIGHT_COLOR, borderProcessor);
        addProcessor(Attributes.Style.BORDER_BOTTOM_COLOR, borderProcessor);
        addProcessor(Attributes.Style.BORDER_WIDTH, borderProcessor);
        addProcessor(Attributes.Style.BORDER_LEFT_WIDTH, borderProcessor);
        addProcessor(Attributes.Style.BORDER_TOP_WIDTH, borderProcessor);
        addProcessor(Attributes.Style.BORDER_RIGHT_WIDTH, borderProcessor);
        addProcessor(Attributes.Style.BORDER_BOTTOM_WIDTH, borderProcessor);
        addProcessor(Attributes.Style.BORDER_STYLE, borderProcessor);
        addProcessor(Attributes.Style.BORDER_LEFT_STYLE, borderProcessor);
        addProcessor(Attributes.Style.BORDER_TOP_STYLE, borderProcessor);
        addProcessor(Attributes.Style.BORDER_RIGHT_STYLE, borderProcessor);
        addProcessor(Attributes.Style.BORDER_BOTTOM_STYLE, borderProcessor);
        addProcessor(Attributes.Style.BORDER_RADIUS, borderProcessor);
        addProcessor(Attributes.Style.BORDER_BOTTOM_LEFT_RADIUS, borderProcessor);
        addProcessor(Attributes.Style.BORDER_BOTTOM_RIGHT_RADIUS, borderProcessor);
        addProcessor(Attributes.Style.BORDER_TOP_LEFT_RADIUS, borderProcessor);
        addProcessor(Attributes.Style.BORDER_TOP_RIGHT_RADIUS, borderProcessor);
        PositionStyle positionStyle = new PositionStyle();
        addProcessor("position", positionStyle);
        addProcessor("top", positionStyle);
        addProcessor("bottom", positionStyle);
        addProcessor("right", positionStyle);
        addProcessor("left", positionStyle);
        DirProcessor dirProcessor = new DirProcessor();
        addProcessor(Attributes.Style.DIR, dirProcessor);
        addProcessor("flexDirection", dirProcessor);
        addProcessor(Attributes.Style.OPACITY, new OpacityProcessor());
        addProcessor("id", new IDProcessor());
        addProcessor(Attributes.Style.DISABLED, new DisableProcessor());
        ContentDescriptionProcessor contentDescriptionProcessor = new ContentDescriptionProcessor();
        addProcessor(Attributes.Style.CONTENT_DESCRIPTION, contentDescriptionProcessor);
        addProcessor(Attributes.Style.CONTENT_DESCRIPTION_SWITCH, contentDescriptionProcessor);
        addProcessor(Attributes.Style.CONTENT_DESCRIPTION_ACTION, contentDescriptionProcessor);
        addProcessor(Attributes.Style.CONTENT_DESCRIPTION_LIVE, contentDescriptionProcessor);
        addProcessor("blur", new BlurAttribute());
        addProcessor("exposure", new ExposureProcessor());
        addProcessor(Attributes.Style.EXTEND_EXPOSURE, new ExtendExposureProcessor());
        addProcessor("transform", new TransformProcessor());
        AnimationProcessor animationProcessor = new AnimationProcessor();
        addProcessor("transformOrigin", animationProcessor);
        addProcessor(Attributes.AnimationStyle.ANIMATION_NAME, animationProcessor);
        addProcessor("animationDelay", animationProcessor);
        addProcessor("animationDuration", animationProcessor);
        addProcessor("animationIterationCount", animationProcessor);
        addProcessor("animationTimingFunction", animationProcessor);
        addProcessor("animationFillMode", animationProcessor);
        addProcessor(Attributes.Style.FOCUSABLE, new FocusableProcessor());
        addProcessor(Attributes.SelfStyle.OUTLINE, new OutLineProcessor());
        addProcessor(Attributes.Style.FOOL_PROOFING_TIME, new FoolProofingProcessor());
    }

    private void b() {
        addEventProcessor("click", new s());
        addEventProcessor(Attributes.Event.LONGPRESS, new w0());
        g0 g0Var = new g0();
        addEventProcessor(Attributes.Event.FOCUS, g0Var);
        addEventProcessor("blur", g0Var);
        w1 w1Var = new w1();
        addEventProcessor(Attributes.Event.TOUCHSTART, w1Var);
        addEventProcessor(Attributes.Event.TOUCHEND, w1Var);
        addEventProcessor(Attributes.Event.TOUCHMOVE, w1Var);
        addEventProcessor(Attributes.Event.TOUCHCANCEL, w1Var);
    }

    private RenderCommand c(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        if (quickCardValue.isExpression()) {
            a((Component<T>) t2, str, quickCardValue);
            return null;
        }
        b(t2, str, quickCardValue);
        ValueUtils.obtainPropertyCacheBeanFromView(t2).saveAttrOrStyle(str, quickCardValue);
        return buildRenderCommand(t2, str, quickCardValue);
    }

    public void addEventProcessor(String str, EventProcessor<T> eventProcessor) {
        this.f33954b.registerProcessor(str, eventProcessor);
    }

    public void addProcessor(String str, PropertyProcessor<T> propertyProcessor) {
        this.f33953a.put(str, propertyProcessor);
    }

    public void bindAllPseudoStylesRenderCommand(@NonNull T t2, @NonNull RenderPipeline renderPipeline) {
        CardContext a10;
        z0 z0Var = (z0) t2.getTag(R.id.quick_card_pseudo_class);
        if (z0Var == null) {
            return;
        }
        Map<String, QuickCardValue> a11 = z0Var.a();
        if (a11.isEmpty() || (a10 = a(t2)) == null) {
            return;
        }
        for (Map.Entry<String, QuickCardValue> entry : a11.entrySet()) {
            QuickCardValue value = entry.getValue();
            QuickCardValue quickCardValue = (value == null || value.getExpression() == null) ? value : toQuickCardValue(entry.getKey(), a10.executeExpr(ViewUtils.composeForItemScript(t2, value.getExpression().getSrc(), true), false));
            ValueUtils.obtainPropertyCacheBeanFromView(t2).saveAttrOrStyle(entry.getKey(), quickCardValue);
            RenderCommand buildRenderCommand = buildRenderCommand(t2, entry.getKey(), quickCardValue);
            if (buildRenderCommand != null && value != null) {
                buildRenderCommand.setPseudoClass(true);
                renderPipeline.addCommand(buildRenderCommand);
            }
        }
    }

    public void bindAttributesRenderCommand(@NonNull T t2, @NonNull Map<String, QuickCardValue> map, @NonNull RenderPipeline renderPipeline) {
        for (Map.Entry<String, QuickCardValue> entry : map.entrySet()) {
            RenderCommand c4 = c(t2, entry.getKey(), entry.getValue());
            if (c4 != null) {
                renderPipeline.addCommand(c4);
            }
        }
    }

    public void bindStylesRenderCommand(@NonNull T t2, @NonNull Map<String, Map<String, QuickCardValue>> map, @NonNull RenderPipeline renderPipeline) {
        RenderCommand c4;
        for (Map.Entry<String, Map<String, QuickCardValue>> entry : map.entrySet()) {
            Map<String, QuickCardValue> value = entry.getValue();
            if (value != null) {
                for (Map.Entry<String, QuickCardValue> entry2 : value.entrySet()) {
                    String key = entry2.getKey();
                    String key2 = entry.getKey();
                    QuickCardValue value2 = entry2.getValue();
                    int i10 = R.id.quick_card_pseudo_class;
                    z0 z0Var = (z0) t2.getTag(i10);
                    if (z0Var == null) {
                        z0Var = new z0();
                        t2.setTag(i10, z0Var);
                    }
                    z0Var.a(key, key2, value2);
                    if ("normal".equals(key) && (c4 = c(t2, key2, value2)) != null) {
                        renderPipeline.addCommand(c4);
                    }
                }
            }
        }
    }

    public RenderCommand buildRenderCommand(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        PropertyProcessor<T> propertyProcessor = this.f33953a.get(str);
        if (propertyProcessor != null) {
            return new p1(propertyProcessor, t2, str, quickCardValue);
        }
        return null;
    }

    public T createView(Context context) {
        return createViewImpl(context);
    }

    public abstract T createViewImpl(Context context);

    @NonNull
    public abstract String getName();

    public String[] getNames() {
        return new String[]{getName()};
    }

    public Map<String, PropertyProcessor<T>> getProcessorMap() {
        return this.f33953a;
    }

    public boolean onViewStateChanged(CardContext cardContext, T t2, String str, boolean z10, long j10) {
        RenderPipeline renderPipeline = new RenderPipeline();
        a(cardContext, t2, str, z10, renderPipeline);
        if (renderPipeline.isEmpty()) {
            return false;
        }
        if (ViewUtils.hasCSSTag(cardContext, t2)) {
            bindAllPseudoStylesRenderCommand(t2, renderPipeline);
        }
        if (j10 > 0) {
            b bVar = new b(null);
            bVar.f33957a = renderPipeline;
            bVar.f33958b = cardContext;
            bVar.f33959c = t2;
            Message obtainMessage = this.f33955c.obtainMessage();
            obtainMessage.what = hashCode();
            obtainMessage.obj = bVar;
            this.f33955c.sendMessageDelayed(obtainMessage, j10);
            return true;
        }
        this.f33955c.removeMessages(hashCode());
        renderPipeline.render(cardContext, t2);
        return true;
    }

    public void removeEventProcessor(String str) {
        this.f33954b.removeProcessor(str);
    }

    public void removeProcessor(String str) {
        this.f33953a.remove(str);
    }

    public void setEvents(@NonNull T t2, @NonNull Set<String> set) {
    }

    public QuickCardValue toQuickCardValue(String str, Object obj) {
        QuickCardValue wrap = QuickCardValue.wrap(obj);
        if (wrap.isExpression()) {
            return wrap;
        }
        PropertyProcessor<T> propertyProcessor = getProcessorMap().get(str);
        if (propertyProcessor != null) {
            return propertyProcessor.parseToValue(str, obj);
        }
        return QuickCardValue.wrap(obj);
    }

    public void updateHostViewStyles(@NonNull View view, @NonNull Map<String, Map<String, QuickCardValue>> map) {
        for (Map.Entry<String, Map<String, QuickCardValue>> entry : map.entrySet()) {
            Map<String, QuickCardValue> value = entry.getValue();
            if (value != null) {
                for (Map.Entry<String, QuickCardValue> entry2 : value.entrySet()) {
                    String key = entry2.getKey();
                    String key2 = entry.getKey();
                    QuickCardValue value2 = entry2.getValue();
                    int i10 = R.id.quick_card_pseudo_class;
                    z0 z0Var = (z0) view.getTag(i10);
                    if (z0Var == null) {
                        z0Var = new z0();
                        view.setTag(i10, z0Var);
                    }
                    z0Var.a(key, key2, value2);
                }
            }
        }
    }

    private void b(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        CardContext a10;
        if (quickCardValue == null) {
            return;
        }
        if ((quickCardValue.isDp() || quickCardValue.isSp()) && (a10 = a(t2)) != null) {
            IWatcherManager watcherManager = a10.getWatcherManager();
            watcherManager.watchDPAttr(t2.hashCode(), str, quickCardValue, new com.huawei.quickcard.framework.ui.a(t2, a10));
            if (quickCardValue.isSp()) {
                watcherManager.watchSPAttr(t2.hashCode(), str, quickCardValue, new com.huawei.quickcard.framework.ui.a(t2, a10));
            }
        }
    }

    private Watcher a(@NonNull T t2, String str, QuickCardValue quickCardValue) {
        CardContext a10 = a(t2);
        IWatcherManager watcherManager = a10.getWatcherManager();
        if (quickCardValue.isExpression()) {
            return watcherManager.watchAttr(str, quickCardValue.getExpression(), new com.huawei.quickcard.framework.ui.a(t2, a10));
        }
        return null;
    }

    private void a(@NonNull T t2, QuickCardValue quickCardValue, String str) {
        if (quickCardValue != null) {
            if (quickCardValue.isDp() || quickCardValue.isSp()) {
                IWatcherManager watcherManager = a(t2).getWatcherManager();
                watcherManager.removeDPWatcher(t2.hashCode(), str);
                if (quickCardValue.isSp()) {
                    watcherManager.removeSPWatcher(t2.hashCode(), str);
                }
            }
        }
    }

    private CardContext a(@NonNull T t2) {
        return (CardContext) t2.getTag(R.id.quick_card_context);
    }

    private void a(CardContext cardContext, T t2, String str, boolean z10, @NonNull RenderPipeline renderPipeline) {
        Map<String, QuickCardValue> a10;
        z0 z0Var = (z0) t2.getTag(R.id.quick_card_pseudo_class);
        if (z0Var == null || (a10 = z0Var.a(str, z10)) == null || a10.isEmpty()) {
            return;
        }
        for (Map.Entry<String, QuickCardValue> entry : a10.entrySet()) {
            QuickCardValue value = entry.getValue();
            QuickCardValue quickCardValue = (value == null || value.getExpression() == null) ? value : toQuickCardValue(entry.getKey(), cardContext.executeExpr(ViewUtils.composeForItemScript(t2, value.getExpression().getSrc(), true), false));
            a((Component<T>) t2, value, entry.getKey());
            b(t2, entry.getKey(), quickCardValue);
            ValueUtils.obtainPropertyCacheBeanFromView(t2).saveAttrOrStyle(entry.getKey(), quickCardValue);
            RenderCommand buildRenderCommand = buildRenderCommand(t2, entry.getKey(), quickCardValue);
            if (buildRenderCommand != null && value != null) {
                renderPipeline.addCommand(buildRenderCommand);
            }
        }
    }
}
