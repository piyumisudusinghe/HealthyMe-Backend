package com.healthyme.model;


public class ApiResponse<T>
{
    private String status_code;
    private String request_result;
    private T data;


    public String getStatus_code()
    {
        return status_code;
    }

    public String getRequest_result()
    {
        return request_result;
    }

    public T getData()
    {
        return data;
    }
}
