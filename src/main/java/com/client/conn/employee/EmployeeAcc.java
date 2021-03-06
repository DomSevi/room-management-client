package com.client.conn.employee;

import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface EmployeeAcc {

    @GET("/employees/list")
    Call<List<Employee>> findAllEmployees();

    @GET("/employees/{login}")
    Call<Employee> findEmployeeByLogin(@Path("login") String login);

    @GET("/employees/find/{id}")
    Call<Employee> findEmployeeById(@Path("id") Long id);

    //@POST("/employees/add")
    //Call<Employee> addNewEmployee(@Body Employee newEmployee);
    @POST("/employees/add")
    Call<Void> addNewEmployee(@Body Employee newEmployee);

    @FormUrlEncoded
    @PUT("/employees/edit/{id}")
    Call<Void> editEmployeeById(@Path("id") Long id, @Field("name") String name, @Field("surname") String surname,
                                    @Field("job") String job);

    @DELETE("/employees/delete/{id}")
    Call<Void> deleteEmployeeById(@Path("id") Long id);
}
