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
        //make db connection
        try(Connection conn = DBConnectionManager.getConnection();
            PreparedStatement psm = conn.prepareStatement("SELECT * FROM Instrument");
            ResultSet rs = psm.executeQuery();){
            //get stuff
            while(rs.next()){
                int  id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                //add to the arraylist
                instruments.add(new Instrument(id,name,type,price));
            }
        } catch (SQLException e) {
            throw new DaoException("getAllInstruments failed: " + e.getMessage());
        }
            return instruments;
    }

    @Override
    public Instrument getInstrumentById(int instrumentId) throws DaoException {
        Instrument instrument = null;
        try(Connection conn = DBConnectionManager.getConnection();
            PreparedStatement psm = conn.prepareStatement("SELECT * FROM instruments WHERE instrument_id = ?");)
        {
            psm.setInt(1, instrumentId);
            ResultSet rs = psm.executeQuery();
            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");

                instrument = new Instrument(id,name,type,price);
            }


        } catch (SQLException e){
            throw new DaoException("getInstrumentById failed: " + e.getMessage());
        }
        return instrument;
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
