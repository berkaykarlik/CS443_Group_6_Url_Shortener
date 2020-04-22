package com.ariba.spring.url.shortener.Repository;



    public interface SequenceDao {

        long getNextSequenceId(String key) throws SequenceException;

    }



