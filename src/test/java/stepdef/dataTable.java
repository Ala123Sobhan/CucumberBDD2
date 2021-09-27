package stepdef;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.util.List;

public class dataTable {


    @Given("I am on {string} website")
    public void i_am_on_website(String website) {
        System.out.println(website);
    }

    @Given("I use my credentials")
    public void i_use_my_credentials(List<List<String>> table) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.

        List<List<String>> data = table;
        System.out.println(data.get(0).get(0) +" - "+ data.get(1).get(0));
        System.out.println(data.get(0).get(1) +" - "+data.get(1).get(1));





    }

    @And("^I use my credentials (.+) and (.+)$")
    public void i_use_my_credentials_and(String email, String password) throws Throwable {
        System.out.println(email +" - "+password);
    }

}
