package Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sample.DataFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class DataFileTest {

    private DataFile dataFile;
    @BeforeEach
    void setUp() {
        dataFile = new DataFile();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void encrypt() throws IOException {
        assertEquals("OVPXRZQPMAMMF AE NO!",dataFile.encrypt("C:\\temp\\JavaFXGenerate\\data_txt", "C:\\temp\\JavaFXGenerate\\data_encrypted.txt","ProgramovaNIE je OK!","ZEBRA" ));
    }

    @Test
    void decrypt() throws IOException {
        assertEquals("PROGRAMOVANIE JE OK!",dataFile.decrypt("C:\\temp\\JavaFXGenerate\\data_encrypted.txt", "C:\\temp\\JavaFXGenerate\\data_decrypted.txt","OVPXRZQPMAMMF AE NO!","ZEBRA" ));

    }
}