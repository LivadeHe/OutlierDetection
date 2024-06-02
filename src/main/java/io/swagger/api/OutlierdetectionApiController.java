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
import java.time.OffsetDateTime;
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

    @Override
    @PostMapping("/analyzeorder")
    public ResponseEntity<AnalysisResult> outlierdetectionAnalyzeorderPost(@Valid @RequestBody OutlierdetectionAnalyzeorderBody body) {

        // Überprüfen, ob der OrderRequest vorhanden ist
        if (body.getOrderRequest() == null) {
            AnalysisResult errorResult = new AnalysisResult();
            errorResult.setReasonsCode(Collections.singletonList("OrderRequest is required and must not be null."));
            return ResponseEntity.badRequest().body(errorResult);
        }

        // Simulierter Fehler für Testzwecke (wenn die Kunden-ID "test500" ist)
        if ("test500".equals(body.getOrderRequest().getCustomerId())) {
            throw new RuntimeException("Simulierter Internal Server Error");
        }

        // Logik zur Verarbeitung der Analyse
        return ResponseEntity.ok(processAnalysis(body));
    }

    //Methode zur Verarbeitung der Analyse
    private AnalysisResult processAnalysis(OutlierdetectionAnalyzeorderBody body) {
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
            result.setTimestamp(OffsetDateTime.now());
            ;
        } else {
            result.setTotalItems(0);
            result.setItemsDetails(new ArrayList<>());
            result.setIsOutlier(false);
            result.setOutlierPercentage(0);
            result.setReasonsCode(new ArrayList<>());
            result.setTimestamp(OffsetDateTime.now());
        }

        return result;
    }

    private boolean determineIfOutlier(OutlierdetectionAnalyzeorderBody body) {
        // Wird bei positiver Entscheidung ergänzt
        return true; // Für die Tests wird true zurückgegeben
    }


}
