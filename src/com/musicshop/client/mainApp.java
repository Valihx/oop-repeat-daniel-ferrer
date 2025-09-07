package com.musicshop.client;

import com.musicshop.exception.DaoException;
import com.musicshop.dao.InstrumentDaoImplementation;
import com.musicshop.dao.InstrumentDaoInterface;
import com.musicshop.dto.Instrument;
import java.util.List;

public class mainApp {

    public static void main(String[] args) {

        InstrumentDaoInterface instrumentDao = new InstrumentDaoImplementation();

        try {
            System.out.println("Making sure all instruments are on the list");

            List<Instrument> instruments = instrumentDao.getAllInstruments();

            if (instruments.isEmpty()) {
                System.out.println("Error the instrument list is empty.");
            } else {
                System.out.println("All instruments are on the list");
                for (Instrument instrument : instruments) {
                    System.out.println(instrument);
                }
            }

        } catch (DaoException e) {
            System.out.println("database error: " + e.getMessage());
        }
    }
}