package com.musicshop.dao;
 import com.musicshop.dto.Instrument;
 import java.util.List;

public class InstrumentDaoImplementation implements InstrumentDaoInterface {

    @Override
    public List<Instrument> getAllInstruments() {
        return null;
    }

    @Override
    public Instrument getInstrumentById(int instrumentId) {
        return null;
    }

    @Override
    public void deleteInstrumentById(int instrumentId) {
    }

    @Override
    public Instrument insertInstrument(Instrument instrument) {
        return null;
    }

    @Override
    public List<Instrument> getInstrumentsByType(String instrumentName) {
        return List.of();
    }

    @Override
    public String getAllInstrumentsAsJson() {
        return "";
    }

    @Override
    public String getInstrumentByIdAsJson(int instrumentId) {
        return "";
    }

}
