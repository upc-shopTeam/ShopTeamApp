package Interface
import Beans.Customer
import Beans.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
interface PlaceHolder {

    @GET("products")
    fun getListProducts(): Call<List<Product>>

    @GET("customers")
    fun getCustomers(): Call<List<Customer>>

    @POST("customers")
    fun addCustomer(
        @Body customer: Customer
    ): Response<Customer>
}