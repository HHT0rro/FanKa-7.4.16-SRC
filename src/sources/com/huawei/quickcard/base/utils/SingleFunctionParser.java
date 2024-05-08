package com.huawei.quickcard.base.utils;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.utils.FunctionParser;
import com.huawei.quickcard.base.utils.SingleFunctionParser;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SingleFunctionParser<V> extends FunctionParser<String, List<V>> {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface FlatMapper<V> {
        V map(String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface NonUniformMapper<V> {
        List<V> map(List<String> list);
    }

    public SingleFunctionParser(@NonNull String str, @NonNull final FlatMapper<V> flatMapper) {
        super(str, new FunctionParser.Mapper() { // from class: com.huawei.quickcard.base.utils.e
            @Override // com.huawei.quickcard.base.utils.FunctionParser.Mapper
            public final Map map(String str2, List list) {
                Map a10;
                a10 = SingleFunctionParser.a(SingleFunctionParser.FlatMapper.this, str2, list);
                return a10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map a(FlatMapper flatMapper, String str, List list) {
        HashMap hashMap = new HashMap();
        LinkedList linkedList = new LinkedList();
        Iterator iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            linkedList.add(flatMapper.map((String) iterator2.next()));
        }
        hashMap.put(str, linkedList);
        return hashMap;
    }

    public List<V> parse(String str) {
        LinkedHashMap<String, V> parse = parse();
        if (parse.containsKey(str)) {
            return (List) parse.get(str);
        }
        return null;
    }

    public SingleFunctionParser(@NonNull String str, @NonNull final NonUniformMapper<V> nonUniformMapper) {
        super(str, new FunctionParser.Mapper() { // from class: com.huawei.quickcard.base.utils.f
            @Override // com.huawei.quickcard.base.utils.FunctionParser.Mapper
            public final Map map(String str2, List list) {
                Map a10;
                a10 = SingleFunctionParser.a(SingleFunctionParser.NonUniformMapper.this, str2, list);
                return a10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map a(NonUniformMapper nonUniformMapper, String str, List list) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, nonUniformMapper.map(list));
        return hashMap;
    }
}
