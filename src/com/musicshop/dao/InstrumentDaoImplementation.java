package com.musicshop.dao;

 import com.musicshop.dto.Instrument;
 import com.musicshop.exception.DaoException;
 import com.musicshop.util.DBConnectionManager;
 import java.sql.*;
 import java.util.ArrayList;
 import java.util.List;

public class InstrumentDaoImplementation implements InstrumentDaoInterface {

    @Override
    public List<Instrument> getAllInstruments() throws DaoException {
        List<Instrument> instruments = new ArrayList<Instrument>();
        Connection conn = null;
        PreparedStatement psm = null;
        ResultSet rs = null;
        try {
            //make db connection
            conn = DBConnectionManager.getConnection();

            String query = "SELECT * FROM instrument";
            psm = conn.prepareStatement(query);
            rs = psm.executeQuery();



        } catch (SQLException e) {
            throw new DaoException("getAllInstruments() failed: " + e.getMessage());
        }

            return instruments;
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
