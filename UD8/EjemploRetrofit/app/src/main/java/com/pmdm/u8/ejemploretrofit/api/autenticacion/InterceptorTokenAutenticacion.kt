package com.pmdm.u8.ejemploretrofit.api.autenticacion

import okhttp3.Interceptor

class InterceptorTokenAutenticacion(private val tipoToken: String,
                                    private val token: String): Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", "$tipoToken $token").build()

        return chain.proceed(request)
    }
}