import org.json.JSONObject;

public class SecretSharing {

    public static void main(String[] args) {
        String jsonInput = "{ \"keys\": {\"n\": 4, \"k\": 3}, \"1\": {\"base\": \"10\", \"value\": \"4\"}, "
                + "\"2\": {\"base\": \"2\", \"value\": \"111\"}, \"3\": {\"base\": \"10\", \"value\": \"12\"}, "
                + "\"6\": {\"base\": \"4\", \"value\": \"213\"}}";


        JSONObject jsonObject = new JSONObject(jsonInput);

        JSONObject keys = jsonObject.getJSONObject("keys");
        int n = keys.getInt("n");
        int k = keys.getInt("k");
        System.out.println("Total Shares (n): " + n + ", Required Shares (k): " + k);

        for (String key : jsonObject.keySet()) {
            if (key.equals("keys")) continue;

            JSONObject share = jsonObject.getJSONObject(key);
            int base = Integer.parseInt(share.getString("base"));
            String value = share.getString("value");

            int decimalValue = Integer.parseInt(value, base);
            System.out.println("Share " + key + " in decimal: " + decimalValue);
        }
    }
}
