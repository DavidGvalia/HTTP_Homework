package org.example;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Reqest {
    public static MultiMap getQueryParams(String url) {
        MultiMap parameter = new MultiValueMap();
        List<NameValuePair> params;
        try {
            params = URLEncodedUtils.parse(new URI(url), "UTF-8");
            for (NameValuePair param : params) {
                if (param.getName() != null && param.getValue() != null)
                    parameter.put(param.getName(), param.getValue());
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return parameter;
    }

}