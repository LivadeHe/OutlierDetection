package io.swagger.api;

import io.swagger.model.AnalysisResult;
import io.swagger.model.OutlierdetectionAnalyzeorderBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-05-14T12:14:50.777488516Z[GMT]")
@RestController
public class OutlierdetectionApiController implements OutlierdetectionApi {

    private static final Logger log = LoggerFactory.getLogger(OutlierdetectionApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OutlierdetectionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

   /* public ResponseEntity<AnalysisResult> outlierdetectionAnalyzeorderPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required = true, schema = @Schema()) @Valid @RequestBody OutlierdetectionAnalyzeorderBody body
    ) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<AnalysisResult>(objectMapper.readValue("{\n  \"items_details\" : [ {\n    \"attribute_z\" : 1,\n    \"attribute_y\" : \"attribute_y\",\n    \"attribute_x\" : \"attribute_x\",\n    \"quantity\" : 6,\n    \"size\" : \"size\",\n    \"color\" : \"color\",\n    \"item_id\" : \"item_id\",\n    \"collection\" : \"collection\",\n    \"brand\" : \"brand\"\n  }, {\n    \"attribute_z\" : 1,\n    \"attribute_y\" : \"attribute_y\",\n    \"attribute_x\" : \"attribute_x\",\n    \"quantity\" : 6,\n    \"size\" : \"size\",\n    \"color\" : \"color\",\n    \"item_id\" : \"item_id\",\n    \"collection\" : \"collection\",\n    \"brand\" : \"brand\"\n  } ],\n  \"reasons_code\" : \"1; Unusually high order quantity, 2; Rare combination of product options...\",\n  \"customer_id\" : \"customer_id\",\n  \"order_id\" : \"order_id\",\n  \"is_outlier\" : true,\n  \"outlier_percentage\" : 0,\n  \"timestamp\" : \"2024-04-18T12:51:17.318Z\"\n}", AnalysisResult.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<AnalysisResult>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<AnalysisResult>(HttpStatus.NOT_IMPLEMENTED);
    }

    */

    // Methode wird bei einer HTTP-POST-Request aufgerufen
    // Override: Überschreibt Methode aus eine Basisklasse oder Interface
    // @Valid&@RequestBody überprüfen die übergebenen Daten. Sind die nicht korrekt, wird ein "400 Bad Request" zurück gegeben, Methode wird nicht ausgeführt

    /*
    @Override
    public ResponseEntity<AnalysisResult> outlierdetectionAnalyzeorderPost(@Valid @RequestBody OutlierdetectionAnalyzeorderBody body) {
        AnalysisResult result = new AnalysisResult();
        if (body.getOrderRequest() != null && body.getOrderRequest().getItems() != null) {
            int totalItems = body.getOrderRequest().getItems().size();
            result.setTotalItems(totalItems);
            result.setItemsDetails(body.getOrderRequest().getItems());
        } else {
            result.setTotalItems(0);
            result.setItemsDetails(null);
        }
        return ResponseEntity.ok(result);
    }

     */

    @Override
    @PostMapping("/analyzeorder")
    public ResponseEntity<AnalysisResult> outlierdetectionAnalyzeorderPost(@Valid @RequestBody OutlierdetectionAnalyzeorderBody body) {
        if (body.getOrderRequest() == null) {
            // Erstellt einer eigenen Fehlerantwort, da der Rückgabetyp AnalysisResult sein muss.
            AnalysisResult errorResult = new AnalysisResult();
            errorResult.setReasonsCode(Collections.singletonList("OrderRequest is required and must not be null."));
            return ResponseEntity.badRequest().body(errorResult);
        }
        AnalysisResult result = new AnalysisResult();
        result.setCustomerId(body.getOrderRequest().getCustomerId());
        result.setOrderId(body.getOrderRequest().getOrderId());
        result.setOutlierHistoryIncluded(body.getOutlierHistory() != null);

        if (body.getOrderRequest() != null && body.getOrderRequest().getItems() != null) {
            int totalItems = body.getOrderRequest().getItems().size();
            result.setTotalItems(totalItems);
            result.setItemsDetails(body.getOrderRequest().getItems());
            result.setOutlierPercentage(0); // Logik folgt bei positiver Entscheidung
            result.setIsOutlier(true); // Logik folgt bei positiver Entscheidung
                /*if(body.getOrderRequest().getMinOutlierPercentage() <= result.getOutlierPercentage()) {
                    result.setIsOutlier(true);
                } else {
                    result.setIsOutlier(false);
                }*/
            result.setReasonsCode(new ArrayList<>()); // Logik folgt bei positiver Entscheidung
            result.setTimestamp(body.getOrderRequest().getOrderDate());
        } else {
            result.setTotalItems(0);
            result.setItemsDetails(new ArrayList<>());
            result.setIsOutlier(false);
            result.setOutlierPercentage(0);
            result.setReasonsCode(new ArrayList<>());
            result.setTimestamp(body.getOrderRequest().getOrderDate());
        }

        return ResponseEntity.ok(result);
    }


    private boolean determineIfOutlier(OutlierdetectionAnalyzeorderBody body) {
        // Wird bei positiver Entscheidung ergänzt
        return true; // Für die Tests wird true zurückgegeben
    }


}
