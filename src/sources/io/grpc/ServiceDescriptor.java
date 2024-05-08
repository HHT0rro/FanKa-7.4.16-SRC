package io.grpc;

import com.google.common.base.j;
import com.google.common.base.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ServiceDescriptor {
    private final Collection<MethodDescriptor<?, ?>> methods;
    private final String name;
    private final Object schemaDescriptor;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Builder {
        private List<MethodDescriptor<?, ?>> methods;
        private String name;
        private Object schemaDescriptor;

        /* JADX INFO: Access modifiers changed from: private */
        public Builder addAllMethods(Collection<MethodDescriptor<?, ?>> collection) {
            this.methods.addAll(collection);
            return this;
        }

        public Builder addMethod(MethodDescriptor<?, ?> methodDescriptor) {
            this.methods.add((MethodDescriptor) o.s(methodDescriptor, "method"));
            return this;
        }

        public ServiceDescriptor build() {
            return new ServiceDescriptor(this);
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2666")
        public Builder setName(String str) {
            this.name = (String) o.s(str, "name");
            return this;
        }

        public Builder setSchemaDescriptor(Object obj) {
            this.schemaDescriptor = obj;
            return this;
        }

        private Builder(String str) {
            this.methods = new ArrayList();
            setName(str);
        }
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static void validateMethodNames(String str, Collection<MethodDescriptor<?, ?>> collection) {
        HashSet hashSet = new HashSet(collection.size());
        for (MethodDescriptor<?, ?> methodDescriptor : collection) {
            o.s(methodDescriptor, "method");
            String serviceName = methodDescriptor.getServiceName();
            o.n(str.equals(serviceName), "service names %s != %s", serviceName, str);
            o.m(hashSet.add(methodDescriptor.getFullMethodName()), "duplicate name %s", methodDescriptor.getFullMethodName());
        }
    }

    public Collection<MethodDescriptor<?, ?>> getMethods() {
        return this.methods;
    }

    public String getName() {
        return this.name;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    public Object getSchemaDescriptor() {
        return this.schemaDescriptor;
    }

    public String toString() {
        return j.c(this).d("name", this.name).d("schemaDescriptor", this.schemaDescriptor).d("methods", this.methods).m().toString();
    }

    public ServiceDescriptor(String str, MethodDescriptor<?, ?>... methodDescriptorArr) {
        this(str, Arrays.asList(methodDescriptorArr));
    }

    public ServiceDescriptor(String str, Collection<MethodDescriptor<?, ?>> collection) {
        this(newBuilder(str).addAllMethods((Collection) o.s(collection, "methods")));
    }

    private ServiceDescriptor(Builder builder) {
        String str = builder.name;
        this.name = str;
        validateMethodNames(str, builder.methods);
        this.methods = Collections.unmodifiableList(new ArrayList(builder.methods));
        this.schemaDescriptor = builder.schemaDescriptor;
    }
}
