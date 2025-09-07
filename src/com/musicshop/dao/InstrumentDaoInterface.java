package com.musicshop.dao;

import com.musicshop.exception.DaoException;
import com.musicshop.dto.Instrument;
import java.util.List;

public interface InstrumentDaoInterface {
    //features

    //find entities
    public List<Instrument> getAllInstruments();

    //find and display entity by key
    public Instrument getInstrumentById(int instrumentId);

    //delete by key
    public void deleteInstrumentById(int instrumentId);

    //insert
    public Instrument insertInstrument(Instrument instrument);

    //list by filter
    public List<Instrument> getInstrumentsByType(String instrumentName);

    //create cache using hashset gets added later onnn

    //retrieve  as JSON strong
    public String getAllInstrumentsAsJson();

    //find single entity by key
    public String getInstrumentByIdAsJson(int instrumentId);


}
