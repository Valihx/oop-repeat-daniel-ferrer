package com.musicshop.dao;

import com.musicshop.dto.Instrument;
import com.musicshop.exception.DaoException;
import java.util.List;

public interface InstrumentDaoInterface {
    //features

    //find entities
    public List<Instrument> getAllInstruments() throws DaoException;

    //find and display entity by key
    public Instrument getInstrumentById(int instrumentId) throws DaoException;

    //delete by key
    public void deleteInstrumentById(int instrumentId) throws DaoException;

    //insert
    public Instrument insertInstrument(Instrument instrument) throws DaoException;

    //list by filter
    public List<Instrument> getInstrumentsByType(String instrumentType) throws DaoException;

    //create cache using hashset gets added later onnn

    //retrieve all entities as a json string
    public String getAllInstrumentsAsJson() throws DaoException;

    //find single entity by key as a json string
    public String getInstrumentByIdAsJson(int instrumentId) throws DaoException;
}