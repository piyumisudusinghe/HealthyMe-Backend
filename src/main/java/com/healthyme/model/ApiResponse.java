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

    public void setStatus_code( String status_code )
    {
        this.status_code = status_code;
    }

    public void setRequest_result( String request_result )
    {
        this.request_result = request_result;
    }

    public void setData( T data )
    {
        this.data = data;
    }
}
