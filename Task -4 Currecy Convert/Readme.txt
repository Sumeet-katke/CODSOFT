## Currency Conversion Application

This Java application allows users to convert currencies using real-time exchange rates obtained from an API. It provides the option to enter an amount in one currency and get the equivalent value in another selected currency.

### Features
1. Currency Selection: Users can choose the base and target currency for conversion.
2. Real-time Exchange Rates: Fetches exchange rates using the currencyapi.com API.
3. Amount Input: Takes user input for the amount to be converted.
4. Currency Conversion: Converts the input amount from the base currency to the target currency using the fetched exchange rate.
5. Display Result: Displays the converted amount with the target currency symbol.

### File Details
The program contains a `Main.java` file which consists of several methods:

1. `value`: Fetches real-time exchange rates and performs the conversion.
2. `conv`: Takes user input for the amount to be converted and displays the result.
3. `status`: Checks the remaining API call limit for the month.
4. `main`: Drives the main functionality of the currency conversion.

### Libraries

The code utilizes several libraries to achieve various functionalities:

-java.io.IOException: Handles Input/Output exceptions for file and network operations.
-java.net.URI: Deals with Uniform Resource Identifiers.
-java.net.http.HttpClient, java.net.http.HttpRequest, java.net.http.HttpResponse: Used for sending HTTP requests and receiving responses.
-java.util.Scanner: Facilitates user input from the console.
-org.json.JSONArray and org.json.JSONObject: Helps in handling JSON data.
-java.util.HashMap and java.util.Map: Enable the storage and retrieval of key-value pairs.

### Formatting the Result
To display the converted value with only two decimal points, the `conv()` method uses the `String.format()` function. It formats the value to show only two decimal places.

### Running the Application
To run the application:
1. Input your base currency when prompted.
2. Enter the amount to convert.
3. Provide the currency code to convert to.

### Usage and Limitations
- Ensure you enter valid currency codes according to the options provided.
- The API call limit is checked, and users are informed if the limit has been reached for the month.

The application also handles errors if an invalid base currency is provided, and it provides user guidance on available currency options.

###Sample Output:

#Case-1: with correct inputs: 

Please enter your current currency (code): INR
Please enter the value you want to convert: 250
Enter the Currency you wish to convert to: USD
The converted Value is: USD 3.003
The remaining attempts after this action are: 254

#Case-2: with incorrect base currency

Please enter your current currency (code): INT
The selected base currency is invalid.

#Case-3: with incorrect 'to' currency

Please enter your current currency (code): INR
Please enter the value you want to convert: 250
Enter the Currency you wish to convert to: PKR
The currency PKR is either invalid or out of program limits. Please try again from the below given options.
1. UAE Dirham - AED
2. Australian dollar - AUD
3. Chinese Yuan - CNY
4. Euro - EUR
5. Indian Rupee - INR
6. Russian Rubel - RUB
7. American Dollar- USD
The remaining attempts after this action are: 252