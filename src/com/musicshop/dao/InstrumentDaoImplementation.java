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
             PreparedStatement psm = conn.prepareStatement("SELECT * FROM instruments");
             ResultSet rs = psm.executeQuery();) {
            //get stuff
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");
                //add to the arraylist
                instruments.add(new Instrument(id, name, type, price, stock));
            }
        } catch(SQLException e) {
            throw new DaoException("getAllInstruments failed: " + e.getMessage());
        }
        return instruments;
    }

    @Override
    public Instrument getInstrumentById(int instrumentId) throws DaoException{
        Instrument instrument = null;
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement psm = conn.prepareStatement("SELECT * FROM instruments WHERE id = ?");) {
            psm.setInt(1, instrumentId);
            ResultSet rs = psm.executeQuery();

            //check if an instrument was found
            if (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                double price = rs.getDouble("price");
                int stock = rs.getInt("stock");

                instrument = new Instrument(id, name, type, price, stock);
            }

        } catch (SQLException e){
            throw new DaoException("getInstrumentById failed: " + e.getMessage());
        }
        return instrument;
    }

    @Override
    public void deleteInstrumentById(int instrumentId) throws DaoException {
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement psm = conn.prepareStatement("DELETE FROM instruments WHERE id = ?")) {

            psm.setInt(1, instrumentId);
            //use executeUpdate to update the db
            psm.executeUpdate();

            System.out.println("Instrument" + instrumentId + " has been deleted");

        } catch (SQLException e){
            throw new DaoException("deleteInstrumentById failed: " + e.getMessage());
        }
    }

    @Override
    public Instrument insertInstrument(Instrument instrument) throws DaoException {
        try (Connection conn = DBConnectionManager.getConnection();
             PreparedStatement psm = conn.prepareStatement("INSERT INTO instruments (name, type, price, stock) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            psm.setString(1, instrument.getName());
            psm.setString(2, instrument.getType());
            psm.setDouble(3, instrument.getPrice());
            psm.setInt(4, instrument.getStock());

            psm.executeUpdate();

            // get the new id the database made
            ResultSet generatedKeys = psm.getGeneratedKeys();
            if(generatedKeys.next()) {
                instrument.setInstrumentId(generatedKeys.getInt(1));
            }

        } catch(SQLException e) {
            throw new DaoException("insertInstrument failed: " + e.getMessage());
        }
        return instrument;
    }

    @Override
    public List<Instrument> getInstrumentsByType(String instrumentName) throws DaoException {
        return List.of();
    }

    @Override
    public String getAllInstrumentsAsJson() throws DaoException {
        System.out.println("DAO: This method should call getAllInstruments(), loop through the list, and convert it to a JSON string.");
        //json array to prove connection works
        return "[]";
    }

    @Override
    public String getInstrumentByIdAsJson(int instrumentId) throws DaoException {
        return "";
    }

}