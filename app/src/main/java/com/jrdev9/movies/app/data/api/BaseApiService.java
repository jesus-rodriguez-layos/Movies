package com.jrdev9.movies.app.data.api;


import com.jrdev9.movies.app.data.api.models.ApiResponseModel;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class BaseApiService {

    @Inject
    protected BaseApiService() {

    }

    protected <T extends ApiResponseModel> T execute(Call<T> callService) throws Exception {
        Response<T> response = callService.execute();
        if (!isSuccessResponse(response)) {
            throw new Exception();
        }
        return response.body();
    }

    private boolean isSuccessResponse(Response response) {
        return response.isSuccessful();
    }
}
