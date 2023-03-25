package tm01;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class FristConnect {
    public static void main(String[] args) throws IOException {
        ConnectURL koneksisaya = new ConnectURL();
        URL myAddress = koneksisaya.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);

        assert response != null;
        JSONArray responeJSON = new JSONArray(response);
        ArrayList<responmodel> responsemodel =
                new ArrayList<>();
        int jeruk = 0;
        for (int i = 0; i < responeJSON.length(); i++) {
            responmodel resModel = new responmodel();
            JSONObject myJSONObject =
                    responeJSON.getJSONObject(i);
            String rega = myJSONObject.
                    getString("i_sell");
            resModel.setI_sell(rega);
            responsemodel.add(resModel);

            int regaint = Integer.parseInt(rega);
            if (
                    regaint < 2000
            ) {
                jeruk++;


            }

            for (int index = 0; index < responsemodel.size(); index++) {
                int regan = Integer.parseInt(responsemodel.get(index).getI_sell());
                if (regan < 2000) {
                    System.out.println("harga = " + regan);
                }
            }
        }
    }
}