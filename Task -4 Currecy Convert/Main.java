import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static double value(JSONObject webdata, String to){
        double Value=0.0;
        JSONObject data = webdata.getJSONObject("data");
        Map<String, Double> dict = new HashMap<>();

        
        
        JSONObject aedobj = data.getJSONObject("AED");
        JSONObject audobj = data.getJSONObject("AUD");
        JSONObject cnyobj = data.getJSONObject("CNY");
        JSONObject eurobj = data.getJSONObject("EUR");
        JSONObject inrobj = data.getJSONObject("INR");
        JSONObject rubobj = data.getJSONObject("RUB");
        JSONObject usdobj = data.getJSONObject("USD");

        double vaed = aedobj.getDouble("value");
        double vaud = audobj.getDouble("value");
        double vcny = cnyobj.getDouble("value");
        double veur = eurobj.getDouble("value");
        double vinr = inrobj.getDouble("value");
        double vrub = rubobj.getDouble("value");
        double vusd = usdobj.getDouble("value");

        dict.put("AED", vaed);
        dict.put("AUD", vaud);
        dict.put("CNY", vcny);
        dict.put("EUR", veur);
        dict.put("INR", vinr);
        dict.put("RUB", vrub);
        dict.put("USD", vusd);

        if (dict.containsKey(to)){
            Value = dict.get(to);
        } else {
            System.out.println("The currency " + to + " is either invalid or out of program limits. Please try again from the below given options.");
            System.out.print("1. UAE Dirham - AED\n"+
                            "2. Australian dollar - AUD\n"+
                            "3. Chinese Yuan - CNY\n"+
                            "4. Euro - EUR\n"+
                            "5. Indian Rupee - INR\n"+
                            "6. Russian Rubel - RUB\n"+
                            "7. American Dollar- USD\n");
        }

        return Value;
    }
    public static void conv (String json) {
        JSONObject webdata = new JSONObject(json);
        Scanner input = new Scanner(System.in);

        
        System.out.print("Please enter the value you want to convert: ");
        double amount = input.nextDouble();
        System.out.print("Enter the Currency you wish to convert to: ");
        String to = input.next().toUpperCase();
        double value= value(webdata, to);

        double newValue = amount * value;
        if(newValue!=0){
            String formattedValue = String.format("%.4f", newValue);
            System.out.println("The converted Value is: " + to + " " + formattedValue);
        }
        input.close();
                
    }

    public static int status () throws IOException, InterruptedException{ 

        String api_key = "cur_live_rUuGVHvyyG4zZn0oB9Ok4tIY9Ty96BZJDrointd5";
        String status_url = "https://api.currencyapi.com/v3/status?apikey=" + api_key;
        
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(status_url)).build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        String responseString = response.body();
        JSONObject data = new JSONObject(responseString);
        JSONObject quotas = data.getJSONObject("quotas");
        JSONObject month = quotas.getJSONObject("month");
        
        int remaining = month.getInt("remaining");
        
        return remaining;
    }
    
    public static void main(String[] args) throws IOException, InterruptedException{
        Scanner input = new Scanner(System.in);

        String api_key = "cur_live_rUuGVHvyyG4zZn0oB9Ok4tIY9Ty96BZJDrointd5";
        String URL = "https://api.currencyapi.com/v3/latest?apikey=" + api_key + "&currencies=EUR%2CUSD%2CINR%2CAED%2CAUD%2CRUB%2CCNY&base_currency=";
        
        System.out.print("Please enter your current currency (code): ");
        String base_currency = input.next().toUpperCase();
        
        String url = URL + base_currency;
        
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        
        JSONObject jsonresponse = new JSONObject(response.body());
        
        if(jsonresponse.has("errors")){
            JSONObject error = jsonresponse.getJSONObject("errors");
            JSONArray baseCurrencyErrors = error.getJSONArray("base_currency");
            if(baseCurrencyErrors!=null){
                String errorMessage = baseCurrencyErrors.getString(0);
                System.out.print(errorMessage);
            }
        }    
        else{
            String webdata = response.body();
        
            conv(webdata);
            int status = status();

            if (status==0){
                System.out.println("The API limit for this month has been reached. Please set a new api key!");
            }
            System.out.print("The remaining attempts after this action are: "+ status);
        }
        input.close();

    }
    
}