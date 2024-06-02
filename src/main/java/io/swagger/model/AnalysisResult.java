package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.model.OrderItem;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AnalysisResult
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-05-14T12:14:50.777488516Z[GMT]")


public class AnalysisResult {
    @JsonProperty("customer_id")
    @NotNull(message = "Customer ID is required")
    private String customerId = null;

    @JsonProperty("order_id")
    @NotNull(message = "Order ID is required")
    private String orderId = null;

    @JsonProperty("is_outlier")
    private Boolean isOutlier = null;

    @JsonProperty("outlier_percentage")
    @Min(value = 0, message = "Outlier percentage must be 0 or positive")
    @NotNull(message = "outlier_percentage is required")
    private Integer outlierPercentage = null;

    @JsonProperty("reasons_code")
    @Valid
    private List<Object> reasonsCode = null;

    @JsonProperty("items_details")
    @Valid
    @NotEmpty(message = "Items details cannot be empty")
    private List<OrderItem> itemsDetails = null;

    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    @NotNull(message = "Timestamp is required")
    private OffsetDateTime timestamp = null;

    // Zusätzlich - für das Testing hinzugefügt
    @JsonProperty("totalItems")
    private Integer totalItems;

    @JsonProperty("outlierHistoryIncluded")
    private Boolean outlierHistoryIncluded = false;


    public AnalysisResult customerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    /**
     * The unique customer ID
     *
     * @return customerId
     **/
    @Schema(description = "The unique customer ID")

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public AnalysisResult orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    // Züsätzlich - Für das Testen hinzugefügt
    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }


    public Boolean getOutlierHistoryIncluded() {
        return outlierHistoryIncluded;
    }

    public void setOutlierHistoryIncluded(Boolean outlierHistoryIncluded) {
        this.outlierHistoryIncluded = outlierHistoryIncluded;
    }

    /**
     * The unique order ID
     *
     * @return orderId
     **/
    @Schema(description = "The unique order ID")

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public AnalysisResult isOutlier(Boolean isOutlier) {
        this.isOutlier = isOutlier;
        return this;
    }

    /**
     * Indicates if the order is classified as an outlier
     *
     * @return isOutlier
     **/
    @Schema(description = "Indicates if the order is classified as an outlier")

    public Boolean isIsOutlier() {
        return isOutlier;
    }

    public void setIsOutlier(Boolean isOutlier) {
        this.isOutlier = isOutlier;
    }

    public AnalysisResult outlierPercentage(Integer outlierPercentage) {
        this.outlierPercentage = outlierPercentage;
        return this;
    }

    /**
     * The percentage of the order classified as an outlier
     *
     * @return outlierPercentage
     **/
    @Schema(description = "The percentage of the order classified as an outlier")

    public Integer getOutlierPercentage() {
        return outlierPercentage;
    }

    public void setOutlierPercentage(Integer outlierPercentage) {
        this.outlierPercentage = outlierPercentage;
    }

    public AnalysisResult reasonsCode(List<Object> reasonsCode) {
        this.reasonsCode = reasonsCode;
        return this;
    }

    public AnalysisResult addReasonsCodeItem(Object reasonsCodeItem) {
        if (this.reasonsCode == null) {
            this.reasonsCode = new ArrayList<Object>();
        }
        this.reasonsCode.add(reasonsCodeItem);
        return this;
    }

    /**
     * List of reasons why the order was classified as an outlier
     *
     * @return reasonsCode
     **/
    @Schema(example = "1; Unusually high order quantity, 2; Rare combination of product options...", description = "List of reasons why the order was classified as an outlier")

    public List<Object> getReasonsCode() {
        return reasonsCode;
    }

    public void setReasonsCode(List<Object> reasonsCode) {
        this.reasonsCode = reasonsCode;
    }

    public AnalysisResult itemsDetails(List<OrderItem> itemsDetails) {
        this.itemsDetails = itemsDetails;
        return this;
    }

    public AnalysisResult addItemsDetailsItem(OrderItem itemsDetailsItem) {
        if (this.itemsDetails == null) {
            this.itemsDetails = new ArrayList<OrderItem>();
        }
        this.itemsDetails.add(itemsDetailsItem);
        return this;
    }

    /**
     * Detailed list of items that triggered the outlier detection
     *
     * @return itemsDetails
     **/
    @Schema(description = "Detailed list of items that triggered the outlier detection")
    @Valid
    public List<OrderItem> getItemsDetails() {
        return itemsDetails;
    }

    public void setItemsDetails(List<OrderItem> itemsDetails) {
        this.itemsDetails = itemsDetails;
    }


    public AnalysisResult timestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }


    /**
     * Get timestamp
     *
     * @return timestamp
     **/
    @Schema(example = "2024-04-18T12:51:17.318Z", description = "")

    @Valid
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AnalysisResult analysisResult = (AnalysisResult) o;
        return Objects.equals(this.customerId, analysisResult.customerId) &&
                Objects.equals(this.orderId, analysisResult.orderId) &&
                Objects.equals(this.isOutlier, analysisResult.isOutlier) &&
                Objects.equals(this.outlierPercentage, analysisResult.outlierPercentage) &&
                Objects.equals(this.reasonsCode, analysisResult.reasonsCode) &&
                Objects.equals(this.itemsDetails, analysisResult.itemsDetails) &&
                Objects.equals(this.timestamp, analysisResult.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, orderId, isOutlier, outlierPercentage, reasonsCode, itemsDetails, timestamp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AnalysisResult {\n");

        sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
        sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
        sb.append("    isOutlier: ").append(toIndentedString(isOutlier)).append("\n");
        sb.append("    outlierPercentage: ").append(toIndentedString(outlierPercentage)).append("\n");
        sb.append("    reasonsCode: ").append(toIndentedString(reasonsCode)).append("\n");
        sb.append("    totalItems: ").append(toIndentedString(totalItems)).append("\n");
        sb.append("    itemsDetails: ").append(toIndentedString(itemsDetails)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public void addItemDetail(OrderItem item) {
        if (this.itemsDetails == null) {
            this.itemsDetails = new ArrayList<>();
        }
        this.itemsDetails.add(item);
    }


}