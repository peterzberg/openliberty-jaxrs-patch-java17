package ch.zberg.sample.openliberty.jaxrs.patch;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DummyResourceIT {

    @Test
    void testSomething() throws IOException {
        // arrange
        final String url = "http://localhost:9080/java17/api/dummy";
        final URLConnection urlConnection = new URL(url).openConnection();
        // act
        final InputStream inputStream = urlConnection.getInputStream();
        // assert
        final String response = readResponseString(inputStream);
        assertEquals("patch", response);
    }

    private String readResponseString(final InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining("\n"));
    }
}