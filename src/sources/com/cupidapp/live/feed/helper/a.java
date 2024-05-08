package com.cupidapp.live.feed.helper;

import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.cupidapp.live.mentionuser.model.ReplaceAtModel;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AtUserDisplayHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f14304a = new a();

    /* compiled from: Comparisons.kt */
    @kotlin.d
    /* renamed from: com.cupidapp.live.feed.helper.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class C0153a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t2, T t10) {
            return qd.a.a(((ReplaceAtModel) t2).getIndex(), ((ReplaceAtModel) t10).getIndex());
        }
    }

    /* compiled from: AtUserDisplayHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends ClickableSpan {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<String, p> f14305b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ReplaceAtModel f14306c;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super String, p> function1, ReplaceAtModel replaceAtModel) {
            this.f14305b = function1;
            this.f14306c = replaceAtModel;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            s.i(widget, "widget");
            this.f14305b.invoke(this.f14306c.getId());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds) {
            s.i(ds, "ds");
            ds.setColor(-16747822);
            ds.setUnderlineText(false);
        }
    }

    public static /* synthetic */ SpannableStringBuilder b(a aVar, List list, CharSequence charSequence, int i10, Function1 function1, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return aVar.a(list, charSequence, i10, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final SpannableStringBuilder a(@Nullable List<ReplaceAtModel> list, @NotNull CharSequence contentValue, int i10, @NotNull Function1<? super String, p> clickListener) {
        String obj;
        SpannableStringBuilder spannableStringBuilder;
        Integer num;
        s.i(contentValue, "contentValue");
        s.i(clickListener, "clickListener");
        if (contentValue instanceof SpannableStringBuilder) {
            obj = contentValue.toString();
            spannableStringBuilder = (SpannableStringBuilder) contentValue;
        } else {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(contentValue);
            obj = contentValue.toString();
            spannableStringBuilder = spannableStringBuilder2;
        }
        int i11 = 0;
        if (!(list == null || list.isEmpty())) {
            List s02 = CollectionsKt___CollectionsKt.s0(list, new C0153a());
            int i12 = -1;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i13 = 0;
            int i14 = 0;
            while (i13 < obj.length()) {
                int i15 = i14 + 1;
                if (obj.charAt(i13) == '@') {
                    i12++;
                    linkedHashMap.put(Integer.valueOf(i12), Integer.valueOf(i14));
                }
                i13++;
                i14 = i15;
            }
            if (!linkedHashMap.isEmpty()) {
                while (true) {
                    if (i11 >= s02.size()) {
                        break;
                    }
                    ReplaceAtModel replaceAtModel = (ReplaceAtModel) s02.get(i11);
                    if (replaceAtModel.getName() != null && replaceAtModel.getId() != null && (num = (Integer) linkedHashMap.get(replaceAtModel.getIndex())) != null) {
                        int intValue = num.intValue() + replaceAtModel.getName().length() + 1;
                        if (i10 >= intValue) {
                            b bVar = new b(clickListener, replaceAtModel);
                            if (intValue <= obj.length()) {
                                String substring = obj.substring(num.intValue() + 1, intValue);
                                s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                                if (s.d(substring, replaceAtModel.getName())) {
                                    spannableStringBuilder.setSpan(bVar, num.intValue(), intValue, 33);
                                }
                            }
                        } else {
                            if (i10 < intValue && i10 > num.intValue()) {
                                spannableStringBuilder.replace(num.intValue(), spannableStringBuilder.length(), (CharSequence) "");
                                break;
                            }
                            if (i10 < num.intValue()) {
                                spannableStringBuilder.replace(i10, spannableStringBuilder.length(), (CharSequence) "");
                                break;
                            }
                        }
                    }
                    i11++;
                }
            } else if (i10 < spannableStringBuilder.length() && i10 >= 0) {
                spannableStringBuilder.replace(i10, spannableStringBuilder.length(), (CharSequence) "");
            }
        }
        if (spannableStringBuilder.length() > i10 && i10 >= 0) {
            spannableStringBuilder.replace(i10, spannableStringBuilder.length(), (CharSequence) "");
        }
        return spannableStringBuilder;
    }
}
