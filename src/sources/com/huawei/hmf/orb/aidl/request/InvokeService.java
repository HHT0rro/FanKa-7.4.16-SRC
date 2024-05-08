package com.huawei.hmf.orb.aidl.request;

import com.huawei.hmf.orb.CommonCode;
import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.orb.IndexedObject;
import com.huawei.hmf.orb.RemoteSession;
import com.huawei.hmf.orb.RemoteSessionManager;
import com.huawei.hmf.orb.RemoteTarget;
import com.huawei.hmf.orb.aidl.NamingRemoteTarget;
import com.huawei.hmf.orb.aidl.NamingRemoteTargetRegistry;
import com.huawei.hmf.orb.aidl.RemoteTargetRegistry;
import com.huawei.hmf.orb.aidl.client.ApiClient;
import com.huawei.hmf.orb.aidl.client.impl.ResolvePendingResult;
import com.huawei.hmf.orb.aidl.communicate.AIDLRequest;
import com.huawei.hmf.orb.bridge.Bridge;
import com.huawei.hmf.orb.bridge.RemoteBridgeFactory;
import com.huawei.hmf.orb.exception.ApiNotExistException;
import com.huawei.hmf.orb.exception.GeneralException;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hmf.services.Module;
import com.huawei.hmf.services.codec.Variant;
import com.huawei.hmf.services.interception.ActionInvocation;
import com.huawei.hmf.services.interception.Signature;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class InvokeService extends AIDLRequest<Request> {
    private static final String constructor = "__constructor__";
    public static final String name = "InvokeService";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Request implements IMessageEntity {
        public String method;
        public String module;
        public List<Variant> param;
        public String uri;
        public long sequence = -1;
        private int returnTypeKind = TypeKind.CLASS.ordinal();

        public TypeKind getReturnTypeKind() {
            return TypeKind.values()[this.returnTypeKind];
        }

        public void setReturnTypeKind(TypeKind typeKind) {
            this.returnTypeKind = typeKind.ordinal();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Response implements IMessageEntity {
        public Variant<?> ret;
        public int statusCode = 0;

        public void failure(int i10) {
            this.statusCode = -1;
            this.ret = new Variant<>(Integer.valueOf(i10));
        }

        public boolean isSuccessful() {
            return this.statusCode == 0;
        }
    }

    public static ResolvePendingResult<Response> build(ApiClient apiClient, String str, String str2, String str3, Object... objArr) {
        return build(apiClient, str, str2, str3, TypeKind.CLASS, objArr);
    }

    private Response callMethod(RemoteSession remoteSession, Request request) throws GeneralException {
        Object[] objArr;
        Response response = new Response();
        RemoteTarget remoteTarget = remoteSession.get(Long.valueOf(request.sequence));
        if (remoteTarget != null) {
            List<Variant> list = request.param;
            if (list != null) {
                objArr = new Variant[list.size()];
                for (int i10 = 0; i10 < request.param.size(); i10++) {
                    objArr[i10] = request.param.get(i10);
                }
            } else {
                objArr = null;
            }
            try {
                Object onTransact = remoteTarget.onTransact(request.method, objArr);
                intercept(remoteTarget, request);
                if (onTransact != null) {
                    Bridge bridge = RemoteBridgeFactory.getBridge(onTransact.getClass());
                    if (bridge != null) {
                        IndexedObject<? extends RemoteTarget> handle = bridge.handle(onTransact, this.response);
                        if (handle != null) {
                            remoteSession.add(handle);
                        }
                        return null;
                    }
                    if (request.getReturnTypeKind() == TypeKind.NamedClass) {
                        response.ret = new Variant<>(Long.valueOf(remoteSession.add(new NamingRemoteTarget(onTransact))));
                        return response;
                    }
                }
                response.ret = new Variant<>(onTransact);
                return response;
            } catch (ApiNotExistException unused) {
                throw new GeneralException(CommonCode.ErrorCode.API_NOT_EXIST);
            }
        }
        throw new GeneralException(CommonCode.ErrorCode.SEQUENCE_ID_INVALID);
    }

    private Response createObject(RemoteSession remoteSession, Request request) throws GeneralException {
        Response response = new Response();
        RemoteTargetRegistry registry = RemoteTargetRegistry.getRegistry(request.module);
        if (registry != null) {
            RemoteTarget createRemoteTarget = registry.createRemoteTarget(request.uri);
            if (createRemoteTarget == null) {
                createRemoteTarget = NamingRemoteTargetRegistry.create(request.uri, request.module, request.param);
                if (createRemoteTarget == null) {
                    throw new GeneralException(CommonCode.ErrorCode.URI_INVALID);
                }
            } else {
                intercept(createRemoteTarget, request);
            }
            response.ret = new Variant<>(Long.valueOf(remoteSession.add(createRemoteTarget)));
            return response;
        }
        throw new GeneralException(CommonCode.ErrorCode.MODULE_INVALID);
    }

    private void intercept(RemoteTarget remoteTarget, Request request) {
        Module lookup;
        if (remoteTarget.getServiceType() == null || (lookup = ComponentRepository.getRepository().lookup(request.module)) == null || lookup.getInterceptor() == null) {
            return;
        }
        Signature signature = new Signature(remoteTarget.getServiceType());
        signature.setDeclaringTypeName(remoteTarget.getServiceTypeName());
        signature.setName(request.method);
        signature.setAlias(remoteTarget.getAlias());
        lookup.getInterceptor().after(ActionInvocation.builder().moduleName(request.module).callingPackageName(this.clientIdentity.packageName).signature(signature).build());
    }

    private Response resolveRequest(RemoteSession remoteSession, Request request) throws GeneralException {
        if (remoteSession != null) {
            if ("__constructor__".equals(request.method)) {
                return createObject(remoteSession, request);
            }
            return callMethod(remoteSession, request);
        }
        throw new GeneralException(CommonCode.ErrorCode.SESSION_INVALID);
    }

    public static ResolvePendingResult<Response> build(ApiClient apiClient, String str, String str2, String str3, TypeKind typeKind, Object... objArr) {
        Request request = new Request();
        request.uri = str2;
        request.module = str;
        request.method = str3;
        request.setReturnTypeKind(typeKind);
        if (objArr.length > 0) {
            request.sequence = ((Long) objArr[0]).longValue();
            if (objArr.length > 1) {
                request.param = new ArrayList(objArr.length - 1);
                for (int i10 = 1; i10 < objArr.length; i10++) {
                    request.param.add(new Variant(objArr[i10]));
                }
            }
        }
        return ResolvePendingResult.build(apiClient, name, request, Response.class);
    }

    @Override // com.huawei.hmf.orb.aidl.communicate.AIDLRequest
    public void onRequest(Request request) {
        Response response = new Response();
        try {
            response = resolveRequest(RemoteSessionManager.get(this.clientIdentity.appID), request);
        } catch (GeneralException e2) {
            response.failure(e2.code);
        } catch (Exception unused) {
            response.failure(CommonCode.ErrorCode.INTERNAL_ERROR);
        }
        if (response != null) {
            this.response.call(response);
        }
    }
}
