package com.huawei.flexiblelayout;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.card.props.FLCardProps;
import com.huawei.flexiblelayout.card.props.NumbersPerLineParser;
import com.huawei.flexiblelayout.creator.FLResolverRegistry;
import com.huawei.flexiblelayout.css.CSSDefinition;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.layoutstrategy.ReactLayoutStrategy;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.parser.DataItem;
import com.huawei.flexiblelayout.parser.DataKeys;
import com.huawei.flexiblelayout.parser.FLDataDelegate;
import com.huawei.flexiblelayout.parser.FLDataParser;
import com.huawei.flexiblelayout.parser.FLDataStream;
import com.huawei.flexiblelayout.parser.ParseException;
import com.huawei.flexiblelayout.parser.csslink.LinkProvider;
import com.huawei.flexiblelayout.z0;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.Tasks;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DataParserBase.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class b1 extends FLDataParser {

    /* renamed from: g, reason: collision with root package name */
    private static final String f27728g = "DataParserBase";

    /* renamed from: c, reason: collision with root package name */
    private FLDataDelegate f27729c;

    /* renamed from: d, reason: collision with root package name */
    private z0 f27730d = new z0(new DataKeys());

    /* renamed from: e, reason: collision with root package name */
    private List<CSSDefinition> f27731e;

    /* renamed from: f, reason: collision with root package name */
    public final FLEngine f27732f;

    /* compiled from: DataParserBase.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Callable<FLDataStream> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f27733a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c1 f27734b;

        public a(String str, c1 c1Var) {
            this.f27733a = str;
            this.f27734b = c1Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public FLDataStream call() {
            return b1.this.b(this.f27733a, this.f27734b);
        }
    }

    /* compiled from: DataParserBase.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements Callable<FLDataStream> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JSONArray f27736a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c1 f27737b;

        public b(JSONArray jSONArray, c1 c1Var) {
            this.f27736a = jSONArray;
            this.f27737b = c1Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public FLDataStream call() {
            return b1.this.b(this.f27736a, this.f27737b);
        }
    }

    /* compiled from: DataParserBase.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final Executor f27739a = Executors.newFixedThreadPool(2);

        private c() {
        }
    }

    public b1(@NonNull FLEngine fLEngine) {
        this.f27732f = fLEngine;
    }

    private LinkProvider c(JSONObject jSONObject) {
        if (this.f27731e == null) {
            return null;
        }
        String link = b().link();
        String optString = TextUtils.isEmpty(link) ? CSSDefinition.PAGE_LINK : jSONObject.optString(link);
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return new LinkProvider.Builder(this.f27731e).setLink(optString).build();
    }

    public final z0 b() {
        return this.f27730d;
    }

    public abstract void b(JSONObject jSONObject, @NonNull FLDataStream fLDataStream);

    @Override // com.huawei.flexiblelayout.parser.FLDataParser
    @NonNull
    public Task<FLDataStream> parse(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(f27728g, "layoutData must not be empty.");
            k1.f28183a.put("code", (Number) 1).build(this.f27732f.getContext()).report();
            return Tasks.fromException(new ParseException("layoutData must not be empty."));
        }
        return a(a(str, new c1(this.f27732f, this, this.f27729c)));
    }

    @Nullable
    public DataItem b(@NonNull DataItem dataItem, @NonNull DataItem dataItem2) {
        FLDataDelegate fLDataDelegate = this.f27729c;
        return fLDataDelegate != null ? fLDataDelegate.onParseNode(dataItem, dataItem2) : dataItem2;
    }

    public void a(DataKeys dataKeys) {
        if (dataKeys != null) {
            this.f27730d = new z0(dataKeys);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FLDataStream b(@NonNull String str, @NonNull c1 c1Var) throws ParseException {
        try {
            try {
                return b(new JSONArray(str), c1Var);
            } catch (JSONException e2) {
                c1Var.setResult(1);
                Log.e(f27728g, "Failed to new JSONObject or JSONArray from the 'data'.");
                k1.f28183a.put("code", (Number) 1).build(this.f27732f.getContext()).report();
                throw new ParseException("Failed to new JSONObject or JSONArray from the 'data'.", e2);
            }
        } catch (JSONException unused) {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.length() != 0) {
                return b(new JSONArray().put(jSONObject), c1Var);
            }
            Log.e(f27728g, "layoutData must not be empty.");
            throw new ParseException("layoutData must not be empty.");
        }
    }

    public void a(List<CSSDefinition> list) {
        this.f27731e = list;
    }

    public void a(FLDataDelegate fLDataDelegate) {
        this.f27729c = fLDataDelegate;
    }

    @Nullable
    public DataItem a(@NonNull DataItem dataItem, @NonNull DataItem dataItem2) {
        FLDataDelegate fLDataDelegate = this.f27729c;
        return fLDataDelegate != null ? fLDataDelegate.onParseGroup(dataItem, dataItem2) : dataItem2;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataParser
    @NonNull
    public Task<FLDataStream> parse(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            return parse(new JSONArray().put(jSONObject));
        }
        Log.e(f27728g, "layoutData must not be empty.");
        return Tasks.fromException(new ParseException("layoutData must not be empty."));
    }

    private Callable<FLDataStream> a(@NonNull String str, @NonNull c1 c1Var) {
        return new a(str, c1Var);
    }

    private Callable<FLDataStream> a(@NonNull JSONArray jSONArray, @NonNull c1 c1Var) {
        return new b(jSONArray, c1Var);
    }

    private static <TResult> Task<TResult> a(Callable<TResult> callable) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return Tasks.call(callable);
        }
        return Tasks.callInBackground(c.f27739a, callable);
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataParser
    @NonNull
    public Task<FLDataStream> parse(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            return a(a(jSONArray, new c1(this.f27732f, this, this.f27729c)));
        }
        Log.e(f27728g, "layoutData must not be empty.");
        return Tasks.fromException(new ParseException("layoutData must not be empty."));
    }

    public DataItem a(JSONObject jSONObject, @NonNull FLDataStream fLDataStream) {
        int optInt = jSONObject.optInt(b().groupId(), 0);
        DataItem root = fLDataStream.getRoot();
        DataItem childById = root.getChildById(optInt);
        if (childById != null) {
            return childById;
        }
        DataItem a10 = a(root, DataItem.groupIt(optInt).setData(Jsons.toJson(jSONObject)));
        if (a10 != null) {
            root.addChild(a10);
            a(a10, jSONObject);
        }
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FLDataStream b(@NonNull JSONArray jSONArray, @NonNull c1 c1Var) throws ParseException {
        if (jSONArray.length() != 0) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    b(optJSONObject, c1Var);
                }
            }
            k1.f28183a.put("code", Integer.valueOf(c1Var.getResult())).build(this.f27732f.getContext()).report();
            c1Var.a();
            return c1Var;
        }
        Log.e(f27728g, "layoutData must not be empty.");
        throw new ParseException("layoutData must not be empty.");
    }

    private void a(DataItem dataItem, JSONObject jSONObject) {
        ReactLayoutStrategy b4 = b(jSONObject);
        if (b4 != null) {
            dataItem.setGroupLayoutStrategy(b4);
        }
        LinkProvider c4 = c(jSONObject);
        if (c4 != null) {
            dataItem.setLinkProvider(c4);
        }
    }

    private ReactLayoutStrategy b(JSONObject jSONObject) {
        FLCardProps.CardNumbersPerLine parse;
        JSONObject optJSONObject = jSONObject.optJSONObject("flex");
        if (optJSONObject == null || (parse = NumbersPerLineParser.parse(optJSONObject.optString("align"))) == null) {
            return null;
        }
        ReactLayoutStrategy reactLayoutStrategy = new ReactLayoutStrategy(this.f27732f, parse.build(), com.huawei.flexiblelayout.common.c.a(this.f27732f.getContext(), optJSONObject.optInt(z0.a.f28679c)));
        a(reactLayoutStrategy, optJSONObject);
        return reactLayoutStrategy;
    }

    private static void a(ReactLayoutStrategy reactLayoutStrategy, @NonNull JSONObject jSONObject) {
        String optString = jSONObject.optString("mode");
        if ("loose".equals(optString)) {
            reactLayoutStrategy.setLineBreakMode(ReactLayoutStrategy.LineBreakMode.loose);
        } else if ("strict".equals(optString)) {
            reactLayoutStrategy.setLineBreakMode(ReactLayoutStrategy.LineBreakMode.strict);
        }
    }

    public String a(JSONObject jSONObject) {
        String optString = jSONObject.optString(b().type());
        return (!TextUtils.isEmpty(optString) && FLResolverRegistry.isDefinedCard(optString)) ? optString : "";
    }

    public void a(DataItem dataItem, String str, JSONObject jSONObject) {
        DataItem style;
        JSONArray optJSONArray = jSONObject.optJSONArray(b().data());
        if (optJSONArray == null) {
            Log.w(f27728g, "Ignore dirty data, Not found data for compat-card: " + str + ".");
            return;
        }
        Object opt = jSONObject.opt(b().style());
        for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
            FLMap json = Jsons.toJson(optJSONArray.opt(i10));
            DataItem b4 = b(dataItem, DataItem.nodeIt("").setData(json));
            if (b4 != null && (style = DataItem.cardIt(str).setData(json).setStyle(opt)) != null && style.getType() != null && FLResolverRegistry.isDefinedCard(style.getType())) {
                b4.addChild(style);
                dataItem.addChild(b4);
            }
        }
    }
}
