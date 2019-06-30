package com.infinity.application.controller;

/**
 * Created by sehgan01 on 30/06/2019.
 */
import com.fasterxml.jackson.core.JsonProcessingException;
        import com.fasterxml.jackson.databind.ObjectMapper;
import com.infinity.application.entities.CreditCard;
import com.infinity.application.repositories.CreditCardRepository;
import org.json.JSONException;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.skyscreamer.jsonassert.JSONAssert;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.boot.test.mock.mockito.MockBean;
        import org.springframework.boot.test.web.client.TestRestTemplate;
        import org.springframework.http.*;
        import org.springframework.test.context.ActiveProfiles;
        import org.springframework.test.context.junit4.SpringRunner;

        import static org.junit.Assert.assertEquals;
        import static org.mockito.ArgumentMatchers.any;
        import static org.mockito.Mockito.times;
        import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // for restTemplate
@ActiveProfiles("test")
public class CreditCardControllerRestTemplateTest {

    private static final ObjectMapper objMapper = new ObjectMapper();

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private CreditCardRepository mockRepository;

    /*
        {
            "timestamp":"2019-03-05T09:34:13.280+0000",
            "status":400,
            "errors":["Please provide a Credit Card Number."]
        }
     */
    @Test
    public void whenEmptyCreditCardNumber() throws JSONException {

        String creditCardInJson = "{\"name\":\"ABC\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(creditCardInJson, headers);

        // send json with POST
        ResponseEntity<String> response = restTemplate.postForEntity("/addCreditcard", entity, String.class);
        //printJSON(response);

        String expectedJson = "{\"status\":400,\"errors\":[\"Please provide a Credit Card Number.\"]}";
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        JSONAssert.assertEquals(expectedJson, response.getBody(), false);

        verify(mockRepository, times(0)).save(any(CreditCard.class));

    }

    /*
        {
            "timestamp":"2019-03-05T09:34:13.207+0000",
            "status":400,
            "errors":["Invalid Credit Card."]
        }
     */
    @Test
    public void whenInvalidCreditCardNumber() throws JSONException {

        String creditCardInJson = "{\"name\":\" Test Name\", \"creditCardNumber\":\"abc\",\"cardLimit\":\"9.99\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(creditCardInJson, headers);

        //Try exchange
        ResponseEntity<String> response = restTemplate.exchange("/addCreditcard", HttpMethod.POST, entity, String.class);

        String expectedJson = "{\"status\":400,\"errors\":[\"Invalid Credit Card.\"]}";
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        JSONAssert.assertEquals(expectedJson, response.getBody(), false);

        verify(mockRepository, times(0)).save(any(CreditCard.class));

    }

    private static void printJSON(Object object) {
        String result;
        try {
            result = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            System.out.println(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}