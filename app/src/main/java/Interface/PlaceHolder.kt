package Interface
import Beans.Customer
import Beans.Product
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
interface PlaceHolder {

    @GET("api/products")
    fun getListProducts(): Call<List<Product>>

    @POST("api/products")
    fun addProduct(
        @Body product: Product
    ): Call<Product>

    @DELETE("api/products/{_id}")
    fun deleteProduct(
        @Path("_id") _id:String
    ): Call<Void>

    @GET("api/customers")
    fun getCustomers(): Call<List<Customer>>

    @POST("api/customers")
    fun addCustomer(
        @Body customer: Customer
    ): Call<Customer>
}