package com.musicshop.dao;

import com.musicshop.dto.Instrument;
import com.musicshop.exception.DaoException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InstrumentDaoImplementationTest {

    @Test
    void getInstrumentById_findsExistingInstrument() {
        // set up the test
        InstrumentDaoInterface instrumentDao = new InstrumentDaoImplementation();
        int instrumentIdToFind = 1;

        // run the method
        Instrument foundInstrument = null;
        try {
            foundInstrument = instrumentDao.getInstrumentById(instrumentIdToFind);
        } catch (DaoException e) {
            fail("an exception was thrown when it shouldntve been: " + e.getMessage());
        }

        //check result
        System.out.println("Test found: " + foundInstrument);
        assertNotNull(foundInstrument, "The instrument shouldnt be null");
        assertEquals(instrumentIdToFind, foundInstrument.getInstrumentId(), "The instrument ID returned should match the one we searched for");
    }
}