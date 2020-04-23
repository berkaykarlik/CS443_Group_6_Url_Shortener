package com.ariba.spring.url.shortener.service;

import com.ariba.spring.url.shortener.dao.UrlDao;
import com.ariba.spring.url.shortener.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class UrlService {

    private UrlDao urlDao;
    private final long url_limit = (long)Math.pow(62,7);

    @Autowired
    public UrlService(UrlDao urlDao) {
        this.urlDao = urlDao;
    }

    public int addUrl (Url url){
        Url existing_url = urlDao.getUrlById(url.getId());
        if (existing_url == null) {
            urlDao.saveUrl(url);
            return 1;
        }
        else {
            return -1; //url with same id already exist
        }
    }

    public Url getUrlById(String id){
        return urlDao.getUrlById(id);
    }


    public String numericIdToMapped(String id) {
        long long_id = Long.parseLong(id);
        int base = 62;

        ArrayList<Long> digits = new ArrayList<Long>() ;

        while (long_id > 0 ){
            long remainder = long_id % base;
            digits.add(remainder);
            long_id = long_id / base;
        }

        Collections.reverse(digits);

        String id_to_st= "";
        for(long digit:digits){
            char tmp;
            if (digit < 10)
                tmp = (char)(digit + '0');
            else if ((digit-10) < 26)
                tmp = (char)((digit -10) + 'A');
            else
                tmp = (char)((digit -36) + 'a');

            id_to_st += tmp;
        }

        return id_to_st;
    }

    public String mappedIdToNumeric(String mapped_id){
        int arr[] = new int[mapped_id.length()];
        int base = 62;

        for (int i = 0 ; i < mapped_id.length(); i++ ){
            int ch = (int)mapped_id.charAt(i);

            if (ch -'0' < 10)
                arr[i] =  ch -'0';
            else if (ch - 'A' < 36)
                arr[i] =  ch -'A'+10;
            else
                arr[i] =  ch -'a'+36;
        }
        int ultimate_id = 0;
        for (int k = 0 ; k< arr.length; k ++){
            int power = arr.length - k -1;
            ultimate_id += Math.pow(base,k)*arr[k];
        }

        return Integer.toString(ultimate_id);


    }

    public String rand_id(){
        long id = (long) (Math.random() * url_limit);
        System.out.println(id);
        return numericIdToMapped(Long.toString(id));
    }
}
